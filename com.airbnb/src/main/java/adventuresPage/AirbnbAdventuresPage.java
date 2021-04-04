package adventuresPage;

import common.BaseAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static adventuresPage.AirbnbAdventuresPageLocators.*;

public class AirbnbAdventuresPage extends BaseAPI {

    @FindBy(css = webElementHeaderAdventures)
    public WebElement headerAdventures;

    public AirbnbAdventuresPage(){
        PageFactory.initElements(driver, this);
    }
}

