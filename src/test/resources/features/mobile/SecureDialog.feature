Feature: Secure Dialog Test in API Demo Application

  @mb
  Scenario: Navigation to Secure Dialog

    When I click on "App" on "HomeScreen"
    Then "Activity" text should display

    When I click on "Activity" on "AppScreen"
    Then "Secure Surfaces" text should display

    When I click on "Secure Surfaces" on "ActivityScreen"
    Then "Secure Dialog" text should display

    When I click on "Show secure dialog" on "SecureDialogScreen"
    Then Dialog should be visible