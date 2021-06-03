package automationpractice.pages;

import automationpractice.elements.*;
import automationpractice.helper.assertion.AssertionHelper;
import automationpractice.helper.assertion.VerificationHelper;
import automationpractice.helper.logger.LoggerHelper;
import automationpractice.helper.wait.WaitHelper;
import automationpractice.testbase.TestBase;
import automationpractice.utilities.Constants;
import com.aventstack.extentreports.Status;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;
    WaitHelper waitHelper;
    WebDriverWait wait;
    LoginPageElements loginPageElements;
    HomePageElements homePageElements;
    HeaderNavPageElements headerNavPageElements;
    RegistrationPageElements registrationPageElements;
    RegistrationConfirmationPageElements registrationConfirmationPageElements;
    Logger log = LoggerHelper.getLogger(LoginPage.class);

    // Constructor //
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.loginPageElements = new LoginPageElements(driver);
        this.homePageElements = new HomePageElements(driver);
        this.headerNavPageElements = new HeaderNavPageElements(driver);
        this.registrationConfirmationPageElements = new RegistrationConfirmationPageElements(driver);
        this.registrationPageElements = new RegistrationPageElements(driver);
        this.wait = new WebDriverWait(driver, 30);

    }
    public boolean verifyHomeIcon() {
        WebElement iconImg = loginPageElements.homeIcon;
        WebDriverWait wait = new WebDriverWait(driver, 30);
        boolean result = new VerificationHelper(driver).isDisplayed(iconImg);
        wait.until(ExpectedConditions.elementToBeClickable(iconImg));
        TestBase.logExtentReport("Home Icon is displayed => ");
        log.info("Home Icon is displayed");
        AssertionHelper.updateTestStatus(result);
        return result;
    }

    public boolean verifyAuthenticationHeaderTxt() {
        WebElement authenticationHeaderTxt = loginPageElements.authenticationHeaderTxt;
        boolean result = authenticationHeaderTxt.isDisplayed();
        TestBase.logExtentReport("Authentication Header Txt is displayed as => " + authenticationHeaderTxt.getText());
        log.info("Authentication Header Txt is displayed as => " + result);
        AssertionHelper.updateTestStatus(result);
        return result;
    }

    public void enterEmailAddressTxtBox() {
        log.info("Entering email address as => " + Constants.email);
        logExtentReport("Entering email address as => " + Constants.email);
        loginPageElements.emailAddressTxtBox.sendKeys(Constants.email);
    }

    public void enterPasswordTxtBox() {
        log.info("Entering password as => " + Constants.pass);
        TestBase.logExtentReport("Entering Password as => " + Constants.pass);
        loginPageElements.passwordTxtBox.sendKeys(Constants.password);
    }

    public void clickOnSigninBtn() {
        WebElement signinBtn = loginPageElements.signinBtn;
        log.info("Clicking on submit button as => " + signinBtn.getText().trim());
        //new TestBase().getNavigationScreen(driver);
        TestBase.logExtentReport("Clicking on submit button as => " + signinBtn.getText().trim());
        signinBtn.click();
    }

    public boolean verifyForgotYourPasswordTxt() {
        WebElement forgotYourPasswordTxt = loginPageElements.forgotYourPasswordTxt;
        boolean result = forgotYourPasswordTxt.isDisplayed();
        TestBase.logExtentReport("Already Registered Txt as => " + forgotYourPasswordTxt.getText());
        log.info("Already Registered Txt as => " + forgotYourPasswordTxt.getText());
        AssertionHelper.updateTestStatus(result);
        return result;
    }

    public boolean verifyAlreadyRegisteredTxt() {
        WebElement alreadyRegisteredTxt = loginPageElements.alreadyRegisteredTxt;
        boolean result = new VerificationHelper(driver).isDisplayed(alreadyRegisteredTxt);
        TestBase.logExtentReport("Already Registered Txt as => " + alreadyRegisteredTxt.getText());
        AssertionHelper.updateTestStatus(result);
        return result;
    }

    public void enterRegistrationEmailAddressTxtBox() {
        String email = System.currentTimeMillis() + "@gmail.com";
        log.info("Entering registration email as => " + email);
        loginPageElements.registrationEmailAddressTxtBox.sendKeys(email);
        new TestBase().getNavigationScreen(driver);
        TestBase.logExtentReport("Entering registration email as => " + email);
    }

    public void clickOnCreateAnAccountBtn() throws InterruptedException {
        Thread.sleep(2000);
        log.info("click On Create An Account Btn");
        wait.until(ExpectedConditions.elementToBeClickable(loginPageElements.createAnAccountButton));
        TestBase.logExtentReport("click On Create An Account Btn => " + loginPageElements.createAnAccountButton.getText());
        loginPageElements.createAnAccountButton.click();
    }

    public boolean verifyAuthenticationTxt() {
        WebElement AuthenticationTxt = loginPageElements.authenticationTxt;
        boolean result = new VerificationHelper(driver).isDisplayed(AuthenticationTxt);
        TestBase.logExtentReport("Authentication Txt as => " + AuthenticationTxt.getText());
        log.info("Authentication Txt as => " + AuthenticationTxt.getText());
        AssertionHelper.updateTestStatus(result);
        return result;
    }

    public boolean verifyCreateAnAccountTxt() {
        WebElement CreateAnAccountTxt = loginPageElements.createAnAccountTxt;
        boolean result = new VerificationHelper(driver).isDisplayed(CreateAnAccountTxt);
        TestBase.logExtentReport("Create An Account Txt as => " + CreateAnAccountTxt.getText());
        log.info("Create An Account Txt as => " + CreateAnAccountTxt.getText());
        AssertionHelper.updateTestStatus(result);
        return result;
    }

    public boolean verifyPleaseEnterYourEmailTxt() {
        WebElement PleaseEnterYourEmailTxt = loginPageElements.pleaseEnterYourEmailAddressToCreateAnAccountTxt;
        boolean result = new VerificationHelper(driver).isDisplayed(PleaseEnterYourEmailTxt);
        log.info("Please Enter Your Email Txt => " + PleaseEnterYourEmailTxt.getText());
        TestBase.logExtentReport("Please Enter Your Email Txt as => " + PleaseEnterYourEmailTxt.getText());
        AssertionHelper.updateTestStatus(result);
        return result;
    }

    public AccountPage enterUserValidCredentials() {
        enterEmailAddressTxtBox();
        enterPasswordTxtBox();
        clickOnSigninBtn();
        new TestBase().getNavigationScreen(driver);
        TestBase.logExtentReport("Login With Valid Credentials");
        return new AccountPage(driver);
    }

    public void logExtentReport(String s1) {
        TestBase.test.log(Status.INFO, s1);

    }

    public void isUserOnLoginPage() throws InterruptedException {
        verifyAlreadyRegisteredTxt();
        verifyAuthenticationHeaderTxt();
        verifyAuthenticationTxt();
        verifyCreateAnAccountTxt();
        verifyForgotYourPasswordTxt();
        verifyPleaseEnterYourEmailTxt();
        new TestBase().getNavigationScreen(driver);
    }
}
