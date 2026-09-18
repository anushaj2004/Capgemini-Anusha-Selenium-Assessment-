package BaseClassUtility;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import PomUtilities.SauceDemoLoginPage;


public class BaseClassSauceDemo {
    protected WebDriver driver=null;
	@BeforeSuite
	public void bs()
	{
		System.out.println("open database connectivity");
	}
	@AfterSuite
	public void As()
	{
		System.out.println("close database connectivity");
	}
	@BeforeTest
	public void bt()
	{
		System.out.println("pre-conditions");
	}
	@AfterTest
	public void at()
	{
		System.out.println("post-conditions");
	}
	@BeforeClass
	public void bc()
	{
		driver = new ChromeDriver();
		System.out.println("launch the brower");
	}
	@AfterClass
	public void ac()
	{
		driver.quit();
		System.out.println("close the browser");
	}
	@BeforeMethod
	public void loginTest() throws IOException
	{
		FileInputStream file=new FileInputStream("./src/test/resources/DDT/SauceDemoLoginPage.properties");
		Properties p=new Properties();
		p.load(file);
		String BROWSER = p.getProperty("Browser");
		String URL=p.getProperty("url");
		String Username=p.getProperty("username");
		String Password=p.getProperty("password");
		if(BROWSER.contains("chrome"))
		{
			ChromeOptions settings = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<>();
			prefs.put("profile.password_manager_leak_detection", false);
			settings.setExperimentalOption("prefs", prefs);
			driver= new ChromeDriver(settings);
			
		}
		if(BROWSER.contains("edge"))
		{
			driver= new EdgeDriver();
		}
		if(BROWSER.contains("firefox"))
		{
			driver= new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(URL);
		SauceDemoLoginPage s=new SauceDemoLoginPage(driver);
		s.getUserName(Username);
		s.getPassword(Password);
		s.getLogin();
		
		 
	}
	
	
	@AfterMethod
	public void am()
	{
		System.out.println("logout execution");
	}
}
