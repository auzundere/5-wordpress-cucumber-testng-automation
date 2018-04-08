package com.wordpress.step_defs;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.wordpress.pages.DashboardPage;
import com.wordpress.pages.PagePage;
import com.wordpress.pages.PagePageS;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import com.wordpress.utilities.BrowserUtils;
import com.wordpress.utilities.Driver;

public class PagesStepDefs {

	SoftAssert softAssert = new SoftAssert();
	DashboardPage dashboard = new DashboardPage();
	PagePage ppage = new PagePage();
	PagePageS ppages = new PagePageS();
	String filePath = "./src/test/resources/test_files/pageList.xlsx";
	Workbook workbook;
	Sheet worksheet;
	FileInputStream inStream;
	FileOutputStream outSTream;
	JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

	// WebDriver driver;

	@When("^I create new page$")
	public void i_create_new_page() throws Exception {

		// --->>> INFO --->>>
		js.executeScript("alert('We are going to create new Page with Gallery of Images');");

		Alert alert = Driver.getDriver().switchTo().alert();
		BrowserUtils.waitFor(3);
		alert.accept();
		// --->>> --->>>

		dashboard.first10ElementsofLeftMenu.get(3).click();

		// click Add New button
		ppage.addNewButton.click();

	}

	@Then("^I check that Page \"([^\"]*)\" loaded correctly$")
	public void i_check_that_Page_loaded_correctly(String pageName) throws Exception {
		// title of the page = 'Add new Page'
		String title = ppage.titleAddNewPage.getText();
		softAssert.assertEquals(title.toLowerCase(), pageName.toLowerCase(), "Page not loaded");

		// --->>> INFO --->>>
		js.executeScript("alert('The buttons-name on this page are compared to the names list in Exsel file.');");
		Alert alert1 = Driver.getDriver().switchTo().alert();
		BrowserUtils.waitFor(4);
		alert1.accept();
		// --->>> --->>>

		// Get the names of button from the 1st row of file "pageList.xlsx"
		// Open file, convert to a stream of data, open Exsel Workbood and worksheet(0)
		inStream = new FileInputStream(filePath);
		workbook = WorkbookFactory.create(inStream);
		worksheet = workbook.getSheetAt(0);

		List<String> buttonsNames = new ArrayList<>();
		Row myRow = worksheet.getRow(1);
		for (int i = 1; i < myRow.getPhysicalNumberOfCells(); i++) {
			buttonsNames.add(myRow.getCell(i).getStringCellValue());
		}

		System.out.println("from Excel: " + buttonsNames);

		// Get the names of button from the Page
		ArrayList<String> buttonsNamesOnPage = new ArrayList<>();
		for (WebElement we : ppage.textFieldButtons) {
			buttonsNamesOnPage.add(we.getAttribute("value"));
		}

		System.out.println("from Page: " + buttonsNamesOnPage.toString());

		// verify that 9 buttons over the text field are displayed
		softAssert.assertTrue(buttonsNames.containsAll(buttonsNamesOnPage),
				"problems with buttons above the text field");

		// verify that 3 tabs and button "AddMedia" is displayed
		softAssert.assertTrue(ppage.tabPageBuilder.isDisplayed(), "");
		softAssert.assertTrue(ppage.tabText.isDisplayed(), "");

		softAssert.assertTrue(ppage.tabVisual.isDisplayed(), "tabs is not displayed");
		softAssert.assertTrue(ppage.buttonAddMedia.isDisplayed(), "buttons is not displayed");

		ppage.tabPageBuilder.click();
	}

