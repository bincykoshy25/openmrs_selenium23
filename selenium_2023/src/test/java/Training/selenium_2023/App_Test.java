package Training.selenium_2023;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class App_Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		File f=new File("sample.txt");
		boolean result= f.createNewFile();
		System.out.println(result);
		
		Random rand=new Random();
		int i = rand.nextInt(100);
		System.out.println(i);
		
		int j=65+rand.nextInt(26);
		System.out.println(j);
		char upperCaseCh = (char)j;
		System.out.println(upperCaseCh);
		
		int k = 97+rand.nextInt(26);
		System.out.println(k);
		char lowerCaseCh = (char)k;
		System.out.println(lowerCaseCh);
		
		String randomString=upperCaseCh+""+lowerCaseCh+""+i+"";
		System.out.println(randomString);
	}
}