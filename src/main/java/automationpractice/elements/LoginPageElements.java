package automationpractice.elements;

import automationpractice.utilities.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPageElements {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(css = ".navigation-pipe")
    public WebElement homeIcon;

    @FindBy(xpath = "//*[@id=\"center_column\"]/h1")
    public WebElement authenticationHeaderTxt;

    @FindBy(xpath = "//*[@id='email']")
    public WebElement emailAddressTxtBox;

    @FindBy(xpath = "//*[@id='passwd']")
    public WebElement passwordTxtBox;

    @FindBy(xpath = "//a[contains(text(),'Forgot your password?')]")
    public WebElement forgotYourPasswordTxt;

    @FindBy(xpath = "//*[@id='SubmitLogin']")
    public WebElement signinBtn;

    @FindBy(xpath = "//*[@id='center_column']/p")
    public WebElement successMsgObject;

    @FindBy(xpath = "//*[@id=\"login_form\"]/h3")
    public WebElement alreadyRegisteredTxt;

    @FindBy(xpath = "//*[@id='email_create']")
    public WebElement registrationEmailAddressTxtBox;

    @FindBy(css = "#SubmitCreate")
    public WebElement createAnAccountButton;

    @FindBy(xpath = "//*[@id='center_column']/h1")
    public WebElement authenticationTxt;

    @FindBy(xpath = "//*[@id='create-account_form']/div/p")
    public WebElement createAnAccountTxt;

    @FindBy(xpath = "//p[contains(text(),'Please enter your email address to create an accou')]")
    public WebElement pleaseEnterYourEmailAddressToCreateAnAccountTxt;

    // Constructor //
    public LoginPageElements(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Constants.thirty_SECONDS);
        PageFactory.initElements(driver, this);
    }
}
