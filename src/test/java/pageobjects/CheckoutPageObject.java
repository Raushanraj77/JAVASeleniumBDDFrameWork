package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutPageObject {
	
	public WebDriver driver;
	
	public CheckoutPageObject(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//Locators
	private By cartBag = By.cssSelector("[alt='Cart']");
	private By checkoutButton = By.xpath("//button[contains(text(), 'PROCEED TO CHECKOUT')]");
	private By promoBtn = By.cssSelector(".promoBtn");
	private By placeOrder = By.xpath("//button[contains(text(), 'Place Order')]");
	private By checkoutProduct = By.xpath("//*[@id=\"productCartTables\"]/tbody/tr/td[2]/p");
	
	//Methods
	
	public void CheckoutItems()
	{
		driver.findElement(cartBag).click();
		driver.findElement(checkoutButton).click();
	}
	
	public boolean VerifyPromoBtn()
	{
		return driver.findElement(promoBtn).isDisplayed();
	}
	
	public boolean VerifyPlaceOrder()
	{
		return driver.findElement(placeOrder).isDisplayed();
	}
	
	public String getCheckoutProductName()
	{
		return driver.findElement(checkoutProduct).getText();
	}
}
