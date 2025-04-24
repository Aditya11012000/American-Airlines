package com.American_Airlines_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.American_Airlines_Base.Base;
import com.com.American_Airlines_Utility.Utility;

public class PassengerDeatailsPage extends Base {
@FindBy(id="tpl9_widget-input-apimTravellers-traveller_0_ADT-IDEN_TitleCode") private WebElement title;
@FindBy(id="tpl9_widget-input-apimTravellers-traveller_0_ADT-PSPT_0-IDEN_Gender") private WebElement gender;
@FindBy(id="tpl9_widget-input-apimTravellers-traveller_0_ADT-IDEN_FirstName") private WebElement fName;
@FindBy(id="tpl9_widget-input-apimTravellers-traveller_0_ADT-IDEN_MiddleName") private WebElement mName;
@FindBy(id="tpl9_widget-input-apimTravellers-traveller_0_ADT-IDEN_LastName") private WebElement lName;
@FindBy(id="tpl9_widget-input-apimTravellers-traveller_0_ADT-PSPT_0-IDEN_DateOfBirth-DateDay") private WebElement day;
@FindBy(id="tpl9_widget-input-apimTravellers-traveller_0_ADT-PSPT_0-IDEN_DateOfBirth-DateMonth") private WebElement month;
@FindBy(id="tpl9_widget-input-apimTravellers-traveller_0_ADT-PSPT_0-IDEN_DateOfBirth-DateYear") private WebElement year;
@FindBy(xpath = "(//input[contains(@id,'tpl9_widget-input-apimTravellers-contactInformation-Email')])[1]") private WebElement primaryEmail;
@FindBy(xpath = "(//input[contains(@id,'tpl9_widget-input-apimTravellers-contactInformation-Email')])[2]") private WebElement confirmEmail;
@FindBy(id="tpl9_widget-input-apimTravellers-contactInformation-PhoneMobileCode") private WebElement countryRegion;
@FindBy(id="tpl9_widget-input-apimTravellers-contactInformation-PhoneMobile") private WebElement phoneNumber;
@FindBy(xpath = "//span[text()='continue']") private WebElement continueButton;

	public PassengerDeatailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void selectTitleAndGender(String givenTitle, String givenGender) throws InterruptedException{
		Utility.selectValueFromList(title, givenTitle);
		Thread.sleep(1000);
		Utility.selectValueFromList(gender, givenGender);
		Reporter.log("Title and gender has selected.",true);
	}
	
	public void enterFullName(String fn, String mn, String ln) {
		Reporter.log("Page scrolled",true);
		fName.sendKeys(fn);
		mName.sendKeys(mn);
		lName.sendKeys(ln);
		Reporter.log("Name entered.",true);
	}
	
	public void selectDateOfBirth(String dd, String m, String yy) {
	Utility.selectValueFromList(day, dd);
	Utility.selectValueFromList(month, m);
	Utility.selectValueFromList(year, yy);
	Reporter.log("Date of birth selected.",true);
	}
	
	public void enterEmail(String email) throws InterruptedException {
		Utility.scrollPageByElement(driver, primaryEmail);
		primaryEmail.sendKeys(email);
		Thread.sleep(1000);
		confirmEmail.sendKeys(email);
		Reporter.log("Email has entered.",true);
	}
	
	public void enterPhoneNumber(String country, String num) throws InterruptedException {
		Utility.selectValueFromList(countryRegion, country);
		Thread.sleep(1000);
		phoneNumber.sendKeys(num);
		Thread.sleep(2000);
		Reporter.log("Phone number entered.",true);
	}
	
	public void clickOnContinue() {
		continueButton.click();
		Reporter.log("Navigated to payment page.",true);
	}
	
}
