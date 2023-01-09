package Scenario1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	static WebDriver driver;

	static String rootFolder = System.getProperty("user.dir");

	static Properties prop = new Properties();

	static String search_xpath = "//*[@id=\"desktop-header-cnt\"]/div[2]/div[3]/input";
	static WebElement searchBar;

	public HomePage(WebDriver driver) throws FileNotFoundException, IOException {
		String path = rootFolder + "//src//test//resources//config.properties";
		prop.load(new FileInputStream(path));
		driver.get(prop.getProperty("url"));
		this.driver = driver;

	}

	public void search() throws InterruptedException {
		Thread.sleep(2000);
		searchBar = driver.findElement(By.xpath(search_xpath));
		searchBar.sendKeys(prop.getProperty("productName") + "\n");

	}

	public String getProductTitle() {
		return prop.getProperty("productTitle");

	}

}
