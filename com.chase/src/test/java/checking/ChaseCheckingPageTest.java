package checking;

import common.BaseAPI;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.io.IOException;

public class ChaseCheckingPageTest extends BaseAPI {

    ChaseCheckingPage chaseCheckingPage;

    /**
     * Test#1
     * 1. Navigate to Chase Checking Page.
     * 2. Click 'Continue and apply' in Special Offer Section.
     * 3. Enter email address in input field.
     * 4. Click 'Get your special offer'.
     * 5. Verify that the page displays correct message.
     */

    @Test(groups = "regression", enabled = false)
    public void testSpecialOfferSignUp() {
        chaseCheckingPage = new ChaseCheckingPage();
        chaseCheckingPage.getSpecialOffer();
        String expectedThankYouMessage = "Check your email for your Checking coupon code, then click \"Open an account\"";
        Assert.assertEquals(chaseCheckingPage.messageThankYou.getText(), expectedThankYouMessage, "The message is not displayed correctly.");

    }

    /**
     * Test#2
     * 1. Navigate to Chase Checking Page.
     * 2. Verify that titles of the links in 'Chose what's right for you' section display correctly.
     */

    @Test(groups = "regression", enabled = false)
    public void testCarouselLinksTitlesChoseWhatRight() throws IOException {
        chaseCheckingPage = new ChaseCheckingPage();
        Assert.assertTrue(chaseCheckingPage.verifyCarouselLinksTitlesChoseWhatRight());
    }

    /**
     * Test#3
     * 1. Navigate to Chase Checking Page.
     * 2. Verify that titles of the tabs in 'Compare Accounts' section display correctly.
     */

    @Test(groups = "regression", enabled = false)
    public void testTabsTitlesCompareAccounts() throws Exception {
        chaseCheckingPage = new ChaseCheckingPage();
        Assert.assertTrue(chaseCheckingPage.verifyTabsCompareAccounts(), "The tab titles are displayed incorrectly.");
    }

    /**
     * Test#4
     * 1. Navigate to Chase Checking Page.
     * 2. Click on 'Premium' tab.
     * 3. Click '+' to add an account to compare.
     * 4. Add 'Chase Total Checking' account to compare.
     * 5. Verify that the account is added the title is displayed.
     */

    @Test(groups = "regression", enabled = false)
    public void testAddChaseTotalCheckingToCompare() {
        chaseCheckingPage = new ChaseCheckingPage();
        chaseCheckingPage.addChaseTotalCheckingToCompare();
        Assert.assertTrue(chaseCheckingPage.headerChaseTotalChecking.isDisplayed(), "The Chase Total Checking was not added to compare accounts.");

    }

    /**
     * Test#5
     * 1. Navigate to Chase Checking Page.
     * 2. Download pdf 'Additional Banking Services'.
     * 3. Verify that the pdf content is accurate.
     */

    @Test(groups = "regression", enabled = false)
    public void testPDFAdditionalServices() throws IOException {
        chaseCheckingPage = new ChaseCheckingPage();
        String expectedContent = "Additional Banking Services and Fees for Personal Accounts";
        String pdfURL = "https://www.chase.com/content/dam/chase-ux/documents/personal/checking/ABSF-en.pdf";
        verifyContentInPDf(pdfURL, expectedContent);
    }

    /**
     * Test#6
     * 1. Navigate to Chase Checking Page.
     * 2. Click 'Zelle' icon to flip it.
     * 3. Verify that the attribute of Zelle element aria-expanded changed to true.
     */

    @Test(groups = "regression", enabled = false)
    public void testFlipCardZelle() {
        chaseCheckingPage = new ChaseCheckingPage();
        chaseCheckingPage.flipCardZelle();
        Assert.assertEquals(chaseCheckingPage.element.getAttribute("aria-expanded"), "true", "The attribute is incorrect. The element may not be displayed correctly.");

    }

    /**
     * Test#7
     * 1. Navigate to Chase Checking Page.
     * 2. Click 'Zelle' icon to flip it.
     * 3. Verify that the text on the flipped side of Zelle icon is correct.
     */

    @Test(groups = "regression", enabled = false)
    public void testFlipCardTextZelle() {
        chaseCheckingPage = new ChaseCheckingPage();
        String expectedText = getStringFromTextFile(System.getProperty("user.dir") + "/src/test/resources/ZelleFlipCard.txt");
        String actualText = (chaseCheckingPage.getFlipCardTextZelle().trim());
        Assert.assertEquals(actualText, expectedText, "The text on Zelle Flip Card is incorrect.");
    }

    /**
     * Test#8
     * 1. Navigate to Chase Checking Page.
     * 2. Click 'Find Your Nearest' Branch.
     * 3. Enter ZipCode into input field.
     * 4. Click 'Search'.
     * 5. Verify that thr search returns a correct location.
     */

    @Test(groups = "regression", enabled = false)
    public void testFindYourBranch() {
        chaseCheckingPage = new ChaseCheckingPage();
        chaseCheckingPage.findYourBranch();
        Assert.assertTrue(chaseCheckingPage.expectedBranch.isDisplayed(), "The expected branch is not displayed.");
    }

    /**
     * Test#9
     * 1. Navigate to Chase Checking Page.
     * 2. Click 'See Details' under Accounts for children' section.
     * 3. Click 'play' to watch a video.
     * 4. Verify that the video is playing as expected.
     */

    @Test(groups = "smoke", enabled = false)
    public void testVideoKidsAccounts() {
        chaseCheckingPage = new ChaseCheckingPage();
        chaseCheckingPage.playVideoKidsAccounts();
        Assert.assertTrue(chaseCheckingPage.buttonTurnOnVideoDescription.isDisplayed(), "The video is not displayed correctly.");
    }

    /**
     * Test#10
     */

    @Test(groups = "smoke", enabled = false)
    public void testLinksTabsFirstBanking() {
        chaseCheckingPage = new ChaseCheckingPage();
        Assert.assertTrue(chaseCheckingPage.verifyLinksTabsFirstBanking(), "One or more links are broken.");
    }

    /**
     * Test#11
     */

    @Test(groups = "smoke", enabled = false)
    public void testLinksTitlesTabsFirstBanking() throws IOException {
        chaseCheckingPage = new ChaseCheckingPage();
        Assert.assertTrue(chaseCheckingPage.verifyLinksTitlesFirstBanking());
    }

    /**
     * Test#12
     */

    @Test(dataProviderClass = ChaseCheckingPage.class, dataProvider = "getInvalidTestData", enabled = false)
    public void doInvalidLogIn(String email, String password) throws Exception {
        chaseCheckingPage = new ChaseCheckingPage();
        chaseCheckingPage.doLogin(email, password);
        String actualErrorMessage = getTextFromElement(chaseCheckingPage.errorMessageLogin);
        String expectedErrorMessage = "We can't find that username and password. You can reset your password or try again.";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "The error message is incorrect.");
    }

    /**
     * Test#13
     */


    @Test(groups = "smoke", enabled = false)
    public void testIfVideoPlaying()  {
        chaseCheckingPage = new ChaseCheckingPage();
        chaseCheckingPage.playVideo();
        Assert.assertTrue(chaseCheckingPage.verifyVideoPlaying());
    }

}


