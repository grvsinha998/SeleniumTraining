import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Java102 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "/Users/gauravsinha/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		ArrayList<String> a = new ArrayList<String>();
		// create object of the class
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		a.add(driver.getTitle());
		a.add(driver.getPageSource());
		a.add(driver.getCurrentUrl());
		a.add(driver.getWindowHandle());
		driver.quit();
		
		a.remove(3);
		a.remove(1);
		
		System.out.println(driver.findElement(By.cssSelector("button.signInBtn")).getText());
//		System.out.println(a.get(0));
		
		driver.quit();
		
	}
}
