package fantasyPage.fantasyPropsGamePage;

import common.BaseAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static fantasyPage.fantasyPropsGamePage.CBSSportsFantasyPropsGamePageLocators.*;


public class CBSSportsFantasyPropsGamePage extends BaseAPI {

    public CBSSportsFantasyPropsGamePage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = WEBELEMENT_BUTTON_ENTER)
    public WebElement buttonEnter;

    @FindBy(css = WEBELEMENT_INPUT_USER_ID)
    public WebElement inputUserID;

    @FindBy(css = WEBELEMENT_INPUT_PASSWORD)
    public WebElement inputPassword;

    @FindBy(css = WEBELEMENT_BUTTON_SUBMIT)
    public WebElement buttonSubmit;

    @FindBy(css = WEBELEMENT_ERROR_MESSAGE)
    public WebElement errorMessage;


    public WebElement invalidLogIn(){
        clickElement(buttonEnter);
        sendKeysToElement(inputUserID, "qwerty123");
        sendKeysToElement(inputPassword, "123456");
        clickElement(buttonSubmit);
        return errorMessage;
    }

}
