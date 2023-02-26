package io.github.selcukes.example.cucumber.pages;

import io.github.selcukes.core.page.WebPage;
import io.github.selcukes.excel.SingleExcelData;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class CommonPage extends WebPage {

    public CommonPage(WebDriver driver) {
        super(driver);
    }

    public Map<String, String> getScenarioData() {
        return SingleExcelData.getTestDataAsMap();
    }

    public void enter(String text) {
        enter(By.name("q"), text + Keys.TAB);
    }
}
