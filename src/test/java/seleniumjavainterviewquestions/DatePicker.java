package seleniumjavainterviewquestions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.redbus.in");
		
		String year="2025";
		String month="July";
		String date="10";
		
		driver.findElement(By.cssSelector("#onward_cal")).click();
		
		while(true) {
			String monthyear=driver.findElement(By.cssSelector(".monthTitle")).getText();
			
			String arr[]=monthyear.split(" ");
			String mon=arr[0];
			String yr=arr[1];
			
			if(mon.equalsIgnoreCase(month) && yr.equalsIgnoreCase(year)) 
				break;
				
			else
				driver.findElement(By.cssSelector(".next")).click();

		}
		
		//date pick up
		List<WebElement> alldates=driver.findElements(By.xpath("//table[@class='rb-monthTable first last']//td"));
		for(WebElement ele:alldates) {
			
			String dt=ele.getText();
			if(dt.equals(date)) {
				ele.click();
				break;
			}
			
		}
		
//		driver.close();
	}

}
