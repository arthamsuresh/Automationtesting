package stepDefinition;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import utilities.hooks;

public class stepDefinition {
	
//public static WebDriver driver;

WebDriver driver = hooks.driver;
public WebDriverWait wait;


	
	@Then("^I verify the Fail in step$")
	public void i_verify_the_Fail_in_step()  {
	    // Write code here that turns the phrase above into concrete actions
		
		
	    
	}
	
	@Given("^Launch the browser$")
	public void launch_the_browser()  {

   
		driver.get(" http://elearningm1.upskills.in/");
		
	    
	}

	@Given("^click on signup link$")
	public void click_on_signup_link()  {
	    // Write code here that turns the phrase above into concrete actions
		
		driver.findElement(By.linkText("Sign up!")).click();
	    
	}

	@When("^enter signup details$")
	public void enter_signup_details()  {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^signup successful$")
	public void signup_successful()  {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("registration_submit")).click();
		
		driver.findElement(By.className("alert alert-warning")).getText();
	    
	}
/*
	@Then("^close the  browser$")
	public void close_the_browser()  {
	    // Write code here that turns the phrase above into concrete actions
	    
	} */

	@When("^enter signup details \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and click on Register button$")
	public void enter_signup_details_and_click_on_Register_button(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11)  {
	    // Write code here that turns the phrase above into concrete actions
	   
	driver.findElement(By.id("registration_submit")).click();
		
	}
	
	
	@Then("^User validates Registration details$")
	public void user_validates_Registration_details(DataTable dt) throws Throwable {
		Map<String,String> list=dt.asMap(String.class,String.class);

		wait = new WebDriverWait(driver,20);

		wait.until(

                ExpectedConditions.presenceOfElementLocated(By.xpath("//li[contains(text(),'Registration')]")));

		String actual2 = driver.findElement(By.xpath("//*[contains(text(),'Dear')]")).getText();

		Assert.assertTrue("Validate message is present", actual2.contains("Dear "+list.get("FirstName")+" "+list.get("LastName")));

		String actual = driver.findElement(By.xpath("//*[text()='Your personal settings have been registered.']")).getText();

		Assert.assertTrue("Validate message is present", actual.contains("Your personal settings have been registered."));

		String actual1 = driver.findElement(By.xpath("//*[text()='An e-mail has been sent to remind you of your login and password.']")).getText();

		Assert.assertEquals("An e-mail has been sent to remind you of your login and password.", actual1);

		driver.findElement(By.xpath("//a[@href='#']/img")).click();

		String actualMail = driver.findElement(By.xpath("//li[@class='user-header']//a/following-sibling::p")).getText();

		Assert.assertEquals(list.get("EMail"),actualMail.trim());
		
	}

	@Then("^User sends an email \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void user_sends_an_email(String toMailId, String subject, String message) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	   
		
		driver.findElement(By.xpath("//a[@title='Inbox']")).click();

		wait = new WebDriverWait(driver,10);

		wait.until(

                ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Profile')]")));

		driver.findElement(By.xpath("//img[@title='Compose message']")).click();

		String firstThreeLetters=toMailId.substring(0, 3);

		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(firstThreeLetters);

		driver.findElement(By.xpath("//ul[@id='select2-compose_message_users-results']/li[text()='"+toMailId+"']")).click();

		

		driver.findElement(By.cssSelector("input#compose_message_title")).sendKeys(subject);

		WebElement frameElement = driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));

		driver.switchTo().frame(frameElement);

		

		driver.findElement(By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")).click();

		driver.findElement(By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")).sendKeys(message);

		driver.switchTo().defaultContent();

		driver.findElement(By.cssSelector("button#compose_message_compose")).click();
		
		
		
	}

	@Then("^User validates success message \"([^\"]*)\"$")
	public void user_validates_success_message(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^User logouts from the application$")
	public void user_logouts_from_the_application() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}





}
