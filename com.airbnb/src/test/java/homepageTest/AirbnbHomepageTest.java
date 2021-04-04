package homepageTest;

import adventuresPage.AirbnbAdventuresPage;
import becomeAHostPage.AirbnbBecomeAHostPage;
import common.BaseAPI;
import homepage.AirbnbHomepage;
import io.cucumber.java.bs.A;
import onlineExperiencesPage.AirbnbOnlineExperiencesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AirbnbHomepageTest extends BaseAPI {

//    AirbnbHomepage airbnbHomepage;
    AirbnbOnlineExperiencesPage airbnbOnlineExperiencesPage;
    AirbnbBecomeAHostPage airbnbBecomeAHostPage;
    AirbnbAdventuresPage airbnbAdventuresPage;

    @Test(enabled = false)
    public void testNavigateToOnlineExperiencesPage(){
        AirbnbHomepage airbnbHomepage = new AirbnbHomepage();
        airbnbOnlineExperiencesPage = airbnbHomepage.navigateToOnlineExperiencesPage();
        Assert.assertTrue(airbnbOnlineExperiencesPage.headerOnlineExperiencesPage.isDisplayed());
    }

    @Test (enabled = false)
    public void testNavigateToBecomeAHostPage(){
        AirbnbHomepage airbnbHomepage = new AirbnbHomepage();
        airbnbBecomeAHostPage = airbnbHomepage.navigateToBecomeAHostPage();
        Assert.assertTrue(airbnbBecomeAHostPage.headerBecomeAHost.isDisplayed());
    }

    @Test
    public void testNavigateToAdventuresPage(){
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

    @Test (enabled = false)
    public void testFlexibleSearchDetails() {
        AirbnbHomepage airbnbHomepage = new AirbnbHomepage();
        airbnbHomepage.doFlexibleSearch();
        boolean isExpectedLocationDisplayed = airbnbHomepage.expectedVacationLocation.isDisplayed();
        Assert.assertTrue(isExpectedLocationDisplayed);
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
    public void testLanguages() {
        AirbnbHomepage airbnbHomepage = new AirbnbHomepage();
        airbnbHomepage.verifyLanguages();
    }

    @Test (enabled = false)
    public void testPickDateSearch() {
        AirbnbHomepage airbnbHomepage = new AirbnbHomepage();
        airbnbHomepage.pickDatesSearch();
        boolean isExpectedLocationDisplayed = airbnbHomepage.expectedVacationLocation.isDisplayed();
        Assert.assertTrue(isExpectedLocationDisplayed);
        boolean isVacationDateDisplayed = airbnbHomepage.expectedVacationDate.isDisplayed();
        Assert.assertTrue(isVacationDateDisplayed);
        boolean isNumOfGuestsDisplayed = airbnbHomepage.expectedNumOfGuests.isDisplayed();
        Assert.assertTrue(isNumOfGuestsDisplayed);

    }
}
