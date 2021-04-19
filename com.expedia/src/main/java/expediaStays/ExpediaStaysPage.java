package expediaStays;

import common.BaseAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


import static expediaStays.ExpediaStaysLocators.*;
public class ExpediaStaysPage extends BaseAPI {
    public ExpediaStaysPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath=WebElementStays)
    WebElement stays;
    @FindBy(xpath=WebElementGoingTo)
    WebElement goingTo;
    @FindBy(id=WebElementMenu)
    WebElement menu;
    @FindBy(xpath=WebElementAdultsTravelers)
    WebElement adultTravellers;
    @FindBy(xpath=WebElementKidsTravelers)
    WebElement kidsTravellers;
    @FindBy(xpath=WebElementSearch)
    WebElement search;
    @FindBy(xpath=WebElementFirstResult)
    public WebElement firstResult;
    @FindBy(xpath=WebElementSortByDropDown)
    WebElement sortBy;
    @FindBy(xpath= WebElementFirstHotelDeal)
    WebElement hotelDeal;
    @FindBy(xpath=WebElementHotelReviews)
    WebElement hotelReviews;
    @FindBy(xpath=WebElementViewInMap)
    WebElement viewInMpa;
    @FindBy(xpath= WebElementZoomMap)
    WebElement zoomIn;
    @FindBy(xpath=WebElementDealMap)
    WebElement dealMap;
    @FindBy(xpath=WebElementHotelPicture)
    WebElement hotelPics;
    @FindBy(xpath=WebElementRoomPics)
    WebElement roomPics;

    public void navigateToStays(){
        clickOnTheElement(stays);
    }
    /**
     * Test case:1
     * Navigate to Stays Page
     * Input Mexico in search bar
     * Select 2 adult
     * select 1 kid
     * click search
     * Validate the first search Title
     */
    public void searchStayDestination(){
        navigateToStays();
     sendKeysToElement(goingTo,"Mexico city");
     clickOnTheElement(menu);
     clickOnTheElement(adultTravellers);
     clickOnTheElement(kidsTravellers);
     clickOnTheElement(search);

    }
    /**
     * Test case:1
     * Navigate to Stays Page
     * Input Mexico in search bar
     * click on search
     * Search by Stays Deals
     * select the first search
     * move to the new open window
     * click on reviews
     * scroll down till the end of reviews
     * go back to the precedent page
     */
public void searchDeals(){
    navigateToStays();
    sendKeysToElement(goingTo,"Mexico city");
    clickOnTheElement(search);
    Select select=new Select(sortBy);
    select.selectByValue("BEST_DEAL");
    clickOnTheElement(hotelDeal);
    windoHandle();
    clickOnTheElement(hotelReviews);
    scrollTillBottomPageJScript();
    driver.navigate().back();
    driver.navigate().refresh();
}
/**
 * Test case:3
 * Navigate to Stays Page
 * Input Mexico in search bar
 * click on search
 * click on search by map
 * click on ZoomIn map
 * select a deal
 * switch to a new window
 * validate the link
 */
public void searchInMap(){
    navigateToStays();
    sendKeysToElement(goingTo,"Mexico city");
    clickOnTheElement(search);
    clickOnTheElement(viewInMpa);
    clickOnTheElement(zoomIn);
    clickOnTheElement(dealMap);
    windoHandle();
}
    /**
     * Test case:4
     * Navigate to Stays Page
     * Input Mexico in search bar
     * click on search
     * click the first Search
     * click to see pictures
     * switch to a tab
     * click on rooms Pics
     * return to the main window
     */
public void bookRoom(){
    navigateToStays();
    sendKeysToElement(goingTo,"Mexico city");
    clickOnTheElement(search);
    clickOnTheElement(hotelDeal);
    clickOnTheElement(hotelPics);
    switchToNewTab(1);
    clickOnTheElement(roomPics);
    switchToNewTab(0);

}
}
