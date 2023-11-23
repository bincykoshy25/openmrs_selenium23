package Training.selenium_2023;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigationMethod {
	
	static WebDriver   driver;
	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.openmrs.org/openmrs/login.htm");
		String title = driver.getTitle();
		System.out.println("Title of the page :::" + title);
		
		//navigation methods
		driver.navigate().to("https://www.selenium.dev/");
		
		driver.navigate().back();//openmrs
		
		driver.navigate().forward();//selenium.dev
		
		driver.navigate().refresh();
	}
}