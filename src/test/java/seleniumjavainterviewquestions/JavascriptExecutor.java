package seleniumjavainterviewquestions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavascriptExecutor {

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
//		WebElement logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));	//draw border & take screenshot
//		JavascriptUtil.drawBorder(logo, driver);
		
		
		TakesScreenshot ts=(TakesScreenshot)driver;	//take screenshot of logo element
		File src=ts.getScreenshotAs(OutputType.FILE);		//set source
		
		File trg=new File(".\\screenshot\\logo5.pnp");	//set target 
		FileUtils.copyFile(src, trg);
		
		//get title of page
//		String title=JavascriptUtil.getTitleByJS(driver);
//		System.out.println(title);
		
		//click action
//		WebElement regLink=driver.findElement(By.xpath("//a[@class='ico-register']"));
//		JavascriptUtil.clickElementByJS(regLink, driver);
		
		//generate alert
//		JavascriptUtils.generateAlert(driver, "This is my Alert...");
		
		//refresh page
//		JavascriptUtil.refreshBrowserByJS(driver);
		
		//scroll Page down
//		JavascriptUtil.scrollPageDown(driver);
		
		
		//scroll page up
//		JavascriptUtil.scrollPageUp(driver);
		
		
		//zoom page
//		JavascriptUtil.zoomPageByJS(driver);
		
		
		//flash
		WebElement logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		JavascriptUtil.flash(logo, driver);
		
		
	}

	public void executeScript(String string, WebElement uploatButton) {
		// TODO Auto-generated method stub
		
	}

	

}
