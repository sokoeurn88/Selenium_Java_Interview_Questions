package seleniumjavainterviewquestions;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/ecosystem/");
		driver.manage().window().maximize();
		
		Dimension dem=driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]")).getSize();
		System.out.println(dem);
		
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 1500)");
		
		String text=driver.findElement(By.xpath("/html/body/div/main/div[4]/div/table/tbody/tr[3]/td[1]")).getText();
		System.out.println(text);
		
		
		
		driver.close();
	}

}
