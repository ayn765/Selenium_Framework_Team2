package carsPage;

import common.BaseAPI;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.util.Iterator;

import static carsPage.CarsPageLocators.*;

public class CarsPage extends BaseAPI {
    @FindBy(css=WEB_ELEMENT_BUTTON_CARS )
   public  WebElement buttonCars;

    @FindBy(css=WEB_ELEMENT_BUTTON_RENTAL_CAR )
   public  WebElement buttonRentalCars;

    @FindBy(xpath=WEB_ELEMENT_BUTTON_AIRPORT_TRANSPORTATION)
    public   WebElement buttonAirportTransportation;

    @FindBy(css=WEB_ELEMENT_EXPECTED_IMAGE_CARS_PAGE )
    public  WebElement expectedImageCarsPage;

    @FindBy(css=WEB_ELEMENT_INPUT_PICK_UP_BOX )
    public  WebElement inputPickUpBOX;

    @FindBy(xpath=WEB_ELEMENT_INPUT_SAME_AS_PICK_UP_BOX )
    public  WebElement inputSameAsPickUpBOX;

    @FindBy(css=WEB_ELEMENT_INPUT_PICK_UP_DATE_BOX  )
    public  WebElement inputPickUpDateBox;

    @FindBy(css=WEB_ELEMENT_INPUT_DROP_OFF_BOX)
    public  WebElement inputDropOffDateBox;

    @FindBy(css=WEB_ELEMENT_DROP_DOWN_TIME_TO_PICK_UP )
    public  WebElement dropDownTimeToPickUp;


    @FindBy(css=WEB_ELEMENT_DROP_DOWN_TIME_TO_DROP_OFF )
    public  WebElement dropDownTimeToDropOff;

    @FindBy(css=WEB_ELEMENT_BUTTON_SEARCH  )
    public  WebElement buttonSearch;

    @FindBy(css=WEB_ELEMENT_BUTTON_I_HAVE_CODE  )
    public  WebElement buttonIHaveTHeCode;

    @FindBy(css=WEB_ELEMENT_DROP_DOWN_RENTAL_CAR_COMPANY )
    public  WebElement dropDownRentalCompany;

    @FindBy(css=WEB_ELEMENT_INPUT_AIRPORT_BOX)
    public  WebElement inputAirPortBox;

    @FindBy(css=WEB_ELEMENT_INPUT_HOTEL_NAME_BOX)
    public  WebElement inputHotelNameBox;

    @FindBy(css=WEB_ELEMENT_FLIGHT_ARRIVAL_DATE )
    public  WebElement flightArrivalDate;

    @FindBy(css=WEB_ELEMENT_DROP_DOWN_ARRIVAL_TIME)
    public  WebElement dropDownArrivalTime;

    @FindBy(css=WEB_ELEMENT_BUTTON_ROUND_TRIP)
    public  WebElement buttonRoundTrip;

    @FindBy(css=WEB_ELEMENT_FLIGHT_DEPARTURE_DATE)
    public  WebElement flightDepartureDate;

    @FindBy(css=WEB_ELEMENT_DROP_DOWN_DEPARTURE_TIME)
    public  WebElement dropDownDepartureTime ;







    public CarsPage(){
        PageFactory.initElements(driver, this);

    }
    /**
     * Test case:1
     * go to Home page Expidia.com
     * click on button car
     * get the title of the page
     *
     */
    public void navigateToCARSPage(){
        clickElement(buttonCars);
    }

    /**
     * Test case:1
     * go to Home page Expidia.com
     * click on button car
     * get the title of the page
     *
     */
public void clickOndiscountbuton(){
        navigateToCARSPage();
        clickElement(buttonIHaveTHeCode);
        selectElement(dropDownRentalCompany);
}

    public void clickONDropDownTimeToPickUp(){
        navigateToCARSPage();
        selectElement(dropDownTimeToPickUp);

    }
    public void clickONDropDownTimeToDropOff(){
        navigateToCARSPage();
        selectElement(dropDownTimeToDropOff);
    }

    public void sendKeysINPUT_PICK_UP_BOX(String searchKeys){
        navigateToCARSPage();
        sendKeysToElement(inputPickUpBOX,(searchKeys));
    }

    public void sendKeysINPUT_SAME_AS_PICK_UP_BOX(String searchKeys){
        navigateToCARSPage();
        sendKeysToElement(inputSameAsPickUpBOX,(searchKeys));
    }

    public void sendKeysINPUtAirPortBox(String searchKeys){
        navigateToAirportTransportationPage();
        sendKeysToElement(inputAirPortBox,(searchKeys));
    }
    public void navigateToAirportTransportationPage(){
        navigateToCARSPage();
        clickElement(buttonAirportTransportation);
    }


    public void sendKeysINPUtHotelNameBox(String searchKeys){
        navigateToAirportTransportationPage();
        sendKeysToElement(inputHotelNameBox,(searchKeys));
    }


public   void selectDateJS(WebDriver driver,WebElement element,String dateVal){
    JavascriptExecutor js=((JavascriptExecutor)driver);

    js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');",element);
}




}
