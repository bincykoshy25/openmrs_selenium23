package org.h2k.testng.examples;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenMRSExample
{
	static WebDriver driver=new ChromeDriver();
	@Parameters({"url"})
	@Test
	public void validateLogin(String url) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(url);
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println("Title of the page :::" + title);

		//login();
		//registerPatient();
		//findPatientRecord();
		//logout();
		
		//Login
		driver.findElement(By.id("username")).sendKeys("Admin");
		driver.findElement(By.id("password")).sendKeys("Admin123");
		driver.findElement(By.id("Registration Desk")).click();
		driver.findElement(By.id("loginButton")).click();
		String actualLoginMsg = driver.findElement(By.xpath("//h4[contains(text(),'Logged in as Super User (admin) at Registration Desk.')]")).getText();
		String expectedLoginMsg="Logged in as Super User (admin) at Registration Desk.";
		if(actualLoginMsg.equals(expectedLoginMsg))
		{
			System.out.println("Login successful");
		}
		else
		{
			System.out.println("Login unsuccessful");
		}
		
		//Register a Patient
		driver.findElement(By.xpath("(//a[normalize-space()='Register a patient'])")).click();
		driver.findElement(By.name("givenName")).sendKeys("Albert");
		driver.findElement(By.name("familyName")).sendKeys("Kennedy");
		WebElement nextBtn=driver.findElement(By.id("next-button"));
		nextBtn.click();
		
		WebElement gender=driver.findElement(By.id("gender-field"));
		Select ddgender=new Select(gender);
		ddgender.selectByVisibleText("Male");
		driver.findElement(By.id("next-button")).click();
		
		driver.findElement(By.id("birthdateDay-field")).sendKeys("30");
		WebElement month=driver.findElement(By.id("birthdateMonth-field"));
		Select ddmnth=new Select(month);
		ddmnth.selectByVisibleText("October");
		driver.findElement(By.id("birthdateYear-field")).sendKeys("1990");
		driver.findElement(By.id("next-button")).click();
		
		driver.findElement(By.id("address1")).sendKeys("230 St Peters Rd");
		driver.findElement(By.id("address2")).sendKeys("Apt 200");
		driver.findElement(By.id("cityVillage")).sendKeys("Irving");
		driver.findElement(By.id("stateProvince")).sendKeys("Texas");
		driver.findElement(By.id("country")).sendKeys("USA");
		driver.findElement(By.id("postalCode")).sendKeys("75121");
		driver.findElement(By.id("next-button")).click();
		
		driver.findElement(By.name("phoneNumber")).sendKeys("9421312351");
		driver.findElement(By.id("next-button")).click();
		
		WebElement relType=driver.findElement(By.id("relationship_type"));
		Select relation=new Select(relType);
		relation.selectByVisibleText("Parent");
		driver.findElement(By.xpath("//div[@id='relationship']/p[2]/input")).sendKeys("Duke");
		driver.findElement(By.id("next-button")).click();
		
		driver.findElement(By.id("submit")).submit(); //Using submit() instead of click() since we're accessing a form
		
		//Explicit wait - introduced here to wait for the patient name web element to be visible after successful registration
//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
//		WebElement patientName=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("PersonName-givenName")));
//		WebElement patientFamilyName=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("PersonName-familyName")));
//		
//		String actualPatientName=patientName.getText() +" " +patientFamilyName.getText();
//		String expectedPatientName="Albert" +" " +"Kennedy";
		
//		if(expectedPatientName.equals(actualPatientName)) {
//			System.out.println("Registration successful");
//		}
//		else {
//			System.out.println("Registration failed");
//		}
		
		driver.findElement(By.xpath("//div[@id='apps']/a[normalize-space()='Find Patient Record']")).click();
		String expectedPatient="Albert Kennedy";
		driver.findElement(By.id("patient-search")).sendKeys(expectedPatient);
		Thread.sleep(3000);
		String actualPatientID = driver.findElement(By.xpath("//table[@id='patient-search-results-table']/tbody/tr[1]/td[2]")).getText(); 
		System.out.println(actualPatientID);
		System.out.println(expectedPatient);
		if(actualPatientID.contains(expectedPatient)) {
			System.out.println("Find a patient record is successful"); 
		} else {
			System.out.println("Find a patient record is unsuccessful"); 
		}
	}
	
	@Test
	public void registerPatient()
	{
		
	}
	
	@Test
	public void findPatientRecord1()
	{
		
	}
	
	@Test
	public void logout()
	{
		
	}
}


