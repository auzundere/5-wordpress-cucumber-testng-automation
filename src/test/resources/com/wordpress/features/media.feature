@media
Feature: Media
  I want to use this template for my feature file

  Background: 
    Given I login to the blog

  Scenario: Verify Library menu and Add New functionality
    When I check Library menu
    Then verify the Library menu has been worked correctly
    Then I will logout

  Scenario: Verify Media menu buttons functionality
    When I check the Media menu
    Then verify the Media menu has been worked correctly
    Then I will logout
    
       

    