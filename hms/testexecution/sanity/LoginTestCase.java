package sanity;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mysql.cj.util.TimeUtil;

import locators.Locators;
import main.BrowserFactory;
import pom.LoginPage;
import utils.ExcelUtils;

public class LoginTestCase {
	WebDriver driver;
	boolean flag = true;
	ExcelUtils excelvalidusers = new ExcelUtils((System.getProperty("user.dir") + "/resources/utils/User.xlsx"),
			"validusers");
	ExcelUtils excelinvalidusers = new ExcelUtils((System.getProperty("user.dir") + "/resources/utils/User.xlsx"),
			"invalidusers");
	String validuserdata[][], invaliduserdata[][];
	LoginPage loginpage;
	SoftAssert asert = new SoftAssert();
	long starttime, endtime;

	
	@BeforeTest
	public void testdata() throws Exception {
	//	WebDriverWait wait = new WebDriverWait(driver,5000);
		FluentWait<WebDriver> 	wait = new FluentWait<WebDriver>(driver);
		wait.ignoring(NoSuchElementException.class);
	

		// for getting valid data into string array
		int cols = excelvalidusers.excel_get_cols();
		int rows = excelvalidusers.excel_get_rows();
		// System.out.println("valid data cols " + cols);
		// System.out.println("valid data rows" + rows);
		validuserdata = new String[rows][cols];

		for (int r = 1; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				validuserdata[r][c] = excelvalidusers.getCellDataAsString(r, c);
				// System.out.print(validuserdata[r][c] + " ");
			}
			// System.out.println();
		}

		// System.out.println("----------------------------------------------------");

		// for getting invalid data into string array

		cols = excelinvalidusers.excel_get_cols();
		rows = excelinvalidusers.excel_get_rows();

		// System.out.println("Invalid data cols " + cols);
		// System.out.println("Invalid data rows" + rows);
		invaliduserdata = new String[rows][cols];

		for (int r = 1; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				invaliduserdata[r][c] = excelinvalidusers.getCellDataAsString(r, c);
				// System.out.print(invaliduserdata[r][c] + " ");
			}
			// System.out.println();
		}

	}

	@BeforeSuite()
	void initBrowser() throws InterruptedException {
		System.out.println("----------------------------------------------------------------------------------");
		driver = BrowserFactory.createDriver("chrome");
		if (driver == null) {
			flag = false;
			System.out.println("Unable to load browser, please check configration first");
		}
		starttime = System.currentTimeMillis();
		System.out.println("Opening Browser");
		driver.get(Locators.LOGINPAGE_URL);
		loginpage = new LoginPage(driver);
		Thread.sleep(3000);
		System.out.println("----------------------------------------------------------------------------------");

		
	}

	@Test(priority = 1)
	void test_VisiblityofAllComponets() {
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("checking visiblity of all componets of " + this.getClass());
		asert.assertTrue(loginpage.visiblityOfComponents(), "fail to load components");
		System.out.println("----------------------------------------------------------------------------------");
	}

	@Test(priority = 2)
	void test_validLogin() throws InterruptedException {
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("Testing valid login testcase");
		Assert.assertTrue(loginpage.validLogin(validuserdata[1][0], validuserdata[1][1]),
				"User Failed to Login with valid credentials");
		driver.findElement(By.xpath(Locators.PROFILE_DROPDOWNMENU_XPATH)).click();
		driver.findElement(By.xpath(Locators.LOGOUT_BUTTON_XPATH)).click();
		System.out.println("----------------------------------------------------------------------------------");

	}

	@Test(priority = 3)
	void test_invalidLogin() throws InterruptedException {
		// driver.get(Locators.LOGINPAGE_URL);
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("Testing Invalid login testcase");
		for (int r = 1; r < invaliduserdata.length; r++) {
			System.out.println("Invalid test scenario " + r + " with username-  " + invaliduserdata[r][0]
					+ " password - " + invaliduserdata[r][1]);
			Thread.sleep(2000);
			asert.assertFalse(loginpage.invalidLogin(invaliduserdata[r][0], invaliduserdata[r][1]),
					"User Login successful with invalid data credentials" + "username-  " + invaliduserdata[r][0]
							+ " password - " + invaliduserdata[r][1]);

		}
		System.out.println("----------------------------------------------------------------------------------");
	}

	@AfterSuite
	void destroy() {
		System.out.println("----------------------------------------------------------------------------------");
		driver.close();
		System.out.println("total time for testing " + this.getClass() + (starttime - System.currentTimeMillis()) / 6000
				+ " Seconds");
		System.out.println("----------------------------------------------------------------------------------");
	}

}
