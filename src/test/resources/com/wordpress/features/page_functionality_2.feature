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
    And I put the "2" in  select element "Set row layout"
    And I put the "Hecton (0.732)" in  select element "columns with the ratio of"
    And I put the "Right to Left" in  select element "Set row layout"
    When I click on "Insert" button
    Then the Page "Add new Page" is displayed
    #Check that only one row is displayed
    Then 1 elements  row are displayed
    #Check that row includes two widjet-containers
    Then 2 widjet - containers in the row are displayed
    # put Image widjet into the first widjet-container of the first row
    When I click on "1" widjet-container
    When I click on "Add Widget" button
    Then the Page "Add New Widjet" is displayed
    When I click on "Image" widjet
    Then the Page "Add New Page" is displayed
    Then the "Gallery" widget is displayed in "1" widjet-container
    # Add the image to the Image widjet
    When I hover over the "Image" widjet
    Then the options are displayed
      | Edit      |
      | Duplicate |
      | Delete    |
    When I click on "Edit" option in "Image" widjet
    Then the Page "Image" is displayed
    When I click on "Add Images" button
    Then the Page "Create Gallery" is displayed
    And I send text "Sophia_3" into the field "Search media items"
    Then 1 images are displayed on Page
    Then I click on image
    When I click on "Add to Widjet" button
    When I click on "Done" button
    Then the Page "Add New Page" is displayed
    #verify that Image widjet is displayed in the first widjet-container of the first row
    Then the widget "Image" is displayed in the "1" widjet-container
    # put Text widjet into the second widjet-container of the first row
    When I click on "2" widjet-container
    When I click on "Add Widget" button
    Then the Page "Add New Widjet" is displayed
    When I click on "Text" widjet
    Then the Page "Add New Page" is displayed
    Then the "Text" widget is displayed in 2 widjet-container
    # Add the text to the Text widjet
    When I hover over the "Text" widjet
    Then the options are displayed
      | Edit      |
      | Duplicate |
      | Delete    |
    When I click on "Edit" option in "Text" widjet
    Then the Page "Text" is displayed
    And I send text "Text sample" into the field "Text Content Body"
    When I click on "Done" button
    Then the Page "Add New Page" is displayed
    #verify that Text widjet is displayed in the second widjet-container of the first row
    Then the widget "Text" is displayed in the "2" widjet-container
    # Give the name for the Page
    And I send text "Page with Text and Image" into the field "title"
    # Publish the Page
    When I click on "Publish" button
    # Show the created Page
    When I click on "Preview Changes" button
    Then the new window with tab "Page with Text and Image" is displayed
    When I return to Window with tab "Edit Page"
    And I close the window with tab "Page with Text and Image"

  Scenario: Search Page, Edit Page
    When I hover over the Pages menu
    When I click on "All Pages" menu option
    Then the Page "Pages" is displayed
    Then the table with all pages is displayed
    # Search for Page
    And I send text "Page with Text and Image" into the field "search pages"
    When I click on "Search pages" button
    Then Page "Page with Text and Image" is displayed in a table of search results
    When I hover over the title of page "Page with Text and Image"
    Then the options are displayed
      | Edit       |
      | Quick Edit |
      | Trash      |
      | View       |
    # Edit - Change the size of Image, add title to the Image
    When I click on "Edit" link for "Page with Text and Image" page
    Then the Page "Edit Page" is displayed
    When I hover over the "Image" widjet
    Then the options are displayed
      | Edit      |
      | Duplicate |
      | Delete    |
    When I click on "Edit" option in "Image" widjet
    Then the Page "Image" is displayed
    When I click on "Edit Image" button
    Then frame "Image Details" is displayed
    And I put the "Full size 531*312" in  select element "Size"
    When I click on "Update" button
    Then frame "Image" is displayed
    And I send text "Hagia Sophia" into the field "title"
    When I click on "Done" button
    Then the Page "Edin Page" is displayed
    When I click on "Done" button
    # Show the created Page
    When I click on "Preview Changes" button
    Then the new window with tab "Page with Text and Image" is displayed
    When I return to Window with tab "Edit Page"
    And I close the window with tab "Page with Text and Image"

  Scenario: Delete Page
    When I hover over the Pages menu
    When I click on "All Pages" menu option
    Then the Page "Pages" is displayed
    Then the table with all pages is displayed
    # Search for Page
    And I send text "Page with Text and Image" into the field "search pages"
    When I click on "Search pages" button
    Then Page "Page with Text and Image" is displayed in a table of search results
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
    And I send text "Page with Text and Image" into the field "search pages"
    When I click on "Search pages" button
    Then Page "Page with Text and Image" is not displayed in a table of search results
