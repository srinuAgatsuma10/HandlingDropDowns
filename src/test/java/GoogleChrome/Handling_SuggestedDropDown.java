package GoogleChrome;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

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
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
}
