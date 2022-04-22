package io.github.selcukes.example.steps;

import io.cucumber.java.*;
import io.github.selcukes.example.utils.TestContext;
import io.github.selcukes.extent.report.Reporter;
import lombok.CustomLog;
import org.openqa.selenium.WebDriver;

@CustomLog
public class CucumberHooks {
    public static ThreadLocal<String> testName = new InheritableThreadLocal<>();
    private final Reporter reporter;
    WebDriver driver;

    public CucumberHooks(TestContext driverManager) {
        driver = driverManager.getDriver();
        reporter = Reporter.getReport();
    }


    @Before
    public void beforeTest(Scenario scenario) {
        String test = getFeatureName(scenario) + "::" + scenario.getName();
        testName.set(test);
        reporter.start() //Initialise Extent Report and start recording logRecord
            .initSnapshot(driver); //Initialise Full page screenshot
        logger.info(() -> "Starting Scenario .." + scenario.getName());
        reporter.attachAndRestart(); // Attach INFO logs and restart logRecord

    }

    @BeforeStep
    public void beforeStep(Scenario scenario) {

        logger.info(() -> "Before Step");
        reporter.attachAndRestart(); // Attach INFO logs and restart logRecord
    }

    @AfterStep
    public void afterStep(Scenario scenario) {

        reporter.attachScreenshot(); //Attach Full page screenshot
        reporter.attachAndRestart(); // Attach INFO logs and restart logRecord
    }

    @After
    public void afterTest(Scenario scenario) {
        logger.info(() -> "Completed Scenario .." + scenario.getName());
        reporter.attachAndClear(); // Attach INFO logs and clear logRecord
    }

    public static String getFeatureName(Scenario scenario) {
        String featureName = scenario.getUri().getPath();
        featureName = featureName.substring(featureName.lastIndexOf("/") + 1, featureName.indexOf("."));
        return featureName;
    }
}
