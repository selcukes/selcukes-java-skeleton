package io.github.selcukes.example.testng;

import io.github.selcukes.commons.config.ConfigFactory;
import io.github.selcukes.core.driver.DriverManager;
import io.github.selcukes.core.listener.TestLifecyclePerMethod;
import io.github.selcukes.core.page.Pages;
import io.github.selcukes.core.page.WinPage;
import io.github.selcukes.reports.ReportDriver;
import io.github.selcukes.reports.listeners.TestNGReportListener;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestLifecyclePerMethod.class, TestNGReportListener.class})
public class CalculatorTest {
    WinPage page;

    @BeforeMethod
    public void beforeMethod() {
        ConfigFactory.getConfig().getWindows().setApp("Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
        page = Pages.winPage();
        ReportDriver.setReportDriver(DriverManager.getDriver());
    }

    @Test(enabled = false)
    public void calTest() {

        page.click(By.name("Nine"))
            .click(By.name("One"))
            .click(By.name("Two"))
            .click(By.name("Three"))
            .click(By.name("Multiply by"));
        page.click("num9Button")
            .click("equalButton")
            .assertThat().element(page.find("CalculatorResults")).textAs("Display is 82,107");
    }

    @AfterMethod
    public void afterMethod() {
        ReportDriver.removeDriver();
    }
}
