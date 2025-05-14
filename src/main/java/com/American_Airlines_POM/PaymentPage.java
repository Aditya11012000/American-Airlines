package com.American_Airlines_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class PaymentPage {

	@FindBy(xpath = "//span[contains(text(),'Credit/Debit Card')]") private WebElement creditCardCheckbox;
	@FindBy(id = "cardNumberSplitCustom1") private WebElement creditCardInputBox;
	@FindBy(xpath = "//span[contains(text(),'Other forms of payment')]")private WebElement otherFormsOfPayment;
	@FindBy(id="afop-options")private WebElement paymentTypeSelectionList;
	
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
	
	public boolean isPaymentTypeSelectionListVisible() throws InterruptedException {
		otherFormsOfPayment.click();
		Reporter.log("Other forms of payment option selected",true);
		Thread.sleep(1000);
		boolean result = paymentTypeSelectionList.isDisplayed();
		return result;
	}
}
