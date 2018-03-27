package com.wordpress.step_defs;

import com.wordpress.pages.HomePage;
import com.wordpress.utilities.BrowserUtils;
import com.wordpress.utilities.ConfigurationReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LoginAndLogoutStepsDefs {
	 HomePage homePage = new HomePage();
	@Given("^I login to the blog$")
	public void i_login_to_the_blog() {
	   
	    homePage.loginLink.click();
	    BrowserUtils.waitFor(1);
	    homePage.username.sendKeys(ConfigurationReader.getProperty("username"));
	    homePage.password.sendKeys(ConfigurationReader.getProperty("password"));
	   homePage.loginButton.click();
	}
	
	@Then("^I will logout$")
	public void i_will_logout() {
		BrowserUtils.waitFor(10);
		homePage.logout();
	   
	}
}
