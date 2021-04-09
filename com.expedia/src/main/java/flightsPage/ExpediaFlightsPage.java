package flightsPage;

import common.BaseAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static flightsPage.ExpediaFlightsPageLocators.*;

public class ExpediaFlightsPage extends BaseAPI {

    public ExpediaFlightsPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = WEBELEMENT_DROPDOWN_NUM_TRAVELERS)
    public WebElement dropdownNumTravelers;

    @FindBy(css = WEBELEMENT_LINK_AIRLINE_AGE_RULES)
    public WebElement linkAirlineAgeRules;



    public void verifyAirlineAgeRules(){
        javaScriptExecutorClickOnElement(dropdownNumTravelers);
        clickElement(linkAirlineAgeRules);
        System.out.println(driver.getWindowHandles());

    }

}

