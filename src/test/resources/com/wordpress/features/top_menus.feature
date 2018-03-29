@top_menu
Feature: Cybertek Blog top menu options

  Background: 
    Given I logged to the blog

  Scenario: Verify W menu options displayed
    When I hover over the W menu
    Then follawing menu options should be visible for W:
      | About WordPress |
      | WordPress.org   |
      | Documentation   |
      | Support Forums  |
      | Feedback        |

  Scenario: Verify Ceybertek Blog menu options displayed
    When I hover over the Ceybertek Blog menu
    Then I Visit site menu optionshould be visible for Ceybertek

  Scenario: Verify +New menu options displayed
    When I hover over the +New menu
    Then following menu options should be visible for +New:
      | Post  |
      | Media |
      | Page  |
      | User  |

  Scenario: Verify Howdy, Tesla menu options displayed
    When I hover over the Howdy, Tesla menu
    Then following menu options should be visible for Howdy, Tesla:
      | Tesla           |
      | Edit My Profile |
      | Logout          |
