package stepdefinitions;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.CheckoutPageObject;
import pageobjects.LandingPageObject;
import utils.TestBase;
import utils.TestContextSetup;

public class CheckoutPage {

	//globally creating webdriver variable to be available for all methods
	//public WebDriver driver;
	public CheckoutPageObject checkoutPageObject;
	public String checkoutProductName;
	TestContextSetup testContextSetup;
	
	
	public CheckoutPage(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.checkoutPageObject = testContextSetup.pageObjectManager.getCheckoutPageObject();
	}
	
	
	@Then("^User proceed to checkout and validate the (.+) items in checkout page$")
	public void user_proceed_to_checkout_and_validate_the_items_in_checkout_page(String shortName) throws InterruptedException {				
	    
		checkoutPageObject.CheckoutItems();
		
		checkoutProductName=checkoutPageObject.getCheckoutProductName().split("-")[0].trim();
	    System.out.println(checkoutProductName);
	    Assert.assertEquals(checkoutProductName, shortName);
	}
	@Then("^User has ability to enter promocode and place order$")
	public void user_has_ability_to_enter_promocode_and_place_order()
	{
		Assert.assertTrue(checkoutPageObject.VerifyPromoBtn());
		Assert.assertTrue(checkoutPageObject.VerifyPlaceOrder());
	}
}
