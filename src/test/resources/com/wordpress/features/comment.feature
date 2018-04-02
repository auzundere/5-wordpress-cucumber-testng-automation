Feature: Add a comment to blog post


Background: 
Given I login to the blog

 
  Scenario: As a blog reader I want to add blog comment to blog post
	Then I click blog post in main page
	Then I add "Good Article, Thank you" comment on blog page
	Then I fill Name, Email and Website boxes
	Then I click post comment button
	Then Verify comment added successfully
	Then I will logout
	
	Scenario: I check the Bulk Actions at the commets page
	Then I click the checkbox
	Then I hover over on the bulk actions
	Then I click on the approve
	Then I click on the Apply
	Then Once I apply "1 comment approved" is displayed
	Then I will logout
	
	Scenario: I check All comment types
	Then I hover over on the All comment types
	Then I choose the comments option
	Then I click filter
	Then I verify the link thet is displayed
	Then I will logout
	
	
	