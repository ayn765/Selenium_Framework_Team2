package creditCards;

import common.BaseAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static creditCards.BankOfAmericaCreditCardsLocators.*;

public class BankOfAmericaCreditCards extends BaseAPI {

    BankOfAmericaCreditCards() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = WEB_ELEMENT_LIST_CREDIT_CARDS)
    public WebElement List_Credit_Cards_Button;

    @FindBy(css = WEB_ELEMENT_FEATURED_CREDIT_CARDS)
    public WebElement List_Credit_Cards_Featured_Credit_Cards;

    @FindBy(css = WEB_ELEMENT_FEATURED_LINK)
    public WebElement Featured_Link;

    @FindBy(xpath = WEB_ELEMENT_EXPECTED_FEATURED)
    public WebElement Expected_Feature;

    @FindBy(css = WEB_ELEMENT_CASH_REWARDS_CARDS)
    public WebElement List_Credit_Cards_Cash_Rewards_Cards;

    @FindBy(id = WEB_ELEMENT_EXPECTED_CASH_TEXT)
    public WebElement Expected_Cash;

    @FindBy(css = WEB_ELEMENT_TRAVEL_AND_AIRLINES_REWARDS_CARDS)
    public WebElement List_Credit_Cards_Travel_And_Airline_Rewards_Cards;

    @FindBy(id = WEB_ELEMENT_EXPECTED_TRAVEL)
    public WebElement Expected_Travel;

    @FindBy(css = WEB_ELEMENT_LOWER_INTEREST_RATE_CARDS)
    public WebElement List_Credit_Cards_Lower_Interest_Rate_Cards;

    @FindBy(css = WEB_ELEMENT_CARDS_TO_BUILD_OR_REBUILD_CREDIT)
    public WebElement List_Credit_Cards_Cards_To_Build_Or_Rebuild_Credit;

    @FindBy(name = WEB_ELEMENT_SMALL_BUSINESS_CARDS)
    public WebElement List_Credit_Cards_Small_Business_Cards;

    @FindBy(name = WEB_ELEMENT_SHOP_ALL_CREDIT_CARDS)
    public WebElement List_Credit_Cards_Shop_All_Credit_Cards;

    @FindBy(name = WEB_ELEMENT_CHECK_FOR_CUSTOMIZED_OFFERS)
    public WebElement List_Credit_Cards_Check_For_Customized_Offers;

    @FindBy(name = WEB_ELEMENT_MANAGE_CREDIT_CARD_ACCOUNT)
    public WebElement List_Credit_Cards_Manage_Your_Credit_Card_Account;


    public void clickFeatured_Credit_Cards() {
        clickElement(List_Credit_Cards_Featured_Credit_Cards);
        clickElement(Featured_Link);

    }

    public void clickCash_Rewards_Cards() {
        clickElement(Featured_Link);
    }

    public void hoverTravel_And_Airline_Rewards_Cards() {
        hoverOverElement(List_Credit_Cards_Travel_And_Airline_Rewards_Cards);
        clickElement(List_Credit_Cards_Travel_And_Airline_Rewards_Cards);
    }

    public void clickLower_Interest_Rate_Cards() {
        clickElement(List_Credit_Cards_Lower_Interest_Rate_Cards);
    }


}
