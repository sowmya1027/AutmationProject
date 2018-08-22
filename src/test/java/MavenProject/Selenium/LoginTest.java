package MavenProject.Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commonLib.BaseTest;
import utility.ConstantVariables;


public class LoginTest 
{
	WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		BaseTest basetest = new BaseTest();
		// pass baseurl and browser info to base test and driver will be 
		// invoked and returned and assigned to current GV-driver;
		driver=basetest.selectBrowser(ConstantVariables.browsername, ConstantVariables.baseurl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.manage().deleteAllCookies();
		driver.quit();
	}
	
	@Test(description="Validate login with valid data")
	public void test1()
	{
		LoginPage loginpage = new LoginPage(driver);
		String title=loginpage.validLogin(ConstantVariables.companyid,ConstantVariables.username, ConstantVariables.password,
				ConstantVariables.homepagetitle);
		Assert.assertTrue(title.contains(ConstantVariables.homepagetitle),"fail to login");
	}
	
	@Test(description="Validate login with In-valid data")
	public void test2()
	{
		LoginPage loginpage = new LoginPage(driver);
		String err=loginpage.inValidLogin(ConstantVariables.companyid,ConstantVariables.username, ConstantVariables.wrongpassword, 
				  ConstantVariables.errormsg);
		Assert.assertTrue(err.contains(ConstantVariables.errormsg),"something worng happened");
	}
	
	@Test(description="login and logout end to end scenarios ")
	public void test3()
	{
		LoginPage loginpage = new LoginPage(driver);
		String title=loginpage.validLogin(ConstantVariables.companyid,ConstantVariables.username, ConstantVariables.password,
				ConstantVariables.homepagetitle);
		Assert.assertTrue(title.contains(ConstantVariables.homepagetitle),"fail to login");
		loginpage.popup();
		loginpage.logout(ConstantVariables.loginpagetitle);
	}
	
}
