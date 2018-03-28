Feature: Verifying Top and Left Menu Items and Dashboard Page
  

Background: 
Given I login to the blog

  @Dev
  Scenario: Verifying the Dashbord page and Left Menu Items are displayed
	Then I verify Dashboard text , At a Glance, Quick Draft, Activity, WordPress Events and News.
	Then I verify left menu items are displayed
	Then I will logout

 @Dev
  Scenario: Verify all top menu elements 
  Then I verify all the links on W menu
  Then I verify Cybertek's Blog menu items
  When I click comments link and goes to comments page
  Then I verify all the link on + New menu
  Then I verify Howdy Menu items
  Then I will logout
  
  
  
  Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
		
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
