package in.spencers.Baselib;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;

public abstract class BaseTest {
	
	public WebDriver driver;
	public DesiredCapabilities cap;

	@Parameters({"host", "browserName"})
	@BeforeTest
	public void preCondition(String host,String browserName) throws Exception
	{
	 if(!host.equals("nothing"))
	  {
		if(browserName.equals("firefox"))
		{
			FirefoxDriverManager.getInstance().setup();
			
		}
		else if (browserName.equals("chrome"))
		{
			ChromeDriverManager.getInstance().setup();
		}
		URL url =new URL(host);
		cap= new DesiredCapabilities();
		cap.setBrowserName(browserName);
		driver= new RemoteWebDriver(url, cap);
	  }
	  else
	  {
			if(browserName.equals("firefox"))
			{
				FirefoxDriverManager.getInstance().setup();
				driver=new FirefoxDriver();
			}
			else if (browserName.equals("chrome"))
			{
				ChromeDriverManager.getInstance().setup();
				driver= new ChromeDriver();
			}
			
			
	  }
		
	 driver.get("https://www.spencers.in");
		
	}
	
	@AfterTest
	public void postCondition()
	{
		driver.close();
		
	}

}
