package GoogleChrome;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Handling_SuggestedDropDown {

	WebDriver driver;

	@BeforeClass()
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void suggestedDropDown() {

		// Text Area/Search Button
		driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("Whey protein");
		// Accessing suggested elements
		List<WebElement> autoOptoin = driver
				.findElements(By.xpath("//ul[@class=\"G43f7e\"]//li//div[@role=\"option\"]"));
		System.out.println(autoOptoin.size());
		// Get suggested text and select given search option
		for (int i = 0; i < autoOptoin.size(); i++) {
			System.out.println("Suggested Text: " + autoOptoin.get(i).getText());
		}
		for (int i = 0; i < autoOptoin.size(); i++) {
			if (autoOptoin.get(i).getText().equals("whey protein powder benefits")) {
				autoOptoin.get(i).click();
				break;
			}
		}
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
