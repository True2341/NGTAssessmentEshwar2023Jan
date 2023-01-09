package Scenario2;

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
	static LoginPage login;

	@BeforeClass
	public void setup() throws FileNotFoundException, IOException {
		System.setProperty("webdriver.chrome.driver", rootFolder + "//src//test//resources//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		login = new LoginPage(driver);

	}

	@Test
	public void checkBag() throws InterruptedException {
		login.setLoginDetails();
		login.bag();

		String actual = login.getActualText();
		System.out.println(actual);
		Assert.assertEquals(actual, login.getExpectedText());

	}

	@AfterClass
	public void exit() {
		driver.quit();
	}

}
