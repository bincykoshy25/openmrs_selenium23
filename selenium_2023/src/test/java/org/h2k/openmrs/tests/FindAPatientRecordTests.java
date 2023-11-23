package org.h2k.openmrs.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.h2k.openmrs.BaseClass;
import org.h2k.openmrs.HelperClass;
import org.h2k.openmrs.pageobjects.FindAPatientRecordPage;
import org.h2k.openmrs.pageobjects.LoginPage;

public class FindAPatientRecordTests extends BaseClass{
	
	@Parameters({"patientName","username","password"})
	@Test
	public void validateFindAPatientRecord(String patientName,String username, String password)
	{
		HelperClass helperObj = new HelperClass(driver);
		String pageTitle = helperObj.launchBrowser(pro.getProperty("url"));
		LoginPage loginPage = new LoginPage(driver);
		if(pageTitle.equals("Login")) {
			loginPage.login(username, password);
		}
		
		FindAPatientRecordPage findAPatientRecordObj = new FindAPatientRecordPage(driver);
		boolean result = findAPatientRecordObj.findAPatientRecord(patientName);
		Assert.assertTrue(result);
	}
	
	@Test
	@Parameters({"invalidpatientName","username","password"})
	public void validateFindAPatientRecordwithInvalidData(String invalidpatientName,String username,String password)
	{
		HelperClass helperObj = new HelperClass(driver);
		String pageTitle = helperObj.launchBrowser(pro.getProperty("url"));
		LoginPage loginPage = new LoginPage(driver);
		if(pageTitle.equals("Login")) {
			loginPage.login(username, password);
		}	
		FindAPatientRecordPage findAPatientRecordObj = new FindAPatientRecordPage(driver);
		boolean result = findAPatientRecordObj.findAPatientRecordInvalidData(invalidpatientName);
		Assert.assertTrue(result);
	}
}