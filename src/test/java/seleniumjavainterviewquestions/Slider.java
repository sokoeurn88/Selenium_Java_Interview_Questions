package seleniumjavainterviewquestions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Slider {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI");
		driver.manage().window().maximize();
		
		WebElement mini_slider=driver.findElement(By.xpath("//span[@style='left: 0%;']"));
		System.out.println("mini slider location: "+mini_slider.getLocation());
		System.out.println("mini slider size: "+mini_slider.getSize());
		
		Actions act=new Actions(driver);
		act.dragAndDropBy(mini_slider, 150, 0).perform();
		
		System.out.println("after mini slider location: "+mini_slider.getLocation());
		
		WebElement max_slider=driver.findElement(By.xpath("//span[@style='left: 100%;']"));
		System.out.println("max slider loation:"+max_slider.getLocation());
		System.out.println("max slider size:"+max_slider.getSize());
		
		act.dragAndDropBy(max_slider, -100, 0).perform();
		
		System.out.println("after decrease max slider loation:"+max_slider.getLocation());

		
		
		
	
	}

}
