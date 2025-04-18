package tutorialsPoint;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SingleSelectDropDown {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.tutorialspoint.com/selenium/practice/select-menu.php");
		driver.manage().window().maximize();
	}

	@Test
	public void selectOneDropDown() {
		WebElement myDrpDown = driver.findElement(By.xpath("//select[@id='inputGroupSelect03']"));
		Select sl = new Select(myDrpDown);
		sl.selectByVisibleText("Dr.");
		sl.selectByIndex(3);
		sl.selectByValue("2");

		// Print all countries present
		List<WebElement> options = sl.getOptions();
		for (WebElement countries : options) {
			System.out.println(countries.getText());
		}
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
