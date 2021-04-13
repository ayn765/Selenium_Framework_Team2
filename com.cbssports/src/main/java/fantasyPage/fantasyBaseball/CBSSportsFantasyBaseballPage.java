package fantasyPage.fantasyBaseball;

import common.BaseAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static fantasyPage.fantasyBaseball.CBSSportsFantasyBaseballPageLocators.*;
public class CBSSportsFantasyBaseballPage extends BaseAPI {

    public CBSSportsFantasyBaseballPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = WEBELEMENT_BASEBALL_PODCAST)
    public WebElement baseballPagePodcast;

    @FindBy(css = WEBELEMENT_IMG_PODCAST)
    public WebElement imgPodcast;

}
