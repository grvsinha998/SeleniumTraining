import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Parse_Strings {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String name = "Gaurav_Sinha";
		
		 System.setProperty("webdriver.chrome.driver", "/Users/gauravsinha/Downloads/chromedriver");
		 WebDriver driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));	
		 driver.get("https://rahulshettyacademy.com/locatorspractice/");
		 
		 driver.findElement(By.id("inputUsername")).sendKeys("user@phptravels.com");
		 driver.findElement(By.name("inputPassword")).sendKeys("demouser");
		 driver.findElement(By.className("submit")).click();
		 
		 Assert.assertEquals(driver.findElement(By.cssSelector("p.error")).getText(), "* Incorrect username or password");
		 
		 String Password = getPwd(driver);
		 		 
		 driver.findElement(By.cssSelector(".go-to-login-btn")).click();
		 Thread.sleep(1000);
		 
		 driver.findElement(By.id("inputUsername")).sendKeys(name);
		 driver.findElement(By.cssSelector("input[type*=pass]")).sendKeys(Password);
		 driver.findElement(By.id("chkboxOne")).click();
		 driver.findElement(By.className("submit")).click();
		 
		 Thread.sleep(1000);
		 Assert.assertEquals(driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText(), "Hello "+name+",");
		 Assert.assertEquals(driver.findElement(By.xpath("//div[@class='login-container']/p")).getText(), "You are successfully logged in.");
		 
		 driver.findElement(By.cssSelector(".logout-btn")).click();
		 
		 driver.quit();
		 }
	
	public static String getPwd(WebDriver driver) throws InterruptedException
	{
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		 
		String txt = driver.findElement(By.cssSelector(".infoMsg")).getText();
		String[] msg_brk = txt.split("'");
		String pwd = msg_brk[1].split("'")[0];
		
		return pwd;
	}

}
