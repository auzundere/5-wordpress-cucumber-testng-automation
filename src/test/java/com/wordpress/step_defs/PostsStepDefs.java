package com.wordpress.step_defs;

import com.wordpress.pages.DashboardPage;

import cucumber.api.java.en.When;

public class PostsStepDefs {
	
	@When("^I create new post$")
	public void i_create_new_post() {
	  DashboardPage dashboard = new DashboardPage();
	  //Click Posts on left menu
	  dashboard.first10ElementsofLeftMenu.get(1).click();
	}
}
