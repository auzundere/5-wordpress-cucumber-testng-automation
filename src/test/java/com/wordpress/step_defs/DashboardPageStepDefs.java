package com.wordpress.step_defs;

import org.testng.asserts.SoftAssert;

import com.wordpress.pages.DashboardPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DashboardPageStepDefs {
	DashboardPage dashboard = new DashboardPage();

	@Then("^I verify Dashboard text , At a Glance, Quick Draft, Activity, WordPress Events and News\\.$")
	public void i_verify_Dashboard_text_At_a_Glance_Quick_Draft_Activity_WordPress_Events_and_News() {
		
		for (int i = 0; i < dashboard.headersOfDashboard.size(); i++) {
			dashboard.isDisplayedElement(dashboard.headersOfDashboard.get(i));
		}
		dashboard.isDisplayedElement(dashboard.dashboardText).assertAll();
	}

	@Then("^I verify left menu items are displayed$")
	public void i_verify_left_menu_items_are_displayed() {

	}

	@Then("^I verify all the links on W menu$")
	public void i_verify_all_the_links_on_W_menu() {

	}

	@Then("^I verify Cybertek's Blog menu items$")
	public void i_verify_Cybertek_s_Blog_menu_items() {

	}

	@When("^I click comments link and goes to comments page$")
	public void i_click_comments_link_and_goes_to_comments_page() {

	}

	@Then("^I verify Howdy Menu items$")
	public void i_verify_Howdy_Menu_items() {

	}

	@Then("^I verify all the link on \\+ New menu$")
	public void i_verify_all_the_link_on_New_menu() {

	}
}
