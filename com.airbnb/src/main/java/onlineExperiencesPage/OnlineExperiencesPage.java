package onlineExperiencesPage;

import common.BaseAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.util.List;

import static onlineExperiencesPage.OnlineExperiencesLocators.*;

public class OnlineExperiencesPage extends BaseAPI {
    @FindBy (xpath = webElementExperiencesPageButtonLink)
    WebElement experiencesPagePageButton;

    @FindBy ( xpath = webElementAirbnbHomepageButton )
    WebElement airbnbHomepageButton;
    @FindBy(xpath = webElementAirbnbHomePage)
    WebElement airbnbHomepage;

    @FindBy (xpath = webElementLoginButton)
    WebElement loginButton;
    @FindBy (xpath = webElementSignUpButton)
    WebElement signUpButton;
    @FindBy (xpath = webElementSelectCountryRegion)
    WebElement selectCountryRegion;
    @FindBy (xpath= webElementTypeInPhoneNum)
    WebElement typeInPhoneNum;
    @FindBy (xpath = webElementConfirmYourNumber)
    WebElement  confirmYourPhoneNum;
    @FindBy (xpath= webElementEnterCodeSent)
     WebElement enterCodeSentIsDisplayed;
    @FindBy(xpath = webElementButtonFotListOfLabelsDisplayed)
    WebElement ButtonForListOfLabelsDisplayed;
    @FindBy(xpath= webElementListOfLabelsDisplayed )
   public  List< WebElement>  expectedListOfLabelsDisplayed;
    @FindBy(xpath= webElementImageOfLabels)
    public WebElement imageOfLabels;



    @FindBy(css= webElementFilterTab)
    WebElement filterTab;
    @FindBy(xpath = webElementFilterWindow)
    WebElement filterWindow;
    @FindBy(css = webElementMinPriceBox)
    WebElement minPriceBox;
    @FindBy(xpath = webElementShowResultsButton)
    public WebElement showResultButton;
    @FindBy(xpath=webElementShowAllOnlineExperiences)
    public WebElement showAllOnlineExperiencesRes;
    @FindBy(xpath= webElementDateDropDown)
    public WebElement dateTab;
    @FindBy(xpath= webElementDateChosenTwentySeven)
    public WebElement dateAprilTwentySeven;
    @FindBy (css = webElementGroupSizeButtonDrop)
    WebElement groupSizeDropDown;
    @FindBy(xpath= webElementDateDropDownImage)
    public WebElement DropDownImage;
    @FindBy (xpath = webElementSelectNumOfGuests)
    public  WebElement numberOfGuestsSelected;
    @FindBy (xpath = webElementSangriaAndSecretsPage)
        WebElement sangriaAndSecretsPage;
    @FindBy (css = webElementCheckImageSangria)
    public WebElement checkSangriaImage;
    @FindBy (css = webElementGreatForGroupsTab)
    WebElement greatForGroupsTab;

    public OnlineExperiencesPage(){
        PageFactory.initElements(driver, this);
    }


    public void clickExperiencesPageButton(){
        experiencesPagePageButton.click();
    }

    public void verifyNavigationToAirbnbHomepage(){
       clickElement(experiencesPagePageButton);

    }
    public void verifyLoginButton() {
        loginButton.click();
        signUpButton.click();
        selectCountryRegion.click();
        typeInPhoneNum.sendKeys("2152555407");
        confirmYourPhoneNum.click();
        boolean isExpectedLocationDisplayed = enterCodeSentIsDisplayed.isDisplayed();


    }
    public String verifyTheNumberOfLabelsDisplayed(){
//        String[] expectedLabelsDisplayed={"Filters","Dates","Group size","Great for Groups", "Family Friendly","Fitness","History & culture", "Magic Music", "Social impact","Wellness", "Olympians & paralympians",
//                "Entertainment", "Dance", "cooking","Arts & Writing", "Animals"};
        return webElementListOfLabelsDisplayed;

        }

        public void verifySwitchingToFilterTab(){
            filterTab.click();
            switchToNewTab(1);
            clickElement(minPriceBox);
            sendKeysToElement(minPriceBox, "50");
            clickElement(showResultButton);



        }
      public void  verifySelectDateTab() {
       clickElement(dateTab);
       selectElement(dateAprilTwentySeven);

       //April locator
       //hoverOverElement(// april );





      }
      public void verifySelectGroupSize(){
        selectElement(groupSizeDropDown);
        selectElement(numberOfGuestsSelected);


      }
      public void verifySwitchToSangriaPage(){
        waitForElementToBeClickable(greatForGroupsTab);
        clickElement(greatForGroupsTab);
        clickElement(sangriaAndSecretsPage);
        switchToNewWindow();

      }





    }











