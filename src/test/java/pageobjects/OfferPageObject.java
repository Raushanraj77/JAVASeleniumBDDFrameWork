package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OfferPageObject {

public WebDriver driver;
	
	public OfferPageObject(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//Locators
	
	By search = By.xpath("//*[@id=\"search-field\"]");
	By productName = By.cssSelector("tr td:nth-child(1)");
	
	//Methods
	public void searchItem(String name)
	{
		driver.findElement(search).sendKeys(name);
	}
	
	
	public String getProduct()
	{
		return driver.findElement(productName).getText();
	}
	
	public void getItem()
	{
		driver.findElement(search).getText();
	}
}
