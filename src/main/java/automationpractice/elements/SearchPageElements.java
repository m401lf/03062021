package automationpractice.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SearchPageElements {
    WebDriver driver;


    public SearchPageElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);


    }

}
