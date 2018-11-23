package sanity;

import javax.xml.xpath.XPath;

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

	@BeforeClass
	void navigatesTo_privatePractitioner() throws InterruptedException {
		Assert.assertTrue(loginpage.validLogin(validuserdata[1][0], validuserdata[1][1]),
				"User Failed to Login with valid credentials");
		driver.findElement(By.xpath(Locators.CREATEN_ENTITY_WIDGET_XPATH)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Locators.PRACTITIONER_FLIPBOX_XPATH)).click();
		Thread.sleep(1000);
		// driver.switchTo().frame(driver.findElement(By.xpath(".//*[@id='container']/div/div[2]/div/div[2]")));
		practitionerpage = new PrivatePractitionerPage(driver);
		// driver.findElement(By.xpath(".//*[@id='container']/div/div[2]/div/div[2]"));
	}

	/*@Test(priority = 1)
	void test_visiblityof_privatepractitioner_components() {
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("checking visiblity of all componets of  " + this.getClass());
		Assert.assertTrue(practitionerpage.visiblityOfComponents(), "All component not dispalyed");
		System.out.println("----------------------------------------------------------------------------------");
	}
*/
	/*@Test(priority = 1)
	void test_verifyStateList() {
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("checking state list of " + this.getClass());
		System.out.println("----------------------------------------------------------------------------------");
		practitionerpage.verifyState();
		// Assert.assertTrue(practitionerpage.verifyState(), "db list not matching with
		// populated list");
		System.out.println("----------------------------------------------------------------------------------");
	}
*/
	@Test(priority = 1)
	void test_verifyAllCityList() {
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("checking city list for all states of " + this.getClass());
		System.out.println("----------------------------------------------------------------------------------");
		practitionerpage.verifyCity();
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
