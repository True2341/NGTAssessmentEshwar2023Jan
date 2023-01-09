package Scenario1;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase {

	static WebDriver driver;

	static String rootFolder = System.getProperty("user.dir");
	static HomePage home;

	@BeforeClass
	public void setup() throws FileNotFoundException, IOException {
		System.setProperty("webdriver.chrome.driver", rootFolder + "//src//test//resources//chromedriver.exe");
		driver = new ChromeDriver();
		home = new HomePage(driver);

	}

	@Test
	public void search() throws InterruptedException {
		home.search();
		Assert.assertEquals(driver.getTitle(), home.getProductTitle());

	}

	@AfterClass
	public void exit() {
		driver.quit();
	}

}
