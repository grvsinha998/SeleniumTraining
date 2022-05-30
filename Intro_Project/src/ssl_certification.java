import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class ssl_certification {
    public static void main(String[] args) {
        ChromeOptions opts = new ChromeOptions();
        opts.setAcceptInsecureCerts(true);

        System.setProperty("webdriver.chrome.driver", "/Users/gauravsinha/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver(opts);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://expired.badssl.com/");

        driver.findElement(By.id("content")).isDisplayed();

        driver.quit();
    }
}
