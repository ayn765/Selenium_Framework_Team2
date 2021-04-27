package accessoriesPage;

import common.BaseAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

import static accessoriesPage.VerizonAccessoriesPageLocators.*;

public class VerizonAccessoriesPage extends BaseAPI {

    public VerizonAccessoriesPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy (css = WEB_ELEMENTS_LINKS_ALL_PRODUCTS)
    public List<WebElement> linksAllProducts;

    @FindBy(css = WEB_ELEMENT_TAB_WORK_FROM_HOME)
    public WebElement tabWorkFromHome;

    @FindBy(css = WEB_ELEMENTS_LINKS_ITEMS_WORK_FROM_HOME)
    public List<WebElement> linksItemsWorkFromHome;

    @FindBy(css = WEB_ELEMENT_INPUT_SEARCH)
    public WebElement inputSearch;

    @FindBy(css = WEB_ELEMENT_BUTTON_HELP)
    public WebElement buttonHelp;

    @FindBy(css = WEB_ELEMENT_HEADER_HELP_POPUP)
    public WebElement headerHelpPopup;

    public void verifyProductLinks(){
        verifyLinks(linksAllProducts, "href");
    }

    public boolean verifyProductLinksTitles() throws IOException {
        return getUrlsAndTitlesFromListWebElementAndCompareToExcelDoc(linksAllProducts, "href",pathFromUserDir + "/src/test/resources/VerizonData.xlsx","ProductLinksTitles");
    }

    public void viewItemsWorkFromHome(){
        clickElement(tabWorkFromHome);
    }

    public void verifyTextGetHelp(){
        clickElement(buttonHelp);
        waitUntilWebElementVisible(headerHelpPopup);
    }

}
