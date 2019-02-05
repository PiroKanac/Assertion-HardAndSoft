package verify;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Compare {
	//Methods needs to be static in order to be called by class
	//Verify URL
	
						// TEST 1  Validate current URL
	public static boolean validateURL(WebDriver driver, String expURL) {
		
		boolean result = false;
		if(driver.getCurrentUrl().equalsIgnoreCase(expURL)) {
			result = true;
		}
		
		return result;
	}
	
						// TEST 2  Validate current Page Title
	public static boolean validatePageTitle(WebDriver driver, String expTitle) {
		
		boolean result = false;
		if(driver.getTitle().equalsIgnoreCase(expTitle)) {
			result = true;
		}
		
		return result;
	}
	
						// TEST 3  Validate that Element Exists
	// Can copy code and just change element locator
	public static boolean validateElementExists1(WebDriver driver, String xpath) {
		
		boolean result = false;
		
		try {
			driver.findElement(By.xpath(xpath));
			result = true;
		} catch(Exception e) {
			
		}
		
		return result;
	} 
	
	// For all elements
						// TEST 4  Validate that any type of Element Exists
	public static boolean validateElementExists2(WebDriver driver, String locType, String locValue) {
		
		boolean result = false;
		
		try {
			if(locType.equalsIgnoreCase("xpath")) {
				driver.findElement(By.xpath(locValue));
			}
			else if(locType.equalsIgnoreCase("id")){
				driver.findElement(By.id(locValue));
			}
			else if(locType.equalsIgnoreCase("name")){
				driver.findElement(By.name(locValue));
			}
			result = true;
		} catch(Exception e) {
			
		}
		
		return result;
	}
	
						// TEST 5  Validate Text present on Element
	public static boolean validateTextPresentOnElement(WebDriver driver, String locType, String locValue, String expText) {
		
		boolean result = false;
		String actValue = "";
		
		try {
			if(locType.equalsIgnoreCase("xpath")) {
				actValue = driver.findElement(By.xpath(locValue)).getText();
			}
			else if(locType.equalsIgnoreCase("name")) {
				actValue = driver.findElement(By.name(locValue)).getText();
			}
			else if(locType.equalsIgnoreCase("id")) {
				actValue = driver.findElement(By.id(locValue)).getText();
			}
			
			if(actValue.equals(expText)) {
				result = true;
			}
		}
		catch(Exception e) {
		}
		return result;
	}
	
						// TEST 6  Validate Text present on Element with String
	public static String verifyTextPresentOnElement(WebDriver driver, String locType, String locValue) {
		
		String actValue = "";
		
		try {
			if(locType.equalsIgnoreCase("xpath")) {
				actValue = driver.findElement(By.xpath(locValue)).getText();
			}
			else if(locType.equalsIgnoreCase("name")) {
				actValue = driver.findElement(By.name(locValue)).getText();
			}
			else if(locType.equalsIgnoreCase("id")) {
				actValue = driver.findElement(By.id(locValue)).getText();
			}
			
		}
		catch(Exception e) {
		}
		return actValue;
	}
	
						// TEST 7  Validate any Text on current Page
	public static boolean validateTextOnPage(WebDriver driver, String expValue) {
		
		boolean result = false;
		if(driver.getPageSource().contains(expValue)) {
			result = true;
		}
		return result;
	}
	
						// TEST 8  Validate Attribute
	public static boolean validateAttribute(WebDriver driver, String locType, String locValue, String attributeName, String expValue) {
		
		boolean result = false;
		String value = "";
		
		try {
			
			if(locType.equalsIgnoreCase("xpath")) {
				value = driver.findElement(By.xpath(locValue)).getAttribute(attributeName);
			}
			else if(locType.equalsIgnoreCase("id")) {
				value = driver.findElement(By.id(locValue)).getAttribute(attributeName);
			}
			else if(locType.equalsIgnoreCase("name")) {
				value = driver.findElement(By.name(locValue)).getAttribute(attributeName);
			}
			
			if(value.equalsIgnoreCase(expValue)) {
				result = true;
			}
			
		}
		catch(Exception e) {}
		return result;
	}
	
						// TEST 9  Validate Element Visibility, also can verify if it is Enabled or Checked
	public static boolean validateElementVisibility(WebDriver driver, String locType, String locValue) {
		
		boolean result = false;
		try {
			
			if(locType.equalsIgnoreCase("xpath")) {
				result = driver.findElement(By.xpath(locValue)).isDisplayed();
			}
			else if(locType.equalsIgnoreCase("id")) {
				result = driver.findElement(By.id(locValue)).isDisplayed();
			}
			else if(locType.equalsIgnoreCase("name")) {
				result = driver.findElement(By.name(locValue)).isDisplayed();
			}
		}
		catch(Exception e) {}
		return result;
		
	}
	
}
