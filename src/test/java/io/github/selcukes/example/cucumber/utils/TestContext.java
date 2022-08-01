package io.github.selcukes.example.cucumber.utils;

import io.appium.java_client.windows.WindowsDriver;
import io.github.selcukes.commons.config.ConfigFactory;
import io.github.selcukes.core.driver.DriverManager;
import io.github.selcukes.core.enums.DeviceType;
import java.time.Duration;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;

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

	public WindowsDriver getWinDriver() {
		if (driver == null) {
			driver = DriverManager.createDriver(DeviceType.DESKTOP);
		}
		return (WindowsDriver) driver;
	}
}
