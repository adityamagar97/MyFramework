package Base;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.testng.Assert;

import org.testng.annotations.Test;

import Utilities.ExtentManager;
import Utilities.provide;



public class RegisterPages extends baseClass {
	
	ExtentReports extent;
	ExtentTest test; 
	
	@BeforeTest
	public void startReport() {
		extent = ExtentManager.getReportObject(); // report path is already set to src/test/resources/reports
	}
	@Test (dataProvider = "regis", dataProviderClass = provide.class)
	void run(String ti,String na,String su,String em,String ph,String mo,String pa,String co,String conditio) {
		
		test = extent.createTest("Register Test for: " + na + " " + su); // log per dataset
		
		rp.tit(ti);
		rp.nam(na);
		rp.sur(su);
		rp.ema(em);
		rp.pho(ph);
		rp.mob(mo);
		rp.pas(pa);
		rp.cop(co);
		rp.tick();
		rp.regis();
		
		if(conditio.equals("Valid")) {
			AssertJUnit.assertEquals(driver.findElement(By.xpath("//*[@id=\"main_content\"]/h2")).getText(),"Your Account" );
			System.out.println("Test Passed for VALID data: ");
		}
		else if(conditio.equals("invalid")) {
			AssertJUnit.assertEquals(driver.getTitle(),"Register" );
			System.out.println("Test Passed for INVALID data ");
		}
		else if(conditio.equals("blank")) {
			AssertJUnit.assertEquals(driver.getTitle(),"Register" );
			System.out.println("Test Passed for Blank Data data");
		}
		else if(conditio.equals("LongEmail")) {
			try {
			    String actualError = driver.findElement(By.xpath("//*[@id='email-error']")).getText();
			    String expectedError = "Please enter a vaasslid email address.";
			    Assert.assertEquals(actualError, expectedError);
			    test.pass("Test Passed for Longemail");
			} catch (AssertionError e) {
			    test.fail("Test Failed for Longemail:\nExpected: Please enter a valid email address.\nBut was: " 
			              + driver.findElement(By.xpath("//*[@id='email-error']")).getText());
			    throw e;
			}

		}
	}
	
	
	@AfterTest
	public void flushReport() {
		extent.flush();
	}
	

}
