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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utilities.DataReader;
import utilities.TextFileReader;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseAPI {

    public static WebDriver driver;
    public static WebDriverWait driverWait;
    public DataReader dataReader;
    public TextFileReader textFileReader;
    public Properties properties;

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
        driver.close();
        driver.quit();
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
     * Helper Methods
     */

    public void sendKeysToElement(WebElement element, String keysToSend) {

        try {
            driverWait.until(ExpectedConditions.visibilityOf(element));
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
            driverWait.until(ExpectedConditions.elementToBeClickable(elementToClick));
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

        driverWait.until(ExpectedConditions.visibilityOf(element));

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

    public String getAttributeFromElement(WebElement element, String attribute) {
        String elementText = "";

        driverWait.until(ExpectedConditions.visibilityOf(element));

        try {
            elementText = element.getAttribute(attribute);
            return elementText;
        } catch (StaleElementReferenceException staleElementReferenceException) {
            staleElementReferenceException.printStackTrace();
            System.out.println("ELEMENT IS STALE");
        } catch (ElementNotVisibleException elementNotVisibleException) {
            elementNotVisibleException.printStackTrace();
            System.out.println("ELEMENT IS NOT VISIBLE IN THE DOM");
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

    /**
     * Assertion Helper Methods
     */

    public boolean compareStrings(String str1, String str2) {
        boolean flag = false;

        if (str1.toLowerCase().equals(str2)) {
            flag = true;
            return flag;
        }

        return flag;
    }

    // Gets text from List<WebElements> and compares against expected String array from Excel workbook
    public boolean compareAttributeListToExpectedStringArray(By by, String attribute, String path, String sheetName) throws IOException {
        List<WebElement> actualList = driver.findElements(by);
        String[] expectedList = dataReader.fileReaderStringArrayXSSF(path, sheetName);

        String[] actual = new String[actualList.size()];

        for (int j = 0; j<actualList.size(); j++) {
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
                System.out.println("FAILED AT INDEX " + (i+1) + "\nEXPECTED " + attribute.toUpperCase() + ": " + expectedList[i] +
                        "\nACTUAL " + attribute.toUpperCase() + ": " + actual[i] + "\n");
                falseCount++;
            }
        }
        if (falseCount > 0) {
            flag = false;
        }
        return flag;
    }

    public void waitUntilWebElementListVisible(List<WebElement> elements) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        elements = wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public void waitUntilWebElementVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        element = wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilWebElementInvisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitUntilWebElementClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        element = wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void javaScriptExecutorClickOnElement(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", element);
    }

    public void actionClassClickOnElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();

    }
//VERIFY VALID OR BROKEN LINKS:

    public boolean verifyLinks(List<WebElement> linkElements, String attribute) {
        Iterator<WebElement> links = linkElements.iterator();
        boolean flag = false;
        int flagCount = 0;
        HttpURLConnection urlConnection = null;
        int responseCode = 0;
        String url = " ";
        int validLinks = 0;
        int brokenLinks = 0;
        while (links.hasNext()) {
            url = links.next().getAttribute(attribute);
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

    public boolean compareListWebElementsToExcelDoc(List<WebElement> elements, String excelDocPath, String sheetName) throws IOException {

        DataReader dataReader = new DataReader();
        String[] expectedGetawayOptions = dataReader.fileReaderStringArrayXSSF(excelDocPath, sheetName);
//        waitUntilWebElementListVisible(elements);
        boolean flag = false;
        int count = 0;
        System.out.println(elements.size());


        for (int i = 0; i <= elements.size()-1; i++) {
            String getawayOption = elements.get(i).getText();
            if (getawayOption.equals(expectedGetawayOptions[i])) {
                flag = true;
                System.out.println("Passed on: " + getawayOption);
            } else {
                System.out.println("Failed on: " + getawayOption);
                count++;
            }
        }
        if (count > 0) {
            flag = false;
        }
        return flag;

    }
}
