package seleniumjavainterviewquestions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Iframe {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		
//		driver.switchTo().frame(0);
		driver.switchTo().frame("packageListFrame");
		
		System.out.println( driver.getTitle());
		driver.findElement(By.xpath("/html/body/main/ul/li[1]/a")).click();
//		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		
		driver.switchTo().frame("packageFrame");
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//span[normalize-space()='WebDriver']")).click();
		driver.switchTo().parentFrame();
		Thread.sleep(2000);
		
		driver.switchTo().frame(2);
		System.out.println( driver.getTitle());
		driver.findElement(By.xpath("//div[@class='topNav']//a[normalize-space()='Help']")).click();
		
		Thread.sleep(2000);
		driver.close();
	}

}
