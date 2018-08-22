package repository;

import org.openqa.selenium.By;

public class LocatorRepository
{
	// login page
	public final By compnayid=By.id("companyid");
	public final By usernamefield=By.id("userid");
	public final By passwordfield=By.name("password");
	
	public final By loginbtn=By.id("button");
	public final By logoutbtn=By.xpath("//nav[1]/div[1]/ul[1]/li[5]/a[1]/i[1]");
	public final By errormsg=By.id("messages");
	
	public final By unexcepteddialg=By.xpath("//div[@id='notification-modal']/div[@role='dialog']/div[1]/div[1]/button[1]");
	
	// home page 
	public final By Flightlink=By.xpath("//a[text()='FLIGHT ']");
	public final By Hotellink=By.xpath("//a[text()='HOTEL ']");
	public final By Carlink=By.xpath("//a[text()='CAR ']");

	
	// Flight
	public final By fromcity=By.cssSelector("#fromCity");
	public final By tocity=By.cssSelector("#toCity");
	public final By fromcity_item=By.cssSelector(".ui-menu-item");
	public final By tocity_item=By.cssSelector(".ui-menu-item");
	
	public final By fromdate=By.cssSelector("#fromDate");
	public final By todate=By.cssSelector("#toDate");
	public final By calendertitle=By.cssSelector(".ui-datepicker-title");
	public final By nextbutton=By.xpath("//span[text()='Next']");
	public final By DepartureOutbound=By.id("departTimeWindow");
	
	
	public final By departime=By.id("departTimeWindow");
	public final	By returntime=By.id("returnTimeWindow");
	public final By searchbtn=By.xpath("//div[4]/div[1]/button[text()='Search']");
	
}
