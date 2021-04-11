package signIn;

import common.BaseAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static signIn.ExpediaSignInPageLocators.*;

public class ExpediaSignInPage extends BaseAPI {

    public ExpediaSignInPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = WEBELEMENT_HEADER_SIGN_IN)
    public WebElement headerSignIn;
}
