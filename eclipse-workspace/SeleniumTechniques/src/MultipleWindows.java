import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kalmazan\\AutomationDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.plus2net.com/javascript_tutorial/window-parent.php");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@value='Open Window']")).click();
		System.out.println(driver.getTitle());
		
		Set <String> ids = driver.getWindowHandles();
		Iterator<String> id =ids.iterator();
		String parentId = id.next();
		String childId = id.next();
		driver.switchTo().window(childId); 
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//*[@value='Close this window']")).click();
		driver.switchTo().window(parentId);
		System.out.println(driver.getTitle());
	
	}

}
