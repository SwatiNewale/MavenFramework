package MAINPage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Master {
	public WebDriver driver;
	public Properties conf;
	public Properties locator;

	public Master() throws IOException{
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\resources\\Object_Repository\\configuration.properties");
		conf = new Properties();
		conf.load(ip);

		FileInputStream locatorsFIS = new FileInputStream(System.getProperty("user.dir")+"\\resources\\Object_Repository\\locators.properties");
		locator = new Properties();
		locator.load(locatorsFIS);

		if(conf.getProperty("browserName").equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\AllThirdPartyDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if(conf.getProperty("browserName").equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if (conf.getProperty("browserName").equals("IE")) 
		{
			// initialize IE driver
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com");	
	}
	public void sendKeys(String xpathKey,String userData)
	{
		driver.findElement(By.xpath(locator.getProperty(xpathKey))).sendKeys(userData);	
	}

	public void click(String xapthKey)
	{
		driver.findElement(By.xpath(locator.getProperty(xapthKey))).click();	
	}
	public boolean isPageOpen(String pageTitle){
		  return (driver.getTitle().contentEquals(pageTitle)); 
		  
	}
	public void chkRecentAccountsAvailableOrNot(){
		
	}

	public boolean isLinkPresent(String xpathKey)
	{
		try{
			driver.findElement(By.xpath(locator.getProperty(xpathKey)));
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	//FirstName	with One Word
	public void sendSignUPFirstName(String fname){
			driver.findElement(By.xpath(locator.getProperty("signeUp_fName"))).sendKeys(fname);
	}
	public void sendSignUPFirstNameSingleAlphabet(String fname){
		driver.findElement(By.xpath(locator.getProperty("signeUp_fName"))).sendKeys(fname);
		
			
	}
	//Lastname		

	public void sendSignUPLastNameSingleAlphabet(String lname){
		driver.findElement(By.xpath(locator.getProperty("signeUp_fName"))).sendKeys(lname);
	}
	public void sendSignUPLastName(String lname){
		driver.findElement(By.xpath(locator.getProperty("signeUp_fName"))).sendKeys(lname);
	}
	//Mobile or emailId

	public void sendSignUPMobile(String lname){
		driver.findElement(By.xpath(locator.getProperty("signeUp_mobNoEmailId"))).sendKeys("9175829319");
	}
	//Mobile or Passwod
	public void sendSignUPPassword(String lname){
		driver.findElement(By.xpath(locator.getProperty("signeUp_fName"))).sendKeys(lname);
	}
	 //For DOB

	public void sendSignUPDOBValues(){
		driver.findElement(By.xpath(locator.getProperty("signeUp_newPassword"))).sendKeys("Swati_1234");
		WebElement DayDropDown = driver.findElement(By.xpath(locator.getProperty("signeUp_dobDay")));
		Select  day= new Select(DayDropDown);
		day.selectByValue("10");
		
		WebElement MonthDropDown = driver.findElement(By.xpath(locator.getProperty("signeUp_dobMonth")));
		Select  month= new Select(MonthDropDown);
		month.selectByIndex(8);
		
		WebElement YearDropDown = driver.findElement(By.xpath(locator.getProperty("signeUp_dobYear")));
		Select  year= new Select(YearDropDown);
		year.selectByValue("1990");
	}
	//for gender
		public void sendSignUPGender(){
			driver.findElement(By.xpath(locator.getProperty("signeUp_GenderRadioFemale"))).click();
		}
	//for submitButton
		public void signUPSendClick(){
		driver.findElement(By.xpath(locator.getProperty("signeUp_SubmitBTN"))).click();
		}

}
