import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Java101 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = {0,5,10,15,20};
//		
//		for (int i = 0 ; i<arr.length; i++)
//		{
//			System.out.println(arr[i]);
//		}
		
		System.setProperty("webdriver.chrome.driver", "/Users/gauravsinha/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		 driver.get("https://www.coinbase.com/");
		 String  a=driver.getTitle();
		 
		 driver.get("https://coindcx.com/");
		 String  b=driver.getTitle();
		 
		 driver.get("https://coinmarketcap.com/");
		 String  c=driver.getTitle();
		 
		 driver.get("https://www.binance.com/en");
		 String  d=driver.getTitle();
		 
		 driver.get("https://www.etoro.com/en-US/");
		 String  e=driver.getTitle();
			
		driver.quit();
		 
		String[] get_titles = {a,b,c,d,e};

//		for (int i=0; i<get_titles.length; i++)
//		{
//			System.out.println(get_titles[i]);
//		}
		
		for (String Tits: get_titles)
		{
			System.out.println(Tits);
		}
		
	}

}
