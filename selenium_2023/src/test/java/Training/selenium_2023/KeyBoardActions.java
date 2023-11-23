package Training.selenium_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyBoardActions {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.bangalorecitycollege.org/application-form.html");
		
		WebElement e = driver.findElement(By.linkText("IQAC"));
		WebElement nameWE = driver.findElement(By.name("name"));
		Actions action = new Actions(driver);
		action.moveToElement(e).build().perform(); // mouse hover
		
		Thread.sleep(2000);
		
		action.sendKeys(Keys.ARROW_DOWN).build().perform();
		action.sendKeys(Keys.ARROW_DOWN).build().perform();
		action.sendKeys(Keys.ARROW_DOWN).build().perform();
		action.sendKeys(Keys.ENTER);
		action.perform();
		action.sendKeys(Keys.RETURN);
		
		action.keyDown(Keys.SHIFT).build().perform();
		action.sendKeys(nameWE,"hello");
		action.keyUp(Keys.SHIFT);
		action.sendKeys(Keys.BACK_SPACE);
		action.sendKeys(nameWE,Keys.chord(Keys.CONTROL, "a"));
		action.sendKeys(Keys.BACK_SPACE);
		action.perform();
	}
}