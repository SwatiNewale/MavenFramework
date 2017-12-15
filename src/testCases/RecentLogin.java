package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.LoginPage;


public class RecentLogin {
	LoginPage lp;
	@Test(enabled=false)
	public void doRecentLoginChkRecentAccounts() throws IOException{
		 lp = new LoginPage();
		 lp.doRecentLogin();
	}
	
	
}
