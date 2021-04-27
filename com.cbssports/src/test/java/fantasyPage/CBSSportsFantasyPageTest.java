package fantasyPage;

import common.BaseAPI;
import fantasyPage.fantasyBaseball.CBSSportsFantasyBaseballPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.DataReader;

import java.io.IOException;
import java.util.List;

public class CBSSportsFantasyPageTest extends BaseAPI {

    CBSSportsFantasyPage cbsSportsFantasyPage;
    DataReader dataReader;
    SoftAssert softAssert;
    CBSSportsFantasyBaseballPage cbsSportsFantasyBaseballPage;



    /**
     * Test#1
     * 1. Navigate to CBSSports website.
     * 2. Click Fantasy Tab to Navigate to Fantasy Page.
     * 3. Verify that the title of Fantasy Page is correct.
     */

    @Test(groups = "regression")
    public void testTitleFantasyPage() {
        cbsSportsFantasyPage = new CBSSportsFantasyPage();
        cbsSportsFantasyPage.navigateToFantasyPage();
        Assert.assertTrue(cbsSportsFantasyPage.verifyCBSSportsTitle(), "The CBSSports Title is incorrect.");
    }

    /**
     * Test#2
     * 1. Navigate to CBSSports website.
     * 2. Click Fantasy Tab to Navigate to Fantasy Page.
     * 3. Hover over 'Play Video' tab and click 'Play'.
     * 4. Validate that a page with live video opens and an icon 'live' is displayed.
     */
    @Test(groups = "regression")
    public void testPlayVideo() {
        cbsSportsFantasyPage = new CBSSportsFantasyPage();
        cbsSportsFantasyPage.navigateToFantasyPage();
        cbsSportsFantasyPage.watchVideo();
        Assert.assertTrue(cbsSportsFantasyPage.iconLive.isDisplayed());
    }

    /**
     * Test#3
     * 1. Navigate to CBSSports website.
     * 2. Click Fantasy Tab to Navigate to Fantasy Page.
     * 3. Click on each tab with links to different pages within Fantasy Module and validate each title.
     */

    @Test(groups = "regression")
    public void testFantasyLinks() throws IOException {
        cbsSportsFantasyPage = new CBSSportsFantasyPage();
        cbsSportsFantasyPage.navigateToFantasyPage();
        Assert.assertTrue(cbsSportsFantasyPage.verifyFantasyLinksTitles());
    }

    /**
     * Test#4
     * 1. Navigate to CBSSports website.
     * 2. Click Fantasy Tab to Navigate to Fantasy Page.
     * 3. Validate the visible text of Side Menu Options in Football Section.
     */

    @Test(groups = "regression")
    public void testSideMenuOptionsFootball() throws IOException {
        cbsSportsFantasyPage = new CBSSportsFantasyPage();
        dataReader = new DataReader();
        cbsSportsFantasyPage.navigateToFantasyPage();
        String[] expectedMenuOptions = dataReader.fileReaderStringArrayXSSF(System.getProperty("user.dir") + "/src/test/resources/CBSSportsTestData.xlsx", "SideMenuOptions");
        List<WebElement> actualMenuOptions = cbsSportsFantasyPage.sideMenuOptionsFootball;
        softAssert = new SoftAssert();
        for (int i = 0; i < actualMenuOptions.size(); i++) {
            System.out.println("Actual menu option: " + actualMenuOptions.get(i).getText());
            System.out.println("Expected menu option: " + expectedMenuOptions[i]);
            softAssert.assertEquals(actualMenuOptions.get(i).getText(), expectedMenuOptions[i], "The menu option " + i + " is incorrect.");
        }
        softAssert.assertAll();
    }

    /**
     * Test#5
     * 1. Navigate to CBSSports website.
     * 2. Click Fantasy Tab to Navigate to Fantasy Page.
     * 3. Navigate to Fantasy Baseball by clicking 'Baseball' tab.
     * 4. Click 'Podcast' button to navigate to Fantasy Baseball Podcast Page.
     * 5. Validate that the Fantasy Baseball Podcast image is displayed.
     */

