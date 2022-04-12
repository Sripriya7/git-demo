package EndToEnd.SeleniumProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base{
	private static Logger log = LogManager.getLogger(HomePage.class.getName());
	WebDriver driver;
	@BeforeMethod
	public void intialise() throws IOException
	{
		driver= IntializeDriver();
		log.info(BrowserName +"Is Initialised");
		//System.out.println(prop.getProperty("url"));
		String url= prop.getProperty("url");
		driver.get(url);
		log.info(url +"url entered");
	}
	@Test (dataProvider="getdata")
	public void  basePageNavigation(String userName,String password,String text) throws IOException, InterruptedException
	{
		System.out.println(System.getProperty("user.dir"));
		LandingPage lp = new LandingPage(driver);
		log.info("object created for landing page");
		Thread.sleep(1000);
		log.info("Waited for 1000ms");
		Actions actions = new Actions(driver);
		actions.moveToElement(lp.clickOnLink()).click().perform();
		log.info("popup closed"); 
		LoginPage l = lp.getLogin();
		//actions.moveToElement(lp.getLogin()).click().perform();
		log.info("Navigated to login page "); 
		l.getEmailID().sendKeys(userName);		
		log.info("Email Id entered for" +text); 
		l.getPassword().sendKeys(password);
		log.info("password entered for" +text); 
		log.info(text);
		//actions.moveToElement(l.getLoginButton()).click().perform();
		l.getLoginButton().click();	
		log.info("Clicked on login button ");
		String alertText=l.getAlert().getText();
		//softAssertion();
		Assert.assertEquals(alertText, "Invalid email or password.", "Strings are not equal");
		ForgotPassword Fp= l.getForgotPassword();
		log.info("navigated to forgot passsword page ");
		Fp.getEmailID().sendKeys("emailid");
		log.info("Email id entered ");
		Fp.getSendMeInstruction().click();
		log.info("Clicked on instruction button");
//		if(alertText.equalsIgnoreCase("Invalid email or password."))
//		{
//			softAssertion();
//     		softAssert.assertTrue(false, "not working");
//			log.info("test execution is completed even after assertion is failed ");
//		}
	}
	@DataProvider
	public Object[][] getdata()
	{
		Object[][] data = new Object[2][3];
		data[0][0]= "nonresticteduser.com";
		//log.info("email1");
		data[0][1]= "password";
		//log.info("password1");
		data[0][2]= "non restricted user";
	//	log.info("text 1");
		data[1][0]= "resticteduser.com";
		//log.info("email2");
		data[1][1]= "password";
		//log.info("password2");
		data[1][2]= "restricted user";
		//log.info("text 2");
		return data;
	}
	@AfterMethod
	public void Close()
	{
		getClose();
		log.info(BrowserName +"window is closed");
	}
	

}
