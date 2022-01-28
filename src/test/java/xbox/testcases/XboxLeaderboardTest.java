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

public class XboxLeaderboardTest extends TestCaseBase {

	@Test(groups = {"ChromeWin32"})
	public void open() throws InterruptedException {
		XboxLeaderboardPage leader = new XboxLeaderboardPage();
		//CustomAssertion assertion = new CustomAssertion();
		leader.open();
		leader.waitPage();
		Assert.assertTrue(leader.titleIs(leader.TITLE));
		
		// Verify Gamer scores
		Assert.assertTrue(leader.verifyTop5Gamers());
	}
	
}