    @Test(groups = "regression")
    public void testButtonPodcastOnBaseballPage() {
        cbsSportsFantasyPage = new CBSSportsFantasyPage();
        cbsSportsFantasyPage.navigateToFantasyPage();
        cbsSportsFantasyBaseballPage = cbsSportsFantasyPage.navigateToFantasyBaseballPage();
        clickElement(cbsSportsFantasyBaseballPage.baseballPagePodcast);
        switchToNewWindow();
        waitUntilWebElementVisible(cbsSportsFantasyBaseballPage.imgPodcast);
        Assert.assertTrue(cbsSportsFantasyBaseballPage.imgPodcast.isDisplayed(), "The image on Fantasy Baseball Podcast Page cannot be located.");
    }

    /**
     * Test#6
     * 1. Navigate to CBSSports website.
     * 2. Click Fantasy Tab to Navigate to Fantasy Page.
     * 3. Click 'Play' button to navigate to Fantasy Play Page
     * 4. Validate that the text of all links on the top of Fantasy Play Page are displayed correctly.
     */

    @Test(groups = "regression")
    public void testLinksTextOnPlayPage() throws Exception {
        cbsSportsFantasyPage = new CBSSportsFantasyPage();
        cbsSportsFantasyPage.navigateToFantasyPage();
        Assert.assertTrue(cbsSportsFantasyPage.navigateToFantasyPlayPage().validateTopLinks(), "The text of the links on the top of Fantasy Play Page is incorrect or cannot be found.");
    }

    /**
     * Test#7
     * 1. Navigate to CBSSports website.
     * 2. Click Fantasy Tab to Navigate to Fantasy Page.
     * 3. Click 'Football' button to navigate to Fantasy Football Page
     * 4. Enter valid email address into the input field to sign up for updates.
     * 5. Validate that the message "Thanks for Sign up" is displayed.
     */

    @Test(groups = "regression")
    public void testInvalidEmailOnFootballPage() {
        cbsSportsFantasyPage = new CBSSportsFantasyPage();
        cbsSportsFantasyPage.navigateToFantasyPage();
        Assert.assertTrue(cbsSportsFantasyPage.navigateToFantasyFootballPage().signUpForEmails().isDisplayed(), "The sign up message is not displayed, the email submission has possibly failed.");
    }

    /**
     * Test#8
     * 1. Navigate to CBSSports website.
     * 2. Click Fantasy Tab to Navigate to Fantasy Page.
     * 3. Click 'Basketball' button to navigate to Fantasy Basketball Page.
     * 4. Validate that the number of links of Side Menu Research on Fantasy Football Page is correct.
     * 5. Validate that the links on Side Menu Research on Fantasy Football Page are valid.
     */

    @Test(groups = "regression")
    public void testSideMenuResearchOnBasketballPage() {
        cbsSportsFantasyPage = new CBSSportsFantasyPage();
        cbsSportsFantasyPage.navigateToFantasyPage();
        softAssert = new SoftAssert();
        int expectedNumOfLinks = 5;
        softAssert.assertEquals(cbsSportsFantasyPage.navigateToFantasyBasketballPage().getNumSideMenuResearchOptions(), expectedNumOfLinks, "The number of links of Side Menu Research on Fantasy Football Page is incorrect.");
        softAssert.assertTrue(cbsSportsFantasyPage.navigateToFantasyBasketballPage().verifyLinksSideMenuResearch(), "One or more links on Side Menu Research on Fantasy Football Page are broken.");
        softAssert.assertAll();
    }

    /**
     * Test#9
     * 1. Navigate to CBSSports website.
     * 2. Click Fantasy Tab to Navigate to Fantasy Page.
     * 3. Click 'Hockey' button to navigate to Fantasy Hockey Page.
     * 4. Move the slider in "Bet Now" section.
     * 5. Validate that the value has changed after the slider has been moved.
     */

