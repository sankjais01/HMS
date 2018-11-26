package sceenshots;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreenshots {

	public static void capture(WebDriver driver, String screenshotname) {
		try {

			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyDirectory(source,
					new File("C:\\Users\\sanket\\git\\HMS_NOV\\hms\\java\\sceenshots" + screenshotname + ".png"));
			System.out.println("ScreenShot taken");
		} catch (Exception e) {
			System.err.println(e);
		}

	}

}
