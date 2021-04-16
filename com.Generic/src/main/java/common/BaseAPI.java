package common;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.Optional;
import org.testng.annotations.*;
import reporting.ExtentManager;
import reporting.ExtentTestManager;
import utilities.DataReader;
import utilities.TextFileReader;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class BaseAPI {

    public static WebDriver driver;
    public static WebDriverWait driverWait;
    public static TextFileReader textFileReader;
    public Robot robot;
    public static Actions actions;
    public static ExtentReports extent;
    public static EventFiringWebDriver eventFiringWebDriver;

    public DataReader dataReader;
    public Properties properties = new Properties();

    String propertiesFilePath = "src/main/resources/secret.properties";

    @BeforeSuite(alwaysRun = true)
    public static void beforeSuiteExtentSetup(ITestContext context) {
        ExtentManager.setOutputDirectory(context);
        extent = ExtentManager.getInstance();
    }

    @BeforeMethod(alwaysRun = true)
    public static void beforeEachMethodExtentInit(Method method) {
        String className = method.getDeclaringClass().getSimpleName();
        String methodName = method.getName();

        ExtentTestManager.startTest(methodName);
        ExtentTestManager.getTest().assignCategory(className);

        System.out.println("\n\t***" + methodName + "***\n");
    }

    // Parameterization via .xml runner files in each module
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

    @AfterMethod(alwaysRun = true)
    public void afterEachTestMethod(ITestResult result) {

        ExtentTestManager.getTest().getTest().setStartedTime(getTime(result.getStartMillis()));
        ExtentTestManager.getTest().getTest().setEndedTime(getTime(result.getEndMillis()));

        for (String group : result.getMethod().getGroups()) {
            ExtentTestManager.getTest().assignCategory(group);
        }

        if (result.getStatus() == ITestResult.FAILURE) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, "TEST CASE FAILED: " + result.getName());
            ExtentTestManager.getTest().log(LogStatus.FAIL, result.getThrowable());
            captureScreenshot(driver, result.getName());
        } else if (result.getStatus() == ITestResult.SKIP) {
            ExtentTestManager.getTest().log(LogStatus.SKIP, "TEST CASE SKIPPED: " + result.getName());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            ExtentTestManager.getTest().log(LogStatus.PASS, "TEST CASE PASSED: " + result.getName());
        }

        ExtentTestManager.endTest();
        extent.flush();
    }

    @AfterMethod(alwaysRun = true)
    public static void tearDown() {
        driver.close();
        driver.quit();
    }

    @AfterSuite(alwaysRun = true)
    private void afterSuiteCloseExtent() {
        extent.close();
    }

    /**
     * Driver + ExtentReport Helper Methods
     */

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

    private static void captureScreenshot(WebDriver driver, String testName) {
        String fileName = testName + ".png";
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File newScreenshotFile = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator +
                "main" + File.separator + "java" + File.separator + "reporting" + File.separator + fileName);

        try {
            FileHandler.copy(screenshot, newScreenshotFile);
            System.out.println("SCREENSHOT TAKEN");
        } catch (Exception e) {
            System.out.println("ERROR TAKING SCREENSHOT: " + e.getMessage());
        }
    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
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

    //Get URLs from the List of WebElements, navigate to each URL to get titles and compare all titles to data from Excel doc
    public boolean verifyLinksTitles(List<WebElement> linkElements, String attribute, String excelDocPath, String sheetName) throws IOException {
        Iterator<WebElement> iterator = linkElements.iterator();
        String url;
        List<String> links = new ArrayList<>();
        ArrayList<String> titles = new ArrayList<>();
        while (iterator.hasNext()) {
            url = iterator.next().getAttribute(attribute);
            links.add(url);
        }
        for (String x : links) {
            driver.navigate().to(x);
            String pageTitle = driver.getTitle();
            titles.add(pageTitle);
        }

        return compareListStringsToExcelDoc(titles, excelDocPath, sheetName);
    }

    public String getStringFromTextFile(String path) {
        String string = "";
        textFileReader = new TextFileReader();
        string = textFileReader.readToString(path);
        return string;
    }

    public boolean compareListWebElementsToExcelDoc(List<WebElement> elements, String excelDocPath, String sheetName) throws IOException {

        dataReader = new DataReader();
        String[] excelData = dataReader.fileReaderStringArrayXSSF(excelDocPath, sheetName);
        waitUntilWebElementListVisible(elements);
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
    public boolean getUrlsAndTitlesFromListWebElementAndCompareToExcelDoc(List<WebElement> elements, String attributeThatContainsUrl, String excelDocPath, String sheetName) throws IOException {
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

    public void verifyContentInPDf(String url, String expectedContent) {
        //specify the url of the pdf file
        driver.get(url);
        try {
            String pdfContent = readPdfContent(url);
            Assert.assertTrue(pdfContent.contains(expectedContent), "The content doesn't match.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public  String readPdfContent(String url) throws IOException {

        URL pdfUrl = new URL(url);
        InputStream in = pdfUrl.openStream();
        BufferedInputStream bf = new BufferedInputStream(in);
        PDDocument doc = PDDocument.load(bf);
        int numberOfPages = getPageCount(doc);
        System.out.println("The total number of pages "+numberOfPages);
        String content = new PDFTextStripper().getText(doc);
        doc.close();

        return content;
    }

    public static int getPageCount(PDDocument doc) {
        //get the total number of pages in the pdf document
        int pageCount = doc.getNumberOfPages();
        return pageCount;

    }



//    public boolean verifyPDFContent(String strURL, String reqTextInPDF) {
//
//        boolean flag = false;
//
//        PDFTextStripper pdfStripper = null;
//        PDDocument pdDoc = null;
//        COSDocument cosDoc = null;
//        String parsedText = null;
//
//        try {
//            URL url = new URL(strURL);
//            BufferedInputStream file = new BufferedInputStream(url.openStream());
//            PDFParser parser = new PDFParser(file);
//
//            parser.parse();
//            cosDoc = parser.getDocument();
//            pdfStripper = new PDFTextStripper();
//            pdfStripper.setStartPage(1);
//            pdfStripper.setEndPage(1);
//
//            pdDoc = new PDDocument(cosDoc);
//            parsedText = pdfStripper.getText(pdDoc);
//        } catch (MalformedURLException e2) {
//            System.err.println("URL string could not be parsed "+e2.getMessage());
//        } catch (IOException e) {
//            System.err.println("Unable to open PDF Parser. " + e.getMessage());
//            try {
//                if (cosDoc != null)
//                    cosDoc.close();
//                if (pdDoc != null)
//                    pdDoc.close();
//            } catch (Exception e1) {
//                e.printStackTrace();
//            }
//        }
//
//        System.out.println("+++++++++++++++++");
//        System.out.println(parsedText);
//        System.out.println("+++++++++++++++++");
//
//        if(parsedText.contains(reqTextInPDF)) {
//            flag=true;
//        }
//
//        return flag;
//    }

//    public boolean verifyPDFContent(String strURL, String text) {
//
//        String output ="";
//        boolean flag = false;
//        try{
//            URL url = new URL(strURL);
//            BufferedInputStream file = new BufferedInputStream(url.openStream());
//            PDDocument document = null;
//            try {
//                document = PDDocument.load(file);
//                output = new PDFTextStripper().getText(document);
//                System.out.println(output);
//            } finally {
//                if (document != null) {
//                    document.close();
//                }
//            }
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        if(output.contains(text)){
//            flag =  true;
//        }
//        return flag;
//    }

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

}

