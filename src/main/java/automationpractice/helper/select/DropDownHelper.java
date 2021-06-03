package automationpractice.helper.select;

import automationpractice.helper.logger.LoggerHelper;
import automationpractice.testbase.TestBase;
import automationpractice.utilities.Constants;
import automationpractice.utilities.Util;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.LinkedList;
import java.util.List;

public class DropDownHelper {

    private WebDriver driver;
    private final Logger log = LoggerHelper.getLogger(DropDownHelper.class);

    public DropDownHelper(WebDriver driver) {
        this.driver = driver;
        log.info("DropDownHelper object created..");
        TestBase.logExtentReport("DropDownHelper object created..");
    }

    public void selectUsingValue(WebElement element, String value) {
        Util.sleep(Constants.two_SECONDS);
        Select select = new Select(element);
        log.info("selectUsingValue and value is: " + value);
        TestBase.logExtentReport("selectUsingValue and value is: " + value);
        select.selectByValue(value);
    }

    public void selectUsingIndex(WebElement element, int index) {
        Util.sleep(Constants.two_SECONDS);
        Select select = new Select(element);
        log.info("selectUsingIndex and index is: " + index);
        TestBase.logExtentReport("selectUsingIndex and index is: " + index);
        select.selectByIndex(index);
    }

    public void selectUsingVisibleText(WebElement element, String visibleText) {
        Util.sleep(Constants.two_SECONDS);
        Select select = new Select(element);
        log.info("selectUsingVisibleText and visibleText is: " + visibleText);
        TestBase.logExtentReport("selectUsingVisibleText and visibleText is: " + visibleText);
        select.selectByVisibleText(visibleText);
    }

    public void deSelectUsingValue(WebElement element, String value) {
        Util.sleep(Constants.two_SECONDS);
        Select select = new Select(element);
        log.info("deSelectUsingValue and value is: " + value);
        TestBase.logExtentReport("deSelectUsingValue and value is: " + value);
        select.deselectByValue(value);
    }

    public void deSelectUsingIndex(WebElement element, int index) {
        Util.sleep(Constants.two_SECONDS);
        Select select = new Select(element);
        log.info("deSelectUsingIndex and index is: " + index);
        TestBase.logExtentReport("deSelectUsingIndex and index is: " + index);
        select.deselectByIndex(index);
    }

    public void deSelectUsingVisibleText(WebElement element, String visibleText) {
        Util.sleep(Constants.two_SECONDS);
        Select select = new Select(element);
        log.info("deselectByVisibleText and visibleText is: " + visibleText);
        TestBase.logExtentReport("deselectByVisibleText and visibleText is: " + visibleText);
        select.deselectByVisibleText(visibleText);
    }

    public List<String> getAllDropDownData(WebElement element) {
        Util.sleep(Constants.two_SECONDS);
        Select select = new Select(element);
        List<WebElement> elementList = select.getOptions();
        List<String> valueList = new LinkedList<String>();
        for (WebElement ele : elementList) {
            log.info(ele.getText());
            TestBase.logExtentReport(ele.getText());
            valueList.add(ele.getText());
        }
        return valueList;
    }
}
