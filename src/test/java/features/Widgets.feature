Feature: Widget Interactions
  Background:
    * I navigate to demoqa.com
    * I click card named Widgets

  Scenario: Date picker
    * I click element type Date Picker
    * I click date picker
    * I click day 27
    * I click date picker
    * I click month picker
    * I select June from date picker
    * I wait for 10 seconds

  Scenario: Menu Interactions
    * I click element type Menu
    * I click menu type Main Item 2
    * I click menu type  type SUB SUB LIST
    * I click menu type Sub Sub Item 2
    * I wait for 10 seconds