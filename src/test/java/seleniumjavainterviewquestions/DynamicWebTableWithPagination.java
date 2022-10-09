package seleniumjavainterviewquestions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicWebTableWithPagination {
	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.opencart.com/admin/index.php");
		driver.manage().window().maximize();

		WebElement username=driver.findElement(By.xpath("//input[@name='username']"));
		username.sendKeys("demo");
		
		WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys("demo");
		
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
		driver.switchTo().alert().dismiss();
		option.addArguments("--disable-notifications");
		
//		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//a[@class='parent']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Orders')]")).click();
		
		//find how many tables in pages
		String text=driver.findElement(By.xpath("//div[contains(text(),'Showing 1 to 10 of 171 (18 Pages)')]")).getText();
		
		//find the number of how many pages
//		  text= showing 1 to 20 of 8511 (426 Pages);
//		  text.indexOf("(");
//		  text.indexOf("Pages");
//		  int total_pages=Integer.valueOf(.substring(text.indexOf("(")+1, text.indexOf("Page")-1));
		
//		for(int p=1;p<=total_pages;p++) {
//			driver.findElement(By.xpath("//ur[@class='pagination']//li//span"));
//			System.out.println("Active Page:"+active_page.getText());
//			active_page.click();
//			
//			int rows=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']")).size();
//			System.out.println("Number of rows: "+rows);
//			
//			//read all rows from each page
//			for(int r=1;r<=rows;r++) {
//				String orderID=driver.findElement(By.xpath("//table[@class='table table-bordered table hover']//tbody//tr[1]//td[2]")).getText();
//				String customerName=driver.findElement(By.xpath("//table[@class='table table-bordered table hover']//tbody//tr[1]//td[3]")).getText();
//				String status=driver.findElement(By.xpath("//table[@class='table table-bordered table hover']//tbody//tr[1]//td[3]")).getText();
//				
//				if(status.equals("Pending")) {
//					System.out.println(orderID+"      "+customerName+"       "+status);
//				}
//			}
//			
//			//xpath find all pages 
//			String pageno=Integer.toString(p+1)
//			driver.findElement(By.xpath("//ul[@class='pagination']//li//a[text(),='"+pageno+"']")).click();
//		}
		
		

//		driver.close();
	}

}
