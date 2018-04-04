Feature: Posts
  I want to use this template for my feature file

  Background: 
    Given I login to the blog

  @Posts
  Scenario: Create a new post
    When I create new post
   	Then verify the post has been created correctly
    #Then select all posted and change their "<category>" from current than the other category
    #Then verify all the posted is in  the "<category>".
    #Then I will logout

    #Examples: 
      #| category |
      #| General  |
