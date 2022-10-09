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

public class CaptureScreenshot {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://text-compare.com/");
		driver.manage().window().maximize();

		TakesScreenshot ts=(TakesScreenshot)driver;
		
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg=new File(".\\screenshots\\homepage.png");
		FileUtils.copyFile(src, trg);
		
		WebElement section=driver.findElement(By.xpath("//textarea[@name='text2']"));
		
		File src1=section.getScreenshotAs(OutputType.FILE);
		File trg1=new File(".\\screenshots\\textbox.png");
		FileUtils.copyFile(src1, trg1);
		
		WebElement section3=driver.findElement(By.xpath("//a[@id='logo']"));	//portion screenshot
		
		File src3=section3.getScreenshotAs(OutputType.FILE);
		File trg3=new File(".\\screenshots\\logo.png");
		FileUtils.copyFile(src3, trg3);
		
		
	}

}