	@Then("^I create Page with ImageGallery$")
	public void i_create_Page_with_ImageGallery() throws Exception {
		System.out.println("size" + ppage.buttonsWidjet.size());
		// button names on the Page
		ArrayList<String> buttons_names_onPage = new ArrayList<>();

		for (WebElement we : ppage.buttonsWidjet) {
			buttons_names_onPage.add(we.getText().toString());
		}

		// button names from Excel
		ArrayList<String> buttonsNameWidjet = new ArrayList<>();
		Row myRow = worksheet.getRow(2);
		for (int i = 1; i < myRow.getPhysicalNumberOfCells(); i++) {
			buttonsNameWidjet.add(myRow.getCell(i).getStringCellValue());
		}

		// close Excel file
		workbook.close();
		inStream.close();

		// verify that all buttons inWidjet are displayed
		softAssert.assertTrue(buttonsNameWidjet.containsAll(buttonsNameWidjet), "*** widjet buttons failed");

		System.out.println(buttons_names_onPage);
		// create new row with one widjet-container for the new Page
		ppage.buttonsWidjet.get(1).click();
		ppage.numOfRowsWidget.clear();
		ppage.numOfRowsWidget.sendKeys("1");

		ppage.insert.click();

		// choose the widget "image GAllery:"
		ppage.buttonsWidjet.get(0).click();

		// verify that title = "Add new Widjet"

		// get the names of all widjets
		List<String> widjetNames = new ArrayList<>();
		for (WebElement we : ppage.widjets) {
			widjetNames.add(we.getText());
			// System.out.println(we.getText());
		}
		System.out.println(ppage.widjets.size());

		// --->>> INFO --->>>
		js.executeScript("alert('Names of Widjets on this Page will be written in new created Exsel file.');");

		Alert alert1 = Driver.getDriver().switchTo().alert();
		BrowserUtils.waitFor(4);
		alert1.accept();
		// --->>> --->>>

		// Write the names of Widget to new Excel file "widjetNames.xlsx"
		// check the "./src/test/resources/test_files/widjetNames.xlsx"
		// if file with name widjetNames.xlsx is in this directory --> delete this file

		try {

			File file = new File("./src/test/resources/test_files/widjetNames.xlsx");
			if (file.delete()) {
				System.out.println(file.getName() + " is deleted!");
			} else {
				System.out.println("No file 'widjetNames.xlsx' in directory ");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// write widget names to Excel file "widjetNames.xlsx"
		XSSFWorkbook workbookNew = new XSSFWorkbook();
		XSSFSheet sheet = workbookNew.createSheet("widjet names");

		for (int i = 0; i < widjetNames.size(); i++) {
			// create new rows
			Row row = sheet.createRow(i);
			// create new cell
			Cell cell = row.createCell(0);
			cell.setCellValue(widjetNames.get(i));
		}

		try {
			// FileOutputStream out = new FileOutputStream(new
			// File("./src/test/resources/test_files/widjetNames.xlsx"));
			FileOutputStream out = new FileOutputStream(
					new File(".\\src\\test\\resources\\test_files\\widjetNames.xlsx"));
			workbookNew.write(out);
			out.close();
			System.out.println("New file 'widjetNames.xlsx' written successfully on disk.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		workbookNew.close();

		// choose Gallery widjet
		for (WebElement we : ppage.widjets) {
			if (we.getText().equals("Gallery")) {
				we.click();
				break;
			}
		}

		// Put Images to the Gallery
		// Click Edin in Widjet menu
		// ppage.links_editWidjet.get(1).click();

		Actions actions = new Actions(Driver.getDriver());
		actions.moveToElement(ppage.container_Widjet);
		actions.contextClick(ppage.container_Widjet).build().perform(); /* this will perform right click */
		Thread.sleep(1000);
		ppage.edit_Widjet.click();

		Thread.sleep(1000);
		ppage.addImageGallery.click();

		// verify that title is "Create Gallery"
		softAssert.assertEquals(ppage.title_CreateGAllery.getText(), "Create Gallery");
		Thread.sleep(2000);
		ppage.input_SearchMedia.sendKeys("Sophia");

		Thread.sleep(3000);
		// choose the images with name "Sophia*" except "Sophia_main"
		for (WebElement we : ppage.imagesForGAllery) {

			if (we.getAttribute("aria-label").toString().equalsIgnoreCase("Sophia_Main"))
				continue;
			System.out.println(we.getAttribute("aria-label").toString());
			we.click();
		}
		// create a new gallery
		ppage.button_CreateNewGAllery.click();
		Thread.sleep(500);
		ppage.button_RecerseOrderGallery.click();
		Thread.sleep(500);
		ppage.button_InsertGallery.click();
		Thread.sleep(2000);

		ppage.button_DoneGallery.click();
		ppage.input_Title.sendKeys("Hagia Sophia");
		Thread.sleep(2000);

		// save current Window Handle
		String handle = Driver.getDriver().getWindowHandle();

		ppage.button_SaveDraft.click();
		ppage.button_PostPreview.click();

		Thread.sleep(3000);

		// Find the set of Window Handle
		Set<String> windowHandles = Driver.getDriver().getWindowHandles();

		String newWindowHandle = "";
		for (String string : windowHandles) {
			if (!string.equals(handle)) {
				newWindowHandle = string;
			}
		}
		Driver.getDriver().switchTo().window(newWindowHandle);

		actions.moveToElement(ppage.wwwTitle).click().sendKeys(Keys.PAGE_DOWN).perform();

		Thread.sleep(2000);

		Driver.getDriver().close();
		Driver.getDriver().switchTo().window(handle);

		ppage.button_SaveDraft.click();

	}

	@Then("^verify the Page has been created correctly$")
	public void verify_the_Page_has_been_created_correctly() {

		softAssert.assertAll();
	}
	//////////////// -----------------EDIT THE PAGE

	@When("^I search the page \"([^\"]*)\"$")
	public void i_search_the_page(String pageName) {

		dashboard.first10ElementsofLeftMenu.get(3).click();

		// search the page "Hagia Sophiya"
		ppages.input_searchPages.sendKeys("Hagia");
		ppages.input_searchSubmit.click();

		BrowserUtils.waitForPageToLoad(2);
		// create array of search results
		System.out.println("size: " + ppages.searchResults.size());
		List<WebElement> searchPages = new ArrayList<>();
		int i = -1;
		for (WebElement we : ppages.searchResults) {
			i++;
			if (we.getText().equals(pageName)) {

				ppages.checkBoxes.get(i).click();
				// we.click();
				//break;
			}
		}
		System.out.println("i= " + i);

		// select Page: click the check-box
		// ppages.checkBoxes.get(i).click();

	}

	@Then("^I verify that page \"([^\"]*)\" is found$")
	public void i_verify_that_page_is_found(String pageName) {

		// --->>> INFO --->>>
		js.executeScript("alert('This script checks the EDIT functionality for Page');");
		Alert alert1 = Driver.getDriver().switchTo().alert();
		BrowserUtils.waitFor(4);
		alert1.accept();
		// --->>> --->>>
		// select action: Edit page
		Select selectAction = new Select(ppages.selectAction);

		selectAction.selectByVisibleText("Edit");
		ppages.button_Apply.click();

	}

	@Then("^I edit \"([^\"]*)\"$")
	public void i_edit(String arg1) {
		Select selectComment = new Select(ppages.selectComment);
		selectComment.selectByVisibleText("Allow");

		Select selectStatus = new Select(ppages.selectStatus);
		selectStatus.selectByVisibleText("Published");

		ppages.button_Update.click();
	}

	@Then("^I verify that page \"([^\"]*)\" is changed$")
	public void i_verify_that_page_is_changed(String pageName) {

		System.out.println("size: " + ppages.searchResults.size());
		List<WebElement> searchPages = new ArrayList<>();
		int i = -1;
		for (WebElement we : ppages.searchResults) {
			i++;
			if (we.getText().equals(pageName)) {
				// we.click();
				//break;
			}
		}
		System.out.println("i= " + i);

		String statusFull = ppages.statuses.get(i).getText();
		System.out.println("statusFull: *" + statusFull + "*");
		Assert.assertTrue(statusFull.contains("Published"), "*Status is not Piblished*");

		// --->>> INFO --->>>
		js.executeScript("alert('Created Page was edited.');");
		Alert alert2 = Driver.getDriver().switchTo().alert();
		BrowserUtils.waitFor(4);
		alert2.accept();
		// --->>> --->>>

	}

	@Then("^I delete the page \"([^\"]*)\"$")
	public void i_delete_the_page(String pageName) {
		// select action: Edit page

		// --->>> INFO --->>>
		js.executeScript("alert('Check the DELETE Page functionality');");
		Alert alert1 = Driver.getDriver().switchTo().alert();
		BrowserUtils.waitFor(4);
		alert1.accept();
		// --->>> --->>>

		Select selectAction = new Select(ppages.selectAction);

		selectAction.selectByVisibleText("Move to Trash");
		ppages.button_Apply.click();
		BrowserUtils.waitFor(2);
	}

	@Then("^I verify that page \"([^\"]*)\" is deleted$")
	public void i_verify_that_page_is_deleted(String pageName) {
		// Check all page names on Pages page. Verify that Hadia Sophia Page is not in
		// the list
		boolean isHere = false;
		for (WebElement we : ppages.searchResults) {
			if (we.getText().equals(pageName)) {
				isHere = true;
			}
		}

		
		
		
		
		
		Assert.assertTrue((isHere == false), "page " + pageName + " still on the list of search reslt");
		// --->>> INFO --->>>
		js.executeScript("alert('Created Page was deleted.');");
		Alert alert2 = Driver.getDriver().switchTo().alert();
		BrowserUtils.waitFor(3);
		alert2.accept();
		// --->>> --->>>

	}

}
