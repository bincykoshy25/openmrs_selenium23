package Training.selenium_2023;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.openmrs.org/openmrs/login.htm");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30) );
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("Admin123");
		driver.findElement(By.id("Inpatient Ward")).click();
		driver.findElement(By.id("loginButton")).click();

       //Logged in as Super User (admin) at Inpatient Ward.
		WebElement textWebElement = driver.findElement(By.tagName("h4"));
		String successfulMsg ="Logged in as Super User (admin) at Inpatient Ward....";
		
//      WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
//      Boolean result = wait.until(ExpectedConditions.textToBePresentInElement(textWebElement,successfulMsg));
//      System.out.println("Result is "+ result);
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
									.withTimeout(Duration.ofSeconds(10L)) //Timeout point
									.pollingEvery(Duration.ofSeconds(5L)) //Interval
									.ignoring(NoSuchElementException.class); //Ignore exception
		
		Boolean result = wait.until(ExpectedConditions.textToBePresentInElement(textWebElement,successfulMsg));
		System.out.println("Result is "+ result);
	}
}