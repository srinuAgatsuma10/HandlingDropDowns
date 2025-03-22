package orangeHRM;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HandlingHidden_DropDown {

	WebDriver driver;

	@BeforeClass()
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void selectOneOption() throws Exception {
		// Login to the Application
		logIN(driver);

		// Click On DropDown
		driver.findElement(By.xpath("//div[6]//div[1]//div[2]//div[1]//div[1]//div[1]")).click();
		Thread.sleep(3000);

		// Selecting One Option
		driver.findElement(By.xpath("//span[normalize-space()='Chief Financial Officer']")).click();

	}

	@Test(priority = 2)
	public void accessAllElements() throws Exception {
		// Click On DropDown
		driver.findElement(By.xpath("//div[6]//div[1]//div[2]//div[1]//div[1]//div[1]")).click();
		Thread.sleep(3000);

		// Accessing All elements names
		// div[@class="oxd-select-option"] ---> Xpath for all Elements
		List<WebElement> options = driver.findElements(By.xpath("//div[@role=\"listbox\"]//span"));
		System.out.println("No of options in List : " + options.size());
		for (WebElement op : options) {
			System.out.println(op.getText());
		}
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public static void logIN(WebDriver driver) {
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='PIM']")).click();
	}

}
