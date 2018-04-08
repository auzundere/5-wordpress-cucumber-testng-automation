# this feature tests the next functionality:
# - create page
# - add elements[widgets] to page: add gallery of images
# - show the created page
# - search page
# - edit page [add parent page to created page]
# - delete page
Feature: Create new page with gallery of images

  Background: 
    Given I login to the blog

@Page
  Scenario: Create the new page
    When I create new page
    Then I check that Page "Add new page" loaded correctly
    Then I create Page with ImageGallery
    Then verify the Page has been created correctly
    Then I will logout

@Page
  Scenario: Edit Page
    When I search the page "Hagia Sophia"
    Then I verify that page "Hagia Sophia" is found
    Then I edit "Hagia Sophia"
    Then I verify that page "Hagia Sophia" is changed
    Then I will logout

@Page
  Scenario: Delete Page
    When I search the page "Hagia Sophia"
    Then I delete the page "Hagia Sophia"
    Then I verify that page "Hagia Sophia" is deleted
    Then I will logout