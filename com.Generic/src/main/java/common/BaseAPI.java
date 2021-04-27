package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utilities.DataReader;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BaseAPI {

    public DataReader dataReader = new DataReader();
    public Properties properties = new Properties();
    public static Robot robot;
    public static WebDriverWait driverWait;
    public static Actions actions;
    public static WebDriver driver;


    @Parameters({"browserName", "browserVersion", "url"})
    @BeforeMethod(alwaysRun = true)
    public static void setUp(@Optional("chrome") String browserName, @Optional("90") String browserVersion,
                             @Optional("") String url, Method method) {

        driver = getLocalDriver(browserName);
        driverWait = new WebDriverWait(driver, 10);
        driver.get(url);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        actions = new Actions(driver);
    }

    @AfterMethod
    public static void tearDown() {
        driver.close();
        driver.quit();
    }

    /**
     * Driver + ExtentReport Helper Methods
     */
    public static WebDriver getLocalDriver(String browserName) {
        if (browserName.toLowerCase().equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.toLowerCase().equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.toLowerCase().equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if (browserName.toLowerCase().equals("opera")) {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        } else if (browserName.toLowerCase().equals("ie")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }

        return driver;

    }


    /**
     * Wait helper methods:
     */

    public void waitUntilWebElementListVisible(List<WebElement> elements) {
        driverWait = new WebDriverWait(driver, 10);
        try {
            elements = driverWait.until(ExpectedConditions.visibilityOfAllElements(elements));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ELEMENTS ARE NOT VISIBLE");
        }
    }

    public void waitUntilWebElementVisible(WebElement element) {
        driverWait = new WebDriverWait(driver, 10);
        try {
            element = driverWait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ELEMENT IS NOT VISIBLE");
        }
    }

    public void waitUntilWebElementInvisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.invisibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("INVISIBILITY OF ELEMENTS FAILED");
        }
    }

    public void waitUntilWebElementClickable(WebElement element) {
        driverWait = new WebDriverWait(driver, 10);
        try {
            element = driverWait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ELEMENT IS NOT CLICKABLE");
        }

    }

    public void waitUntilWebElementsArePresent() {
        driverWait = new WebDriverWait(driver, 10);
        try {
            driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("li.uitk-carousel-item>div>div>div>div>a")));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ELEMENTS ARE NOT PRESENT");
        }

    }

    public void implicitWait() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }


    /**
     * Action Helper Methods
     */




    public void pressEnterKey() throws AWTException {
        robot = new Robot();
        try {
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("UNABLE TO PRESS ENTER KEY");
        }

    }

    public void pressEscapeKey() throws AWTException {
        robot = new Robot();
        try {
            robot.keyPress(KeyEvent.VK_ESCAPE);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("UNABLE TO PRESS ESC KEY");
        }

    }
    public void javaScriptExecutorClickOnElementNoWait(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        try {
            jse.executeScript("arguments[0].click()", element);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Unable to click on the element with JSExecutor.");
        }
    }
    public void javaScriptExecutorClickOnElement(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        try {
            waitUntilWebElementClickable(element);
            jse.executeScript("arguments[0].click()", element);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Unable to click on the element with JSExecutor.");
        }
    }

    public void actionClassClickOnElement(WebElement element) {
        Actions actions = new Actions(driver);
        try {
            waitUntilWebElementClickable(element);
            actions.moveToElement(element).click().perform();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("UNABLE TO CLICK ON " + element);
        }
    }

    public void jsScrollIntoView(WebElement element) {
        try {
            waitUntilWebElementVisible(element);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Unable to scroll into view.");
        }
    }

    public void removeAttributeNone(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('style')", element);

    }

    public void playEmbeddedVideo(WebElement buttonPlay) {

        try {
            javaScriptExecutorClickOnElement(buttonPlay);
            System.out.println("Clicked \"Play\" on embedded Video player");
        } catch (Exception e) {
            e.printStackTrace();
            clickElement(buttonPlay);
        }
    }


    public String getAttributeFromElement(WebElement element, String attribute) {
        String elementText = "";

        waitUntilWebElementVisible(element);

        try {
            elementText = element.getAttribute(attribute);
            return elementText;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("UNABLE TO GET ATTRIBUTE FROM WEB ELEMENT");
        }

        return elementText;
    }

    public java.util.List<WebElement> getListOfWebElements(By by) {
        java.util.List<WebElement> elementList = new ArrayList<>();

        driverWait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(by)));

        try {
            elementList = driver.findElements(by);
            return elementList;
        } catch (StaleElementReferenceException staleElementReferenceException) {
            staleElementReferenceException.printStackTrace();
            System.out.println("ELEMENTS ARE STALE");
        } catch (ElementNotVisibleException elementNotVisibleException) {
            elementNotVisibleException.printStackTrace();
            System.out.println("ELEMENTS ARE NOT VISIBLE IN THE DOM");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("UNABLE TO LOCATE WEB ELEMENTS");
        }

        return elementList;
    }

    //Select methods
    public void selectFromDropDownByIndex(WebElement dropdown, int index) {
        Select select = new Select(dropdown);
        try {
            waitUntilWebElementVisible(dropdown);
            select.selectByIndex(index);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("UNABLE TO SELECT AN ELEMENT");
        }
    }

    public void selectFromDropDownByValue(WebElement dropdown, String value) {
        Select select = new Select(dropdown);
        try {
            waitUntilWebElementVisible(dropdown);
            select.selectByValue(value);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("UNABLE TO SELECT AN ELEMENT");
        }
    }

    public void selectFromDropDownByVisibleText(WebElement dropdown, String visibleText) {
        Select select = new Select(dropdown);
        try {
            waitUntilWebElementVisible(dropdown);
            select.selectByVisibleText(visibleText);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("UNABLE TO SELECT AN ELEMENT");
        }
    }

    public void hoverOverElement(WebElement elementToHoverOver) {
        try {
            actions = new Actions(driver);
            waitUntilWebElementVisible(elementToHoverOver);
            actions.moveToElement(elementToHoverOver).build().perform();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("UNABLE TO HOVER OVER ELEMENT");
        }
    }
    public void hoverOverElementAndClick(WebElement element) {
        try {
            actions = new Actions(driver);
            waitUntilWebElementVisible(element);
            actions.moveToElement(element);
            actions.click().build().perform();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("UNABLE TO HOVER OVER ELEMENT AND CLICK");
        }
    }

    public void mouseHoverJScript(WebElement HoverElement) {
        try {
            if (isElementPresent(HoverElement)) {

                String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
                ((JavascriptExecutor) driver).executeScript(mouseOverScript,
                        HoverElement);

            } else {
                System.out.println("Element was not visible to hover " + "\n");

            }
        } catch (StaleElementReferenceException e) {
            System.out.println("Element with " + HoverElement
                    + "is not attached to the page document"
                    + e.getStackTrace());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error occurred while hovering"
                    + e.getStackTrace());
        }
    }

    public static boolean isElementPresent(WebElement element) {
        boolean flag = false;
        try {
            if (element.isDisplayed()
                    || element.isEnabled())
                flag = true;
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    public void switchToNewWindow() {
        String parentWindow = driver.getWindowHandle();

        Set<String> windowHandles = driver.getWindowHandles();

        for (String handle : windowHandles) {
            if (!(handle.equals(parentWindow))) {
                driver.switchTo().window(handle);
            }
        }
    }

    public void dismissAlert() {
        try {
            driver.switchTo().alert().dismiss();
        } catch (Exception e) {
            System.out.println("The alert was not detected or couldn't be dismissed.");
        }
    }

    public void closePopUp(WebElement popUp, WebElement dismissPopUp) {
        try {
            driverWait.until(ExpectedConditions.visibilityOf(popUp));
            if (popUp.isDisplayed()) {
                dismissPopUp.click();
                System.out.println("Pop-up closed.");
                driver.switchTo().defaultContent();
            } else {
                System.out.println("Pop-up was not displayed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void switchToiFrameByIndex(int index) {
        try {
            driver.switchTo().frame(index);
            System.out.println("Switched to iFrame.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Unable to switch to iFrame.");
        }
    }

    public void switchToiFrameByWebElement(WebElement element) {
        try {
            driver.switchTo().frame(element);
            System.out.println("Switched to iFrame.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Unable to switch to iFrame.");
        }
    }

    public void switchToNewTab(int tabIndexToSwitchTo) {

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());

        try {
            driver.switchTo().window(tabs.get(tabIndexToSwitchTo));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Unable to switch to a new tab.");
        }
    }

    public void sliderBarAction(WebElement slider) {
        Actions actions = new Actions(driver);
        actions.clickAndHold(slider);
        actions.moveByOffset(40, 0).build().perform();
    }

    /** Helper Methods **/

    public void selectElement(WebElement elementToSelect) {
        waitForElementToBeClickable(elementToSelect);
        clickElement(elementToSelect);
    }

    public void sendKeysToElement(WebElement element, String keysToSend) {

        try {
            waitForVisibilityOfElement(element);
            element.sendKeys(keysToSend);

        } catch (StaleElementReferenceException staleElementReferenceException) {
            staleElementReferenceException.printStackTrace();
            System.out.println("ELEMENT IS STALE");

        } catch (ElementNotVisibleException elementNotVisibleException) {
            elementNotVisibleException.printStackTrace();
            System.out.println("ELEMENT IS NOT VISIBLE IN THE DOM");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("UNABLE TO SEND KEYS TO WEB ELEMENT" );
        }
    }

    public void clickElement(WebElement elementToClick) {

        try {
            waitForElementToBeClickable(elementToClick);
            elementToClick.click();
        } catch (StaleElementReferenceException staleElementReferenceException) {
            staleElementReferenceException.printStackTrace();
            System.out.println("ELEMENT IS STALE");

        } catch (ElementNotVisibleException elementNotVisibleException) {
            elementNotVisibleException.printStackTrace();
            System.out.println("ELEMENT IS NOT VISIBLE IN THE DOM");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("UNABLE TO CLICK ON WEB ELEMENT" );
        }
    }

    public String getTextFromElement(WebElement element) {
        String elementText = "";

        waitForVisibilityOfElement(element);

        try {
            elementText = element.getText();
            return elementText;
        } catch (StaleElementReferenceException staleElementReferenceException) {
            staleElementReferenceException.printStackTrace();
            System.out.println("ELEMENT IS STALE");
        } catch (ElementNotVisibleException elementNotVisibleException) {
            elementNotVisibleException.printStackTrace();
            System.out.println("ELEMENT IS NOT VISIBLE IN THE DOM");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("UNABLE TO GET TEXT FROM WEB ELEMENT" );
        }

        return elementText;
    }



    /**
     * Synchronization Helper Methods
     */

    public void waitForVisibilityOfElement(WebElement element) {
        try {
            driverWait.until(ExpectedConditions.visibilityOf(element));

        } catch (ElementNotVisibleException elementNotVisibleException) {
            elementNotVisibleException.printStackTrace();
            System.out.println("ELEMENT NOT VISIBLE");

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("UNABLE TO LOCATE ELEMENT");
        }
    }

    public void waitForElementToBeClickable(WebElement element) {
        try {
            driverWait.until(ExpectedConditions.elementToBeClickable(element));

        } catch (ElementNotInteractableException elementNotInteractableException) {
            elementNotInteractableException.printStackTrace();
            System.out.println("ELEMENT NOT INTERACTABLE");

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("UNABLE TO LOCATE ELEMENT");
        }
    }

    public void waitForElementToBeSelected(WebElement element) {
        try {
            driverWait.until(ExpectedConditions.elementSelectionStateToBe(element, true));

        } catch (ElementNotInteractableException elementNotInteractableException) {
            elementNotInteractableException.printStackTrace();
            System.out.println("ELEMENT NOT INTERACTABLE");

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("UNABLE TO LOCATE ELEMENT");
        }
    }

    public void waitForPageLoad(String URL) {
        driverWait.until(ExpectedConditions.urlToBe(URL));
    }
}