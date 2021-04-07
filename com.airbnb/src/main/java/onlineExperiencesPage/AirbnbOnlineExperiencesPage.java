package onlineExperiencesPage;

import common.BaseAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static onlineExperiencesPage.AirbnbOnlineExperiencesPageLocators.*;

public class AirbnbOnlineExperiencesPage extends BaseAPI {

    @FindBy (css = webElementHeaderOnlineExperiencesPage)
    public WebElement headerOnlineExperiencesPage;

    public AirbnbOnlineExperiencesPage(){
        PageFactory.initElements(driver, this);
    }

}
