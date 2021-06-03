package automationpractice.utilities;

import automationpractice.helper.logger.LoggerHelper;
import automationpractice.testbase.TestBase;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class CustomDrivers extends TestBase {
    static WebDriver driver;
    protected static WebDriverWait wait;
    protected JavascriptExecutor jsExecutor;
    private static JavascriptExecutor js;
    private static final Logger log = LoggerHelper.getLogger(CustomDrivers.class);

    public CustomDrivers() {
        this.wait = new WebDriverWait(driver, 60);
        jsExecutor = ((JavascriptExecutor) driver);
    }

    public CustomDrivers(WebDriver driver) {
        this.driver = driver;
        js = (JavascriptExecutor) driver;
    }

    /**
     * Refresh the current browser session
     */
    public static void refresh() {
        driver.navigate().refresh();
        log.info("The Current Browser location was Refreshed...");
        TestBase.logExtentReport("The Current Browser location was Refreshed...");
        Util.sleep(Constants.three_SECONDS, "The Current Browser location was Refreshed...");
    }

    /**
     * @return Returns the Current Page Title
     */
    public String getTitle() {
        String title = driver.getTitle();
        log.info("Title of the page is :: " + title);
        TestBase.logExtentReport("Title of the page is :: " + title);
        return title;
    }

    /**
     * @return Current Browser URL
     */
    public String getURL() {
        String url = driver.getCurrentUrl();
        log.info("Current URL is :: " + url);
        TestBase.logExtentReport("Current URL is :: " + url);
        return url;
    }

    /**
     * Navigate browser back
     */
    public static void navigateBrowserBack() {
        driver.navigate().back();
        log.info("Navigate back");
        TestBase.logExtentReport("Navigate back");
    }

    /**
     * Navigate browser forward
     */
    public static void navigateBrowserForward() {
        driver.navigate().back();
        log.info("Navigate back");
        TestBase.logExtentReport("Navigate back");
    }

    /***
     * Builds the By type with given locator strategy
     * @param locator - locator strategy, id=>example, name=>example, css=>#example,
     *      *                tag=>example, xpath=>//example, link=>example
     * @return Returns By Type
     */
    public static By getByType(String locator) {
        By by = null;
        String locatorType = locator.split("=>")[0];
        locator = locator.split("=>")[1];
        try {
            if (locatorType.contains("id")) {
                by = By.id(locator);
            } else if (locatorType.contains("name")) {
                by = By.name(locator);
            } else if (locatorType.contains("xpath")) {
                by = By.xpath(locator);
            } else if (locatorType.contains("css")) {
                by = By.cssSelector(locator);
            } else if (locatorType.contains("class")) {
                by = By.className(locator);
            } else if (locatorType.contains("tag")) {
                by = By.tagName(locator);
            } else if (locatorType.contains("link")) {
                by = By.linkText(locator);
            } else if (locatorType.contains("partiallink")) {
                by = By.partialLinkText(locator);
            } else {
                log.info("Locator type not supported");
                TestBase.logExtentReport("Locator type not supported");
            }
        } catch (Exception e) {
            log.info("By type not found with: " + locatorType);
            TestBase.logExtentReport("By type not found with: " + locatorType);
        }
        return by;
    }

    /**
     * Builds The WebElement By given locator strategy
     *
     * @param locator - locator strategy, id=>example, name=>example, css=>#example,
     *                tag=>example, xpath=>//example, link=>example
     * @param info    - Information about element, usually text on element
     * @return WebElement
     */
    public static WebElement getElement(String locator, String info) {
        WebElement element = null;
        By byType = getByType(locator);
        try {
            element = driver.findElement(byType);
        } catch (Exception e) {
            log.info("Element not found with: " + locator);
            TestBase.logExtentReport("Element not found with: " + locator);
            e.printStackTrace();
        }
        return element;
    }

    public static List<WebElement> getElementList(String locator, String info) {
        List<WebElement> elementList = new ArrayList<WebElement>();
        By byType = getByType(locator);
        try {
            elementList = driver.findElements(byType);
            if (elementList.size() > 0) {
                log.info("Element List found with: " + locator);
                TestBase.logExtentReport("Element List found with: " + locator);
            } else {
                log.info("Element List not found with: " + locator);
                TestBase.logExtentReport("Element List not found with: " + locator);
            }
        } catch (Exception e) {
            log.info("Element List not found with: " + locator);
            TestBase.logExtentReport("Element List not found with: " + locator);
            e.printStackTrace();
        }
        return elementList;
    }

    /***
     * Check if element is present
     * @param locator locator strategy, id=>example, name=>example, css=>#example,
     *      *                tag=>example, xpath=>//example, link=>example
     * @return boolean if element is present or not
     */
    public boolean isElementPresent(String locator, String info) {
        List<WebElement> elementList = getElementList(locator, info);
        int size = elementList.size();
        if (size > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Click element with information about element and
     * time to wait in seconds after click
     *
     * @param element - WebElement to perform Click operation
     * @param info    - information about element
     */
    public static  void elementClick(WebElement element, String info, long timeToWait) {
        try {
            element.click();
            if (timeToWait == 0) {
                log.info("Clicked On :: " + info);
                TestBase.logExtentReport("Clicked On :: " + info);
            } else {
                Util.sleep(timeToWait, "Clicked on :: " + info);
            }
        } catch (Exception e) {
            log.info("Cannot click on :: " + info);
            TestBase.logExtentReport("Cannot click on :: " + info);
            takeScreenshot("Click ERROR", "");
        }
    }

    /**
     * Click element with no time to wait after click
     *
     * @param element - WebElement to perform Click operation
     * @param info    - information about element
     */
    public static void elementClick(WebElement element, String info) {
        elementClick(element, info, 0);
    }

    /**
     * Click element with locator
     *
     * @param locator    - locator strategy, id=>example, name=>example, css=>#example,
     *                   *                tag=>example, xpath=>//example, link=>example
     * @param info
     * @param timeToWait
     * @return
     */
    public static void elementClick(String locator, String info, long timeToWait) {
        WebElement element = getElement(locator, info);
        elementClick(element, info, timeToWait);
    }

    /**
     * Click element with locator and no time to wait
     *
     * @param locator - locator strategy, id=>example, name=>example, css=>#example,
     *                *                tag=>example, xpath=>//example, link=>example
     * @param info    - Information about element
     * @return
     */
    public static  void elementClick(String locator, String info) {
        WebElement element = getElement(locator, info);
        elementClick(element, info, 0);
    }

    /***
     * Click element using JavaScript
     * @param element - WebElement to perform Click operation
     * @param info - Information about element
     */
    public static  void javascriptClick(WebElement element, String info) {
        try {
            js.executeScript("arguments[0].click();", element);
            log.info("Clicked on :: " + info);
            TestBase.logExtentReport("Clicked on :: " + info);
        } catch (Exception e) {
            log.info("Cannot click on :: " + info);
            TestBase.logExtentReport("Cannot click on :: " + info);
        }
    }

    /***
     * Click element using JavaScript
     * @param locator - locator strategy, id=>example, name=>example, css=>#example,
     *      *                tag=>example, xpath=>//example, link=>example
     * @param info - Information about element
     */
    public static void javascriptClick(String locator, String info) {
        WebElement element = getElement(locator, info);
        try {
            js.executeScript("arguments[0].click();", element);
            log.info("Clicked on :: " + info);
            TestBase.logExtentReport("Clicked on :: " + info);
        } catch (Exception e) {
            log.info("Cannot click on :: " + info);
            TestBase.logExtentReport("Cannot click on :: " + info);
        }
    }

    /***
     * Click element when element is clickable
     * @param locator - locator strategy, id=>example, name=>example, css=>#example,
     *      *                tag=>example, xpath=>//example, link=>example
     * @param timeout - Duration to try before timeout
     */
    public static void clickWhenReady(By locator, int timeout) {
        try {
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            WebElement element = null;
            log.info("Waiting for max:: " + timeout + " seconds for element to be clickable");
            TestBase.logExtentReport("Waiting for max:: " + timeout + " seconds for element to be clickable");
            WebDriverWait wait = new WebDriverWait(driver, 15);
            element = wait.until(
                    ExpectedConditions.elementToBeClickable(locator));
            element.click();
            log.info("Element clicked on the web page");
            TestBase.logExtentReport("Element clicked on the web page");
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        } catch (Exception e) {
            log.info("Element not appeared on the web page");
            TestBase.logExtentReport("Element not appeared on the web page");
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        }
    }

    /***
     * Send Keys to element
     * @param element - WebElement to send data
     * @param data - Data to send
     * @param info - Information about element
     * @param clear - True if you want to clear the field before sending data
     */
    public static  void sendData(WebElement element, String data, String info, Boolean clear) {
        try {
            if (clear) {
                element.clear();
            }
            Util.sleep(1000, "Waiting Before Entering Data");
            element.sendKeys(data);
            log.info("Send Keys on element :: "
                    + info + " with data :: " + data);
            TestBase.logExtentReport("Send Keys on element :: "
                    + info + " with data :: " + data);
        } catch (Exception e) {
            log.info("Cannot send keys on element :: "
                    + info + " with data :: " + data);
            TestBase.logExtentReport("Cannot send keys on element :: "
                    + info + " with data :: " + data);
        }
    }

    /***
     * Send Keys to element with locator
     * @param locator - locator strategy, id=>example, name=>example, css=>#example,
     *      *                tag=>example, xpath=>//example, link=>example
     * @param data - Data to send
     * @param info - Information about element
     * @param clear - True if you want to clear the field before sending data
     */
    public static void sendData(String locator, String data, String info, Boolean clear) {
        WebElement element = getElement(locator, info);
        sendData(element, data, info, clear);
    }

    /***
     * Send Keys to element with clear
     * @param element - WebElement to send data
     * @param data - Data to send
     * @param info - Information about element
     */
    public static void sendData(WebElement element, String data, String info) {
        sendData(element, data, info, true);
    }

    /***
     * Send Keys to element with locator and clear
     * @param locator - locator strategy, id=>example, name=>example, css=>#example,
     *      *                tag=>example, xpath=>//example, link=>example
     * @param data - Data to send
     * @param info - Information about element
     */
    public static void sendData(String locator, String data, String info) {
        WebElement element = getElement(locator, info);
        sendData(element, data, info, true);
    }

    /**
     * Get text of a web element
     *
     * @param element - WebElement to perform click action
     * @param info    - Information about element
     */
    public String getText(WebElement element, String info) {
        log.info("Getting Text on element :: " + info);
        String text = null;
        text = element.getText();
        if (text.length() == 0) {
            text = element.getAttribute("innerText");
        }
        if (!text.isEmpty()) {
            log.info(" The text is : " + text);
            TestBase.logExtentReport(" The text is : " + text);
        } else {
            text = "NOT_FOUND";
        }
        return text.trim();
    }

    /**
     * Get text of a web element with locator
     *
     * @param locator
     * @param info
     * @return
     */
    public String getText(String locator, String info) {
        WebElement element = getElement(locator, info);
        return this.getText(element, info);
    }

    /**
     * Check if element is enabled
     *
     * @param element
     * @param info
     * @return
     */
    public Boolean isEnabled(WebElement element, String info) {
        Boolean enabled = false;
        if (element != null) {
            enabled = element.isEnabled();
            if (enabled)
                log.info("Element :: " + info + " is Enabled");
            if (enabled)
                TestBase.logExtentReport("Element :: " + info + " is Enabled");
            else
                log.info("Element :: " + info + " is Disabled");
            TestBase.logExtentReport("Element :: " + info + " is Disabled");
        }
        return enabled;
    }

    /***
     * Check if element is enabled with locator
     * @param locator
     * @param info
     * @return
     */
    public Boolean isEnabled(String locator, String info) {
        WebElement element = getElement(locator, info);
        return this.isEnabled(element, info);
    }

    /**
     * Check if element is displayed
     *
     * @param element
     * @param info
     * @return
     */
    public Boolean isDisplayed(WebElement element, String info) {
        Boolean displayed = false;
        if (element != null) {
            displayed = element.isDisplayed();
            if (displayed)
                log.info("Element :: " + info + " is displayed");
            if (displayed)
                TestBase.logExtentReport("Element :: " + info + " is displayed");
            else
                log.info("Element :: " + info + " is NOT displayed");
            TestBase.logExtentReport("Element :: " + info + " is NOT displayed");


        }
        return displayed;
    }

    /***
     * Check if element is displayed with locator
     * @param locator
     * @param info
     * @return
     */
    public Boolean isDisplayed(String locator, String info) {
        WebElement element = getElement(locator, info);
        return this.isDisplayed(element, info);
    }

    /**
     * @param element
     * @param info
     * @return
     */
    public static Boolean isSelected(WebElement element, String info) {
        Boolean selected = false;
        if (element != null) {
            selected = element.isSelected();
            if (selected)
                log.info("Element :: " + info + " is selected");
            if (selected)
                TestBase.logExtentReport("Element :: " + info + " is selected");
            else
                log.info("Element :: " + info + " is already selected");
            TestBase.logExtentReport("Element :: " + info + " is already selected");
        }
        return selected;
    }

    /**
     * @param locator
     * @param info
     * @return
     */
    public Boolean isSelected(String locator, String info) {
        WebElement element = getElement(locator, info);
        return isSelected(element, info);
    }

    /**
     * Selects a check box irrespective of its state
     *
     * @param element
     * @param info
     */
    public static void Check(WebElement element, String info) {
        if (!isSelected(element, info)) {
            elementClick(element, info);
            log.info("Element :: " + info + " is checked");
            TestBase.logExtentReport("Element :: " + info + " is checked");

        } else
            log.info("Element :: " + info + " is already checked");
        TestBase.logExtentReport("Element :: " + info + " is already checked");
    }

    /**
     * Selects a check box irrespective of its state, using locator
     *
     * @param locator
     * @param info
     * @return
     */
    public static void Check(String locator, String info) {
        WebElement element = getElement(locator, info);
        Check(element, info);
    }

    /**
     * UnSelects a check box irrespective of its state
     *
     * @param element
     * @param info
     * @return
     */
    public static void UnCheck(WebElement element, String info) {
        if (isSelected(element, info)) {
            elementClick(element, info);
            log.info("Element :: " + info + " is unchecked");
            TestBase.logExtentReport("Element :: " + info + " is unchecked");
        } else
            log.info("Element :: " + info + " is already unchecked");
        TestBase.logExtentReport("Element :: " + info + " is already unchecked");
    }

    /**
     * UnSelects a check box irrespective of its state, using locator
     *
     * @param locator
     * @param info
     * @return
     */
    public static void UnCheck(String locator, String info) {
        WebElement element = getElement(locator, info);
        UnCheck(element, info);
    }

    /**
     * @param element
     * @param info
     * @return
     */
    public Boolean Submit(WebElement element, String info) {
        if (element != null) {
            element.submit();
            log.info("Element :: " + info + " is submitted");
            TestBase.logExtentReport("Element :: " + info + " is submitted");
            return true;
        } else
            TestBase.logExtentReport("Element :: " + info + " is Not submitted");
        return false;
    }

    /**
     * @param locator
     * @param attribute
     * @return
     */
    public String getElementAttributeValue(String locator, String attribute) {
        WebElement element = getElement(locator, "info");
        TestBase.logExtentReport("Element Attribute Value located");
        return element.getAttribute(attribute);
    }

    /**
     * @param element
     * @param attribute
     * @return
     */
    public String getElementAttributeValue(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }

    /**
     * @param locator
     * @param timeout
     * @return
     */
    public static WebElement waitForElement(String locator, int timeout) {
        By byType = getByType(locator);
        WebElement element = null;
        try {
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            log.info("Waiting for max:: " + timeout + " seconds for element to be available");
            TestBase.logExtentReport("Waiting for max:: " + timeout + " seconds for element to be available");
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            element = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(byType));
            log.info("Element appeared on the web page");
            TestBase.logExtentReport("Element appeared on the web page");
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        } catch (Exception e) {
            log.info("Element not appeared on the web page");
            TestBase.logExtentReport("Element not appeared on the web page");
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        }
        return element;
    }

    /***
     * Wait for element to be clickable
     * @param locator - locator strategy, id=>example, name=>example, css=>#example,
     *      *                tag=>example, xpath=>//example, link=>example
     * @param timeout - Duration to try before timeout
     */
    public WebElement waitForElementToBeClickable(String locator, int timeout) {
        By byType = getByType(locator);
        WebElement element = null;
        try {
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            log.info("Waiting for max:: " + timeout + " seconds for element to be clickable");
            TestBase.logExtentReport("Waiting for max:: " + timeout + " seconds for element to be clickable");

            WebDriverWait wait = new WebDriverWait(driver, 15);
            element = wait.until(
                    ExpectedConditions.elementToBeClickable(byType));
            log.info("Element is clickable on the web page");
            TestBase.logExtentReport("Element is clickable on the web page");
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        } catch (Exception e) {
            log.info("Element not appeared on the web page");
            TestBase.logExtentReport("Element not appeared on the web page");
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        }
        return element;
    }

    /**
     *
     */
    public boolean waitForLoading(String locator, long timeout) {
        By byType = getByType(locator);
        boolean elementInvisible = false;
        try {
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            log.info("Waiting for max:: " + timeout + " seconds for element to be available");
            TestBase.logExtentReport("Waiting for max:: " + timeout + " seconds for element to be available");
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            elementInvisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(byType));
            log.info("Element appeared on the web page");
            TestBase.logExtentReport("Element appeared on the web page");
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        } catch (Exception e) {
            log.info("Element not appeared on the web page");
            TestBase.logExtentReport("Element not appeared on the web page");
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        }
        return elementInvisible;
    }

    /**
     * Mouse Hovers to an element
     *
     * @param locator
     */
    public static void mouseHover(String locator, String info) {
        WebElement element = getElement(locator, info);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        TestBase.logExtentReport("Mousing over the element...");
        log.info("Mousing over the element...");
        Util.sleep(Constants.three_SECONDS);
    }

    /**
     * @param element
     * @param optionToSelect
     */
    public static void selectOption(WebElement element, String optionToSelect) {
        Select sel = new Select(element);
        Util.sleep(Constants.three_SECONDS);
        sel.selectByVisibleText(optionToSelect);
        log.info("Selected option : " + optionToSelect);
        TestBase.logExtentReport("Selected option : " + optionToSelect);
    }

    /**
     * Selects a given option in list box
     *
     * @param locator
     * @param optionToSelect
     */
    public static void selectOption(String locator, String optionToSelect, String info) {
        WebElement element = getElement(locator, info);
        Util.sleep(Constants.three_SECONDS);
        selectOption(element, optionToSelect);
    }
    public String getSelectDropDownValue(WebElement element) {
        Util.sleep(Constants.three_SECONDS);
        Select sel = new Select(element);
        return sel.getFirstSelectedOption().getText();
    }

    /**
     * @param element
     * @param optionToVerify
     */
    public boolean isOptionExists(WebElement element, String optionToVerify) {
        Util.sleep(Constants.three_SECONDS);
        Select sel = new Select(element);
        boolean exists = false;
        List<WebElement> optList = sel.getOptions();
        for (int i = 0; i < optList.size(); i++) {
            String text = getText(optList.get(i), "Option Text");
            if (text.matches(optionToVerify)) {
                exists = true;
                break;
            }
        }
        if (exists) {
            log.info("Selected Option : " + optionToVerify + " exist");
            TestBase.logExtentReport("Selected Option : " + optionToVerify + " exist");
        } else {
            log.info("Selected Option : " + optionToVerify + " does not exist");
            TestBase.logExtentReport("Selected Option : " + optionToVerify + " does not exist");
        }
        return exists;
    }

    /***
     *
     * @param methodName
     * @param browserName
     * @return
     */
    public static String takeScreenshot(String methodName, String browserName) {
        String fileName = Util.getScreenshotName(methodName, browserName);
        String screenshotDir = System.getProperty("user.dir") + "//" + "test-output/screenshots";
        new File(screenshotDir).mkdirs();
        String path = screenshotDir + "//" + fileName;

        try {
            File screenshot = ((TakesScreenshot) driver).
                    getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File(path));
            log.info("Screen Shot Was Stored at: " + path);
            TestBase.logExtentReport("Screen Shot Was Stored at: " + path);
        } catch (Exception e) {
            TestBase.logExtentReport("Screen Shot Was NOT Stored at: " + path);
            e.printStackTrace();
        }
        return path;
    }

    public static void DoubleClick(WebElement element, String info) {
        Actions action = new Actions(driver);
        Util.sleep(Constants.three_SECONDS);
        action.doubleClick(element);
        log.info("Double Clicked on :: " + info);
        TestBase.logExtentReport("Double Clicked on :: " + info);
        action.perform();
    }

    /**
     * Right Click a WebElement
     *
     * @param locator
     */
    public static void rightClick(String locator, String info) {
        WebElement element = getElement(locator, info);
        Actions action = new Actions(driver);
        action.contextClick(element).build().perform();
        log.info("Double Clicked on :: " + info);
        TestBase.logExtentReport("Double Clicked on :: " + info);
    }

    /**
     * Right click a WebElement and select the option
     *
     * @param elementLocator
     * @param itemLocator
     */
    public static void selectItemRightClick(String elementLocator, String itemLocator) {
        Util.sleep(Constants.three_SECONDS);
        WebElement element = getElement(elementLocator, "info");
        Actions action = new Actions(driver);
        action.contextClick(element).build().perform();
        WebElement itemElement = getElement(itemLocator, "info");
        elementClick(itemElement, "Selected Item");
    }

    /**
     * @param key
     */
    public static void keyPress(Keys key, String info) {
        Actions action = new Actions(driver);
        action.keyDown(key).build().perform();
        log.info("Key Pressed :: " + info);
        TestBase.logExtentReport("Key Pressed :: " + info);
    }


    /**********************************************************************************
     **CLICK METHODS
     * @throws IOException
     **********************************************************************************/
    public static  void waitAndClickElement(WebElement element) throws InterruptedException, IOException {
        Util.sleep(Constants.three_SECONDS);
        boolean clicked = false;
        int attempts = 0;
        while (!clicked && attempts < 10) {
            try {
                Thread.sleep(Constants.two_SECONDS);
                element.click();
                log.info("Successfully clicked on the WebElement: " + "<" + element.toString() + ">");
                TestBase.logExtentReport("Successfully clicked on the WebElement: " + "<" + element.toString() + ">");
                clicked = true;
            } catch (Exception e) {
                TestBase.logExtentReport("Unable to wait and click on WebElement, Exception: " + e.getMessage());
                log.error("Unable to wait and click on WebElement, Exception: " + e.getMessage());
                Assert.fail("Unable to wait and click on the WebElement, using locator: " + "<" + element.toString() + ">");
            }
            attempts++;
        }
    }

    public static void waitAndClickElementsUsingByLocator(By by) throws InterruptedException {
        boolean clicked = false;
        int attempts = 0;
        while (!clicked && attempts < 10) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(by)).click();
                log.info("Successfully clicked on the element using by locator: " + "<" + by.toString() + ">");
                TestBase.logExtentReport("Successfully clicked on the element using by locator: " + "<" + by.toString() + ">");
                clicked = true;
            } catch (Exception e) {
                log.error("Unable to wait and click on the element using the By locator, Exception: " + e.getMessage());
                TestBase.logExtentReport("Unable to wait and click on the element using the By locator, Exception: " + e.getMessage());
                Assert.fail("Unable to wait and click on the element using the By locator, element: " + "<" + by.toString() + ">");
            }
            attempts++;
        }
    }

    public static void clickOnTextFromDropdownList(WebElement list, String textToSearchFor) {
        Wait<WebDriver> tempWait = new WebDriverWait(driver, 30);
        try {
            tempWait.until(ExpectedConditions.elementToBeClickable(list)).click();
            list.sendKeys(textToSearchFor);
            list.sendKeys(Keys.ENTER);
            log.info("Successfully sent the following keys: " + textToSearchFor + ", to the following WebElement: " + "<" + list.toString() + ">");
            TestBase.logExtentReport("Successfully sent the following keys: " + textToSearchFor + ", to the following WebElement: " + "<" + list.toString() + ">");
        } catch (Exception e) {
            log.error("Unable to send the following keys: " + textToSearchFor + ", to the following WebElement: " + "<" + list.toString() + ">");
            TestBase.logExtentReport("Unable to send the following keys: " + textToSearchFor + ", to the following WebElement: " + "<" + list.toString() + ">");
            Assert.fail("Unable to select the required text from the dropdown menu, Exception: " + e.getMessage());
        }
    }

    public static void clickOnElementUsingCustomTimeout(WebElement locator, WebDriver driver, int timeout) {
        try {
            final WebDriverWait customWait = new WebDriverWait(driver, timeout);
            customWait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(locator)));
            locator.click();
            log.info("Successfully clicked on the WebElement, using locator: " + "<" + locator + ">" + ", using a custom Timeout of: " + timeout);
            TestBase.logExtentReport("Successfully clicked on the WebElement, using locator: " + "<" + locator + ">" + ", using a custom Timeout of: " + timeout);
        } catch (Exception e) {
            TestBase.logExtentReport("Unable to click on the WebElement, using locator: " + "<" + locator + ">" + ", using a custom Timeout of: " + timeout);
            log.error("Unable to click on the WebElement, using locator: " + "<" + locator + ">" + ", using a custom Timeout of: " + timeout);
            Assert.fail("Unable to click on the WebElement, Exception: " + e.getMessage());
        }
    }

    /**********************************************************************************
     **ACTION METHODS
     **********************************************************************************/

    public static void actionMoveAndClick(WebElement element) throws Exception {
        Actions ob = new Actions(driver);
        try {
            Util.sleep(Constants.three_SECONDS);
            ob.moveToElement(element).click().build().perform();
            log.info("Successfully Action Moved and Clicked on the WebElement, using locator: " + "<" + element.toString() + ">");
            TestBase.logExtentReport("Successfully Action Moved and Clicked on the WebElement, using locator: " + "<" + element.toString() + ">");
        } catch (StaleElementReferenceException elementUpdated) {
            WebElement elementToClick = element;
            Boolean elementPresent = wait.until(ExpectedConditions.elementToBeClickable(elementToClick)).isEnabled();
            if (elementPresent == true) {
                ob.moveToElement(elementToClick).click().build().perform();
                TestBase.logExtentReport("(Stale Exception) - Successfully Action Moved and Clicked on the WebElement, using locator: " + "<" + element.toString() + ">");
                log.error("(Stale Exception) - Successfully Action Moved and Clicked on the WebElement, using locator: " + "<" + element.toString() + ">");
            }
        } catch (Exception e) {
            TestBase.logExtentReport("Unable to Action Move and Click on the WebElement, using locator: " + "<" + element.toString() + ">");
            log.error("Unable to Action Move and Click on the WebElement, using locator: " + "<" + element.toString() + ">");
            Assert.fail("Unable to Action Move and Click on the WebElement, Exception: " + e.getMessage());
        }
    }

    public static void actionMoveAndClickByLocator(By element) throws Exception {
        Util.sleep(Constants.three_SECONDS);
        Actions ob = new Actions(driver);
        try {
            Boolean elementPresent = wait.until(ExpectedConditions.elementToBeClickable(element)).isEnabled();
            if (elementPresent == true) {
                WebElement elementToClick = driver.findElement(element);
                ob.moveToElement(elementToClick).click().build().perform();
                log.info("Action moved and clicked on the following element, using By locator: " + "<" + element.toString() + ">");
                TestBase.logExtentReport("Action moved and clicked on the following element, using By locator: " + "<" + element.toString() + ">");
            }
        } catch (StaleElementReferenceException elementUpdated) {
            WebElement elementToClick = driver.findElement(element);
            ob.moveToElement(elementToClick).click().build().perform();
            log.info("(Stale Exception) - Action moved and clicked on the following element, using By locator: " + "<" + element.toString() + ">");
            TestBase.logExtentReport("(Stale Exception) - Action moved and clicked on the following element, using By locator: " + "<" + element.toString() + ">");
        } catch (Exception e) {
            TestBase.logExtentReport("Unable to Action Move and Click on the WebElement using by locator: " + "<" + element.toString() + ">");
            log.error("Unable to Action Move and Click on the WebElement using by locator: " + "<" + element.toString() + ">");
            Assert.fail("Unable to Action Move and Click on the WebElement using by locator, Exception: " + e.getMessage());
        }
    }

    /**********************************************************************************
     **SEND KEYS METHODS /
     **********************************************************************************/
    public static  void sendKeysToWebElement(WebElement element, String textToSend) throws Exception {
        try {
            Util.sleep(Constants.two_SECONDS);
            WaitUntilWebElementIsVisible(element);
            element.clear();
            element.sendKeys(textToSend);
            log.info("Successfully Sent the following keys: '" + textToSend + "' to element: " + "<" + element.toString() + ">");
            TestBase.logExtentReport("Successfully Sent the following keys: '" + textToSend + "' to element: " + "<" + element.toString() + ">");
        } catch (Exception e) {
            TestBase.logExtentReport("Unable to locate WebElement: " + "<" + element.toString() + "> and send the following keys: " + textToSend);
            log.error("Unable to locate WebElement: " + "<" + element.toString() + "> and send the following keys: " + textToSend);
            Assert.fail("Unable to send keys to WebElement, Exception: " + e.getMessage());
        }
    }

    /**********************************************************************************
     **JS METHODS & JS SCROLL
     **********************************************************************************/

    public static  void scrollToElementByWebElementLocator(WebElement element) {
        try {
            Util.sleep(Constants.three_SECONDS);
            wait.until(ExpectedConditions.visibilityOf(element)).isEnabled();
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -400)");
            log.info("Successfully scrolled to the WebElement, using locator: " + "<" + element.toString() + ">");
            TestBase.logExtentReport("Successfully scrolled to the WebElement, using locator: " + "<" + element.toString() + ">");
        } catch (Exception e) {
            TestBase.logExtentReport("Unable to scroll to the WebElement, using locator: " + "<" + element.toString() + ">");
            log.error("Unable to scroll to the WebElement, using locator: " + "<" + element.toString() + ">");
            Assert.fail("Unable to scroll to the WebElement, Exception: " + e.getMessage());
        }
    }

    public static void jsPageScroll(int numb1, int numb2) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("scroll(" + numb1 + "," + numb2 + ")");
            log.info("Successfully scrolled to the correct position! using locators: " + numb1 + ", " + numb2);
            TestBase.logExtentReport("Successfully scrolled to the correct position! using locators: " + numb1 + ", " + numb2);
        } catch (Exception e) {
            log.error("Unable to scroll to element using locators: " + "<" + numb1 + "> " + " <" + numb2 + ">");
            TestBase.logExtentReport("Unable to scroll to element using locators: " + "<" + numb1 + "> " + " <" + numb2 + ">");
            Assert.fail("Unable to manually scroll to WebElement, Exception: " + e.getMessage());
        }
    }

    public static  void waitAndClickElementUsingJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            Util.sleep(Constants.two_SECONDS);
            js.executeScript("arguments[0].click();", element);
            log.info("Successfully JS clicked on the following WebElement: " + "<" + element.toString() + ">");
            TestBase.logExtentReport("Successfully JS clicked on the following WebElement: " + "<" + element.toString() + ">");
        } catch (StaleElementReferenceException elementUpdated) {
            WebElement staleElement = element;
            Boolean elementPresent = wait.until(ExpectedConditions.elementToBeClickable(staleElement)).isEnabled();
            if (elementPresent == true) {
                js.executeScript("arguments[0].click();", elementPresent);
                log.error("(Stale Exception) Successfully JS clicked on the following WebElement: " + "<" + element.toString() + ">");
                TestBase.logExtentReport("(Stale Exception) Successfully JS clicked on the following WebElement: " + "<" + element.toString() + ">");
            }
        } catch (NoSuchElementException e) {
            TestBase.logExtentReport("Unable to JS click on the following WebElement: " + "<" + element.toString() + ">");
            log.error("Unable to JS click on the following WebElement: " + "<" + element.toString() + ">");
            Assert.fail("Unable to JS click on the WebElement, Exception: " + e.getMessage());
        }
    }

    public static  void jsClick(WebElement element) {
        Util.sleep(Constants.three_SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
        log.info("Successfully JS clicked on the following WebElement: " + "<" + element.toString() + ">");
        TestBase.logExtentReport("Successfully JS clicked on the following WebElement: " + "<" + element.toString() + ">");
    }

    /**********************************************************************************
     **WAIT METHODS
     **********************************************************************************/
    public static boolean WaitUntilWebElementIsVisible(WebElement element) {
        try {
            Util.sleep(2);
            log.info("WebElement is visible using locator: " + "<" + element.toString() + ">");
            TestBase.logExtentReport("WebElement is visible using locator: " + "<" + element.toString() + ">");
            return true;
        } catch (Exception e) {
            log.info("WebElement is NOT visible, using locator: " + "<" + element.toString() + ">");
            TestBase.logExtentReport("WebElement is NOT visible, using locator: " + "<" + element.toString() + ">");
            Assert.fail("WebElement is NOT visible, Exception: " + e.getMessage());
            return false;
        }
    }

    public static  void WaitUntilWebElementIsVisibleOrDisplay(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            log.info("WebElement is visible using locator: " + "<" + element.toString() + ">");
            TestBase.logExtentReport("WebElement is visible using locator: " + "<" + element.toString() + ">");
        } catch (Exception e) {
            TestBase.logExtentReport("WebElement is NOT visible, using locator: " + "<" + element.toString() + ">");
            log.error("WebElement is NOT visible, using locator: " + "<" + element.toString() + ">");
            Assert.fail("WebElement is NOT visible, Exception: " + e.getMessage());

        }
    }

    public boolean WaitUntilWebElementIsVisibleUsingByLocator(By element) {
        try {
            this.wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            log.info("Element is visible using By locator: " + "<" + element.toString() + ">");
            TestBase.logExtentReport("Element is visible using By locator: " + "<" + element.toString() + ">");
            return true;
        } catch (Exception e) {
            TestBase.logExtentReport("WebElement is NOT visible, using By locator: " + "<" + element.toString() + ">");
            log.error("WebElement is NOT visible, using By locator: " + "<" + element.toString() + ">");
            Assert.fail("WebElement is NOT visible, Exception: " + e.getMessage());
            return false;
        }
    }

    public boolean isElementClickable(WebElement element) {
        try {
            this.wait.until(ExpectedConditions.elementToBeClickable(element));
            log.info("WebElement is clickable using locator: " + "<" + element.toString() + ">");
            TestBase.logExtentReport("WebElement is clickable using locator: " + "<" + element.toString() + ">");
            return true;
        } catch (Exception e) {
            log.info("WebElement is NOT clickable using locator: " + "<" + element.toString() + ">");
            TestBase.logExtentReport("WebElement is NOT clickable using locator: " + "<" + element.toString() + ">");
            return false;
        }
    }


    public boolean waitUntilPreLoadElementDissapears(By element) {
        return this.wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
    }

    /**********************************************************************************
     **PAGE METHODS
     **********************************************************************************/

    public String getCurrentURL() {
        try {
            String url = driver.getCurrentUrl();
            log.info("Found(Got) the following URL: " + url);
            TestBase.logExtentReport("Found( get Current URL) the following URL: " + url);
            return url;
        } catch (Exception e) {
            log.error("Unable to locate (Get) the current URL, Exception: " + e.getMessage());
            TestBase.logExtentReport("Unable to locate (Get) the current URL, Exception: " + e.getMessage());
            return e.getMessage();
        }
    }

    public String waitForSpecificPage(String urlToWaitFor) {
        try {
            String url = driver.getCurrentUrl();
            this.wait.until(ExpectedConditions.urlMatches(urlToWaitFor));
            log.info("The current URL was: " + url + ", " + "navigated and waited for the following URL: " + urlToWaitFor);
            TestBase.logExtentReport("The current URL was: " + url + ", " + "navigated and waited for the following URL: " + urlToWaitFor);
            return urlToWaitFor;
        } catch (Exception e) {
            log.info("Exception! waiting for the URL: " + urlToWaitFor + ",  Exception: " + e.getMessage());
            TestBase.logExtentReport("Exception! waiting for the URL: " + urlToWaitFor + ",  Exception: " + e.getMessage());
            return e.getMessage();
        }
    }

    /**********************************************************************************
     **ALERT & POPUPS METHODS
     **********************************************************************************/
    public static void closePopups(By locator) throws InterruptedException {
        try {
            List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
            for (WebElement element : elements) {
                if (element.isDisplayed()) {
                    element.click();
                    wait.until(ExpectedConditions.invisibilityOfAllElements(elements));
                    log.info("The popup has been closed Successfully!");
                    TestBase.logExtentReport("The popup has been closed Successfully!");
                }
            }
        } catch (Exception e) {
            TestBase.logExtentReport("Exception! - could not close the popup!, Exception: " + e.toString());
            log.error("Exception! - could not close the popup!, Exception: " + e.toString());
            throw (e);
        }
    }

    public boolean checkPopupIsVisible() {
        try {
            @SuppressWarnings("unused")
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            log.info("A popup has been found!");
            TestBase.logExtentReport("A popup has been found!");
            return true;
        } catch (Exception e) {
            System.err.println("Error came while waiting for the alert popup to appear. " + e.getMessage());
            log.error("Error came while waiting for the alert popup to appear. " + e.getMessage());
            TestBase.logExtentReport("Error came while waiting for the alert popup to appear. " + e.getMessage());
        }
        return false;
    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            log.info("An Alert is Present");
            TestBase.logExtentReport("An Alert is Present");
            return true;
        } catch (Exception e) {
            System.err.println("Error came while waiting for the alert popup to appear. " + e.getMessage());
            log.error("Error came while waiting for the alert popup to appear. " + e.getMessage());
            TestBase.logExtentReport("Error came while waiting for the alert popup to appear. " + e.getMessage());
            return false;
        }
    }

    public static  void closeAlertPopupBox() throws AWTException, InterruptedException {
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
            log.info("The popup is closed");
            TestBase.logExtentReport("The popup is closed");
        } catch (UnhandledAlertException f) {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            log.info("Unable to close the popup");
            TestBase.logExtentReport("Unable to close the popup");
            Assert.fail("Unable to close the popup, Exception: " + e.getMessage());
        }
    }
}
