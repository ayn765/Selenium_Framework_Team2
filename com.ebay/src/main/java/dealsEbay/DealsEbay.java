package dealsEbay;

import advancedPage.AdvancedPage;
import common.BaseAPI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.List;

import static advancedPage.AdvancedPageLocators.*;
import static advancedPage.AdvancedPageLocators.WEB_ELEMENT_BUTTON_SEARCH;
import static dealsEbay.DealsEbayLocators.*;

public class DealsEbay extends BaseAPI {
    @FindBy(css = WEB_ELEMENT_BUTTON_DEALS)
    public WebElement buttonDeals;

    @FindBy(xpath = WEB_ELEMENT_EXPECTED_TEXT)
    public WebElement expectedText;
    @FindBy(xpath = WEB_ELEMENT_BUTTON_SHOP_CATEGORY)
    public WebElement buttonShopCategory;
    @FindBy(xpath = WEB_ELEMENT_LIST_SHOP_CATEGORY)
    public List<WebElement> listShopCategory;


    @FindBy(css = WEB_ELEMENT_LIST_CATEGORY_DEALS)
    public List<WebElement> listCategoryDeals;

    @FindBy(css = WEB_ELEMENT_BUTTON_ABOUT_EBAY)
    public WebElement buttONaBOUTeBAY;

    @FindBy(xpath = WEB_ELEMENT_LInks_ABOUT_EBAY)
    public List<WebElement> linksAboutEbay;

    @FindBy(xpath = WEB_ELEMENT_EXPECTED_TEXT_SECURITY_PAGE)
    public WebElement expectedTextSecurityPage;


    //shopping Cart
    @FindBy(css = WEB_ELEMENT_INPUT_SEARCH_BAR)
    public WebElement inputSearchBar;

    @FindBy(css = WEB_ELEMENT_BUTTON_SEARCH_BAR)
    public WebElement buttonSearchBar;

    @FindBy(css = WEB_ELEMENT_ITEM_T0_BUY)
    public WebElement itemToBuy;


    @FindBy(css = WEB_ELEMENT_SELECT_DROP_DOWN_COLOR)
    public WebElement selectDropDownColor;

    @FindBy(css = WEB_ELEMENT_SELECT_DROP_DOWN_SIZE)
    public WebElement selectDropDownSize;

    @FindBy(xpath = WEB_ELEMENT_BUTTON_VIEW_CART)
    public WebElement buttonViewCart;

    @FindBy(css = WEB_ELEMENT_BUTTON_BUY_AS_GUSET)
    public WebElement buttonBuyAsGuset;

    @FindBy(css = WEB_ELEMENT_BUTTON_Not_robot)
    public WebElement buttonNotRobot;
    @FindBy(css = WEB_ELEMENT_SELECT_DROP_DOWN_QTS)
    public List<WebElement> selectDropDownQts;

    @FindBy(css = WEB_ELEMENT_PRICE)
    public WebElement price;



    @FindBy(xpath= WEB_ELEMENT_LIST_ALL_CATEGORY2)
    public List<WebElement> ListAllCategory;


    @FindBy(xpath= WEB_ELEMENT_BUTTON_ADVANCED)
    public WebElement buttonAdvanced;

    @FindBy(css= WEB_ELEMENT_EXPECTED_RESULT)
    public WebElement expectedResult;

    @FindBy(css= WEB_ELEMENT_BUTTON_SEARCH)
    public WebElement buttonSearch;



    public DealsEbay() {
        PageFactory.initElements(driver, this);
    }


    /**
     * Test case 1 -
     * 1. Navigate to https://www.ebay.com/
     * 2. click on deals button
     */
    public void navigateToDealsPage() {
        clickElement(buttonDeals);

    }


    /**
     * Test case 2 -
     * 1. Navigate to https://www.ebay.com/
     * 2. click on deals button
     * 3.CLICK on button shop by category
     * 4.get the list
     * 5.iterate through the list and if we get the same value that we Passing; we click on it
     */
    public boolean clickOnListShopCategory(String ele) {
        String actualList = "";
        clickElement(buttonShopCategory);
        List<WebElement> links = listShopCategory;
        int total_links = links.size();
        System.out.println("the size is " + total_links);
        for (WebElement element : links) {
            actualList = element.getText();
            System.out.println(actualList);
            if (actualList.equalsIgnoreCase(ele)) {
                clickElement(element);


                break;
            }
            return true;
        }
        return true;
    }

    /**
     * Test case 3 -
     * 1. Navigate to https://www.ebay.com/
     * 2. click on deals button
     * 3.CLICK on button shop by category
     * 4.get the size of list
     * * 5.retrun the size
     */


    public int getSizeOfShopCategory() {
        int size = 0;
        clickElement(buttonShopCategory);
        List<WebElement> links = listShopCategory;
        int total_links = links.size();
        System.out.println("the size is " + total_links);
        return size;
    }


    /**
     * Test case 4 -
     * 1. Navigate to https://www.ebay.com/
     * 2. click on deals button
     * 3.CLICK on button category Deals
     * 4.get the list
     * 5.iterate through the list and if we get the same value that we Passing; we click on it
     * retrun ture if it clicks./flase if not.
     */
    public String getlistofcategoryDeals() {
        String actualList = "";

        List<WebElement> links = listCategoryDeals;
        int total_links = links.size();
        System.out.println("the size is " + total_links);
        for (WebElement element : links) {
            actualList = element.getText();
            System.out.println(actualList);
        }
        return actualList;
    }

