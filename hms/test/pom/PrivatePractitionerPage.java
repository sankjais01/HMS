package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import locators.Locators;

public class PrivatePractitionerPage {

	WebDriver driver;
	boolean flag = true;

	@FindBy(xpath = Locators.TITLE_DROPDOWNLIST_XPATH)
	WebElement title_dropdown;

	@FindBy(xpath = Locators.FIRSTNAME_TEXTFIELD_XPATH)
	WebElement firstname_textfield;

	@FindBy(xpath = Locators.MIDDLENAME_TEXTFIELD_XPATH)
	WebElement middlename_textfield;

	@FindBy(xpath = Locators.LASTNAME_TEXTFIELD_XPATH)
	WebElement lastname_textfield;

	@FindBy(xpath = Locators.PHONETYPE_DROPDOWNLIST_XPATH)
	WebElement phone_dropdown;

	@FindBy(xpath = Locators.CONTACT_TEXTFIELD_XPATH)
	WebElement contact_textfield;

	@FindBy(xpath = Locators.ADD_CONTACT_BUTTON_XPATH)
	WebElement add_contact_button;

	@FindBy(xpath = Locators.ADDRESSLINE1_TEXTFIELD_XPATH)
	WebElement addressLine1_textfield;

	@FindBy(xpath = Locators.ADDRESSLINE2_TEXTFIELD_XPATH)
	WebElement addressLine2_textfield;

	@FindBy(xpath = Locators.STATE_DROPDOWNLIST_XPATH)
	WebElement state_dropdown;

	@FindBy(xpath = Locators.CITY_DROPDOWNLIST_XPATH)
	WebElement city_dropdown;

	@FindBy(xpath = Locators.PINCODE_TEXTFIELD_XPATH)
	WebElement pincode_textfield;

	@FindBy(xpath = Locators.COUNTRY_TEXTFIELD_XPATH)
	WebElement country_textfield;

	@FindBy(xpath = Locators.DOB_CALENDAR_XPATH)
	WebElement dob_calendar;

	@FindBy(xpath = Locators.YEAROFPRACTICE_TEXTFIELD_XPATH)
	WebElement practice_years_textfield;

	@FindBy(xpath = Locators.EMAIL_TEXTFIELD_XPATH)
	WebElement email_textfield;

	@FindBy(xpath = Locators.SPECIALITY_DROPDOWNLIST_XPATH)
	WebElement specality_dropdown;

	@FindBy(xpath = Locators.COLLEGE_TEXTFIELD_XPATH)
	WebElement college_textfield;

	@FindBy(xpath = Locators.DEGREE_TEXTFIELD_XPATH)
	WebElement degree_textfield;

	@FindBy(xpath = Locators.PASSINGYEAR_TEXTFIELD_XPATH)
	WebElement passing_year_textfield;

	@FindBy(xpath = Locators.ADD_SEPCIALITY_BUTTON_XPATH)
	WebElement addspecality_button;

	@FindBy(xpath = Locators.LICENSESTATUS_DROPDOWNLIST_XPATH)
	WebElement licensestatus_dropdown;

	@FindBy(xpath = Locators.BUSINESS_LICENSE_NUMBER_TEXTFIELD_XPATH)
	WebElement businesslicence_number_textfield;

	@FindBy(xpath = Locators.LICENSE_ISSUER_BODY_TEXTFIELD_XPATH)
	WebElement licenceissuerbody_textfield;

	@FindBy(xpath = Locators.LICENSE_ISSUER_YEAR_TEXTFIELD_XPATH)
	WebElement licenceissueryear_textfield;

	@FindBy(xpath = Locators.EDIT_ENTITY_LOGO_BROWSER_XPATH)
	WebElement entity_logo_button;

	@FindBy(xpath = Locators.EDIT_PROFILE_IMAGE_BROWSER_XPATH)
	WebElement profile_image_button;

