package seleniumjavainterviewquestions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Syncroniation_ImplicitlyWait {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.google.com");

		WebElement inputbox=driver.findElement(By.xpath("//input[@name='q']"));
		System.out.println(driver.getTitle()); 
		inputbox.sendKeys("Selenium");
		inputbox.sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//cite[contains(text(), 'https://www.selenium.dev')]")).click();
		System.out.println(driver.getTitle()); 
		
		Thread.sleep(2000);
//		driver.close();
	}

}
