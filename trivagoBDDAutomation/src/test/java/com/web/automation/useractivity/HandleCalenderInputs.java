package com.web.automation.useractivity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.web.automation.utility.ConfigReader.readElementLocators;
import static com.web.automation.utility.ConfigReader.readTestData;

public class HandleCalenderInputs {

	public static void enterCalenderDate(WebDriver driver, String date, String monthAndYear) {

		driver.findElement(By.xpath(readElementLocators("Date_Tab"))).click();

		boolean flag = false;

		while (!flag) {
			if (driver.findElement(By.xpath(readElementLocators("Month_Year_Header"))).getText()
					.equalsIgnoreCase(readTestData(monthAndYear))) {
				driver.findElement(By.xpath(readElementLocators(date))).click();
				flag = true;
			} else {
				driver.findElement(By.xpath(readElementLocators("NextMonth_Arrow"))).click();
			}
		}
	}
}