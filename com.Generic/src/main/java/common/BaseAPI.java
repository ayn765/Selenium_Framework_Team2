package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseAPI {

    public static WebDriver driver;
    static final String URL = "https://www.airbnb.com";

    @BeforeMethod
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterMethod
    public static void tearDown() {
        driver.close();
        driver.quit();
    }

    public void waitUntilWebElementsVisible(List<WebElement> elements){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        elements = wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

}
