package Utilities;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Helper.Base;
import POM.LoginPage;

public class Utility extends Base{
	public  void adminLogin(String Username,String pwd) {
		LoginPage lp=PageFactory .initElements(this.driver, LoginPage.class);
		lp.getEmailidTextBox().clear();
		lp.getEmailidTextBox().sendKeys(Username);
		lp.getPasswordTextBox().clear();
		lp.getPasswordTextBox().sendKeys(pwd);
		lp.getLoginButton().click();
		}

}
