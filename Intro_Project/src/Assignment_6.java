import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Assignment_6 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/gauravsinha/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        Random num = new Random();
        int opt_num = num.nextInt(3);

        driver.findElements(By.xpath("//fieldset//*[@type='checkbox']")).get(opt_num).click();

        WebElement staticDropdown = driver.findElement(By.id("dropdown-class-example"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByIndex(opt_num+1);

        String opt_value = "Option" + (opt_num+1);
        System.out.println(opt_value);
        driver.findElement(By.xpath("//input[@placeholder='Enter Your Name']")).sendKeys(opt_value);
        driver.findElement(By.id("alertbtn")).click();

        String alert_txt = driver.switchTo().alert().getText();
        if (alert_txt.contains(opt_value)) {
            System.out.println(alert_txt);
            driver.switchTo().alert().accept();
            driver.quit();
        }
        else {
            System.out.println("Bhakk loduu!");
        }
    }
}
