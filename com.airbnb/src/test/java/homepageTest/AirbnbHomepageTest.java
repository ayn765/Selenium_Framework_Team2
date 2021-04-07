package homepageTest;

import adventuresPage.AirbnbAdventuresPage;
import becomeAHostPage.AirbnbBecomeAHostPage;
import common.BaseAPI;
import homepage.AirbnbHomepage;
import onlineExperiencesPage.AirbnbOnlineExperiencesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AirbnbHomepageTest extends BaseAPI {

    //    AirbnbHomepage airbnbHomepage;
    AirbnbOnlineExperiencesPage airbnbOnlineExperiencesPage;
    AirbnbBecomeAHostPage airbnbBecomeAHostPage;
    AirbnbAdventuresPage airbnbAdventuresPage;

    @Test(enabled = false)
    public void testNavigateToOnlineExperiencesPage() {
        AirbnbHomepage airbnbHomepage = new AirbnbHomepage();
        airbnbOnlineExperiencesPage = airbnbHomepage.navigateToOnlineExperiencesPage();
        Assert.assertTrue(airbnbOnlineExperiencesPage.headerOnlineExperiencesPage.isDisplayed());
    }

    @Test(enabled = false)
    public void testNavigateToBecomeAHostPage() {
        AirbnbHomepage airbnbHomepage = new AirbnbHomepage();
        airbnbBecomeAHostPage = airbnbHomepage.navigateToBecomeAHostPage();
        Assert.assertTrue(airbnbBecomeAHostPage.headerBecomeAHost.isDisplayed());
    }

    @Test(enabled = false)
    public void testNavigateToAdventuresPage() {
        AirbnbHomepage airbnbHomepage = new AirbnbHomepage();
        airbnbAdventuresPage = airbnbHomepage.navigateToAdventuresPage();
        Assert.assertTrue(airbnbAdventuresPage.headerAdventures.isDisplayed());

    }

    @Test(enabled = false)
    public void testTripSearch() {
        AirbnbHomepage airbnbHomepage = new AirbnbHomepage();
        airbnbHomepage.sendKeysToDestination("New York");
        airbnbHomepage.doFlexibleSearch();
        String actualTitle = driver.getTitle();
        String expectedTitle = "Vacation Rentals, Homes, Hotels, Experiences & More - Airbnb";
        Assert.assertEquals(actualTitle, expectedTitle, "Title is incorrect.");
    }

    @Test(enabled = false)
    public void testFlexibleSearchDetails() {
        AirbnbHomepage airbnbHomepage = new AirbnbHomepage();
        airbnbHomepage.doFlexibleSearch();
        Assert.assertTrue(airbnbHomepage.expectedVacationLocation.isDisplayed());
    }

    @Test(enabled = false)
    public void testNumberOfLanguages() {
        AirbnbHomepage airbnbHomepage = new AirbnbHomepage();
        airbnbHomepage.languageIcon.click();
        int actualNumOfLanguages = airbnbHomepage.listOfLanguages.size();
        int expectedNumOfLanguages = 91;
        Assert.assertEquals(actualNumOfLanguages, expectedNumOfLanguages, "The number of languages is incorrect.");
    }

    @Test(enabled = false)
    public void testLanguages() throws IOException {
        AirbnbHomepage airbnbHomepage = new AirbnbHomepage();
        Assert.assertTrue(airbnbHomepage.verifyLanguages(), "The languages are displayed incorrectly.");
    }

    @Test(enabled = false)
    public void testPickDateSearch() {
        AirbnbHomepage airbnbHomepage = new AirbnbHomepage();
        airbnbHomepage.pickDatesSearch();
        Assert.assertTrue(airbnbHomepage.expectedVacationLocation.isDisplayed());
        Assert.assertTrue(airbnbHomepage.expectedVacationDate.isDisplayed());
        Assert.assertTrue(airbnbHomepage.expectedNumOfGuests.isDisplayed());

    }

    @Test(enabled = true)
    public void testInvalidPhoneNumLogin() throws IOException {
        AirbnbHomepage airbnbHomepage = new AirbnbHomepage();
        airbnbHomepage.invalidPhoneNumLogin();
        String expectedErrorMessage = airbnbHomepage.getInvalidPhoneErrorMessage();
        Assert.assertEquals(airbnbHomepage.invPhoneErrorMessage.getText(),expectedErrorMessage, "The message is incorrect.");

    }
    @Test(enabled = false)
    public void testInspirationDestinationOptions() throws IOException {
        AirbnbHomepage airbnbHomepage = new AirbnbHomepage();
        Assert.assertTrue(airbnbHomepage.verifyInspirationGetaways(), "One or more Destination Values are incorrect.");
    }
    @Test(enabled = false)
    public void testLinksExploreNearbyDest(){
        AirbnbHomepage airbnbHomepage = new AirbnbHomepage();
        Assert.assertTrue(airbnbHomepage.verifyLinksExploreNearbyDest(), "Explore Nearby Destination section contains one or more broken links.");
    }
    @Test(enabled = false)
    public void testLinksLiveAnywhere(){
        AirbnbHomepage airbnbHomepage = new AirbnbHomepage();
        Assert.assertTrue(airbnbHomepage.verifyLinksLiveAnywhere(), "Live Anywhere section contains one or more broken links.");
    }
}
