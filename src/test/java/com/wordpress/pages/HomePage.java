package com.wordpress.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wordpress.utilities.Driver;

public class HomePage {
private WebDriver driver;

	public HomePage() {
		this.driver=Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[.='Log in']")
	public WebElement loginLink;
	
	@FindBy(xpath="//input[@id='user_login']")
	public WebElement username;
	
	@FindBy(xpath="//input[@id='user_pass']")
	public WebElement password;
	
	@FindBy(xpath="//input[@id='wp-submit']")
	public WebElement loginButton;
}
