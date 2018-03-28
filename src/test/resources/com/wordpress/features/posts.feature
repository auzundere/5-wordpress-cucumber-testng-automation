
Feature: Posts
  I want to use this template for my feature file
Background: 
Given I login to the blog

  @posts
  Scenario: Title of your scenario
    When I open Posts using All Posts link, verify it goes to Posts page
    And Listed all posts
    And yet another action
    Then I validate the outcomes
    And check more outcomes

  @tag2
  Scenario Outline: Title of your scenario outline
    Given I want to write a step with <name>
    When I check for the <value> in step
    Then I verify the <status> in step

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
