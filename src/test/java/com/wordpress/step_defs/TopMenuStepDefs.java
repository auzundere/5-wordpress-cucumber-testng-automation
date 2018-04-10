package com.wordpress.step_defs;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Random;

import org.openqa.selenium.Keys;

import com.wordpress.pages.DashboardPage;
import com.wordpress.pages.TopMenuPage;
import com.wordpress.utilities.BrowserUtils;
import com.wordpress.utilities.Driver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TopMenuStepDefs {

	DashboardPage dashboard = new DashboardPage();
	TopMenuPage topmenupage = new TopMenuPage();
	String actual;

	@Then("^I verify title$")
	public void i_verify_title() {
		// verify title is Dashboard ‹ Cybertek's Blog! — WordPress
		assertTrue(Driver.getDriver().getTitle().contains("Dashboard ‹ Cybertek's Blog! — WordPress"));
		// System.out.println("Cybertek Blog title is verified!!");
	}

	@When("^I click Howdy Tesla$")
	public void i_click_Howdy_Tesla() {
		dashboard.howdyMenuLink.click();
		// verify text "Profile" is displayed
		actual = topmenupage.textProfile.getText();
		assertEquals(actual, "Profile", "I am not at profile page!!");

	}

	@Then("^I edit profile$")
	public void i_edit_profile() {
		Random random = new Random();
		// check keyboard shortcuts
		topmenupage.comment_shortcuts.click();
		// check Toolbar
		topmenupage.toolbar.click();
		// set Admin Color Scheme
		topmenupage.admin_color_blue.click();

		// enter info
		// clear previous name, enter new name
		topmenupage.first_name.clear();
		topmenupage.first_name.sendKeys("Tesla");
		// clear previous last name,enter new last name
		topmenupage.last_name.clear();
		topmenupage.last_name.sendKeys("Team");
		// clear previous description, add new description
		topmenupage.description.clear();
		topmenupage.description
				.sendKeys("Tesla Team; dedicated, helpful, team player, open minded, optimistic SDET's ");
		topmenupage.submit.click();
	}

	@Then("^I verify profile is updated$")
	public void i_verify_profile_is_updated() {

		// verify text "Profile updated." is displayed
		actual = topmenupage.profileUpdated.getText();
		assertEquals(actual, "Profile updated.\n" + "Dismiss this notice.", "Profile is not updated!");
		// click users
		topmenupage.users.click();
		// Search name and click search Users
		topmenupage.userSearchInput.sendKeys("Tesla");
		topmenupage.searchUsersButton.click();
		// verify name, last name appear in users page
		actual = topmenupage.verifyName.getText();
		assertEquals(actual, "Tesla Team", "Name and last name did not match!!");

	}
	// Search by given text

	@When("^I click on Cybertek Blog menu$")
	public void i_click_on_Cybertek_Blog_menu() {
		// Click on Ceybertek's Blog
		dashboard.BlogLink.click();
		// verify header is Cybertek's Blog
		assertTrue(topmenupage.header.getText().equalsIgnoreCase("Cybertek's Blog!"));
	}

	@Then("^I search for \"([^\"]*)\"$")
	public void i_search_for(String arg1) {
		// click on seach button and enter word "Istanbul"
		BrowserUtils.waitFor(2);
		topmenupage.search.click();
		topmenupage.search.sendKeys("istanbul" + Keys.ENTER);
	}

	@Then("^I verify search is displayed$")
	public void i_verify_search_is_displayed() {
		// verify search result is displayed
		
		assertTrue(topmenupage.textSearchResult.getText().equalsIgnoreCase("Search Results"));
		// verify page title contains search term
		assertTrue(Driver.getDriver().getTitle().contains("istanbul"));
	}
}
