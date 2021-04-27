package electronics;

import common.BaseAPI;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static electronics.EbayElectronicsLocators.*;

public class EbayElectronics extends BaseAPI {

    public EbayElectronics() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = WEB_ELEMENT_CATEGORY_CELLPHONES)
    public WebElement Cellphones;

    @FindBy(name = WEB_ELEMENT_CATEGORY_CAMERA)
    public WebElement Camera;

    @FindBy(name = WEB_ELEMENT_CATEGORY_COMPUTERS)
    public WebElement Computers;

    @FindBy(name = WEB_ELEMENT_CATEGORY_PORTABLE_AUDIO)
    public WebElement PortableAudio;

    @FindBy(name = WEB_ELEMENT_CATEGORY_SMART_HOME)
    public WebElement SmartHome;

    @FindBy(name = WEB_ELEMENT_CATEGORY_TV)
    public WebElement TV;

    @FindBy(name = WEB_ELEMENT_CATEGORY_VIDEO)
    public WebElement Video;

    @FindBy(xpath = WEB_ELEMENT_ALL_CATEGORY_BUTTONS)
    public List<WebElement> AllCategoriesButtons;


    public void selectShopByCategoryCellphones() {
        javaScriptExecutorClickOnElement(Cellphones);

    }

    public void hoverAndClickCamerra() {
        hoverOverElementAndClick(Camera);
    }

    public void navigateBackToRefresh() {
        driver.navigate().to("https://www.ebay.com/Electronics");
        System.out.println(driver.getTitle());
        driver.navigate().back();
        System.out.println(driver.getTitle());
        driver.navigate().refresh();
        driver.navigate().forward();
    }

    public void scrollDown() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1500)");
        Thread.sleep(3000);
    }

    public boolean numOfCategories() {

        boolean flag = false;
        int f = 0;
        Cellphones.click();
        String[] expectedNumOfCategories = {"Cameras & Photos", "Cell Phones, Smart Watches, & Accessories", "Computers, Tablets & Network Hardware," +
                "TV, Video & Home Audio Electronics", "Video & PC Gaming"};

        waitUntilWebElementListVisible(AllCategoriesButtons);

        for (int i = 0; i < 5; i++) {

            String categories = AllCategoriesButtons.get(i).getText();

            if (categories.equals(expectedNumOfCategories[i])) {
                System.out.println("Passed on: " + categories);
                flag = true;
            } else {
                System.out.println("Failed on: " + categories);
                flag = false;
                f++;
            }

        }
        if (f > 0) {
            flag = false;

        }
        return flag;
    }
}
