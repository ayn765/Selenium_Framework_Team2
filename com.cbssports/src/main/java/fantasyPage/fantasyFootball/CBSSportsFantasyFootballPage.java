package fantasyPage.fantasyFootball;

import common.BaseAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static fantasyPage.fantasyFootball.CBSSportsFantasyFootballPageLocators.*;

public class CBSSportsFantasyFootballPage extends BaseAPI {

    public CBSSportsFantasyFootballPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = WEBELEMENT_INPUT_EMAIL)
    public WebElement inputEmail;

    @FindBy(css = WEBELEMENT_BUTTON_SUBMIT_EMAIL)
    public WebElement buttonSubmitEmail;

    @FindBy(css = WEBELEMENT_MESSAGE_THANKS_FOR_SIGN_UP)
    public WebElement messageThanksForSignUp;

    public WebElement signUpForEmails(){
        sendKeysToElement(inputEmail, "ayn_765@yahoo.com");
        clickElement(buttonSubmitEmail);
        waitUntilWebElementVisible(messageThanksForSignUp);
        return messageThanksForSignUp;
    }


}
