package com.web.automation.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.web.automation.utility.ConfigReader;

public class DriverInstance {

	public static WebDriver driver = null;

	// Initiate Driver Instance
	public static void startDriverInstance() throws InterruptedException {

		switch (ConfigReader.readProjectConfiguration("BrowserName")) {
		case "Firefox":
			System.setProperty("webdriver.gecko.driver", "Driver/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "IE":
			System.setProperty("webdriver.ie.driver", "Driver/InternetExplorerDriver.exe");
			driver = new InternetExplorerDriver();
			break;
		case "Chrome":
		default:
			System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
			driver = new ChromeDriver();
			break;
	    }

		driver.manage().window().maximize();
		driver.get(ConfigReader.readProjectConfiguration("ApplicationURL"));
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		By cookies_accept = By.id(ConfigReader.readElementLocators("Accept_cookie_btn"));
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(cookies_accept)).click();

	}

	// Return Driver Instance
	public static WebDriver getDriverInstance() throws InterruptedException {

		if (driver != null) {
			return driver;
		} else {
			DriverInstance.startDriverInstance();
			return driver;
		}

	}

	// setting driver instance to null
	public static void setDriverInstanceToNull() {
		driver = null;
	}

	// close the browser
	public static void closeDriverInstance() {
		driver.quit();
	}

}
