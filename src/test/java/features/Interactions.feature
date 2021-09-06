Feature: Interactions
  Background:
    * I navigate to demoqa.com
    * I click card named Interactions

  Scenario: Change Numbers
    * I click element type Sortable
    * I drag Three to Five

  Scenario: Change Cards
    * I click element type Sortable
    * I click grid
    * I drag Three to Five

  Scenario: Select Cards
    * I click element type Selectable
    * I click grid
    * I select number Two and Five cards
    * I wait for 10 seconds

  Scenario: Select Cards
    * I click element type Droppable
    * I click drag Drag me to Drop Here
    * I wait for 10 seconds