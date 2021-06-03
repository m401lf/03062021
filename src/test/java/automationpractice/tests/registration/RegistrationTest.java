package automationpractice.tests.registration;

import automationpractice.helper.browserConfiguration.config.ObjectReader;
import automationpractice.helper.logger.LoggerHelper;
import automationpractice.testbase.TestBase;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {
    Logger log = LoggerHelper.getLogger(RegistrationTest.class);

    @Test()
    public void gotoHomePage() throws Exception {
        Visit().flowTo().navigateToUrl(ObjectReader.reader.getUrl());
    }
    @Test(dependsOnMethods = "gotoHomePage")
    public void click0nLoginLink() throws Exception {
        Visit().pages().headerNavPage().clickOnSigninLink();
    }
    @Test(dependsOnMethods = "click0nLoginLink")
    public void gotoLoginPage() throws Exception {
        Visit().pages().loginPage().isUserOnLoginPage();
    }
    @Test(dependsOnMethods = "gotoLoginPage")
    public void enterRegistrationEmailAddress() throws Exception {
        Visit().pages().loginPage().enterRegistrationEmailAddressTxtBox();
    }
    @Test(dependsOnMethods = "enterRegistrationEmailAddress")
    public void clickOnCreateAnAccountBtn() throws Exception {
        Visit().pages().loginPage().clickOnCreateAnAccountBtn();
    }
    @Test(dependsOnMethods = "clickOnCreateAnAccountBtn")
    public void gotoRegistrationPage() throws Exception {
        Visit().pages().registrationPage().isUserOnRegistrationPage();
    }
    @Test(dependsOnMethods = "gotoRegistrationPage")
    public void enterUserPersonalInfomationDetails() throws Exception {
        Visit().pages().registrationPage().enterAllYourPersonalInfomationDetailsSection();
    }
    @Test(dependsOnMethods = "enterUserPersonalInfomationDetails")
    public void enterUserAddressDetails() throws Exception {
        Visit().pages().registrationPage().enterAllYourAddressDetailsSection();
    }
    @Test(dependsOnMethods = "enterUserAddressDetails")
    public void clickOnRegisterBtn() throws Exception {
        Visit().pages().registrationPage().clickingOnRegisterBtn();
    }
    @Test(dependsOnMethods = "clickOnRegisterBtn")
    public void gotoAccountPage() throws Exception {
        Visit().pages().accountPage().isUserSuccessfulLogin();
    }
    @Test(dependsOnMethods = "gotoAccountPage")
    public void clickOnLogoutLink() throws Exception {
        Visit().pages().headerNavPage().clickOnLogoutLink();
    }
    @Test(dependsOnMethods = "clickOnLogoutLink")
    public void backHomePage() throws Exception {
        gotoHomePage();
    }

}