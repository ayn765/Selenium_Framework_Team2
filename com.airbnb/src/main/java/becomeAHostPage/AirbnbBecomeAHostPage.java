package becomeAHostPage;

import common.BaseAPI;
import static becomeAHostPage.AirbnbBecomeAHostPageLocators.*;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AirbnbBecomeAHostPage extends BaseAPI {

    @FindBy(css = webElementHeaderBecomeAHost)
    public WebElement headerBecomeAHost;

    public AirbnbBecomeAHostPage(){
        PageFactory.initElements(driver, this);
    }
}

