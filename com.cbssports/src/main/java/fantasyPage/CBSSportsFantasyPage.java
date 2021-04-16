package fantasyPage;


import common.BaseAPI;
import fantasyPage.fantasyBasketball.CBSSportsFantasyBasketballPage;
import fantasyPage.fantasyCollege.CBSSportsFantasyCollegePage;
import fantasyPage.fantasyFootball.CBSSportsFantasyFootballPage;
import fantasyPage.fantasyHockey.CBSSportsFantasyHockeyPage;
import fantasyPage.fantasyPlay.CBSSportsFantasyPlayPage;
import fantasyPage.fantasyPropsGamePage.CBSSportsFantasyPropsGamePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.TextFileReader;
import fantasyPage.fantasyBaseball.*;

import java.io.IOException;
import java.util.List;

import static fantasyPage.CBSSportsFantasyPageLocators.*;

public class CBSSportsFantasyPage extends BaseAPI {

    public CBSSportsFantasyPage() {
        PageFactory.initElements(driver, this);
    }

    TextFileReader textFileReader;


    @FindBy(css = WEBELEMENT_TAB_HOVER_TO_FANTASY_PAGE)
    public WebElement tabHoverToFantasyPage;

    @FindBy(css = WEBELEMENT_DROPDOWN_SELECT_FANTASY)
    public WebElement dropdownSelectFantasy;

    @FindBy(xpath = WEBELEMENT_BUTTON_WATCH)
    public WebElement buttonWatch;

    @FindBy(css = WEBELEMENT_BUTTON_PLAY)
    public WebElement buttonPlay;

    @FindBy(css = WEBELEMENT_ICON_LIVE)
    public WebElement iconLive;

    @FindBy(css = WEBELEMENT_TABS_LINKS_FANTASY)
    public List<WebElement> tabsLinksFantasy;

    @FindBy(xpath = WEBELEMENTS_SIDE_MENU_OPTIONS_FOOTBALL)
    public List<WebElement> sideMenuOptionsFootball;

    @FindBy(css = WEBELEMENT_TAB_PLAY)
    public WebElement tabPlay;

    @FindBy(css = WEBELEMENT_TAB_FOOTBALL)
    public WebElement tabFootball;

    @FindBy(css = WEBELEMENT_TAB_BASEBALL)
    public WebElement tabBaseball;

    @FindBy(css = WEBELEMENT_TAB_BASKETBALL)
    public WebElement tabBasketball;

    @FindBy(css = WEBELEMENT_TAB_HOCKEY)
    public WebElement tabHockey;

    @FindBy(css = WEBELEMENT_TAB_COLLEGE)
    public WebElement tabCollege;

    @FindBy(xpath = WEBELEMENT_TAB_PROPS_GAME)
    public WebElement tabPropsGame;

    @FindBy(css = WEBELEMENT_HOVER_TO_PROPS_GAME)
    public WebElement hoverToPropsGame;

    @FindBy(css = WEBELEMENT_INPUT_EMAIL_SIGN_UP)
    public WebElement inputEmailSignUp;

    @FindBy(css = WEBELEMENT_CHECKBOX_AGREE_TO_TERMS)
    public WebElement checkboxAgreeToTerms;

    @FindBy(css = WEBELEMENT_BUTTON_SUBMIT_SIGN_UP)
    public WebElement buttonSubmitSignUp;

    @FindBy(css = WEBELEMENT_MESSAGE_SIGN_UP)
    public WebElement messageSignUp;

    public void navigateToFantasyPage() {
        hoverOverElement(tabHoverToFantasyPage);
        clickElement(dropdownSelectFantasy);
    }

    public boolean verifyCBSSportsTitle() {
        textFileReader = new TextFileReader();
        String expectedTitle = textFileReader.readToString(System.getProperty("user.dir") + "/src/test/resources/CBSSpotsTitle.txt");
        System.out.println("Expected title: " + expectedTitle);
        String actualTitle = driver.getTitle();
        System.out.println("Actual title: " + actualTitle);
        return expectedTitle.equals(actualTitle);
    }

    public void watchVideo() {
        hoverOverElement(buttonWatch);
        playEmbeddedVideo(buttonPlay);
    }

    public boolean verifyFantasyLinksTitles() throws IOException {
        return verifyLinksTitles(tabsLinksFantasy, "href", System.getProperty("user.dir") + "/src/test/resources/CBSSportsTestData.xlsx", "FantasyLinks");
    }

    public CBSSportsFantasyPlayPage navigateToFantasyPlayPage() {
        actionClassClickOnElement(tabPlay);
        return new CBSSportsFantasyPlayPage();
    }

    public CBSSportsFantasyFootballPage navigateToFantasyFootballPage(){
        clickElement(tabFootball);
        return new CBSSportsFantasyFootballPage();
    }

    public CBSSportsFantasyBaseballPage navigateToFantasyBaseballPage() {
        actionClassClickOnElement(tabBaseball);
        return new CBSSportsFantasyBaseballPage();
    }

    public CBSSportsFantasyBasketballPage navigateToFantasyBasketballPage(){
        clickElement(tabBasketball);
        return new CBSSportsFantasyBasketballPage();
    }

    public CBSSportsFantasyHockeyPage navigateToFantasyHockeyPage(){
        clickElement(tabHockey);
        return new CBSSportsFantasyHockeyPage();
    }

    public CBSSportsFantasyCollegePage navigateToFantasyCollegePage(){
        hoverOverElement(tabPropsGame);
        clickElement(tabCollege);
        return new CBSSportsFantasyCollegePage();
    }

    public CBSSportsFantasyPropsGamePage navigateToFantasyPropsGamePage(){
        hoverOverElement(hoverToPropsGame);
        clickElement(tabPropsGame);
        return new CBSSportsFantasyPropsGamePage();
    }

    public void emailsSignUp(){
        clickElement(checkboxAgreeToTerms);
        sendKeysToElement(inputEmailSignUp, "someEmail@someEmail.com");
        clickElement(buttonSubmitSignUp);
    }
}