package musicPage;

import common.BaseAPI;
import concersPage.ConcertsPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DataReader;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import static musicPage.MusicPageLocators.*;

public class MusicPage extends BaseAPI {
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

    public MusicPage() {
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
    public ConcertsPage navigateToConcertTicketsPage(){
        clickElement(linkConcertTicketsPage);
     return new ConcertsPage();
    }

}
