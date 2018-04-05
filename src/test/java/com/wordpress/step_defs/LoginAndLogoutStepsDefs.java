package com.wordpress.step_defs;

import com.wordpress.pages.DashboardPage;
import com.wordpress.pages.HomePage;
import com.wordpress.utilities.BrowserUtils;
import com.wordpress.utilities.ConfigurationReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LoginAndLogoutStepsDefs {
	DashboardPage dashboard = new DashboardPage();
	HomePage homePage = new HomePage();
	@Given("^I login to the blog$")
	public void i_login_to_the_blog() {
	   
	    BrowserUtils.waitFor(1);
		homePage.username.clear();
	    homePage.username.sendKeys(ConfigurationReader.getProperty("username"));
	    homePage.password.sendKeys(ConfigurationReader.getProperty("password"));
	    homePage.loginButton.click();
	    dashboard.isAt("http://34.223.219.142:1022/wordpress/wp-admin/");
	    if(dashboard.collapseMenuLink.getText().isEmpty()) {
	    	dashboard.collapseMenuLink.click();
	    }
	}
	
	@Then("^I will logout$")
	public void i_will_logout() {
		BrowserUtils.waitFor(1);
		homePage.logout();
	   
	}
}
