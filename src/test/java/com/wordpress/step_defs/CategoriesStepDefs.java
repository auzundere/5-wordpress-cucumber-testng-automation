package com.wordpress.step_defs;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.wordpress.pages.CategoriesPage;
import com.wordpress.pages.DashboardPage;
import com.wordpress.pages.PostsPage;
import com.wordpress.utilities.BrowserUtils;
import com.wordpress.utilities.ConfigurationReader;
import com.wordpress.utilities.Driver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CategoriesStepDefs {
	CategoriesPage categoriesPage = new CategoriesPage();
	DashboardPage dashboard = new DashboardPage();
	PostsPage postsPage = new PostsPage();

	Random rand = new Random();
	String categoryName;
	String categorySlug;
	boolean creationSuccessfull;
	WebElement catName;
	WebElement catSlug;
	int numberOfItemsBeforeDeletion;
	int numberOfItemsAfterDeletion;
	int numberOfCategoriesToDelete;

	Actions actions = new Actions(Driver.getDriver());
	JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

	@When("^I create new categories$")
	public void i_create_new_categories() throws Exception {
		BrowserUtils.hover(categoriesPage.postsMenu);
		categoriesPage.categoriesMenu.click();
		categoriesPage.showSettingsLink.click();
		BrowserUtils.waitForInMilliSeconds(150);
		categoriesPage.edit_category_per_page.clear();
		categoriesPage.edit_category_per_page.sendKeys("999");
		categoriesPage.screenOptionsApply.click();
		BrowserUtils.waitForInMilliSeconds(400);
		// Open given Sheet in the given Excel File
		Sheet ws = BrowserUtils.openExcelWorksheet(ConfigurationReader.getProperty("excelcategoriesfile"), 0);
		// Find out how many rows in this sheet
		int rowsCount = ws.getPhysicalNumberOfRows();
		int rowNumber = rand.nextInt(rowsCount) + 1;
		int index = categoriesPage.categoryNames.size();
		categoryName = ws.getRow(rowNumber).getCell(0).toString().trim();
		categorySlug = ws.getRow(rowNumber).getCell(1).toString().trim();
		boolean notDublicate = true;
		for (int i = 0; i < index; i++) {
			catName = categoriesPage.categoryNames.get(i);
			catSlug = categoriesPage.categorySlugs.get(i);
			try {
				assertFalse(catName.getText().equals(categoryName) && catSlug.getText().equals(categorySlug));
			} catch (AssertionError e) {
				notDublicate = false;
				BrowserUtils.highlightElement(catName);
				BrowserUtils.highlightElement(catSlug);
				actions.moveToElement(catSlug).doubleClick().perform();
				BrowserUtils.waitFor(1);
				js.executeScript("alert('" + categoryName + " is already created before!');");
				Alert alert = Driver.getDriver().switchTo().alert();
				BrowserUtils.waitFor(5);
				alert.accept();
				break;
			}
		}
		if (notDublicate) {
			categoriesPage.categoryName.clear();
			categoriesPage.categoryName.sendKeys(categoryName);
			categoriesPage.categorySlug.clear();
			categoriesPage.categorySlug.sendKeys(categorySlug);
			categoriesPage.addNewCategoryButton.click();
			categoriesPage.refreshThePage();
			creationSuccessfull = true;
		}

	}

	@Then("^verify the categories have been created$")
	public void verify_the_categories_have_been_created() {
		if (creationSuccessfull) {
			List<String> cats = BrowserUtils.getElementsText(categoriesPage.categoryNames);
			Collections.sort(cats);
			assertTrue(cats.indexOf(categoryName) != -1);
		} else {
			System.out.println(categoryName + " has been created at another time in the past!");
		}

	}

	@When("^I delete categories$")
	public void i_delete_categories() {
		BrowserUtils.hover(categoriesPage.postsMenu);
		categoriesPage.categoriesMenu.click();
		categoriesPage.showSettingsLink.click();
		BrowserUtils.waitForInMilliSeconds(150);
		categoriesPage.edit_category_per_page.clear();
		categoriesPage.edit_category_per_page.sendKeys("999");
		categoriesPage.screenOptionsApply.click();
		BrowserUtils.waitForInMilliSeconds(400);
		// define how many categories will be deleted
		numberOfCategoriesToDelete = BrowserUtils.generateRandomNumber(0,
				categoriesPage.categoriesCheckboxes.size() - 1);
		numberOfItemsBeforeDeletion = Integer.parseInt(categoriesPage.itemCountText.getText().split(" ")[0]);
		postsPage.clickElements(categoriesPage.categoriesCheckboxes.size(), numberOfCategoriesToDelete,
				categoriesPage.categoriesCheckboxes, 0);
		Select bulkDropDownSelect = new Select(categoriesPage.bulkActionDropDown);
		bulkDropDownSelect.selectByVisibleText("Delete");
		categoriesPage.applyButton.click();
	}

	@Then("^verify the categories have been deleted$")
	public void verify_the_categories_have_been_deleted() {
		numberOfItemsAfterDeletion = Integer.parseInt(categoriesPage.itemCountText.getText().split(" ")[0]);
		assertEquals(numberOfItemsAfterDeletion, numberOfItemsBeforeDeletion-numberOfCategoriesToDelete);
	}
}
