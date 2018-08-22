package MavenProject.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import commonLib.ReusableMethods;
import repository.LocatorRepository;

public class HomePage 
{
	WebDriver driver=null;
	ReusableMethods res;
	LocatorRepository repo;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		res = new ReusableMethods(driver);
		repo=PageFactory.initElements(driver, LocatorRepository.class);
	}

	public void flightBook()
	{
		if(!res.getpageurl().contains("Flight"))
		{
			res.clickOnElement(repo.Flightlink);
		}
	}
	
	public void hotelBook()
	{
		if(!res.getpageurl().contains("Hotel"))
		{
			res.clickOnElement(repo.Hotellink);
		}
	}
	
	public void carBook()
	{
		if(!res.getpageurl().contains("Car"))
		{
			res.clickOnElement(repo.Carlink);
		}
	}
	


}
