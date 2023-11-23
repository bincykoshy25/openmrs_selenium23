package Training.selenium_2023;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ConfirmExample {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/documentation/webdriver/interactions/alerts/");
		
		WebElement el=driver.findElement(By.linkText("See a sample confirm"));
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", el);
		Thread.sleep(2000);
		
		Alert alert=driver.switchTo().alert();
		String alertTxt=alert.getText();
		System.out.println(alertTxt);
		alert.accept();
		
		jse.executeScript("arguments[0].click()", el);
		Thread.sleep(2000);
		
		Alert alert1=driver.switchTo().alert();
		alert1.dismiss();
	}
}