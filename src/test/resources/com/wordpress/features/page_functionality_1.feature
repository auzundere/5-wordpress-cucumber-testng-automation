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

  Scenario: Create the new page menu
    When I hover over the Pages menu
    Then following menu options should be visible for Pages:
      | All Pages |
      | Add New   |
    When I click on "Add New" menu option
    Then the Page "Add New Page" is displayed
    Then buttons are displayed on the "Add New"  Page
      | link |
      | ins  |
      | ul   |
      | ol   |
      | li   |
    Then tabs are displayed on the "Add New"  Page
      | Visual       |
      | Text         |
      | Page Builder |
    When I click on "Page Builder" tab
    Then buttons are displayed on the "Add New"  Page
      | Add Widjet  |
      | Add Row     |
      | Layouts     |
      | History     |
      | Live Editor |
      | Addons      |
      | Learn       |
    #  create new row for the Page
    When I click on "Add Row" button
    Then the Page "New row" is displayed
    And I put the "1" in  select element "Set row layout"
    When I click on "Insert" button
    Then the Page "Add new Page" is displayed
    
    #Check that only one row is displayed
    Then 1 elements  row are displayed
    #Check that row includes one widjet-container
    Then 1 widjet - containers in the row are displayed
    
    # put 'Gallery' widjet into the widjet-container of first row
    When I click on "1" widjet-container
    When I click on "Add Widget" button
    Then the Page "Add New Widjet" is displayed
    When I click on "Gallery" widjet
    Then the Page "Add New Page" is displayed
    Then the "Gallery" widget is displayed in 1 widjet-container
    # Add the images to the Gallery widjet
    When I hover over the "Gallery" widjet
    Then the options are displayed
      | Edit      |
      | Duplicate |
      | Delete    |
    When I click on "Edit" option in "Gallery" widjet
    Then the Page "Gallery" is displayed
    When I click on "Add Images" button
    Then the Page "Create Gallery" is displayed
    And I send text "Sophia" into the field "Search media items"
    Then 4 images are displayed on Page
    Then I click on all images exclude the first one
    When I click on "Create a new gallery" button
    When I click on "Insert gallery" button
    When I click on "Done" button
    Then the Page "Add New Page" is displayed
    #verify that Gallery widjet is displayed in the first row
    Then the widget "Gallery" is displayed in the "1" widjet-container
    # Give the name for the Page
    And I send text "Page with Gallery" into the field "title"
    # Publish the Page
    When I click on "Publish" button
    # Show the created Page
    When I click on "Preview Changes" button
    Then the new window with tab "Page with Gallery" is displayed
    When I return to Window with tab "Edit Page"
    And I close the window with tab "Page with Gallery"

  Scenario: Search Page, Edit Page
    When I hover over the Pages menu
    When I click on "All Pages" menu option
    Then the Page "Pages" is displayed
    Then the table with all pages is displayed
    # Search for Page
    And I send text "Page with Gallery" into the field "search pages"
    When I click on "Search pages" button
    Then Page "Page with Gallery" is displayed in a table of search results
    When I hover over the title of page "Page with Gallery"
    Then the options are displayed
      | Edit       |
      | Quick Edit |
      | Trash      |
      | View       |
    # Quick Edit - Set the parent page
    When I click on "Quick Edit" link for "Page with Gallery" page
    Then Text "Quick edit" is displayed
    And I put the "Hadia Sophia Charch" in  select element "Parent"
    When I click on "Update" button
    Then Page "Page with Gallery" is displayed in a table of search results

  Scenario: Delete Page
    When I hover over the Pages menu
    When I click on "All Pages" menu option
    Then the Page "Pages" is displayed
    Then the table with all pages is displayed
    # Search for Page
    And I send text "Page with Gallery" into the field "search pages"
    When I click on "Search pages" button
    Then Page "Page with Gallery" is displayed in a table of search results
    When I hover over the title of page "Page with Gallery"
    Then the options are displayed
      | Edit       |
      | Quick Edit |
      | Trash      |
      | View       |
    #Delete the created page
    When I click on "Trash" link for "Page with Gallery" page
    #check that page was deleted
    When I click on "All Pages" menu option
    Then the Page "Pages" is displayed
    Then the table with all pages is displayed
    # Search for deleted Page
    And I send text "Page with Gallery" into the field "search pages"
    When I click on "Search pages" button
    Then Page "Page with Gallery" is not displayed in a table of search results
