@regression @top_menu_1
Feature: Cybertek Blog top menu options

  Background: 
    Given I login to the blog

  Scenario: Edit Ceybertek Blog Profile
    Then I verify title  
    When I click Howdy Tesla 
    Then I edit profile
    Then I verify profile is updated
    Then I will logout
   

   Scenario: Search by given text
   When I click on Cybertek Blog menu
   Then I search for "Istanbul" 
   Then I verify search is displayed
   Then I will logout
   
   