package registry;

import common.BaseAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

import static registry.MacysRegistryPageLocators.*;

public class MacysRegistryPage extends BaseAPI {

    public MacysRegistryPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = WEBELEMENT_BUTTON_SHOP_REGISTRY)
    public WebElement buttonShopRegistry;

    @FindBy(css = WEBELEMENT_BUTTON_DROPDOWN_REGISTRY)
    public WebElement dropdownRegistry;

    @FindBy(css = WEBELEMENTS_OPTIONS_SHOP_REGISTRY)
    public List<WebElement> optionsShopRegistry;

    @FindBy(css = WEBELEMENT_INPUT_SEARCH)
    public WebElement inputSearch;

    @FindBy(css = WEBELEMENT_BUTTON_SEARCH_SUBMIT)
    public WebElement buttonSearchSubmit;

    @FindBy(css = WEBELEMENT_HEADER_SEARCH_RESULT)
    public WebElement headerSearchResult;

    @FindBy(css = WEBELEMENT_DROPDOWN_MANAGE)
    public WebElement dropdownManage;

    @FindBy(css = WEBELEMENTS_DROPDOWN_OPTIONS_MANAGE)
    public List<WebElement> dropdownOptionsManage;

    @FindBy(css = WEBELEMENT_BUTTON_STORES)
    public WebElement buttonStores;


    public boolean verifyShopRegistryOptions() throws Exception {
        mouseHoverJScript(buttonShopRegistry);
        waitUntilWebElementVisible(driver.findElement(By.cssSelector("div.redesign-header-radical-category-dropdown.animated-show")));
//        clickElement(dropdownRegistry);
        Thread.sleep(2000);
        return compareListWebElementsToExcelDoc(optionsShopRegistry, System.getProperty("user.dir") + "/src/test/resources/MacysTestData.xlsx", "RegistryMenuOptions");
    }

    public void doInputSearch(){
        sendKeysToElement(inputSearch, "tea set");
        clickElement(buttonSearchSubmit);
    }

    public void verifyManageDropdown() throws IOException {

        clickElement(buttonStores);


//        hoverOverElement(dropdownManage);
//        compareListWebElementsToExcelDoc(dropdownOptionsManage, System.getProperty("user.dir") + "/src/test/resources/MacysTestData.xlsx", "RegistryMenuOptions");

    }

}

