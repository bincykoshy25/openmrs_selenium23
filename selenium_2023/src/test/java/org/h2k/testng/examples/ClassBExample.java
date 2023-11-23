package org.h2k.testng.examples;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClassBExample {
	/* Order of execution  ---->
	 * @BeforeClass - instantiateDriver
	 * @BeforeMethod - login
	 * b1()
	 * @AfterMethod - logout
	 * @BeforeMethod - login
	 * b2()
	 * @AfterMethod - logout
	 * @AfterClass - closeBrowser
	 */
	
	@BeforeClass
	public void instantiateDriver()
	{
		System.out.println("Instantiate driver before class");
	}
	
	@BeforeMethod
	public void login()
	{
		System.out.println("Login before method");
	}
	
	@Test
	public void b1()
	{
		System.out.println("In test b1");
	}
	
	@Test
	public void b2()
	{
		System.out.println("In test b2");
	}
	
	@AfterMethod
	public void logout()
	{
		System.out.println("Logout after method");
	}
	
	@AfterClass
	public void closeBrowser()
	{
		System.out.println("Close browser after class");
	}
}
