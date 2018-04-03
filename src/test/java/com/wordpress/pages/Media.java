package com.wordpress.pages;

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

	@FindBy(xpath="//a[@id='view-switch-list']")
	public WebElement switchButton;
	
	@FindBy(xpath="//th[@id='title']")
	public WebElement fileUpDownArrow;
	

	@FindBy(xpath="//img[@src='http://34.223.219.142:1022/wordpress/wp-content/uploads/2018/04/4c2a6be8-8c55-403f-b052-004c2ee251c1_neyzen.jpg-150x150.jpg']")
	public WebElement firstImg;
	
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
