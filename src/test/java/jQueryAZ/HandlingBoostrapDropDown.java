package jQueryAZ;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HandlingBoostrapDropDown {

	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.manage().window().maximize();
	}

	@Test
	public void countryDropDown() {
		driver.findElement(By.xpath("//button[@class=\"multiselect dropdown-toggle btn btn-default\"]")).click();

		// Select one element
		driver.findElement(By.xpath("//input[@value='Java']")).click();

		// Checking on element if selected or not
		WebElement mySql = driver.findElement(By.xpath("//input[@value='MySQL']"));
		if (!mySql.isSelected()) {
			mySql.click();
		} else {
			System.out.println("Element already selected");
		}

		// Automate all elements in DropDown
		List<WebElement> options = driver.findElements(
				By.xpath("//ul[@class='multiselect-container dropdown-menu']//li//label[@class='checkbox']"));
		System.out.println("Size of the optoins in DropDown : " + options.size());	// Return size of the Options list

		// Access all names of the Options
		for (WebElement op : options) {
			System.out.println(op.getText());
		}

		// Select multiple options
		for (WebElement op : options) {
			String opt = op.getText();
			if (opt.equals("Java")||opt.equals("Angular")) {
				op.click();
			}
		}

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
