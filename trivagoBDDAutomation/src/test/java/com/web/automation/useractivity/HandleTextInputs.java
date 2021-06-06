package com.web.automation.useractivity;

import static com.web.automation.utility.ConfigReader.readElementLocators;
import static com.web.automation.utility.ConfigReader.readTestData;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HandleTextInputs {

	public static void inputText(WebDriver driver, String element, String value) {
		driver.findElement(By.xpath(readElementLocators(element))).sendKeys(Keys.BACK_SPACE);

		driver.findElement(By.xpath(readElementLocators(element)))
				.sendKeys(readTestData(value));
	}
}
