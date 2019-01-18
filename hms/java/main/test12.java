package main;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class test12 {

	public static void main(String args[]) {
		WebDriver driver = BrowserFactory.createDriver("firefox");
		driver.get("https://www.google.com/advanced_search");
		driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL, "t");
		ArrayList<String> s= new ArrayList<String>(driver.getWindowHandles());
		System.out.println(s.size());
		driver.switchTo().window(s.get(1));
		driver.get("https://www.google.com");
Actions action = new Actions(driver);
action.moveToElement(driver.findElement(By.xpath("sasa")));

		/*
		 * GetExcelData readdata=GetExcelData.get_exceldata("Invalidusers");
		 * System.out.println(readdata.usersheetdata.length); for (int r = 1; r <
		 * readdata.usersheetdata.length; r++) { for (int c = 0; c < 2; c++) {
		 * 
		 * System.out.print(readdata.usersheetdata[r][c] + " ");
		 * 
		 * } System.out.println(); }
		 */

	}

}
