package com.American_Airlines_Testng;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.American_Airlines_Base.Base;
import com.American_Airlines_POM.ChooseFlights;
import com.American_Airlines_POM.HomePage;
import com.American_Airlines_POM.PassengerDeatailsPage;
import com.American_Airlines_POM.PaymentPage;
import com.com.American_Airlines_Utility.Utility;

public class fligHtBookingMainTestng  extends Base{
	HomePage hm;
	ChooseFlights ch;
	PassengerDeatailsPage pd;
   Logger logger;
   PaymentPage pay;
	
	@BeforeClass
	public void launchBrowser() {
		openBrowswer();
	}
	
	@BeforeMethod
	public void preconditions() throws InterruptedException {
	 
		logger= Logger.getLogger("My_New_log");
		  PropertyConfigurator.configure("log4j.properties");
		
		 hm = new HomePage(driver);
		Utility.scrollPage(driver);
		hm.selectRadioButton();
		hm.selectSourceCity("new");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		hm.selectDestinationCity("california");
		hm.selectAdults("1");
		hm.selectDate();
		hm.selectChildren("0"); 
//		fb.saveScreenshot(driver);
		Thread.sleep(2000);
		hm.searchFlight();		
		  logger.info("User has searched flight.");
		
		 ch = new ChooseFlights(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		Utility.scrollPage(driver);
		Thread.sleep(1000);
		ch.sortBy();
		Thread.sleep(3000);
		ch.selectFlight();
		ch.continueBooking();
		  logger.info("User has selectd the flight ticket.");
		
		pd= new PassengerDeatailsPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		Thread.sleep(1000);
		pd.selectTitleAndGender("Mr", "Male");
		Thread.sleep(1500);
		pd.enterFullName("Devid", "Michel", "Jonson");
		Thread.sleep(1500);
		pd.selectDateOfBirth("15", "January", "1999");
		Thread.sleep(1500);
		pd.enterEmail("test@gmail.com");
		Thread.sleep(1500);
		pd.enterPhoneNumber("India", "8888777788");
		Thread.sleep(3000);
		pd.clickOnContinue();
		  logger.info("User has provided passenger details.");
		System.out.println();
	}
  @Test
  public void creditCardSelectionValidation() throws InterruptedException {
	  pay = new PaymentPage(driver);
	boolean expResult=true;
	boolean actualResult = pay.isCreditCardInputBoxVisible();
	
	Assert.assertEquals(actualResult, expResult, "Credit card number input box is not visible. Test case has been failed.");
  Reporter.log("Credit card number input box is visible. Test case has been passed.",true);
  }
}
