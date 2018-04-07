package com.wordpress.step_defs;

import static org.testng.Assert.assertEquals;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.wordpress.pages.DashboardPage;
import com.wordpress.pages.Media;
import com.wordpress.pages.PostsPage;
import com.wordpress.utilities.ConfigurationReader;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MediaStpeDefs {
	
	WebDriver driver; 
	Media media = new Media();
	PostsPage postsPage = new PostsPage();
	DashboardPage dashboard = new DashboardPage();
	String actual;
	
	@When("^I check Library menu$")
	public void i_check_Library_menu() throws InterruptedException, AWTException {
		// I click the Media
		media.media.click();
		//click swithListButton
		media.switchGridButton.click();
		//count all picture
		postsPage.allPicturesMediaLibrary.size();
		System.out.println(postsPage.allPicturesMediaLibrary.size());  
		//click Add New
		media.addNew.click();
		media.selectFilesButton.click();
		//upload
		String mediaToUpload = "/Users/handanmelis/Desktop/scd.png";
		media.uploadMedia(mediaToUpload);		
		// I click the Media
		media.media.click();
		Thread.sleep(1000);
		// click Bulk Select
		media.bulkSelectButton.click();
		//click first photo
		media.selectFirstPhotoForDelete.click();
		//click delete
		media.deleteSelectedButton.click();
		// accept popUp		
		media.acceptAlert();
		//count all picture
		postsPage.allPicturesMediaLibrary.size();
		System.out.println(postsPage.allPicturesMediaLibrary.size());
		
	}
	
	@Then("^verify the Library menu has been worked correctly$")
	public void verify_the_Library_menu_has_been_worked_correctly() {
		// verify Media Library
		actual = media.mediaLibraryVerify.getText();
		assertEquals(actual,"Media Library", "It is not correct!");
		//verify search box
		actual = media.searchBox.getText();
		assertEquals(actual, "", "It is not correct!");
		
	}
	
	@When("^I check the Media menu$")
	public void i_check_the_Media_menu() {
		//click Media
		media.media.click();
		//click switchButton again
	    media.switchListButton.click();
	    //click file button
	  	media.fileUpDownArrow.click();
	    //check total items on the page
		media.totalItems.getText();
		System.out.println(media.totalItems.getText());
		//click All Media Item and select "Unattached"
		Select allMediaItem = new Select(media.allMediaItemDropDown);
		allMediaItem.selectByVisibleText("Unattached"); 
		//click All Dates and select "April 2018"
		Select allDates = new Select(media.allDates);
		allDates.selectByVisibleText("April 2018");
		//click filter
		media.filterButton.click();
		//check again how many image on the page
		media.totalItems.getText();
		System.out.println(media.totalItems.getText());
	
		
	}

	@Then("^verify the Media menu has been worked correctly$")
	public void verify_the_has_been_worked_correctly() {
		// verify Media Library
		actual = media.mediaLibraryVerify.getText();
		assertEquals(actual, "Media Library", "It is not correct!");
		//verify total items on the page
		actual = media.totalItems.getText();
		Assert.assertTrue( true, media.totalItems.getText());              
		//verify All Media Item
        actual = media.helpButton.getText();
        assertEquals(actual, "Help", "This is not correct");
				
	    
	}
	
	
	} 


