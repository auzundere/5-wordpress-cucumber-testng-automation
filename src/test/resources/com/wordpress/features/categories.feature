@regression @categories
Feature: Categories
  I want to use this template for my feature file

  Background: 
    Given I login to the blog

  
  Scenario: Create bulk categories
    When I create new categories
    Then verify the categories have been created
    Then I will logout

  Scenario: Delete categories
    When I delete categories
    Then verify the categories have been deleted
    Then I will logout
