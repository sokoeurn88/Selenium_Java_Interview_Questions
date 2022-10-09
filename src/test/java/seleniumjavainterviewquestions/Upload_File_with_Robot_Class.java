package seleniumjavainterviewquestions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Upload_File_with_Robot_Class {

	public static void main(String[] args) throws AWTException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.monsterindia.com");
		
		driver.findElement(By.xpath("//a[@class='btn block resume-btn btn-orange mt20']")).click();
		
		//sendKeys is only work when type=file
//		driver.findElement(By.xpath("//*[@id=\"file-upload\"]")).sendKeys("C:\\Users\\sokoeurn chhay\\OneDrive\\Desktop\\sokoeurnsample.rtf");
		
		
		//using Robot Class
		WebElement uploatButton=driver.findElement(By.xpath("//*[@id=\"file-upload\"]"));
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", uploatButton);		//I don't know why not work
		
		
		// 3 steps: copy path, ctrl+v, press open button-enter key
		
		Robot robot=new Robot();
		
		robot.delay(1000);
		
		//copy path file into clipboard
		StringSelection ss=new StringSelection("C:\\\\Users\\\\sokoeurn chhay\\\\OneDrive\\\\Desktop\\\\sokoeurnsample.rtf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		
		//ctrl + v
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_CONTROL);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		//enter
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		
	}

}
