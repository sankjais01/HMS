package screenshots;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreenshots {

	public static void capture(WebDriver driver, String screenshotname) {
		try {

			DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
			DateFormat timeformat = new SimpleDateFormat("HHmmss");
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			Date date = new Date();
			//System.out.println(dateFormat.format(date));

			FileUtils.copyFile(source, new File(System.getProperty("user.dir") + "\\java\\screenshots\\"
					+ dateFormat.format(date) + "\\" + screenshotname+"_"+timeformat.format(date)+ ".png"));
			// FileUtils.copyDirectory(source, new File(
			// "C:\\Users\\sanket\\git\\HMS_JAN_2019\\hms\\java\\screenshots" +
			// screenshotname + ".jpeg"));
			System.out.println("***********  ScreenShot taken for test " + screenshotname + "  ***********");
		} catch (Exception e) {
			System.err.println(e);
		}

	}

}
