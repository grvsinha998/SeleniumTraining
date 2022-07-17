import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Relative_web_elements {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/gauravsinha/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        Actions axn = new Actions(driver);

        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice");

        WebElement check_txt = driver.findElement(By.xpath("//*[contains(text(),'Check')]"));
        driver.findElement(with(By.id("exampleCheck1")).toLeftOf(check_txt)).click();

        WebElement rbd1 = driver.findElement(By.id("inlineRadio1"));
        String rdb1_opt = driver.findElement(with(By.tagName("label")).toRightOf(rbd1)).getText();
        System.out.println(rdb1_opt);

        WebElement dob_txt = driver.findElement(By.cssSelector("[for='dateofBirth']"));
        driver.findElement(with(By.tagName("input")).below(dob_txt)).sendKeys("23022002");

        driver.findElement(with(By.tagName("input")).below(dob_txt)).click();
        driver.findElement(By.xpath("//strong")).isDisplayed();

        driver.quit();

    }
}
