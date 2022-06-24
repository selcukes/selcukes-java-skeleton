Feature: Secure Dialog Test in API Demo Application

    @mobile
    Scenario: Navigation to Secure Dialog
        When I click on "App" link
        Then "Activity" text should display
        When I click on "Activity" link
        And I scroll down and click on "Secure Surfaces"
        Then "Secure Dialog" text should display
        When I click on "Secure Dialog" link
        Then "Show secure dialog" text should display
        When I click on "Show secure dialog" button
        Then Dialog should be visible