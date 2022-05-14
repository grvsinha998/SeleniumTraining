import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Frames {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/gauravsinha/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        Actions axn = new Actions(driver);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://jqueryui.com/droppable/");

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
        driver.findElement(By.id("draggable")).isDisplayed();

        WebElement src = driver.findElement(By.id("draggable"));
        WebElement tgt = driver.findElement(By.id("droppable"));
        axn.dragAndDrop(src,tgt).build().perform();

        driver.switchTo().defaultContent();
        driver.findElement(By.id("content")).isDisplayed();

        driver.quit();
    }
}