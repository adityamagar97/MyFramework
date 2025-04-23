package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Pages.LoginPage;
import Pages.RegisterPage;

public class baseClass {
	
public	WebDriver driver;
	public RegisterPage rp;
	public LoginPage lp ;
	
	
	@BeforeMethod
	void setup() {
		
		driver = new ChromeDriver();
	driver.get("https://javabykiran.in/other/CC/register");//Register 
		//driver.get("https://javabykiran.in/other/CC/login");
		rp = new RegisterPage(driver);
		lp = new LoginPage(driver);
		
	}
	
	@AfterMethod
	void end() {
	//driver.close();
	}

}
