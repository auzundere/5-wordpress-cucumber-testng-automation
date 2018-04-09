package com.wordpress.step_defs;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.wordpress.pages.CommentsPage;

import cucumber.api.java.en.Then;

public class CommentsPageStepDefs {
		CommentsPage commentspage = new CommentsPage();
		
		@Then("^I click blog post in main page$")
		public void i_click_blog_post_in_main_page() {
			
		}

		@Then("^I add \"([^\"]*)\" comment on blog page$")
		public void i_add_comment_on_blog_page(String arg1) {
		   
		}

		@Then("^I fill Name, Email and Website boxes$")
		public void i_fill_Name_Email_and_Website_boxes() {
		    
		}

		@Then("^I click post comment button$")
		public void i_click_post_comment_button() {
		    
		}

		@Then("^Verify comment added successfully$")
		public void verify_comment_added_successfully() {
		   
		}

		@Then("^I click the checkbox$")
		public void i_click_the_checkbox() throws InterruptedException {
		   commentspage.commentsButton.click();
		   Thread.sleep(3000);
		   commentspage.checkbox.click();
		}

		@Then("^I hover over on the bulk actions$")
		public void i_hover_over_on_the_bulk_actions() {
			commentspage.hoverOverToElement(commentspage.bulkActions);
		}

		@Then("^I click on the approve$")
		public void i_click_on_the_approve() {
		    commentspage.bulkActions.click();
		    commentspage.approveButton.click();
		}

		@Then("^I click on the Apply$")
		public void i_click_on_the_Apply() {
			commentspage.apply.click();
		}

		@Then("^Once I apply \"([^\"]*)\" is displayed$")
		public void once_I_apply_is_displayed(String arg1) {
		    assertEquals(commentspage.OneCommentApproved.getText(),"1 comment approved");
		}

		

}
