package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPassword {
	WebDriver driver;
	public ForgotPassword(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	private @FindBy(id="user_email")
	WebElement emailId;
	private @FindBy(css="input[value='Send Me Instruction']")
	WebElement sendMeInstruction;
	
	public WebElement  getEmailID()
	{
		return emailId;
	}
	public WebElement  getSendMeInstruction()
	{
		return sendMeInstruction;
	}
	
	

}
