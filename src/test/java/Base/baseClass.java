package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Pages.RegisterPage;

public class baseClass {
	
public	WebDriver driver;
	public RegisterPage rp;
	
	
	@BeforeMethod
	void setup() {
		
		driver = new ChromeDriver();
		driver.get("https://javabykiran.in/other/CC/register");
		rp = new RegisterPage(driver);
		
	}
	
	@AfterMethod
	void end() {
	//driver.close();
	}

}
