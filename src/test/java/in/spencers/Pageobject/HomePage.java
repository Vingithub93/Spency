package in.spencers.Pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import in.spencers.Baselib.BaseClass;
import in.spencers.Baselib.Generics;

public class HomePage extends BaseClass{
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="login-icon")
	private WebElement signinIcon;
	
	public void moveTosigninIcon()
	{
		Generics.visibilityofElement(driver, signinIcon);
		Generics.moveToElement(driver, signinIcon);
	}

}
