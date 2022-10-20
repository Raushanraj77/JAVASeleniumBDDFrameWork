package stepdefinitions;

import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageobjects.LandingPageObject;
import pageobjects.OfferPageObject;
import utils.GenericUtils;
import utils.TestContextSetup;

public class OfferPage {

	//globally creating webdriver variable to be available for all methods
	//public WebDriver driver;
	public String landingProductName;
	public String dealProductName;
	public OfferPageObject offerPageObject;
	public LandingPageObject landingPageObject;
	TestContextSetup testContextSetup;
	
	
	
	
	public OfferPage(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.offerPageObject = testContextSetup.pageObjectManager.getOfferPageObject();
		this.landingPageObject = testContextSetup.pageObjectManager.getLandinPageObject();
	}
	
	
	
	
	public void offerPage() {
		
		//if(!(testContextSetup.driver.getCurrentUrl().equals("https://rahulshettyacademy.com/seleniumPractise/#/offers")))
		//{
			//avoiding object creation with the help of page factory and constructor
		
		    landingPageObject.selectDealsPage();
			testContextSetup.genericUtils.SwitchWindowToChild();
			//testContextSetup.driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/div[3]/a[2]")).click();
		    /*
			Set<String> openWindows=testContextSetup.driver.getWindowHandles();
		    Iterator<String> it = openWindows.iterator();
		    String parentWindow =it.next();
		    String childWindow =it.next();
		    testContextSetup.driver.switchTo().window(childWindow);
		    */
		//} else 
		//{
		//	System.out.println("Already in offers page");
		//}
		
	}
	
	@Then("User searched for {string} shortname in offers page for Single Value")
	public void user_searched_for_same_shortname_in_offers_page_for_single_value(String shortName) throws InterruptedException {
	    offerPage();
	    //offerPageObject = testContextSetup.pageObjectManager.getOfferPageObject();
	    //OfferPageObject op = new OfferPageObject(testContextSetup.driver);
	    offerPageObject.searchItem(shortName);
	    //WebElement dealSearchBox =testContextSetup.driver.findElement(By.xpath("//*[@id=\"search-field\"]"));
	    //dealSearchBox.clear();
	    //dealSearchBox.sendKeys(shortName);
	    Thread.sleep(2000);
	    //WebElement dealProduct =testContextSetup.driver.findElement(By.cssSelector("tr td:nth-child(1)"));
	    dealProductName = offerPageObject.getProduct();
	    
	    
	}
	
	@Then("^User searched for (.+) shortname in offers page$")
	public void user_searched_for_tom_shortname_in_offers_page(String shortName) throws InterruptedException {
		offerPage();
		//offerPageObject = testContextSetup.pageObjectManager.getOfferPageObject();	    
		offerPageObject.searchItem(shortName);
	    
	    Thread.sleep(2000);
	    dealProductName = offerPageObject.getProduct();
	}
	
	@Then("Validate product name in offers page matches with landing page")
	public void Validate_product_name_in_offers_page()
	{
		Assert.assertEquals(dealProductName, testContextSetup.landingProductName);
		
	}
}
