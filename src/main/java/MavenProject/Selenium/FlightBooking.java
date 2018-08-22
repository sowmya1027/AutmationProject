package MavenProject.Selenium;

import org.openqa.selenium.WebDriver;

public class FlightBooking extends HomePage 
{

	public FlightBooking(WebDriver driver)
	{
		super(driver);
	}

	public void bookTicket(String from, String expfromplace, String to, String exptoplace )
	{

		try
		{
			res.sendKeysToElement(repo.fromcity, from);
			Thread.sleep(5000);
			res.selectitemdropdown(repo.fromcity_item, expfromplace);		

			Thread.sleep(5000);

			res.sendKeysToElement(repo.tocity, to);
			Thread.sleep(5000);
			res.selectitemdropdown(repo.tocity_item, exptoplace);
		}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}


		public void selectfromdate(String month, String date)
		{
			res.clickOnElement(repo.fromdate);
			
			res.selectcalnder(repo.calendertitle, repo.nextbutton, month, date);
		}

		public void selecttodate(String month, String date)
		{
			res.clickOnElement(repo.todate);
			res.selectcalnder(repo.calendertitle, repo.nextbutton, month, date);
		}

		public void selectdeparttime(String value)
		{
			res.selettime(repo.departime, value);
		}

		public void selectreturntime(String value)
		{
			res.selettime(repo.returntime, value);
		}

		public String search(String title)
		{
			res.clickUsingJS(repo.searchbtn);
			res.explictwait_title(title);
			return res.GetpageTitle();
		}
	}
