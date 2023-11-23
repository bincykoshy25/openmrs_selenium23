package org.h2k.openmrs.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPatientPage {
	
	WebDriver driver;
	private By registerAPatientID = By.xpath("(//a[normalize-space()='Register a patient'])");
	private By patientGivenNameID = By.name("givenName");
	private By patientFamilyNameID = By.name("familyName");
	private By navigationBtnID = By.id("next-button");
	private By patientGenderID = By.id("gender-field");
	private By patientBirthDayID = By.id("birthdateDay-field");
	private By patientBirthMnthID = By.id("birthdateMonth-field");
	private By patientBirthYearID = By.id("birthdateYear-field");
	private By patientAddress1ID = By.id("address1");
	private By patientAddress2ID = By.id("address2");
	private By patientCityID = By.id("cityVillage");
	private By patientProvinceID = By.id("stateProvince");
	private By patientCountryID = By.id("country");
	private By patientPostalCodeID = By.id("postalCode");
	private By patientPhoneNumID = By.name("phoneNumber");
	private By patientRelationshipTypeID = By.id("relationship_type");
	private By patientRelationshipNameID = By.xpath("//div[@id='relationship']/p[2]/input");
	private By formSubmitBtnID = By.id("submit");
	private By formCancelBtnID = By.id("cancelSubmission");
	private By demoLabelInFocusID = By.xpath("//li[@class='question-legend done focused']");
	private By personNameGivenNameID = By.className("PersonName-givenName");
	private By personNameFamilyNameID = By.className("PersonName-familyName");
	
	public RegisterPatientPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//Register a Patient
	public boolean RegisterPatient(String patientGivenName,String patientFamilyName,String gender,String birthDay,String birthMonth,String birthYear,
									String address1,String address2,String city,String province,String country,String postalCode,String phoneNumber,
									String relationshipType,String relationshipName,String isSubmit)
	{
		driver.findElement(registerAPatientID).click();
		
		driver.findElement(patientGivenNameID).sendKeys(patientGivenName);
		driver.findElement(patientFamilyNameID).sendKeys(patientFamilyName);
		WebElement nextBtn=driver.findElement(navigationBtnID);
		nextBtn.click();
		
		WebElement genderWE=driver.findElement(patientGenderID);
		Select ddgender=new Select(genderWE);
		ddgender.selectByVisibleText(gender);
		driver.findElement(navigationBtnID).click();
		
		driver.findElement(patientBirthDayID).sendKeys(birthDay);
		WebElement month=driver.findElement(patientBirthMnthID);
		Select ddmnth=new Select(month);
		ddmnth.selectByVisibleText(birthMonth);
		driver.findElement(patientBirthYearID).sendKeys(birthYear);
		driver.findElement(navigationBtnID).click();
		
		driver.findElement(patientAddress1ID).sendKeys(address1);
		driver.findElement(patientAddress2ID).sendKeys(address2);
		driver.findElement(patientCityID).sendKeys(city);
		driver.findElement(patientProvinceID).sendKeys(province);
		driver.findElement(patientCountryID).sendKeys(country);
		driver.findElement(patientPostalCodeID).sendKeys(postalCode);
		driver.findElement(navigationBtnID).click();
		
		driver.findElement(patientPhoneNumID).sendKeys(phoneNumber);
		driver.findElement(navigationBtnID).click();
		
		WebElement relType=driver.findElement(patientRelationshipTypeID);
		Select relation=new Select(relType);
		relation.selectByVisibleText(relationshipType);
		driver.findElement(patientRelationshipNameID).sendKeys(relationshipName);
		driver.findElement(navigationBtnID).click();
		
		if(isSubmit.equals("true"))
		driver.findElement(formSubmitBtnID).submit(); //Using submit() instead of click() since we're accessing a form
		
		//Explicit wait - introduced here to wait for the patient name web element to be visible after successful registration
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement patientNameWE=wait.until(ExpectedConditions.visibilityOfElementLocated(personNameGivenNameID));
		WebElement patientFamilyNameWE=wait.until(ExpectedConditions.visibilityOfElementLocated(personNameFamilyNameID));
		
		String actualPatientName=patientNameWE.getText() +" " +patientFamilyNameWE.getText();
		String expectedPatientName=patientGivenName +" " +patientFamilyName;
		
		return expectedPatientName.equals(actualPatientName);
	}
}