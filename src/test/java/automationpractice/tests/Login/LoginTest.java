package automationpractice.tests.Login;

import automationpractice.helper.logger.LoggerHelper;
import automationpractice.testbase.TestBase;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    Logger log = LoggerHelper.getLogger(LoginTest.class);

    @Test()
    public static void navigateToHomePage() throws Exception {
        Visit().flowTo().navigateToUrl(Visit().pages().homePage().getPageUrl());
        Assert.assertTrue(Visit().pages().homePage().isUserOnHomePage(), "Sign in button Enabled");
    }
    @Test(dependsOnMethods = "navigateToHomePage")
    public static void click0nLoginLink() throws Exception {
        Visit().pages().headerNavPage().clickOnSigninLink();
    }
    @Test(dependsOnMethods = "click0nLoginLink")
    public static void gotoLoginPage() throws Exception {
        Visit().pages().loginPage().isUserOnLoginPage();
    }
    @Test(dependsOnMethods = "gotoLoginPage")
    public void loginWithValidUserCredentials() throws Exception {
        Visit().pages().loginPage().enterUserValidCredentials();
    }
    @Test(dependsOnMethods = "loginWithValidUserCredentials")
    public void gotoAccountPage() throws Exception {
        Visit().pages().accountPage().isUserSuccessfulLogin();
        Visit().pages().headerNavPage().isUserAccountPage();
    }
    @Test(dependsOnMethods = "gotoAccountPage")
    public void clickOnSignOutLink() throws Exception {
        Visit().pages().headerNavPage().clickOnLogoutLink();
    }
    @Test(dependsOnMethods = "clickOnSignOutLink")
    public void backHomePage() throws Exception {
        gotoLoginPage();
    }

}