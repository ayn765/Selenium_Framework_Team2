package homepageTest;

import common.BaseAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import static homepageTest.BankOfAmericaHomepageLocators.*;

public class BankOfAmericaHomepage extends BaseAPI {
    @FindBy (css=WEB_ELEMENT_INPUT_ONLINE_ID_BOX)
    WebElement  inputOnlineIdBox;

    @FindBy (css=WEB_ELEMENT_INPUT_PASSCODE_BOX)
    WebElement inputPassCodeBox;

    @FindBy (css=WEB_ELEMENT_BUTTON_SING_IN)
    WebElement buttonSingIn;

    @FindBy (css=WEB_ELEMENT_EXPECTED_TEXT_LOG_IN)
    WebElement TextAfterLogIn;

    @FindBy (css=WEB_ELEMENT_BUTTON_LOCATION_BANK_ATM)
    WebElement buttonFindYourClosestBankATM;
    @FindBy (css=WEB_ELEMENT_INPUT_SEARCH_LOCATION_BOX)
    WebElement inputSearchLocationBox;
    @FindBy (css=WEB_ELEMENT_BUTTON_SEARCH_LOCATION)
    WebElement buttonSearchLocation;

    @FindBy (css=WEB_ELEMENT_BUTTON_FILTER_LOCATION)
    WebElement buttonFilterLocation;

    @FindBy (css=WEB_ELEMENT_EXPECTED_RESULT_LOCATION)
    WebElement expectedResultLocation;

    @FindBy(css = WEB_ELEMENT_BUTTON_ASK_ERICA)
    WebElement buttonAskErica;

    @FindBy(xpath = WEB_ELEMENT_VIDEO_TIMER)

    WebElement videoTimer;
    @FindBy(css = WEB_ELEMENT_EXPECTED_TEXT_VIDEO)
    WebElement expectedTextVideo;

    @FindBy(css = WEB_ELEMENT_BUTTON_CRIDIT_CARD)
    WebElement buttonCriditCard;

    @FindBy(css = WEB_ELEMENT_BUTTON_REWARDS_CARD)
    WebElement buttonRewardCard;

    @FindBy(css = WEB_ELEMENT_BUTTON_APPLY_NOW)
    WebElement buttonApplyNow;

    @FindBy(css = WEB_ELEMENT_EXPECTED_TEXT_CRDIT_CARD)
    WebElement expectedTextCriditCard;

    @FindBy(xpath = WEB_ELEMENT_IMAGE_IN_HOME_PAGE)
   public WebElement imageHomepage;


    @FindBy( css= WEB_ELEMENT_IMAGE_ASK_ERICA)
    public WebElement imageAskErica;

    @FindBy(css = WEB_ELEMENT_LINK_IMAGE_CASH_REWARD)
public WebElement linkImageCashReward;

    @FindBy(css =WEB_ELEMENT_BUTTON_HOME_LOANS )
    public WebElement buttonHomeloan;

    @FindBy(css =WEB_ELEMENT_BUTTON_MORTGAGES)
    public WebElement buttonMortgages;

    @FindBy(xpath =WEB_ELEMENT_INPUT_PURCHASE_PRICE_BOX)
    public WebElement inputPurchasePrice_box;

    @FindBy(xpath =WEB_ELEMENT_INPUT_DOWN_PAYMENT_BOX)
    public WebElement inputDownPaymentBox;

    @FindBy(xpath =WEB_ELEMENT_INPUT_ZIP_CODE_BOX)
    public WebElement inputZipCodeBox;

    @FindBy(css =WEB_ELEMENT_EXPECTED_TEXT_HOME_LOAN)
    public WebElement expectedTextHomeLoan;

    @FindBy(css =WEB_ELEMENT_INPUT_SEARCH_HELP_BOX)
    public WebElement inputSearchHelpBox;

    @FindBy(css =WEB_ELEMENT_BUTTON_SEARCH_HELP)
    public WebElement buttonSearchHelp;

    @FindBy(css =WEB_ELEMENT_BUTTON_VIEW_ALL_RESULT)
    public WebElement buttonViewAllResult;


    @FindBy(css =WEB_ELEMENT_EXPECTED_TEXT_HELP_PAGE)
    public WebElement expectedTextHelpPage;

    @FindBy(css =WEB_ELEMENT_BUTTON_CHECKING)
    public WebElement button_checking;

    @FindBy(css =WEB_ELEMENT_BUTTON_ADVANTAGEBANKING)
    public WebElement buttonAdvantageBanking;

    @FindBy(css =WEB_ELEMENT_EXPECTED_IMAGE_CHECKING)
    public WebElement expectedImageChecking;

    @FindBy(css =WEB_ELEMENT_BUTTON_SAVINGS)
    public WebElement buttonSavings;

    @FindBy(css =WEB_ELEMENT_BUTTON_CHILD_SAVINGS)
    public WebElement buttonChildSavings;

    @FindBy(css =WEB_ELEMENT_EXPECTED_TEXT_SAVING)
    public WebElement expectedTextSavings;

