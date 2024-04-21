package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ActivityLog {
	@FindBy(xpath="(//i[@class='right fas fa-angle-left '] )[4]")
	WebElement CustomerRightbutton;
	@FindBy(xpath="(//i[@class='nav-icon far fa-dot-circle'])[17]")
	WebElement CusActLogBtn;
	@FindBy(xpath="//i[@class='far fa-angle-down']")
	WebElement ActRightButton;
	@FindBy(name="IpAddress")
	WebElement IpAddressTxtBox;
	@FindBy(id="search-log")
	WebElement searchBtn;
	public WebElement getActRightButton() {
		return ActRightButton;
	}

	public WebElement getCusActLogBtn() {
		return CusActLogBtn;
	}

	public WebElement getCustomerRightbutton() {
		return CustomerRightbutton;
	}

	public WebElement getIpAddressTxtBox() {
		return IpAddressTxtBox;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	
	

}
