package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class hooks {
	public static WebDriver driver;
	
	 @Before
	    public void beforeScenario(){
		 System.setProperty("webdriver.gecko.driver","C:\\Users\\IBMADMIN\\Desktop\\Selenium_Udemy\\Eclipse\\geckodriver-v0.29.0-win64\\geckodriver.exe");
		   driver=new FirefoxDriver();
		 
		
		 
	    } 
	 
	 @After
	    public static void afterScenario(){
	        System.out.println("This will run after the Scenario");
	        driver.quit();
	    }
	

}
