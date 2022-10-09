package seleniumjavainterviewquestions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCheckBox {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://itera-qa.azurewesites.net/home/automation");
		
		//select specific check box
		driver.findElement(By.xpath("//input[@id='monday']")).click();
		
		//select all check boxes, need to write x-path that match to all check boxes
		List<WebElement> checkboxes=driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
		System.out.println(checkboxes.size());
		
		for(int i=0;i<checkboxes.size();i++) {
			checkboxes.get(i).click();
		}
		
		for(WebElement chbox:checkboxes) {
			chbox.click();
		}
		
		//select multiple check box by choice
		
		for(WebElement chbox1:checkboxes) {
			String values=chbox1.getAttribute("id");
			
			if(values.equals("monday") || values.equals("sunday")) {
				chbox1.click();
			}
		}
		
		//select last 2 check boxes
		int totalcheckboxes=checkboxes.size();
		for(int i=totalcheckboxes-2;i<=checkboxes.size();i++) {
			checkboxes.get(i).click();
		}
		
		//select first 3 check boxes
		for(int i=0;i<totalcheckboxes;i++) {
			
			if(i<3) {
				checkboxes.get(i);
			}
			
			
		}
		
		
		
		
		
		
		

	}

}
