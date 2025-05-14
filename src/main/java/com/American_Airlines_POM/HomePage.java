package com.American_Airlines_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class HomePage {
@FindBy(xpath = "//span[text()='One way']") private WebElement radioButton;
@FindBy(id = "reservationFlightSearchForm.originAirport") private WebElement fromCity;
@FindBy(xpath = "//UL[@ID='ui-id-1']/li[1]/a") private WebElement srcCity;
@FindBy(id = "reservationFlightSearchForm.destinationAirport") private WebElement toCity;
@FindBy(xpath = "//ul[@id='ui-id-2']/li[1]/a") private WebElement destCity;

@FindBy(xpath = "(//button[@class='ui-datepicker-trigger'])[1]") private WebElement date;
@FindBy(xpath = "(//table[@class='ui-datepicker-calendar'])[1]/tbody/tr[5]/td[3]/a") private WebElement selectedDate;

@FindBy(id = "flightSearchForm.adultPassengerCount") private WebElement adults;
@FindBy(id="flightSearchForm.childPassengerCount") private WebElement children;

@FindBy(id = "bookingModule-submit") private WebElement search;

public HomePage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public void selectRadioButton() {
radioButton.click();
}

public void selectSourceCity(String name) throws InterruptedException {
	Thread.sleep(1000);
	fromCity.sendKeys(name);
	Thread.sleep(1000);
	srcCity.click();
	Reporter.log("Source city selected",true);
}

public void selectDestinationCity(String name) throws InterruptedException {
	toCity.sendKeys(name);
	Thread.sleep(1000);
	destCity.click();
	Reporter.log("Destination city selected",true);
}

public void selectAdults(String n) throws InterruptedException {
	Select sel= new Select(adults);
	adults.click();
	sel.selectByValue(n);
	Reporter.log("Adults selected",true);
}
 
//public void clickOnDate() throws InterruptedException {
//	Thread.sleep(1000);
//	date.click();
//}
public void selectDate() throws InterruptedException {
	Thread.sleep(1000);
	date.click();
	Thread.sleep(1000);
	selectedDate.click();
	Reporter.log("Date selected",true);
}

public void selectChildren(String n) throws InterruptedException {
	Select sel = new Select(children);
	children.click();
	sel.selectByValue(n);
	Reporter.log("Children selected",true);
}
public void searchFlight() {
	search.click();
	Reporter.log("Flight searched",true);
	Reporter.log("Navigated to flight selection page.",true);
	System.out.println();
}


}
