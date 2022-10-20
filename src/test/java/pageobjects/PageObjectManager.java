package pageobjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	//Using pagefactory pattern for manage avoid object creation at test case level
	public LandingPageObject landingPageObject;
	public OfferPageObject offerPageObject;
	public CheckoutPageObject checkoutPageObject;
	public WebDriver driver;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public LandingPageObject getLandinPageObject()
	{
		landingPageObject = new LandingPageObject(driver);
		return landingPageObject;
	}
	
	public OfferPageObject getOfferPageObject()
	{
		offerPageObject = new OfferPageObject(driver);
		return offerPageObject;
	}
	
	public CheckoutPageObject getCheckoutPageObject()
	{
		checkoutPageObject = new CheckoutPageObject(driver);
		return checkoutPageObject;
	}

}
