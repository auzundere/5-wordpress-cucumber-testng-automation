package com.wordpress.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wordpress.utilities.Driver;

public class PagePageS {
	private WebDriver driver;
	public PagePageS() {
		this.driver=Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="post-search-input")
	public WebElement input_searchPages;
	
	@FindBy(id="search-submit")
	public WebElement input_searchSubmit;
	
	@FindBy(xpath="//a[@class='row-title']")
	public List<WebElement> searchResults;
	
	
	@FindBy(xpath="//input[@name='post[]']")
	public List<WebElement> checkBoxes;
	 
	@FindBy(id="bulk-action-selector-bottom")
	public WebElement selectAction;
	
	@FindBy(id="doaction2")
	public WebElement button_Apply;
	
	@FindBy(name="comment_status")
	public WebElement selectComment;
	
	@FindBy(name="_status")
	public WebElement selectStatus;
	
	@FindBy(id="bulk_edit")
	public WebElement button_Update;
	
	@FindBy(xpath="//td[@class='date column-date']")
	public List<WebElement> statuses;
	
}


