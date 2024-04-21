package Helper;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;

public class Base {
  public static String propath="C:\\Users\\Windows\\eclipse-workspace\\nopcommerce\\src\\main\\resources\\Common\\Property.Properties";
  public static Properties pro;
  public static FileInputStream fis;
  public WebDriver driver;
  public String getproperty(String name) throws IOException {
	fis=new FileInputStream(propath);
	pro=new Properties();
	pro.load(fis);
	String data=pro.getProperty(name);
	
	return data;
	
	  
  }
  
  
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  String browser=this.getproperty("browser");
	  if(browser.equals("chrome")) {
		  System.setProperty("webdriver.chrome.driver", this.getproperty("chromepath"));
		  ChromeOptions option=new ChromeOptions();
		  option.addArguments("__disable-notifications");
		  driver=new ChromeDriver(option);
	  }
	  else if(browser.equals("firefox")) {
		  System.setProperty("webdriver.gecko.driver", this.getproperty("ffpath"));
		  FirefoxOptions option=new FirefoxOptions();
		  option.addPreference("dom.webnotifications.enabled",false);
		  driver=new FirefoxDriver(option);
	  }
	  driver.get(this.getproperty("url"));
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  }
		  
	  
	    

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
  
  public void takeScreenShots(String name)throws IOException{
	  EventFiringWebDriver ef=new EventFiringWebDriver(driver);
	  File f1=ef.getScreenshotAs(OutputType.FILE);
	  File f2=new File(this.getproperty("screenshotspath")+name+".png");
	  FileUtils.copyFile(f1, f2);
  }
  public String getTestData(String sheetname,int r, int c) throws IOException {
	  FileInputStream fis=new FileInputStream(this.getproperty("testdatapath"));
	  XSSFWorkbook wb=new XSSFWorkbook(fis);
	  XSSFSheet sheet=wb.getSheet(sheetname);
	  XSSFRow row=sheet.getRow(r);
	  XSSFCell cell=row.getCell(c);
	  String data=cell.getStringCellValue();
	  return data;
	  
  }



}		
