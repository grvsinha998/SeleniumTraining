import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 System.setProperty("webdriver.chrome.driver", "/Users/gauravsinha/Downloads/chromedriver");
		 WebDriver driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));	
		 driver.manage().window().maximize();
		 
		 driver.get("https://rahulshettyacademy.com/locatorspractice/");			//waits till page is completely loaded.	 
		 driver.navigate().to("http://google.com");
		 
		 for (int i=0; i<5; i++)
		 {
			 driver.navigate().back();
			 driver.navigate().forward();
		 }
	 
		 driver.quit();
	}

}
