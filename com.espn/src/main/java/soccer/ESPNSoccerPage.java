package soccer;

import common.BaseAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

import static soccer.ESPNSoccerPageLocators.*;

public class ESPNSoccerPage extends BaseAPI {

    public ESPNSoccerPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = WEB_ELEMENT_TABS_TOP_LINKS)
    public List<WebElement> tabsTopLinks;

    @FindBy(css = WEB_ELEMENT_BUTTON_SUBSCRIBE)
    public WebElement buttonSubscribe;

    @FindBy(css = WEB_ELEMENT_INPUT_EMAIL)
    public WebElement inputEmail;

    @FindBy(css = WEB_ELEMENT_INPUT_PASSWORD)
    public WebElement inputPassword;

    @FindBy(css = WEB_ELEMENT_BUTTON_SUBMIT)
    public WebElement buttonSubmit;

    @FindBy(css = WEB_ELEMENT_MESSAGE_ERROR_SUBSCRIBE)
    public WebElement messageErrorSubscribe;

    @FindBy(css = WEB_ELEMENT_IFRAME)
    public WebElement iframe;

    @FindBy(css = WEB_ELEMENTS_TEAMS_OPTIONS)
    public List<WebElement> tabTeamsOptions;

    @FindBy(css = WEB_ELEMENT_BUTTON_TEAMS)
    public WebElement buttonTeams;

    @FindBy(xpath = WEB_ELEMENT_BUTTON_SIGN_UP)
    public WebElement buttonSignUp;

    @FindBy(css = WEB_ELEMENT_INPUT_FIRST_NAME)
    public WebElement inputFirstName;

    @FindBy(css = WEB_ELEMENT_INPUT_LAST_NAME)
    public WebElement inputLastName;

    @FindBy(css = WEB_ELEMENT_INPUT_EMAIL_SIGN_UP)
    public WebElement inputEmailSignUP;

    @FindBy(css = WEB_ELEMENT_INPUT_PASSWORD_SIGN_UP)
    public WebElement inputPasswordSignUp;

    @FindBy(xpath = WEB_ELEMENT_SUBMIT_SIGN_UP)
    public WebElement submitSignUp;

    @FindBy(css = WEB_ELEMENT_USER_PROFILE)
    public WebElement userProfile;

    @FindBy(css = WEB_ELEMENT_USER_FIRST_NAME)
    public WebElement userFirstName;

    @FindBy(css = WEB_ELEMENTS_LINKS_LEFT_SIDE)
    public List<WebElement> linkLeftSide;

    @FindBy(css = WEB_ELEMENT_BUTTON_LISTEN)
    public WebElement buttonListen;

    @FindBy(css = WEB_ELEMENT_DROPDOWN_LISTEN_LIVE)
    public WebElement dropdownListenLive;

    @FindBy(css = WEB_ELEMENT_TITLE_RADIO)
    public WebElement titleRadio;

    @FindBy(css = WEB_ELEMENT_TAB_SCORES)
    public WebElement tabScores;

    @FindBy(css = WEB_ELEMENT_ICON_DATE_PICKER)
    public WebElement iconDatePicker;

    @FindBy(css = WEB_ELEMENT_DATE_29)
    public WebElement date29;


    @FindBy(css = WEB_ELEMENT_RESULT_SCORE)
    public WebElement resultScore;

    @FindBy(css = WEB_ELEMENT_TAB_TABLES)
    public WebElement tabTables;

    @FindBy(css = WEB_ELEMENT_DROPDOWN_ENGLISH_PREMIER_LEAGUE)
    public WebElement dropdownEnglishPremierLeague;

    @FindBy(css = WEB_ELEMENT_HEADER_TABLES_RESULT)
    public WebElement headerTablesResult;

    @FindBy(css = "ul.quicklinks_list>li.quicklinks_list__item>a[name='&lpos=soccer:quicklinks:1:soccerchampionspickem']")
    public List<WebElement> quickLinks;


    public boolean verifyTabsTopPagesTitles() throws IOException {
        implicitWait();
        waitUntilWebElementListVisible(tabsTopLinks);
        return verifyLinksTitles(tabsTopLinks, "href", System.getProperty("user.dir") + "/src/test/resources/ESPNTestData.xlsx", "TabsTopPagesTitles");
    }

    public boolean verifyTabTopLinksValid() {
        implicitWait();
        waitUntilWebElementListVisible(tabsTopLinks);
        return verifyLinks(tabsTopLinks, "href");
    }

    public int getNumberOfLinksTopTabs() {
        waitUntilWebElementListVisible(tabsTopLinks);
        return tabsTopLinks.size();
    }

    public void logIn() {
        clickElement(buttonSubscribe);
        waitUntilWebElementVisible(iframe);
        driver.switchTo().frame(iframe);
        sendKeysToElement(inputEmail, "someEmail@someEmail.com");
        sendKeysToElement(inputPassword, "SomePassword$");
        clickElement(buttonSubmit);
        waitUntilWebElementVisible(messageErrorSubscribe);
    }

    public boolean verifyTeamsOptions() throws Exception {
        clickElement(buttonTeams);
        waitUntilWebElementListVisible(tabTeamsOptions);
        return compareListWebElementsToExcelDoc(tabTeamsOptions, System.getProperty("user.dir") + "/src/test/resources/ESPNTestData.xlsx", "TeamsOptions");
    }

    public void customizeESPNSignUp() {
        clickElement(buttonSignUp);
        switchToiFrameByWebElement(iframe);
        sendKeysToElement(inputFirstName, "Jack");
        sendKeysToElement(inputLastName, "Brown");
        sendKeysToElement(inputEmailSignUP, "email@someEmail.com");
        sendKeysToElement(inputPasswordSignUp, "someP@$$word");
        clickElement(submitSignUp);
        clickElement(userProfile);
    }

    public boolean verifyTitlesLeftSideMenu() throws IOException {
        return compareListWebElementsToExcelDoc(linkLeftSide, System.getProperty("user.dir") + "/src/test/resources/ESPNTestData.xlsx", "LeftSideMenu");
    }

    public void listenNow() {
        clickElement(buttonListen);
        clickElement(dropdownListenLive);
    }

    public void findScores() {
        clickElement(tabScores);
        clickElement(iconDatePicker);
        clickElement(date29);
    }

    public void selectFromEnglishPremierLeague() throws InterruptedException {
        clickElement(tabTables);
        waitUntilWebElementVisible(dropdownEnglishPremierLeague);
        selectFromDropDownByVisibleText(dropdownEnglishPremierLeague, "Russian Premier League");

        Thread.sleep(2000);
    }

    public boolean verifyQuickLinksValid() {
        return verifyLinks(quickLinks, "href");

    }

    public boolean verifyQuickLinksTitles() throws IOException {
        return verifyLinksTitles(quickLinks, "href", System.getProperty("user.dir") + "/src/test/resources/ESPNTestData.xlsx", "QuickLinksTitles" );
    }

}
