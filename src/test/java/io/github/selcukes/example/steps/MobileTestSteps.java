package io.github.selcukes.example.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.selcukes.core.enums.SwipeDirection;
import io.github.selcukes.example.pages.MobileTestPage;
import io.github.selcukes.example.utils.TestContext;
import org.testng.Assert;

public class MobileTestSteps {
    MobileTestPage page;

    public MobileTestSteps(TestContext context) {
        page = new MobileTestPage(context.getDriver());
    }

    @When("I click on {string} link/button")
    public void iClickOn(String linkName) {
        page.click(linkName);
    }

    @Then("{string} text should display")
    public void textShouldDisplay(String text) {
        Assert.assertTrue(page.find(text).isDisplayed());
    }

    @Then("Dialog should be visible")
    public void dialogShouldBeVisible() {

    }

    @When("I scroll down and click on {string}")
    public void iScrollDownClickOn(String name) {
        page.swipe(name, SwipeDirection.DOWN).tap(name);
    }
}
