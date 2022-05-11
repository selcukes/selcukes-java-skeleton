package io.github.selcukes.example.utils;

import io.github.selcukes.core.driver.DriverManager;
import io.github.selcukes.core.enums.DeviceType;
import io.github.selcukes.core.listener.EventCapture;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

import java.time.Duration;

public class TestContext {
    private WebDriver driver;

    @SneakyThrows
    private void createWebDriver() {

        driver = DriverManager.createDriver(DeviceType.MOBILE);
        ConfigFactory.loadLoggerProperties();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
    }

    public WebDriver getDriver() {
        if (driver == null) {
            createWebDriver();
        }
        return driver;
    }
}