import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;

public class MouseInteractionAndKeyboardActions {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kalmazan\\AutomationDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Actions mouse = new Actions(driver);
		WebElement move = driver.findElement(By.xpath("//*[@id='nav-link-accountList']"));
		WebElement searchBox = driver.findElement(By.xpath("//*[@name='site-search']"));
		
		//Inputting All Caps
		mouse.moveToElement(searchBox).click().keyDown(Keys.SHIFT).sendKeys("ferrari").doubleClick().build().perform();
		
		
		//Action Method mouse hover moves to specific element
		mouse.moveToElement(move).contextClick().build().perform();
		
		
		
		
		
		
	}

}
