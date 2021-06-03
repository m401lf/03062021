package automationpractice.elements;

import automationpractice.utilities.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationConfirmationPageElements {

    WebDriver driver;
    WebDriverWait wait;
    RegistrationConfirmationPageElements accountPageElements;


    @FindBy(css = ".info-account")
    public WebElement welcomeAccountTxt;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/h1")
    public WebElement myAccountText;

    @FindBy(xpath = "//span[contains(text(),'Order history and details')]")
    public WebElement orderHistoryAndDetailsLink;

    @FindBy(xpath = "//span[contains(text(),'My credit slips')]")
    public WebElement myCreditSlipsLink;

    @FindBy(xpath = "//span[contains(text(),'My addresses')]")
    public WebElement myAddressesLink;

    @FindBy(xpath = "//span[contains(text(),'My personal information')]")
    public WebElement myPersonalInformationTxt;

    @FindBy(xpath = "//span[contains(text(),'My wishlists')]")
    public WebElement myWishlistsLink;

    @FindBy(xpath = "//*[@id='center_column']/p")
    public WebElement successMsgObject;

    public RegistrationConfirmationPageElements(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Constants.thirty_SECONDS);
        PageFactory.initElements(driver, this);
    }
}
