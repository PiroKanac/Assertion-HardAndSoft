
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import verify.Compare;



	public class HelloSelenium {
		public static WebDriver driver;
		static String driverPath = "C:\\Users\\vnikolic\\Downloads\\Selenium";
		boolean result;
		@BeforeMethod
		public void setUp(){
			
			//    Open Chrome browser
			System.out.println("*******************");
			System.out.println("launching Chrome browser");
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\vnikolic\\Downloads\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize(); 
			driver.get("https://google.com");
		    System.out.println("Navigate to URL");
		}
		
//***************TC 001 - 009 are all types of Hard Assertion in which when step fail no further steps are executed******************
//***************TC 010 is a type of Soft Assertion in which when step fail execution continue******************		
								
					            // TEST 1  Validate current URL
	   @Test
	   public void TC_001() {
	       
		   
	        driver.findElement(By.name("q")).sendKeys("Hello Selenium!");
	        
	       // Verify URL
	        // First way
	       /* result =  Compare.validateURL(driver, "https://www.google.com/");
	        Assert.assertTrue(result, "[Error - Not Matching Actual URL with Expected URL]");*/
	        
	       // Second short way
	        Assert.assertTrue(Compare.validateURL(driver, "https://www.google.com/"), "[Error - Not Matching Actual URL with Expected URL]");
	        
	        System.out.println("Verify URL successfull");
	   }
	   
	   							// TEST 2  Validate current Page Title
	   @Test
	   public void TC_002() {
		   driver.findElement(By.name("q")).sendKeys("Hello Selenium!");
		   
		   result = Compare.validatePageTitle(driver, "Google");
		   System.out.println(driver.getTitle());
		   Assert.assertTrue(result, "[Error - This is Page Title mismatch]");
		   // Optimized solution
		   //Assert.assertTrue(Compare.validatePageTitle(driver, "Google"), "[Error - This is Page Title mismatch]");
	   }
	   
	   							// TEST 3  Validate that Element Exists
	   @Test
	   public void TC_003() {
		   //Compare Element exists for first type
		   driver.findElement(By.name("q")).sendKeys("Hello Selenium!");
		   result = Compare.validateElementExists1(driver, "//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input");
		   Assert.assertTrue(result, "ERROR - Not able to find out Element");
		   System.out.println(result);
		   
		   // Also can be optimized and we no longer need line 17
		   //Assert.assertTrue(Compare.validateElementExists(driver, "//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input"), "ERROR - Not able to find out Element");
	   }
	   
	   						  // TEST 4  Validate that any type of Element Exists
		 @Test
		 public void TC_004() {
			 
			  // Compate Element exists with second type for all elements
			   
			   driver.findElement(By.name("q")).sendKeys("Hello Selenium!");
			   result = Compare.validateElementExists2(driver, "name", "q");
			   Assert.assertTrue(result, "ERROR - No such Element");
			      
		 }
		 
		                     // TEST 5  Validate Text present on Element
		 @Test
		 public void TC_005() {
			 driver.findElement(By.name("q")).sendKeys("Hello Selenium!");
			 //String message = driver.findElement(By.xpath("//*[@id=\"gbw\"]/div/div/div[1]/div[1]/a")).getText();
			 //System.out.println(message);
			 boolean result = Compare.validateTextPresentOnElement(driver, "xpath", "//*[@id=\"gbw\"]/div/div/div[1]/div[1]/a", "Gmail");
			 Assert.assertTrue(result, "[ERROR - Text Not Matched]");
		 }
		 
		 
		                    // TEST 6  Validate Text present on Element with String
		 @Test
		 public void TC_006() {
			 driver.findElement(By.name("q")).sendKeys("Hello Selenium!");
			 String actResult = Compare.verifyTextPresentOnElement(driver, "xpath", "//*[@id=\"gbw\"]/div/div/div[1]/div[1]/a");
			 Assert.assertEquals(actResult, "Gmail", "[ERROR = Actual Text does not match with expected]");
		 }
		 
		 
		                  // TEST 7  Validate any Text on current Page
		 @Test
		 public void TC_007() {
			 driver.findElement(By.name("q")).sendKeys("Hello Selenium!");
			 boolean actResult =  Compare.validateTextOnPage(driver, "Gmail");
			 Assert.assertTrue(actResult, "[ERROR - Text Not found on Page]");
			 
		 }
		 
		 			     // TEST 8  Validate Attribute
		 @Test
		 public void TC_008() {
			 
			 driver.findElement(By.name("q")).sendKeys("Hello Selenium!");
			 boolean actResult = Compare.validateAttribute(driver, "xpath", "//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input", "class", "gLFyf gsfi");
			 Assert.assertTrue(actResult, "[ERROR - Attribute Tab index is not matched]");
		 }
		
		 				// TEST 9  Validate Element Visibility, also can verify if it is Enabled or Checked
		 @Test
		 public void TC_009() {
			 
			 driver.findElement(By.name("q")).sendKeys("Hello Selenium!");
			 boolean actResult = Compare.validateElementVisibility(driver, "xpath", "//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input");
			 Assert.assertTrue(actResult, "[ERROR - Element is not visible]");
		 }
		 
					// TEST 10  Validate Element Visibility with Soft Assertion
		 @Test
		 public void TC_010() {
		 
			 SoftAssert assertion = new SoftAssert();
			 //assert one fail
			 boolean actResult = Compare.validateElementVisibility(driver, "xpath", "//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input33");
			 assertion.assertTrue(actResult, "[ERROR - Element is not visible]");
			 driver.findElement(By.name("q")).sendKeys("Hello Selenium!");
			 //assert two pass
			 boolean actResult2 = Compare.validateElementVisibility(driver, "xpath", "//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input");
			 assertion.assertTrue(actResult2, "[ERROR - Element is not visible]");
			 
			 assertion.assertAll();
		 }
	   
	   
	   @AfterMethod
	   public void tearDown() {
		   //Closing Browser
	        driver.quit();
	        System.out.println("Closing Browser");
	}

}
