package seleniumjavainterviewquestions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavascriptUtil {
	
	public static void drawBorder(WebElement element, WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("arguments[0].style.border='3px solid red'", element);					//this method is not work,and I don't know why?
	}

//	public static String getTitleByJS(WebDriver driver) {
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		String title=js.executeScript("return document.title;").toString();
//		return title;
//	}
	
	
//	public static void clickElementByJS(WebElement element, WebDriver driver) {
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("argument[0].click();", element);
//	}
	
	
//	public static void generateAlert(WebDriver driver, String message) {
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("alert('" + message + "'");
//	}

	
	//	public static void refreshBrowserByJS(WebDriver driver) {
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("history.go(0)");
//	}

	//	public static void scrollPageDown(WebDriver driver) {
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
//	}
	
	
	//	public static void scrollPageUp(WebDriver driver) {
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
//	}
	
	
	//	public static void zoomPageByJS(WebDriver driver) {
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("document.body.style.zoom='50%'");
//	}
	
	
	public static void changeColor(String color, WebElement element, WebDriver driver) {
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("argument[0].style.backgroundColor = '" + color + "'", element);
//		
//		try {
//			Thread.sleep(20);
//		}catch(InterruptedException e) {
//			
//		}
	}
	
	
	public static void flash(WebElement element, WebDriver driver) {
		
//		JavascriptExecutor js =(JavascriptExecutor)driver;
//		element.getCssValue("backgroundColor");
//		
//		for(int i=0;i<10;i++) {
//			changeColor("#000000", element, driver);
//			changeColor(bgcolor, element,driver);
//		}
	}
	
	
	
	
}
