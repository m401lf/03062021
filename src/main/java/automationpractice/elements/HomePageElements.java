package automationpractice.elements;

import automationpractice.utilities.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageElements {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//head//title")
    public WebElement pageTitle;

    @FindBy(xpath = "//a[@class='Login']")
    public WebElement SigninButton;

    public HomePageElements(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Constants.thirty_SECONDS);
        PageFactory.initElements(driver, this);
    }

}
