package checking;

import common.BaseAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import utilities.DataReader;

import java.io.IOException;
import java.util.List;

import static checking.ChaseCheckingPageLocators.*;

public class ChaseCheckingPage extends BaseAPI {


    public ChaseCheckingPage() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = WEB_ELEMENT_BUTTON_CONTINUE_AND_APPLY)
    public WebElement buttonContinueAndApply;

    @FindBy(css = WEB_ELEMENT_INPUT_EMAIL_SPECIAL_OFFER)
    public WebElement inputEmailSpecialOffer;

    @FindBy(css = WEB_ELEMENT_BUTTON_EMAIL_MY_COUPON)
    public WebElement buttonEmailMyCoupon;

    @FindBy(css = WEB_ELEMENT_MESSAGE_THANK_YOU)
    public WebElement messageThankYou;

    @FindBy(css = WEB_ELEMENTS_CAROUSEL_CHOSE_WHAT_RIGHT)
    public List<WebElement> carouselChoseWhatRight;

    @FindBy(css = WEB_ELEMENTS_TABS_COMPARE_ACCOUNTS)
    public List<WebElement> tabsCompareAccounts;

    @FindBy(css = WEB_ELEMENT_BUTTON_ADD_COMPARE_ACCOUNT)
    public WebElement buttonAddCompareAccount;

    @FindBy(css = WEB_ELEMENT_BUTTON_CHASE_TOTAL_CHECKING)
    public WebElement buttonChaseTotalChecking;

    @FindBy(css = WEB_ELEMENT_HEADER_CHASE_TOTAL_CHECKING)
    public WebElement headerChaseTotalChecking;

    @FindBy(css = WEB_ELEMENT_BUTTON_PREMIUM)
    public WebElement buttonPremium;

    @FindBy(css = WEB_ELEMENT_PDF_LINK)
    public WebElement pdfLink;

    @FindBy(css = WEB_ELEMENT_FLIP_CARD_ZELLE)
    public WebElement flipCardZelle;

    @FindBy(css = WEB_ELEMENT)
    public WebElement element;

    @FindBy(css = WEB_ELEMENT_BUTTON_FIND_YOUR_BRANCH)
    public WebElement buttonFindYourBranch;

    @FindBy(css = WEB_ELEMENT_INPUT_ZIPCODE)
    public WebElement inputZipcode;

    @FindBy(css = WEB_ELEMENT_BUTTON_SEARCH_ZIPCODE)
    public WebElement buttonSearchZipcode;

    @FindBy(xpath = WEB_ELEMENT_EXPECTED_BRANCH)
    public WebElement expectedBranch;

    @FindBy(css = WEB_ELEMENT_LINK_KIDS_ACCOUNT_SEE_MORE)
    public WebElement linkKidsAccountSeeMore;

    @FindBy(css = WEB_ELEMENT_PLAY_VIDEO_KIDS_ACCOUNTS)
    public WebElement videoKidsAccounts;

    @FindBy(css = WEB_ELEMENT_BUTTON_TURN_ON_AUDIO_DESCRIPTION)
    public WebElement buttonTurnOnVideoDescription;

    @FindBy(css = WEB_ELEMENTS_TABS_FIRST_BANKING)
    public List<WebElement> tabsFirstBanking;

    @FindBy(css = WEB_ELEMENT_IFRAME_VIDEO)
    public WebElement iFrameVideo;

    @FindBy(css = WEB_ELEMENT_BUTTON_SIGN_IN)
    public WebElement buttonSignIn;

    @FindBy(css = WEB_ELEMENT_INPUT_USER_ID)
    public WebElement inputUserID;

    @FindBy(css = WEB_ELEMENT_INPUT_PASSWORD)
    public WebElement inputPassword;

    @FindBy(css = WEB_ELEMENT_BUTTON_SUBMIT)
    public WebElement buttonSubmit;

    @FindBy(css = WEB_ELEMENT_ERROR_MESSAGE_LOGIN)
    public WebElement errorMessageLogin;

    @FindBy(css = WEB_ELEMENT_LINK_REFER_A_FRIEND)
    public WebElement linkReferAFriend;

    @FindBy(css = WEB_ELEMENT_PLAY_VIDEO)
    public WebElement playVideo;

    @FindBy(css = WEB_ELEMENT_VIDEO_CONTROL)
    public WebElement videoControl;

    @FindBy(css = WEB_ELEMENT_VOLUME_CONTROL_MUTE)
    public WebElement volumeControlMute;

    @FindBy(css = WEB_ELEMENT_TIME_VIDEO_CONTROL)
    public WebElement timeVideoControl;

    @FindBy(css = WEB_ELEMENT_SLIDER_VIDEO)
    public WebElement sliderVideo;


