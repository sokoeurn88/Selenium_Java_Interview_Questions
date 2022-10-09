package seleniumjavainterviewquestions;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Cookies {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		
		Set<Cookie> cookies=driver.manage().getCookies();
		System.out.println(cookies.size());
		
		for(Cookie ck:cookies) {
			String ckName=ck.getName();
			String ckValue=ck.getValue();
			System.out.println("All cookies are: "+ckName+" : "+ckValue);
		}
		
		//add cookie to browser
		Cookie cookieobj=new Cookie("MyCookies123", "987654321");
		driver.manage().addCookie(cookieobj);
		
		cookies=driver.manage().getCookies();
		System.out.println(cookies.size());
		
		for(Cookie ck:cookies) {
			String ckName=ck.getName();
			String ckValue=ck.getValue();
			System.out.println("All cookies are: "+ckName+" : "+ckValue);
		}
		
		//delete cookie by cookieobj
//		driver.manage().deleteCookie(cookieobj);
//		cookies=driver.manage().getCookies();
//		System.out.println(cookies.size());
//		
//		for(Cookie ck:cookies) {
//			String ckName=ck.getName();
//			String ckValue=ck.getValue();
//			System.out.println("All cookies are: "+ckName+" : "+ckValue);
//		}
		
		//delete cookie by cookieName
		driver.manage().deleteCookieNamed("MyCookies123");
		
		cookies=driver.manage().getCookies();
		System.out.println(cookies.size());
		
		for(Cookie ck:cookies) {
			String ckName=ck.getName();
			String ckValue=ck.getValue();
			System.out.println("All cookies are: "+ckName+" : "+ckValue);
		}
		
		
		//delete all cookies
		driver.manage().deleteAllCookies();
		
		cookies=driver.manage().getCookies();
		System.out.println(cookies.size());
		
		for(Cookie ck:cookies) {
			String ckName=ck.getName();
			String ckValue=ck.getValue();
			System.out.println("All cookies are: "+ckName+" : "+ckValue);
		}
		

	}

}
