import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarUi {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kalmazan\\AutomationDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cebupacificair.com");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		driver.findElement(By.id("DepartureCont")).click();
		driver.findElement(By.cssSelector("div[class*='first'] table tbody [data-month='9'][data-day='20']")).click();
		driver.findElement(By.cssSelector("[class='ui-icon ui-icon-circle-triangle-e']")).click();
		driver.findElement(By.cssSelector("div[class*='last'] table tbody [data-month='11'][data-day='16']")).click();
		driver.findElement(By.xpath("//*[text()='Confirm']")).click();

	}

}
