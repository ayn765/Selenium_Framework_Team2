package helpCenterPage;

import common.BaseAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static helpCenterPage.AirbnbHelpCenterPageLocators.*;

public class AirbnbHelpCenterPage extends BaseAPI {
    @FindBy(xpath = WEB_ELEMENT_HELP_CENTER_BUTTON)
    WebElement helpCenterButton;

    @FindBy(css = WEB_ELEMENT_INPUT_SEARCH_HELP_ARTICLES)
    WebElement inputSearchHelpArticles;

    @FindBy(css = WEB_ELEMENT_BUTTON_SEARCH_SEARCH_BAR)
    public WebElement buttonSearchInSearchBar;

    @FindBy(css = WEB_ELEMENT_BUTTON_LOG_IN)
    WebElement buttonLogIn;

    @FindBy(css = WEB_ELEMENT_BUTTON_SING_UP)
    WebElement buttonSingUp;

    @FindBy(css = WEB_ELEMENT_INPUT_PHONENUMBER_BOX)
    WebElement inputPhoneNumberBox;

    @FindBy(xpath=WEB_ELEMENT_EXPECTED_TEXT_RESULT)
    public WebElement expectedTextResult;

    @FindBy(css =WEB_ELEMENT_EXPECTED_TEXT_SEARCH)
    public WebElement expectedTextSearch;

    @FindBy (css=WEB_ELEMENT_EXPECTED_TEXT_SEARCH_PhoneNumberBox)
    public WebElement expectedTextSearchPhoneNumeberBox;

    @FindBy(css=WEB_ELEMENT_BUTTON_CONTINUE)
    public WebElement buttonContinue;

    @FindBy(css=WEB_ELEMENT_DROP_DOWN_COUNTRY)
    public WebElement dropDownCountry;

    //@FindBy(css=WEB_ELEMENTS_EXPECTED_OPTION_DROP_DOWN_COUNTRY)
    //public WebElement expectedOptionDropDownCountry;
public String getWEB_ELEMENTS_EXPECTED_OPTION_DROP_DOWN_COUNTRY(){
    return WEB_ELEMENTS_EXPECTED_OPTION_DROP_DOWN_COUNTRY;
}


    public AirbnbHelpCenterPage() {
        {
            PageFactory.initElements(driver, this);
        }

    }
    public void navigateToHelpCenter(){
        selectElement(helpCenterButton);
        helpCenterButton.click();

    }

    public void sendKeysToSearchBar(String searchKeys) {
        navigateToHelpCenter();
        WebElement m3=waitForElementToBeClickable(inputSearchHelpArticles);
       sendKeysToElement(m3,searchKeys);

    }
    public void doSearch(String searchKeys){
        sendKeysToSearchBar(searchKeys);
        waitForElementToBeClickable(buttonSearchInSearchBar);;
    }
    public void navigateToLogInPge(){
        navigateToHelpCenter();
        selectElement(buttonLogIn);
        clickElement(buttonLogIn);
    }
    public void sendkeysToPhoneNumberBox(String searchKeys){
        navigateToLogInPge();
        sendKeysToElement(inputPhoneNumberBox,searchKeys);
        clickElement(buttonContinue);


        }
        public void selectCountryDropDownIndex(int index){
        navigateToLogInPge();
        Select select=new Select(dropDownCountry);
        select.selectByIndex(index);


        }
    public void selectCountryDropDownValue(String value){
        navigateToLogInPge();
        Select select=new Select(dropDownCountry);
        select.selectByValue(value);
    }
    public void selectCountryDropDownText(String text){
        navigateToLogInPge();
        Select select=new Select(dropDownCountry);
        select.selectByVisibleText(text);
    }
public void selectCountryDropDownOption(){
        navigateToLogInPge();


}
    }




