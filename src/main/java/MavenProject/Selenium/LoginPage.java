package MavenProject.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import commonLib.ReusableMethods;
import repository.LocatorRepository;

public class LoginPage 
{
	WebDriver driver;
	ReusableMethods res;
	LocatorRepository repo;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		res = new ReusableMethods(driver);
		// create locator repository object using page factory approach
		repo=PageFactory.initElements(driver, LocatorRepository.class);
	}
	
	private void typecompnayid(String value)
	{
		res.sendKeysToElement(repo.compnayid, value);
	}	
	
	private void typeUsername(String value)
	{
		res.sendKeysToElement(repo.usernamefield, value);
	}
	
	private void typepassword(String value)
	{
		res.sendKeysToElement(repo.passwordfield, value);
	}
	
	private void clickOnLogin()
	{
		res.clickOnElement(repo.loginbtn);
	}
	
	public String validLogin(String companyid,String username, String password, String title)
	{
		typecompnayid(companyid);
		System.out.println("compnay id passed ");
		typeUsername(username);
		System.out.println("user id passed ");
		typepassword(password);
		System.out.println("password id passed ");
		clickOnLogin();
		res.explictwait_title(title);
		return res.GetpageTitle();
	}
	
	public String inValidLogin(String companyid,String username, String password, String error)
	{
		typecompnayid(companyid);
		typeUsername(username);
		typepassword(password);
		clickOnLogin();
		res.explictwait_locator(repo.errormsg);
		return res.getElementText(repo.errormsg);
	}
	
	public void popup()
	{
		res.popuphanlder(repo.unexcepteddialg);
	}
	
	public String logout(String logintitle)
	{
		res.clickUsingJS(repo.logoutbtn);
		res.explictwait_title(logintitle);
		return res.GetpageTitle();
	}
}
