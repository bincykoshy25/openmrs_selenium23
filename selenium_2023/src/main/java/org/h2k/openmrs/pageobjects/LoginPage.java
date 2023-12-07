package org.h2k.openmrs.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	private By loginUsername = By.id("username");
	private By loginPassword = By.id("password");
	private By loginType = By.id("//ul[@id='sessionLocation']/li[2]");
	private By loginButton = By.id("loginButton");
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void login(String username, String password)
	{
		driver.findElement(loginUsername).sendKeys(username);
		driver.findElement(loginPassword).sendKeys(password);
		driver.findElement(loginType).click();
		driver.findElement(loginButton).click();
	}
}