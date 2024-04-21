package Utilities;

import java.io.IOException;

import org.testng.annotations.Test;

import Helper.Base;

public class NewTest extends Base{
  @Test
  public void adminLoginWithvalidCread() throws IOException {
	  Utility util=new Utility();
	  
	util.adminLogin(this.getTestData("login",1,0), this.getTestData("login",1,1));
	  
  }
}
