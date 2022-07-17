import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.Set;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Tab_Switching {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/gauravsinha/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        Actions axn = new Actions(driver);

        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice");
        driver.switchTo().newWindow(WindowType.TAB);

        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = ((Set<String>) handles).iterator();
        String parent = it.next();
        String child = it.next();

        driver.get("https://rahulshettyacademy.com/");

        String course = driver.findElement(By.xpath("(//h2/a)[1]")).getText();
        System.out.println(course);

        driver.switchTo().window(parent);

        driver.findElement(By.xpath("(//input[@name='name'])[1]")).sendKeys(course);

        WebElement dob_txt = driver.findElement(By.cssSelector("[for='dateofBirth']"));
        driver.findElement(with(By.tagName("input")).below(dob_txt)).click();
        driver.findElement(By.xpath("//strong")).isDisplayed();

        driver.quit();
    }
}
