package in.spencers.Testscript;

import org.testng.annotations.Test;

import in.spencers.Baselib.BaseClass;
import in.spencers.Baselib.BaseTest;
import in.spencers.Baselib.Excel;

public class CheckTitle extends BaseTest{
	
	@Test
	public void checkTitle()
	{
		BaseClass bc = new BaseClass(driver);
		String eTitle=Excel.getCellvalue("verifyTitle", 1, 0);
		System.out.println(eTitle);
		bc.verifyTitle(Excel.getCellvalue("verifyTitle", 1, 0));
	}
	
	

}
