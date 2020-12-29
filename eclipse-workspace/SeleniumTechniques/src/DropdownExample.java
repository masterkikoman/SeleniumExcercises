import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropdownExample {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kalmazan\\AutomationDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.philippineairlines.com/en/ph/home");
		driver.manage().window().maximize();

		// Static dropdown: Choosing 1 option in Cabin Class field with select tag
		Select sel = new Select(driver.findElement(By.id("baf-cabin-class"))); // Pass the web element of the dropdown
																				// in the argument of Select()
		driver.findElement(By.id("baf-passenger-field"));
		sel.selectByValue("Business");// select by value
		sel.selectByIndex(1);// select by index
		sel.selectByVisibleText("ECONOMY");// by visible text

		// Updated Dropdown for different UI without select value
		driver.get("https://www.skyscanner.com.ph/");
		driver.findElement(By.name("class-travellers-trigger")).click();
		Thread.sleep(3000);
		for (int i = 0; i < 5; i++) {
			driver.findElement(By.xpath("//*[contains(@title,'Increase number of adults')]")).click();//adding number of adults
		}
		driver.findElement(By.cssSelector("[class=BpkLink_bpk-link__1Wmr3]")).click();
		Assert.assertEquals(driver
				.findElement(By.xpath("//*[contains(@class,'CabinClassTravellersSelector__triggertext')]")).getText(),
				"6 travellers, Economy");
		String selectorText = driver
				.findElement(By.xpath("//*[contains(@class,'CabinClassTravellersSelector__triggertext')]")).getText();
		Assert.assertEquals(selectorText,"6 travellers, Economy");
		// Dynamic Drop Down
		driver.get("https://www.cebupacificair.com/");
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='FromStation']")))).click();
		driver.findElement(By.xpath("//*[@id='flyout-FromStation']//*[contains(@data-name,'Philippines')]")).click();
		driver.findElement(By.xpath("//*[@id='flyout-FromStation']//*[contains(@aria-label,'Boracay (Caticlan)')]")).click();
		//driver.findElement(By.id("ToStation")).click();
		driver.findElement(By.xpath("//*[@id='flyout-ToStation']//*[contains(@data-name,'Japan')]")).click();
		driver.findElement(By.xpath("//*[@id='flyout-ToStation']//*[contains(@aria-label,'Tokyo (Narita)')]")).click();
		
		//Auto Suggestive Drop Down
		driver.get("https://www.skyscanner.com.ph/");
		driver.findElement(By.id("fsc-origin-search")).sendKeys(Keys.BACK_SPACE);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='fsc-origin-search']")))).sendKeys("PHI");
		Thread.sleep(3000);
		List<WebElement> options = driver.findElements(By.cssSelector("li[class*='2PQtj'] div span[class*='1Skwp']"));

		for(WebElement option :options) {
			if(option.getText().equalsIgnoreCase("Luzon Clark International (CRK)")) {
			
				option.click();
				break;
			}
		}
	}

}
