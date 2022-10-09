package seleniumjavainterviewquestions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseOperations {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		WebElement button=driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		
		Actions act=new Actions(driver);
		act.contextClick(button).perform();
		
		//double click
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		
		driver.switchTo().frame("iframeResult");
		
		driver.findElement(By.xpath("//input[@id='field1']")).clear();
		driver.findElement(By.xpath("//input[@id='field1']")).sendKeys("Welcome to Mouse Operations");
		
		WebElement doubleClickBtn=driver.findElement(By.xpath("//button[@ondblclick='myFunction()']"));
		
		act.doubleClick(doubleClickBtn).perform();
		
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		
		WebElement rome=driver.findElement(By.xpath("//div[@id='box6']"));
		WebElement italy=driver.findElement(By.xpath("//div[@id='box106']"));
		WebElement seoul=driver.findElement(By.xpath("//div[@id='box5']"));
		WebElement south_korea=driver.findElement(By.xpath("//div[@id='box105']"));
		
		act.dragAndDrop(rome, italy).perform();
		act.dragAndDrop(seoul, south_korea).perform();
		
		
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		
		WebElement ele=driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']"));
		driver.switchTo().frame(ele);
		
		WebElement pic1=driver.findElement(By.xpath("//img[@alt='The peaks of High Tatras']"));
		WebElement pic2=driver.findElement(By.xpath("//img[@alt='On top of Kozi kopka']"));
		
		WebElement trash=driver.findElement(By.xpath("//div[@id='trash']"));
		
		act.dragAndDrop(pic1, trash).perform();
		act.dragAndDrop(pic2, trash).perform();
		
		
		driver.get("https://demo.opencart.com");
		
		WebElement desktops=driver.findElement(By.xpath("//a[text()='Desktops']"));
		
		WebElement mac1=driver.findElement(By.xpath("//a[text()='Mac (1)']"));
		
		act.moveToElement(desktops).moveToElement(mac1).click().perform();
		
		Thread.sleep(3000);
		driver.close();

	}

}
