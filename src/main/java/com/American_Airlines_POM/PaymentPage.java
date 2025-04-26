package com.American_Airlines_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class PaymentPage {

	@FindBy(xpath = "//span[contains(text(),'Credit/Debit Card')]") private WebElement creditCardCheckbox;
	@FindBy(id = "cardNumberSplitCustom1") private WebElement creditCardInputBox;
	
	public PaymentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isCreditCardInputBoxVisible() throws InterruptedException {
		creditCardCheckbox.click();
		Reporter.log("Credit/Debit card option selected.",true);
		Thread.sleep(1000);
	  boolean result = creditCardInputBox.isDisplayed();
	  return result;
	}
}
