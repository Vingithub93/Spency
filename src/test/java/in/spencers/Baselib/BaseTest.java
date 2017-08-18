package in.spencers.Baselib;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import in.spencers.Pageobject.SelectCityPopupPO;
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
		try{
			 driver.manage().window().maximize();
		}
		catch(Exception exe)
		{
			
		}
		
	 driver.get("https://www.spencers.in");
		
	}
	
	@BeforeMethod
	public void selectCity()
	{
		
		SelectCityPopupPO scp= new SelectCityPopupPO(driver);
		scp.clickSelectCity();
		scp.selectCity(Excel.getCellvalue("selectCity", 4, 0));
		scp.enterPincode(Excel.getCellvalue("selectCity", 4, 1));
		scp.clickSubmitBTN();
		
	}
	
	@AfterTest
	public void postCondition() throws Exception
	{
		Thread.sleep(3000);
//		driver.close();
		
	}

}
