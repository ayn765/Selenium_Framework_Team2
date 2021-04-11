package flightsPageTest;

import common.BaseAPI;
import flightsPage.ExpediaFlightsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class ExpediaFlightsPageTest extends BaseAPI {

    ExpediaFlightsPage expediaFlightsPage;

    @Test(enabled = false)
    public void testAirlineAgeRules() throws AWTException {
        expediaFlightsPage = new ExpediaFlightsPage();
        expediaFlightsPage.navigateToFlightsPage();
        expediaFlightsPage.verifyAirlineAgeRules();
        switchToNewWindow();
        Assert.assertTrue(expediaFlightsPage.linkTravelWithChild.isDisplayed(), "The Airline Age Rules Page is not properly displayed.");
    }

    @Test(enabled = false)
    public void testSearchFlight() throws AWTException {
        expediaFlightsPage = new ExpediaFlightsPage();
        expediaFlightsPage.navigateToFlightsPage();
        expediaFlightsPage.searchForFlight();
        waitUntilWebElementVisible(expediaFlightsPage.messageCovid);
        Assert.assertTrue(expediaFlightsPage.messageCovid.isDisplayed(), "The search flight test failed.");
    }

    @Test(enabled = false)
    public void testCountyCodeOptions() throws AWTException, IOException {
        expediaFlightsPage = new ExpediaFlightsPage();
        expediaFlightsPage.navigateToFlightsPage();
        Assert.assertTrue(expediaFlightsPage.verifyCountryCodeOptions(), "The Country Code Options are displayed incorrectly.");
    }

    @Test(enabled = false)
    public void testGetAppInvalidPhoneNum() throws Exception {
        expediaFlightsPage = new ExpediaFlightsPage();
        expediaFlightsPage.navigateToFlightsPage();
        expediaFlightsPage.sendInvalidPhoneNumToGetApp();
        Assert.assertTrue(expediaFlightsPage.messageErrorPhoneNum.isDisplayed(), "The Error Message is not displayed or displayed incorrectly.");
    }

    @Test(enabled = false)
    public void testLinksFindNextDest() throws Exception {
        expediaFlightsPage = new ExpediaFlightsPage();
        expediaFlightsPage.navigateToFlightsPage();
        Assert.assertTrue(expediaFlightsPage.verifyLinksTitlesFindYourNextDest(), "The Titles of one or more links are incorrect.");
    }

    @Test(enabled = false)
    public void testLinksFindYourNextDest() {
        expediaFlightsPage = new ExpediaFlightsPage();
        Assert.assertTrue(expediaFlightsPage.verifyLinksFindYourNextDest(), "One or more links are broken.");
    }

    @Test
    public void testsLinksTitlesSwitchRoutine() throws Exception {
        expediaFlightsPage = new ExpediaFlightsPage();
        expediaFlightsPage.navigateToFlightsPage();
        Assert.assertTrue(expediaFlightsPage.verifyLinksTitlesSwitchRoutine(), "Titles of one or more links are incorrect.");
    }

//    @Test
//    public void test() throws IOException {
//        expediaFlightsPage = new ExpediaFlightsPage();
//        expediaFlightsPage.test();
//    }


}
