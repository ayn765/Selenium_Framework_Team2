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
import utilities.TextFileReader;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseAPI {

    public static WebDriver driver;
    public static WebDriverWait driverWait;
    public DataReader dataReader;
    public TextFileReader textFileReader;
    public Properties properties;
    public Robot robot;
    public Actions actions;

    String propertiesFilePath = "src/main/resources/secret.properties";

    public BaseAPI() {

//        try {
//            properties = new Properties();
//            FileInputStream fis = new FileInputStream(propertiesFilePath);
//            properties.load(fis);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        try {
//            dataReader = new DataReader();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }


    // Parameterization via .xml runner files in each module
    @Parameters({"browserName", "browserVersion", "url"})
    @BeforeMethod
    public static void setUp(@Optional("chrome") String browserName, @Optional("90") String browserVersion,
                             @Optional("") String url) {

        driver = getLocalDriver(browserName);
        driverWait = new WebDriverWait(driver, 10);
        driver.get(url);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public static void tearDown() {
//        driver.close();
//        driver.quit();
    }

    // Method to get local driver, based on the browserName parameter in testNG.xml runner file
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

    public void javaScriptExecutorClickOnElement(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        try {
            jse.executeScript("arguments[0].click()", element);
        } catch (Exception e) {
            e.printStackTrace();
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

    public void jsScrollIntoView(WebElement elements) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elements);
    }

    public void removeAttributeNone(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('style')", element);

    }

    public void sendKeysToElement(WebElement element, String keysToSend) {

        try {
            waitUntilWebElementVisible(element);
            element.sendKeys(keysToSend);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("UNABLE TO SEND KEYS TO WEB ELEMENT");
        }
    }

    public void clickElement(WebElement elementToClick) {

        try {
            waitUntilWebElementClickable(elementToClick);
            elementToClick.click();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("UNABLE TO CLICK ON WEB ELEMENT");
        }
    }

    public String getTextFromElement(WebElement element) {
        String elementText = "";

        waitUntilWebElementVisible(element);

        try {
            elementText = element.getText();
            return elementText;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("UNABLE TO GET TEXT FROM WEB ELEMENT");
        }

        return elementText;
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

    public List<WebElement> getListOfWebElements(By by) {
        List<WebElement> elementList = new ArrayList<>();

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

    public void switchToNewWindow() {
        String parentWindow = driver.getWindowHandle();

        Set<String> windowHandles = driver.getWindowHandles();

        for (String handle : windowHandles) {
            if (!(handle.equals(parentWindow))) {
                driver.switchTo().window(handle);
            }
        }
    }

    /**
     * Assertion Helper Methods
     */

    //VERIFY VALID OR BROKEN LINKS:
    public boolean verifyLinks(List<WebElement> linkElements, String attribute) {
        Iterator<WebElement> iterator = linkElements.iterator();
        boolean flag = false;
        int flagCount = 0;
        HttpURLConnection urlConnection = null;
        int responseCode = 0;
        String url = " ";
        int validLinks = 0;
        int brokenLinks = 0;
        while (iterator.hasNext()) {
            url = iterator.next().getAttribute(attribute);
            if ((url == null) || (url.isEmpty())) {
                System.out.println("URL is either not configured for " + attribute + " tag or it is empty");
                continue;
            }
            try {
                urlConnection = (HttpURLConnection) (new URL(url).openConnection());
                urlConnection.setRequestMethod("HEAD");
                urlConnection.connect();
                responseCode = urlConnection.getResponseCode();
                if (responseCode >= 400) {
                    System.out.println(url + " is a broken link.");
                    brokenLinks++;
                    flagCount++;
                } else {
                    System.out.println(url + " is a valid link.");
                    validLinks++;
                    flag = true;
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
        System.out.println("Detection of broken links completed with " + brokenLinks + " broken links and " + validLinks + " valid links\n");
        if (flagCount > 0) {
            flag = false;
        }
        return flag;
    }


    public void verifyLinksTitles(List<WebElement> linkElements, String attribute) {
        Iterator<WebElement> links = linkElements.iterator();
        boolean flag = false;
        String url;
        while (links.hasNext()) {
            url = links.next().getAttribute(attribute);
            if ((url == null) || (url.isEmpty())) {
                System.out.println("URL is either not configured for " + attribute + " tag or it is empty");
                continue;
            }
            try {
                driver.navigate().to(url);
                System.out.println(driver.getTitle());
                driver.navigate().back();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public boolean compareListWebElementsToExcelDoc(List<WebElement> elements, String excelDocPath, String sheetName) throws IOException {

        dataReader = new DataReader();
        String[] excelData = dataReader.fileReaderStringArrayXSSF(excelDocPath, sheetName);
//        waitUntilWebElementListVisible(elements);
        boolean flag = false;
        int count = 0;

        for (int i = 0; i < elements.size(); i++) {
            String elementsData = elements.get(i).getText();
            if (elementsData.equals(excelData[i])) {
                flag = true;
                System.out.println("PASSED ON: " + elementsData);
            } else {
                System.out.println("FAILED ON: " + elementsData);
                count++;
            }
        }
        if (count > 0) {
            flag = false;
        }
        return flag;

    }

    public boolean compareListStringsToExcelDoc(ArrayList<String> string, String excelDocPath, String sheetName) throws IOException {

        dataReader = new DataReader();
        String[] excelData = dataReader.fileReaderStringArrayXSSF(excelDocPath, sheetName);
//        waitUntilWebElementListVisible(elements);
        boolean flag = false;
        int count = 0;

        for (int i = 0; i < string.size(); i++) {
            String elementsData = string.get(i);
            if (elementsData.equals(excelData[i])) {
                flag = true;
                System.out.println("PASSED ON: " + elementsData);
            } else {
                System.out.println("FAILED ON: " + elementsData);
                count++;
            }
        }
        if (count > 0) {
            flag = false;
        }
        return flag;

    }

    public boolean compareStrings(String str1, String str2) {
        boolean flag = false;

        if (str1.toLowerCase().equals(str2)) {
            flag = true;
            return flag;
        }

        return flag;
    }
    //Get links and link's titles form List of WebElements and compare titles to data from Excel Doc
    public boolean getUrlsAndTitlesFromListWebElementAndCompareToExcelDoc(List<WebElement>elements, String attributeThatContainsUrl, String excelDocPath, String sheetName) throws IOException {
        Iterator<WebElement> iterator = elements.iterator();
        String url;
        List<String> links = new ArrayList<>();
        ArrayList<String> titles = new ArrayList<>();
        while (iterator.hasNext()) {
            url = iterator.next().getAttribute(attributeThatContainsUrl);
            links.add(url);
        }
        for (String x : links) {
            driver.navigate().to(x);
            String pageTitle = driver.getTitle();
            titles.add(pageTitle);
        }
        boolean flag = compareListStringsToExcelDoc(titles, excelDocPath, sheetName);
        return flag;
    }


    // Gets text from List<WebElements> and compares against expected String array from Excel workbook
    public boolean compareAttributeListToExpectedStringArray(By by, String attribute, String path, String sheetName) throws IOException {
        List<WebElement> actualList = driver.findElements(by);
        String[] expectedList = dataReader.fileReaderStringArrayXSSF(path, sheetName);

        String[] actual = new String[actualList.size()];

        for (int j = 0; j < actualList.size(); j++) {
            actual[j] = actualList.get(j).getAttribute(attribute).replaceAll("&amp;", "&").replaceAll("’", "'").replaceAll("<br>", "\n").trim();
            actual[j].replaceAll("&amp;", "&").replaceAll("’", "'").replaceAll("<br>", "\n").trim();
//            escapeHtml4(actual[j]);
//            escapeHtml3(actual[j]);
        }

        int falseCount = 0;
        boolean flag = false;

        for (int i = 0; i < expectedList.length; i++) {
            if (actual[i].equalsIgnoreCase(expectedList[i])) {
                flag = true;
                System.out.println("ACTUAL " + attribute.toUpperCase() + " " + (i + 1) + ": " + actual[i]);
                System.out.println("EXPECTED " + attribute.toUpperCase() + " " + (i + 1) + ": " + expectedList[i] + "\n");
            } else {
                System.out.println("FAILED AT INDEX " + (i + 1) + "\nEXPECTED " + attribute.toUpperCase() + ": " + expectedList[i] +
                        "\nACTUAL " + attribute.toUpperCase() + ": " + actual[i] + "\n");
                falseCount++;
            }
        }
        if (falseCount > 0) {
            flag = false;
        }
        return flag;
    }

    /**
     * Wait helper methods:
     */

    public void waitUntilWebElementListVisible(List<WebElement> elements) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            elements = wait.until(ExpectedConditions.visibilityOfAllElements(elements));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ELEMENTS ARE NOT VISIBLE");
        }
    }

    public void waitUntilWebElementVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            element = wait.until(ExpectedConditions.visibilityOf(element));
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
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            element = wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ELEMENT IS NOT CLICKABLE");
        }

    }
    public void waitUntilWebElementsArePresent() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("li.uitk-carousel-item>div>div>div>div>a")));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ELEMENTS ARE NOT PRESENT");
        }

    }

}

