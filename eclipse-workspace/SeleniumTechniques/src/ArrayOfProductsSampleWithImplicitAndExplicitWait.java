import java.util.Arrays;

import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

public class ArrayOfProductsSampleWithImplicitAndExplicitWait {

public static void main(String[] args) throws InterruptedException {

	// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver" ,"C:\\Users\\kalmazan\\AutomationDrivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);// Implicit wait
		driver.manage().window().maximize();
		String[] itemsNeeded= {"Cucumber","Brocolli","Beetroot"};

		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		addItems(driver,itemsNeeded);
		driver.findElement(By.xpath("//*[@alt='Cart']")).click();
		driver.findElement(By.xpath("//*[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.xpath("//input[contains(@class,'promoCode')]")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);//Explicit Wait
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));
		String promoText = driver.findElement(By.xpath("//span[@class='promoInfo']")).getText();
		if (promoText.contains("Code applied")) {
			System.out.println(promoText);
		}
		else {
			System.out.println("no promo");
		}

	}

	public static  void addItems(WebDriver driver,String[] itemsNeeded)
	{
		int j=0;
		List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));
		
		for(int i=0;i<products.size();i++)	{
			//Brocolli - 1 Kg
			//Brocolli,    1 kg			
			String[] name=products.get(i).getText().split("-");
			String formattedName=name[0].trim();

			//format it to get actual vegetable name
			//convert array into array list for easy search
			//  check whether name you extracted is present in arrayList or not-

			List itemsNeededList = Arrays.asList(itemsNeeded);
			if(itemsNeededList.contains(formattedName))

			{
				j++;
				//click on Add to cart
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(j==itemsNeeded.length)
				{
					break;
				}

			}

		}
		
	}
}
		