package seleniumjavainterviewquestions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker_Dropdown {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		
		driver.findElement(By.xpath("//input[@name='dob']")).click();
		
		Select monthSel=new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		monthSel.selectByVisibleText("Sep");
		
		Select yearSel=new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
		yearSel.selectByVisibleText("1988");
		
		String date="10";
		
		List<WebElement> allDates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		
		for(WebElement ele:allDates) {
			String dt=ele.getText();
			
			if(dt.equals(date)) {
				ele.click();
			}
		}
		
//		driver.close();
	}

}
