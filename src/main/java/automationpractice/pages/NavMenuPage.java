package automationpractice.pages;

import automationpractice.elements.NavMenuPageElements;
import org.openqa.selenium.WebDriver;

public class NavMenuPage {
    WebDriver driver;
    NavMenuPageElements navMenuPageElements;

    public NavMenuPage(WebDriver driver) {
        this.driver = driver;
        this.navMenuPageElements = new NavMenuPageElements(driver);
    }


}
