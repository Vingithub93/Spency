package in.spencers.Testscript;

import org.testng.annotations.Test;

import in.spencers.Baselib.BaseTest;
import in.spencers.Pageobject.HomePage;

public class CheckTitle extends BaseTest{
	
	
	@Test
	public void moveToIcon()
	{
		HomePage hp =new HomePage(driver);
		hp.moveTosigninIcon();
	}

}
