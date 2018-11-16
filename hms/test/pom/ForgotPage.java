package pom;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import locators.Locators;
import main.DBConnect;

public class ForgotPage {

	WebDriver driver;
	boolean emailflag = false;

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

	public boolean forgotPassword(String email) throws InterruptedException {

		try {
			forgot_email_textfield.clear();
			forgot_email_textfield.sendKeys(email);
			if (!forgot_login_button.isEnabled()) {
				System.out.println("Invalid data entered - button not clickable");
				return false;
			}

			/*
			 * if (driver.findElement(By.xpath(Locators.
			 * FORGOT_VALID_EMAIL_MESSAGE_ALREADYSENT_XPATH)).isDisplayed()) {
			 * System.out.println("Reset password link already sent sucessfuly");
			 * System.out.println("verifying in database, please wait...........");
			 * System.out.println();
			 * 
			 * for (String s :
			 * DBConnect.readEmail_of_forgorpasswords().forgot_password_email) { if
			 * (s.equalsIgnoreCase(email)) { emailflag = true; } }
			 * 
			 * return emailflag; } Thread.sleep(3000);
			 */
			else {
				forgot_login_button.click();
				Thread.sleep(500);
				try {
					if (driver.findElement(By.xpath(Locators.INVALID_USERNOTFOUND_MESSAGE_XPATH)).isDisplayed()) {
						System.out.println("User not avaliable");
						return false;
					}
				} catch (NoSuchElementException e) {
					// TODO Auto-generated catch block
					System.err.println("User not found xpath is not found exception");
				}
				if (driver.findElement(By.xpath(Locators.FORGOT_VALID_RESET_EMAIL_MESSAGE_XPATH)).isDisplayed()) {
					System.out.println("Reset password link sent sucessfuly");
					driver.navigate().refresh();
					driver.get(Locators.LOGINPAGE_URL);
					driver.get(Locators.FORGOTPAGE_URL);
					System.out.println("verifying in database, please wait...........");
					for (String s : DBConnect.readEmail_of_forgorpasswords().forgot_password_email) {
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
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e);
			// e.printStackTrace();
			return false;
		}

	}

}
