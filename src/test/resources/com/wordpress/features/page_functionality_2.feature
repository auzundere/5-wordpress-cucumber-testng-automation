# this feature tests the next functionality:
# - create page
# - add elements[widgets] to page: add image, add text
# - show the created page
# - search page
# - edit page [change the size of image, add title of image]
# - delete page
Feature: Create new page with image and text

  Background: 
    Given I login to the blog
@Page2
  Scenario: Create the new page menu
    When I create new page
    Then I check that Page "Add new page" loaded correctly
    Then I create Page with Image and text
    Then verify the Page with Image and text has been created correctly
    Then I will logout
    
@Page2
 Scenario: Delete Page
    When I search the page "Page with Image and Text"
    Then I delete the page "Page with Image and Text"
    Then I verify that page "Page with Image and Text" is deleted
    Then I will logout   
    
    