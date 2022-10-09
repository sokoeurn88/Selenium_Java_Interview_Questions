package seleniumjavainterviewquestions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataBase_Testing {

	public static void main(String[] args) throws AWTException, SQLException {
		
		//data
		String cust_firstname="Sokoeurn";
		String cust_lastname="chhay";
		String cust_email="john@gmail.com";
		String cust_telPhone="1234567890";
		String cust_password="john123";
		
		//user registration
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("http://localhost/opencart/upload/");
		
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		
		
		driver.findElement(By.name("firstname")).sendKeys("cust_firstname");
		driver.findElement(By.name("lastname")).sendKeys("cust_lastname");
		driver.findElement(By.name("email")).sendKeys("cust_email");
		driver.findElement(By.name("telephone")).sendKeys("cust_telPhone");
		driver.findElement(By.name("password")).sendKeys("cust_password");
		driver.findElement(By.name("confirm")).sendKeys("cust_password");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		
		
		String confmsg=driver.findElement(By.xpath("h1[text()='Your Account Has Been Created!']")).getText();
		try {
			if(confmsg.equals("Your Account Has Been Created!")) {
				System.out.println("successful Registration");
			} else {
				System.out.println("Please try again!");
			}
			
		}
		 catch(Exception e) {
			 
			 System.out.println("Some problem in the application");
			
		}
		
		
		//Data base validation
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/openshop", "root", "");
		
		Statement stmt=con.createStatement();
		
		//create query
		String query="select firstname,lastname,email,telephone from oc_customer";
		
		ResultSet rs=stmt.executeQuery(query);
		
		boolean status=false;
		
		while(rs.next()) {
			
			String firstname=rs.getString("firstname");
			String lastname=rs.getString("lastname");
			String email=rs.getString("email");
			String telephone=rs.getString("telephone");
			
			if(cust_firstname.equals(firstname) && cust_lastname.equals(lastname)
					&& cust_email.equals(email) && cust_telPhone.equals(telephone)) {
				
				System.out.println("Record found in table || Test Passed");
				status=true;
				break;
				
			}
			
		}
		
		
		if(status==false) {
			
			System.out.println("Record Not Found || Test Failed");
			
			
		}
		
	
	}

}
