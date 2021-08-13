package io.github.selcukes.example.utils;

import io.github.selcukes.wdb.WebDriverBinary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.picocontainer.Disposable;

import java.time.Duration;

public class DriverManager implements Disposable {
    private WebDriver webDriver;

    private void createWebDriver() {
        WebDriverBinary.chromeDriver().setup();

        ChromeOptions options = new ChromeOptions();
        webDriver = new ChromeDriver(options);
        WebDriverEventListener eventCapture = new EventCapture();
        webDriver = new EventFiringWebDriver(webDriver).register(eventCapture);

        // webDriver = new EventFiringDecorator(eventCapture).decorate(webDriver);
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
        webDriver.quit();
    }
}