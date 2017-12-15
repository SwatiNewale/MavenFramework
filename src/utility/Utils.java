package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Utils {
	public static WebDriver driver = null;
	public static Properties conf;

	
	public static  WebDriver OpenBrowser() throws IOException
	{
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\resources\\Object_Repository\\configuration.properties");
		conf = new Properties();
		conf.load(ip);
		System.out.println("swati");

		if(conf.getProperty("browserName").equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\AllThirdPartyDrivers\\chromedriver.exe");
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
		return driver;
	}
}
