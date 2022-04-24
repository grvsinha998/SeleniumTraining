import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class GreenKart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "/Users/gauravsinha/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		productQty("Beans", 5, driver);
		productQty("Cucumber", 3, driver);
		productQty("Carrot", 2, driver);
		
		Thread.sleep(1000);
		
		Assert.assertEquals(driver.findElement(By.xpath("//td/strong")).getText(), "3");

		driver.quit();

	}

	public static void productQty(String input, int qty, WebDriver driver) throws InterruptedException {
		
		List<WebElement> prodList = driver.findElements(By.xpath("//h4[@class='product-name']"));

		for (int i = 0; i < prodList.size(); i++) {
			String name = prodList.get(i).getText();
			if (name.contains(input)) {
				for (int j = 0; j < qty - 1; j++) {
					driver.findElements(By.xpath("//div[@class='stepper-input']//a[text()='+']")).get(i).click();
					Thread.sleep(500);
				}
				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				break;
			}
		}
	}

}
