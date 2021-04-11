package flightsPage;

import common.BaseAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    @FindBy(css = WEBELEMENT_SELECT_DEPARTING_DATE)
    public WebElement selectDepartingDate;

    @FindBy(css = WEBELEMENT_SELECT_RETURNING_DATE)
    public WebElement selectReturningDate;

    @FindBy(css = WEBELEMENT_BUTTON_SUBMIT_FLIGHT_SEARCH)
    public WebElement buttonSubmitFlightSearch;

    @FindBy(css = WEBELEMENT_MESSAGE_COVID)
    public WebElement messageCovid;

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


    public void navigateToFlightsPage() throws AWTException {
        pressEscapeKey();
        clickElement(tabFlights);
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

    public boolean verifyCountryCodeOptions() throws IOException {
        boolean flag = compareListWebElementsToExcelDoc(selectCountryCode, System.getProperty("user.dir") + "/src/test/resources/ExpediaTestData.xlsx", "CountryCodes");
        return flag;
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



