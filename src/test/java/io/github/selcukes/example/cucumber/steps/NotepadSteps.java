package io.github.selcukes.example.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.selcukes.core.driver.DriverManager;
import io.github.selcukes.core.enums.DeviceType;
import io.github.selcukes.example.cucumber.pages.NotepadPage;
import org.openqa.selenium.By;

public class NotepadSteps {
	NotepadPage page;

	@Given("Notepad application is opened")
	public void openPage() {
		page = new NotepadPage(DriverManager.createDriver(DeviceType.DESKTOP));
	}

	@When("User enters {string} in the Notepad")
	public void iEnter(String text) {
		page.enter(By.className("Edit"), text);
	}

	@And("User select {string} -> {string} to show the file save dialog")
	public void saveDialog(String menu, String item) {
		page.click(By.name(menu));
		page.click("3");
	}

	@And("User enters {string} and clicks on {string}")
	public void enterAndClick(String text, String button) {
		page.enter("1001", text);
		page.click(By.name(button));
	}

	@Then("the file should be saved successfully")
	public void verifyAction() {
	}
}
