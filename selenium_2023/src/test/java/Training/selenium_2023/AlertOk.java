package Training.selenium_2023;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertOk {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		String title = driver.getTitle();
		System.out.println("Title of the page :::" + title);
		
		driver.findElement(By.id("Register")).click();
	
		Alert alert =  driver.switchTo().alert();

		//Store the alert text in a variable
		String text = alert.getText();
		System.out.println("Alert Text"+ text);

		//Press the OK button
		alert.accept();
	}
}