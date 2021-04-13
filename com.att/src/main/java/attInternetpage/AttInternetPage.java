package attInternetpage;

import common.BaseAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import utilities.DataReader;


import java.util.List;

import static attInternetpage.AttInternetLocators.*;

public class AttInternetPage extends BaseAPI {


    public AttInternetPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = WebElementAttInternet)
    public WebElement attInternet;
    @FindBy(xpath = WebElementChat)
    WebElement chat;
    @FindBy(css = WebElementChatInput)
    WebElement chatInput;
    @FindBy(css = WebElementChatSend)
    WebElement chatSend;
    @FindBy(xpath = WebElementRewardCard)
    WebElement rewardCard;
    @FindBy(xpath = WebElementInternetTab)
    WebElement internetTab;
    @FindBy(css = WebElementPlanAndPrices)
    WebElement planAndPrices;
    @FindBy(xpath = WebElementWireless)
    WebElement wireless;
    @FindBy(css= WebElementEquipment)
    WebElement equipment;
    @FindBy(xpath = WebElementShopInternet)
    WebElement shopInternet;
    @FindBy(xpath=WebElementFeedbackButton)
    public WebElement feedbackButton;
    @FindBy(xpath=WebElementAccountDropDown)
    WebElement accountDropDown;
    @FindBy(xpath=WebElementFavorite)
    WebElement favorite;
    @FindBy(css=WebElementStartShopping)
    WebElement startShopping;
    @FindBy(xpath=WebElementProduct)
    WebElement product;
    @FindBy(xpath=WebElementProductReview)
    WebElement productReview;
    @FindBy(css= WebElementWyAttInternet)
    WebElement whyAttInternet;
    @FindBy(xpath=WebElementWyAttInternetText)
    WebElement wyAttInternetText;
    @FindBy(xpath=WebElementGoodFeedback)
    WebElement goodFeedBack;
    @FindBy(xpath=WebElementSelectTopicFeedback)
    WebElement selectTopicFeedBack;
    @FindBy(xpath=WebElementSubmitFeedback)
    WebElement submitFeedback;
    @FindBy(xpath=WebElementAttFacebook)
    WebElement attFacebook;
    @FindBy(xpath=WebElementLink)
    WebElement link;
    @FindBy(xpath= WebElementTextHeader)
    public WebElement textHeader;
    @FindBy(xpath=WebElementAccount)
    WebElement account;
    @FindBy(xpath=WebElementSignIn)
    WebElement signIn;
    @FindBy(css=WebElementUserId)
    WebElement userId;
    @FindBy(css=WebElementPassword)
    WebElement password;
    @FindBy(css=WebElementSubmit)
    WebElement submit;
    @FindBy(css=WebElementErrorText)
    public WebElement errorText;





    /**
     * Test case:1
     * Navigate to ATT home Page
     * Click on Att Internet  Button to open page
     * Validate the page link.
     */
    public void navigateToInternet() {
        clickOnTheElement(attInternet);
    }

    /**
     * Test case:2
     * Navigate to ATT home Page
     * Click on Att Internet  Button to open page
     * click on chat Icon
     * send chat
     */

    public void sendChat() {
        navigateToInternet();
        waitForVisibilityOfElement(chat);
        clickOnTheElement(chat);
        switchToNewTab(1);
        chatInput.sendKeys("I have problem with my Wifi");
        clickOnTheElement(chatSend);
    }

    /**
     * Test case:3
     * Navigate to ATT home Page
     * Click on Att Internet  Button to open page
     * click on Deals Link
     * Validate the title
     */

    public void infoRewardDeal() {
        navigateToInternet();
        clickOnTheElement(rewardCard);
    }

    /**
     * Test case:4
     * Navigate to ATT home Page
     * Click on Att Internet  Button to open page
     * click on Plan and Prices
     * Scroll down the page until the element "Wireless" is found
     */
    public void scrollDownUntilElementIsVisible() {
        navigateToInternet();
        clickOnTheElement(internetTab);
        clickOnTheElement(planAndPrices);
        scrollToElementJScript(wireless);
    }

    /**
     * Test case:5
     * Navigate to ATT home Page
     * Click on Att Internet  Button to open page
     * click on Equipment
     * Scroll Down to ShopInternet button using JavaScript and click
     * then go back to the main Page
     */
    public void shopInternetAndGoBackMainPage() {
        navigateToInternet();
        try {
            clickOnTheElement(internetTab);
            clickOnTheElement(equipment);
            scrollToElementJScript(shopInternet);
        } catch (Exception e) {
            System.out.println("unable to click on element");
        }
        driver.navigate().back();
        driver.navigate().refresh();
    }
