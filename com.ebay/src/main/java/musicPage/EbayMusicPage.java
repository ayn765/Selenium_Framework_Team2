package musicPage;

import common.BaseAPI;
import concertsPage.EbayConcertsPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.util.List;

import static musicPage.EbayMusicPageLocators.*;

public class EbayMusicPage extends BaseAPI {
    @FindBy(xpath = WEBELEMENT_BUTTON_NAVIGATE_TO_MUSIC_PAGE)
    public WebElement buttonNavigateToMusicPage;

    @FindBy(css = WEBELEMENT_HEADER_MUSIC_PAGE)
    public WebElement headerMusicPage;

    @FindBy(css = WEBELEMENTS_DROP_DOWN_MISIC_MEDIA)
    public List<WebElement> dropDownMusicMedia;

    @FindBy(xpath = WEBELEMENT_EXPEND_MUSICCD_OPTIONS)
    public WebElement expendMusicCDOptions;

    @FindBy(css = WEBELEMENT_DROP_DOWN_MUSICCD_OPTION_CLASSICAL)
    public WebElement dropDownMusicCDOptionClassic;

    @FindBy(css = WEBELEMENT_INPUT_MIN_PRICE)
    public WebElement inputMinPrice;

    @FindBy(css = WEBELEMENT_INPUT_MAX_PRICE)
    public WebElement inputMaxPrice;

    @FindBy(css = WEBELEMENT_SUBMIT_PRICE_RANGE)
    public WebElement submitPriceRange;

    @FindBy(css = WEBELEMENT_HEADER_SEARCH_RESULTS)
    public WebElement headerSearchResults;

    @FindBy(xpath = WEBELEMENT_LINK_CONCERT_TICKETS_PAGE)
    public WebElement linkConcertTicketsPage;

    @FindBy(xpath = WEBELEMENT_DROPDOWN_SELECT)
    public WebElement dropdownSelect;

    @FindBy(xpath = WEBELEMENT_INPUT_SEARCH)
    public WebElement inputSearch;

    @FindBy(xpath = WEBELEMENT_SEARCH_RESULT_MADONNA)
    public WebElement searchResultMadonna;

    @FindBy(css = WEBELEMENT_ICON_NOTIFICATIONS)
    public WebElement iconNotifications;

    @FindBy(xpath = WEBELEMENT_MESSAGE_ICON_NOTIFICATIONS)
    public WebElement messageIconNotifications;

    public EbayMusicPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToMusicPage() {
        clickElement(buttonNavigateToMusicPage);
    }

    public void makeSelectionFromMusicCDOption(){
        navigateToMusicPage();
        clickElement(expendMusicCDOptions);
        clickElement(dropDownMusicCDOptionClassic);
        sendKeysToElement(inputMinPrice, "15");
        sendKeysToElement(inputMaxPrice, "100");
        clickElement(submitPriceRange);

    }
    public EbayConcertsPage navigateToConcertsPage(){
        clickElement(linkConcertTicketsPage);
     return new EbayConcertsPage();
    }

    public void searchInMusicCategory() throws AWTException {
        selectFromDropDownByVisibleText(dropdownSelect,"Music");
        sendKeysToElement(inputSearch, "Madonna");
        pressEnterKey();
    }

    public void hoverOverIconNotifications(){
        hoverOverElement(iconNotifications);
    }
}
