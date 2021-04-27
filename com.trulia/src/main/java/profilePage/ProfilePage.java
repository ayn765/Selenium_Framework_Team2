package profilePage;

import common.BaseAPI;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static profilePage.ProfilePageLocators.*;

import static homePageTrulia.HomePageLocatorsTrulia.WEB_ELEMENT_TEXT_IN_THE_PARENT_PAGE;

public class ProfilePage extends BaseAPI {
    @FindBy(css = WEB_ELEMENT_INPUT_FULL_NAME)
    public WebElement inputFullName;

    @FindBy(css = WEB_ELEMENT_INPUT_pHONE_NUMBER)
    public WebElement inputPhone;

    @FindBy(css = WEB_ELEMENT__SELECT_DROP_DOWN_uSER_TYPE)
    public WebElement selectDropDownUserType;

    @FindBy(css = WEB_ELEMENT_BUTTON_SAVE_PROFILE)
    public WebElement buttonSaveProfile;

    @FindBy(css = WEB_ELEMENT_EXPECTED_TEXT_INVALID_lOG_IN)
    public WebElement expectedTextInvalidLogIn;


    public ProfilePage() {
        PageFactory.initElements(driver, this);

    }
    /**
     * Test case:1
     * in profile page
     * clear the input full name box and send keys;
     * send keys to input Phone box
     * select from the user type from the drop Down;
     * click on the button saved the profile
     */
    public void clearInputFullNameAndSendKeysToElement( String keysToSend) {
        WebElement element=inputFullName;
        try {
            waitUntilWebElementVisible(element);
            element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
            element.sendKeys("keysToSend");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("UNABLE TO SEND KEYS TO WEB ELEMENT");
        }

    }
    public void sendKeystoPhoneBox(String phone){
        sendKeysToElement(inputPhone, phone);
    }
    public void selectFromDropDownUserType(int index){
        selectOptionByIndex(selectDropDownUserType, index);

    }

    public void savedProfile( String keysToSend,String phoneNumber,int index){
        clearInputFullNameAndSendKeysToElement(keysToSend);
        sendKeystoPhoneBox(phoneNumber);
        selectFromDropDownUserType( index);
        clickElement(buttonSaveProfile);


    }
}

