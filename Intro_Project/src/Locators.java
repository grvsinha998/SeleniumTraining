import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 System.setProperty("webdriver.chrome.driver", "/Users/gauravsinha/Downloads/chromedriver");
		 WebDriver driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));	
		 driver.get("https://rahulshettyacademy.com/locatorspractice/");
		 
		 driver.findElement(By.id("inputUsername")).sendKeys("user@phptravels.com");
		 driver.findElement(By.name("inputPassword")).sendKeys("demouser");
		 driver.findElement(By.className("submit")).click();
		 
		 System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		
		 driver.findElement(By.linkText("Forgot your password?")).click();
		 driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Gaurav_Sinha");
		 driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("mustang.gaurav@gmail.com");
		 driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("0123456789");
		 driver.findElement(By.xpath("//form//div//button[text()='Reset Login']")).click();
		 
		 driver.quit();
		 
		 }

}
