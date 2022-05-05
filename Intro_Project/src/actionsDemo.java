import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class actionsDemo {

    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/gauravsinha/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://amazon.in/");

//        Location_Confirm(driver);
        Hover_Sign_in(driver);
        Search_Item("bananas",driver);

        driver.quit();
    }

    public static void Location_Confirm(WebDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='submit'])[2]")));
        driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
    }

    public static void Hover_Sign_in(WebDriver driver) {
        Actions axn = new Actions(driver);
        axn.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).build().perform();
    }

    public static void Search_Item(String item, @NotNull WebDriver driver) {
        WebElement search_bar = driver.findElement(By.id("twotabsearchtextbox"));

        Actions axn = new Actions(driver);
        axn.moveToElement(search_bar).click().sendKeys(item).sendKeys(Keys.ENTER).build().perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'results')]")));

        WebElement item_to_select = driver.findElement(By.xpath("//span[contains(text(),'Fresh Banana Yelakki')"));
        wait.until(ExpectedConditions.visibilityOf(item_to_select));
        item_to_select.click();

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentID = it.next();
        String childID = it.next();

        driver.switchTo().window(childID);
    }
}
