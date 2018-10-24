package sanity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import locators.Locators;
import main.BrowserFactory;
import pom.LoginPage;
import pom.PrivatePractitionerPage;
import utils.ExcelUtils;

public class PrivatePractitionerTestCase {

	WebDriver driver;
	boolean flag = true;
	ExcelUtils excelvalidusers = new ExcelUtils((System.getProperty("user.dir") + "/resources/utils/User.xlsx"),
			"validusers");
	String validuserdata[][];
	LoginPage loginpage;
	PrivatePractitionerPage practitionerpage;
	SoftAssert asert = new SoftAssert();
	long starttime, endtime;

	@BeforeSuite
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
			}
		}

	}

	@BeforeTest
	void initBrowser() throws InterruptedException {
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

	}

	@BeforeClass
	void navigatesTo_privatePractitioner() throws InterruptedException {
		Assert.assertTrue(loginpage.validLogin(validuserdata[1][0], validuserdata[1][1]),
				"User Failed to Login with valid credentials");
		driver.findElement(By.xpath(Locators.CREATEN_ENTITY_WIDGET_XPATH)).click();
		driver.findElement(By.xpath(Locators.PRACTITIONER_FLIPBOX_XPATH)).click();
		practitionerpage = new PrivatePractitionerPage(driver);
	}

	/*
	 * @Test(priority = 1) void validLogin() throws InterruptedException {
	 * Assert.assertTrue(loginpage.validLogin(validuserdata[1][0],
	 * validuserdata[1][1]), "User Failed to Login with valid credentials");
	 * 
	 * }
	 */

	@AfterSuite
	void destroy() {
		driver.close();

		System.out.println("total time for testing " + this.getClass() + (starttime - System.currentTimeMillis()) / 6000
				+ " Seconds");
	}

}
