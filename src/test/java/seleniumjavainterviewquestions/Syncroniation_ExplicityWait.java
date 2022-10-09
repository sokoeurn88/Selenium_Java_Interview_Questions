package seleniumjavainterviewquestions;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Syncroniation_ExplicityWait {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		Wait<WebDriver> mywait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		
		
		WebDriverWait myWait= new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://www.google.com");

//		WebElement inputbox=driver.findElement(By.xpath("//input[@name='q']"));
		
		WebElement element=myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='q']")));
		
		System.out.println(driver.getTitle()); 
		element.sendKeys("Selenium");
		element.sendKeys(Keys.ENTER);
		
//		driver.findElement(By.xpath("//cite[contains(text(), 'https://www.selenium.dev')]")).click();
		
		WebElement element1=mywait.until(new Function<WebDriver, WebElement>(){
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//cite[contains(text(), 'https://www.selenium.dev')]"));
			}
		});
		
		element1.click();
		
		System.out.println(driver.getTitle()); 
		
		Thread.sleep(2000);
//		driver.close();
	}

}
