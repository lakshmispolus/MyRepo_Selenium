package Pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.BaseClass;
import Utilities.ExcelRead;

public class LoginPage extends BaseClass {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"email\"]")
	private WebElement Usermail;

	@FindBy(xpath = "//*[@id=\"password\"]")
	private WebElement password;

	@FindBy(xpath = "//*[@id=\"signin-form\"]/button")
	private WebElement loginbtn;

	@FindBy(xpath = "//*[@id=\"user-dropdown\"]/span[2]")
	private WebElement username;

	@FindBy(id = "email-error")
	private WebElement Usermailerror;

	@FindBy(id = "password-error")
	private WebElement passworderror;


	public String mandatoryvalidations() {
		loginbtn.submit();
		String errormsg = Usermailerror.getText();
		String errormsg1 = passworderror.getText();
		if (errormsg.contentEquals(errormsg1)) {
			return errormsg;
		}
		return errormsg = null;

	}

	public String login(String usermail) throws IOException {
	//	Usermail.sendKeys(ExcelRead.readStringData(5, 1));
		Usermail.sendKeys(usermail);
		password.sendKeys(ExcelRead.readIntegerData(6, 1));
		loginbtn.submit();
		String userName = username.getText();
		return userName;

	}
	
}
