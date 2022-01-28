package xbox.basepages;

//import org.openqa.selenium.*;
//import org.testng.Assert;
//import org.testng.annotations.*;
import util.Page;
import util.SystemUtil;
import util.TestCaseBase;
import util.Waiting;

import java.util.Properties;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class XboxHomePage extends Page {
	
	public static String TITLE = "Xbox Gamertag";
	Properties PROPERTIES_RESOURCES = SystemUtil
			.loadPropertiesResources("/testdata_xbox.properties");
	
	// Web Elements
	@FindBy(css = ".bg-white.container.home-container.p-4 > form[method='post'] > input[name='s']")
	public WebElement searchBar;
	@FindBy(css = "form[method='post'] > input[value='Search']")
	public WebElement searchButton;
	
	public XboxHomePage open() {
		String URL = PROPERTIES_RESOURCES.getProperty("xbox.url.base");
		TestCaseBase.threadDriver.get().navigate().to(URL);
		return this;
	}
	
	public XboxHomePage waitPage() throws InterruptedException {
		Waiting.implicitly(2);
		return this;
	}
	
	public XboxHomePage searchGamertag(String s) {
		searchBar.clear();
		searchBar.sendKeys(s);
		
		return this;
	}
	
	public XboxDuskamoPage gotoXboxGamertagProfilePage() {
		searchButton.click();
		
		return new XboxDuskamoPage();
	}
	
}
