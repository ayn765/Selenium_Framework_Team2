package flightsPageTest;

import common.BaseAPI;
import flightsPage.ExpediaFlightsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import signIn.ExpediaSignInPage;

import java.awt.*;
import java.io.IOException;

public class ExpediaFlightsPageTest extends BaseAPI {

    ExpediaFlightsPage expediaFlightsPage;
    ExpediaSignInPage expediaSignInPage;

    @Test(enabled = false, groups = "smoke")
    public void testAirlineAgeRules() throws AWTException {
        expediaFlightsPage = new ExpediaFlightsPage();
        expediaFlightsPage.navigateToFlightsPage();
        expediaFlightsPage.verifyAirlineAgeRules();
        switchToNewWindow();
        Assert.assertTrue(expediaFlightsPage.linkTravelWithChild.isDisplayed(), "The Airline Age Rules Page is not properly displayed.");
    }

    @Test(enabled = false, groups = "smoke")
    public void testOnewaySearch() throws Exception{
        expediaFlightsPage = new ExpediaFlightsPage();
        expediaFlightsPage.navigateToFlightsPage();
        expediaFlightsPage.onewaySearch();
        waitUntilWebElementVisible(expediaFlightsPage.buttonNonStop);
        Assert.assertTrue(expediaFlightsPage.buttonNonStop.isDisplayed(), "One way flight search failed.");
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
    public void testChangeOrCancelTrip() throws Exception{
        expediaFlightsPage = new ExpediaFlightsPage();
        expediaFlightsPage.navigateToFlightsPage();
        expediaFlightsPage.changeOrCancelTrip();
        driver.switchTo().frame(3);
        waitUntilWebElementVisible(expediaFlightsPage.chatWithVirtualAgent);
        Assert.assertTrue(expediaFlightsPage.chatWithVirtualAgent.isDisplayed(),"Change or Cancel trip doesn't invoke the Virtual Chat.");
    }

    @Test(enabled = false)
    public void testUseCreditOrCoupon() throws Exception{
        expediaFlightsPage = new ExpediaFlightsPage();
        expediaFlightsPage.navigateToFlightsPage();
        expediaSignInPage = expediaFlightsPage.useCreditOrCoupon();
        Assert.assertTrue(expediaSignInPage.headerSignIn.isDisplayed());
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

    @Test(enabled = false)
    public void testsLinksTitlesSwitchRoutine() throws Exception {
        expediaFlightsPage = new ExpediaFlightsPage();
        expediaFlightsPage.navigateToFlightsPage();
        Assert.assertTrue(expediaFlightsPage.verifyLinksTitlesSwitchRoutine(), "Titles of one or more links are incorrect.");
    }

    @Test(enabled = false)
    public void testHelpChat() throws Exception {
        expediaFlightsPage = new ExpediaFlightsPage();
        expediaFlightsPage.navigateToFlightsPage();
        expediaFlightsPage.navigateToHelpChat();
        waitUntilWebElementVisible(expediaFlightsPage.chatWithVirtualAgent);
        Assert.assertTrue(expediaFlightsPage.chatWithVirtualAgent.isDisplayed(), "The help chat test failed.");
    }
    @Test(enabled = false)
    public void testDropDownFlightClass() throws Exception {
        expediaFlightsPage = new ExpediaFlightsPage();
        expediaFlightsPage.navigateToFlightsPage();
        Assert.assertTrue(expediaFlightsPage.verifyDropdownFlightClass(), "The Flight Class Dropdown is not displayed correctly.");
    }

    @Test(enabled = false, groups = "regression")
    public void testFooterLinks() throws Exception{
        expediaFlightsPage = new ExpediaFlightsPage();
        expediaFlightsPage.navigateToFlightsPage();
        Assert.assertTrue(expediaFlightsPage.verifyFooterLinks());
    }

    @Test(groups = "smoke", enabled = false)
    public void testTitleExpediaFlights() throws AWTException {
        expediaFlightsPage = new ExpediaFlightsPage();
        expediaFlightsPage.navigateToFlightsPage();
        String expectedTitle = "Expedia Flights";
        Assert.assertEquals(driver.getTitle(), expectedTitle, "Titles do not match");
    }
}
