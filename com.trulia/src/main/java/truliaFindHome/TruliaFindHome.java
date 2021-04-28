package truliaFindHome;

import common.BaseAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

import static truliaFindHome.TruliaFindHomeLocatorsPage.*;

public class TruliaFindHome extends BaseAPI {

    @FindBy(css = WEB_ELEMENT_INPUT_SEARCH_BOX)
    WebElement inputSearchBar;
    @FindBy(xpath = WEB_ELEMENT_SEARCH_BUTTON)
    WebElement searchButton;
    @FindBy(xpath = WEB_ELEMENT_NEW_HANOVER_HEADER)
    public WebElement newHanoverHeaderText;
    @FindBy(css = WEB_ELEMENT_CONDO_CHECK_BOX)
    WebElement condoCheckBox;
    @FindBy(xpath = WEB_ELEMENT_HOUSE_TAB)
    WebElement houseTab;
    @FindBy(xpath = WEB_ELEMENT_HEADER_CONDO)
    public WebElement headerCondo;
    @FindBy(xpath = WEB_ELEMENT_SAVED_HOMES)
    WebElement savedHomes;
    @FindBy(css = WEB_ELEMENT_INPUT_EMAIL)
    WebElement emailInputBox;
    @FindBy(xpath = WEB_ELEMENT_SUBMIT_BUTTON)
    public WebElement submitButton;
    @FindBy(xpath = WEB_ELEMENT_PASSWORD_INPUT_BOX)
    public WebElement passwordInputBox;
    @FindBy(xpath = WEB_ELEMENT_COUNT_ELEMENTS_ANY_PRICE_TAB)
    WebElement anyPriceTab;

    @FindBy(xpath = WEB_ELEMENT_COUNT_ELEMENTS_ANY_PRICE_TAB)
    public List<WebElement> expectedNumberOfElementsAnyPriceTabDropDown;
    @FindBy(xpath = WEB_ELEMENT_Min_PRICE_LABEL)
    public WebElement selectCategoryFromMinPriceDropDown;
    @FindBy(css = WEB_ELEMENT_ALL_BEDS)
    WebElement allBedsTab;
    @FindBy(xpath = WEB_ELEMENT_STUDIO_OPTION)
    public WebElement selectStudioPlusOption;
    @FindBy(xpath = WEB_ELEMENT_SAVED_SEARCHES_TAB)
    WebElement savedSearchesTab;
    @FindBy(xpath = WEB_ELEMENT_HEADER_SAVED_SEARCHES)
    public WebElement headerSavedSearches;
    @FindBy(xpath = WEB_ELEMENT_MORE_TAB)
    WebElement moreTab;
    @FindBy(xpath = WEB_ELEMENT_SELECT_BUY_FROM_MORE_TAB)
    WebElement selectOptionBuyFromMoreTab;
    @FindBy(xpath = WEB_ELEMENT_SAVE_SEARCH_BUTTON)
    WebElement saveSearchButton;
    @FindBy(xpath = WEB_ELEMENT_SAVE_SEARCH_HEADER)
    public WebElement savedSearchHeader;
    @FindBy(css = WEB_ELEMENT_AGENT_LISTING_TAB)
    public WebElement agentListings;
    @FindBy(css = WEB_ELEMENT_SORT_RESULT)
    public WebElement sortResult;
    @FindBy(xpath = WEB_ELEMENT_MORTGAGE_TAB)
    WebElement mortgageTab;
    @FindBy(xpath = WEB_ELEMENT_MORTGAGE_OVERVIEW)
    public WebElement selectMortgageOverviewOption;
    @FindBy(xpath = WEB_ELEMENT_INPUT_ZIPCODE)
    WebElement inputZipCode;
    @FindBy(xpath = WEB_ELEMENT_GET_PREQUALIFIES_BUTTON)
    public WebElement prequalifiedButton;

    @FindBy(xpath = WEB_ELEMENT_PREQUALIFIED_HEADER)
    public WebElement prequalifiedHeader;
    @FindBy(xpath = WEB_ELEMENT_RENT_TAB)
    WebElement rentTab;
    @FindBy(xpath = WEB_ELEMENT_ALL_RENTALS_OPTION)
    WebElement allRentalsOption;
    //excel file
    @FindBy(css = WEB_ELEMENT_MORTGAGE_DROP_DOWN)
    List<WebElement> MortgageOptions;

    public TruliaFindHome() {
        PageFactory.initElements(driver, this);
    }

    public void verifySearchBar() {
        sendKeysToElement(inputSearchBar, "New Hanover, PA");
        clickElement(searchButton);
    }

    public void verifyHouseTab() {
        clickElement(houseTab);
        selectElement(condoCheckBox);
    }

    //        public void selectCondoCheckBox(){
//            clickElement(condoCheckBox);
//        }
    public void verifySavedHomeTab() {
        savedHomes.click();
    }


    public void enterEmailAddress() {
        sendKeysToElement(emailInputBox, "amelbailech@gmail.com");
        clickElement(submitButton);
    }

    public String WEB_ELEMENT_COUNT_ELEMENTS_ANY_PRICE_TAB() {
        return WEB_ELEMENT_COUNT_ELEMENTS_ANY_PRICE_TAB;

    }

    public void selectFromAnyPriceDropdownUsingIndex(int index) {
        anyPriceTab.click();
        selectOptionByIndex(selectCategoryFromMinPriceDropDown, index);
    }

    public void selectFromAnyPriceDropdownUsingValue(String value) {
        anyPriceTab.click();
        selectOptionByValue(selectCategoryFromMinPriceDropDown, value);
    }

    public void selectFromAnyPriceDropdownUsingVisibleText(String visibleText) {
        anyPriceTab.click();
        selectOptionByVisibleText(selectCategoryFromMinPriceDropDown, visibleText);
    }

    public void checkAllBedsTab() {
        allBedsTab.click();
        selectElement(selectStudioPlusOption);
    }

    public void verifySavedSearchesTab() {
        savedSearchesTab.click();
        sendKeysToElement(emailInputBox, "amelbailech@gmail.com");
        clickElement(submitButton);
    }

    public void checkMoreTab() {
        moreTab.click();
        selectElement(selectOptionBuyFromMoreTab);
        clickElement(saveSearchButton);

    }

    public void verifyAgentListingsTab() {
        selectElement(agentListings);
    }

    public void verifyMortgageTab() {
        mortgageTab.click();
        hoverOverElement(selectMortgageOverviewOption);

    }

    public void verifyEnteringZipCodeInMortgageTab() {
        mortgageTab.click();
        clickElement(selectMortgageOverviewOption);
        sendKeysToElement(inputZipCode, "19525");
        clickElement(prequalifiedButton);

    }

    public void verifyRentTab() {
        hoverOverElement(rentTab);
        clickElement(allRentalsOption);
    }


    /**
     * Excel file
     * Test case 15 -
     * ExelSheet
     * 1. Navigate to https://www.trulia.com/
     * 2. click on Mortgage Drop Down
     * 3.create a list of Mortgages
     * get the text of each element and compare it against the exel sheet
     *
     * @return
     */
    public boolean compareListOfElementToExcelSheet() throws IOException {

        String sheetPath = System.getProperty("user.dir") + "/src/test/resources/Mortgage.xlsx";

        return compareListWebElementsToExcelDoc(MortgageOptions, sheetPath, "Feui2");

    }

}
