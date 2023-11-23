package org.h2k.testng.examples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestngEx1 {
	
	@Test (priority = 1, description = "Test case to get the title of the webpage")
	public void m1()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.openmrs.org/openmrs/login.htm");
		String actual = driver.getTitle();
		String expected = "OpenMRS";
		Assert.assertEquals(actual, expected);
	}
	@Test (priority = 2, enabled = false)
	public void m2()
	{
		
	}
	@Test (priority = 3)
	public void a1()
	{
		
	}
}