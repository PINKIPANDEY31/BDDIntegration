package com.web.automation.pages;

import static com.web.automation.utility.ConfigReader.readElementLocators;
import static com.web.automation.utility.ConfigReader.readTestData;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.web.automation.useractivity.CaptureScreenshot;
import com.web.automation.useractivity.HandleCalenderInputs;
import com.web.automation.useractivity.HandleTextInputs;

public class SearchHotel {

	WebDriver driver;

	public SearchHotel(WebDriver driver) {
		this.driver = driver;
	}

	public void enterLocation() throws InterruptedException {
		driver.findElement(By.xpath(readElementLocators("Currency_dropdown"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(readElementLocators("Change_Currency"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(readElementLocators("location_tab"))).click();
		HandleTextInputs.inputText(driver, "location_textfield", "Search_Location");

		Thread.sleep(1000);
		driver.findElement(By.xpath(readElementLocators("location_dropdown"))).click();

	}

	public void selectRadius() {
		driver.findElement(By.xpath(readElementLocators("Radius_200miles_dropdown"))).click();
	}

	public void selectFromDate() {
		HandleCalenderInputs.enterCalenderDate(driver, "From_Date", "From_Month_Year_Text");
	}

	public void selectToDate() {
		HandleCalenderInputs.enterCalenderDate(driver, "To_Date", "To_Month_Year_Text");
	}

	public void selectNoOfGuest() throws Exception {
		Thread.sleep(2000);

		driver.findElement(By.xpath(readElementLocators("Guest_Tab"))).click();

		HandleTextInputs.inputText(driver, "Adults_Input", "Number_Of_Adults");
		HandleTextInputs.inputText(driver, "Children_Input", "Number_Of_Children");
		Thread.sleep(2000);
		HandleTextInputs.inputText(driver, "Rooms_Input", "Number_Of_Rooms");

		Select dropDown = new Select(driver.findElement(By.xpath(readElementLocators("Children_Age_Dropdown"))));
		dropDown.selectByValue(readTestData("Childrens_Age"));

		driver.findElement(By.xpath(readElementLocators("Guest_Apply_Button"))).click();
		CaptureScreenshot.captureScreenMethod(driver);


	}

	public void clickOnViewDealButton() throws InterruptedException {
		driver.findElement(By.xpath(readElementLocators("View_Deal_Button"))).click();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
	}

	public void viewDealGalleryPopup() throws InterruptedException {

		driver.findElement(By.xpath(readElementLocators("Deal_Tiles"))).click();
		Thread.sleep(2000);
		List<WebElement> imageList = driver
				.findElements(By.xpath(readElementLocators("Deal_Popup_ThumbnailImage_List")));
		for (int i = 0; i <= imageList.size() - 1; i++) {
			imageList.get(i).click();
		}
		Actions actions = new Actions(driver);
		actions.doubleClick(driver.findElement(By.xpath(readElementLocators("Image_Arrow_Next")))).perform();
		driver.findElement(By.xpath(readElementLocators("Image_Arrow_Previous"))).click();
		driver.findElement(By.xpath(readElementLocators("Popup_ViewDealButton"))).click();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
		driver.findElement(By.xpath(readElementLocators("Pop-up_Close"))).click();

	}

}
