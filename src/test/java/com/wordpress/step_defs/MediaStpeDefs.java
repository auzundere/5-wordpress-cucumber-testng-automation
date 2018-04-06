package com.wordpress.step_defs;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.wordpress.pages.DashboardPage;
import com.wordpress.pages.Media;
import com.wordpress.pages.PostsPage;
import com.wordpress.utilities.ConfigurationReader;

import cucumber.api.PendingException;
import cucumber.api.java.en.When;

public class MediaStpeDefs {
	
	WebDriver driver;
	Media media = new Media();
	PostsPage postsPage = new PostsPage();
	DashboardPage dashboard = new DashboardPage();
	SoftAssert soft = new SoftAssert();


	@When("^I check Library menu$")
	public void i_check_Library_menu() throws InterruptedException, AWTException {
		// I click the Media
		media.media.click();
		// I verify Media Library
		//media.mediaLibraryVerify.isDisplayed();
		//media.switchGridButton.click();
		//count all picture
		postsPage.allPicturesMediaLibrary.size();
		System.out.println(postsPage.allPicturesMediaLibrary.size());  
		//click swithListButton
		media.switchGridButton.click();
		//click file button
		//media.fileUpDownArrow.click();
		//click switchButton again
		//media.switchGridButton.click();
		//click Add New
		media.addNew.click();
		media.selectFilesButton.click();
		//upload
		String mediaToUpload = "/Users/handanmelis/Desktop/scd.png";
		media.uploadMedia(mediaToUpload);		
		
		
	}
	}
//	
//	
//	
//	
//	
//	
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//
//
//	
//
//
