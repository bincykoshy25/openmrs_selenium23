package org.h2k.openmrs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperClass {

	WebDriver driver;
	public HelperClass(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void navigateToFindPatient()
	{
		driver.findElement(By.xpath("//div[@id='apps']/a[normalize-space()='Find Patient Record']")).click();
	}
	
	public void navigateToActiveVisits()
	{
		driver.findElement(By.xpath("//div[@id='apps']/a[normalize-space()='Active Visits']")).click();
	}
	
	public void navigateToRegisterPatient()
	{
		driver.findElement(By.xpath("(//div[@id='apps']/a[normalize-space()='Register a patient'])")).click();
	}
	
	public String launchBrowser(String url)
	{
		driver.get(url);
		String title = driver.getTitle();
		System.out.println("Title of the page :::" + title);
		return title;
	}
}
