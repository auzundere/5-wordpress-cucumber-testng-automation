Feature: Add a comment to blog post


Background: 
Given I login to the blog

 
  Scenario: As a blog reader I want to add blog comment to blog post
	Then I click blog post in main page
	Then I add "Good Article, Thank you" comment on blog page
	Then I fill Name, Email and Website boxes
	Then I click post comment button
	Then Verify comment added successfully