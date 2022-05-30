import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.time.Duration;

public class Assignment_8 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/gauravsinha/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        Actions axn = new Actions(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.id("autocomplete")).sendKeys("land");
        WebElement Finland = driver.findElement(By.xpath("//div[text()='Finland']"));
        axn.moveToElement(Finland).click().build().perform();

        String selection = driver.findElement(By.id("autocomplete")).getAttribute("value");

        Assert.assertEquals("Finland",selection);

        driver.quit();

    }
}
