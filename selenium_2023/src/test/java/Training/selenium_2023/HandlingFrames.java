package Training.selenium_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.rediff.com/");
		
		driver.switchTo().frame("moneyiframe"); //Switching to frame
		driver.findElement(By.id("query")).sendKeys("TCS"); //NoSuchElementException will be thrown if we don't switch to frame before accessing its elements
		driver.switchTo().defaultContent(); //Switching back to default page/content
	}
}