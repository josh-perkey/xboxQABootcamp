package xbox.basepages;

//import org.openqa.selenium.*;
//import org.testng.Assert;
//import org.testng.annotations.*;
import util.FunctionUtil;
import util.Page;
import util.SystemUtil;
import util.TestCaseBase;
import util.TestData;
import util.Waiting;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;

public class XboxLeaderboardPage extends Page {
	
	public static String TITLE = "Xbox Leaderboards - Xbox Gamertag";
	
	// Web Elements
	@FindAll({
		@FindBy(tagName="p")
	})
	protected List<WebElement> allGamerScores;
	protected final List<String> verifyValues = new ArrayList<String>();
	Properties PROPERTIES_RESOURCES = SystemUtil
			.loadPropertiesResources("/testdata_xbox.properties");
	
	public XboxLeaderboardPage open() {
		String URL = PROPERTIES_RESOURCES.getProperty("xbox.url.leaderboard");
		TestCaseBase.threadDriver.get().navigate().to(URL);
		return this;
	}
	
	public XboxLeaderboardPage waitPage() throws InterruptedException {
		Waiting.implicitly(2);
		return this;
	}
	
	public boolean verifyTop5Gamers() {
		//String browserFlag = TestCaseBase.browserFlag;
		boolean result = true;
		verifyValues.add(PROPERTIES_RESOURCES.getProperty("xbox.top.gamer.1"));
		verifyValues.add(PROPERTIES_RESOURCES.getProperty("xbox.top.gamer.2"));
		verifyValues.add(PROPERTIES_RESOURCES.getProperty("xbox.top.gamer.3"));
		verifyValues.add(PROPERTIES_RESOURCES.getProperty("xbox.top.gamer.4"));
		verifyValues.add(PROPERTIES_RESOURCES.getProperty("xbox.top.gamer.5"));
		System.out.println(verifyValues);
		
		for(int i=0; i<5; i++)
		{
			WebElement ii = allGamerScores.get(i);
			String gs = ii.getText();
			//System.out.println("================");
			if(!gs.equals(verifyValues.get(i))) { 
				result = false; 
				//System.out.println(gs + " != " + verifyValues.get(i));
				break;
			}
			//System.out.println("================");
		}
		
		log.info("Top 5 Gamerscores Verified?: "+result);
		
		return result;
	}
	
	
	
}
