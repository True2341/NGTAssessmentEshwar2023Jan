package Scenario2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	static WebDriver driver;
	static String rootFolder = System.getProperty("user.dir");

	static Properties prop = new Properties();

	static String email_id = "mobileNumberPass";
	static String password_xpath = "//*[@id=\"reactPageContent\"]/div/div/form/div/div[2]/input";
	static String login_xpath = "//*[@id=\"reactPageContent\"]/div/div/form/div/div[3]/button";

	static String bag_xpath = "//*[@id=\"desktop-header-cnt\"]/div[2]/div[2]/a[2]/span[3]";
	static String add_to_bag_xpath = "//*[@id=\"mountRoot\"]/div/div[1]/main/div[2]/div[2]/div[2]/div[2]/div/div[1]";
	static String empty_bag_xpath = "//div[text()=\"There is nothing in your bag. Let's add some items.\"]";
	static String selected_xpath = "//*[@id=\"appContent\"]/div/div/div/div/div[1]/div[5]/div[2]";

	public LoginPage(WebDriver driver) throws FileNotFoundException, IOException {
		String path = rootFolder + "//src//test//resources//config.properties";
		prop.load(new FileInputStream(path));
		driver.get(prop.getProperty("login_url"));
		this.driver = driver;
	}

	public void setLoginDetails() throws InterruptedException {
		driver.findElement(By.id(email_id)).sendKeys(prop.getProperty("email"));
		driver.findElement(By.xpath(password_xpath)).sendKeys(prop.getProperty("password"));
		WebElement login = driver.findElement(By.xpath(login_xpath));
		login.click();
		Thread.sleep(30000);
		login.click();
		Thread.sleep(2000);
	}

	public void bag() throws InterruptedException {
		driver.findElement(By.xpath(bag_xpath)).click();
		try {
			driver.findElement(By.xpath(empty_bag_xpath));
		} catch (NoSuchElementException e) {
			return;
		}

		add_to_bag();
	}

	public void add_to_bag() throws InterruptedException {
		driver.get(prop.getProperty("product_url"));
		driver.findElement(By.xpath(add_to_bag_xpath)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(bag_xpath)).click();
		Thread.sleep(2000);
	}

	public String getActualText() {
		return driver.findElement(By.xpath(selected_xpath)).getText();

	}

	public String getExpectedText() {
		return prop.getProperty("selected_text");
	}
}
