import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CheckboxExample {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kalmazan\\AutomationDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		/*
		 * driver.get("https://dev-rhipe-signup.azurewebsites.net/");
		 * driver.manage().window().maximize();
		 * driver.findElement(By.id("CustomerName")).sendKeys("asdadadsadasdads");
		 * driver.findElement(By.id("RegistrationNumber")).sendKeys("asdadadad");
		 * 
		 * 
		 * WebDriverWait wait = new WebDriverWait(driver, 40);
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
		 * "iframe[src*='google.com']"))); WebElement iframeElement =
		 * driver.findElement(By.cssSelector("iframe[src*='google.com']"));
		 * driver.switchTo().frame(iframeElement); WebElement box =
		 * driver.findElement(By.id("recaptcha-anchor")); JavascriptExecutor js =
		 * (JavascriptExecutor)driver; js.executeScript("arguments[0].click()", box);
		 */

		driver.get("https://www.spicejet.com");
		driver.manage().window().maximize();
		// Check if textbox is selected or not
		System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());
		// Assertion Using TestNG
		Assert.assertFalse(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected()); 
		driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).click();
		// Check if textbox is selected or not
		System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());
		// Assertion Using TestNG																											
		Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected()); 

		// Count the number of Checkboxes
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

		Assert.assertEquals(driver.findElements(By.cssSelector("input[type='checkbox']")).size(), 6);

	}

}
