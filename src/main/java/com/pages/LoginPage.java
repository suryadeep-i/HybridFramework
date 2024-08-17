package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	private WebDriver driver;
	private WebDriverWait mywait;
	
	//By locators
	By userName = By.xpath("//input[@id='email']");
	By password = By.xpath("//input[@id='pass']");
	By loginbutton = By.xpath("//button[@id='send2']");
	By forgotpasswordlink = By.xpath("//a[@class='action remind']");
	//Constructor
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		this.mywait = new WebDriverWait(driver,Duration.ofSeconds(5));
	}
	
	//PageActions
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean forgotPasswordLink() {
		mywait.until(ExpectedConditions.visibilityOfElementLocated(forgotpasswordlink));
		return driver.findElement(forgotpasswordlink).isDisplayed();
	}
	
	public void enterUsername(String username) {
		 mywait.until(ExpectedConditions.visibilityOfElementLocated(userName));
		 driver.findElement(userName).sendKeys(username);
	}
	
	public void enterPassword(String pwd) {
		mywait.until(ExpectedConditions.visibilityOfElementLocated(password));
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickOnLogin() {
		mywait.until(ExpectedConditions.visibilityOfElementLocated(loginbutton));
		driver.findElement(loginbutton).click();
	}
	/*
	 * Method to perform the overallLogin
	 */
	public AccountsPage doLogin(String un, String pwd) {
		driver.findElement(userName).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginbutton).click();
		return new AccountsPage(driver);
	}
}
