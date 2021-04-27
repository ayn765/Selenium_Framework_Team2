package homePageTrulia;

import common.BaseAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import profilePage.ProfilePage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.List;

import static homePageTrulia.HomePageLocatorsTrulia.*;

public class HomePageTrulia extends BaseAPI {


    HomePageTrulia homePageTrulia;
    @FindBy(xpath = WEB_ELEMENT_BUTTON_BUY)
    public WebElement buttonBuy;

    @FindBy(xpath = WEB_ELEMENT_BUTTON_List_BUY)
    public List<WebElement> buttonListBuy;

    @FindBy(css = WEB_ELEMENT_BUTTON_IN_DROP_DOWN_HOME_FOR_SALE)
    public WebElement buttonInDropDown_homeForSale;

    @FindBy(css = WEB_ELEMENT_BUTTON_RENT)
    public WebElement buttonRent;

    @FindBy(xpath = WEB_ELEMENT_BUTTON_LIST_RENT)
    public List<WebElement> buttonListRent;

    @FindBy(css = WEB_ELEMENT_BUTTON_MORTGAGE)
    public WebElement buttonMortgage;

    @FindBy(xpath = WEB_ELEMENT_BUTTON_LIST_MORTGAGE)
    public List<WebElement> buttonListMortgage;


    @FindBy(xpath = WEB_ELEMENT_LIST_CATEGORY_SEARCH_BAR_)
    public List<WebElement> listcategorySearchbar;

    @FindBy(xpath = WEB_ELEMENT_HOME_IMAGE)
    public WebElement homeImage;
    @FindBy(xpath = WEB_ELEMENT_BUTTON_SEARCH_BAR)
    public WebElement buttonSearchBar;
    @FindBy(css= WEB_ELEMENT_INPUT_SEARCH_BAR)
    public WebElement inputSearchBar;

    @FindBy(xpath= WEB_ELEMENT_CURRENT_PAGE)
    public WebElement currentPage;

    @FindBy(css= WEB_ELEMENT_NEW_TAB)
    public WebElement newTab ;

    @FindBy(css= WEB_ELEMENT_Image_NEW_TAB)
    public WebElement ImageNewTab ;

    @FindBy(css= WEB_ELEMENT_TEXT_IN_THE_PARENT_PAGE)
    public WebElement text_In_Parent_page ;

    @FindBy(css= WEB_ELEMENT_BUTTON_PROFILE)
    public WebElement buttonProfile ;

    @FindBy(xpath= WEB_ELEMENT_LINKS_LIST_REAL_ESTATE_MARKET)
    public WebElement linksRealEstateMarket ;

    @FindBy(xpath= WEB_ELEMENT_LINKS_LIST_EXPLORE_TRULIA)
    public WebElement linksExploreTrulia ;

    @FindBy(xpath= WEB_ELEMENT_LINKS_LIST_POPULAR_SEARCH)
    public WebElement linksPopularSearch ;


    public HomePageTrulia() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Test case:1
     * go to Home page trulia.com
     * mousehover the buy button
     * get all the elemnts of the dro Down inside the list
     * <p>
     * get the size of drop down
     */

    public void mouseHover() {
        // hoverOverElement(buttonBuy);
        Actions action = new Actions(driver);
        action.moveToElement(buttonBuy).perform();

    }

    public int getSizeofdropdown() {
        mouseHover();
        List<WebElement> links = buttonListBuy;
        int total_links = links.size();
        System.out.println("the size is" + total_links);
        return total_links;
    }


    /**
     * Test case:2
     * go to Home page trulia.com
     * mouse hover the buy button
     * get all the elements of the drop Down inside the list
     * <p>
     * get the text of each elment and compare it against the exel sheet
     */
    public String getAllElementsOfList1() {
        String actuallist = "";
        mouseHover();
        List<WebElement> links = buttonListBuy;
        int total_links = links.size();
        for (WebElement element : links) {
            actuallist = element.getText();
            System.out.println(actuallist);

        }
        return actuallist;

    }


    /**
     * Test case:3
     * go to Home page trulia.com
     * mouse hover the buy button
     * get all the elements of the drop Down inside the list
     * <p>
     * iterate through the list and if we get the same value that we Passing; we click on it
     */

