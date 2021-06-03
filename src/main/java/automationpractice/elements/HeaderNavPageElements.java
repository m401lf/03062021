package automationpractice.elements;

import automationpractice.utilities.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HeaderNavPageElements {
    WebDriver driver;
    WebDriverWait wait;

    public String welcomeMessage = "//div[contains(text(),'Welcome back Bee')]";
    public String loginOrRegisterLink = "Login or registration";
    public String logoutLink = "//body/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[10]/a[1]";

    @FindBy(xpath = "//head//title")
    public WebElement baseTitle;

    @FindBy(id = "contact-link")
    public WebElement contactUsLink;

    @FindBy(xpath = "//*[@id=\"header\"]/div[1]/div")
    public WebElement bannerSale70PercentImg;

    @FindBy(xpath = "//a[contains(text(),'Sign in')]")
    public WebElement signinLink;

    @FindBy(xpath = "//b[contains(text(),'Cart')]")
    public WebElement cartLink;

    @FindBy(xpath = "//*[@id=\"header\"]/div[3]")
    public List<WebElement> logoSearchCartArea;

    @FindBy(xpath = "//header/div[3]/div[1]/div[1]/div[1]/a[1]/img[1]")
    public WebElement logoImg;

    @FindBy(xpath = "//header/div[2]/div[1]/div[1]/nav[1]/span[1]")
    public WebElement callUsNowText;

    @FindBy(css = "a.logout")
    public WebElement signOutLink;

    @FindBy(css = "a.account")
    public WebElement headerUserInfoLink;

    @FindBy(xpath = "//input[@id='search_query_top']")
    public WebElement searchBox;

    @FindBy(name = "submit_search")
    public WebElement searchBtn;

    public HeaderNavPageElements(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Constants.thirty_SECONDS);
        PageFactory.initElements(driver, this);

    }
}
