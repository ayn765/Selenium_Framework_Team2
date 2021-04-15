package homepageTest;

import common.BaseAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static homepageTest.AirbnbCovid19Locators.*;


public class AirbnbCovid19 extends BaseAPI{
    @FindBy (xpath= WEB_ELEMENT_GET_THE_LATEST_ON_OUR_COVID19_RESPONSE)
    WebElement GET_THE_LATEST_ON_OUR_COVID19_RESPONSE;
     @FindBy (xpath= WEB_ELEMENT_TOPICS)
    WebElement TOPICS;

     @FindBy(xpath = WEB_ELEMENT_ABOUT_HOSTING)
     WebElement ABOUT_HOSTING;
     @FindBy (xpath = WEB_ELEMENT_YOUR_ONLINE_LISTING)
     WebElement ONLINE_LISTING;


     @FindBy(xpath= WEB_ELEMENT_HELP)
     WebElement HELP;

     @FindBy(xpath = WEB_ELEMENT_SIGN_UP)
     WebElement SIGN_UP;

     @FindBy(xpath =WEB_ELEMENT_PHONE_NUMBER )
     WebElement PHONE_NUMBER ;

     @FindBy(xpath = WEB_ELEMENT_CONTINUE)
     WebElement CONTINUE;


  @FindBy(xpath = WEB_ELEMENT_GUIDES)
  WebElement GUIDES;


 @FindBy(xpath =  WEB_ELEMENT_SETTING_UP_A_SUCCESSFUL_LISTING )
  WebElement SETTING_UP_A_SUCCESSFUL_LISTING;


    public void checkTopics() throws InterruptedException {
        GET_THE_LATEST_ON_OUR_COVID19_RESPONSE.click();
        Thread.sleep(4000);
        handleNewTab(driver);
        TOPICS.click();
        Thread.sleep(4000);
        ABOUT_HOSTING.click();
    }

     public void checkTitle(){

        GET_THE_LATEST_ON_OUR_COVID19_RESPONSE.click();
        handleNewTab(driver);
        TOPICS.click();
        ONLINE_LISTING.click();

}
   public void signUp() throws InterruptedException {
       GET_THE_LATEST_ON_OUR_COVID19_RESPONSE.click();
       handleNewTab(driver);
       Thread.sleep(4000);
       HELP.click();
       handleNewTab(driver);
       Thread.sleep(4000);
       SIGN_UP.click();
       Thread.sleep(4000);
       PHONE_NUMBER.sendKeys("2344444444");
       CONTINUE.click();

   }
public void scrollToSettingUpSuccessfulListing () throws InterruptedException {
    GET_THE_LATEST_ON_OUR_COVID19_RESPONSE.click();
    handleNewTab(driver);
    Thread.sleep(4000);
    GUIDES.click();
    SETTING_UP_A_SUCCESSFUL_LISTING.click();


}













//    @FindBy (css = webElementWhereAreYouGoingInput)
//    WebElement whereAreYouGoingInput;
//
//    @FindBy (xpath = webElementCheckInAddDates)
//    WebElement checkInAddDates;
//
//    @FindBy (css = webElementIAmFlexible)
//    WebElement iAmFlexible;
//
//    @FindBy (xpath = webElementCheckOutAddDates)
//    WebElement checkOutAddDates;
//
//    @FindBy (xpath = webElementAddGuests)
//    WebElement addGuests;
//
//    @FindBy (css = webElementIncreaseAdultGuest)
//    WebElement increaseAdultGuest;
//
//    @FindBy (css = webElementSearchButton)
//    WebElement searchButton;
//
//    public AirbnbCovid19()  {
//        PageFactory.initElements(driver, this);
//    }
//
//    public void sendKeysToDestination(String keysToSend) {
//        whereAreYouGoingInput.sendKeys(keysToSend);
//    }
//
//
//    public void createFlexibleSearch() {
//        checkInAddDates.click();
//        iAmFlexible.click();
//        addGuests.click();
//        increaseAdultGuest.click();
//        searchButton.click();
//    }


}
