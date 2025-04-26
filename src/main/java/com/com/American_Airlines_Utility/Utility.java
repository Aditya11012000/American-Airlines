package com.com.American_Airlines_Utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import net.bytebuddy.utility.RandomString;

public class Utility {
	
	public static void saveScreenshot(WebDriver dr) throws IOException {
		File src = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		String ssName = RandomString.make(4);
		File destination = new File("C:\\ADITYA_SOFTWARE_TESTING\\JAVA\\Selenium\\src\\Screenshots\\"+ssName+".png");
		FileHandler.copy(src, destination);
	}
	
	public static void scrollPage(WebDriver driver) {
		JavascriptExecutor js= ((JavascriptExecutor)driver);
		js.executeScript("window.scrollBy(500,500)");
		Reporter.log("Page scrolled.",true);
	}
	
	public static void scrollPage(WebDriver driver, WebElement element) {
		JavascriptExecutor js= ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true)",element);
		Reporter.log("Page scrolled to element : "+element.getText(),true);
	}
	
	 public static void selectValueFromList(WebElement element, String text)
	{
		 Select sel = new Select(element);
		 sel.selectByContainsVisibleText(text);
	}
	
}
