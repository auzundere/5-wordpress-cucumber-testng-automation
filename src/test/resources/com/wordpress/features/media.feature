@media
Feature: Media
  I want to use this template for my feature file

  Background: 
    Given I login to the blog

  Scenario: Verify Library menu functionality
    When I hover over the Media
    Then I click Library
    When I verify "Media Library" text should be displayed.
    And I click the first sort button.
    And I verify File text should be displayed.
    And I verify "Istanbul_M" text should be displayed.
    Then I verify img “Istanbul_M.png” should be displayed
    Then I will logout

  Scenario: Verify Add New menu functionality
    When I hover over the Media
    Then I click Add New
    And I verify "Upload New Media" text should be displayed.
    Then I veriyf "Drop files here" text should be displayed
    And I click the Selet File button
    And I upload img file.
    Then I click Edit
    And I click Update
    And I click Permalink
    Then The picture should be displayed at main page
    Then I click Edit Post
    And I click Delete Permanently
    And I click popUp ok button.
    Then I verify "Media Library" text should be displayed.
    Then I will logout
