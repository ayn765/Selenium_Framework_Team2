package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.FileStore;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;


public class BaseAPI {

    public static WebDriver driver;
    public static WebDriverWait driverWait;
    public DataReader dataReader = new DataReader();
    public Properties properties = new Properties();
    private FileStore videoPlayPauseButton;


    @Parameters({"browserName", "browserVersion", "url"})
    @BeforeMethod
    public static void setUp(@Optional("chrome") String browserName, @Optional("90") String browserVersion,
                             @Optional("") String url) {

        driver = getLocalDriver(browserName);
        driverWait = new WebDriverWait(driver, 10);
        driver.get(url);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
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

    //----------------------------Helper Methods---------------------------------------------

    //click on the element
    public void clickOnTheElement(WebElement elementToClick) {
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
            System.out.println("UNABLE TO CLICK ON WEB ELEMENT");
        }
    }


    //method to check if element is displayed
    public static boolean isElementDisplayed(WebElement element) {
        boolean flag = false;
        try {
            if (element.isDisplayed()
                    || element.isEnabled())
                flag = true;
        } catch (NoSuchElementException e) {
            flag = false;
        } catch (StaleElementReferenceException e) {
            flag = false;
        }
        return flag;
    }

    //method to send text
    public void sendKeysToElement(WebElement element, String keysToSend) {

        try {
            driverWait.until(ExpectedConditions.visibilityOf(element));
            element.sendKeys(keysToSend);
            driverWait.until(ExpectedConditions.elementToBeClickable(element));
            element.sendKeys(keysToSend);

        } catch (StaleElementReferenceException staleElementReferenceException) {
            staleElementReferenceException.printStackTrace();
            System.out.println("ELEMENT IS STALE");

        } catch (ElementNotVisibleException elementNotVisibleException) {
            elementNotVisibleException.printStackTrace();
            System.out.println("ELEMENT IS NOT VISIBLE IN THE DOM");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("UNABLE TO SEND KEYS TO WEB ELEMENT");
        }
    }

    //mouse hover to element
    public static void mouseHoverElement(WebElement element) {
        try {
            Actions hover = new Actions(driver);
            hover.moveToElement(element).click().build().perform();
        } catch (Exception ex) {
            driver.navigate().refresh();
            System.out.println("1st mouse-hover attempt failed - Attempting 2nd time");

            WebDriverWait wait = new WebDriverWait(driver, 10);
            Actions hover = new Actions(driver);

            wait.until(ExpectedConditions.visibilityOf(element));
            hover.moveToElement(element).perform();
        }
    }

    // get text from element
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
            System.out.println("UNABLE TO GET TEXT FROM WEB ELEMENT");
        }

        return elementText;
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

    //window Handle Methode
    public void windoHandle() {
        String parentWindow = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
    }


    //list of webElements
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

    public void scrollToElementJScript(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            js.executeScript("arguments[0].scrollIntoView();", element);
        } catch (NoSuchElementException e) {
            System.out.println("NO SUCH ELEMENT - " + element);
            e.printStackTrace();
        } catch (StaleElementReferenceException e) {
            System.out.println("STALE ELEMENT - " + element);
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("COULD NOT SCROLL TO ELEMENT - " + element);
            e.printStackTrace();
        }
    }


    public void switchToNewTab(int tabIndexToSwitchTo) {

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());

        try {
            driver.switchTo().window(tabs.get(tabIndexToSwitchTo));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


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

    public void waitForPageLoad(String URL) {
        driverWait.until(ExpectedConditions.urlToBe(URL));
    }


    public boolean compareAttributeListToExpectedStringArray(By by, String attribute, String path, String sheetName) throws IOException {
        List<WebElement> actualList = driver.findElements(by);
        String[] expectedList = dataReader.fileReaderStringXSSF(path, sheetName);

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

    public boolean compareListWebElementsToExcelDoc(List<WebElement> elements, String excelDocPath, String sheetName) throws IOException {

        dataReader = new DataReader();
        String[] excelData = dataReader.fileReaderStringXSSF(excelDocPath, sheetName);
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

    //==============================My Methods==========================================================

    //Convert phone number
    public void convertPhoneNumber(String phoneNumber) {
        String input = "1234567890";
        String number = input.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
    }

    // method to check if the phone number is valid
    public boolean checkPhoneNumber(String phone) {

        boolean valid = phone.matches("\\d{3}-\\d{3}-\\d{4}");
        System.out.println(phone + " : " + valid);
        return true;
    }

    //Scroll till bottom Of the page
    public void scrollTillBottomPageJScript() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    //get current page URL
    public String getCurrentPageUrl() {
        String url = driver.getCurrentUrl();
        return url;
    }

    //get current page Title
    public String getCurrentPageTitle() {
        String title = driver.getTitle();
        return title;
    }


    //download picture
    public void downloadPicture(WebElement element) {
        try {
            String airbnbImage = element.getAttribute("src"); //Getting the Image Path
            java.net.URL imageURL = new URL(airbnbImage);//convert Image path to Java URL using URL Class
            BufferedImage saveImage = ImageIO.read(imageURL); //Read the image object from URL
            String path = System.getProperty("user.dir") + "user path";
            ImageIO.write(saveImage, "jpg", new File(path));   //Download image to the path
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


   //get values of table
       public void printTableValues() {
        List<WebElement> allRows = driver.findElements(By.xpath(""));
        for (WebElement row : allRows) {
            List<WebElement> cells = row.findElements(By.id(""));
            for (WebElement cell : cells) {
                System.out.println(cell.getText());
            }
        }
    }
//check if video playing
     public boolean isVideoPlaying(){
        try {
        if(videoPlayPauseButton.getAttribute("data-control").equals("Play")){
            System.out.println("This Youtube video wasn't playing but we clicked on it to play the video.");
        }else{
            if(videoPlayPauseButton.getAttribute("data-control").equals("Pause")){
                System.out.println("Youtube video is already playing.");
                return true;
            }
        }
       } catch (Exception e) {
        e.printStackTrace();
         }
       return false;//return "false" in case both conditions fail
}
    //number of pictures in a page
    public int numOfImageInThePage() {
        int countImage = 0;
        List<WebElement> listImages = driver.findElements(By.tagName("img"));
        for (WebElement image : listImages) {
            if (image.isDisplayed()) {
                countImage++;
                System.out.println(image.getAttribute("alt"));
            }
        }
        System.out.println("Total Number of images in the page : " + countImage);
        return countImage;
    }

    //number and name of all the links in website
    public void nameAndNumberOfLinksInPage(){
        String url="";
        List<WebElement> allURLs = driver.findElements(By.tagName("a"));
        System.out.println("Total links on the Wb Page: " + allURLs.size());
        //We will iterate through the list and will check the elements in the list.
        Iterator<WebElement> iterator = allURLs.iterator();
        while (iterator.hasNext()) {
            url = iterator.next().getText();
            System.out.println(url);
        }
    }



}




