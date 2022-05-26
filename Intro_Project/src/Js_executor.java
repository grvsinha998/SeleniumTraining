import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Js_executor {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/gauravsinha/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor js = (JavascriptExecutor)driver;     //casting driver to js executor.

        js.executeScript("window.scrollBy(0,600)");
        Thread.sleep(3000);

        int num_rows = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr")).size();
        int num_cols = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr/th")).size();
        System.out.printf("Number of rows:%d\nNumber of columns:%d%n", num_rows, num_cols);

        List<WebElement> cells = driver.findElements(By.xpath("(//table[@name='courses']/tbody/tr)[3]//td"));

        for (WebElement cell: cells) {
            String cell_data = cell.getText();
            System.out.println(cell_data);
        }

        driver.quit();
    }
}