/**
 * Test case:6
 * Navigate to ATT home Page
 * mouse hover Feedback Button
 * get the Button Background color
 * validate the color
 */
public void backgroundColor(){
    navigateToInternet();
    Actions action = new Actions(driver);
    action.moveToElement(feedbackButton).build().perform();
    feedbackButton.getCssValue("background-color");
}
/**
 * Test case:7
 * Navigate to ATT home Page
 * mouse hover Account
 * calculate the number of elements inside of the drop Down
 * validate the result
 */

public void navigateToAccountDropDown(){
    navigateToInternet();
    mouseHoverElement(accountDropDown);
}
 public int calculateItemsInsideOfDrop(){
     WebElement ul_element = driver.findElement(By.xpath("//*[@id=\"profile-unauth\"]/div[2]/ul"));
     List<WebElement> li_All = ul_element.findElements(By.className("cta wcgn-account-dropdown"));
     int AccountNUMlinks = li_All.size();
     for (int i = 0; i < li_All.size(); i++) {
         System.out.println(li_All.get(i).getText());
     }
     return AccountNUMlinks;
 }
    /**
     * Test case:8
     * Navigate to ATT home Page
     * click on Favorite Icon
     * click on shop now
     * scroll down the page to see product
     * click on the product
     * click on its reviews
     * go back to the precedent page to continue shopping
     */
 public void shoppingProduct() {
     navigateToInternet();
     clickOnTheElement(favorite);
     clickOnTheElement(startShopping);
     try {

         scrollToElementJScript(product);
     } catch (Exception E) {
         System.out.println("no such element");
     }
      clickOnTheElement(product);
      clickOnTheElement(productReview);
     driver.navigate().back();
     driver.navigate().refresh();
 }
    /**
     * Test case:9
     * Navigate to ATT home Page
     * scroll down till Why Att Internet
     * click on the link
     * Validate the text
     */
 public void whyATTInfo(){
     navigateToInternet();
     scrollToElementJScript(whyAttInternet);
     clickOnTheElement(whyAttInternet);
 }
 public boolean isWhyATTInternetTextDisplayed(){
    wyAttInternetText.getText();
    return true;
 }

/**
 * Test case:10
 * Navigate to ATT home Page
 * navigate to Internet
 * click on Feedback Button
 * switch to the tab
 * Click On "Good" icon Feedback
 * click on the Topic Drop down AND Click on Customer service Topic
 * click on Submit button
 */
public void giveFeedback(){
    navigateToInternet();
    waitForVisibilityOfElement(feedbackButton);
    Actions action = new Actions(driver);
    action.moveToElement(feedbackButton).click().build().perform();
    switchToNewTab(1);
    clickOnTheElement(goodFeedBack);
    Select select = new Select(selectTopicFeedBack);
    select.selectByValue("Customer Service");
    clickOnTheElement(submitFeedback);
}
    /**
     * Test case:11
     * Navigate to ATT home Page
     * Scroll down to the butTom of page
     * click on Facebook icon
    */
public void checkAttOnFacebook(){
   navigateToInternet();
  scrollTillBottomPageJScript();
  clickOnTheElement(attFacebook);
}
/**
 * Test case:12
 * Navigate to ATT home Page
 * navigate to internet
 * click on the link
 * validate the new link
 */
public void planLink(){
    navigateToInternet();
  mouseHoverElement(link);
}
    /**
     * Test case:13
     * Navigate to ATT home Page
     * navigate to internet
     * Scroll down to the header"So many reasons to love AT&T Internet"
     * validating the text
     */
public void moveToTextHeader(){
    navigateToInternet();
   scrollToElementJScript(textHeader);
}
    /**
     * Test case:14
     * Navigate to ATT home Page
     * navigate to internet
     * Scroll down to the header"So many reasons to love AT&T Internet"
     * validating the text
     */
public void signIn(String email, String passwordUser){
    clickOnTheElement(account);
    clickOnTheElement(signIn);
    sendKeysToElement(userId,email);
    sendKeysToElement(password,passwordUser);
    clickOnTheElement(submit);
}
    @DataProvider
    public Object[][] getInvalidSignIn() throws Exception {
    String path = System.getProperty("user.dir") + "/src/test/resources/Book1.xlsx";
    Object[][] testSignIn = dataReader.fileReaderArrayStringArraysXSSF(path, "testInvalidSignIn");
    return testSignIn;
}
}


