Feature: Element Interactions
  Background:
    * I navigate to demoqa.com
    * I click card named Elements

  Scenario: Text box interactions
    * I click element type Text Box
    * I enter the username tester
    * I enter the email bora.bora.feyza@gmail.com
    * I enter current address Antalya - Kas
    * I enter permanent address Turkiye
    * I click submit button
    * I verify name output to be tester
    * I verify email output to be bora.bora.feyza@gmail.com
    * I verify current address output to be Antalya - Kas
    * I verify permanent address output to be Turkiye

  Scenario: Check box interactions
    * I click element type Check Box
    * I click checkbox
    * I verify checkbox is checked: true