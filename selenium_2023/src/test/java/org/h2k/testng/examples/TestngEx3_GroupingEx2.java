package org.h2k.testng.examples;

import org.testng.annotations.Test;

public class TestngEx3_GroupingEx2 {
	/* 
	 * Grouping mechanism
	 * UI/API
	 * APPNAME
	 * SANITY/REGRESSION
	 * USERSTORY_NO
	 * BACKLOG_NO
	 */
	
	@Test (groups = {"ui", "sanity"})
	public void a1()
	{
		
	}
	
	@Test (groups = {"ui", "sanity", "US_123"})
	public void a2()
	{
		
	}
	
	@Test (groups = {"ui", "regression", "US_123"})
	public void a3()
	{
		
	}
}
