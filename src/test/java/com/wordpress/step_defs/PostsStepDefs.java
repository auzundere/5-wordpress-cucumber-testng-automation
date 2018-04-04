package com.wordpress.step_defs;

import java.io.FileInputStream;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.wordpress.pages.DashboardPage;
import com.wordpress.pages.PostsPage;
import com.wordpress.utilities.BrowserUtils;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PostsStepDefs {
	String filePath = "./src/test/resources/test_files/postList.xlsx";
	DashboardPage dashboard = new DashboardPage();
	PostsPage postsPage = new PostsPage();
	SoftAssert soft = new SoftAssert();
	String expectedTitle;
	String expectedBody;
	String expectedCategory;

	@When("^I create new post$")
	public void i_create_new_post() throws Exception {
		// Open File and convert to a stream of data
		FileInputStream inStream = new FileInputStream(filePath);
		// take the stream of data and use it as Workbook
		Workbook wb = WorkbookFactory.create(inStream);
		// get the first worksheet from the workbook
		Sheet ws = wb.getSheetAt(0);
		// Find out how many rows in this sheet
		int rowsCount = ws.getPhysicalNumberOfRows();
		Random rand = new Random();
		int rowNumber = rand.nextInt(rowsCount) + 1;

		// Click Posts on left menu
		dashboard.first10ElementsofLeftMenu.get(1).click();
		// click Add New button
		postsPage.addNewButton.click();
		// enter post title getting from Excel (column 0)
		expectedTitle = ws.getRow(rowNumber).getCell(0).toString();
		postsPage.post_title.sendKeys(expectedTitle);
		// enter post content getting from Excel (column 1)
		expectedBody = ws.getRow(rowNumber).getCell(1).toString();
		postsPage.bodyOfPost.sendKeys(expectedBody);
		// Select a category from the list
		int index = rand.nextInt(postsPage.categoryAll.size());
		expectedCategory = postsPage.categoryAlllabels.get(index).getText().trim();
		postsPage.categoryAll.get(index).click();
		System.out.println(expectedCategory);
		// click the set Feature image link
		try {
			postsPage.setFeatureImageLink.click();
		} catch (Exception e) {
			postsPage.featureImageTabTitle.click();
			postsPage.setFeatureImageLink.click();
		}
		// click Media Library Tab
		postsPage.mediaLibraryTab.click();
		// choose rondomly an image of the library
		postsPage.allPicturesMediaLibrary.get(rand.nextInt(postsPage.allPicturesMediaLibrary.size())).click();
		// click set Feature Image button
		postsPage.setFeatureImageButton.click();
		// click Publish button using Javascript Executer to publish the post...
		postsPage.chooseBlindspot(postsPage.publishButton);

	}

	@Then("^verify the post has been created correctly$")
	public void verify_the_post_has_been_created_correctly() {
		// postsPage.publishButton.click();
		postsPage.postLink.click();
		BrowserUtils.waitFor(1);
		// verify the title of the new post
		soft.assertEquals(postsPage.titleOfCreatedPost.getText(), expectedTitle.toUpperCase(),
				"the post's title was not the same with the expected title: " + expectedTitle);
		// verify the body of the new post
		soft.assertEquals(postsPage.contentOfCreatedPost.getText(), expectedBody,
				"the post's body was not the same with the expected body: " + expectedBody);
		// verify the category of the new post
		soft.assertEquals(postsPage.categoryOfCreatedPost.getText(), expectedCategory,
				"the post's category was not the same with the expected category: " + expectedCategory);
		soft.assertAll();
	}

}
