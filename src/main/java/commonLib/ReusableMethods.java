package commonLib;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableMethods 
{
	WebDriver driver;
	WebDriverWait wait;
	Actions act;

	public ReusableMethods(WebDriver driver)
	{
		// assigning base test driver to ReusableMethods driver (this.driver)
		this.driver=driver;
	}

	public void sendKeysToElement(By locator, String data)
	{
		clearelementtext(locator);
		explictwait_locator(locator);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(locator).sendKeys(data);
	}

	public void clickOnElement(By locator)
	{
		driver.findElement(locator).click();
	}

	public String GetpageTitle()
	{
		return driver.getTitle();
	}

	public String getElementText(By locator)
	{
		explictwait_locator(locator);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver.findElement(locator).getText();
	}

	public void explictwait_locator(By locator)
	{
		wait = new WebDriverWait(driver,30);	
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void explictwait_title(String title)
	{
		wait = new WebDriverWait(driver,30);	
		wait.until(ExpectedConditions.titleContains(title));
	}

	public void explictwait_webElement(By locator)
	{
		wait = new WebDriverWait(driver,30);	
		WebElement element= driver.findElement(locator);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void typeEscKey()
	{
		act = new Actions(driver);
		act.sendKeys(Keys.ESCAPE).perform();
	}


	public void popuphanlder(By locator) 
	{

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		act = new Actions(driver);
		try
		{
			wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.elementToBeClickable(locator));

			boolean flag=driver.findElement(locator).isDisplayed();
			System.out.println("status " + flag);

			if(driver.findElement(locator).isDisplayed())
			{
				driver.findElement(locator).click();
				act.sendKeys(Keys.ESCAPE).perform();
			}
			else {
				System.out.println("unexcepted dailog not dispplayed - else case " );
				act.sendKeys(Keys.ESCAPE).perform();
			}
		}
		catch(Exception e)
		{

			System.out.println("unexcepted dailog not dispplayed " + e);
		}
	}

	public void clickUsingJS(By locator)
	{
		explictwait_locator(locator);
		WebElement element=	driver.findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}

	public String getpageurl()
	{
		return driver.getCurrentUrl();
	}

	public void selectitemdropdown(By commonlocator, String place)
	{
		List<WebElement> list2=	driver.findElements(commonlocator);
		for(int t=0; t<list2.size();t++)
		{
			System.out.println(list2.get(t).getText());
			if (list2.get(t).getText().equals(place))
			{
				list2.get(t).click(); break;
			}
		}
	}


	public void selectcalnder(By titlelocator, By nextlocator, String expmonth,String expdate)
	{
		explictwait_locator(titlelocator);
		int coun=0;
		while(coun<6)
		{
			List<WebElement> title= driver.findElements(titlelocator);
			if(title.get(0).getText().contains(expmonth))
			{
				break;
			}
			if(!title.get(1).getText().contains(expmonth))
			{
				driver.findElement(nextlocator).click();
			}
			else
			{
				break;
			}
		}



		By table= By.xpath("//span[text()='"+expmonth+"']/following::table[1]");

		System.out.println("xpath " + table);

		int count=0;
		while(count<3)
		{
			try {
				WebElement tble= driver.findElement(table);
				List<WebElement> row=tble.findElements(By.tagName("tr"));
				for(int k=0;k<row.size();k++)
				{
					List<WebElement> column= row.get(k).findElements(By.tagName("td"));
					for(int a=0; a<column.size();a++)
					{
						if(	column.get(a).getText().equals(expdate))
						{
							column.get(a).click(); break;
						}
					}
				}
				count=count+3;
			}
			catch(Exception e)
			{
				System.out.println("exception occured ");
				count=count+1; continue;
			}
		}
	}

	public void selettime(By locator, String value)
	{
		WebElement ele=driver.findElement(locator);
		Select s = new Select(ele);
		s.selectByVisibleText(value);		
	}


	public void clearelementtext(By locator)
	{
		driver.findElement(locator).clear();
	}
}
