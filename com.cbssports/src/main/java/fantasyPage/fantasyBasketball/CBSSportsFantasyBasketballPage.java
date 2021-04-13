package fantasyPage.fantasyBasketball;

import common.BaseAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static fantasyPage.fantasyBasketball.CBSSportsFantasyFootballPageLocators.*;

public class CBSSportsFantasyBasketballPage extends BaseAPI {

    public CBSSportsFantasyBasketballPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = WEBELEMENTS_SIDE_MENU_RESEARCH)
    public List<WebElement> sideMenuResearch;

    public int getNumSideMenuResearchOptions(){
        return sideMenuResearch.size();
    }
     public boolean verifyLinksSideMenuResearch(){
        return verifyLinks(sideMenuResearch, "href");
     }

}
