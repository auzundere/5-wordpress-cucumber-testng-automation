package com.wordpress.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wordpress.utilities.Driver;

public class CommentsPage {
	private WebDriver driver;
	public CommentsPage() {
		this.driver=Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[@class='wp-heading-inline']")
	public WebElement commentsHeaderText;
	
	public void isAt() {
		String actualURL = driver.getCurrentUrl();
		String expectedURL= "http://34.223.219.142:1022/wordpress/wp-admin/edit-comments.php";
		assertEquals(actualURL,expectedURL,actualURL + " was not the same with the expected URL of " +expectedURL );
		
	}
	
}
