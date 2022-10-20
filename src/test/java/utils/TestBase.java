package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	public WebDriver driver;
	
	public WebDriver WebDriverManager() throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "//src//test//resources//config.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url =prop.getProperty("QAUrl");		
		
		String browser_properties = prop.getProperty("browser");
		String browser_maven = System.getProperty("browser");
		//use java ternary operator to check value getting from terminal or properties file and set it to variable
		// result = testcondition ? value1 : value2
		String browser = browser_maven != null ? browser_maven : browser_properties;
		
		// checking if condition to keep driver initialize only once for execution
		if(driver == null)
		{
			if(browser.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//test//resources//chromedriver");
			    driver = new ChromeDriver();			    
			}
			else if(browser.equalsIgnoreCase("ie"))
			{
				//need to implement
			}			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get(url);
		}
		return driver;		
	}
}
