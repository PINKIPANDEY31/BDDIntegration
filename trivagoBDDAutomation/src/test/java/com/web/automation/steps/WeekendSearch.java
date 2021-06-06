package com.web.automation.steps;

import static com.web.automation.utility.ConfigReader.readElementLocators;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.web.automation.base.DriverInstance;
import com.web.automation.pages.SearchHotel;
import com.web.automation.useractivity.CaptureScreenshot;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WeekendSearch extends DriverInstance {

	SearchHotel search;
	
	//test test test

	@Given("^User is on Weekend page$")
	public void user_is_on_Weekend_page() throws Throwable {
		DriverInstance.startDriverInstance();
		search = new SearchHotel(driver);
		Assert.assertTrue(driver.getTitle().contains("trivago Weekend"));
	}

	@When("^User enters Location$")
	public void user_enters_Location() throws Throwable {
		search.enterLocation();
	}

	@When("^User selects Radius$")
	public void user_selects_Radius() throws Throwable {
		search.selectRadius();
	}

	@When("^User selects Dates$")
	public void user_selects_Dates() throws Throwable {
		search.selectFromDate();
		search.selectToDate();
	}

	@When("^User clicks on Guest Tab and modifies no\\. of Guests$")
	public void user_clicks_on_Guest_Tab_and_modifies_no_of_Guests() throws Throwable {
		search.selectNoOfGuest();
	}

	@Then("^Search results are updated based on Location, Radius, Date and Guest$")
	public void search_results_are_updated_based_on_Location_Radius_Date_and_Guest() throws Throwable {
		if (!driver.findElements(By.xpath(readElementLocators("See_More_Stays_button"))).isEmpty()) {
			Assert.assertEquals(driver.findElement(By.xpath(readElementLocators("See_More_Stays_button"))).getText(),
					"See more stays");
			Assert.assertEquals(driver.findElement(By.xpath(readElementLocators("View_Deal_Button"))).getText(),
					"View Deal");
			Assert.assertEquals(driver.findElement(By.xpath(readElementLocators("Deal_Tiles_Dates"))).getText(),
					"15 Jun - 17 Jun");
		} else {
			Assert.assertTrue(driver.findElement(By.xpath(readElementLocators("No_Search_Found"))).isDisplayed());
		}

	}

	@Then("^User clicks on View Deal button$")
	public void user_clicks_on_View_Deal_button() throws Throwable {
		search.clickOnViewDealButton();
		Assert.assertTrue(driver.getTitle().contains("trivago Weekend"));
		search.viewDealGalleryPopup();

	}
	
	@Then("^User clicks on View Deal button$")
	public void user_clicks_on_View_Deal_buttonc() throws Throwable {
		search.clickOnViewDealButton();
		Assert.assertTrue(driver.getTitle().contains("trivago Weekend"));
		search.viewDealGalleryPopup();

	}
	
	@Then("^User clicks on View Deal button$")
	public void user_clicks_on_View_Deal_buttontest() throws Throwable {
		search.clickOnViewDealButton();
		Assert.assertTrue(driver.getTitle().contains("trivago Weekend"));
		search.viewDealGalleryPopup();

	}

}