    @Test(groups = "regression")
    public void testSliderBarOnHockeyPage() throws InterruptedException {
        cbsSportsFantasyPage = new CBSSportsFantasyPage();
        cbsSportsFantasyPage.navigateToFantasyPage();
        Assert.assertTrue(cbsSportsFantasyPage.navigateToFantasyHockeyPage().verifySliderBar(), "The slider bar test failed.");
    }

    /**
     * Test#10
     * 1. Navigate to CBSSports website.
     * 2. Click Fantasy Tab to Navigate to Fantasy Page.
     * 3. Click 'Hockey' button to navigate to Fantasy Hockey Page.
     * 4. Click on each tab of Player News Menu.
     * 5. Validate that each tab is extended to populate the news.
     */

    @Test(groups = "regression")
    public void testTabsPlayerNewsExpandedOnHockeyPage() {
        cbsSportsFantasyPage = new CBSSportsFantasyPage();
        cbsSportsFantasyPage.navigateToFantasyPage();
        Assert.assertTrue(cbsSportsFantasyPage.navigateToFantasyHockeyPage().verifyTabsPlayerNewsExpanded());
    }

    /**
     * Test#11
     * 1. Navigate to CBSSports website.
     * 2. Click Fantasy Tab to Navigate to Fantasy Page.
     * 3. Click 'Hockey' button to navigate to Fantasy Hockey Page.
     * 4. Validate that the tabs on Player News Menu are displayed correctly.
     */

    @Test(enabled = false, groups = "regression")
    public void testLabelTabsPlayerNewsOnHockeyPage() throws IOException {
        cbsSportsFantasyPage = new CBSSportsFantasyPage();
        cbsSportsFantasyPage.navigateToFantasyPage();
        Assert.assertTrue(cbsSportsFantasyPage.navigateToFantasyHockeyPage().verifyTabsPlayerNews());
    }

    /**
     * Test#12
     * 1. Navigate to CBSSports website.
     * 2. Click Fantasy Tab to Navigate to Fantasy Page.
     * 3. Click 'College' button to navigate to Fantasy College Page.
     * 4. Validate the header on Fantasy College Page.
     */

    @Test(groups = "regression")
    public void testHeaderOnCollegePage() {
        cbsSportsFantasyPage = new CBSSportsFantasyPage();
        cbsSportsFantasyPage.navigateToFantasyPage();
        Assert.assertTrue(cbsSportsFantasyPage.navigateToFantasyCollegePage().verifyHeader());
    }

    /**
     * Test#13
     * 1. Navigate to CBSSports website.
     * 2. Click Fantasy Tab to Navigate to Fantasy Page.
     * 3. Click 'Props Game' button to navigate to Fantasy Props Game Page.
     * 4. Click button 'Enter' and enter invalid login and password.
     * 5. Verify that the error message is displayed.
     */

    @Test(groups = "regression")
    public void testInvalidLoginOnPropsGamePage() {
        cbsSportsFantasyPage = new CBSSportsFantasyPage();
        cbsSportsFantasyPage.navigateToFantasyPage();
        Assert.assertTrue(cbsSportsFantasyPage.navigateToFantasyPropsGamePage().invalidLogIn().isDisplayed());
    }

    /**
     * Test#14
     * 1.Navigate to CBSSports website.
     * 2. Click Fantasy Tab to Navigate to Fantasy Page.
     * 3. Select checkbox to agree to terms.
     * 4. Enter email address to subscribe to emails.
     * 5. Click submit.
     * 6. Verify that correct message is displayed.
     */

    @Test(groups = "smoke")
    public void testEmailSignUp() {
        cbsSportsFantasyPage = new CBSSportsFantasyPage();
        cbsSportsFantasyPage.emailsSignUp();
        String expectedSignUpMessage = "Thanks for signing up!";
        waitUntilWebElementVisible(cbsSportsFantasyPage.messageSignUp);
        Assert.assertEquals(cbsSportsFantasyPage.messageSignUp.getText(), expectedSignUpMessage, "The Sign Up message is incorrect.");
    }
}