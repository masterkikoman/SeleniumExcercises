import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EndToEnd {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kalmazan\\AutomationDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cebupacificair.com/");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 60);

		// Select from local airport to destination
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='FromStation']"))))
				.click();
		driver.findElement(By.xpath("//*[@id='flyout-FromStation']//*[contains(@data-name,'Philippines')]")).click();
		driver.findElement(By.xpath("//*[@id='flyout-FromStation']//*[contains(@aria-label,'Boracay (Caticlan)')]"))
				.click();
		// driver.findElement(By.id("ToStation")).click();
		driver.findElement(By.xpath("//*[@id='flyout-ToStation']//*[contains(@data-name,'Japan')]")).click();
		driver.findElement(By.xpath("//*[@id='flyout-ToStation']//*[contains(@aria-label,'Tokyo (Narita)')]")).click();

		// select date
		driver.findElement(By.id("DepartureCont")).click();
		driver.findElement(By.cssSelector("div[class*='first'] table tbody [data-month='9'][data-day='20']")).click();
		driver.findElement(By.cssSelector("[class='ui-icon ui-icon-circle-triangle-e']")).click();
		driver.findElement(By.cssSelector("div[class*='last'] table tbody [data-month='11'][data-day='16']")).click();
		driver.findElement(By.xpath("//*[text()='Confirm']")).click();

		// Add passenger
		WebElement pass = driver.findElement(By.cssSelector("div[class='adult-cont col-xs-4'] span:nth-child(9)"));

		for (int i = 0; i < 3; i++) {
			pass.click();
		}

		// Find flights
		driver.findElement(By.id("btnFind")).click();

	}

}
