package io.github.selcukes.example.cucumber.steps;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.github.selcukes.example.cucumber.utils.TestContext;
import io.github.selcukes.excel.ScenarioContext;
import io.github.selcukes.snapshot.SnapshotImpl;
import lombok.CustomLog;
import org.openqa.selenium.WebDriver;

@CustomLog
public class CucumberHooks {
    WebDriver driver;

    public CucumberHooks(TestContext driverManager) {
        driver = driverManager.getDriver();
    }

    @BeforeAll
    public static void beforeAll() {
        logger.info(() -> "Before All ...");
    }

    @AfterAll
    public static void afterAll() {
        logger.info(() -> "After All ...");
    }

    @Before
    public void beforeTest(Scenario scenario) {
        ScenarioContext.setTestName(scenario);

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
            var snapshot = new SnapshotImpl(driver).shootVisiblePageAsBytes();
            scenario.attach(snapshot, "image/png", "screenshot");
        } catch (Exception ignored) {
        }
    }

    @After
    public void afterTest(Scenario scenario) {
        ScenarioContext.removeTestName();
        logger.info(() -> "Completed Scenario .." + scenario.getName());
    }
}
