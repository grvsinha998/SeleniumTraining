import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sel_Intro {

	public static void main(String[] args) {
		
		// Invoking browser
		System.setProperty("webdriver.chrome.driver", "/Users/gauravsinha/Downloads/chromedriver");

		WebDriver driver = new ChromeDriver();		// WebDriver is the interface & ChromeDriver is implementing & we want to refer only to web driver implemented method.
//		ChromeDriver driver = new ChromeDriver();	// This might not work in other browsers if it's accessing personal chrome driver class methods.
		 driver.get("https://www.coinbase.com/price");
		 System.out.println(driver.getTitle());
		 System.out.println(driver.getCurrentUrl());
		 
		 driver.quit();		
//		 driver.close(); 	//Only closes the current tab. Quit closes all tabs opened by selenium.
	}

}
