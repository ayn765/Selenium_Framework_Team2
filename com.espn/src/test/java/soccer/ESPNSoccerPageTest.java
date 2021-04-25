package soccer;

import common.BaseAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ESPNSoccerPageTest extends BaseAPI {


    ESPNSoccerPage espnSoccerPage;


    /**
     * Test#1
     * 1. Navigate to ESPN Soccer webpage.
     * 2. Click on each tab and validate the title of each page.
     */
    @Test(groups = "regression")
    public void testTabsTopPagesTitles() throws IOException {
        espnSoccerPage = new ESPNSoccerPage();
        Assert.assertTrue(espnSoccerPage.verifyTabsTopPagesTitles(), "The titles of the pages are incorrect.");
    }

    /**
     * Test#2
     * 1. Navigate to ESPN Soccer webpage.
     * 2. Validate that all link on the top tabs are valid.
     */
    @Test(groups = "regression")
    public void testTabsTopLinks() throws IOException {
        espnSoccerPage = new ESPNSoccerPage();
        Assert.assertTrue(espnSoccerPage.verifyTabTopLinksValid(), "One or more links are broken.");
    }

    /**
     * Test#3
     * 1. Navigate to ESPN Soccer webpage.
     * 2. Validate that the number of the links on top tabs are correct.
     */
    @Test(groups = "regression")
    public void testTabsTopNumberLinks() throws IOException {
        espnSoccerPage = new ESPNSoccerPage();
        int expectedNumOfLinks = 9;
        Assert.assertEquals(espnSoccerPage.getNumberOfLinksTopTabs(), expectedNumOfLinks, "The number of links is incorrect.");
    }

    /**
     * Test#4
     * 1. Navigate to ESPN Soccer webpage.
     * 2. Click button 'Subscribe' to navigate to ESPN+ login page
     * 3. Enter email address.
     * 4. Enter invalid password.
     * 5. Validate that the error message displayed correctly.
     */

    @Test(groups = "smoke")
    public void testInvalidLogin() {
        espnSoccerPage = new ESPNSoccerPage();
        espnSoccerPage.logIn();
        String expectedMessage = "The credentials you entered are incorrect.\n" +
                "Reminder: Passwords are case sensitive.";
        Assert.assertEquals(espnSoccerPage.messageErrorSubscribe.getText(), expectedMessage, "The error message is displayed incorrectly.");

    }

    /**
     * Test#5
     * 1. Navigate to ESPN Soccer webpage.
     * 2. Click on 'Teams' tab to navigate to Teams Page.
     * 4. Validate that the Team options are displayed correctly.
     */

    @Test(groups = "regression")
    public void testTeamsOptions() throws Exception {
        espnSoccerPage = new ESPNSoccerPage();
        Assert.assertTrue(espnSoccerPage.verifyTeamsOptions(), "The options are displayed incorrectly.");
    }

    /**
     * Test#6
     * 1. Navigate to ESPN Soccer webpage.
     * 2. Click button 'Sign Up' in 'Customize ESPN' section.
     * 3. Enter First name in input field.
     * 4. Enter Last name in input field.
     * 5. Enter email address.
     * 6. Enter password.
     * 7. Click 'Sign Up'.
     * 8. Navigate to User Profile by clicking Profile icon.
     * 9. Validate that the First Name of a newly created user account is displayed correctly.
     */

    @Test(groups = "regression")
    public void testCustomizeESPNSignUp() {
        espnSoccerPage = new ESPNSoccerPage();
        espnSoccerPage.customizeESPNSignUp();
        String name = "Jack!";
        Assert.assertEquals(espnSoccerPage.userFirstName.getText(), name, "The User First Name is not displayed correctly. Sign up test failed.");
    }

    /**
     * Test#7
     * 1. Navigate to ESPN Soccer webpage.
     * 2. Validate that left side menu is displayed correctly.
     */

    @Test(groups = "regression")
    public void testLeftSideMenu() throws IOException {
        espnSoccerPage = new ESPNSoccerPage();
        Assert.assertTrue(espnSoccerPage.verifyTitlesLeftSideMenu());
    }

    /**
     * Test#8
     * 1. Navigate to ESPN Soccer webpage.
     * 2. Click 'Listen' tab.
     * 3. Select 'Listen Live' option form dropdown.
     * 4. Validate that the radio is playing and the title is displayed.
     */

    @Test(groups = "regression")
    public void testListenLive() {
        espnSoccerPage = new ESPNSoccerPage();
        espnSoccerPage.listenNow();
        waitUntilWebElementVisible(espnSoccerPage.titleRadio);
        Assert.assertTrue(espnSoccerPage.titleRadio.isDisplayed(), "The radio title is not displayed. The 'Listen Live' link may not be working");
    }

    /**
     * Test#9
     * 1. Navigate to ESPN Soccer webpage.
     * 2. Click 'Scores' tab.
     * 3. Select a date from the calendar.
     * 4. Validate that the correct date is displayed on the page with the results.
     */

    @Test(groups = "regression")
    public void testFindScore() {
        espnSoccerPage = new ESPNSoccerPage();
        espnSoccerPage.findScores();
        String expectedScoreMessage = "Scores for April 29, 2021";
        waitUntilWebElementVisible(espnSoccerPage.resultScore);
        Assert.assertEquals(espnSoccerPage.resultScore.getText(), expectedScoreMessage, "The date is displayed incorrectly.");
    }

    /**
     * Test#10
     * 1. Navigate to ESPN Soccer webpage.
     * 2. Click 'Tables' tab.
     * 3. Select a league form dropdown menu.
     * 4. Validate that the correct league is displayed on the page with the results.
     */

    @Test(groups = "regression")
    public void test() throws InterruptedException {
        espnSoccerPage = new ESPNSoccerPage();
        espnSoccerPage.selectFromEnglishPremierLeague();
        String expectedTableMessage = "Russian Premier League Table 2020-21";
        waitUntilWebElementVisible(espnSoccerPage.headerTablesResult);
        Assert.assertEquals(espnSoccerPage.headerTablesResult.getText(), expectedTableMessage, "The league is displayed incorrectly.");
    }

    /**
     * Test#11
     * 1. Navigate to ESPN Soccer webpage.
     * 2. Validate that the Quick Links are valid.
     */

    @Test(groups = "regression")
    public void testQuickLinks() {
        espnSoccerPage = new ESPNSoccerPage();
        Assert.assertTrue(espnSoccerPage.verifyQuickLinksValid(), "One or more links are broken");
    }

    /**
     * Test#12
     * 1. Navigate to ESPN Soccer webpage.
     * 2. Navigate to each page in Quick Links Section.
     * 3. Validate that the titles of Quick Links are correct.
     */

    @Test(groups = "regression")
    public void testQuickLinksTitles() throws IOException {
        espnSoccerPage = new ESPNSoccerPage();
        Assert.assertTrue(espnSoccerPage.verifyQuickLinksTitles(), "The titles of the pages are incorrect.");
    }

    /**
     * Test#13
     * 1. Navigate to ESPN Soccer webpage.
     * 2. Click on Profile Icon.
     * 3. Enter email address.
     * 4. Enter invalid password.
     * 5. Validate that user is unable to log in and the error message is displayed correctly.
     */

    @Test(dataProviderClass = ESPNSoccerPage.class, dataProvider = "getInvalidTestData", groups = "smoke")
    public void doInvalidLogIn(String email, String password) throws Exception {
        espnSoccerPage = new ESPNSoccerPage();
        espnSoccerPage.doLogin(email, password);
        waitUntilWebElementVisible(espnSoccerPage.errorMessageLogin);
        String actualErrorMessage = getTextFromElement(espnSoccerPage.errorMessageLogin);
        String expectedErrorMessage = "The credentials you entered are incorrect.\n" +
                "Reminder: Passwords are case sensitive.";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "The error message is incorrect.");
    }

    /**
     * Test#14
     * 1. Navigate to ESPN Soccer webpage.
     * 2. Validate that the title of the page is displayed correctly.
     */

    @Test(groups = "smoke")
    public void testTitle() throws IOException {
        espnSoccerPage = new ESPNSoccerPage();
        String expectedTitle = "Soccer Teams, Scores, Stats, News, Fixtures, Results, Tables - ESPN";
        Assert.assertEquals(driver.getTitle(), expectedTitle, "The title of the page is displayed incorrectly.");

    }

}

