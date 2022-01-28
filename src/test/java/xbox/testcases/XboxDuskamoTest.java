package xbox.testcases;

//import org.openqa.selenium.*;
//import org.testng.Assert;
//import org.testng.annotations.*;
import util.FunctionUtil;
import util.Page;
import util.SystemUtil;
import util.TestCaseBase;
import util.TestData;
import util.Waiting;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Properties;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;
import xbox.basepages.*;

public class XboxDuskamoTest extends TestCaseBase {

	@Test(groups = {"ChromeWin32"})
	public void open() throws InterruptedException {
		// Open browser, go to home page, and verify home page is open
		XboxHomePage xboxHome = new XboxHomePage();
		xboxHome.open();
		xboxHome.waitPage();
		Assert.assertTrue(xboxHome.titleIs(xboxHome.TITLE));
		
		// Search for user and verify correct user page is open
		Properties PROPERTIES_RESOURCES = SystemUtil
				.loadPropertiesResources("/testdata_xbox.properties");
		String gamertag = PROPERTIES_RESOURCES.getProperty("xbox.gamertag");
		xboxHome.searchGamertag(gamertag);
		XboxDuskamoPage xboxDuskamo = xboxHome.gotoXboxGamertagProfilePage();
		Assert.assertTrue(xboxDuskamo.titleIs(xboxDuskamo.TITLE));
		
		// Verify titles
		Assert.assertTrue(xboxDuskamo.verifyTopGame1());
		Assert.assertTrue(xboxDuskamo.verifyTopGame2());
		Assert.assertTrue(xboxDuskamo.verifyTopGame3());
		Assert.assertTrue(xboxDuskamo.verifyTopGame4());
		Assert.assertTrue(xboxDuskamo.verifyTopGame5());
	}
	
}
