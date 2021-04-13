package flightsPage;

import common.BaseAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import signIn.ExpediaSignInPage;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static flightsPage.ExpediaFlightsPageLocators.*;

public class ExpediaFlightsPage extends BaseAPI {

    public ExpediaFlightsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = WEBELEMTET_TAB_FLIGHTS)
    public WebElement tabFlights;

    @FindBy(xpath = WEBELEMTET_TAB_ONEWAY)
    public WebElement tabOneway;

    @FindBy(css = WEBELEMENT_DROPDOWN_NUM_TRAVELERS)
    public WebElement dropdownNumTravelers;

    @FindBy(css = WEBELEMENT_LINK_AIRLINE_AGE_RULES)
    public WebElement linkAirlineAgeRules;

    @FindBy(css = WEBELEMENT_BUTTON_INCREASE_NUM_CHILDREN)
    public WebElement increaseNumChildren;

    @FindBy(xpath = WEBELEMENT_LINK_TRAVEL_WITH_CHILD)
    public WebElement linkTravelWithChild;

    @FindBy(css = WEBELEMENT_INPUT_LEAVING_FROM)
    public WebElement inputLeavingFrom;

    @FindBy(css = WEBELEMENT_INPUT_GOING_TO)
    public WebElement inputGoingTo;

    @FindBy(xpath = WEBELEMENT_GOING_TO_AIRPORT_SELECTION)
    public WebElement goingToAirportSelection;

    @FindBy(css = WEBELEMENT_LEAVING_AIRPORT_SELECTION)
    public WebElement leavingAirportSelection;

    @FindBy(css = WEBELEMENT_BUTTON_DEPARTING)
    public WebElement buttonDeparting;

    @FindBy(css = WEBELEMENT_BUTTON_RETURNING)
    public WebElement buttonReturning;

    @FindBy(xpath = WEBELEMENT_SELECT_DEPARTING_DATE)
    public WebElement selectDepartingDate;

    @FindBy(xpath = WEBELEMENT_SELECT_RETURNING_DATE)
    public WebElement selectReturningDate;

    @FindBy(xpath = WEBELEMENT_BUTTON_DATE_DONE)
    public WebElement buttonDateDone;

    @FindBy(css = WEBELEMENT_BUTTON_SUBMIT_FLIGHT_SEARCH)
    public WebElement buttonSubmitFlightSearch;

    @FindBy(css = WEBELEMENT_CHECKBOX_NON_STOP)
    public WebElement checkboxNonStop;

    @FindBy(css = WEBELEMENT_BUTTON_NON_STOP)
    public WebElement buttonNonStop;

    @FindBy(css = WEBELEMENT_MESSAGE_COVID)
    public WebElement messageCovid;

    @FindBy(css = WEBELEMENT_BUTTON_CHANGE_TRIP)
    public WebElement buttonChangeTrip;

    @FindBy(css = WEBELEMENT_CHAT_WITH_VIRTUAL_AGENT)
    public WebElement chatWithVirtualAgent;

    @FindBy(css = WEBELEMENT_BUTTON_USE_CREDIT_OR_COUPON)
    public WebElement buttonUseCreditOrCoupon;

    @FindBy(css = WEBELEMENTS_SELECT_COUNTRY_CODE)
    public List<WebElement> selectCountryCode;

    @FindBy(css = WEBELEMENT_INPUT_PHONE_NUM)
    public WebElement inputPhoneNum;

    @FindBy(css = WEBELEMENT_BUTTON_GET_APP)
    public WebElement buttonGetApp;

    @FindBy(css = WEBELEMENT_MESSAGE_ERROR_PHONE_NUM)
    public WebElement messageErrorPhoneNum;

    @FindBy(css = WEBELEMENTS_LINKS_FIND_YOUR_NEXT_DEST)
    public List<WebElement> linksFindYourNextDest;

    @FindBy(css = WEBELEMENTS_LINKS_SWITCH_ROUTINE)
    public List<WebElement> linksSwitchRoutine;

    @FindBy(css = WEBELEMENT_BUTTON_HELP)
    public WebElement buttonHelp;

    @FindBy(css = WEBELEMENTS_DROPDOWN_FLIGHT_CLASS)
    public List<WebElement> dropDownFlightClass;

    @FindBy(css = WEBELEMENT_BUTTON_FLIGHT_CLASS)
    public WebElement buttonFlightClass;

    @FindBy(css = WEBELEMENT_LINKS_FOOTER)
    public List<WebElement> linksFooter;


    public void navigateToFlightsPage() throws AWTException {
        pressEscapeKey();
        clickElement(tabFlights);
    }

    public void onewaySearch(){
        clickElement(tabOneway);
        sendKeysToElement(inputLeavingFrom, "Washington DC");
        clickElement(leavingAirportSelection);
        sendKeysToElement(inputGoingTo, "Tampa, FL");
        clickElement(goingToAirportSelection);
        clickElement(buttonDeparting);
        clickElement(selectDepartingDate);
        clickElement(buttonDateDone);
        clickElement(buttonSubmitFlightSearch);
        waitUntilWebElementVisible(checkboxNonStop);
        checkboxNonStop.click();
    }

    public void verifyAirlineAgeRules() {
        clickElement(dropdownNumTravelers);
        actionClassClickOnElement(increaseNumChildren);
        clickElement(linkAirlineAgeRules);
    }

    public void searchForFlight() {
        sendKeysToElement(inputLeavingFrom, "Washington DC");
        clickElement(leavingAirportSelection);
        sendKeysToElement(inputGoingTo, "Tampa, FL");
        clickElement(goingToAirportSelection);
        clickElement(buttonSubmitFlightSearch);
    }

    public void changeOrCancelTrip(){
        clickElement(buttonChangeTrip);
    }

    public ExpediaSignInPage useCreditOrCoupon(){
        clickElement(buttonUseCreditOrCoupon);
        return new ExpediaSignInPage();
    }

    public boolean verifyCountryCodeOptions() throws IOException {
        return compareListWebElementsToExcelDoc(selectCountryCode, System.getProperty("user.dir") + "/src/test/resources/ExpediaTestData.xlsx", "CountryCodes");
    }

    public void sendInvalidPhoneNumToGetApp() {
        sendKeysToElement(inputPhoneNum, "ase678");
        clickElement(buttonGetApp);
        waitUntilWebElementVisible(messageErrorPhoneNum);
    }

    public boolean verifyLinksFindYourNextDest() {
        boolean flag = verifyLinks(linksFindYourNextDest, "href");
        return flag;
    }

    public boolean verifyLinksTitlesSwitchRoutine() throws IOException {
        boolean flag = getUrlsAndTitlesFromListWebElementAndCompareToExcelDoc(linksSwitchRoutine, "href", System.getProperty("user.dir") + "/src/test/resources/ExpediaTestData.xlsx", "SwitchRoutine");
        return flag;
    }

    public boolean verifyLinksTitlesFindYourNextDest() throws IOException {
        Iterator<WebElement> iterator = linksFindYourNextDest.iterator();
        String url;
        List<String> links = new ArrayList<>();
        ArrayList<String> titles = new ArrayList<>();
        while (iterator.hasNext()) {
            url = iterator.next().getAttribute("href");
            links.add(url);
        }
        for (String x : links) {
            driver.navigate().to(x);
            String pageTitle = driver.getTitle();
            titles.add(pageTitle);
        }

        boolean flag = compareListStringsToExcelDoc(titles, System.getProperty("user.dir") + "/src/test/resources/ExpediaTestData.xlsx", "YourNextDestTitles");
        return flag;
    }

    public void navigateToHelpChat(){
        driver.switchTo().frame(3);
        clickElement(buttonHelp);
    }

    public boolean verifyDropdownFlightClass() throws IOException {
        clickElement(buttonFlightClass);
        return compareListWebElementsToExcelDoc(dropDownFlightClass, System.getProperty("user.dir") + "/src/test/resources/ExpediaTestData.xlsx", "FlightClass");
    }

    public boolean verifyFooterLinks(){
        return verifyLinks(linksFooter, "href");
    }

//    public void verifyLinksTitlesFindYourNextDest() {
//
//        for (WebElement x : linksFindYourNextDest) {
//            waitUntilWebElementsArePresent();
//            String linkOption;
//            try {
//                waitUntilWebElementVisible(x);
//                jsScrollIntoView(x);
//                linkOption = x.getAttribute("href");
//                System.out.println(linkOption);
//                driver.navigate().to(linkOption);
//                System.out.println(driver.getTitle());
//                driver.navigate().back();
//                pressEscapeKey();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//    }
}



