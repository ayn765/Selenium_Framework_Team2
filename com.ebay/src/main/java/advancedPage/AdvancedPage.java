package advancedPage;

import common.BaseAPI;
import advancedPage.AdvancedPageLocators.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

import static advancedPage.AdvancedPageLocators.*;
import static dealsEbay.DealsEbayLocators.WEB_ELEMENT_BUTTON_DEALS;

public class AdvancedPage extends BaseAPI {

    @FindBy(css = WEB_ELEMENT_BUTTON_DEALS)
    public WebElement buttonDeals;


    @FindBy(xpath= WEB_ELEMENT_LIST_ALL_CATEGORY2)
    public List<WebElement> ListAllCategory;


    @FindBy(xpath= WEB_ELEMENT_BUTTON_ADVANCED)
    public WebElement buttonAdvanced;

    @FindBy(css= WEB_ELEMENT_EXPECTED_RESULT)
    public WebElement expectedResult;

    @FindBy(css= WEB_ELEMENT_BUTTON_SEARCH)
    public WebElement buttonSearch;


    public AdvancedPage(){

        PageFactory.initElements(driver, this);
    }

/**
     * Test case 1 -
     * 1. Navigate to https://www.ebay.com/
     * 2. click on deals button
     * click on advanced Search button
     *
     */
    public void advancedPage(){
        clickElement(buttonDeals);
        clickElement(buttonAdvanced);
    }
    /**   * Test case 2 -
     * 1. Navigate to https://www.ebay.com/
     * 2. click on deals button
     * click on advanced Search button
     *click on button search
     * we will iterate through the list all category and click on each element
     * and make sur that the element is displayed.
     * retrun bolean.
     *
     *
             */
    public boolean displayedCategory(){

        advancedPage();
        clickElement(buttonSearch);
        List<WebElement> elementList = getListOfWebElements(By.xpath("//*[@id='wrapper']/div[1]/div/div/div[2]/div[1]/ul/li"));
        int actualCount = elementList.size();
        boolean flag = false;
        int count = 0;

        for (int i = 0; i < elementList.size(); i++) {
            elementList.get(i).click();
            for(WebElement element:elementList) {
                String page = element.getText();


            if ( page.equals("eBay Motors")) {
                count+=1;
                System.out.println("the page is not displayed");
            } else {
                System.out.println("the page is displayed : " + page);
                count-=1;
            }
        }
        if (count > 1) {
            flag = false;
        }else{ flag=true;}
        System.out.println(flag);
        return flag;

    }



        return flag;

    }

    }


