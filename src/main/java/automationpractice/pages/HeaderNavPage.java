package automationpractice.pages;

import automationpractice.elements.HeaderNavPageElements;
import automationpractice.helper.assertion.VerificationHelper;
import automationpractice.helper.logger.LoggerHelper;
import automationpractice.testbase.TestBase;
import automationpractice.utilities.Constants;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderNavPage {
    WebDriver driver;
    WebDriverWait wait;
    HeaderNavPageElements headerNavPageElements;
    Logger log = LoggerHelper.getLogger(HeaderNavPage.class);

    public HeaderNavPage(WebDriver driver) {
        this.driver = driver;
        headerNavPageElements = new HeaderNavPageElements(driver);
        this.wait = new WebDriverWait(driver, Constants.thirty_SECONDS);
    }

    public boolean isLogoImageDisplayed() throws Exception {
        WebElement logoImage = headerNavPageElements.logoImg;
        this.wait.until(ExpectedConditions.visibilityOf(logoImage));
        boolean logoDisplayed = logoImage.isDisplayed();
        log.info("Logo is displayed = " + logoDisplayed);
        TestBase.logExtentReport("Register Button is displayed => " + logoDisplayed);
        return logoDisplayed;
    }

    public boolean isSigninLinkEnabled() {
        WebElement signinLink = headerNavPageElements.signinLink;
        this.wait.until(ExpectedConditions.visibilityOf(signinLink));
        boolean logoDisplayed = signinLink.isDisplayed();
        log.info("Logo is displayed = " + logoDisplayed);
        log.info("==================================================");
        log.info("Signin Link is Enabled ");
        log.info("==================================================");
        TestBase.logExtentReport("Signin Link is Displayed ");
        return signinLink.isEnabled();
    }

    public void clickOnSigninLink() throws InterruptedException {
        WebElement signinLink = headerNavPageElements.signinLink;
        this.wait.until(ExpectedConditions.elementToBeClickable(signinLink));
        String signinLinkTxt = signinLink.getText();
        log.info("WebDriver waiting for element visibility....");
        signinLink.click();
        TestBase.logExtentReport("Clicked on Signin Link => " + signinLinkTxt);
        log.info("Clicked on Signin Link => " + signinLinkTxt);
    }

    public boolean isSigninLinkDisplayedAndEnabled() throws InterruptedException {
        WebElement signInLink = headerNavPageElements.signinLink;
        this.wait.until(ExpectedConditions.elementToBeClickable(signInLink));
        boolean displayed = new VerificationHelper(driver).isDisplayed(signInLink);
        boolean result = signInLink.isEnabled();
        log.info("Signin Link is displayed and enabled as => " + displayed+ " and " +result+ " respectively");
        TestBase.logExtentReport("Signin Link is Displayed => " + displayed);
        return displayed;
    }

    public void clickOnContactUsLink() throws InterruptedException {
        WebElement contactusLink = headerNavPageElements.contactUsLink;
        this.wait.until(ExpectedConditions.elementToBeClickable(contactusLink));
        contactusLink.click();
        log.info(" Clicked on Contact us Link");
        TestBase.logExtentReport("Clicked on Signin Link");
    }

    public void clickOnLogoutLink() {
        WebElement logoutLink = headerNavPageElements.signOutLink;
        this.wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
        log.info("Clicking on Sign out Link  => " + logoutLink.getText());
        TestBase.logExtentReport("Clicking on Sign out Link  => " + logoutLink.getText());
        logoutLink.click();
    }

    public boolean isLogoutLinkDisplayed() {
        WebElement logoutLink = headerNavPageElements.signOutLink;
        this.wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
        boolean displayed = logoutLink.isDisplayed();
        log.info("Sign out Link is Displayed => " + displayed);
        TestBase.logExtentReport("Sign out Link is Displayed => " + displayed);
        return displayed;
    }

    public boolean isUserInfoDisplayed() {
        WebElement userInfo = headerNavPageElements.headerUserInfoLink;
        this.wait.until(ExpectedConditions.elementToBeClickable(userInfo));
        String text = userInfo.getText();
        boolean result = new VerificationHelper(driver).isDisplayed(userInfo);
        TestBase.logExtentReport(result+ " is displayed as  => " + text);
        log.info(" User info is displayed as  => " + text);
        return result;
    }

    public boolean isSearchBoxEnabled() {
        WebElement searchBoxElement = headerNavPageElements.searchBox;
        this.wait.until(ExpectedConditions.elementToBeClickable(searchBoxElement));
        boolean result = searchBoxElement.isEnabled();
        log.info("SearchBox is Enabled => " + result);
        TestBase.logExtentReport("SearchBox is Enabled => " + result);
        return result;
    }

    public void ClickOnSearchBtn() {
        WebElement searchElement = headerNavPageElements.searchBtn;
        this.wait.until(ExpectedConditions.elementToBeClickable(searchElement));
        boolean result = new VerificationHelper(driver).isDisplayed(searchElement);
        log.info("Clicking on Search Btn  => " + result);
        TestBase.logExtentReport("Clicking on Search Btn  => " + result);
        searchElement.click();
    }

    public void isUserAccountPage() {
        isUserInfoDisplayed();
        isLogoutLinkDisplayed();
        isLogoutLinkDisplayed();
    }

}
