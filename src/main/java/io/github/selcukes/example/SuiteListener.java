package io.github.selcukes.example;

import lombok.CustomLog;
import lombok.SneakyThrows;
import org.testng.ISuite;
import org.testng.ISuiteListener;

@CustomLog
public class SuiteListener implements ISuiteListener {
    public void onStart(ISuite suite) {
        logger.info(() -> "Test Suite execution started...");
        System.setProperty("cucumber.publish.quiet", "true");
        String reportsPath = "target/cucumber-reports";

        String plugin = "html:" + reportsPath + "/cucumber.html, json:" + reportsPath + "/cucumber.json, " +
            "io.github.selcukes.extent.report.SelcukesExtentAdapter:";
        System.setProperty("cucumber.plugin", plugin);
    }

    @SneakyThrows
    public void onFinish(ISuite suite) {
        logger.info(() -> "Test Suite execution completed...");
    }
}
