@media
Feature: Media
  I want to use this template for my feature file

  Background: 
    Given I login to the blog

  Scenario: Verify Library menu functionality
    When I check Library menu
    Then verify the "Library menu all option" should be displayed
    Then I will logout

  #When I hover over the Media
  #Then I click Library
  #When I verify "Media Library" text should be displayed.
  #And I click the first sort button.
  #And I verify File text should be displayed.
  #And I verify "Istanbul_M" text should be displayed.
  #Then I verify img “Istanbul_M.png” should be displayed
  #Then I will logout
  Scenario: Verify Add New menu functionality
    When I create new Add New
    Then verify the "Add New" has been created correctly
    Then verify all the "Add New" is in  the "<main page>".
    #  Then verify all the "Add New" is in  the "<Library>".
    Then I will logout

  #When I hover over the Media
  #Then I click Add New
  #And I verify "Upload New Media" text should be displayed.
  #Then I veriyf "Drop files here" text should be displayed
  #And I click the Selet File button
  #And I upload img file.
  #Then I click Edit
  #And I click Update
  #And I click Permalink
  #Then The picture should be displayed at main page
  #Then I click Edit Post
  #And I click Delete Permanently
  #And I click popUp ok button.
  #Then I verify "Media Library" text should be displayed.
  #Then I will logout
  
  Scenario: Verify Media Library menu button functionality
    When I hover over the Media
    When I verify “Media Library” text should be displayed.
    Then the options are displayed
      | All media items     |
      | All dates           |
      | Filter              |
      | Bulk Action         |
      | Apply               |
      | items “right arrow” |
    Then I click “All media items” select menu
    And I select “Unattached”.
    Then I click “All dates” select menu
    And I select “April 2018”
    Then I click “Filter”
    And I verify “numbers of items” items should be displayed
    Then I will logout