    public boolean clickOnElementOnDropDown(String ele) {
        String actuallist = "";

        mouseHover();
        List<WebElement> links = buttonListBuy;
        int total_links = links.size();
        for (WebElement element : links) {
            actuallist = element.getText();
            System.out.println(actuallist);
            if (actuallist.equalsIgnoreCase(ele)) {
                clickElement(element);

                break;
            }
            return true;
        }
        return true;
    }
    /**
     * Test case:4
     * go to Home page trulia.com
     * mouse hover the Rent button
     * get all the elements of the drop Down inside the list
     * compare each element to the expected list
     *
     */
public String comparingActualListToExpectedlist() {
    String actualList = "";
    mouseHover();
    List<WebElement> links = buttonListBuy;
    int total_links = links.size();
    for (WebElement element : links) {
        actualList = element.getText();
    }
    System.out.println(actualList);
    return actualList;

}
    /**
     * Test case:5
     * go to Home page trulia.com
     * inspect button buy above the search box
     * get all the elements  inside the list
     * iterate through the list and click on each buttone .
     * @return a flag=true if the all elments are displayed.

     */
    public boolean clickOnEchElemntIntheList() {
        String actuallist = "";
        boolean flag = false;
        mouseHover();
        List<WebElement> links = listcategorySearchbar;
        int total_links = links.size();
        for (WebElement element : links) {
            clickElement(element);

            if (element.isEnabled()) {
              return true;

           } else {
               return flag;
           }}return flag;}

/**
 * Test case:6
 * go to Home page trulia.com
 * get the text from the  search box
 * get the attribute.
 */

 public String getKeysFromTheSearchBar(){
    String actual= inputSearchBar.getAttribute("value");
     System.out.println("the expected text is : "+actual);
     return actual;


 }
    /**
     * Test case:7
     * go to Home page trulia.com
     * delete  the initial Sendkeys in  search box
     * send new sendkys
     * press the button search
     * get the url.
     */

    public void clearInputFieldAndSendKeysToElement(WebElement element, String keysToSend) {
        try {
            waitUntilWebElementVisible(element);
            element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
            element.sendKeys(keysToSend);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("UNABLE TO SEND KEYS TO WEB ELEMENT");
        }

    }
    public String doSearch(){
        clickElement(buttonSearchBar);
     String URL =  driver.getCurrentUrl();

    // currentPage.getCurrntUrl();
        System.out.println("the url iss: "+ URL);
        //:https://www.trulia.com/PA/Lansdale/
     return URL;


    }




    /**
     * Test case:8
     * go to Home page trulia.com
     *get the nmber of Iframe we have.
     * return the number
     *
     */
    public int getThenumOfifrem(){
        int size = 0;
        return size;
    }
    /**
     * Test case:9
     * go to Home page trulia.com
     *click on button buy then and select new .
     * click on the photo(newTab) and new tab open up.
     * switch to this tab
     *
     */
public void SwitchToNewWin(String ele){
    mouseHover();
    clickOnElementOnDropDown( ele);
    clickElement(newTab);
    switchToNewTab(1);}

    /**
     * Test case:10
     * go to Home page trulia.com
     *click on button buy then and select new .
     * click on the photo(newTab) and new tab open up.
     * switch to this tab
     * go back to the parent tab
     *
     */

public void switchToParentTab(String ele){
    SwitchToNewWin(ele);
    driver.switchTo().defaultContent();


}
/**
 * Test case:11(navigate to profile page)
 * go to Home page trulia.com
 *click on button Profile .
 * return an object of this page
 *
 *
 */
public ProfilePage navigateTpProfilePage(){
    clickElement(buttonProfile);
    return new ProfilePage();
}
    /**
     * Test case:12
     * SCROLL dOWN UNTIL THE REAL ESTATE MARKET
     * MAKE LIST OF ALL  LINKS.
     * Return THE SIZE OF THE list.
     * return the num of  links.
     */
    public int numLinkInRealEstateMarket() {

        scrollToElementJScript(linksRealEstateMarket);
        List<WebElement> links_list = linksRealEstateMarket.findElements(By.tagName("a"));
        int size=links_list.size();
        return size;
    }
    /**
     * Test case:13
     * SCROLL dOWN UNTIL THE popular search
     * MAKE LIST OF ALL  LINKS.
     * Return THE SIZE OF THE list.
     * return the num of  links.
     */
    public int numLinkInPopularSearch() {

        scrollToElementJScript(linksPopularSearch);
        List<WebElement> links_list = linksPopularSearch.findElements(By.tagName("a"));
        int size=links_list.size();
        return size;
    }
    /**
     * Test case:14
     * SCROLL dOWN UNTIL THE explore trulia
     * MAKE LIST OF ALL  LINKS.
     * Return THE SIZE OF THE list.
     * return the num of  links.
     */
    public int numLinkInExploreTrulia() {

        scrollToElementJScript(linksExploreTrulia);
        List<WebElement> links_list = linksExploreTrulia.findElements(By.tagName("a"));
        int size=links_list.size();
        return size;
    }
}




