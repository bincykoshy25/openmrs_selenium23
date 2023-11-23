package Training.selenium_2023;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingWindowsFacebook {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.xpath("//a[contains(text(),'Create new account')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Learn more")).click();
		Thread.sleep(5000);
		WebElement termsLink= driver.findElement(By.id("terms-link"));
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", termsLink);
		
		//1&2&3. Access the parent window and store in a string 
		String parentWName=driver.getWindowHandle();
		
		Set<String> wSet=driver.getWindowHandles();
		System.out.println("No. of open windows::" +wSet.size());
		for(String wName: wSet) {
			System.out.println("In window::" +wName);
			driver.switchTo().window(wName);
			System.out.println("Title of the window::" +driver.getTitle());
			if(driver.getCurrentUrl().contains("/terms/"))
			{
				String termsServiceHeaderValue = driver.findElement(By.tagName("h2")).getText();
				System.out.println("terms Header::" + termsServiceHeaderValue);
			}
			else
			{
				System.out.println("Not the child window which i wanted to switch");
			} 
		}
		driver.switchTo().window(parentWName);
	}
}