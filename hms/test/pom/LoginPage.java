package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import locators.Locators;

public class LoginPage {

	WebDriver driver;

	@FindBy(xpath = Locators.USERNAME_TEXTFIELD_XPATH)
	WebElement username_textfield;

	@FindBy(xpath = Locators.PASSWORD_TEXTFIELD_XPATH)
	WebElement password_textfield;

	@FindBy(xpath = Locators.LOGIN_BUTTON_XPATH)
	WebElement login_button;

	@FindBy(xpath = Locators.FORGOTPASSWORD_LINK_XPATH)
	WebElement forgotpassword_link;

	@FindBy(xpath = Locators.LOGOUT_BUTTON_XPATH)
	WebElement logout_button;

	@FindBy(xpath = Locators.PROFILE_DROPDOWNMENU_XPATH)
	WebElement menu;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public boolean visiblityOfComponents() {
		if (username_textfield.isDisplayed() && password_textfield.isDisplayed() && login_button.isDisplayed()
				&& forgotpassword_link.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean validLogin(String username, String password) throws InterruptedException {

		try {
			username_textfield.clear();
			username_textfield.sendKeys(username);
			password_textfield.clear();
			password_textfield.sendKeys(password);
			login_button.click();
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e);
			// e.printStackTrace();
		}
		if (driver.getCurrentUrl().equalsIgnoreCase(Locators.LANDINGPAGE_URL)) {
			Thread.sleep(1000);
			System.out.println("user login sucessfuly");
			// menu.click();
			// logout_button.click();
			return true;
		} else {
			return false;
		}

	}

	public boolean invalidLogin(String username, String password) {

		try {

			username_textfield.clear();
			username_textfield.sendKeys(username);
			password_textfield.clear();
			password_textfield.sendKeys(password);
			// System.out.println(login_button.getAttribute("disabled"));
			if (login_button.isEnabled()) {
				login_button.click();
				Thread.sleep(500);
			} else {
				System.out.println("Invalid email format or password entered - button not clickable");
				return false;

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e);
			// e.printStackTrace();
		}

		if ((!driver.getCurrentUrl().equalsIgnoreCase(Locators.LANDINGPAGE_URL))
				&& driver.findElement(By.xpath(Locators.INVALID_LOGIN_MESSAGE_XPATH)).isDisplayed()) {
			return false;
		} else {
			return true;
		}

	}

}
