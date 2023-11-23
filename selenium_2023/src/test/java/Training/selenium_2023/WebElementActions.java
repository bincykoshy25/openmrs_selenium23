package Training.selenium_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementActions {
	public static void main(String[] args) {
		//https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/WebElement.html
		
		
		//textbox,textarea - sendkeys,clear
		//button,radio,checkbox,list-submit,click
		//text displayed-getText
		//Fetch the attribute value of the WebElement- getAttribute("attributename")
		//Enabled/Displayed/Selected- isEnabled,isDisplayed(),isSelected

		WebDriverManager.chromedriver().setup();
		//WebDriver is a interface implemented by class ChromeDriver
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.bangalorecitycollege.org/application-form.html");
		String title = driver.getTitle();
		System.out.println("Title of the page :::" + title);
		//textbox/textarea
		String result = driver.findElement(By.name("name")).getAttribute("readonly");
		System.out.println(result);
	}
}