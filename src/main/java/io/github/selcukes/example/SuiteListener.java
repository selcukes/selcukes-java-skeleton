package io.github.selcukes.example;

import lombok.CustomLog;
import lombok.SneakyThrows;
import org.testng.ISuite;
import org.testng.ISuiteListener;

import java.awt.*;
import java.io.File;

@CustomLog
public class SuiteListener implements ISuiteListener {
    public void onStart(ISuite suite) {
        logger.info(() -> "Test Suite execution started...");
        String reportsPath = "target/cucumber-reports";

        String plugin = "pretty, html:" + reportsPath + "/cucumber.html, json:" + reportsPath + "/cucumber.json, " +
            "io.github.selcukes.extent.report.ExtentCucumberAdapter:";
        System.setProperty("cucumber.plugin", plugin);
    }

    @SneakyThrows
    public void onFinish(ISuite suite) {
        logger.info(() -> "Test Suite execution completed...");
        Desktop.getDesktop().open(new File("target/extent-reports/TestReport.html"));
    }
}
