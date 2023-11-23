package Training.selenium_2023;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElementsEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.bangalorecitycollege.org/application-form.html");
		
		driver.findElement(By.linkText("ACADEMICS")).click();
		List<WebElement> subMenuList=driver.findElements(By.xpath("//a[contains(text(),'Academics')]/following-sibling::ul[@class='dropdown-menu']/li"));
		System.out.println("No. of elements in the list::" +subMenuList.size());
		subMenuList.get(2).click();
	}
}