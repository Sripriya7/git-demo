package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="user_email")
	private WebElement emailId;
	@FindBy(id="user_password")
	private WebElement password;
	@FindBy(css="input[name='commit']")
	private WebElement loginButton;
	private @FindBy(css="a[href*='password/new/index.php']")
	WebElement forgotPassword;
	@FindBy(xpath="//div[contains(text(),'Invalid email or password.')]")
	private WebElement alert;
	public WebElement  getEmailID()
	{
		return emailId;
	}
	public WebElement  getPassword()
	{
		return password;
	}
	public WebElement  getLoginButton()
	{
		return loginButton;
	}
	public ForgotPassword  getForgotPassword()
	{
		forgotPassword.click();
		ForgotPassword Fp = new ForgotPassword(driver);
		return Fp;
	}
	public WebElement  getAlert()
	{
		return alert;
	}
	

}
