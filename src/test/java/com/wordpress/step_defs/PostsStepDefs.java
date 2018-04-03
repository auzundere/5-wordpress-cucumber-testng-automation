package com.wordpress.step_defs;

import java.io.FileInputStream;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.wordpress.pages.DashboardPage;
import com.wordpress.pages.PostsPage;

import cucumber.api.java.en.When;

public class PostsStepDefs {
	String filePath = "./src/test/resources/test_files/postList.xlsx";
	DashboardPage dashboard = new DashboardPage();
	PostsPage postsPage = new PostsPage();
	
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
		int rowNumber = rand.nextInt(rowsCount-1)+1;
		
	  //Click Posts on left menu
	  dashboard.first10ElementsofLeftMenu.get(1).click();
	  //click Add New button
	  postsPage.addNewButton.click();
	  //enter post title getting from Excel (column 0)
	  postsPage.post_title.sendKeys(ws.getRow(rowNumber).getCell(0).toString());
	  //enter post content getting from Excel (column 1)
	  postsPage.bodyOfPost.sendKeys(ws.getRow(rowNumber).getCell(1).toString());
	  //Select a category from the list
	  postsPage.categoryAll.get(rand.nextInt(postsPage.categoryAll.size())).click();
	  //click the set Feature image link
	  try {
		 postsPage.setFeatureImageLink.click(); 
	  }catch(Exception e) {
		  postsPage.featureImageTabTitle.click();
		  postsPage.setFeatureImageLink.click(); 
	  }
	  //click Media Library Tab
	  postsPage.mediaLibraryTab.click();
	  //choose rondomly an image of the library
	  postsPage.allPicturesMediaLibrary.get(rand.nextInt(postsPage.allPicturesMediaLibrary.size())).click();
	  //click set Feature Image button
	  postsPage.setFeatureImageButton.click();
	  //click Publidh button using Javascript Executer to publish the post...
	  postsPage.chooseBlindspot(postsPage.publishButton);
	  //postsPage.publishButton.click();
	  postsPage.postLink.click();
	}
	
	
}
