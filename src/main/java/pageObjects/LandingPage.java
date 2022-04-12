package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver ;
	
	private By loginLink = By.cssSelector("a[href*='sign_in']");
	private By thanksLink	= By.xpath("//input[@type='text']//following::div[4]");
	private By text = By.xpath("//h2[contains(text(),'Featured Courses')]");
	private By homeMenubar = By.xpath("//div[@role='navigation']/div[1]/nav/ul");
	private By headerText = By.xpath("//div[@class='carousel-caption']/div/div[1]/h3");
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}


	public LoginPage getLogin()
	{
		driver.findElement(loginLink).click();
		LoginPage l=new LoginPage(driver);
		return l;
		
	}
	
	public WebElement clickOnLink()
	{
		return driver.findElement(thanksLink);
	}
	public WebElement getFeaturedText()
	{
		return driver.findElement(text);
	}
	public WebElement getHomeMenubar()
	{
		return driver.findElement(homeMenubar);
	}
	public WebElement getHeaderText()
	{
		return driver.findElement(headerText);
	}

}
