package Training.selenium_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumBrowserExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.bangalorecitycollege.org/application-form.html");
		String title=driver.getTitle();
		System.out.println("Title of the page ::: " +title);
		
		//Textbox
		driver.findElement(By.name("name")).sendKeys("testName");
		driver.findElement(By.id("dd")).sendKeys("25");
		driver.findElement(By.id("mm")).sendKeys("03");
		driver.findElement(By.id("yyyy")).sendKeys("1988");
		//Radio/button/checkbox
		driver.findElement(By.xpath("//input[@value='Female']")).click();
		driver.findElement(By.id("nationality")).sendKeys("Indian");
		driver.findElement(By.id("religion")).click();
		driver.findElement(By.xpath("//input[@value='SC']")).click();
		driver.findElement(By.xpath("//input[@value='ST']")).click();
		driver.findElement(By.xpath("//input[@value='BC']")).click();
		driver.findElement(By.xpath("//input[@value='BT']")).click();
		driver.findElement(By.id("course")).sendKeys("BTech");
		driver.findElement(By.id("marks2")).sendKeys("82");
		driver.findElement(By.id("marks3")).sendKeys("85");
		driver.findElement(By.id("marks4")).sendKeys("90");
		driver.findElement(By.id("marks5")).sendKeys("92");
		driver.findElement(By.id("padd")).sendKeys("This is a test");
		driver.findElement(By.id("phone")).sendKeys("8909152321");
		driver.findElement(By.id("cadd")).sendKeys("232, Rowlett Rd, TX");
		driver.findElement(By.id("phone1")).sendKeys("8909152321");
		driver.findElement(By.id("parent")).sendKeys("Koshy");
		driver.findElement(By.id("occ")).sendKeys("Business");
		driver.findElement(By.xpath("//input[@value='No']")).click();
		driver.findElement(By.id("cadd")).sendKeys("432, Rowlett Rd, TX");
		driver.findElement(By.id("phone3")).sendKeys("8909152321");
		driver.findElement(By.id("exam")).sendKeys("Test exam");
		driver.findElement(By.id("sadd")).sendKeys("St. Peter's, 232, Rowlett Rd, TX");
		driver.findElement(By.id("date")).sendKeys("23/12/2022");
		Select course=new Select(driver.findElement(By.id("capp")));
		course.selectByVisibleText("M.Sc Computer Science");
		driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
		driver.findElement(By.cssSelector("//input[class='btn btn-primary']")).click();
	}
}