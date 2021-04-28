package ebayFashionPage;

import common.BaseAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import sun.jvm.hotspot.utilities.Assert;

import java.util.List;

import static ebayFashionPage.EbayFashionPageLocators.*;

public class EbayFashionPage extends BaseAPI {


    @FindBy (css= WEB_ELEMENT_FASHION_TAB)
            public WebElement fashionTab;

    @FindBy (xpath = WEB_ELEMENT_BEAUTY_BUTTON)
            public WebElement beautyButton;

    @FindBy (xpath = WEB_ELEMENT_TEXT_FASHION_DISPALYED)
              public WebElement textFashion;

    @FindBy (xpath= WEB_ELEMENT_BEAUTY_DROP_DOWN)
             public WebElement beautyDropDownDisplayed;

    @FindBy (xpath= WEB_ELEMENT_ALL_CATEGORIES_DROP_DOWN)
            public WebElement allCategoriesDropDown;

    @FindBy (xpath= WEB_ELEMENT_OPTION_ANTIQUES)
            public  WebElement optionAntiques;

    @FindBy (xpath= WEB_ELEMENT_SEARCH_BAR)
             WebElement searchBar;

    @FindBy (xpath= WEB_ELEMENT_WATCHES_TEXT)
            public WebElement watchesText;

    @FindBy (xpath= WEB_ELEMENT_CLICK_SEARCH_BUTTON)
             WebElement clickSearchButton;

    @FindBy (xpath= WEB_ELEMENT_CLICK_SHOPPING_CART)
            WebElement clickShoppingCart;

    @FindBy (xpath= WEB_ELEMENT_CLICK_SIGN_IN_BUTTON)
            WebElement clickSignInButton;

    @FindBy(xpath = WEB_ELEMENT_SIGN_IN_TEXT_EXPECTED)
          public WebElement signInTextExpected;

    @FindBy(xpath = WEB_ELEMENT_HELP_AND_CONTACT_TAB)
             WebElement helpAndContactTab;

    @FindBy(xpath =WEB_ELEMENT_CUSTOMER_SERVICE)
            public  WebElement customerService;

    @FindBy (xpath= WEB_ELEMENTS_DROP_DOWN_ALL_OPTIONS)
             public List<WebElement > dropDownAllOptions;

    @FindBy (xpath=WEB_ELEMENT_REGISTER_BUTTON)
    public WebElement registerButton;

    @FindBy (xpath= WEB_ELEMENT_FIRST_NAME)
            WebElement enterFirstName;

    @FindBy (xpath= WEB_ELEMENT_LAST_NAME)
            WebElement enterLastName;

    @FindBy (xpath= WEB_ELEMENT_EMAIL)
             WebElement enterEmail;

    @FindBy (xpath= WEB_ELEMENT_PASSWORD)
            WebElement enterPassword;

    @FindBy (xpath= WEB_ELEMENT_NOT_ROBOT_CHECK_BOX)
              WebElement notRobotCheckBox;

    @FindBy (xpath= WEB_ELEMENT_HEADER_TEXT)
              public WebElement headerTextDisplayed;

    @FindBy (xpath=WEB_ELEMENT_MEN_CLOTHING)
            WebElement menClothing;

    @FindBy (xpath= WEB_ELEMENT_Shop_Men_Clothing)
             WebElement shopMenClothing;

    @FindBy (xpath=WEB_ELEMENT_SELECT_COAT_AND_JACKETS)
    WebElement selectCoatsAndJackets;

    @FindBy (xpath= WEB_ELEMENT_Header_MEN_COAT_JACKETS)
    public WebElement headerMenCoatAndJackets;

    @FindBy (xpath= WEB_ELEMENT_TOP_BRANDS)
    WebElement topBrandsTab;

    @FindBy (xpath= WEB_ELEMENT_ADIDAS)
    WebElement adidasOption;

    @FindBy (xpath= WEB_ELEMENT_ADIDAS_PAGE_TITLE)
    public WebElement adidasPageTitle;

    @FindBy (xpath=WEB_ELEMENT_SELL_TAB)
    WebElement sellTab;

    @FindBy (xpath= WEB_ELEMENT_LIST_AN_ITEM_TAB)
    WebElement listAnItemInputTab;

    @FindBy (xpath=WEB_ELEMENT_INPUT_BRAND)
    WebElement inputBrandBox;

    @FindBy (xpath=WEB_ELEMENT_GO_BUTTON)
    WebElement goButton;

    @FindBy (xpath=WEB_ELEMENT_ATHLETIC_SHOES_HEADER)
    public WebElement athleticShoesHeader;





            public EbayFashionPage(){
        PageFactory.initElements(driver, this);
    }

    public void selectFashionTab(){

         clickElement(fashionTab);

            }
    public void verifyBeautyTab(){
         clickElement(fashionTab);
         clickElement(beautyButton);
    }

    public void verifyAllCategoriesDropDown(){
         clickElement(fashionTab);
         selectElement(allCategoriesDropDown);
    }
    public void selectOptionAntiqueUsingValue(String value){
        clickElement(fashionTab);
       selectOptionByValue( allCategoriesDropDown, value);

     }
    public void selectBabyByFromDropdownVisibleText(String visibleText) {
        clickElement(fashionTab);
        selectOptionByVisibleText(allCategoriesDropDown, visibleText);
    }
    public void selectArtFromDropdownUsingIndex(int index) {
        clickElement(fashionTab);
        selectOptionByIndex(allCategoriesDropDown,index);

    }


    public void verifySearchBar(String searchKeys) {
        clickElement(fashionTab);
        sendKeysToElement( searchBar, searchKeys);
        clickElement(clickSearchButton);


    }

    public void verifyShoppingCartButton(){
        clickElement(fashionTab);
         clickElement(clickShoppingCart);
    }

    public void verifySignInButton(){
        clickElement(fashionTab);
        clickElement(clickShoppingCart);
        clickElement(clickSignInButton);

    }
    public void verifyHelpAndContactTab(){
        clickElement(fashionTab);
        clickElement(helpAndContactTab);

    }
    public void navigateToRegisterPage(){
        clickElement(fashionTab);
        clickElement(registerButton);

    }
    public void verifyCreatingAccountPage(){
        clickElement(fashionTab);
        clickElement(registerButton);
//        clickElement(notRobotCheckBox);
//        sendKeysToElement(enterFirstName, "Amel");
//        sendKeysToElement(enterLastName, "Baileche");
//        sendKeysToElement(enterEmail, "amelbailech@gmail.com");
//        sendKeysToElement(enterPassword,"12345846");


    }
   public void verifyMenClothingTab(){
      clickElement(fashionTab);
      clickElement(menClothing);
      hoverOverElement(shopMenClothing);
      selectElement(selectCoatsAndJackets);
}
    public void adidasPage(){
    clickElement(fashionTab);
    topBrandsTab.click();
    clickElement(adidasOption);


            }

   public void verifySellTab(){
       clickElement(fashionTab);
       sellTab.click();
       clickElement(listAnItemInputTab);
       sendKeysToElement(inputBrandBox,"Nike");
    selectElement(goButton);


   }

}













//    <?xml version="1.0" encoding="UTF-8"?>
//<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">