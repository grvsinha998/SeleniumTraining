//import java.time.Duration;
//import java.util.Arrays;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class GreenKart {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "/Users/gauravsinha/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		
//		Add product with quantity to cart.
		productQty("Beans", 5, driver);
		productQty("Cucumber", 3, driver);
		productQty("Carrot", 2, driver);
		
		Assert.assertEquals(driver.findElement(By.xpath("//td/strong")).getText(), "3");
		
		checkout("rahulshettyacademy", driver);
		selectCountry("China", driver);
		
		driver.quit();

/*
		Add multiple products to cart.
		driver.navigate().refresh();

		String[] List = {"Beans", "Cucumber", "Carrot"};
		addOneToCart(List, driver);
*/

	}
	
	static void productQty(String input, int qty, @NotNull WebDriver driver) {

		List<WebElement> prodList = driver.findElements(By.xpath("//h4[@class='product-name']"));

		for (int i = 0; i < prodList.size(); i++) {
			String name = prodList.get(i).getText();
			if (name.contains(input)) {
				for (int j = 0; j < qty - 1; j++) {
					driver.findElements(By.xpath("//div[@class='stepper-input']//a[text()='+']")).get(i).click();
				}
				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				break;
			}
		}
	}
	
	static void addOneToCart(String[] productListinput, WebDriver driver) {

		List<WebElement> prodList = driver.findElements(By.xpath("//h4[@class='product-name']"));

		for (String product : productListinput) {
			for (int i = 0; i < prodList.size(); i++) {
				String name = prodList.get(i).getText();
				if (name.contains(product)) {
					driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
					break;
				}
			}
		}
	}
	
	static void selectCountry(String country, WebDriver driver) {
		 WebElement staticDropdown = driver.findElement(By.xpath("//div/select"));
		 Select dropdown = new Select(staticDropdown);		//Only works with Select Tag.
		 dropdown.selectByValue(country);
		 
		 driver.findElement(By.xpath("//input[@class='chkAgree']")).click();
		 
		 driver.findElement(By.tagName("button")).click();
		 
	}
	
	static void checkout(String coupon, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.findElement(By.className("cart-icon")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED')]")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoCode")));
		
		driver.findElement(By.className("promoCode")).sendKeys(coupon);
		driver.findElement(By.className("promoBtn")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Code applied ..!']")));
		
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
	}

}