package automationpractice.pages;

import automationpractice.elements.*;
import automationpractice.helper.logger.LoggerHelper;
import automationpractice.testbase.TestBase;
import automationpractice.utilities.Constants;
import automationpractice.utilities.CustomDrivers;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class RegistrationPage {
    WebDriver driver;
    RegistrationPageElements registrationPageElements;
    RegistrationConfirmationPageElements registrationConfirmationPageElements;
    HomePageElements homePageElements;
    HeaderNavPageElements headerNavPageElements;
    LoginPageElements loginPageElements;
    WebDriverWait wait;
    Logger log = LoggerHelper.getLogger(RegistrationPage.class);

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.registrationPageElements = new RegistrationPageElements(driver);
        this.homePageElements = new HomePageElements(driver);
        this.headerNavPageElements = new HeaderNavPageElements(driver);
        this.loginPageElements = new LoginPageElements(driver);
        this.registrationConfirmationPageElements = new RegistrationConfirmationPageElements(driver);
        this.wait = new WebDriverWait(driver, Constants.thirty_SECONDS);
    }

    public boolean verifyCreateAnAccountTxt() {
        WebElement ele = registrationPageElements.createAnAccountTxt;
        boolean result = ele.isDisplayed();
        String displayedText = ele.getText();
        log.info(displayedText + " is => " + result);
        TestBase.logExtentReport("Create An Account Txt is displayed as => " + displayedText);
        return result;

    }

    public boolean verifyYourPersonalInformationSectionTxt() {
        boolean result = registrationPageElements.yourPersonalInformationSectionTxt.isDisplayed();
        log.info("Your Personal Information Section Txt is displayed as => " + result);
        TestBase.logExtentReport("Your Personal Information Section Txt is displayed as => " + result);
        return result;
    }

    public boolean checkMrRadioBtn() {
        WebElement mr = registrationPageElements.mrRadioBtn;
        wait.until(ExpectedConditions.visibilityOf(mr));
        boolean result = mr.isEnabled();
        log.info("Checking Mr. Radio Btn as => " + Constants.mr);
        mr.click();
        CustomDrivers.isSelected(mr,"Mr Radio Btn selected..");
        TestBase.logExtentReport("Checking Mr. Radio Btn as => " + Constants.mr);
        return result;
    }

    public boolean checkMrsRadioBtn() {
        log.info("Checking Mrs Radio Btn as " + Constants.mrs);
        TestBase.logExtentReport("Checking Mrs Radio Btn as => " + Constants.mrs);
        CustomDrivers.isSelected(registrationPageElements.mrsRadioBtn,"Mrs Radio Btn");
        registrationPageElements.mrsRadioBtn.click();
        return registrationPageElements.mrsRadioBtn.isEnabled();
    }

    public void enterFirstNameTxtBox() throws Exception {
        WebElement fName = registrationPageElements.firstNameTxtBox;
        log.info("Entering firstName as => " + Constants.firstname);
        TestBase.logExtentReport("Entering FirstName as => " + Constants.firstname);
        fName.clear();
        fName.sendKeys(Constants.firstname);
    }

    public void enterLastnameTxtBox() {
        WebElement lName = registrationPageElements.lastnameTxtBox;
        log.info("Entering LastName as => " + Constants.lastname);
        lName.clear();
        TestBase.logExtentReport("Entering LastName as => " + Constants.lastname);
        lName.sendKeys(Constants.lastname);
    }

    public void enterEmailAddressTxtBox() {
        registrationPageElements.emailAddressTxtBox.click();
    }

    public WebElement enterPasswordTxtBox() {
        WebElement password = registrationPageElements.passwordTxtBox;
        log.info("Entering password as => " + Constants.Password);
        TestBase.logExtentReport("Entering Password as => " + Constants.Password);
        password.sendKeys(Constants.Password);
        return password;
    }

    public void selectDaysDropdownBtn() throws InterruptedException {
        Thread.sleep(Constants.two_SECONDS);
        WebElement day = registrationPageElements.daysDropdownBtn;
        boolean dayDropDown = day.isEnabled();
        Select sel = new Select(day);
        TestBase.logExtentReport("selecting date as => " + Constants.day);
        TestBase.logExtentReport("Day DropDown is enabled as => " + dayDropDown);
        log.info("Day DropDown is enabled => " + dayDropDown);
        log.info("Selecting date as => " + Constants.day);
        sel.selectByIndex(Constants.day);
        CustomDrivers.isSelected(day,"Is Day DropDown selected =>");
    }

    public void selectMonthDropdownBtn() throws InterruptedException {
        Thread.sleep(Constants.two_SECONDS);
        WebElement month = registrationPageElements.monthDropdownBtn;
        boolean monthDropDown = month.isEnabled();
        log.info("Month DropDown is enabled as =>  " + monthDropDown);
        Select select = new Select(month);
        TestBase.logExtentReport("Month DropDown is enabled as => " + monthDropDown);
        TestBase.logExtentReport("Selecting month as => " + Constants.month);
        select.selectByIndex(Constants.month);
        CustomDrivers.isSelected(month,"Is Month DropDown selected =>");
    }

    public void selectYearDropdownBtn() throws InterruptedException {
        Thread.sleep(Constants.two_SECONDS);
        WebElement year = registrationPageElements.yearDropdownBtn;
        boolean yearDropDown = year.isEnabled();
        log.info("Year DropDown is enabled as => " + yearDropDown);
        Select select = new Select(year);
        TestBase.logExtentReport("Year DropDown is enabled as => " + yearDropDown);
        TestBase.logExtentReport("Selecting year as => " + Constants.year_DOB);
        select.selectByValue(String.valueOf(Constants.year_DOB));
        CustomDrivers.isSelected(year,"Is Year DropDown selected =>");
    }

    public void checkSignUpNewsletterRadioBtn() throws InterruptedException {
        WebElement SignUpNewsletterBtn = registrationPageElements.signUpNewsletterRadioBtn;
        this.wait.until(ExpectedConditions.elementToBeClickable(SignUpNewsletterBtn));
        TestBase.logExtentReport("Checked SignUp Newsletter Radio Btn as " + SignUpNewsletterBtn.getText());
        SignUpNewsletterBtn.click();
        CustomDrivers.isSelected(SignUpNewsletterBtn,"Is Year Checked => ");
    }

    public boolean verifySignUpNewsletterTxt() throws InterruptedException {
        Thread.sleep(Constants.two_SECONDS);
        WebElement element = registrationPageElements.signUpNewsletterTxt;
        boolean result = element.isDisplayed();
        String text = element.getText().trim();
        TestBase.logExtentReport("SignUp Newsletter Radio Btn Txt is displayed as => " + result);
        log.info("SignUp Newsletter Txt displayed as => " + text);
        return result;
    }

    public boolean CheckOnReceiveSpecialOffersRadioBtn() {
        WebElement SpecialOffer = registrationPageElements.receiveSpecialOffersRadioBtn;
        boolean result = SpecialOffer.isEnabled();
        TestBase.logExtentReport("Checked on" + SpecialOffer.getText() + " => " + result);
        log.info("Checked on SpecialOffer => " + result);
        SpecialOffer.click();
        CustomDrivers.isSelected(SpecialOffer,"Is Year Checked => ");
        return result;
    }

    public boolean verifyReceiveSpecialOffersTxt() {
        WebElement element = registrationPageElements.receiveSpecialOffersTxt;
        String text = element.getText();
        boolean result = element.isDisplayed();
        TestBase.logExtentReport("Receive Special Offers Txt as => " + text);
        log.info("Receive Special Offers Txt is displayed as => " + text.trim());
        return result;
    }

    public boolean verifyYourAddressSectionTxt() {
        WebElement element = registrationPageElements.yourAddressSectionTxt;
        String text = element.getText();
        boolean result = element.isDisplayed();
        TestBase.logExtentReport("Your Address Section Txt is displayed as => " + text);
        log.info("Your Address Section Txt is displayed as => " + text.trim());
        return result;
    }

    public void enterYourAddressFirstNameTxtBox() {
        log.info("Entering Your Address FirstName as => " + Constants.firstname);
        WebElement first_name = registrationPageElements.yourAddressFirstNameTxtBox;
        first_name.clear();
        log.info("Clearing Your Address FirstName field");
        TestBase.logExtentReport("Entering Your Address FirstName as => " + Constants.firstname);
        first_name.sendKeys(Constants.firstname);
    }

    public void enterYourAddressLastNameTxtBox() {
        WebElement last_name = registrationPageElements.yourAddressLastNameTxtBox;
        log.info("Entering Your Address LastName as => " + Constants.lastname);
        TestBase.logExtentReport("Entering your Address Last Name as => " + Constants.lastname);
        last_name.clear();
        last_name.sendKeys(Constants.lastname);
    }

    public void enterYourAddressCompanyTxtBox() {
        WebElement element = registrationPageElements.yourAddressCompanyTxtBox;
        element.clear();
        log.info("Entering Your Address Company as => " + Constants.yourAddressCompany);
        TestBase.logExtentReport("Entering yourAddressCompany as => " + Constants.yourAddressCompany);
        element.sendKeys(Constants.yourAddressCompany);
    }

    public void enterAddressTxtBox() {
        log.info("Entering Address as => " + Constants.yourAddress);
        TestBase.logExtentReport("Entering Address as => " + Constants.yourAddress);
        registrationPageElements.addressTxtBox.sendKeys(Constants.yourAddress);
    }

    public boolean verifyStreetAddressPOBoxCompanyNameEtcTxt() {
        WebElement element = registrationPageElements.streetAddressPOBoxCompanyNameEtcTxt;
        boolean result = element.isDisplayed();
        log.info("Street Address PO Box Company Name Etc Txt is Displayed as => " + result);
        TestBase.logExtentReport("Street Address POBox Company Name Etc Txt is Displayed as => " + result);
        return result;
    }

    public void enterAddress2TxtBox() {
        log.info("Entering address2 as => " + Constants.yourAddressLine2Apartment);
        TestBase.logExtentReport("Entering address 2 as => " + Constants.yourAddressLine2Apartment);
        registrationPageElements.address2TxtBox.sendKeys(Constants.yourAddressLine2Apartment);
    }

    public void enterYourAddressCityTxtBox() {
        log.info("Entering your Address City as => " + Constants.yourAddressCity);
        TestBase.logExtentReport("Entering Your Address City as => " + Constants.yourAddressCity);
        registrationPageElements.yourAddressCityTxtBox.sendKeys(Constants.yourAddressCity);
    }

    public void selectYourAddressStateDropdownBtn() throws InterruptedException {
        WebElement state = registrationPageElements.yourAddressStateDropdownBtn;
        Thread.sleep(Constants.two_SECONDS);
        log.info("Entering Your Address State as => " + Constants.yourAddressState);
        TestBase.logExtentReport("Entering Your Address State as => " + Constants.yourAddressState);
        Select select = new Select(state);
        select.selectByVisibleText(Constants.yourAddressState);
        CustomDrivers.isSelected(state,"Is Address State selected => ");
    }

    public void enterYourAddressPostCodeTxtBox() {
        log.info("Entering Your Address PostCode as => " + Constants.yourAddressZipPostalCode);
        TestBase.logExtentReport("Entering Your Address PostCode as => " + Constants.yourAddressZipPostalCode);
        registrationPageElements.yourAddressPostCodeTxtBox.sendKeys(Constants.yourAddressZipPostalCode);
    }

    public void selectYourAddressCountryDropdownBtn() throws InterruptedException {
        WebElement CountryDropdown = registrationPageElements.yourAddressCountryDropdownBtn;
        boolean result = CountryDropdown.isEnabled();
        log.info("Country DropDown is enabled as =>  " + result);
        log.info("Selecting Your Address Country Dropdown Btn as => " + Constants.yourAddressCountry);
        TestBase.logExtentReport("Your Address Country Dropdown Btn is enabled as => " + result);
        Thread.sleep(Constants.two_SECONDS);
        Select select = new Select(CountryDropdown);
        select.selectByVisibleText(Constants.yourAddressCountry);
        CustomDrivers.isSelected(CountryDropdown,"Is Address Country selected => ");
    }

    public void enterAdditionalInformationTxtBox() {
        log.info("Entering additionalInformation as => " + Constants.AdditionalInformation);
        TestBase.logExtentReport("Entering Additional Information as => " + Constants.AdditionalInformation);
        registrationPageElements.additionalInformationTxtBox.sendKeys(Constants.AdditionalInformation);
    }

    public boolean verifyYouMustRegisterOnePhoneNumberTxt() {
        WebElement text = registrationPageElements.youMustRegisterOnePhoneNumberTxt;
        log.info("You Must Register One Phone Number Txt is displayed as => " + Constants.yourAddressYouMustRegisterAtLeastOnePhoneNumber);
        TestBase.logExtentReport("You Must Register One Phone Number Txt is displayed as => " + Constants.yourAddressYouMustRegisterAtLeastOnePhoneNumber);
        return text.isDisplayed();
    }

    public void enterHomePhoneTxtBox() {
        log.info("Entering homePhone => " + Constants.yourAddressHomePhone);
        TestBase.logExtentReport("Entering Home Phone as => " + Constants.yourAddressHomePhone);
        registrationPageElements.homePhoneTxtBox.sendKeys(Constants.yourAddressHomePhone);
    }

    public void enterMobilePhoneTxtBox() {
        log.info("Entering mobilePhone as => " + Constants.yourAddressMobilePhone);
        TestBase.logExtentReport("Entering Mobile Phone as => " + Constants.yourAddressMobilePhone);
        registrationPageElements.mobilePhoneTxtBox.sendKeys(Constants.yourAddressMobilePhone);
    }

    public void enterAddressAliasTxtBox() {
        WebElement element = registrationPageElements.addressAliasTxtBox;
        element.clear();
        log.info("Entering Address Alias as => " + Constants.yourAssignAnAddressAlias);
        TestBase.logExtentReport("Entering Address Alias as => " + Constants.yourAssignAnAddressAlias);
        element.sendKeys(Constants.yourAssignAnAddressAlias);
    }

    public boolean verifyRequiredFieldTxt() {
        WebElement ele = registrationPageElements.requiredFieldTxt;
        boolean result = ele.isDisplayed();
        TestBase.logExtentReport(ele.getText() + " is displayed as => " + result);
        log.info(ele.getText() + " is displayed as => " + result);
        return result;
    }

    public void clickingOnRegisterBtn() throws IOException, InterruptedException {
        WebElement RegisterBtn = this.registrationPageElements.registerBtn;
        boolean text = verifyRequiredFieldTxt();
        boolean result = RegisterBtn.isEnabled();
        TestBase.logExtentReport("Clicking on => " + RegisterBtn.getText() + " button");
        TestBase.logExtentReport("Register Button is enabled as => " + result);
        RegisterBtn.click();
    }

    public void isUserOnRegistrationPage() throws Exception {
        verifyCreateAnAccountTxt();
        verifyYourPersonalInformationSectionTxt();
        verifyYourAddressSectionTxt();
    }

    public void enterAllYourPersonalInfomationDetailsSection() throws Exception {
        checkMrRadioBtn();
        enterFirstNameTxtBox();
        enterLastnameTxtBox();
        enterEmailAddressTxtBox();
        enterPasswordTxtBox();
        selectDaysDropdownBtn();
        selectMonthDropdownBtn();
        selectYearDropdownBtn();
        verifySignUpNewsletterTxt();
        CheckOnReceiveSpecialOffersRadioBtn();
    }

    public void enterAllYourAddressDetailsSection() throws InterruptedException {
        enterYourAddressFirstNameTxtBox();
        enterYourAddressLastNameTxtBox();
        enterYourAddressCompanyTxtBox();
        enterAddressTxtBox();
        enterAddress2TxtBox();
        enterYourAddressCityTxtBox();
        selectYourAddressStateDropdownBtn();
        enterYourAddressPostCodeTxtBox();
        selectYourAddressCountryDropdownBtn();
        enterAdditionalInformationTxtBox();
        enterHomePhoneTxtBox();
        enterMobilePhoneTxtBox();
        enterAddressAliasTxtBox();
    }

}
