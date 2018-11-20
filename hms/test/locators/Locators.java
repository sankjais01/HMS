package locators;

public class Locators {

	public static final String LANDINGPAGE_URL = "http://49.248.255.50:8090/HMS_UI/#/landingPage";
	public static final String LOGINPAGE_URL = "http://49.248.255.50:8090/HMS_UI/#/";
	public static final String FORGOTPAGE_URL = "http://49.248.255.50:8090/HMS_UI/#/sendMail";

	// Login page objects xpaths

	public static final String USERNAME_TEXTFIELD_XPATH = "//input[@id='email']";
	public static final String PASSWORD_TEXTFIELD_XPATH = "//input[@id='password']";
	public static final String LOGIN_BUTTON_XPATH = "//button[@type='submit']";
	public static final String FORGOTPASSWORD_LINK_XPATH = "//a[contains(text(),'Forgot Password?')]";
	public static final String INVALID_LOGIN_MESSAGE_XPATH = "//span[contains(text(),'Invalid username or password')]";
	public static final String INVALID_USERNOTFOUND_MESSAGE_XPATH = "//span[contains(text(),'User is not available')]";


	// forgot password page object Xpath

	public static final String FORGOT_EMAIL_TEXTFIELD_XPATH = "//input[@id='email']";
	public static final String FORGOT_LOGIN_BUTTON_XPATH = "//button[@type='submit']";
	public static final String FORGOT_GOBACK_LINK_XPATH = ".//*[@id='app']//div[2]//div[2]/div[2]/div/a/span";
	public static final String FORGOT_VALID_RESET_EMAIL_MESSAGE_XPATH = "//p[contains(text(),'Password reset instructions sent to your mail.')]";
	public static final String FORGOT_VALID_EMAIL_MESSAGE_XPATH = "//p[contains(text(),'Password reset instructions sent to your mail.')]";
	public static final String FORGOT_VALID_EMAIL_MESSAGE_ALREADYSENT_XPATH = "// span[contains(text(),'Email has already been sent to your email address.')]";
	public static final String FORGOT_INVALID_EMAIL_MESSAGE_XPATH = "//span[contains(text(),'User is not available')]";

	// home page object Xpath
	public static final String SLIDER_MENU_BUTTON_XPATH = ".//*[@id='home']/span";
	public static final String SLIDER_ENTITY_DROPDOWN_XPATH = ".//*[@id='treeViewClass']/i";
	public static final String SLIDER_ENTITY_CREATENEWENTITY_BUTTON_XPATH = ".//*[@id='app']//div[1]//ul[1]/li[2]//li[1]/a";
	public static final String SLIDER_ENTITY_VIEWENTITY_BUTTON_XPATH = ".//*[@id='app']//div[1]//ul[1]/li[2]//li[2]/a";
	public static final String SLIDER_REPORTS_BUTTON_XPATH = ".//*[@id='app']//ul[1]/li[3]/a/span";
	public static final String SLIDER_MYTASK_BUTTON_XPATH = ".//*[@id='app']//ul[1]/li[4]/a/span";
	public static final String PROFILE_BUTTON_XPATH = "//span[contains(text(),'My Profile')]";
	public static final String LOGOUT_BUTTON_XPATH = "//span[contains(text(),'Logout')]";
	public static final String PROFILE_DROPDOWNMENU_XPATH = "//img[@class='usericon-down']";
	public static final String CREATEN_ENTITY_WIDGET_XPATH = "//h2[contains(text(),'Create Entity')]";
	public static final String REPORTS_WIDGET_XPATH = "//h2[contains(text(),'Reports')]";
	public static final String MY_ACCOUNT_WIDGET_XPATH = "//h2[contains(text(),'My Account')]";
	public static final String HOSPITAL_FLIPBOX_XPATH = "//span[contains(text(),'HOSPITAL')]";
	public static final String PRACTITIONER_FLIPBOX_XPATH = "//span[contains(text(),'PRIVATE PRACTITIONER')]";
	public static final String NGO_FLIPBOX_XPATH = "//span[contains(text(),'NGO')]";

	// private practitioner

	public static final String TITLE_DROPDOWNLIST_XPATH = "//*[@id='person']";
	public static final String FIRSTNAME_TEXTFIELD_XPATH = "//input[@id='firstName']";
	public static final String MIDDLENAME_TEXTFIELD_XPATH = "//input[@id='middleName']";
	public static final String LASTNAME_TEXTFIELD_XPATH = "//input[@id='lastName']";
	public static final String PHONETYPE_DROPDOWNLIST_XPATH = "//select[@id='typeTel']";
	public static final String CONTACT_TEXTFIELD_XPATH = "//input[@id='numberTel']";
	public static final String ADD_CONTACT_BUTTON_XPATH = "//*[@id='telPrimary']/ng-form/div[5]";
	public static final String ADDRESSLINE1_TEXTFIELD_XPATH = "//input[@id='addressLine1']";
	public static final String ADDRESSLINE2_TEXTFIELD_XPATH = "//input[@id='addressLine2']";
	public static final String STATE_DROPDOWNLIST_XPATH = "//*[@id='selectOptions']";
	public static final String CITY_DROPDOWNLIST_XPATH = "//*[@name='city']";
	public static final String PINCODE_DROPDOWNLIST_XPATH = "//select[@id='selectPin']";
	public static final String PINCODE_TEXTFIELD_XPATH = "//input[@name='otherzipCode']";
	public static final String COUNTRY_TEXTFIELD_XPATH = "//input[@id='country']";
	public static final String DOB_CALENDAR_XPATH = "//input[@id='dateBirth']";
	public static final String YEAROFPRACTICE_TEXTFIELD_XPATH = "//input[@id='yearsPractice']";
	public static final String EMAIL_TEXTFIELD_XPATH = "//input[@id='email']";
	public static final String SPECIALITY_DROPDOWNLIST_XPATH = "//*[@id='speciality']";
	public static final String COLLEGE_TEXTFIELD_XPATH = "//input[@id='college']";
	public static final String DEGREE_TEXTFIELD_XPATH = "//input[@id='degree']";
	public static final String PASSINGYEAR_TEXTFIELD_XPATH = "//input[@id='passingYears']";
	public static final String ADD_SEPCIALITY_BUTTON_XPATH = "//button[@id='addSpeciality3']";
	public static final String LICENSESTATUS_DROPDOWNLIST_XPATH = "//*[@name='licenseStatus']";
	public static final String BUSINESS_LICENSE_NUMBER_TEXTFIELD_XPATH = "//input[@id='businessLicenser']";
	public static final String LICENSE_ISSUER_BODY_TEXTFIELD_XPATH = "//input[@id='licenseBody']";
	public static final String LICENSE_ISSUER_YEAR_TEXTFIELD_XPATH = "//input[@id='licenseYear']";
	public static final String EDIT_ENTITY_LOGO_BROWSER_XPATH = "//span[contains(text(),'Edit Entity Logo')]";
	public static final String EDIT_PROFILE_IMAGE_BROWSER_XPATH = "//span[contains(text(),'Edit Profile Image')]";

	public static final String CANCEL_BUTTON_XPATH = "//button[@type='button']";
	public static final String CREATE_ENTITY_BUTTON_XPATH = "//button[@type='submit']";

}