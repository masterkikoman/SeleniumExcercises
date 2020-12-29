import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alertsbox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kalmazan\\AutomationDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		WebElement iframeElement = driver.findElement(By.id("iframeResult"));
		driver.switchTo().frame(iframeElement);
		WebElement button = wait.until(
				ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[text()='Try it']"))));
		int i = 0;
		for (i = 0; i <= 1; i++) {
			button.click();
			System.out.println(driver.switchTo().alert().getText());
			if (i == 0) {
				driver.switchTo().alert().accept();
				System.out.println(driver.findElement(By.id("demo")).getText());
				System.out.println("You Pressed OK button in alerts");
			} else {
				driver.switchTo().alert().dismiss();
				System.out.println(driver.findElement(By.id("demo")).getText());
				System.out.println("You Pressed Cancel button in alerts");
			}
		}
	}

}
