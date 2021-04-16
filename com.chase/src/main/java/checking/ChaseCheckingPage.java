package checking;

import common.BaseAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

//        @FindBy(css = )
//    public WebElement

    //    @FindBy(css = )
//    public WebElement

    //    @FindBy(css = )
//    public WebElement

    //    @FindBy(css = )
//    public WebElement

    //    @FindBy(css = )
//    public WebElement


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
        String actualText = element.getText();
        waitUntilWebElementVisible(element);
        return actualText;
    }

    public void findYourBranch(){
        clickElement(buttonFindYourBranch);
        inputZipcode.sendKeys("20001");
        clickElement(buttonSearchZipcode);
    }
}