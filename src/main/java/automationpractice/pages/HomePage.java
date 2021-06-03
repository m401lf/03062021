package automationpractice.pages;

import automationpractice.elements.HeaderNavPageElements;
import automationpractice.elements.HomePageElements;
import automationpractice.helper.logger.LoggerHelper;
import automationpractice.testbase.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class HomePage {
    String pageUrl = "http://automationpractice.com/index.php";

    WebDriver driver;
    HomePageElements homePageElements;
    HeaderNavPageElements headerNavPageElements;
    Logger log = LoggerHelper.getLogger(HomePage.class);

    public HomePage(WebDriver driver) {
        this.driver = driver;
        homePageElements = new HomePageElements(driver);
        headerNavPageElements = new HeaderNavPageElements(driver);

    }

    public String testLoginApplication() {

        return pageUrl;
    }

    public boolean PageLogoDisplayed() {
        boolean LogoDisplayed = headerNavPageElements.logoImg.isDisplayed();
        log.info("Page Logo is Displayed =>  " + LogoDisplayed);
        return LogoDisplayed;
    }

    public String getPageUrl() {
        log.info("Current Page Url =>  " + pageUrl);
        return pageUrl;
    }

    public String isPageTitleDisplayed() {
        return homePageElements.pageTitle.getText();
    }

    public void clickOnSignInLink() {
        headerNavPageElements.signinLink.click();
    }

    public boolean isSignInLinkEnabled() {
        boolean displayed = headerNavPageElements.signinLink.isDisplayed();
        headerNavPageElements.signinLink.isEnabled();
        log.info("Page Logo is Displayed =>  " + displayed);
        return displayed;
    }

    public boolean isContactUsLinkEnabled() {
        return headerNavPageElements.contactUsLink.isEnabled();
    }

    public boolean isUserOnHomePage() {
        PageLogoDisplayed();
        getPageUrl();
        isPageTitleDisplayed();
        isSignInLinkEnabled();
        isContactUsLinkEnabled();
        return true;
    }
}

