@top_menu_1
Feature: Cybertek Blog top menu options

  Background: 
    Given I login to the blog

  Scenario: Edit Ceybertek Blog Profile
    When I click Howdy Tesla
    Then I verify text "Profile" is displayed
    Then I set Admin Color Scheme "Blue"
    Then I enter info 
    Then I verify text "Profile updated." is displayed
    Then I will logout
    
    
   Scenario: Search by given text
   When I click on Cybertek Blog menu
   Then I verify text "Ceybertek Blog" is displayed
   Then I search for "Istanbul" 
   Then I verify text "SEARCH RESULTS" is displayed
   Then I will logout
   
   