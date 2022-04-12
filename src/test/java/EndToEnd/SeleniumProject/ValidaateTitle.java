package EndToEnd.SeleniumProject;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class ValidaateTitle extends Base{
	private static Logger log = LogManager.getLogger(ValidaateTitle.class.getName());
	WebDriver driver;
	LandingPage lp;
	@BeforeClass
	public void intialise() throws IOException
	{
		driver= IntializeDriver();
		log.info(BrowserName +"Is Initialised");
		//System.out.println(prop.getProperty("url"));
		driver.get(prop.getProperty("url"));
		log.info("url entered");
		lp = new LandingPage(driver);
	}
	@Test 
	public void  validatetitle() throws IOException, InterruptedException
	{
		
		Thread.sleep(1000);
		Assert.assertTrue(lp.clickOnLink().isDisplayed(), "element not found");
		log.info("popup is displayed and close icon is displayed  ");
		Assert.assertTrue(lp.clickOnLink().isEnabled(), "element not enabled");
		log.info("close link at popup is enabled");
		Actions actions = new Actions(driver);
		actions.moveToElement(lp.clickOnLink()).click().perform();
		log.info("popup is clossed");
		Assert.assertEquals( "FEATURED COURSES",lp.getFeaturedText().getText());
		log.info("Text is " +lp.getFeaturedText().getText());
		Assert.assertTrue(lp.getHomeMenubar().isDisplayed());
		log.info("navigation bar is displayed");
		//SoftAssert softAssert = new SoftAssert();	
//		softAssertion();
//        softAssert.assertTrue(false, "not working");
//		log.info("test execution is completed even after assertion is failed ");
	}
	@Test
	public void  validateHeader()
	{
		//lp = new LandingPage(driver);
		log.info("2nd test");
		log.info(lp.getHeaderText().getText());
		Assert.assertEquals(lp.getHeaderText().getText(),"AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		log.info("header is found" +lp.getHeaderText().getText());
	}
	@AfterClass
	public void Close()
	{
		getClose();
		log.info(BrowserName +"window is closed");
	}
	
	

}
