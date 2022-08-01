package io.github.selcukes.example.cucumber.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.selcukes.core.enums.SwipeDirection;
import io.github.selcukes.example.cucumber.pages.MobileTestPage;
import io.github.selcukes.example.cucumber.utils.TestContext;
import org.openqa.selenium.By;

public class MobileTestSteps {
  MobileTestPage page;
  private static final String AID = "aid:";

  public MobileTestSteps(TestContext context) {
    page = new MobileTestPage(context.getDriver());
  }

  @When("I click on {string} link/button")
  public void iClickOn(String linkName) {
    page.click(AID + linkName);
  }

  @Then("{string} text should display")
  public void textShouldDisplay(String text) {
    page.assertThat().element(page.find(AID + text)).isVisible();
  }

  @Then("Dialog should be visible")
  public void dialogShouldBeVisible() {
    page.click(By.id("android:id/button1"));
  }

  @When("I scroll down and click on {string}")
  public void iScrollDownClickOn(String name) {
    page.swipe(AID + name, SwipeDirection.DOWN);
    page.assertThat().element(page.find(AID + name)).isVisible();
    page.click(AID + name);
  }
}
