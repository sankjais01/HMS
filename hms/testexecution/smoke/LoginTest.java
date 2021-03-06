package smoke;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import locators.Locators;
import main.BrowserFactory;
import pom.LoginPage;
import utils.ExcelUtils;

public class LoginTest {

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

	@Test(priority = 1)
	void testVisiblityofAllComponets() {
		asert.assertTrue(loginpage.visiblityOfComponents(), "fail to load components");
	}

	@Test(priority = 2)
	void validLogin() throws InterruptedException {
		Assert.assertTrue(loginpage.validLogin(validuserdata[1][0], validuserdata[1][1]),
				"User Failed to Login with valid credentials");

	}

	@AfterSuite
	void destroy() {
		driver.close();

		System.out.println("total time for testing " + this.getClass() + (starttime - System.currentTimeMillis()) / 6000
				+ " Seconds");
	}

}
