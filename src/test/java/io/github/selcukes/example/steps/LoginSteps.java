package io.github.selcukes.example.steps;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.selcukes.core.listener.EventCapture;
import io.github.selcukes.example.pages.LoginPage;
import io.github.selcukes.example.utils.TestDriverManager;
import io.github.selcukes.extent.report.Reporter;


public class LoginSteps {


    LoginPage loginPage;

    public LoginSteps(TestDriverManager driverManager) {
        loginPage = new LoginPage(driverManager.getDriver());
    }

    @Given("{} is on Home Page")
    public void userIsOnHomePage(String user) {
        EventCapture.FIELD_ATTRIBUTE = "title";
        loginPage.enableDriverEvents();
        loginPage.open("http://www.google.com/");
        Reporter.getReport().attachScreenshot();
    }


    @And("Open new browser window")
    public void switchToNewBrowserWindow() {
        loginPage.openNewBrowserWindow();
    }

    @And("Switch to User{int} browser window")
    public void switchToWindow(int i) {
        if (i > 2)
            loginPage.switchWindow(i - 3);
        else
            loginPage.switchWindow(i - 1);
        loginPage.enter("User" + i);
    }

    @When("User enters {string} text/values")
    public void userEnters(String text) {
        loginPage.enter(text);
    }

    @When("User clicks on {string} edit Icon")
    @When("User clicks on {string} icon")
    public void userClicks(String text) {
        System.out.println("Hello");
    }

    @When("User clicks on {string} action button")
    @When("User clicks on {string} button")
    public void userClicksButton(String text) {
        System.out.println("Hello" + text);
    }
}

