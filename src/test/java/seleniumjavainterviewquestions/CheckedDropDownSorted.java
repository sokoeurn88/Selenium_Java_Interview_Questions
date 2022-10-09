package seleniumjavainterviewquestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckedDropDownSorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("#twotabsearchtextbox")).click();
		driver.findElement(By.xpath("//select[@id='searchDropdownBox']")).click();
		
		WebElement dropElement = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
		Select seldrop=new Select(dropElement);
		List<WebElement> valueofseldrop=seldrop.getOptions();
		
		ArrayList originallist=new ArrayList();
		ArrayList templist=new ArrayList();
		
		
		for(WebElement option: valueofseldrop) {
			
			originallist.add(option.getText());
			templist.add(option.getText());
			
		}
		
		System.out.println(templist);
		
		Collections.sort(templist);
		Collections.sort(originallist);
		System.out.println(templist.size());
		System.out.println(templist);
		
		
		if(templist.equals(originallist)) {
			System.out.println("Dropdown is sorted...");
		} else {
			System.out.println("Dropdown is unsorted...");
		}
		
		
		
		

	}

}
