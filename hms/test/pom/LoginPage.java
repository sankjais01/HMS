package pom;

import org.openqa.selenium.WebDriver;
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

	private LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	

}
