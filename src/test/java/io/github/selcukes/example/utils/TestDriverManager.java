package io.github.selcukes.example.utils;

import io.github.selcukes.core.driver.DriverManager;
import io.github.selcukes.core.enums.DeviceType;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.picocontainer.Disposable;

import java.time.Duration;

public class TestDriverManager implements Disposable {
    private WebDriver webDriver;

    @SneakyThrows
    private void createWebDriver() {
        DriverManager<RemoteWebDriver> driverManager = new DriverManager<>();
        webDriver = driverManager.createDriver(DeviceType.BROWSER);

        webDriver.manage().window().maximize();

        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

    }

    public WebDriver getDriver() {
        if (webDriver == null) {
            createWebDriver();
        }
        return webDriver;
    }

    @Override
    public void dispose() {

    }
}