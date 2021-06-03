package automationpractice.pages;

import automationpractice.elements.HeaderNavPageElements;
import automationpractice.elements.LoginPageElements;
import automationpractice.elements.RegistrationConfirmationPageElements;
import automationpractice.elements.RegistrationPageElements;
import automationpractice.helper.assertion.AssertionHelper;
import automationpractice.helper.assertion.VerificationHelper;
import automationpractice.helper.logger.LoggerHelper;
import automationpractice.testbase.TestBase;
import automationpractice.utilities.Constants;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage {
    WebDriver driver;
    WebDriverWait wait;
    HeaderNavPageElements headerNavPageElements;
    LoginPageElements loginPageElements;
    RegistrationPageElements registrationPageElements;
    RegistrationConfirmationPageElements registrationConfirmationPageElements;
    Logger log = LoggerHelper.getLogger(AccountPage.class);

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Constants.thirty_SECONDS);
        registrationConfirmationPageElements = new RegistrationConfirmationPageElements(driver);
        this.registrationPageElements = new RegistrationPageElements(driver);
        headerNavPageElements = new HeaderNavPageElements(driver);
        loginPageElements = new LoginPageElements(driver);
    }
    public boolean verifyWelcomeAccountTxt() throws InterruptedException {
        WebElement WelcomeAccountTxt = registrationConfirmationPageElements.welcomeAccountTxt;
        String text = WelcomeAccountTxt.getText();
        boolean result = new VerificationHelper(driver).isDisplayed(WelcomeAccountTxt);
        log.info("Welcome Account Txt displayed as => " + text);
        TestBase.logExtentReport("Welcome Account Txt displayed as => " + result);
        AssertionHelper.updateTestStatus(result);
        return result;
    }
    public boolean verifyMyAccountText() throws InterruptedException {
        WebElement MyAccountText = registrationConfirmationPageElements.myAccountText;
        String text = MyAccountText.getText();
        boolean result = new VerificationHelper(driver).isDisplayed(MyAccountText);
        log.info("My AccountText displayed as => " + text);
        TestBase.logExtentReport("My AccountText displayed as => " + result);
        AssertionHelper.updateTestStatus(result);
        return result;
    }
    public boolean verifyOrderHistoryAndDetailsLink() throws InterruptedException {
        WebElement OrderHistoryAndDetailsLink = registrationConfirmationPageElements.orderHistoryAndDetailsLink;
        String text = OrderHistoryAndDetailsLink.getText();
        boolean result = new VerificationHelper(driver).isDisplayed(OrderHistoryAndDetailsLink);
        log.info("My Order History And Details Link displayed as => " + text);
        TestBase.logExtentReport("My Order History And Details Link displayed as => " + result);
        AssertionHelper.updateTestStatus(result);
        return result;
    }
    public boolean verifyMyCreditSlipsLink() throws InterruptedException {
        WebElement MyCreditSlipsLink = registrationConfirmationPageElements.myCreditSlipsLink;
        String text = MyCreditSlipsLink.getText();
        boolean result = new VerificationHelper(driver).isDisplayed(MyCreditSlipsLink);
        log.info("My CreditSlips Link displayed as => " + text);
        TestBase.logExtentReport("My CreditSlips Link displayed as => " + result);
        AssertionHelper.updateTestStatus(result);
        return result;
    }
    public boolean verifyMyAddressesLink() throws InterruptedException {
        WebElement MyAddressesLink = registrationConfirmationPageElements.myAddressesLink;
        this.wait.until(ExpectedConditions.visibilityOf(MyAddressesLink));
        String text = MyAddressesLink.getText();
        boolean result = new VerificationHelper(driver).isDisplayed(MyAddressesLink);
        log.info("My Addresses Link displayed as => " + text);
        TestBase.logExtentReport("My Addresses Link displayed as => " + result);
        AssertionHelper.updateTestStatus(result);
        return result;
    }
    public boolean verifyMyPersonalInformationTxt() throws InterruptedException {
        WebElement MyCreditSlips = registrationConfirmationPageElements.myPersonalInformationTxt;
        this.wait.until(ExpectedConditions.visibilityOf(MyCreditSlips));
        String text = MyCreditSlips.getText();
        boolean result = new VerificationHelper(driver).isDisplayed(MyCreditSlips);
        log.info("My Personal Information Link displayed as => " + text);
        TestBase.logExtentReport("My Personal Information Link displayed as => " + result);
        AssertionHelper.updateTestStatus(result);
        return result;
    }
    public boolean verifyMyWishlistsLink() throws InterruptedException {
        WebElement MyWishlists = registrationConfirmationPageElements.myWishlistsLink;
        this.wait.until(ExpectedConditions.visibilityOf(MyWishlists));
        String text = MyWishlists.getText();
        boolean result = MyWishlists.isDisplayed();
        log.info("My Wishlists displayed as => " + text);
        TestBase.logExtentReport("My Wishlists displayed as => " + result);
        AssertionHelper.updateTestStatus(result);
        return result;
    }
    public boolean verifyHeaderUserInfoLink() throws InterruptedException{
        this. wait.until(ExpectedConditions.visibilityOf(headerNavPageElements.headerUserInfoLink));
        WebElement UserInfo = headerNavPageElements.headerUserInfoLink;
        String text = UserInfo.getText();
        boolean result = UserInfo.isDisplayed();
        log.info("User Info Link displayed as => " + text);
        TestBase.logExtentReport("User Info Link displayed as => " + result);
        TestBase.logExtentReport("User Info Link displayed as => " + text);
        AssertionHelper.updateTestStatus(result);
        return result;
    }
    public boolean verifySuccessLoginMsg() {
        WebElement SuccessLoginMsg = registrationConfirmationPageElements.successMsgObject;
        this.wait.until(ExpectedConditions.visibilityOf(SuccessLoginMsg));
        boolean result = new VerificationHelper(driver).isDisplayed(SuccessLoginMsg);
        TestBase.logExtentReport("Success welcome message as => " + SuccessLoginMsg.getText());
        log.info("Success welcome message as => " + SuccessLoginMsg.getText());
        new TestBase().getNavigationScreen(driver);
        AssertionHelper.updateTestStatus(result);
        return result;
    }
    public void isUserSuccessfulLogin() throws InterruptedException {
        verifyWelcomeAccountTxt();
        verifyMyAccountText();
        verifyOrderHistoryAndDetailsLink();
        verifyMyCreditSlipsLink();
        verifyMyAddressesLink();
        verifyMyWishlistsLink();
        verifySuccessLoginMsg();
    }


}
