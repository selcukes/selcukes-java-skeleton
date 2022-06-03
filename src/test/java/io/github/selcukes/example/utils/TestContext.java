package io.github.selcukes.example.utils;

import io.appium.java_client.windows.WindowsDriver;
import io.github.selcukes.commons.config.ConfigFactory;
import io.github.selcukes.commons.helper.FileHelper;
import io.github.selcukes.core.driver.DriverManager;
import io.github.selcukes.core.enums.DeviceType;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class TestContext {
    private WebDriver driver;

    @SneakyThrows
    private void createWebDriver() {
        //Temp fix to resolve App Path
        String app = FileHelper.loadThreadResource(ConfigFactory.getConfig()
            .getMobile().getApp()).getAbsolutePath();
        ConfigFactory.getConfig()
            .getMobile().setApp(app);


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
    public WindowsDriver getWinDriver() {
        if (driver == null) {
            driver = DriverManager.createDriver(DeviceType.DESKTOP);
        }
        return (WindowsDriver) driver;
    }

}