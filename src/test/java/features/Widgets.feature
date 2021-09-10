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
    * I verify date 09/27/2021

  Scenario: Menu Interactions
    * I click element type Menu
    * I click menu type Main Item 2
    * I click menu type  type SUB SUB LIST
    * I click menu type Sub Sub Item 2

  Scenario: Select Menu Interactions
    * I click element type Select Menu
    * I select color type Green
    * I click dropdown Select Option
    * I click group option from dropdown Group 1, option 2
    * I click dropdown Select Title
    * I click group option from dropdown Mrs.
    * I click dropdown Select...
    * I click group option from dropdown Green
    * I click group option from dropdown Red
    * I click group option from dropdown Black
    * I click group option from dropdown Blue
    * I remove colors
    * I click car type Opel
    * I verify dropdown to be Group 1, option 2
    * I verify dropdown to be Mrs.
    * I verify removed tags
    * I verify color to be Green
    * I verify car type to be Opel