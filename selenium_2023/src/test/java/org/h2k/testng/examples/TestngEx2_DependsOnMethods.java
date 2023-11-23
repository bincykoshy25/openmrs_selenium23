package org.h2k.testng.examples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestngEx2_DependsOnMethods {
	@Test
	public void login()
	{
		boolean result = false;
		Assert.assertTrue(result);
	}
	@Test (dependsOnMethods = "login" )
	public void search()
	{
		
	}
	@Test (dependsOnMethods = "search", alwaysRun = true)
	public void logout()
	{
		
	}
}
