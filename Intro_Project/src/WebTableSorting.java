import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class WebTableSorting {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/gauravsinha/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        driver.findElement(By.xpath("//tr/th[1]")).click();

        List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));
        List<String> originalList = elementsList.stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
        Assert.assertTrue(new HashSet<>(originalList).containsAll(sortedList));

        List<String> price;

        do
        {
            List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
            price = rows.stream().filter(s -> s.getText().contains("Rice"))
                    .map(WebTableSorting::getPriceVeggie).collect(Collectors.toList());
            price.forEach(System.out::println);

            if(price.size()<1)
            {
                driver.findElement(By.cssSelector("[aria-label='Next']")).click();
            }
        }
        while(price.size()<1);

        driver.quit();

    }



    private static String getPriceVeggie(WebElement s) {

// TODO Auto-generated method stub

        return s.findElement(By.xpath("following-sibling::td[1]")).getText();


    }
}
