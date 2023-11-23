package org.h2k.testng.examples;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestngEx3_GroupingEx3 {
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("In Before Suite");
	}
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("In After Suite");
	}
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("In Before Test");
	}
	@AfterTest
	public void afterTest()
	{
		System.out.println("In After Test");
	}
	@BeforeGroups (groups = {"US_123"})
	public void beforeGroups()
	{
		System.out.println("In Before Groups");
	}
	@AfterGroups (groups = {"US_123"})
	public void afterGroups()
	{
		System.out.println("In After Groups");
	}
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("In Before Class");
	}
	@AfterClass
	public void afterClass()
	{
		System.out.println("In After Class");
	}
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("In Before Method");
	}
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("In After Method");
	}
	
	@Test (groups = {"ui", "sanity"})
	public void a1()
	{
		System.out.println("In Test case a1");
	}
	
	@Test (groups = {"ui", "sanity", "US_123"})
	public void a2()
	{
		System.out.println("In Test case a2");
	}
	
	@Test (groups = {"ui", "regression", "US_123"})
	public void a3()
	{
		System.out.println("In Test case a3");
	}
}
