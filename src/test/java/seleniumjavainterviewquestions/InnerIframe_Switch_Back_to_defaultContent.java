package seleniumjavainterviewquestions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InnerIframe_Switch_Back_to_defaultContent {
	public static void main(String[] args) throws InterruptedException {
		
		//note: frame = iframe = form
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");

		driver.switchTo().frame("iframeResult");	//outer frame
		
		driver.switchTo().frame(0);		//inner frame
		String innerText=driver.findElement(By.xpath("//h1")).getText();
		System.out.println(innerText);
		
		driver.switchTo().parentFrame();
		String outerText=driver.findElement(By.xpath("//p[contains(text(), 'You can use the height and width attributes to specify the size of the iframe:')]")).getText();
		System.out.println(outerText);

		
		Thread.sleep(2000);
		driver.close();
	}

}
