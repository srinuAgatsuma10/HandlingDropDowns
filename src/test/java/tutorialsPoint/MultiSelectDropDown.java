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

public class MultiSelectDropDown {
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
	public void selectOneDropDown()throws Exception {
		
		// Select all options.
		driver.findElement(By.xpath("//span[@class='mbsc-textfield-tags-placeholder mbsc-ios']")).click();
		for(int i = 41;i<49;i++) {
			WebElement opt = driver.findElement(By.xpath("//div["+i+"]"));
			System.out.println(opt.getText());
			opt.click();
		}
		Thread.sleep(300);
	}
	

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
