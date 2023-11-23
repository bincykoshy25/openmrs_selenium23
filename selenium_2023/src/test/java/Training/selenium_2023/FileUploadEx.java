package Training.selenium_2023;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30) );
		driver.get("https://the-internet.herokuapp.com/upload");
		
		boolean result = uploadFile("Bangalore.jpg",driver);
		if(result==true) {
			System.out.println("jpg file format is uploaded successfully");
		}
		
		driver.get("https://the-internet.herokuapp.com/upload");
		result = uploadFile("Bangalore.txt",driver);
		if(result==true) {
			System.out.println("txt file format is uploaded successfully");
		}
	}
	
	public static boolean uploadFile(String filename,WebDriver driver) {
		File f = new File(filename);
		driver.findElement(By.id("file-upload")).sendKeys(f.getAbsolutePath());
		driver.findElement(By.id("file-submit")).submit();
		String expected = "File Uploaded!";
		String actual = driver.findElement(By.tagName("h3")).getText();
		boolean result = false;
		if(expected.equals(actual)) {
			result = true;
		}
		return result;
	}
}