package io.github.selcukes.example.utils;

import io.github.selcukes.commons.config.ConfigFactory;
import io.github.selcukes.core.driver.DriverManager;
import io.github.selcukes.core.driver.GridRunner;
import io.github.selcukes.core.enums.DeviceType;
import io.github.selcukes.core.listener.EventCapture;
import io.github.selcukes.wdb.enums.DriverType;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

import java.time.Duration;

public class TestContext {
    private WebDriver webDriver;

    @SneakyThrows
    private void createWebDriver() {
        GridRunner.startSeleniumServer(DriverType.CHROME);
        webDriver = DriverManager.createDriver(DeviceType.BROWSER);
        ConfigFactory.loadLoggerProperties();
        EventCapture.FIELD_ATTRIBUTE = "title";
        WebDriverListener eventCapture = new EventCapture();
        webDriver = new EventFiringDecorator(eventCapture).decorate(webDriver);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
    }

    public WebDriver getDriver() {
        if (webDriver == null) {
            createWebDriver();
        }
        return webDriver;
    }
}