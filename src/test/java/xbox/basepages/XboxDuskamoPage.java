package xbox.basepages;

//import org.openqa.selenium.*;
//import org.testng.Assert;
//import org.testng.annotations.*;
import util.FunctionUtil;
import util.Page;
import util.SystemUtil;
//import util.SystemUtil;
import util.TestCaseBase;
//import util.TestData;
import util.Waiting;

import java.util.Properties;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class XboxDuskamoPage extends Page {
	
	public static String TITLE = "Duskamo - Xbox Gamertag";
	Properties PROPERTIES_RESOURCES = SystemUtil
			.loadPropertiesResources("/testdata_xbox.properties");
	
	// Web Elements
	@FindBy(linkText = "Duskamo")
	public WebElement pageLoad;
	
	@FindBy(linkText  = "League of Legends")
	public WebElement topgame1;
	
	@FindBy(linkText  = "Fortnite")
	public WebElement topgame2;
	
	@FindBy(linkText  = "DARK SOULS™ II")
	public WebElement topgame3;
	
	@FindBy(linkText  = "Skyrim")
	public WebElement topgame4;
	
	@FindBy(linkText  = "Assassin's Creed Revelations")
	public WebElement topgame5;

	
	public XboxDuskamoPage open() {
		String URL = PROPERTIES_RESOURCES.getProperty("xbox.url.base");
		TestCaseBase.threadDriver.get().navigate().to(URL);
		return this;
	}
	
	public XboxDuskamoPage waitPage() throws InterruptedException {
		Waiting.implicitly(2);
		return this;
	}
	
	public boolean verifyTopGame1() {
		//String browserFlag = TestCaseBase.browserFlag;
		boolean result = false;
		
		if (FunctionUtil.isExist(topgame1)) {
			result = true;
		} 
		else { result = false; }
		
		log.info("top game #1 verified? "+result);
		
		return result;
	}
	
	public boolean verifyTopGame2() {
		//String browserFlag = TestCaseBase.browserFlag;
		boolean result = false;
		
		if (FunctionUtil.isExist(topgame2)) {
			result = true;
		} 
		else { result = false; }
		
		log.info("top game #2 verified? "+result);
		
		return result;
	}
	
	public boolean verifyTopGame3() {
		//String browserFlag = TestCaseBase.browserFlag;
		boolean result = false;
		
		if (FunctionUtil.isExist(topgame3)) {
			result = true;
		} 
		else { result = false; }
		
		log.info("top game #3 verified? "+result);
		
		return result;
	}
	
	public boolean verifyTopGame4() {
		//String browserFlag = TestCaseBase.browserFlag;
		boolean result = false;
		
		if (FunctionUtil.isExist(topgame4)) {
			result = true;
		} 
		else { result = false; }
		
		log.info("top game #4 verified? "+result);
		
		return result;
	}
	
	public boolean verifyTopGame5() {
		//String browserFlag = TestCaseBase.browserFlag;
		boolean result = false;
		
		if (FunctionUtil.isExist(topgame5)) {
			result = true;
		} 
		else { result = false; }
		
		log.info("top game #5 verified? "+result);
		
		return result;
	}
	
	
}
