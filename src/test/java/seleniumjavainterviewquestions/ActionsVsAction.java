package seleniumjavainterviewquestions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsVsAction {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://automationpractice.com/index.php");
		driver.manage().window().maximize();
		
		WebElement woment=driver.findElement(By.xpath("//a[@title='Women']"));
		WebElement summer_dress=driver.findElement(By.xpath("//a[text()='Summer Dresses']"));
		
		
		
		Actions act=new Actions(driver);	//is a class
//		act.moveToElement(woment).moveToElement(summer_dress).click().perform();
		
		
		Action action=act.moveToElement(woment).moveToElement(summer_dress).click().build();	//Action is interface
		action.perform();
		
		
		
		


		
		
		
		

	}

}
