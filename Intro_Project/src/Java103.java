

public class Java103 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// String is an object that represents sequence of character.
		// 2 ways of declaring string variables -
		// 1. String literal - Multiple identical values are saved as one object.	
//			String s = "Udemy Course";
//			String s1 = "Udemy Course";
			
		// 2. String s2 = new String("Welcome)
		
//		System.setProperty("webdriver.chrome.driver", "/Users/gauravsinha/Downloads/chromedriver");
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://www.coinbase.com/");
//		System.out.println(driver.getTitle());
//		driver.quit();
		
		
		String  s = "Coinbase – Buy & Sell Bitcoin, Ethereum, and more with trust";
		String[] splited = s.split("Ethereum");
		
//		System.out.println(split[1].trim());
		
		for (int i=0; i<s.length(); i++)
		{
			System.out.println(s.charAt(i));
		}
		
		//Reverse Order
		for (int i=s.length()-1; i>=0; i--)
		{
			System.out.println(s.charAt(i));
		}
	}

}
