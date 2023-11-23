package Training.selenium_2023;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PromptExample {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//driver.get("https://www.selenium.dev/documentation/webdriver/interactions/alerts/");
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		//WebElement ele = driver.findElement(By.linkText("See a sample prompt"));
		WebElement ele = driver.findElement(By.id("promtButton"));
		
		//clicking on the link using javascript
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", ele);
		
		Alert alert =  driver.switchTo().alert();
		Thread.sleep(2000);
		String alertText1 = alert.getText();
		System.out.println("Prompt alert text is>>>> " + alertText1); 
		alert.sendKeys("Linux"); //Its the limitation of chrome browser that the text entered isn't visible to us. Its a display issue.
		
		//Press the Ok button
		alert.accept();
		
		//1000 milliseconds = 1 seconds
		//5000 milliseconds = 5 seconds
		Thread.sleep(5000);
		
		//clicking on the link using javascript
		jse.executeScript("arguments[0].click()", ele);
		
		Alert alert1 =  driver.switchTo().alert();
		Thread.sleep(2000);
		String text = alert1.getText(); //Store the alert text in a variable
		System.out.println("Prompt Text::: "+ text);

		//Press the cancel button
		alert1.dismiss();
	}
}
