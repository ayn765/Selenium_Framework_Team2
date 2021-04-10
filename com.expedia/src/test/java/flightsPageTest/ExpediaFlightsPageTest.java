package flightsPageTest;

import common.BaseAPI;
import flightsPage.ExpediaFlightsPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class ExpediaFlightsPageTest extends BaseAPI {

    ExpediaFlightsPage expediaFlightsPage;

    @Test(enabled = false)
    public void testAirlineAgeRules() throws AWTException {
        expediaFlightsPage = new ExpediaFlightsPage();
        expediaFlightsPage.navigateToFlightsPage();
        expediaFlightsPage.verifyAirlineAgeRules();
        switchToNewWindow();
        Assert.assertTrue(expediaFlightsPage.linkTravelWithChild.isDisplayed());
    }

    @Test
    public void testSearchFlight() throws AWTException {
        expediaFlightsPage = new ExpediaFlightsPage();
        expediaFlightsPage.navigateToFlightsPage();
        expediaFlightsPage.searchForFlight();


    }
}
