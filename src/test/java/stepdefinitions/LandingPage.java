package stepdefinitions;

import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageobjects.LandingPageObject;
import utils.TestBase;
import utils.TestContextSetup;

public class LandingPage {

	//globally creating webdriver variable to be available for all methods
	//public WebDriver driver;
	public String landingProductName;
	public String dealProductName;
	TestContextSetup testContextSetup;
	public LandingPageObject landingPageObject;
	
	
	public LandingPage(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.landingPageObject = testContextSetup.pageObjectManager.getLandinPageObject();
	}
	
	@Given("User is on GreenCart landing Page")
	public void user_is_on_green_cart_landing_page() {
		/*
	    System.setProperty("webdriver.chrome.driver", "/Users/maa/Projects/Eclipse/CucumberFramework/drivers/chromedriver");
	    testContextSetup.driver = new ChromeDriver();
	    testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	    */
		//landingPageObject = testContextSetup.pageObjectManager.getLandinPageObject();
		landingPageObject.verifyLandingPageTitle("GreenKart - veg and fruits kart");
				
		//lp.verifyLandingPageTitle("GreenKart");
		
	}
	
	@When("User searched with shortname {string} and extracted actual name of Product for Single Value")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product_for_single_value(String shortName) throws InterruptedException {
		
		//landingPageObject = testContextSetup.pageObjectManager.getLandinPageObject();
		landingPageObject.searchItem(shortName);
	    //WebElement searchBox = testContextSetup.driver.findElement(By.xpath("//input[@type=\"search\"]"));
	    //searchBox.clear();
	    //searchBox.sendKeys(shortName);
	    Thread.sleep(5000);
	    
	    String fullName = landingPageObject.getProduct();
	    testContextSetup.landingProductName=fullName.split("-")[0].trim();
	    System.out.println(testContextSetup.landingProductName);
	}
	
	@When("^User searched with shortname (.+) and extracted actual name of Product$")
	public void user_searched_with_shortname_tom_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
		//landingPageObject = testContextSetup.pageObjectManager.getLandinPageObject();
		landingPageObject.searchItem(shortName);	   
	    Thread.sleep(5000);
	    
	    String fullName = landingPageObject.getProduct();
	    testContextSetup.landingProductName=fullName.split("-")[0].trim();
	    System.out.println(testContextSetup.landingProductName);
	}
	
	@When("Added {string} items of the selected Product to cart")
	public void added_items_of_the_selected_product_to_cart(String shortName)
	{
		landingPageObject.incrementQuantity(Integer.parseInt(shortName));
		landingPageObject.addToCart();
	}
	
}
