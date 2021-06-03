package automationpractice.pages;

import automationpractice.elements.HeaderNavPageElements;
import automationpractice.elements.SearchPageElements;
import automationpractice.helper.logger.LoggerHelper;
import automationpractice.utilities.Constants;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
    WebDriver driver;
    WebDriverWait wait;
    SearchPageElements searchPageElements;
    HeaderNavPageElements headerNavPageElements;
    Logger log = LoggerHelper.getLogger(SearchPage.class);


    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.searchPageElements = new SearchPageElements(driver);
        this.headerNavPageElements = new HeaderNavPageElements(driver);
        this.wait = new WebDriverWait(driver, Constants.thirty_SECONDS);
    }

    public void clickSearchButton() {
        headerNavPageElements.searchBtn.click();
    }

    public boolean isSearchButtonEnabled() {
        return headerNavPageElements.searchBtn.isEnabled();
    }

}

