package com.American_Airlines_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.American_Airlines_Base.Base;
import com.com.American_Airlines_Utility.Utility;

public class ChooseFlights extends  Base {
@FindBy(id="w22") private WebElement sort;
@FindBy(xpath = "//ul[@id='w23']/li[2]/a") private WebElement sortedElement;
@FindBy(xpath = "(//dIv[contains(@class,'bound-table-flightline')])[1]/div[2]/div[1]/div/div") private WebElement flight;
@FindBy(xpath = "//span[text()='continue']") private WebElement continueButton;

public ChooseFlights(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public void sortBy() throws InterruptedException {
//	Utility.scrollPage(driver, sort);
	Thread.sleep(2000);
	sort.click();
	Thread.sleep(3000);
	sortedElement.click();
	Reporter.log("Flights sorted",true);
}

public void selectFlight() throws InterruptedException {
	Utility.scrollPage(driver, flight);
	flight.click();
	Thread.sleep(3000);
	Reporter.log("Flights selected",true);
}

public void continueBooking() throws InterruptedException {
	Utility.scrollPage(driver, continueButton);
	Thread.sleep(1000);
	continueButton.click();
	Reporter.log("Continued to passenger details page.",true);
	System.out.println();
}
}
