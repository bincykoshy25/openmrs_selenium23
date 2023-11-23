package Training.selenium_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		
		driver.switchTo().frame(0);
		//1.Identify the source and target web elements
		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement droppable = driver.findElement(By.id("droppable"));
		
		//2.Click and hold source element
		Actions action=new Actions(driver);
		action.clickAndHold(draggable);
		
		//3.Move to the target element
		action.moveToElement(droppable);
		
		//4.Release the source element in target
		action.release(draggable);
		
		//Mandatory statement to be called
		action.perform();
		
		String expectedText="Dropped!";
		String actualText=droppable.getText();
		System.out.println(actualText);
		
		String expectedColor="rgba(255, 250, 144, 1)";
		String actualColor=droppable.getCssValue("background-color");
		System.out.println(actualColor);
		
		if(expectedText.equals(actualText) && expectedColor.equals(actualColor)) {
			System.out.println("TC Pass");
		}
		else {
			System.out.println("TC Fail");
		}
	}
}