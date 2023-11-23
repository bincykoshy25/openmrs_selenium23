package Training.selenium_2023;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class SeleniumLibrary {
	// TODO Auto-generated method stub
	public static String getDate() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY-HH-mm-ss-SS");
		String date = sdf.format(cal.getTime());
		System.out.println(date);
		return date;
	}

	public static void captureScreenshot(String filename, WebDriver driver) throws IOException {
		//TakesScreenshot is an interface implemented by the class ChromeDriver()
		//Typecasting
		TakesScreenshot tsh=(TakesScreenshot) driver;
		File srcFile = tsh.getScreenshotAs(OutputType.FILE);
		File destFile = new File(filename);
		FileUtils.copyFile(srcFile, destFile);
	}
}