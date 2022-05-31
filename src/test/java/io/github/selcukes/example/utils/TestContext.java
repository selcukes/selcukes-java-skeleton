package io.github.selcukes.example.utils;

import io.appium.java_client.android.options.UiAutomator2Options;
import io.github.selcukes.commons.config.ConfigFactory;
import io.github.selcukes.commons.helper.FileHelper;
import io.github.selcukes.core.driver.DriverManager;
import io.github.selcukes.core.enums.DeviceType;
import lombok.SneakyThrows;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class TestContext {
    private WebDriver driver;

    @SneakyThrows
    private void createWebDriver() {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setApp(FileHelper.loadThreadResource(ConfigFactory.getConfig()
            .getMobile().get("app")).getAbsolutePath());
        driver = DriverManager.createDriver(DeviceType.MOBILE, new MutableCapabilities().merge(options));
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