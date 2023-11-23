package Training.selenium_2023;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWaitEx {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.bangalorecitycollege.org/application-form.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement e = driver.findElement(By.linkText("ACADEMICS"));
		e.click();
		List<WebElement> submenuList=driver.findElements(By.xpath("//a[contains(text(),'Academics')]/following-sibling::ul[@class=\"dropdown-menu\"]/li"));
		System.out.println(submenuList.size());
		submenuList.get(2).click();
	}
}