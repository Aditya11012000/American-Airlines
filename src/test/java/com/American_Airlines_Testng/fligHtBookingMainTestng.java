package com.American_Airlines_Testng;

import java.time.Duration;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.American_Airlines_Base.Base;
import com.American_Airlines_POM.ChooseFlights;
import com.American_Airlines_POM.HomePage;
import com.American_Airlines_POM.PassengerDeatailsPage;
import com.com.American_Airlines_Utility.Utility;

public class fligHtBookingMainTestng  extends Base{
	HomePage hm;
	ChooseFlights ch;
	PassengerDeatailsPage pd;
	@BeforeClass
	public void launchBrowser() {
		openBrowswer();
	}
	
	@BeforeMethod
	public void preconditions() throws InterruptedException {
		 hm = new HomePage(driver);
		Utility.scrollPage(driver);
		hm.selectRadioButton();
		hm.selectSourceCity("New");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		hm.selectDestinationCity("california");
		hm.selectAdults("1");
		hm.selectDate();
		hm.selectChildren("0"); 
//		fb.saveScreenshot(driver);
		Thread.sleep(2000);
		hm.searchFlight();		
		
		 ch = new ChooseFlights(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		Utility.scrollPage(driver);
		Thread.sleep(1000);
		ch.sortBy();
		Thread.sleep(3000);
		ch.selectFlight();
		ch.continueBooking();
		
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
		
		
	}
  @Test
  public void f() {
	  Reporter.log("TC passed");
  }
}
