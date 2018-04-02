@top_menu_1
Feature: Cybertek Blog top menu options

  Background: 
    Given I login to the blog

  Scenario: Edit Ceybertek Blog Profile
    When I click Howdy Tesla
    Then I verify text "Profile" is displayed
    Then I check keyboard shortcuts
    Then I check Toolbar
    Then I set Admin Color Scheme "Blue"
    Then I enter name part 
    Then I enter contact part
    Then I entered about yourself
    Then I verify text "Profile updated." is displayed
    Then I will logout
    
    
   Scenario: Search by given text
   When I click on Cybertek Blog menu
   Then I verify text Ceybertek Blog is displayed
   Then I click on search button and I enter "Istanbul" 
   Then I click search
   Then I verify text "SEARCH RESULTS" and "Istanbul" are displayed
   Then I verify page title
   Then I will logout
   
   