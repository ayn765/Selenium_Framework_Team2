package ebayhomegarden;

import common.BaseAPI;
import static ebayhomegarden.EbayHomeGardenPageLocators.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import sell.SellPage;

import java.util.List;


public class EbayHomeGardenPage extends BaseAPI {

    public EbayHomeGardenPage() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = WebElementHomeGardenButton)
    WebElement homeGardenButton;
    @FindBy(css = WebElementHomeGardenHeader)
    public WebElement homeGardenHeader;
    @FindBy(css = WebElementHomeGardenShopByCategory)
    WebElement shopHomeGardenCategory;
    @FindBy(id = WebElementSearchBar)
    WebElement searchBar;
    @FindBy(css = WebElementSearchButton)
    WebElement searchButton;
    @FindBy(xpath = WebElementFashionMenu)
    WebElement fashionMenu;
    @FindBy(xpath = WebElementFashionWomenClothing)
    WebElement fashionWomenClothing;
    @FindBy(css = WebElementChooseLikeNewButton)
    WebElement chooseLikeNewButton;
    @FindBy(xpath = WebElementSortFeaturedItems)
    WebElement sortFeaturedItems;
    @FindBy(css = WebElementSortFeaturedItemsLowestPrice)
    WebElement sortFeaturedItemsLowestPrice;
    @FindBy(xpath = WebElementHowManyResult)
    public WebElement howManyResult;
    @FindBy(xpath = WebElementDinnerware)
    public WebElement dinnerWare;
    @FindBy(css = WebElementDinnerwarePrice)
    WebElement dinnerwarePrice;
    @FindBy(css = WebElementDinnerWareCheckBoxPrice)
    WebElement dinnerWareCheckboxPrice;
    @FindBy(css = WebElementDinnerwareHeaderResult)
    public WebElement dinnerwareHeaderResult;
    @FindBy(xpath = WebElementSmartHome)
    WebElement smartHome;
    @FindBy(css = WebElementSmartTv)
    WebElement smartTv;
    @FindBy(css = WebElementShopByBrandButtonArrow)
    WebElement shopByBrandArrow;
    @FindBy(xpath = WebElementShopByBrandSony)
    WebElement shopByBrandSony;
    @FindBy(xpath = WebElementSelectTVInSonyBrand)
    WebElement selectedTvInSonyBrand;
    @FindBy(xpath = WebElementAddTvToTheCart)
    WebElement addTvToTheCart;
    @FindBy(xpath = WebElementDoNotAddWarranty)
    WebElement doNotAddWarranty;
    @FindBy(xpath = WebElementHouseKeeping)
    WebElement houseKeeping;
    @FindBy(xpath = WebElementHouseKeepingTool)
    public WebElement houseKeepingTool;
    @FindBy(css = WebElementKitchenAppliances)
    WebElement kitchenAppliances;
    @FindBy(css = WebElementArrowButton)
    WebElement arrowButton;
    @FindBy(xpath = WebElementTopBrandProduct)
    WebElement topBrandProduct;
    @FindBy(xpath = WebElementTopBrandProductPage)
    public WebElement topBrandProductPage;
    @FindBy(xpath = WebElementMyEbayDropDown)
    WebElement myEbayDropDown ;
    @FindBy(xpath = WebElementMyEbayRecentlyViewed)
    WebElement myEbayRecentlyViewed;
    @FindBy(css = WebElementMinPrice)
    WebElement minPrice;
    @FindBy(css = WebElementMaxPrice)
    WebElement maxPrice;
    @FindBy(xpath = WebElementPriceRangeButton)
    WebElement priceRangeButton;
    @FindBy(css = WebElementPriceRangeResult)
    public WebElement priceRangeResult;
    @FindBy(id = webElementLinkAdvancedSearch)
    public WebElement linkAdvancedSearch;
    @FindBy(id = webElementInputKeywords)
    public WebElement inputKeywords;
    @FindBy(css = webElementSelectCategory)
    public WebElement selectCategory;
    @FindBy(css = webElementButtonSearch)
    public WebElement buttonSearch;
    @FindBy(css =WebElementAdvancedSearchResult)
    public WebElement advancedSearchResult;
    @FindBy(id =WebElementSellPage)
    WebElement sellPage;

    /**
     * Test case:1
     * Navigate to Ebay Homepage
     * Click on Home&Garden Button to open Home&Garden page
     * Validate shop by category element is displayed or not
     */
    public void navigateToHomeGarden() {
        clickOnTheElement(homeGardenButton);
    }

    public boolean checkIfPageDisplay() {
        shopHomeGardenCategory.isDisplayed();
        return true;
    }

    /**
     * Test case:2
     * Navigate to Ebay Homepage
     * Click on Home&Garden Button to open Home&Garden page
     * Search Kitchen Appliances in search bar
     * click Search Button
     */
    public void sendKeysToSearchBar() {
        sendKeysToElement(searchBar, "kitchen tools");
    }

    public void clickOnSearchButton() {
        clickOnTheElement(searchButton);
    }

    public void searchProduct() {
        navigateToHomeGarden();
        sendKeysToSearchBar();
        clickOnSearchButton();

    }

    /**
     * Test case:3
     * Navigate to Ebay Homepage
     * Click on Home&Garden Button to open Home&Garden page
     * click on shop by category menu
     * mouse hover Fashion
     * click on women clothing tab in Fashion
     */
    public void shopByCategoryClick() {
        clickOnTheElement(shopHomeGardenCategory);
    }

    public void womenClothingTab() {
        mouseHoverElement(fashionMenu);
        String parentWindow = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        clickOnTheElement(fashionWomenClothing);
    }

    public void navigateToWomenClothing() {
        navigateToHomeGarden();
        shopByCategoryClick();
        womenClothingTab();
    }

    /**
     * Test Case:4
     * Navigate to Ebay Homepage
     * Click on Home&Garden Button to open page
     * Move back page
     * Validate back to homePage
     */
    public void validateDoMoveBackward() {
        navigateToHomeGarden();
        driver.navigate().back();
    }

    /**
     * Test Case:5
     * Navigate to Ebay Homepage
     * Navigate Home&Garden Button to open page
     * mouse hover home & garden header
     * Validate the header attribute by style
     */

    public void hoverHomeGardenHeader(){
        navigateToHomeGarden();
        Actions action = new Actions(driver);
        action.moveToElement(homeGardenHeader).build().perform();
    }
    /**
     * Test Case:6
     * - Navigate to Ebay Homepage
     * - Navigate Home&Garden Button to open page
     * - click on choose like new Button
     * - Navigate to the new open window
     * - click on  Sort Featured items
     * - select Sort items By lowest price
     * - eValidate how many result we get
     */

    public void sortItems() {
        navigateToHomeGarden();
        clickOnTheElement(chooseLikeNewButton);
        clickOnTheElement(sortFeaturedItems);
        sortFeaturedItemsLowestPrice.isEnabled();

    }

    /**
     * Test Case:7
     * - Navigate to Ebay Homepage
     * - Navigate Home&Garden Button to open page
     * - click on Dinnerware
     * - set the price for Dinnerware to over 35$
     * - validate the title(header) that appears
     */
    public void dinnerWareChoosePrice() {
        navigateToHomeGarden();
        clickOnTheElement(dinnerWare);
        mouseHoverElement(dinnerwarePrice);
        dinnerWareCheckboxPrice.isEnabled();
    }

    /**
     * Test Case:8
     * - Navigate to Ebay Homepage
     * - Navigate Home&Garden Button to open page
     * - navigate to Smart Home
     * - navigate to Smart TV
     * - click on the Arrow to have the full visibility of the Tv's Brands
     * -select Sony Tv Brand
     * -choose Which sony Tv we want
     * -click on Add to Cart
     * -Move to the the popping tab(windowHandle)
     * -click on "No Thanks" to decline Protection Plan
     */
    public void addSonySmartTvToTheCart() {
        navigateToHomeGarden();
        clickOnTheElement(smartHome);
        clickOnTheElement(smartTv);
        clickOnTheElement(shopByBrandArrow);
        clickOnTheElement(shopByBrandSony);
        clickOnTheElement(selectedTvInSonyBrand);
        clickOnTheElement(addTvToTheCart);
        windoHandle();
        clickOnTheElement(doNotAddWarranty);
    }

    /**
     * Test Case:9
     * - Navigate to Ebay Homepage
     * - Navigate Home&Garden Button to open page
     * - click on Dinnerware
     * - set the price for Dinnerware to over 35$
     * -validate the title(header) that appears
     */

    public int numElementsInHomeGardenShopCategoryDrop() {
        navigateToHomeGarden();
        //Here I'm counting number of element in an <UL> list.So for that we need to locate ul first then all li in that UL
        WebElement ul_element = driver.findElement(By.xpath("//*[@id=\"s0-16-13-0-1[0]-0-0-0\"]/ul"));
        List<WebElement> li_All = ul_element.findElements(By.className("b-links-accordion"));
        int drop = li_All.size();
        for (int i = 0; i < li_All.size(); i++) {
            System.out.println(li_All.get(i).getText());
        }
        return drop;
    }

    /**
     * Test Case:10
     * - Navigate to Ebay Homepage
     * - Navigate Home&Garden Button to open page
     * - click House Keeping and organisation
     * - validate element is available
     */
    public void searchItemInHousekeepingPage() {
        navigateToHomeGarden();
        clickOnTheElement(houseKeeping);
    }

    /**
     * Test Case:11
     * - Navigate to Ebay Homepage
     * - click on Kitchen Appliances
     * - Validate how many category of appliances in the next window
     */
    public int categoryKitchenAplliances() {
        navigateToHomeGarden();
        clickOnTheElement(kitchenAppliances);
        WebElement ul_element = driver.findElement(By.xpath("//*[@id=\"s0-27-9-0-1[0]-0-0-xCarousel-x-carousel-items\"]/ul"));
        List<WebElement> li_All = ul_element.findElements(By.className("b-guidancecard__link"));
        int category = li_All.size();
        for (int i = 0; i < li_All.size(); i++) {
            System.out.println(li_All.get(i).getText());
        }
        return category;
    }

    /**
     * Test Case:12
     * - Navigate to Ebay homeGarden
     * - click on arrow button 2 times to defile all of the top Brands
     * - click on a Top brand Product on the page
     * validate the page
     */
    public void topProductBrand() {
        navigateToHomeGarden();
        clickOnTheElement(topBrandProduct);
        for (int i = 0; i < 3; i++) {
            clickOnTheElement(arrowButton);}
    }
    /**
     * Test Case:13
     * Navigate to Ebay Homepage
     * navigate to home garden
     * Mouse hover My Ebay Menu
     * Click on WatchList
     * Navigate to back page
     * refresh the page
     */
 public void navigateBack(){
 navigateToHomeGarden();
 try{
 mouseHoverElement(myEbayDropDown);
     Thread.sleep(2000);
clickOnTheElement(myEbayRecentlyViewed);
     Thread.sleep(2000);
 driver.navigate().back();
 driver.navigate().refresh();
 }catch(Exception e) {
     System.out.println("Web Element haven't download properly, need to increase wait time");
 }
}
    /**
     * Test Case:14
     * Navigate to Ebay Homepage
     * navigate to home garden
     * click on smart home
     * input min and max price for Smart home items
     * click on submit arrow
     * validate the number of items that shows for that price range
     */
