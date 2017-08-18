package in.spencers.Pageobject;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import in.spencers.Baselib.BaseClass;
import in.spencers.Baselib.Generics;

public class SelectCityPopupPO extends BaseClass {
	
	public String idName;
	
	public SelectCityPopupPO(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="cityselect")
	private WebElement selectCity;
	
	public void clickSelectCity()
	{
		Generics.visibilityofElement(driver, selectCity);
		selectCity.click();
	}

	public void selectCity(String cityName)
	{
		idName=cityName.toLowerCase()+"txt";
		
		Select sc= new Select(selectCity);
		sc.selectByVisibleText(cityName);
	}
	
	@FindBy(xpath="//input[@class='pincode-input pincodetxt']")
	private java.util.List<WebElement> citiespin;
	
	public void enterPincode(String pincode)
	{
		
		for(WebElement we: citiespin)	
		{
			System.out.println(we.getAttribute("id"));
			if(we.getAttribute("id").equals(idName))
			{
				we.click();
				we.sendKeys(pincode);
			}
		}
	}
	
	@FindBy(id="pcpu_btnSubmit")
	private WebElement submitBTN;
	
	public void clickSubmitBTN()
	{
		submitBTN.click();
	}
	
}
