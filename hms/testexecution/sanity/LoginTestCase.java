package sanity;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import main.BrowserFactory;
import utils.ExcelUtils;

public class LoginTestCase {
	WebDriver driver;
	boolean flag = true;
	ExcelUtils excelvalidusers = new ExcelUtils((System.getProperty("user.dir") + "/resources/utils/User.xlsx"),
			"validusers");
	ExcelUtils excelinvalidusers = new ExcelUtils((System.getProperty("user.dir") + "/resources/utils/User.xlsx"),
			"invalidusers");
	String validuserdata[][], invaliduserdata[][];

	@Test
	public void testdata() throws Exception {
		int cols = excelvalidusers.excel_get_cols();
		int rows = excelvalidusers.excel_get_rows();
		validuserdata[rows][cols] = new String();
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				validuserdata[r][c] = excelvalidusers.getCellDataAsString(r, c);
				System.out.println(excelvalidusers.getCellDataAsString(r, c));
			}
		}

	}

	/*
	 * @BeforeTest void initBrowser() { driver =
	 * BrowserFactory.createDriver("chrome"); if (driver == null) { flag = false;
	 * System.out.println("Unable to load browser, please check configration first"
	 * ); } System.out.println("Opening Browser"); }
	 * 
	 * @Test void validLogin() {
	 * 
	 * }
	 */

}
