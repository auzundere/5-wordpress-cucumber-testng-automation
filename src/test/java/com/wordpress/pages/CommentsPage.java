package com.wordpress.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wordpress.utilities.BrowserUtils;
import com.wordpress.utilities.Driver;

public class CommentsPage {
	private WebDriver driver;
	public CommentsPage() {
		this.driver=Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[@class='wp-heading-inline']")
	public WebElement commentsHeaderText;
	
	@FindBy(xpath="//li[@class='wp-not-current-submenu menu-top menu-icon-comments menu-top-last']//div[@class='wp-menu-name']")
	public WebElement commentsButton;
	
	@FindBy(xpath="//select[@id='bulk-action-selector-top']")
	public WebElement bulkActions;
	
	@FindBy(xpath="//input[@id='cb-select-29']")
	public WebElement checkbox;
	
	@FindBy(xpath="//input[@id='doaction']")
	public WebElement apply;
	
	@FindBy(xpath="//select[@name='action']/option[@value='approve']")
	public WebElement approveButton;
	
	@FindBy(xpath="//div[@id='moderated']/p")
	public WebElement OneCommentApproved;
	
	@FindBy(xpath="//select[@id='filter-by-comment-type']")
	public WebElement AllCommentTypes;
	
	@FindBy(xpath="//select[@id='filter-by-comment-type']/option[@value='comment']")
	public WebElement comment;
	
	@FindBy(id="post-query-submit")
	public WebElement filter;
	
	public void isAt() {
		String actualURL = driver.getCurrentUrl();
		String expectedURL= "http://34.223.219.142:1022/wordpress/wp-admin/edit-comments.php";
		assertEquals(actualURL,expectedURL,actualURL + " was not the same with the expected URL of " +expectedURL );
		
	}
	
	public void hoverOverToElement(WebElement element) {
		 Actions actions = new Actions(driver);
		 actions.moveToElement(element).perform();
		 BrowserUtils.waitFor(1);
	 }
	
}
