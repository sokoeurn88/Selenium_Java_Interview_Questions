package seleniumjavainterviewquestions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestDropdown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
		
		driver.get("https://google.com");
		driver.findElement(By.cssSelector("input[name='q']")).sendKeys("Books");
		
		List<WebElement> list=driver.findElements(By.cssSelector("ul.G43f7e>li"));
		
		
		System.out.println("Size of Auto suggest: "+list.size());
		
		
		for(WebElement listitem:list) {

			if(listitem.getText().equals("bookstore")) {
				listitem.click();
				break;
				
			}
		}
		
		Thread.sleep(1000);


	}

}
