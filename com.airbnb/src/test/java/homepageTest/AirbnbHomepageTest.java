package homepageTest;

import adventuresPage.AirbnbAdventuresPage;
import becomeAHostPage.AirbnbBecomeAHostPage;
import common.BaseAPI;
import homepage.AirbnbHomepage;
import onlineExperiencesPage.AirbnbOnlineExperiencesPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class AirbnbHomepageTest extends BaseAPI {

    AirbnbHomepage airbnbHomepage;
    AirbnbOnlineExperiencesPage airbnbOnlineExperiencesPage;
    AirbnbBecomeAHostPage airbnbBecomeAHostPage;
    AirbnbAdventuresPage airbnbAdventuresPage;

    /**
     * Test#1
     * 1. Navigate to AirBnB Home Page.
     * 2. Click a tab to navigate to 'Online Experiences' Page.
     * 3. Verify that the 'Online Experiences' is returned and the correct header is displayed.
     */

    @Test(enabled = false, groups = "sanity")
    public void testNavigateToOnlineExperiencesPage() {
        airbnbHomepage = new AirbnbHomepage();
        airbnbOnlineExperiencesPage = airbnbHomepage.navigateToOnlineExperiencesPage();
        Assert.assertTrue(airbnbOnlineExperiencesPage.headerOnlineExperiencesPage.isDisplayed());
    }

    /**
     * Test#2
     * 1. Navigate to AirBnB Home Page.
     * 2. Click a tab to navigate to 'Become a Host' Page.
     * 3. Verify that the 'Become a Host' Page is returned and the correct header is displayed.
     */

    @Test(enabled = false, groups = "sanity")
    public void testNavigateToBecomeAHostPage() {
        airbnbHomepage = new AirbnbHomepage();
        airbnbBecomeAHostPage = airbnbHomepage.navigateToBecomeAHostPage();
        Assert.assertTrue(airbnbBecomeAHostPage.headerBecomeAHost.isDisplayed());
    }
    /**
     * Test#3
     * 1. Navigate to AirBnB Home Page.
     * 2. Click a tab to navigate to 'Adventures' Page.
     * 3. Verify that the 'Adventures' Page is returned and the correct header is displayed.
     */

    @Test(enabled = false, groups = "sanity")
    public void testNavigateToAdventuresPage() {
        airbnbHomepage = new AirbnbHomepage();
        airbnbAdventuresPage = airbnbHomepage.navigateToAdventuresPage();
        Assert.assertTrue(airbnbAdventuresPage.headerAdventures.isDisplayed());

    }
    /**
     * Test#4
     * 1. Navigate to AirBnB Home Page.
     * 2. Enter 'Los Angeles' in 'Where are you going field'.
     * 3. Click 'check in' and then 'I'm flexible'.
     * 4. Click 'Add guests' and increase 'Adult' by one.
     * 5. Click 'Search' button.
     * 3. Verify that the correct title is displayed.
     */

    @Test(enabled = false, groups = "sanity")
    public void testTripSearch() {
        airbnbHomepage = new AirbnbHomepage();
        airbnbHomepage.doFlexibleSearch();
        String actualTitle = driver.getTitle();
        String expectedTitle = "Vacation Rentals, Homes, Hotels, Experiences & More - Airbnb";
        Assert.assertEquals(actualTitle, expectedTitle, "Title is incorrect.");
    }

    /**
     * Test#5
     * 1. Navigate to AirBnB Home Page.
     * 2. Enter 'Los Angeles' in 'Where are you going field'.
     * 3. Click 'check in' and then 'I'm flexible'.
     * 4. Click 'Add guests' and increase 'Adult' by one.
     * 5. Click 'Search' button.
     * 6. Verify that the correct trip details are displayed.
     */

    @Test(enabled = false, groups = "sanity")
    public void testFlexibleSearchDetails() {
        airbnbHomepage = new AirbnbHomepage();
        airbnbHomepage.doFlexibleSearch();
        Assert.assertTrue(airbnbHomepage.expectedVacationLocation.isDisplayed(), "Incorrect trip details are displayed.");
    }

    /**
     * Test#6
     * 1. Navigate to AirBnB Home Page.
     * 2. Click on the Globe Icon to display all available languages.
     * 3. Verify that the correct number of languages are displayed.
     */

    @Test(enabled = false, groups = "sanity")
    public void testNumberOfLanguages() {
        airbnbHomepage = new AirbnbHomepage();
        airbnbHomepage.languageIcon.click();
        int actualNumOfLanguages = airbnbHomepage.listOfLanguages.size();
        int expectedNumOfLanguages = 91;
        Assert.assertEquals(actualNumOfLanguages, expectedNumOfLanguages, "The number of languages is incorrect.");
    }

    /**
     * Test#7
     * 1. Navigate to AirBnB Home Page.
     * 2. Click on the Globe Icon to display all available languages.
     * 3. Verify that the correct languages are displayed.
     */

    @Test(enabled = false, groups = "smoke")
    public void testLanguages() throws IOException {
        airbnbHomepage = new AirbnbHomepage();
        Assert.assertTrue(airbnbHomepage.verifyLanguages(), "The languages are displayed incorrectly.");
    }

    /**
     * Test#8
     * 1. Navigate to AirBnB Home Page.
     * 2. Click on the Globe Icon.
     * 4. Click on 'Currency' button.
     * 3. Verify that the correct number of currency options is displayed.
     */

    @Test(groups = "regression")
    public void testNumOfCurrency(){
        airbnbHomepage = new AirbnbHomepage();
        Assert.assertTrue(airbnbHomepage.verifyNumberOfCurrency(), "The number of currency options is incorrect.");
    }

    /**
     * Test#9
     * 1. Navigate to AirBnB Home Page.
     * 2. Click on the Globe Icon.
     * 4. Click on 'Currency' button.
     * 3. Verify that the correct currency options are displayed.
     */

    @Test(groups = "smoke")
    public void testCurrencyOptions() throws Exception {
        airbnbHomepage = new AirbnbHomepage();
        Assert.assertTrue(airbnbHomepage.verifyCurrencyOptions(), "The currency options are displayed incorrectly.");
    }

    /**
     * Test#10
     * 1. Navigate to AirBnB Home Page.
     * 2. Enter 'Los Angeles' in 'Where are you going field'.
     * 3. Click 'check in' and enter a date.
     * 4. Enter 'check out' date.
     * 5. Click 'Add guests' and increase 'Adult' by one.
     * 6. Click 'Search' button.
     * 7. Verify that the correct trip details are displayed.
     */

    @Test(enabled = false, groups = "sanity")
    public void testPickDateSearch() {
        airbnbHomepage = new AirbnbHomepage();
        airbnbHomepage.pickDatesSearch();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(airbnbHomepage.expectedVacationLocation.isDisplayed());
        softAssert.assertTrue(airbnbHomepage.expectedVacationDate.isDisplayed());
        softAssert.assertTrue(airbnbHomepage.expectedNumOfGuests.isDisplayed());
        softAssert.assertAll();
    }

    /**
     * Test#11
     * 1. Navigate to AirBnB Home Page.
     * 2. Click Main menu button.
     * 3. Select login form the menu.
     * 4. Enter incorrect phone number into input field.
     * 5. Click 'sign in'.
     * 6. Verify that the sign in was not allowed and correct error message is displayed.
     */

    @Test(enabled = false, groups = "sanity")
    public void testInvalidPhoneNumLogin() throws IOException {
        airbnbHomepage = new AirbnbHomepage();
        airbnbHomepage.invalidPhoneNumLogin();
        String expectedErrorMessage = airbnbHomepage.getInvalidPhoneErrorMessage();
        Assert.assertEquals(airbnbHomepage.invPhoneErrorMessage.getText(), expectedErrorMessage, "The message is incorrect.");

    }

    /**
     * Test#12
     * 1. Navigate to AirBnB Home Page.
     * 2. Verify that all titles of the links in 'Inspiration Getaways' section are displayed correctly.
     */

    @Test(enabled = false, groups = "sanity")
    public void testInspirationDestinationOptions() throws IOException {
        airbnbHomepage = new AirbnbHomepage();
        Assert.assertTrue(airbnbHomepage.verifyInspirationGetaways(), "One or more Destination Values are incorrect.");
    }

    /**
     * Test#13
     * 1. Navigate to AirBnB Home Page.
     * 2. Verify that all the links in 'Explore Nearby Destination' section are valid.
     */

    @Test(enabled = false, groups = "sanity")
    public void testLinksExploreNearbyDest() {
        airbnbHomepage = new AirbnbHomepage();
        Assert.assertTrue(airbnbHomepage.verifyLinksExploreNearbyDest(), "Explore Nearby Destination section contains one or more broken links.");
    }

    /**
     * Test#14
     * 1. Navigate to AirBnB Home Page.
     * 2. Verify that all the links in 'Live Anywhere' section are valid.
     */

    @Test(enabled = false, groups = "sanity")
    public void testLinksLiveAnywhere() {
        airbnbHomepage = new AirbnbHomepage();
        Assert.assertTrue(airbnbHomepage.verifyLinksLiveAnywhere(), "Live Anywhere section contains one or more broken links.");
    }
}
