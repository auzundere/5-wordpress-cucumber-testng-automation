Feature: Posts
  I want to use this template for my feature file

  Background: 
    Given I login to the blog

  @Posts
  Scenario: Create a new post
    When I create new post
   	Then verify the post has been created correctly
   	Then I will logout
   	
   	@Posts
   	Scenario: Delete posts
    When I delete a post
   	Then verify the post has been deleted
    Then I will logout