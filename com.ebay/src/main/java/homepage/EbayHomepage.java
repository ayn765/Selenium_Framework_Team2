package homepage;

import common.BaseAPI;
import musicPage.MusicPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static homepage.EbayHomepageLocators.*;

public class EbayHomepage extends BaseAPI {

    EbayHomepage ebayHomepage;


    public EbayHomepage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = WEBELEMENT_BUTTON_NAVIGATE_TO_MUSIC_PAGE)
    public WebElement navigateToMusicPage;

    public MusicPage navigateToMusicPage(){
      ebayHomepage = new EbayHomepage();
      clickElement(navigateToMusicPage);
      return new MusicPage();
    }
}
