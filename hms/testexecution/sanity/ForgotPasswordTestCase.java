package sanity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import locators.Locators;
import main.BrowserFactory;
import pom.ForgotPage;
import pom.LoginPage;
import screenshots.CaptureScreenshots;
import utils.ExcelUtils;

public class ForgotPasswordTestCase {

	WebDriver driver;
	boolean flag = true;
	ExcelUtils excelvalidusers = new ExcelUtils((System.getProperty("user.dir") + "/resources/utils/User.xlsx"),
			"validusers");
	ExcelUtils excelinvalidusers = new ExcelUtils((System.getProperty("user.dir") + "/resources/utils/User.xlsx"),
			"invalidusers");
	String validuserdata[][], invaliduserdata[][];
	ForgotPage forgotpage;
	SoftAssert asert = new SoftAssert();
	long starttime, endtime;

	@BeforeTest
	public void testdata() throws Exception {
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
			System.exit(1);
		}
		starttime = System.currentTimeMillis();
		System.out.println("Opening Browser");
		driver.get(Locators.LOGINPAGE_URL);
		Thread.sleep(1000);
		driver.findElement(By.xpath(Locators.FORGOTPASSWORD_LINK_XPATH)).click();
		forgotpage = new ForgotPage(driver);
		Thread.sleep(1000);
		System.out.println("----------------------------------------------------------------------------------");

	}

	@Test(priority = 1)
	void testForgotPassword_VisiblityofAllComponets() {
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("checking visiblity of all componets of  " + this.getClass());
		boolean flag = forgotpage.visiblityOfComponents();
		if (flag == false) {
			CaptureScreenshots.capture(driver, "testForgotPassword_VisiblityofAllComponets");
		}
		asert.assertTrue(flag, "fail to load components");
		asert.assertAll();
		System.out.println("----------------------------------------------------------------------------------");
	}

	@Test(priority = 2)
	void testForgotPassword_validforgotpassword() throws InterruptedException {
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("Valid forgot password test scenario 1 with username " + validuserdata[1][0]);
		boolean flag = forgotpage.valid_forgotPassword(validuserdata[1][0]);
		if (flag == false) {
			CaptureScreenshots.capture(driver, "testForgotPassword_validforgotpassword");
		}
		Assert.assertTrue(flag, "fail to test forgot password page");
		System.out.println("----------------------------------------------------------------------------------");

	}

	@Test(priority = 3)
	void testForgotPassword_invalidforgotpassword() throws InterruptedException {
		System.out.println("----------------------------------------------------------------------------------");

		// System.out.println("test data for invalid emails"+ invaliduserdata.length-1);
		for (int r = 1; r < invaliduserdata.length; r++) {
			System.out
					.println("Invalid forgotpassword test scenario " + r + " with username-  " + invaliduserdata[r][0]);
			Thread.sleep(2000);
			boolean flag = forgotpage.invalid_forgotPassword(invaliduserdata[r][0]);
			if (flag == true) {
				CaptureScreenshots.capture(driver, "testForgotPassword_invalidforgotpassword");
			}
			asert.assertFalse(flag, "fail to test invalid forgot password page");
			asert.assertAll();
			System.out.println("----------------------------------------------------------------------------------");

		}
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
