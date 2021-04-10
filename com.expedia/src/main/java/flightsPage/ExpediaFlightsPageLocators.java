package flightsPage;

import common.BaseAPI;

public class ExpediaFlightsPageLocators extends BaseAPI {

    public static final String WEBELEMTET_TAB_FLIGHTS = "//*[@id='uitk-tabs-button-container']/li[2]/a/span";
    public static final String WEBELEMENT_DROPDOWN_NUM_TRAVELERS = "#adaptive-menu > a";
    public static final String WEBELEMENT_LINK_AIRLINE_AGE_RULES = "#airline-age-rules";
    public static final String WEBELEMENT_BUTTON_INCREASE_NUM_CHILDREN = "div.uitk-spacing-padding-blockstart-unset > div:nth-child(2) > div > button:nth-child(3)";
    public static final String WEBELEMENT_LINK_TRAVEL_WITH_CHILD = "//strong[contains(text(),'Infant, child, and senior discounts')]";
    public static final String WEBELEMENT_INPUT_LEAVING_FROM = "button[data-stid=location-field-leg1-origin-menu-trigger]";
    public static final String WEBELEMENT_INPUT_GOING_TO = "button[data-stid=location-field-leg1-destination-menu-trigger]";
    public static final String WEBELEMENT_BUTTON_DEPARTING = "#d1-btn";
    public static final String WEBELEMENT_SELECT_DEPARTING_DATE = "button[aria-label='May 14, 2021 selected, current check in date. -. Price not available']";
    public static final String WEBELEMENT_BUTTON_RETURNING = "#d2-btn";
    public static final String WEBELEMENT_SELECT_RETURNING_DATE = "button[aria-label='May 21, 2021.']";
    public static final String WEBELEMENT_BUTTON_SUBMIT_FLIGHT_SEARCH = ".uitk-flex-item>button[type=submit]";


}