public void selectHomeItemsPrice(){
     navigateToHomeGarden();
     clickOnTheElement(smartHome);
     minPrice.sendKeys("200");
    maxPrice.sendKeys("300");
    try {
        Thread.sleep(2000);
       mouseHoverElement(priceRangeButton);
    } catch (Exception e) {
        System.out.println("Could not click on the Price button --- Trying again");
    }
}

    /**
     * Test Case:15
     * Navigate to Ebay Homepage
     * navigate to home garden
     * navigate to advanced search
     * input indoor plants in search bar
     * select category search
     * click search
     * validate the number of items for the search
     */
public void advancedSearchHOMEGArden(){
    navigateToHomeGarden();
    mouseHoverElement(linkAdvancedSearch);
    mouseHoverElement(inputKeywords);
    sendKeysToElement(inputKeywords,"indoor plants");
    Select select = new Select(selectCategory);
    select.selectByVisibleText("Home & Garden");
    clickOnTheElement(buttonSearch);
}
    /**
     * Test Case:16
     * Navigate to Ebay Homepage
     * navigate to home garden
     * navigate to advanced search
     * input Golden Cups in search bar
     * clear search
     * Go back to home page
     */
    public void clearSearch(){
        navigateToHomeGarden();
        mouseHoverElement(linkAdvancedSearch);
        mouseHoverElement(inputKeywords);
        sendKeysToElement(inputKeywords,"Golden Cups");
        inputKeywords.clear();
        driver.navigate().back();
        driver.navigate().refresh();
    }
    /**
     * Test Case:17
     * Navigate to Ebay Homepage
     * navigate to home garden
     * navigate Sell page from Home Garden (Method Chaining)
     * click on Sell
     * click on sell Item
     * Input Samsung in Search Bar
     */
    public SellPage navigateToSellPage(){
        clickOnTheElement(sellPage);
        return new SellPage();
    }
}