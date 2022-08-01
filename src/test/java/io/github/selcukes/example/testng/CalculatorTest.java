package io.github.selcukes.example.testng;

import io.github.selcukes.commons.annotation.Lifecycle;
import io.github.selcukes.commons.config.ConfigFactory;
import io.github.selcukes.core.page.Pages;
import io.github.selcukes.core.page.WinPage;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Lifecycle
public class CalculatorTest {
	WinPage page;

	@BeforeMethod
	public void beforeMethod() {
		ConfigFactory.getConfig().getWindows().setApp("Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
		page = Pages.winPage();
	}

	@Test(enabled = false)
	public void calTest() {

		page.click(By.name("Nine")).click(By.name("One")).click(By.name("Two")).click(By.name("Three"))
				.click(By.name("Multiply by")).click("aid:num9Button").click("aid:equalButton").assertThat()
				.element(page.find("aid:CalculatorResults")).textAs("Display is 82,107");
	}
}
