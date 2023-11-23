package org.h2k.testng.examples;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenerExample.class)
public class ClassAExample {
	
	@BeforeSuite
	public void connectToDB()
	{
		
	}
	
	@BeforeTest
	public void readProperties() 
	{
		
	}
	
	@Test
	public void a1()
	{
		
	}
	
	@Test
	public void a2()
	{
		
	}
}
