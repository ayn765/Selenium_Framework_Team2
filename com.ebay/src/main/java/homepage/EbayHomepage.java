package homepage;

import common.BaseAPI;
import musicPage.EbayMusicPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sellerCenterPage.EBaySellerCenterPage;

import static homepage.EbayHomepageLocators.*;

public class EbayHomepage extends BaseAPI {

    EbayHomepage ebayHomepage;


    public EbayHomepage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = WEBELEMENT_BUTTON_NAVIGATE_TO_MUSIC_PAGE)
    public WebElement navigateToMusicPage;

    @FindBy(xpath = WEBELEMENT_LINK_NAVIGATE_TO_SELLER_CENTER_PAGE)
    public WebElement navigateToSellerCenterPage;

    public EbayMusicPage navigateToMusicPage(){
      ebayHomepage = new EbayHomepage();
      clickElement(navigateToMusicPage);
      return new EbayMusicPage();
    }

    public EBaySellerCenterPage navigateToSellerCenterPage(){
        ebayHomepage = new EbayHomepage();
        clickElement(navigateToSellerCenterPage);
        return new EBaySellerCenterPage();
    }


}
