package automationpractice.elements;

import automationpractice.utilities.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPageElements {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//h1[contains(text(),'Create an account')]")
    public WebElement createAnAccountTxt;

    @FindBy(xpath = "//*[@id=\"account-creation_form\"]/div[1]/h3")
    public WebElement yourPersonalInformationSectionTxt;

    @FindBy(xpath = "//div[@id='uniform-id_gender1']")
    public WebElement mrRadioBtn;

    @FindBy(xpath = ".//*[@id='id_gender2']")
    public WebElement mrsRadioBtn;

    @FindBy(css = "#customer_firstname")
    public WebElement firstNameTxtBox;

    @FindBy(css = "#customer_lastname")
    public WebElement lastnameTxtBox;

    @FindBy(xpath = "//*[@id='email']")
    public WebElement emailAddressTxtBox;

    @FindBy(xpath = "//*[@id='passwd']")
    public WebElement passwordTxtBox;

    @FindBy(css = "#days")
    public WebElement daysDropdownBtn;

    @FindBy(xpath = "//*[@id='months']")
    public WebElement monthDropdownBtn;

    @FindBy(css = "#years")
    public WebElement yearDropdownBtn;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div/form/div[1]/div[7]/label")
    public WebElement signUpNewsletterRadioBtn;

    @FindBy(xpath = "//label[@for='newsletter']")
    public WebElement signUpNewsletterTxt;

    @FindBy(xpath = "//label[@for='optin']")
    public WebElement receiveSpecialOffersRadioBtn;

    @FindBy(xpath = "//label[contains(Txt(),'Receive special offers from our partners!')]")
    public WebElement receiveSpecialOffersTxt;

    @FindBy(xpath = "//*[@id=\"account-creation_form\"]/div[2]/h3")
    public WebElement yourAddressSectionTxt;

    @FindBy(xpath = "//*[@id='firstname']")
    public WebElement yourAddressFirstNameTxtBox;

    @FindBy(xpath = "//*[@id='lastname']")
    public WebElement yourAddressLastNameTxtBox;

    @FindBy(xpath = "//*[@id='company']")
    public WebElement yourAddressCompanyTxtBox;

    @FindBy(xpath = "//*[@id='address1']")
    public WebElement addressTxtBox;

    @FindBy(xpath = "//span[contains(Txt(),'Street address, P.O. Box, Company name, etc.')]")
    public WebElement streetAddressPOBoxCompanyNameEtcTxt;

    @FindBy(xpath = "//*[@id='address2']")
    public WebElement address2TxtBox;

    @FindBy(xpath = "//*[@id='city']")
    public WebElement yourAddressCityTxtBox;

    @FindBy(xpath = "//*[@id='id_state']")
    public WebElement yourAddressStateDropdownBtn;

    @FindBy(xpath = "//*[@id='postcode']")
    public WebElement yourAddressPostCodeTxtBox;

    @FindBy(css = "#id_country")
    public WebElement yourAddressCountryDropdownBtn;

    @FindBy(css = ".pull-right.required")
    public WebElement requiredFieldTxt;

    @FindBy(css = "#other")
    public WebElement additionalInformationTxtBox;

    @FindBy(xpath = "//p[contains(Txt(),'You must registration at least one phone number.')]")
    public WebElement youMustRegisterOnePhoneNumberTxt;

    @FindBy(xpath = "//*[@id='phone']")
    public WebElement homePhoneTxtBox;

    @FindBy(xpath = "//*[@id='phone_mobile']")
    public WebElement mobilePhoneTxtBox;

    @FindBy(xpath = "//*[@id='alias']")
    public WebElement addressAliasTxtBox;

    @FindBy(xpath = "//*[@id='submitAccount']")
    public WebElement registerBtn;

    public RegistrationPageElements(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Constants.thirty_SECONDS);
        PageFactory.initElements(driver, this);
    }

}
