Feature: Login Test

  Rule: Testing Positive flow
    @tag1
    Scenario Outline: Login Test1 <User>
      Given User is on Home Page
#    When Open new browser window
#    And User2 is on Home Page
#    And Switch to User1 browser window
#    And Switch to User2 browser window
      Examples:
        | User  |
        | User1 |
        | User2 |
  Rule: Testing Negative flow
    Scenario: Login Test2
      Given User1 is on Home Page
#    When Open new browser window
#    And User2 is on Home Page
#    And Switch to User1 browser window
#    And Switch to User2 browser window

#  @serial
#  Scenario: Login Test3
#    Given User3 is on Home Page
#    When Open new browser window
#    And User4 is on Home Page
#    And Switch to User3 browser window
#    And Switch to User4 browser window
