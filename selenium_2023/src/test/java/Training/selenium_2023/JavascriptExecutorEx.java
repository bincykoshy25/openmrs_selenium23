package Training.selenium_2023;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavascriptExecutorEx {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.bangalorecitycollege.org/application-form.html");
		driver.manage().window().maximize();
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		Object obj = jse.executeScript("return document.title");
		String title = (String) obj;
		System.out.println("Title:::" +title);
		
		obj = jse.executeScript("return document.readyState");
		String readyStatus = (String) obj;
		System.out.println("ReadyStatus:::" +readyStatus);
		
		obj = jse.executeScript("return document.getElementById('religion')");
		WebElement id = (WebElement) obj;
		System.out.println("Id:::" +id.isDisplayed());
		
		obj = jse.executeScript("return document.getElementsByName(\"name\")");
		ArrayList<WebElement> nameArrayList = (ArrayList<WebElement>) obj;
		System.out.println(nameArrayList.size());
		System.out.println("Name:::" +nameArrayList.get(0).getAttribute("name"));
		
		WebElement button = driver.findElement(By.name("send"));
		//Executing JavaScript to click on element
		jse.executeScript("arguments[0].click();", button);
	}
}