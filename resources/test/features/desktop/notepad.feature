Feature: Notepad Application Automation

  @note
  Scenario: Edit content and save
    Given Notepad application is opened
    When User enters "Welcome to Selcukes !!!" in the Notepad
    And User select "File" -> "Save" to show the file save dialog
    And User enters "sample.txt" and clicks on "Save"
    Then the file should be saved successfully
