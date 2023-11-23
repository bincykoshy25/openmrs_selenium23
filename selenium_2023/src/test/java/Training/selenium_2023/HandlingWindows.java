package Training.selenium_2023;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingWindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rediff.com/");
		
		//Handling Frames/IFrames
		driver.switchTo().frame("moneyiframe");
		driver.findElement(By.id("query")).sendKeys("TCS");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		driver.switchTo().defaultContent();
		
		//1&2&3. Access the parent window and store in a string
		String parentWName=driver.getWindowHandle();
		
		//4.fetch all windows [parent, child]
		Set<String> wSet=driver.getWindowHandles();
		for(String wName : wSet) {
			System.out.println("in Set wName::" + wName);
			driver.switchTo().window(wName);
			System.out.println("Title::" +driver.getTitle());
			if(driver.getTitle().contains("TATA")) {
				 String stockPrice = driver.findElement(By.id("ltpid")).getText();
				 System.out.println("StockPrice::" + stockPrice);
			}
			else {
				 System.out.println("Not the child window which i wanted to switch");
			} 
		}
		driver.switchTo().window(parentWName);
		//difference between close() & quit() method
		//driver.close();//closes the browser window which is having focus
		driver.quit();//closes all the browser
	}
}
