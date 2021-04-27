package smallBusiness;

import common.BaseAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DataReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static smallBusiness.BankOfAmericaSmallBusinessPageLocators.*;

public class BankOfAmericaSmallBusinessPage extends BaseAPI {

    DataReader dataReader;

    public BankOfAmericaSmallBusinessPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = WEBELEMENT_INPUT_ONLINE_ID)
    public WebElement inputOnlineID;

    @FindBy(css = WEBELEMENT_INPUT_PASSWORD)
    public WebElement inputPassword;

    @FindBy(css = WEBELEMENT_BUTTON_SIGN_IN)
    public WebElement buttonSignIn;

    @FindBy(css = WEBELEMENT_ERROR_MESSAGE)
    public WebElement errorMessage;

    @FindBy(css = WEBELEMENT_INFO_BOX_BUSINESS_SOLUTIONS)
    public WebElement infoBoxBusinessSolutions;

    @FindBy(css = WEBELEMENT_BUSINESS_SOLUTIONS_HEADER)
    public WebElement infoBoxBusinessSolutionsHeader;

    @FindBy(css = WEBELEMENT_BUSINESS_SOLUTIONS_TEXT_BODY)
    public WebElement infoBoxBusinessSolutionsTextBody;

    @FindBy(css = WEBELEMENT_BUSINESS_SOLUTIONS_MESSAGE_OPEN_ACCOUNT)
    public WebElement infoBoxBusinessSolutionsMessageOpenAccount;

    @FindBy(css = WEBELEMENT_GO_PAPERLESS_HEADER)
    public WebElement infoBoxGoPaperlessHeader;

    @FindBy(css = WEBELEMENT_GO_PAPERLESS_TEXT_BODY)
    public WebElement infoBoxGoPaperlessTextBody;

    @FindBy(css = WEBELEMENT_GO_PAPERLESS_SIGN_IN)
    public WebElement infoBoxGoPaperlessSignIn;

    @FindBy(css = WEBELEMENT_BUTTON_SCHEDULE_APPNTMNT)
    public WebElement buttonScheduleAppnmnt;

    @FindBy(css = WEBELEMENT_CHECKBOX_NEW_ACCOUNT)
    public WebElement checkboxNewAccount;

    @FindBy(css = WEBELEMENT_CHECKBOX_MERCHANT_SERV)
    public WebElement checkboxMerchantServ;

    @FindBy(css = WEBELEMENT_CHECKBOX_PAYROLL_SERV)
    public WebElement checkboxPayrollServ;

    @FindBy(css = WEBELEMENT_BUTTON_NEXT_TOPIC)
    public WebElement buttonNextTopic;

    @FindBy(css = WEBELEMENT_HEADER_HOW_TO_MEET)
    public WebElement headerHowToMeet;

    @FindBy(css = WEBELEMENT_MERCHANT_SERV_RESPONSE)
    public WebElement merchantServResponse;

    @FindBy(css = WEBELEMENT_LINKS_EXPLORE_TOPICS)
    public List<WebElement> linksExploreTopics;

    @FindBy(css = WEBELEMENTS_LINKS_TITLES_EXPLORE_TOPICS)
    public List<WebElement> linksTitlesExploreTopics;

    @FindBy(css = WEBELEMENT_LINK_VIDEO_RUN_BUSINESS_EFFECTIVELY)
    public WebElement linkVideoRunBusinessEffectively;

    @FindBy(css = WEBELEMENT_LINK_PLAY_VIDEO)
    public WebElement linkPlayVideo;

    @FindBy(css = WEBELEMENT_BUTTON_PLAY_VIDEO)
    public WebElement buttonPlayVideo;

    @FindBy(css = WEBELEMENT_HEADER_VIDEO)
    public WebElement headerVideo;

    @FindBy(css = WEBELEMENT_LINK_AGREEMENT)
    public WebElement linkAgreement;

    @FindBy(css = WEBELEMENT_HEADER_AGREEMENT_PAGE)
    public WebElement headerAgreementPage;

    @FindBy(css = WEBELEMENT_BUTTON_ENROLL)
    public WebElement buttonEnroll;

    @FindBy(css = WEBELEMENT_INPUT_ACCOUNT_NUMBER)
    public WebElement inputAccountNumber;

    @FindBy(css = WEBELEMENT_INPUT_SSN)
    public WebElement inputSNN;

    @FindBy(css = WEBELEMENT_BUTTON_CONTINUE_ENROLL)
    public WebElement buttonContinueEnroll;

    @FindBy(css = WEBELEMENT_ERROR_MESSAGE1_ENROLL)
    public WebElement errorMessage1Enroll;

    @FindBy(css = WEBELEMENT_ERROR_MESSAGE2_ENROLL)
    public WebElement errorMessage2Enroll;

    @FindBy(css = WEBELEMENT_LINK_ZELLE)
    public WebElement linkZelle;

    @FindBy(css = WEBELEMENT_BUTTON_PLAY_ZELLE_VIDEO)
    public WebElement buttonPlayZelleVideo;

    @FindBy(css = WEBELEMENT_VIEW_TRANSCRIPT)
    public WebElement viewTranscript;

    @FindBy(css = WEBELEMENT_INPUT_HELP)
    public WebElement inputHelp;

    @FindBy(css = WEBELEMENT_DROPDOWN_VALUE_ROUTING_NUMBER)
    public WebElement dropdownRoutingNumber;

    @FindBy(css = WEBELEMENT_BUTTON_SUBMIT_HELP)
    public WebElement buttonSubmitHelp;

    @FindBy(css = WEBELEMENT_LINK_ROUTING_NUMBERS)
    public WebElement linkRoutingNumbers;

    @FindBy(css = WEBELEMENT_PUTTING_SMALL_BUS_FIRST)
    public WebElement puttingSmallBusFirst;

    @FindBy(css = WEBELEMENT_PUTTING_SMALL_BUS_FIRST_TABS_LINKS)
    public List<WebElement> puttingSmallBusFirstTabsLinks;

    @FindBy(css = WEBELEMENT_BUTTON_CHAT )
    public WebElement buttonChat;

    @FindBy(css = WEBELEMENT_OPEN_ACCOUNT)
    public WebElement openAccount;



    public void doInvalidLogIn() {
        sendKeysToElement(inputOnlineID, "someInvalidID$");
        sendKeysToElement(inputPassword, "some#Password");
        clickElement(buttonSignIn);
    }

    public void doInvalidEnroll() {
        clickElement(buttonEnroll);
        sendKeysToElement(inputAccountNumber, "123456");
        sendKeysToElement(inputSNN, "123456789");
        clickElement(buttonContinueEnroll);
    }

    public boolean verifyInfoBoxBusinessSolutions() throws Exception {
        ArrayList<String> boxInfoBusinessSolutions = new ArrayList<String>();
        boxInfoBusinessSolutions.add(infoBoxBusinessSolutionsHeader.getText());
        boxInfoBusinessSolutions.add(infoBoxBusinessSolutionsTextBody.getText());
        boxInfoBusinessSolutions.add(infoBoxBusinessSolutionsMessageOpenAccount.getText());
        return compareListStringsToExcelDoc(boxInfoBusinessSolutions, System.getProperty("user.dir") + "/src/test/resources/BOATestData.xlsx", "BusinessSolutions");
    }

    public boolean verifyInfoBoxGoPaperless() throws Exception {
        ArrayList<String> boxInfoBoxGoPaperless = new ArrayList<String>();
        boxInfoBoxGoPaperless.add(infoBoxGoPaperlessHeader.getText());
        boxInfoBoxGoPaperless.add(infoBoxGoPaperlessTextBody.getText());
        boxInfoBoxGoPaperless.add(infoBoxGoPaperlessSignIn.getText());
        return compareListStringsToExcelDoc(boxInfoBoxGoPaperless, System.getProperty("user.dir") + "/src/test/resources/BOATestData.xlsx", "GoPaperless");
    }

    public void doScheduleAppointmentNewAccount() {
        clickElement(buttonScheduleAppnmnt);
        implicitWait();
        javaScriptExecutorClickOnElementNoWait(checkboxNewAccount);
        clickElement(buttonNextTopic);
    }

    public void doScheduleAppointment() {
        clickElement(buttonScheduleAppnmnt);
        implicitWait();
        javaScriptExecutorClickOnElementNoWait(checkboxMerchantServ);
        javaScriptExecutorClickOnElementNoWait(checkboxPayrollServ);
        javaScriptExecutorClickOnElementNoWait(checkboxNewAccount);
//        javaScriptExecutorClickOnElement(buttonNextTopic);
    }

    public boolean verifyLinksExploreTopics() {
        return verifyLinks(linksExploreTopics, "href");
    }

    public boolean verifyLinksTitlesExploreTopics() throws IOException {
        return compareListWebElementsToExcelDoc(linksTitlesExploreTopics, System.getProperty("user.dir") + "/src/test/resources/BOATestData.xlsx", "TitlesExploreTopics");
    }

    public void playVideoManageBusinessEffectively() throws InterruptedException {
        clickElement(linkVideoRunBusinessEffectively);
        playEmbeddedVideo(linkPlayVideo);
        playEmbeddedVideo(buttonPlayVideo);
        Thread.sleep(5000);//   added thread to see if the video actually playing

    }

    public void navigateToAgreement() {
        clickElement(linkAgreement);
    }

    public void watchZelleVideo() {
        clickElement(linkZelle);
        playEmbeddedVideo(buttonPlayZelleVideo);
    }

    public void searchHelp(){
        clickElement(inputHelp);
        clickElement(dropdownRoutingNumber);
    }

    public boolean verifyPuttingSmallBusinessFirstLinks(){
        clickElement(puttingSmallBusFirst);
        return verifyLinks(puttingSmallBusFirstTabsLinks, "href");
    }

    public boolean verifyLinksTitlesPuttingSmallBusinessFirst() throws IOException {
        clickElement(puttingSmallBusFirst);
        return verifyLinksTitles(puttingSmallBusFirstTabsLinks,"href", System.getProperty("user.dir") + "/src/test/resources/BOATestData.xlsx", "SmallBusinessFirstTitles");
    }

    public void openAccount(){
        clickElement(openAccount);
    }

}
