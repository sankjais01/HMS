package sanity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import main.BrowserFactory;

public class test1 {
	WebDriver driver;
	boolean flag;
	
	
	@BeforeTest()
	void initBrowser() throws InterruptedException {
		driver = BrowserFactory.createDriver("chrome");
		if (driver == null) {
			flag = false;
			System.out.println("Unable to load browser, please check configration first");
		}
		System.out.println("Opening Browser");
		driver.get("http://49.248.255.50:8090/HMS_UI/#/createPrivatePriactitioner");
		Thread.sleep(3000);

	}
	
	@Test
	void t1()
	{
		Select s= new Select(driver.findElement(By.xpath("//select[@id='person']")));
		s.selectByValue("Mr");
				}
}
