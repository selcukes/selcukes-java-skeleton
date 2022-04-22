package io.github.selcukes.example.pages;

import io.github.selcukes.core.page.WebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class CommonPage extends WebPage {

    public CommonPage(WebDriver driver) {
        super(driver);
    }

    public void enter(String text) {
        find(By.name("q")).clear();
        write(By.name("q"), text + Keys.TAB);
    }
}
