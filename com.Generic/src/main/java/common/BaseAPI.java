package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.DataReader;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseAPI {

    public static WebDriver driver;
    static final String URL = "https://www.ebay.com";

    @BeforeMethod
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public static void tearDown() {
        driver.close();
        driver.quit();
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

    public boolean verifyListWebElements(List<WebElement> elements, String excelDocPath, String sheetName) throws IOException {

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
