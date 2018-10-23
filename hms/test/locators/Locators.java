package locators;

public class Locators {

	public static final String LANDINGPAGE_URL = "http://49.248.255.50:8090/HMS_UI/#/landingPage";
	public static final String LOGINPAGE_URL = "http://49.248.255.50:8090/HMS_UI/#/";

	// home page object Xpath
	public static final String USERNAME_TEXTFIELD_XPATH = "//input[@id='email']";
	public static final String PASSWORD_TEXTFIELD_XPATH = "//input[@id='password']";
	public static final String LOGIN_BUTTON_XPATH = "//button[@type='submit']";
	public static final String FORGOTPASSWORD_LINK_XPATH = "//a[contains(text(),'Forgot Password?')]";
	public static final String INVALID_LOGIN_MESSAGE_XPATH = "//span[contains(text(),'Invalid username or password')]";
	public static final String LOGOUT_BUTTON_XPATH = "//span[contains(text(),'Logout')]";
	public static final String PROFILE_DROPDOWNMENU_XPATH = "//img[@class='usericon-down']";

}