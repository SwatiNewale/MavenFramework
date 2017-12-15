package pageObjects;

import java.io.IOException;

import org.testng.Assert;

import MAINPage.Master;

public class LoginPage extends Master {
	
		// 1. login
		// 2. forgot password
		// 3. create new user
		
	public LoginPage() throws IOException {
		super();
	}
	public  boolean dologin(String userName, String Password)
	{
		sendKeys("userName_TxtBox", userName);
		sendKeys("password_TxtBox", Password);
		click("login_btn");
		return (isLinkPresent("home_hyperLnk"));
			
	/*	driver.findElement(By.xpath("//input[@id='email']")).sendKeys("SeleniumForSure@gmail.com");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("Password_123");

		driver.findElement(By.xpath("//label[@id='loginbutton']")).click();
	*/
			
		}
	public void doRecentLogin(){
		if(driver.getPageSource().contains("Recent logins")){
		click("recentLogin");
		}else{
			System.out.println("No Recents Account");
		}
	}
	public boolean newUserEntry(){
		/*String actualTitle = "There is a limit on how short first names or surnames can be on Facebook.";
		String expectedTitle ="There is a limit on how short first names or surnames can be on Facebook.";
		Assert.assertEquals(actualTitle, expectedTitle,"This should ruun...."); //if tc fails nextline code fails and next method will execute
		*/
		sendSignUPFirstNameSingleAlphabet("A");
		sendSignUPFirstName("Sonam");
		sendSignUPLastNameSingleAlphabet("S");
		sendSignUPLastName("Sathe");
		sendSignUPDOBValues();
		sendSignUPGender();
		signUPSendClick();
		
		return (isLinkPresent("home_hyperLnk"));

	}
		
	public boolean ChkforgotPassword()
		{
			click("forgetLink");
			//return new find_A_Flight(driver);
			String PageTitle = driver.getTitle();
			return (isPageOpen(PageTitle));
		}

}
