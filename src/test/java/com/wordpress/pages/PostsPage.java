package com.wordpress.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.wordpress.utilities.Driver;

public class PostsPage {
	private WebDriver driver;
	public PostsPage() {
		this.driver=Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	
}
