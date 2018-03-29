package com.wordpress.step_defs;

import org.testng.asserts.SoftAssert;

import com.wordpress.pages.CommentsPage;
import com.wordpress.pages.DashboardPage;
import com.wordpress.utilities.BrowserUtils;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DashboardPageStepDefs {
	DashboardPage dashboard = new DashboardPage();
	CommentsPage commentsPage = new CommentsPage();
	@Then("^I verify Dashboard text , At a Glance, Quick Draft, Activity, WordPress Events and News\\.$")
	public void i_verify_Dashboard_text_At_a_Glance_Quick_Draft_Activity_WordPress_Events_and_News() {
		for (int i = 0; i < dashboard.headersOfDashboard.size(); i++) {
			dashboard.isDisplayedElement(dashboard.headersOfDashboard.get(i));
		}
		dashboard.isDisplayedElement(dashboard.dashboardText).assertAll();
	}

	@Then("^I verify left menu items are displayed$")
	public void i_verify_left_menu_items_are_displayed() {
		for (int i = 0; i < dashboard.first10ElementsofLeftMenu.size(); i++) {
			dashboard.isDisplayedElement(dashboard.first10ElementsofLeftMenu.get(i));
		}
		dashboard.isDisplayedElement(dashboard.homeLink);
		dashboard.isDisplayedElement(dashboard.updateLink);
		dashboard.isDisplayedElement(dashboard.collapseMenuLink).assertAll();
	}

	@Then("^I verify all the links on W menu$")
	public void i_verify_all_the_links_on_W_menu() {
		dashboard.hoverOverToElement(dashboard.wMenu);
		dashboard.isDisplayedElement(dashboard.aboutWordpressLink);
		for (int i = 0; i < dashboard.last4ElementsOfWSubMenu.size(); i++) {
			dashboard.isDisplayedElement(dashboard.last4ElementsOfWSubMenu.get(i));
		}
		dashboard.isDisplayedElement(dashboard.wordpressDotOrgLink).assertAll();
	}

	@Then("^I verify Cyberteks Blog menu items$")
	public void i_verify_Cyberteks_Blog_menu_items() {
		dashboard.hoverOverToElement(dashboard.BlogLink);
		dashboard.isDisplayedElement(dashboard.visitSiteLink).assertAll();
	}

	@When("^I click comments link and goes to comments page$")
	public void i_click_comments_link_and_goes_to_comments_page() {
		dashboard.topCommentsLink.click();
		BrowserUtils.waitFor(2);
		commentsPage.isAt();
	}

	@Then("^I verify all the link on \\+ New menu$")
	public void i_verify_all_the_link_on_New_menu() {
		dashboard.hoverOverToElement(dashboard.plusNewLink);
		for (int i = 0; i < dashboard.plusNewMenuElements.size()-1; i++) {
			dashboard.isDisplayedElement(dashboard.plusNewMenuElements.get(i));
		}
		dashboard.isDisplayedElement(dashboard.plusNewMenuElements.get(
				dashboard.plusNewMenuElements.size()-1)).assertAll();
	}
	
	@Then("^I verify Howdy Menu items$")
	public void i_verify_Howdy_Menu_items() {
		dashboard.hoverOverToElement(dashboard.howdyMenuLink);
		for (int i = 0; i < dashboard.howdyMenuElements.size()-1; i++) {
			dashboard.isDisplayedElement(dashboard.howdyMenuElements.get(i));
		}
		dashboard.isDisplayedElement(dashboard.howdyMenuElements.get(
				dashboard.howdyMenuElements.size()-1)).assertAll();
		
	}
}
