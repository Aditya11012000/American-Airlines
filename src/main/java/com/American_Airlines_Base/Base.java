package com.American_Airlines_Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {
	protected static WebDriver driver;

	public void openBrowswer() {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("start-maximized");
		opt.addArguments("disable-notifications");
		
		 driver = new ChromeDriver(opt);
		driver.get("https://www.americanairlines.in/intl/in/index.jsp");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
	}
	
}
