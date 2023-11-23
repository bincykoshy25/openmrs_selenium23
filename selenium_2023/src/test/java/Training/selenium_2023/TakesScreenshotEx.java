package Training.selenium_2023;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakesScreenshotEx {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.bangalorecitycollege.org/application-form.html");
		
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
		driver.manage().window().minimize();
		Thread.sleep(1000);
		
		driver.manage().window().fullscreen();
		Thread.sleep(1000);
		
		String date = SeleniumLibrary.getDate();
		SeleniumLibrary.captureScreenshot("Bangalore" +date +".jpg", driver);
	}
}