    public boolean clickOnListCategoryDeals(String ele) {

        String actualList = "";

        List<WebElement> links = listCategoryDeals;
        int total_links = links.size();
        System.out.println("the size is " + total_links);
        for (WebElement element : links) {
            actualList = element.getText();
            System.out.println(actualList);

            if (actualList.equalsIgnoreCase(ele)) {
                clickElement(element);

                break;
            }
            return true;
        }
        return true;
    }


    /**
     * Test case 5 -
     * 1. Navigate to https://www.ebay.com/
     * 2. click on deals button
     * 3.CLICK on button category Deals
     * 4.creat a list of category deals
     * 5.get the size of list
     * * 6.retrun the size
     */


    public int getSizeOfCategoryDealsList() {
        int size = 0;
        List<WebElement> links = listCategoryDeals;
        int total_links = links.size();
        System.out.println("the size is " + total_links);
        return size;

    }


    /**
     * Test case 6 -
     * ExelSheet
     * 1. Navigate to https://www.ebay.com/
     * 2. click on deals button
     * 3.CLICK on button category Deals
     * 4.create a list of category deals
     * get the text of each element and compare it against the exel sheet
     */
    public String compareListOfElementToExcelSheet() {

        String actualList = "";

        List<WebElement> links = listCategoryDeals;
        int total_links = links.size();
        System.out.println("the size is " + total_links);
        for (WebElement element : links) {
            actualList = element.getText();
            System.out.println(actualList);
        }
        return actualList;
    }
/**
 * Test case 7 -
 * 1. Navigate to https://www.ebay.com/.
 * 2. click on search bar.
 * 3.send keys to search bar.
 *4 click on the search bar.
 *find the number of the photos on the page.
 * return the number of the photos on the page.
 *
 */
public void SendKeysToSearchBar(String keys) {
    sendKeysToElement(inputSearchBar, keys);
    clickElement(buttonSearchBar);

}
public int getNumOfPhotos(){

    List<WebElement> listImages=driver.findElements(By.tagName("img"));
    System.out.println("No. of Images: "+listImages.size());
    System.out.println(listImages.size());
    return listImages.size();
}






    /**
     * Test case:8
     * SCROLL dOWN UNTIL THE about ebay
     * MAKE LIST OF ALL  LINKS.
     * Return THE SIZE OF THE list.
     * return the num of  links.
     */
    public int numLinkInAboutEbayButton() {

        scrollToElementJScript(buttONaBOUTeBAY);
        List<WebElement> links_list = buttONaBOUTeBAY.findElements(By.tagName("a"));
        int size = links_list.size();
        return size;
    }

    /**
     * Test case 9-
     * Navigate to https://www.ebay.com/
     * scroll down until the "about Eaby" button
     * create a list of links
     * iterate trough the list
     * cilck on the element that we passed
     * <p>
     * *
     */
    public void clickOnTheLink() {
        clickOnList(buttonDeals, linksAboutEbay, "Securty center");
    }

    /**
     * Test case 10-
     * Navigate to https://www.ebay.com/
     * pass a method to find the number of iframe existing in this page
     * return a number of the iframe on the DealsPage
     */


    public int getNumOfIframe() {
        navigateToDealsPage();
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println(size);
        return size;
    }


    /**
     * Test case 11-
     * Navigate to https://www.ebay.com/
     * navigate to the Deals Page
     * send keys to input box "kids"
     * click on the search button
     * pick an item and click on it
     * select the color
     * select the size
     * click on view cart
     */


    public void cilkOnItem() {
        javaScriptExecutorClickOnElement(itemToBuy);

    }

    public void selectOnDropDownColor(int index1) {
        selectOptionByIndex(selectDropDownColor, index1);

    }

    public void selectOnDropDownsize(int index2) {
        selectOptionByIndex(selectDropDownSize, index2);

    }

    public boolean shoppingCart(String keys, int index, int index2) {
        navigateToDealsPage();
        SendKeysToSearchBar("kids");
        cilkOnItem();
        selectOnDropDownColor(1);
        selectOnDropDownsize(1);

        javaScriptExecutorClickOnElement(buttonViewCart);
        clickElement(buttonBuyAsGuset);
       //  clickElement(buttonNotRobot);
        List<WebElement> elementList = getListOfWebElements(By.cssSelector("#qty-BId-\\{\\\"ItemId\\\"\\:\\\"154176343081\\\"\\}\\;EId-\\{\\\"VariationId\\\"\\:454302967839\\}\\;Domain-ebay\\;LId-420002>option"));
        int actualCount = elementList.size();
        boolean flag = false;
        int count = 0;

        for (int i = 0; i < elementList.size(); i++) {
            elementList.get(i).click();

            String elementsData = getTextFromElement(price);
            if (elementsData.equals("$10.19")) {
               count+=1;
                System.out.println("the quantit is 1: "+ getTextFromElement(price));
            } else {
                System.out.println("the quantie is more then 1 ann the price is : " + getTextFromElement(price));
                count-=1;
            }
        }
        if (count > 1) {
            flag = false;
        }else{ flag=true;}
        System.out.println(flag);
        return flag;

    }

/**
 * Test case 12-
 * Navigate to https://www.ebay.com/
 * navigate To Advance page
 * test for the method inside the class
 */

public AdvancedPage navigationToAdvancePage(){
    clickElement(buttonDeals);
    clickElement(buttonAdvanced);
    return new AdvancedPage();
}
    }







