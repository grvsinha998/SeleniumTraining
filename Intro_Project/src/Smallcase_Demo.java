import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Objects;
import java.util.Scanner;

public class Smallcase_Demo {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/gauravsinha/Downloads/chromedriver");

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Sorting Method [Minimun Amount/Popularity/Recently Rebalanced: ");
        String a = sc.nextLine();

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://www.smallcase.com/discover/all");

        Sort_By(a, driver);
        Thread.sleep(3000);
        Get_First_Smallcase(driver);

        driver.findElement(By.xpath("//input[@class='SmallcaseSearchAutosuggestTheme__input__uI43R font-regular ml8 text-14']")).sendKeys("TATA");
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//h5[text()='House of Tata'])[1]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//h1[text()='House of Tata'])[1]")).isDisplayed();

        driver.quit();
    }

    static void Sort_By(String sort, WebDriver driver) {
        driver.findElement(By.xpath("//div[@class='DropdownRow__wrapper__3eOpl DropdownRow__sort-filter__1a_W4']/span/span/i")).click();

        if (Objects.equals(sort, "Minimum Amount")) {
            driver.findElement(By.xpath("//span[text()='Minimum Amount']")).click();
        }
        else if (Objects.equals(sort,"Recently Rebalanced")) {
            driver.findElement(By.xpath("//span[text()='Recently Rebalanced']")).click();
        }
        else {
            driver.findElement(By.xpath("//span[text()='Popularity']")).click();
        }

        driver.findElement(By.xpath("//div[@class='DropdownRow__wrapper__3eOpl DropdownRow__sort-filter__1a_W4']/span/span/i")).click();
        }
    static void Get_First_Smallcase(WebDriver driver) {
        String Head = driver.findElement(By.xpath("(//h2[@class='SmallcaseCard__title__2M7E_ ellipsis mr8 SmallcaseCard__size-auto__NxnIC'])[1]")).getText();
        String Price = driver.findElement(By.xpath("(//div[@data-testid='undefined_statbox-amount-stats-0']//div[contains(text(),'₹')])[1]")).getText();
        System.out.println(Head+": "+ Price);
    }
}


