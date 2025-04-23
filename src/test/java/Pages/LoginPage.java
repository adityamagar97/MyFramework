package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	@FindBy (xpath = "//*[@id=\"login-username\"]") WebElement email;
	@FindBy (xpath = "//*[@id=\"login-password\"]") WebElement passw;
	@FindBy (xpath = "//*[@id=\"login-remember\"]") WebElement click;
	@FindBy (xpath = "//*[@id=\"login_form\"]/div[5]/div/button") WebElement login;
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	
	public void ema(String em) {
	
		email.sendKeys(em);
		
	}
	
	public void pas(String pa) {
	
		passw.sendKeys(pa);
		
	}
	
	public void cli() {
	
		click.click();
		
	}
	
	public void log() {
	
		login.click();
		
	}
	
	public void condition() {
	
		
		
	}
	
	
	
	
	
}
