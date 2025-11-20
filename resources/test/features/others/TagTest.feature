Feature: Google page tag validation


  Rule: Testing Positive flow

    Scenario Outline: validate <Message> text
      When User enters "<Message>" text

      Scenarios:
        | Message |
        | Hi      |
        |         |

      Scenarios:
        | Message |
        | Hello   |

    @tag2
    Rule: Testing Negative flow

    Scenario: validate Negative values
      When User enters "Negative" values

    Scenario: validate Invalid text
      When User enters "Invalid" text

