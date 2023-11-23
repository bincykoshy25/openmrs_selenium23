package org.h2k.openmrs.tests;

import org.h2k.openmrs.BaseClass;
import org.h2k.openmrs.HelperClass;
import org.h2k.openmrs.pageobjects.LoginPage;
import org.h2k.openmrs.pageobjects.RegisterPatientPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RegisterPatientTests extends BaseClass {
	
	@Parameters({"username","password","patientGivenName","patientFamilyName","gender","birthDay","birthMonth","birthYear", 
				"address1","address2","city","province","country","postalCode","phoneNumber","relationshipType","relationshipName","isSubmit"})
	@Test
	public void validateRegisterPatient(String username,String password,String patientGivenName, String patientFamilyName,
										String gender,String birthDay,String birthMonth,String birthYear,String address1,String address2,
										String city,String province,String country,String postalCode,String phoneNumber,String relationshipType,
										String relationshipName,String isSubmit)
	{
		HelperClass helperObj = new HelperClass(driver);
		helperObj.launchBrowser(pro.getProperty("url"));
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);
		RegisterPatientPage registerPatientPage = new RegisterPatientPage(driver);
		Boolean result = registerPatientPage.RegisterPatient(patientGivenName,patientFamilyName,gender,birthDay,birthMonth,birthYear,address1,address2,
															city,province,country,postalCode,phoneNumber,relationshipType,relationshipName,isSubmit);
		Assert.assertTrue(result);
	}
	
	@Test
	public void validateCancelPatientRegistration()
	{
		
	}
}