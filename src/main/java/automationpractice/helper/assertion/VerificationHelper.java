package automationpractice.helper.assertion;

import automationpractice.helper.logger.LoggerHelper;
import automationpractice.testbase.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerificationHelper {

    private final WebDriver driver;
    private final Logger log = LoggerHelper.getLogger(VerificationHelper.class);

    public VerificationHelper(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDisplayed(WebElement element) {
        try {
            element.isDisplayed();
            log.info("element is Displayed => " + element.getText());
            TestBase.logExtentReport("element is Displayed => " + element.getText());
            return true;
        } catch (Exception e) {
            log.error("element is not Displayed... ", e.getCause());
            TestBase.logExtentReport("element is not Displayed.." + e.getMessage());
            return false;
        }
    }

    public boolean isNotDisplayed(WebElement element) {
        try {
            element.isDisplayed();
            log.info("element is present => " + element.getText());
            TestBase.logExtentReport("element is present => " + element.getText());
            return false;
        } catch (Exception e) {
            log.error("element is not present..");
            TestBase.logExtentReport("element is not present..");
            return true;
        }
    }

    public String readValueFromElement(WebElement element) {
        if (null == element) {
            log.info("WebElement is null..");
            TestBase.logExtentReport("WebElement is null..");
            return null;
        }
        boolean status = isDisplayed(element);
        if (status) {
            log.info("element text is => " + element.getText());
            TestBase.logExtentReport("element text is => " + element.getText());
            return element.getText();
        } else {
            return null;
        }
    }

    public String getText(WebElement element) {
        if (null == element) {
            log.info("WebElement is null..");
            TestBase.logExtentReport("WebElement is null..");
            return null;
        }
        boolean status = isDisplayed(element);
        if (status) {
            log.info("element text is => " + element.getText());
            TestBase.logExtentReport("element text is => " + element.getText());
            return element.getText();
        } else {
            return null;
        }
    }

    public String getTitle() {
        log.info("page title is => " + driver.getTitle());
        TestBase.logExtentReport("page title is => " + driver.getTitle());
        return driver.getTitle();
    }


}
