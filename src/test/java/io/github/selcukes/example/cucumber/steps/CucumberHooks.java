package io.github.selcukes.example.cucumber.steps;

import io.cucumber.java.*;
import io.github.selcukes.core.driver.GridRunner;
import io.github.selcukes.example.cucumber.utils.TestContext;
import lombok.CustomLog;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

@CustomLog
public class CucumberHooks {
  public static ThreadLocal<String> testName = new InheritableThreadLocal<>();
  WebDriver driver;

  public CucumberHooks(TestContext driverManager) {
    driver = driverManager.getDriver();
  }

  @BeforeAll
  public static void beforeAll() {
    logger.info(() -> "Before All ...");
    GridRunner.startAppium();
  }

  @AfterAll
  public static void afterAll() {
    logger.info(() -> "After All ...");
    GridRunner.stopAppium();
  }

  @Before
  public void beforeTest(Scenario scenario) {
    String test = getFeatureName(scenario) + "::" + scenario.getName();
    testName.set(test);
    // Reporter.getReporter().initSnapshot(driver); //Initialise Full page
    // screenshot
    logger.info(() -> "Starting Scenario .." + scenario.getName());
  }

  @BeforeStep
  public void beforeStep(Scenario scenario) {
    logger.info(() -> "Before Step");
  }

  @AfterStep
  public void afterStep(Scenario scenario) {
    logger.info(() -> "After Step");
    try {
      byte[] bytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
      scenario.attach(bytes, "image/png", "screenshot");
    } catch (Exception ignored) {
    }

    // Reporter.attachScreenshot(); //Attach Full page screenshot
  }

  @After
  public void afterTest(Scenario scenario) {
    logger.info(() -> "Completed Scenario .." + scenario.getName());
  }

  public static String getFeatureName(Scenario scenario) {
    String featureName = scenario.getUri().getPath();
    featureName = featureName.substring(featureName.lastIndexOf("/") + 1, featureName.indexOf("."));
    return featureName;
  }
}
