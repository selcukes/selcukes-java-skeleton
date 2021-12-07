package io.github.selcukes.example.utils;

import io.github.selcukes.wdb.driver.LocalDriver;
import io.github.selcukes.wdb.enums.DriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.picocontainer.Disposable;

import java.time.Duration;

public class DriverManager implements Disposable {
    private WebDriver webDriver;

    private void createWebDriver() {
        LocalDriver localDriver = new LocalDriver();
        webDriver = localDriver.createWebDriver(DriverType.CHROME);
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

    @Override
    public void dispose() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}