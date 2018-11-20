package pom;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import locators.Locators;
import main.DBConnect;

public class ForgotPage {

	WebDriver driver;
	boolean emailflag = false;
	String querry = "select * from forgot_password_detail;", attribute = "user_id";

	@FindBy(xpath = Locators.FORGOT_EMAIL_TEXTFIELD_XPATH)
	WebElement forgot_email_textfield;

	@FindBy(xpath = Locators.FORGOT_LOGIN_BUTTON_XPATH)
	WebElement forgot_login_button;

	@FindBy(xpath = Locators.FORGOTPASSWORD_LINK_XPATH)
	WebElement forgotpassword_link;

	@FindBy(xpath = Locators.FORGOT_GOBACK_LINK_XPATH)
	WebElement forgot_goback_link;

	public ForgotPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public boolean visiblityOfComponents() {
		if (forgot_email_textfield.isDisplayed() && forgot_goback_link.isDisplayed()
				&& forgot_login_button.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean valid_forgotPassword(String email) throws InterruptedException {
		forgot_email_textfield.clear();
		forgot_email_textfield.sendKeys(email);
		try {
			if (!forgot_login_button.isEnabled()) {
				System.out.println("Invalid data entered, entered valid registered email id - button not clickable");
				return false;
			}
		} catch (Exception e) {
			System.out.println("Exception occur while checking button control");
			return false;
		}
		forgot_login_button.click();
		Thread.sleep(500);

		try {
			if (driver.findElement(By.xpath(Locators.FORGOT_VALID_RESET_EMAIL_MESSAGE_XPATH)).isDisplayed()) {
				System.out.println("Reset password link sent sucessfuly");
				System.out.println("verifying in database, please wait...........");
				for (String s : DBConnect.readEmail_of_forgorpasswords(querry,attribute).forgot_password_email) {
					System.out.println("emails in db are as - " + s);
					if (s.equalsIgnoreCase(email)) {
						emailflag = true;
						System.out.println("Reset link found in DB");
					}
				}
				return emailflag;
			} else {
				System.out.println("Reset link not found in DB");
				return emailflag;
			}
		} catch (Exception e) {
			System.out.println("Exception occur for valid registered user");
			return false;
		}
	}

	public boolean invalid_forgotPassword(String email) throws InterruptedException {

		try {

			driver.get(Locators.LOGINPAGE_URL);
			driver.get(Locators.FORGOTPAGE_URL);
			forgot_email_textfield.clear();
			forgot_email_textfield.sendKeys(email);
			// for wrong email format
			try {
				if (!forgot_login_button.isEnabled()) {
					System.out.println("Invalid email format entered - button not clickable");
					return false;
				}
			} catch (Exception e) {
				System.out.println("Exception occur while checking button control");
				return true;
			}
			forgot_login_button.click();
			Thread.sleep(500);
			try {
				if (driver.findElement(By.xpath(Locators.INVALID_USERNOTFOUND_MESSAGE_XPATH)).isDisplayed()) {
					System.out.println("User not registered with us");
					return false;
				}
			} catch (Exception e) {
				System.out.println("Exception occur to find message User is not available.");
				// return true;
			}
			try {
				if (driver.findElement(By.xpath(Locators.FORGOT_VALID_RESET_EMAIL_MESSAGE_XPATH)).isDisplayed()) {
					System.out.println("Reset password link sent sucessfuly");
					System.out.println("verifying in database, please wait...........");
					for (String s : DBConnect.readEmail_of_forgorpasswords(querry,attribute).forgot_password_email) {
						if (s.equalsIgnoreCase(email)) {
							System.out.println("Reset link found in DB");
							return true;
						}
					}
				} else {
					System.out.println("Reset link not found in DB");
					return false;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Exception occur for registered user");
				return true;
				// System.err.println(e);
				// e.printStackTrace();

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception in main try block");
			return true;
		}
		return emailflag;
	}
}
