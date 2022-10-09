package seleniumjavainterviewquestions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoCompletedDropdownPlace {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
		driver.get("https://www.google.com/maps/@32.9508111,-96.8870581,16z");
		
		WebElement searchBox=driver.findElement(By.cssSelector("input#searchboxinput"));
		searchBox.clear();
		Thread.sleep(2000);
		searchBox.sendKeys("TX-12 Loop, Dallas, TX");
		
		Thread.sleep(2000);
		String text;
		do {
			searchBox.sendKeys(Keys.ARROW_DOWN);
			text=searchBox.getAttribute("value");
			
			if(text.equals("TX-12 Loop, Dallas, TX")) {
				Thread.sleep(2000);
				searchBox.sendKeys(Keys.ENTER);
				break;
			}
		}while(!text.isEmpty());
		
		
		
		Thread.sleep(1000);


	}

}
