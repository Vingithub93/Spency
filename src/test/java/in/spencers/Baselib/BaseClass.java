package in.spencers.Baselib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BaseClass {

	public WebDriver driver;
	
	public BaseClass(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void verifyTitle(String eTitle)
	{
		String aTitle=driver.getTitle();
		Assert.assertEquals(aTitle, eTitle);
	}
	
}
