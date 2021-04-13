package macysdeals;

import common.BaseAPI;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


import java.util.List;

import static macysdeals.MacysDealsLocators.*;



public class MacysDealsPage extends BaseAPI {
    public MacysDealsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = WebElementDeals)
    WebElement deals;
    @FindBy(xpath = WebElementOfferHeader)
    public WebElement offerHeader;
    @FindBy(xpath = WebElementShopCategoryDropDown)
    WebElement shopByCategory;
    @FindBy(xpath = WebElementShopKidsDeal)
    WebElement shopKidsDeals;
    @FindBy(xpath = WebElementFiltersShopKids)
    WebElement filtersShopKids;
    @FindBy(xpath =WebElementLink)
    WebElement link;


    public void navigateDeals() {
        clickOnTheElement(deals);
    }

    /**
     * Test case:1
     * Navigate to Deals
     * Get text from Offer Header
     * Validate the text
     */
    public void textHeader() {
        navigateDeals();
        mouseHoverElement(offerHeader);
    }

    /**
     * Test case:2
     * Navigate to Deals
     * click on category drop down
     * Validate the number of link
     */
    public int NumOfLinksINCategoryDropDown() {
        clickOnTheElement(shopByCategory);
        WebElement ul_element = driver.findElement(By.xpath("//*[@id=\"mainNavigationFobs\"]"));
        List<WebElement> li_All = ul_element.findElements(By.className("fob"));
        int numlinks = li_All.size();
        for (int i = 0; i < li_All.size(); i++) {
            System.out.println(li_All.get(i).getText());
        }
        return numlinks;
    }

    /**
     * Test case:3
     * Navigate to Deals
     * click Kids
     * Filter he search by best seller
     */

    public void shop() {
        navigateDeals();
        scrollToElementJScript(shopKidsDeals);
        mouseHoverElement(shopKidsDeals);
        Select sel=new Select(filtersShopKids);
         sel.selectByValue("BEST_SELLERS");
   }

   }



