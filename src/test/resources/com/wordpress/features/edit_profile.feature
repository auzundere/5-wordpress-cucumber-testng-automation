@profile
Feature: Editing Cybertek Blog Profile
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
    

 