package flightsPage;

import common.BaseAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;

import static flightsPage.ExpediaFlightsPageLocators.*;

public class ExpediaFlightsPage extends BaseAPI {

    public ExpediaFlightsPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = WEBELEMTET_TAB_FLIGHTS)
    public WebElement tabFlights;

    @FindBy(css = WEBELEMENT_DROPDOWN_NUM_TRAVELERS)
    public WebElement dropdownNumTravelers;

    @FindBy(css = WEBELEMENT_LINK_AIRLINE_AGE_RULES)
    public WebElement linkAirlineAgeRules;

    @FindBy(css = WEBELEMENT_BUTTON_INCREASE_NUM_CHILDREN)
    public WebElement increaseNumChildren;

    @FindBy(xpath = WEBELEMENT_LINK_TRAVEL_WITH_CHILD)
    public  WebElement linkTravelWithChild;

    @FindBy(css = WEBELEMENT_INPUT_LEAVING_FROM)
    public WebElement inputLeavingFrom;

    @FindBy(css = WEBELEMENT_INPUT_GOING_TO)
    public WebElement inputGoingTo;

    @FindBy(css = WEBELEMENT_BUTTON_DEPARTING)
    public WebElement buttonDeparting;

    @FindBy(css = WEBELEMENT_BUTTON_RETURNING)
    public WebElement buttonReturning;

    @FindBy(css = WEBELEMENT_SELECT_DEPARTING_DATE)
    public WebElement selectDepartingDate;

    @FindBy(css = WEBELEMENT_SELECT_RETURNING_DATE)
    public WebElement selectReturningDate;

    @FindBy(css = WEBELEMENT_BUTTON_SUBMIT_FLIGHT_SEARCH)
    public WebElement buttonSubmitFlightSearch;

    public void navigateToFlightsPage() throws AWTException {
        pressEscapeKey();
        clickElement(tabFlights);
    }

    public void verifyAirlineAgeRules(){
        clickElement(dropdownNumTravelers);
        actionClassClickOnElement(increaseNumChildren);
        clickElement(linkAirlineAgeRules);
    }

    public void searchForFlight(){
        sendKeysToElement(inputLeavingFrom, "Washington DC");
        sendKeysToElement(inputGoingTo, "Tempa, FL");

//        clickElement(buttonDeparting);
//        clickElement(selectDepartingDate);
//        clickElement(buttonReturning);
//        clickElement(selectReturningDate);
        clickElement(buttonSubmitFlightSearch);

    }

}

