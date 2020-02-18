package in.spencers.Baselib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import in.spencers.Pageobject.SelectCityPopupPO;

public class BaseClass {

	public WebDriver driver;
	
	public BaseClass()
	{
		PageFactory.initElements(driver, this);
	}
	
	@BeforeClass
	public void selectCity()
	{
		
		SelectCityPopupPO scp= new SelectCityPopupPO(driver);
		System.out.println("hello");
		scp.clickSelectCity();
		scp.selectCity(Excel.getCellvalue("selectCity", 4, 0));
		scp.enterPincode(Excel.getCellvalue("selectCity", 4, 1));
		scp.clickSubmitBTN();
		
	}
	
	public void verifyTitle(String eTitle)
	{
		String aTitle=driver.getTitle();
		Assert.assertEquals(aTitle, eTitle);
	}
	
}
