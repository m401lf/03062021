package automationpractice.tests.registration;

import automationpractice.helper.browserConfiguration.config.ObjectReader;
import automationpractice.testbase.TestBase;
import org.testng.annotations.Test;

public class Registration extends TestBase {

    @Test()
    public void register() throws Exception {
        Visit().flowTo().navigateToUrl(ObjectReader.reader.getUrl());
        Visit().pages().headerNavPage().clickOnSigninLink();
        Visit().pages().loginPage().isUserOnLoginPage();
        Visit().pages().loginPage().enterRegistrationEmailAddressTxtBox();
        Visit().pages().loginPage().clickOnCreateAnAccountBtn();
        Visit().pages().registrationPage().enterAllYourPersonalInfomationDetailsSection();
        Visit().pages().registrationPage().enterAllYourAddressDetailsSection();
        Visit().pages().registrationPage().clickingOnRegisterBtn();
        Visit().pages().accountPage().isUserSuccessfulLogin();
        Visit().pages().headerNavPage().clickOnLogoutLink();
    }

}