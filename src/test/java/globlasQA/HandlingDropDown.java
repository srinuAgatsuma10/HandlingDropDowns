package globlasQA;

import java.time.Duration;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class HandlingDropDown {

	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
		driver.manage().window().maximize();
	}

	@Test
	public void countryDropDown() {
		WebElement dropDown = driver.findElement(By.xpath("//div[@class='single_tab_div resp-tab-content resp-tab-content-active']//p//select"));
		Select dp = new Select(dropDown);
		dp.selectByVisibleText("India"); 	// Select by using visible text
		dp.selectByIndex(5); 	// Select by index value
		dp.selectByValue("IND"); 	// Select value of the WebElement

		// Print all countries present
		List<WebElement> options = dp.getOptions();
		for (WebElement countries : options) {
			System.out.println(countries.getText());
		}
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
