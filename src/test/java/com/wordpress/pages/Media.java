package com.wordpress.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wordpress.utilities.Driver;

public class Media {
	private WebDriver driver;
	public Media() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver,	this);
	}
	

	@FindBy(xpath="//div[@class='wp-menu-image dashicons-before dashicons-admin-media']")    //li[@id='wp-admin-bar-new-media']
	public WebElement media;
	
    @FindBy(xpath="//a[@class='wp-first-item current']")
	public WebElement library;

	@FindBy(xpath="//a[@id='view-switch-grid']")
	public WebElement switchGridButton;
	
	@FindBy(xpath="//th[@id='title']")
	public WebElement fileUpDownArrow;
	
	@FindBy(xpath="//ul[@class='attachments ui-sortable ui-sortable-disabled']/li")
	public List<WebElement> allPicturesMediaLibrary;
	
	@FindBy(xpath="")
	public WebElement imgNameVerfy;
	
	@FindBy(xpath="")
	public WebElement q;
	
	@FindBy(xpath="")
	public WebElement qwer;
	
	
	
	@FindBy(id="")
	public WebElement hjkk;
	
	@FindBy(xpath="")
	public WebElement rt;
	
	
	@FindBy(linkText="")
	public WebElement asd;
	

}
