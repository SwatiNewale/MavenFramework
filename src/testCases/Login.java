package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import utility.ReadingUserDataFromExcel;

public class Login 
{
	LoginPage lp; //enabled=false priority=1
	@Test(priority=1,dataProvider="sendData")
	public void login(String Uname, String Passwd) throws IOException
	{
		if(ReadingUserDataFromExcel.isTCPresent("LoginTest"))
		{
			lp = new LoginPage(); 
			Assert.assertTrue(lp.dologin(Uname,Passwd));	
		}
	}
		
	@DataProvider 
	public Object[][] sendData() throws IOException
	{
		return (ReadingUserDataFromExcel.readTCdata("LoginTest"));
	}
	
	/*@Before
	public void xyz() 
	{
		
	}*/
}
