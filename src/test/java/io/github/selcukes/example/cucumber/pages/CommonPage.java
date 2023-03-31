package io.github.selcukes.example.cucumber.pages;

import io.github.selcukes.core.page.WebPage;
import java.util.Map;

import io.github.selcukes.excel.ExcelDataFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class CommonPage extends WebPage {

	public CommonPage(WebDriver driver) {
		super(driver);
	}

	public Map<String, String> getScenarioData() {
		return ExcelDataFactory.getInstance().getScenarioData();
	}

	public void enter(String text) {
		enter(By.name("q"), text + Keys.TAB);
	}
}
