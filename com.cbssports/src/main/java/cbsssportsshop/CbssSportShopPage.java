package cbsssportsshop;

import common.BaseAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static cbsssportsshop.CbssSportShopPageLocators.*;

public class CbssSportShopPage extends BaseAPI {
    public CbssSportShopPage() {
        PageFactory.initElements(driver, this);

    }
    @FindBy(css=WebElementShopPage)
    WebElement shopPage;
    @FindBy(xpath=WebElementShopSoccer)
    WebElement shopSoccer;
    @FindBy(xpath= WebElementShopSoccerTeam)
    WebElement shopTeam;
    @FindBy(xpath=WebElementShopSoccerItem)
    WebElement soccerItem;
    @FindBy(xpath=WebElementAddToCart)
    WebElement addToCart;
    @FindBy(xpath=WebElementPlayers)
    WebElement players;
    @FindBy(xpath=WebElementJames)
    WebElement jamesClothes;
    @FindBy(xpath =WebElementJamesKidsItem)
    WebElement jamesKidsItem;
    @FindBy(xpath =WebElementSearchBar)
    WebElement searchBar;
    @FindBy(xpath =WebElementSearchResult)
    public WebElement searchResult;
    @FindBy(xpath = WebElementReturnPolicy)
    WebElement returnPolicy;

    /**
     * Test case:1
     * Navigate to Shop
     * click on Soccer
     * Select Soccer Team
     * Click on Item
     * add item to the cart
     */
    public void navigateToShop() {
        clickOnTheElement(shopPage);
    }

  public void shopSoccer(){
        navigateToShop();
        clickOnTheElement(shopSoccer);
        switchToNewTab(1);
        clickOnTheElement(shopTeam);
        clickOnTheElement(soccerItem);
        clickOnTheElement(addToCart);

  }
    /**
     * Test case:2
     * Navigate to Shop
     * MouseHover Players
     * Select James Lebron
     * Click on button kids
     */

    public void shopPlayersItems(){
        navigateToShop();
        mouseHoverElement(players);
        clickOnTheElement(jamesClothes);
        clickOnTheElement(jamesKidsItem);
    }
    /**
     * Test case:3
     * Navigate to Shop
     * search item in search bar
     * validate how many results
     * Click on button kids
     */
    public void searchItems(){
        navigateToShop();
        sendKeysToElement(searchBar,"Algeria t-shirt Flag");
    }
    /**
     * Test case:3
     * Navigate to Shop
     * click on Return policy button
     * get the text
     * return to shop page
     */
    public void returnItems(){
        navigateToShop();
        clickOnTheElement(returnPolicy);
        String text=returnPolicy.getText();
        System.out.println(text);
        driver.navigate().back();
    }
}

