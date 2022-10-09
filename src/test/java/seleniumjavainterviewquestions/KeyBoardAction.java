package seleniumjavainterviewquestions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyBoardAction {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/key_presses");
		driver.manage().window().maximize();
		
		Actions act=new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
		
		Thread.sleep(1000);
		act.sendKeys(Keys.ESCAPE).perform();
		
		Thread.sleep(1000);
		act.sendKeys(Keys.SPACE).perform();
		
		driver.get("https://text-compare.com/");
		
		WebElement input1=driver.findElement(By.xpath("//textarea[@name='text1']"));
		WebElement input2=driver.findElement(By.xpath("//textarea[@name='text2']"));
		
		input1.sendKeys("I am learning Actions Class in Selenium");
		
		act.keyDown(Keys.CONTROL).perform();
		act.sendKeys("a").perform();
		act.keyUp(Keys.CONTROL).perform();
		
		act.keyDown(Keys.CONTROL).perform();
		act.sendKeys("c").perform();
		act.keyUp(Keys.CONTROL).perform();
		
		act.sendKeys(Keys.TAB).perform();
		
		act.keyDown(Keys.CONTROL).perform();
		act.sendKeys("v").perform();
		act.keyUp(Keys.CONTROL).perform();
		
		if(input1.getAttribute("value").equals(input2.getAttribute("value"))){
			
			System.out.println("Text is copied");
		} else {
			System.out.println("Text is not copied");
		}
			
		
		
	}

}
