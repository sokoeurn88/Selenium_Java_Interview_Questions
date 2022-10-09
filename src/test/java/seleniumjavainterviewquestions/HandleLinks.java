package seleniumjavainterviewquestions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleLinks {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.com");
//		driver.manage().window().maximize();
		
		Thread.sleep(2000);
//		driver.findElement(By.linkText("Best Sellers")).click();
		driver.findElement(By.partialLinkText("Best")).click();
		
		List<WebElement> linksTag=driver.findElements(By.tagName("a")); //capture all links in webpage, write x-path that is common for all links
		System.out.println(linksTag.size());
		
		for(int i =0;i<=linksTag.size();i++) {
			System.out.println(linksTag.get(i).getText());
//			System.out.println(linksTag.get(i).getAttribute("href"));	
		}
	}

}
