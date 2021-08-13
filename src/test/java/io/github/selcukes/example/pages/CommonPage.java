package io.github.selcukes.example.pages;

import lombok.CustomLog;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

import java.util.ArrayList;
import java.util.List;

@CustomLog
public class CommonPage {

    private WebDriver driver;


    public CommonPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String url) {
        driver.get(url);
    }

    public void openNewBrowserWindow() {
        logger.info(() -> "Opening New Browser Window");
        driver.switchTo().newWindow(WindowType.WINDOW);
    }

    public void switchToWindow(int index) {
        logger.info(() -> "Switching to " + index + " Browser window");
        driver.switchTo().window(getWindows().get(index));
    }

    public List<String> getWindows() {
        return new ArrayList<>(driver.getWindowHandles());

    }

    public void enter(String text) {
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys(text + Keys.TAB);

    }
}
