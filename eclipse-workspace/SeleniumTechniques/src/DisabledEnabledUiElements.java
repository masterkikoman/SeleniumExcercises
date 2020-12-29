import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DisabledEnabledUiElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kalmazan\\AutomationDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.spicejet.com");
		driver.manage().window().maximize();
		
		// System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement div = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("Div1"))));
		System.out.println(div.getAttribute("style"));
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));

		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))

		{
			System.out.println("its enabled");
			Assert.assertTrue(true);
		}

		else

		{
			Assert.assertTrue(false);
		}

	}

}
