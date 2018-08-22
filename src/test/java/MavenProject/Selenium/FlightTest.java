package MavenProject.Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commonLib.BaseTest;
import utility.ConstantVariables;

public class FlightTest 
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

	@Test(description="flight book sceanrio 1")
	public void test1()
	{
		LoginPage loginpage = new LoginPage(driver);
		String title=loginpage.validLogin(ConstantVariables.companyid,ConstantVariables.username, ConstantVariables.password,
				ConstantVariables.homepagetitle);
		Assert.assertTrue(title.contains(ConstantVariables.homepagetitle),"fail to login");
		loginpage.popup();		
		HomePage homepage = new HomePage(driver);
		homepage.flightBook();
		FlightBooking flight = new FlightBooking(driver);
		flight.bookTicket(ConstantVariables.fromcity_partial, ConstantVariables.fromcity,
				ConstantVariables.tocity_partial, ConstantVariables.tocity);
		flight.selectfromdate(ConstantVariables.start_month,ConstantVariables.start_date);
		flight.selecttodate(ConstantVariables.end_month,ConstantVariables.end_date);
		flight.selectdeparttime(ConstantVariables.departime);
		flight.selectreturntime(ConstantVariables.returtime);
		String flag=flight.search(ConstantVariables.searchreultpagetitle);
		Assert.assertTrue(flag.contains(ConstantVariables.searchreultpagetitle),"Fail to navigate search");
		loginpage.logout(ConstantVariables.loginpagetitle);
	}
	
	@Test(description="flight book sceanrio 1 ", enabled=true, priority=1 	)
	public void test2()
	{
		LoginPage loginpage = new LoginPage(driver);
		String title=loginpage.validLogin(ConstantVariables.companyid,ConstantVariables.username, ConstantVariables.password,
				ConstantVariables.homepagetitle);
		Assert.assertTrue(title.contains(ConstantVariables.homepagetitle),"fail to login");
		loginpage.popup();		
		HomePage homepage = new HomePage(driver);
		homepage.flightBook();
		FlightBooking flight = new FlightBooking(driver);
		flight.bookTicket(ConstantVariables.fromcity_partial, ConstantVariables.fromcity,
				ConstantVariables.tocity_partial, ConstantVariables.tocity);
		flight.selectfromdate(ConstantVariables.start_month,ConstantVariables.start_date);
		flight.selecttodate(ConstantVariables.end_month,ConstantVariables.end_date);
		flight.selectdeparttime(ConstantVariables.departime);
		flight.selectreturntime(ConstantVariables.returtime);
		String flag=flight.search(ConstantVariables.searchreultpagetitle);
		Assert.assertTrue(flag.contains(ConstantVariables.searchreultpagetitle),"Fail to navigate search");
		loginpage.logout(ConstantVariables.loginpagetitle);
	}

}
