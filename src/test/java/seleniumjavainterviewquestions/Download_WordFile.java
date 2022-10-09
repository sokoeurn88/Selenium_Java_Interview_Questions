package seleniumjavainterviewquestions;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Download_WordFile {

	public static void main(String[] args) {
		
		String location=System.getProperty("user.dir")+".\\Downloads";
		
		//chrome
//		HashMap preferences=new HashMap();
//		preferences.put("download.default_directory", location);
//		ChromeOptions options=new ChromeOptions();
//		options.addArguments("--disable-notifications");
//		options.setExperimentalOption("prefs", preferences);
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver(options);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.manage().window().maximize();
		
		//edge
		
//		HashMap preferences=new HashMap();
//		preferences.put("download.default_directory", location);
//		EdgeOptions options=new EdgeOptions();
//		options.addArguments("--disable-notifications");
//		options.setExperimentalOption("prefs", preferences);
//		WebDriverManager.edgedriver().setup();
//		WebDriver driver = new EdgeDriver(options);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.manage().window().maximize();
		
		//firefox driver
		
		FirefoxProfile profile=new FirefoxProfile();
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk",	"application/msword");
		profile.setPreference("Browser.download.dir", location);
		
		FirefoxOptions options=new FirefoxOptions();
		options.setProfile(profile);
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();

		driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/");		
		driver.switchTo().frame(0); 
		driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();
		
		
		
		

		
		driver.close();
	}

}
