package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import main.BrowserFactory;

public class testdemo {

	WebDriver driver;
	boolean flag;
	boolean flagSlider;
	SoftAssert asert = new SoftAssert();
	int count, displayedCount, notDisplayeCount = 0;

	@BeforeSuite
	public void init() {
		driver = BrowserFactory.createDriver("chrome");
		if (driver == null) {
			flag = false;
			System.out.println("Unable to load browser, please check configration first");
		}
		System.out.println("Opening Browser");

	}

	
	}

	@Test
	void test() throws InterruptedException {
		driver.get("https://stackoverflow.com/");
		Thread.sleep(5000);
		List<WebElement> webelements = driver.findElements(By.xpath("//a"));
		for (WebElement webElement : webelements) {
			count++;
			if (webElement.isDisplayed()) {
				displayedCount++;
			} else {
				notDisplayeCount++;
			}

		}
		System.out.println("total achor tags are= " + count);
		System.out.println("is displayed " + displayedCount);
		System.out.println("failed to appear " + notDisplayeCount);
	}

	@AfterClass
	void end() {
		driver.close();
	}

}
