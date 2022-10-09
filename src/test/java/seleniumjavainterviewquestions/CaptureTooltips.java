package seleniumjavainterviewquestions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureTooltips {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/tooltip");
		driver.manage().window().maximize();
		
		driver.switchTo().frame(0);
		
		WebElement inputBox=driver.findElement(By.xpath("//input[@id='age']"));
		
		String toolTip=inputBox.getAttribute("title");
		

		System.out.println(toolTip);

		
		driver.close();
		
		
	}

}
