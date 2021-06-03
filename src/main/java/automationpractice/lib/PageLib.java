package automationpractice.lib;

import automationpractice.pages.*;
import automationpractice.testbase.TestBase;
import org.openqa.selenium.WebDriver;

public class PageLib {
    private WebDriver driver;
    private HomePage homePage;
    private HeaderNavPage headerNavPage;
    private LoginPage loginPage;
    private AccountPage accountPage;
    private RegistrationPage registrationPage;
    private SearchPage searchPage;
    private NavMenuPage navMenuPage;
    private TestBase testBase;


    public PageLib(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(this.driver);
        headerNavPage = new HeaderNavPage(this.driver);
        loginPage = new LoginPage(this.driver);
        accountPage = new AccountPage(this.driver);
        registrationPage = new RegistrationPage(this.driver);
        searchPage = new SearchPage(this.driver);
        navMenuPage = new NavMenuPage(this.driver);
        testBase = new TestBase();
    }

    public HomePage homePage() {

        return homePage;
    }

    public HeaderNavPage headerNavPage() {

        return headerNavPage;
    }

    public AccountPage accountPage() {

        return accountPage;
    }

    public RegistrationPage registrationPage() {

        return registrationPage;
    }

    public LoginPage loginPage() {

        return loginPage;
    }

    public SearchPage searchPage() {

        return searchPage;
    }

    public NavMenuPage navMenuPage() {

        return navMenuPage;
    }

    public TestBase testBase() {
        return testBase;
    }
}
