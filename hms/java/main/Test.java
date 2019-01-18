package main;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(System.getProperty("user.dir"));
		System.out.println(System.getProperty("os.name"));
		DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy");
		Date date = new Date();
		System.out.println(date);
		System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
		
		
		DateFormat timeformat = new SimpleDateFormat("HHmmss");
System.err.println(dateFormat.format(timeformat));
		
		System.out.println(Integer.toString(124));
		
		//System.out.println(System.currentTimeMillis());
		
	//	WebDriver driver = BrowserFactory.createDriver("chrome");
		//driver.get("https://www.google.co.in/");
		new Test();

	}

	static {
		System.out.println("no main execution");
		// System.exit(0);
	}

	{
		System.out.println("in no static block");
	}

}