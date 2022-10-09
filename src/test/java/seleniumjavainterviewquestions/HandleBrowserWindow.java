package seleniumjavainterviewquestions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBrowserWindow {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.opensource-demo.orangehrmlive.com/");
		
//		String windowID=driver.getWindowHandle(); 		//will return a window id
//		System.out.println(windowID);
		
		driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
		
		Set<String> windowIDs=driver.getWindowHandles();  	//will return Set<String>
		Iterator<String>it=windowIDs.iterator();
		
		String parentWindowID=it.next();
		String childWindowID=it.next();
		
		System.out.println(parentWindowID);
		System.out.println(childWindowID);
		
		//HOW TO USE WINDOW ID FOR SWITCHING
		driver.switchTo().window(parentWindowID);
		System.out.println("Parent Window Title: "+driver.getTitle());
		
		driver.switchTo().window(childWindowID);
		System.out.println("Child Window Title: "+ driver.getTitle());
		
		
		for(String windowID2: windowIDs) {
			String title=driver.switchTo().window(windowID2).getTitle();
			System.out.println(title);
		}
		
		driver.close();  	//close single browser window
		driver.quit(); 		//close all windows
		
		for(String windowID3: windowIDs) {
			String title1=driver.switchTo().window(windowID3).getTitle();
			if(title1.equals("OrangeHRM") || title1.equals("Another Window Title")) {
				driver.close();
			}
		}
	}

}
