package seleniumjavainterviewquestions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		//Javascript Alert
		driver.findElement(By.cssSelector("button[onclick='jsAlert()']")).click();
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(2000);
//		driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
		
		//comfirmation alert
		driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();
		Thread.sleep(2000);
		System.out.println(driver.switchTo().alert().getText());
//		driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
		
		//alert with input box
		driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();
		Thread.sleep(2000);
		Alert alertWindow=driver.switchTo().alert();
		System.out.println( alertWindow.getText());
		alertWindow.sendKeys("Welcome JSpromt alert().");
		alertWindow.accept();
		
		
//		driver.close();
	}

}
