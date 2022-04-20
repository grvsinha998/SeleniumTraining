import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Dropdowns {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 System.setProperty("webdriver.chrome.driver", "/Users/gauravsinha/Downloads/chromedriver");
		 WebDriver driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));	
		 driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		 driver.manage().window().maximize();
		 
		 WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		 Select dropdown = new Select(staticDropdown);		//Only works with Select Tag.
		 
		 String[] currencies = {"Select","INR","AED","USD"};
		 
		 for (int i = 1; i<4; i++)
		 {
			 dropdown.selectByIndex(i);
			 Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), currencies[i]);
		 }
		 

		 driver.quit();
	}

}
