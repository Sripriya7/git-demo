package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.asserts.SoftAssert;


public class Base {
	public WebDriver driver;
	public Properties prop;
	 public String BrowserName;
	public SoftAssert softAssert;
	@SuppressWarnings("deprecation")
	public WebDriver IntializeDriver() throws IOException {
		// TODO Auto-generated method stub
		//Write code like when browser value changes browser in all test cases should change 
		//so for that we need data driven parameterization from properties file 
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/resources/data.properties");
        prop.load(fis);
     BrowserName = prop.getProperty("browser"); //this command will used to get the browser name from properies file 
       // BrowserName = System.getProperty("browser"); // this command is used to get the browser details from maven from maven comand "mvn test -Dbrowser=chrome" and we integrate browser types to jenkin. 
        if(BrowserName.contains("chrome"))
        {
        	//System.out.println(System.getProperty("user.dir")+"/src/main/java/resources/chromedriver");
        	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/java/resources/chromedriver");
        	ChromeOptions options = new ChromeOptions();
        	if(BrowserName.contains("headless"))
        	{
        	options.addArguments("headless");
        	}
        	driver = new ChromeDriver(options);
        }
        else if(BrowserName.contains("firefox"))
        {
        	System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/java/resources/geckodriver");
        	FirefoxOptions options = new FirefoxOptions();
        	if(BrowserName.contains("headless"))
        	{
        		options.addArguments("headless");
        	}
        	driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver ;  
      
	}
	public String getTimeStamp() {
	    String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	    return timestamp;
	}
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException

	{

	TakesScreenshot ts=(TakesScreenshot) driver;

	File source =ts.getScreenshotAs(OutputType.FILE);

	String destinationFile = System.getProperty("user.dir") + "/reports/" + testCaseName +getTimeStamp()+ "png";
	FileUtils.copyFile(source,new File(destinationFile));

	return destinationFile;

	}

	  public void getClose()
      {
      	driver.quit();
      }
	  public void softAssertion()
	  {
		  softAssert = new SoftAssert();
	  }

}
