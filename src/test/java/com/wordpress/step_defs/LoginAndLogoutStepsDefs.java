package com.wordpress.step_defs;

import com.wordpress.pages.HomePage;
import com.wordpress.utilities.BrowserUtils;
import com.wordpress.utilities.ConfigurationReader;

import cucumber.api.java.en.Given;

public class LoginAndLogoutStepsDefs {
	@Given("^I login to the blog$")
	public void i_login_to_the_blog() {
	    HomePage homePage = new HomePage();
	    homePage.loginLink.click();
	    BrowserUtils.waitFor(1);
	    homePage.username.sendKeys(ConfigurationReader.getProperty("username"));
	    homePage.password.sendKeys(ConfigurationReader.getProperty("password"));
	   homePage.loginButton.click();
	}
}
