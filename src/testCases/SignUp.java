package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.LoginPage;


public class SignUp {	
	
	LoginPage lp;
	@Test()
	public void SignUp() throws IOException{	
		 lp = new LoginPage();
	lp.newUserEntry();
	}

}
