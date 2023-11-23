package org.h2k.testng.examples;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx1 {
	
	@DataProvider(name = "test1")
	public Object[][] createData1()
	{
		Object[][] o1 = new Object[][]
				{
					{"Cedric", "Student1"},
					{"Anne", "Student1"}
				};
				
		return o1;
	}
	
	//This test case will be executed first and it checks for the data provider "test1" in the class.
	//Then it executes the DataProvider method above and o1 will contain the data which will be passed to @Test.
	//Then the remaining code of @Test will be executed based on the data in o1 (data received from DataProvider)
	@Test (dataProvider = "test1")
	public void verifyData1(String n1, String n2)
	{
		System.out.println(n1 +" " +n2);
	}
}