    @FindBy(css =WEB_ELEMENT_BUTTON_AUTO_LOANS)
    public WebElement buttonAutoLoan;

    @FindBy(css =WEB_ELEMENT_BUTTON_LEARN_MORE_AUTO_LOANS)
    public WebElement buttonLearnMoreAutoLoan;

    @FindBy(css =WEB_ELEMENT_EXPECTED_HEADER_AUTO_LOAN)
    public WebElement expectedHeaderAutoLoan;





















    public BankOfAmericaHomepage(){
        PageFactory.initElements(driver, this);

    }

    /**
     * Test case 1-
     *  Navigate to https://www.bankOfAmerica.com/
     *  pass a method to find the number of iframe existing in this page
     * return a number of the iframe on the home  page
     *
     *
     * */
    public int getNumOfIframe() {
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println(size);
        return size;
    }
    /**
     * Test case 2-
     *  Navigate to https://www.bankOfAmerica.com/
     *  pass a method to find the number of iframe existing in this page
     * return a number of the iframe on the home  page
     * if the number of iframe is diffrnet from zero switch to the next iframe
     *
     *
     * */
    public boolean switchtoTheNextIframe() {

        boolean flag = false;
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println(size);
        for (int i = 0; i <= size; i++) {
            driver.switchTo().frame(i);
            driver.switchTo().defaultContent();
            if (size != 0) {
                flag = true;
            } else {
                flag = false;

            } }  return flag;}
    /**
     * Test case 3-
     *  Navigate to https://www.bankOfAmerica.com/
     *  pass  keys to sendKeysIDBox
     *  pass  keys to sendKeysPasswordBox
     * click each time on the log in button
     *
     *
     *
     * */
    public void sendKeysIDBox (String email){
        sendKeysToElement(inputOnlineIdBox, (email));

    }
    public void sendKeysPasswordBox (String passWord){
        sendKeysToElement(inputPassCodeBox, (passWord));
    }
    public void clickSingInButton () {
        clickElement(buttonSingIn);
    }
    public void invalidLogIn (String email,String passWord){
        sendKeysIDBox(email);
        sendKeysPasswordBox(passWord);
        clickSingInButton();}



    /**
     * Test case 4-Data provider
     *  Navigate to https://www.bankOfAmerica.com/
     *  pass  keys to sendKeysIDBox
     *  pass  keys to sendKeysPasswordBox
     *create an excel sheet and we add data for each id an password box
     * click each time on the log in button
     *
     *
     *
     * */
    @DataProvider
    public Object[][] getInvalidLoginTestData() throws Exception {
        String path = System.getProperty("user.dir") + "dataLogIN.xlsx";
        Object[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, "dataLogIN");

        return testData;
    }








    public void navigateToLocation () {
            clickElement(buttonFindYourClosestBankATM);
        }
        public void sendKeysToLocationBar (String searchKeys ){
            sendKeysToElement(inputSearchLocationBox, searchKeys);

        }
        public void searchLocation (String searchKeys){
            navigateToLocation();
            sendKeysToLocationBar(searchKeys);
            clickElement(buttonSearchLocation);

        }
        public void navigateToVideo () {
            selectElement(buttonAskErica);
            clickElement(buttonAskErica);

        }
        public void navigateToCridtCardPage () {
            clickElement(buttonCriditCard);
            clickElement(buttonRewardCard);
            clickElement(buttonApplyNow);

        }
        public void clickOnImageAskErica () {
            clickElement(imageAskErica);

        }
        public void navigateToHomeLoans () {
            clickElement(buttonHomeloan);

        }
        public void navigateToMortgagePage () {
            clickElement(buttonMortgages);
        }
        public void sendKeysPurchasePriceBox (String searchKeys){
            sendKeysToElement(inputPurchasePrice_box, (searchKeys));
        }


        public void sendKeysDownPaymentBox (String searchKeys){
            sendKeysToElement(inputDownPaymentBox, (searchKeys));
        }


        public void sendKeysZipCodeBox (String searchKeys){
            sendKeysToElement(inputZipCodeBox, (searchKeys));
        }

        public void sendKeysTohelpBox (String searchKeys){
            sendKeysToElement(inputSearchHelpBox, (searchKeys));

        }
        public void doSearchHelpBox (String searchKeys){
            sendKeysTohelpBox(searchKeys);
            clickElement(buttonSearchHelp);

        }
        public void extandSearch (String searchKeys){

            doSearchHelpBox(searchKeys);
            clickElement(buttonViewAllResult);

        }
        public void navigateToCheCkingPage () {
            clickElement(button_checking);
            clickElement(buttonAdvantageBanking);
        }
        public void navigateToSavingsPage () {
            clickElement(buttonSavings);
            clickElement(buttonChildSavings);

        }
        public void navigateToAutoPage () {
            clickElement(buttonAutoLoan);
            clickElement(buttonLearnMoreAutoLoan);


        }

    }







