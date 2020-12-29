import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ArrayOfProductsToCartForCheckout {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kalmazan\\AutomationDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoblaze.com/");
		driver.manage().window().maximize();
		
		//declaring array
		//String [] brand = {"Sony vaio i5","MacBook air","Sony vaio i7","Dell i7 8gb", "2017 Dell 15.6 Inch","MacBook Pro"};
		
		driver.findElement(By.xpath("//*[text()='Laptops']")).click();
		Thread.sleep(4000);
		List<WebElement> monitor = (driver.findElements(By.xpath("//*[@class='hrefch']")));
		
		//Converting Array to Array List
		//Do not use break if using Array List 
		//List items = Arrays.asList(brand);
		
		
		for( int i=0; i < monitor.size(); i++) {
			
			String model = monitor.get(i).getText();
			if(model.contains("MacBook Pro")) {
				
				// clicking item
				driver.findElement(By.cssSelector("h4[class='card-title'] a")).click();
				break;
				}
		}
	}

}
