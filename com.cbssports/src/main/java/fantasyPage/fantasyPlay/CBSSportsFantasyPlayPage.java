package fantasyPage.fantasyPlay;

import common.BaseAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

import static fantasyPage.fantasyPlay.CBSSportsFantasyPlayPageLocators.*;

public class CBSSportsFantasyPlayPage extends BaseAPI {

    public CBSSportsFantasyPlayPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = WEBELEMENTS_TOP_LINKS_IMGS)
    public List<WebElement> topLinksImgs;

    public boolean validateTopLinks() throws IOException {
        return compareListWebElementsToExcelDoc(topLinksImgs, System.getProperty("user.dir")+"/src/test/resources/CBSSportsTestData.xlsx", "PlayPageTopLinks");
    }

}
