package MavenProject.Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commonLib.BaseTest;
import commonLib.ExcelLib;
import utility.ConstantVariables;

public class DataDrivernTest 
{
WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		BaseTest basetest = new BaseTest();
		driver=basetest.selectBrowser(ConstantVariables.browsername, ConstantVariables.baseurl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.manage().deleteAllCookies();
		driver.quit();
	}
	

	@Test(description="Validate login with In-valid data")
	public void test2()
	{
		LoginPage loginpage = new LoginPage(driver);
		ExcelLib lib = new ExcelLib();
		int rc=lib.getrowcount(ConstantVariables.filepath, ConstantVariables.sheetname);
		System.out.println("rowcount is " + rc);
		for(int i=1;i<=rc;i++)
		{
			String companyid=lib.readexceldata(ConstantVariables.filepath, ConstantVariables.sheetname, i, 0);
			String username=lib.readexceldata(ConstantVariables.filepath, ConstantVariables.sheetname, i, 1);
			String password=lib.readexceldata(ConstantVariables.filepath, ConstantVariables.sheetname, i, 2);
			
			String err=loginpage.inValidLogin(companyid,username,password,ConstantVariables.errormsg);
			Assert.assertTrue(err.contains(ConstantVariables.errormsg),"something worng happened");
		}
		
		
	}
	

	
}
