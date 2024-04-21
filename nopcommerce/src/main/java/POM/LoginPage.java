package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import Helper.Base;

public class LoginPage extends Base {

	@FindBy(name = "Email")
	WebElement emailidTextBox;
	@FindBy(name = "Password")
	WebElement PasswordTextBox;
	@FindBy(xpath="//button[text()='Log in']")
	WebElement loginButton;
	
	public WebElement getEmailidTextBox() {
		return emailidTextBox;
	}
	public WebElement getPasswordTextBox() {
		return PasswordTextBox;
	}
	public WebElement getLoginButton() {
		return loginButton;
	}
	

}

