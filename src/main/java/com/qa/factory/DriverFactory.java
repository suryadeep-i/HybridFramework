package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	//Method to initilize a Driver
	public WebDriver init_driver(String browser) {
		System.out.println(browser);
		
		if("chrome".equalsIgnoreCase(browser)) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		}
		else if("firefox".equalsIgnoreCase(browser)) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		}
		else {
			System.out.println("Please enter the correct browser value: "+browser);
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	
	//Method to get WebDriver
	public static WebDriver getDriver() {
		return tlDriver.get();
	}

}
