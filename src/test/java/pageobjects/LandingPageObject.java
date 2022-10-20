package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LandingPageObject {
	
	public WebDriver driver;
	
	public LandingPageObject(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//Locators
	private By search = By.xpath("//input[@type=\"search\"]");
	private By productName = By.cssSelector("h4.product-name");
	private By dealLink = By.xpath("//*[@id=\"root\"]/div/header/div/div[3]/a[2]");
	private By incrementBtn = By.cssSelector("a.increment");
	private By addToCart = By.cssSelector(".product-action button");
	
	//Methods
	
	public LandingPageObject verifyLandingPageTitle(String expectedTitle)
	{
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		return null;
	}
	
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
	
	public void selectDealsPage()
	{
		driver.findElement(dealLink).click();
	}
	
	public void incrementQuantity(int quantity)
	{
		int i = quantity - 1;
		while(i>0)
		{
			driver.findElement(incrementBtn).click();
			i--;
		}
	}
	
	public void addToCart()
	{
		driver.findElement(addToCart).click();
	}
}
