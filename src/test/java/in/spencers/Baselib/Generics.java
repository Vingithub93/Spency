package in.spencers.Baselib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Generics {
	
	public static WebDriverWait wait;
	public static Actions act;
	
	public static void visibilityofElement(WebDriver driver, WebElement element)
	{
		wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void moveToElement(WebDriver driver, WebElement element)
	{
		act = new Actions(driver);
		act.moveToElement(element).perform();
	}
}
