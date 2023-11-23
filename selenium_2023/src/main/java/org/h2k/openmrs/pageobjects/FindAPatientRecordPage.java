package org.h2k.openmrs.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindAPatientRecordPage {
	
	WebDriver driver;
	private By patientSearchID = By.id("patient-search");
	private By findAPatientID = By.xpath("//div[@id='apps']/a[normalize-space()='Find Patient Record']");
	private By patientSearchTableFirstRow = By.xpath("//table[@id='patient-search-results-table']/tbody/tr[1]/td[2]");
	private By patientSearchTableInvalidData = By.xpath("//table[@id='patient-search-results-table']/tbody/tr[1]/td");
	
	public FindAPatientRecordPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public boolean findAPatientRecord(String patientName)
	{
		driver.findElement(findAPatientID).click();
		driver.findElement(patientSearchID).sendKeys(patientName);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(patientSearchTableFirstRow,patientName));
		String actual = driver.findElement(patientSearchTableFirstRow).getText();
		String expected = driver.findElement(patientSearchID).getAttribute("value");
		return actual.equals(expected);
	}
	
	public boolean findAPatientRecordInvalidData(String invalidPatientName)
	{
		driver.findElement(findAPatientID).click();
		driver.findElement(patientSearchID).sendKeys(invalidPatientName);
		String expected = "No matching records found";		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(patientSearchTableInvalidData,expected));
		String actual = driver.findElement(patientSearchTableInvalidData).getText();
		return actual.equals(expected);
	}
}