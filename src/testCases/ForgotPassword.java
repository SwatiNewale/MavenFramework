package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.LoginPage;


public class ForgotPassword {
	LoginPage lp;
	@Test()
	public void forgotPassword() throws IOException{
		lp = new LoginPage();
		lp.ChkforgotPassword();
	}
}
