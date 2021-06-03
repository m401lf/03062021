package automationpractice.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class NavMenuPageElements {
    WebDriver driver;
    NavMenuPageElements navMenuPageElements;

    public NavMenuPageElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
