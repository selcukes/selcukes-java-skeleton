@complete
Feature: Google page validation

  Rule: Testing Positive flow

    Background:
      Given Maker1 is on Home Page

    Scenario Outline: User enters <Message>
      When User enters "<Message>" text

      Scenarios:
        | Message |
        | Hello   |
        | Hi      |


  Rule: Testing Negative flow

    Background:
      Given Checker1 is on Home Page

    Scenario: User enters Negative values
      When User enters "Negative" values

    Scenario: User enters Invalid text
      When User enters "Invalid" text

