package io.github.selcukes.example.steps;

import io.appium.java_client.AppiumBy;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.selcukes.example.pages.MobileTestPage;
import io.github.selcukes.example.utils.TestContext;

public class MobileTestSteps {
    MobileTestPage page;

    public MobileTestSteps(TestContext context) {
        page = new MobileTestPage(context.getDriver());
    }

    @When("I click on {string} on {string}")
    public void iClickOn(String linkName, String screenName) {
        page.click(AppiumBy.accessibilityId(linkName));
    }

    @Then("{string} text should display")
    public void textShouldDisplay(String text) {
        try {
            System.out.println(page.find(AppiumBy.accessibilityId(text)).isDisplayed());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }

    @Then("Dialog should be visible")
    public void dialogShouldBeVisible() {
    }
}