	@FindBy(xpath = Locators.CANCEL_BUTTON_XPATH)
	WebElement cancel_button;

	@FindBy(xpath = Locators.CREATE_ENTITY_BUTTON_XPATH)
	WebElement createentity_button;

	public PrivatePractitionerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean visiblityOfComponents() {

		if (!title_dropdown.isDisplayed()) {
			flag = false;
			System.out.println("title for MR, MRs prefix not displayed");
		}
		if (!firstname_textfield.isDisplayed()) {
			flag = false;
			System.out.println("firstname textfield not displayed");
		}
		if (!middlename_textfield.isDisplayed()) {
			flag = false;
			System.out.println("middle name textfield not displayed");
		}
		if (!phone_dropdown.isDisplayed()) {
			flag = false;
			System.out.println("phone number type dropdown not displayed");
		}
		if (!contact_textfield.isDisplayed()) {
			flag = false;
			System.out.println("contact textfield not displayed");
		}

		if (!add_contact_button.isDisplayed()) {
			flag = false;
			System.out.println("add contact button not displayed");
		}

		if (!addressLine1_textfield.isDisplayed()) {
			flag = false;
			System.out.println("address line 1 textfield not displayed");
		}

		if (!addressLine2_textfield.isDisplayed()) {
			flag = false;
			System.out.println("address line 2 textfield not displayed");
		}
		if (!state_dropdown.isDisplayed()) {
			flag = false;
			System.out.println("state dropdown list not displayed");
		}

		if (!city_dropdown.isDisplayed()) {
			flag = false;
			System.out.println("city dropdown list not displayed");
		}

		if (!pincode_textfield.isDisplayed()) {
			flag = false;
			System.out.println("pincode textfield not displayed");
		}

		if (!country_textfield.isDisplayed()) {
			flag = false;
			System.out.println("country textfield not displayed");
		}
		if (!dob_calendar.isDisplayed()) {
			flag = false;
			System.out.println("DOB calendar not displayed");
		}

		if (!practice_years_textfield.isDisplayed()) {
			flag = false;
			System.out.println("year of practice textfield not displayed");
		}

		if (!email_textfield.isDisplayed()) {
			flag = false;
			System.out.println("email textfield not displayed");
		}
		if (!profile_image_button.isDisplayed()) {
			flag = false;
			System.out.println("profile image browser button not displayed");
		}

		if (!entity_logo_button.isDisplayed()) {
			flag = false;
			System.out.println("entity image browser button not displayed");
		}
		if (!specality_dropdown.isDisplayed()) {
			flag = false;
			System.out.println("speciality dropdown list not displayed");
		}

		if (!college_textfield.isDisplayed()) {
			flag = false;
			System.out.println("college textfield not displayed");
		}

		if (!degree_textfield.isDisplayed()) {
			flag = false;
			System.out.println("degree textfield not displayed");
		}

		if (!passing_year_textfield.isDisplayed()) {
			flag = false;
			System.out.println("passing year textfield not displayed");
		}

		if (!addspecality_button.isDisplayed()) {
			flag = false;
			System.out.println("add specality button not displayed");
		}

		if (!licensestatus_dropdown.isDisplayed()) {
			flag = false;
			System.out.println("license status dropdownlist not displayed");
		}

		if (!businesslicence_number_textfield.isDisplayed()) {
			flag = false;
			System.out.println("business license number textfield not displayed");
		}

		if (!licenceissuerbody_textfield.isDisplayed()) {
			flag = false;
			System.out.println("license body textfield not displayed");
		}

		if (!licenceissueryear_textfield.isDisplayed()) {
			flag = false;
			System.out.println("license issuer year textfield not displayed");
		}

		if (!cancel_button.isDisplayed()) {
			flag = false;
			System.out.println("cancel button not displayed");
		}

		if (!createentity_button.isDisplayed()) {
			flag = false;
			System.out.println("create entity button not displayed");
		}

		return flag;

	}

}
