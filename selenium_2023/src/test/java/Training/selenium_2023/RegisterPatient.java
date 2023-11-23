package Training.selenium_2023;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterPatient {
	
	@Test //TestNG Annotation
	public void validateRegisterPatient() {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.openmrs.org/openmrs/login.htm");
		//driver.manage().window().setSize(new Dimension(1280, 672));

		//login
		driver.findElement(By.id("username")).sendKeys("Admin");
		driver.findElement(By.id("password")).sendKeys("Admin123");
		driver.findElement(By.id("Inpatient Ward")).click();
		driver.findElement(By.id("loginButton")).click();
		
		//Register a patient
		driver.findElement(By.id("referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension")).click();
		 
		
		String randomString = generateRandomString();
		driver.findElement(By.name("givenName")).sendKeys("Given"+randomString);
		String expected = driver.findElement(By.name("givenName")).getAttribute("value");
		driver.findElement(By.name("middleName")).sendKeys("Middl"+randomString);
		driver.findElement(By.name("familyName")).sendKeys("Surname"+randomString);
		driver.findElement(By.id("next-button")).click();
		
 
		Select genderSelect = new Select(driver.findElement(By.id("gender-field")));
		genderSelect.selectByVisibleText("Male");
		driver.findElement(By.id("next-button")).click();

		driver.findElement(By.id("birthdateDay-field")).sendKeys("01");

		WebElement birthMonthWE = driver.findElement(By.id("birthdateMonth-field"));
		birthMonthWE.findElement(By.xpath("//option[. = 'January']")).click();

		driver.findElement(By.id("birthdateYear-field")).click();
		driver.findElement(By.id("birthdateYear-field")).sendKeys("1980");
		driver.findElement(By.id("next-button")).click();
		driver.findElement(By.id("address1")).click();
		driver.findElement(By.id("address1")).click();
		driver.findElement(By.id("address1")).sendKeys("Address1");
		driver.findElement(By.id("address2")).sendKeys("Addres2");
		driver.findElement(By.id("next-button")).click();

		driver.findElement(By.name("phoneNumber")).sendKeys("1231231231");
		driver.findElement(By.id("next-button")).click();

		WebElement dropdown = driver.findElement(By.id("relationship_type"));
		Select relationShipSelect = new Select(dropdown);
		relationShipSelect.selectByVisibleText("Doctor");

		driver.findElement(By.cssSelector(".person-typeahead")).click();
		driver.findElement(By.cssSelector(".person-typeahead")).sendKeys("123awdgsa");
		driver.findElement(By.id("next-button")).click();
		driver.findElement(By.id("submit")).submit();//click on confirm
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		WebElement givenNameWE= wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("PersonName-givenName")));
		
		
		String actual = givenNameWE.getText();
		
		Assert.assertEquals(actual, expected);
		 
		/*
		 * if(actual.trim().equals(expected)) { System.out.println("TC Pass"); } else {
		 * System.out.println("TC Fails"); }
		 */
	}
	public static String generateRandomString()
	{
		Random rand = new Random();
		int i = rand.nextInt(100);
		System.out.println(i);
		
		int j = 65+rand.nextInt(26);
		System.out.println(j);
		char upperCaseCh = (char)j;
		System.out.println(upperCaseCh);
		
		int k = 97+rand.nextInt(26);
		System.out.println(k);
		char lowerCaseCh = (char)k;
		System.out.println(lowerCaseCh);
		
		String randomString=upperCaseCh+""+lowerCaseCh+""+i+"";
		
		System.out.println(randomString);
		return randomString;
	}
}