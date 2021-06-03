package automationpractice.tests.Login;

import automationpractice.helper.browserConfiguration.config.ObjectReader;
import automationpractice.testbase.TestBase;
import org.testng.annotations.Test;

public class Login extends TestBase {

    @Test()
    public void Signin() throws Exception {
        Visit().flowTo().navigateToUrl(ObjectReader.reader.getUrl());
        Visit().pages().headerNavPage().clickOnSigninLink();
        Visit().pages().loginPage().isUserOnLoginPage();
        Visit().pages().loginPage().enterUserValidCredentials();
        Visit().pages().accountPage().isUserSuccessfulLogin();
        Visit().pages().headerNavPage().clickOnLogoutLink();
    }

}