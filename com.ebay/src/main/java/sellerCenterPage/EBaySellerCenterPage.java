package sellerCenterPage;

import common.BaseAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.DataReader;
import utilities.TextFileReader;


import java.io.IOException;
import java.util.List;

import static sellerCenterPage.EBaySellerCenterPageLocators.*;


public class EBaySellerCenterPage extends BaseAPI {
    @FindBy(xpath = webElementPageSellerCenter)
    public WebElement pageSellerCenter;

    @FindBy(css = webElementInputSearch)
    public WebElement inputSearch;

    @FindBy(css = webElementInputSearchFocus)
    public WebElement inputSearchFocus;

    @FindBy(css = webElementButtonSearch)
    public WebElement buttonSearch;

    @FindBy(css = webElementSellerCenterMenuOptions)
    public List<WebElement> sellerCenterMenuOptions;

    public EBaySellerCenterPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToSellerCenterPage() {
        waitUntilWebElementVisible(pageSellerCenter);
        pageSellerCenter.click();
    }

    public String getSellerCenterTitle() {
        String title = "";
        TextFileReader textFileReader = new TextFileReader();
        title = textFileReader.readToString(System.getProperty("user.dir") + "/src/test/resources/SellerCenterTitle.txt");
        return title;
    }

    public void sendKeysToInputSearch() {
        inputSearch.sendKeys("how to sell on ebay");
        buttonSearch.click();
    }

    public boolean verifyCallCenterMenuOption() throws IOException {
        boolean flag = false;
        DataReader dataReader = new DataReader();
        flag = dataReader.compareListWebElementsToExcelDoc(sellerCenterMenuOptions, System.getProperty("user.dir") + "/src/test/resources/TestData.xlsx", "MenuOptions");
        return flag;
    }

}