//    @FindBy(css = )
////    public WebElement


    public void getSpecialOffer() {
        clickElement(buttonContinueAndApply);
        sendKeysToElement(inputEmailSpecialOffer, "someEmail2@someemail.com");
        clickElement(buttonEmailMyCoupon);
        waitUntilWebElementVisible(messageThankYou);
    }

    public boolean verifyCarouselLinksTitlesChoseWhatRight() throws IOException {
        return compareListWebElementsToExcelDoc(carouselChoseWhatRight, System.getProperty("user.dir") + "/src/main/resources/ChaseTestData.xlsx", "CarouselLinksTitles");
    }

    public boolean verifyTabsCompareAccounts() throws Exception {
        return compareListWebElementsToExcelDoc(tabsCompareAccounts, System.getProperty("user.dir") + "/src/main/resources/ChaseTestData.xlsx", "TabsCompareAccounts");
    }

    public void addChaseTotalCheckingToCompare() {
        clickElement(buttonPremium);
        clickElement(buttonAddCompareAccount);
        javaScriptExecutorClickOnElement(buttonChaseTotalChecking);
    }

    public void flipCardZelle() {
        clickElement(flipCardZelle);
    }


    public String getFlipCardTextZelle() {
        clickElement(flipCardZelle);
        waitUntilWebElementVisible(element);
        String actualText = element.getText();
        return actualText;
    }

    public void findYourBranch() {
        clickElement(buttonFindYourBranch);
        inputZipcode.sendKeys("20001");
        clickElement(buttonSearchZipcode);
    }

    public void playVideoKidsAccounts() {
        clickElement(linkKidsAccountSeeMore);
        switchToNewTab(1);
        playEmbeddedVideo(videoKidsAccounts);
        switchToiFrameByWebElement(iFrameVideo);
//        waitUntilWebElementVisible(buttonTurnOnVideoDescription);
    }

    public boolean verifyLinksTabsFirstBanking() {
        clickElement(linkKidsAccountSeeMore);
        switchToNewTab(1);
        return verifyLinks(tabsFirstBanking, "href");
    }

    public boolean verifyLinksTitlesFirstBanking() throws IOException {
        clickElement(linkKidsAccountSeeMore);
        switchToNewTab(1);
        return getUrlsAndTitlesFromListWebElementAndCompareToExcelDoc(tabsFirstBanking, "href", pathFromUserDir + "/src/main/resources/ChaseTestData.xlsx", "FirstBankingLinks");
    }

    public void doLogin(String userID, String password) throws Exception {
        clickElement(buttonSignIn);

        switchToNewTab(1);
        sendKeysToElement(inputUserID, userID);
        sendKeysToElement(inputPassword, password);
        clickElement(buttonSubmit);
    }

    @DataProvider

    public Object[][] getInvalidTestData() throws Exception {
        DataReader dataReader = new DataReader();
        String path = System.getProperty("user.dir") + "/src/main/resources/ChaseTestData.xlsx";
        return dataReader.fileReaderArrayStringArraysXSSF(path, "InvalidSignIn");
    }

    public void playVideo(){
        clickElement(linkReferAFriend);
        switchToNewTab(1);
        playEmbeddedVideo(playVideo);
    }
    public boolean verifyVideoPlaying(){
        System.out.println(videoControl.getText());
        return (videoControl.getText().equals("Clicked \"Play\" on embedded Video player\n" +
                "Pause"));
    }
}