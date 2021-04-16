package smallBusiness;

import common.BaseAPI;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.DataReader;

import java.io.IOException;

public class BankOfAmericaSmallBusinessPageTest extends BaseAPI {

    BankOfAmericaSmallBusinessPage bankOfAmericaSmallBusinessPage;
    SoftAssert softAssert;

    /**
     * Test#1
     * 1. Navigate to BOA Small Business Page.
     * 2. Enter Online ID in input field.
     * 3. Enter invalid Password in input field.
     * 4. Error message has to be displayed. A User should not be allowed to log in.
     */

    @Test(groups = "regression")
    public void testInvalidLogin() {
        bankOfAmericaSmallBusinessPage = new BankOfAmericaSmallBusinessPage();
        bankOfAmericaSmallBusinessPage.doInvalidLogIn();
        Assert.assertTrue(bankOfAmericaSmallBusinessPage.errorMessage.isDisplayed(), "The error message is not displayed. The Invalid Login Test failed.");
    }

    /**
     * Test#2
     * 1. Navigate to BOA Small Business Page.
     * 2. Enter Online ID in input field.
     * 3. Enter invalid Password in input field.
     * 4. Error message has to be displayed. A User should not be allowed to log in.
     */

    @Test(groups = "regression")
    public void testInvalidEnroll() {
        bankOfAmericaSmallBusinessPage = new BankOfAmericaSmallBusinessPage();
        bankOfAmericaSmallBusinessPage.doInvalidEnroll();
        String expectedErrorMessage1 = "We're unable to complete your request at this time.";
        String expectedErrorMessage2 = "The information you entered does not match our records. Please verify your information.";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(bankOfAmericaSmallBusinessPage.errorMessage1Enroll.getText(), expectedErrorMessage1, "Part or entire message is incorrect.");
        softAssert.assertEquals(bankOfAmericaSmallBusinessPage.errorMessage2Enroll.getText(), expectedErrorMessage2, "Part or entire message is incorrect.");

    }

    /**
     * Test#3
     * 1. Navigate to BOA Small Business Page.
     * 2. Verify that all text in Info Box "All in one Business Solution" is displayed correctly.
     */

    @Test(groups = "regression")
    public void testBusinessSolutionsText() throws Exception {
        bankOfAmericaSmallBusinessPage = new BankOfAmericaSmallBusinessPage();
        Assert.assertTrue(bankOfAmericaSmallBusinessPage.verifyInfoBoxBusinessSolutions(), "The text of Info box Business Solutions is displayed incorrectly.");
    }

    /**
     * Test#4
     * 1. Navigate to BOA Small Business Page.
     * 2. Verify that all text in Info Box "Skip the mailbox Go paperless" is displayed correctly.
     */

    @Test(groups = "regression")
    public void testGoPaperlessText() throws Exception {
        bankOfAmericaSmallBusinessPage = new BankOfAmericaSmallBusinessPage();
        Assert.assertTrue(bankOfAmericaSmallBusinessPage.verifyInfoBoxGoPaperless(), "The text of Info box Go Paperless is displayed incorrectly.");
    }

    /**
     * Test#5
     * 1. Navigate to BOA Small Business Page.
     * 2. Click 'Schedule an appointment button'.
     * 3. Select 'New Account', 'Payroll Services', and 'Merchant Services' checkboxes.
     * 4. Verify that the checkboxes are selected.
     */

    @Test(groups = "regression")
    public void testScheduleAppointmentCheckboxes() {
        bankOfAmericaSmallBusinessPage = new BankOfAmericaSmallBusinessPage();
        bankOfAmericaSmallBusinessPage.doScheduleAppointment();
        softAssert = new SoftAssert();
        softAssert.assertTrue(bankOfAmericaSmallBusinessPage.checkboxMerchantServ.isSelected(), "The checkbox is not selected.");
        softAssert.assertTrue(bankOfAmericaSmallBusinessPage.checkboxNewAccount.isSelected(), "The checkbox is not selected.");
        softAssert.assertTrue(bankOfAmericaSmallBusinessPage.checkboxPayrollServ.isSelected(), "The checkbox is not selected.");
        softAssert.assertAll();
    }

    /**
     * Test#6
     * 1. Navigate to BOA Small Business Page.
     * 2. Click 'Schedule an appointment button'.
     * 3. Select 'New Account' checkbox.
     * 4. Click next button.
     * 5. Verify that a message is displayed.
     * 5. Verify that 'How would you like to meet?' message is displayed correctly.
     */

    @Test(groups = "regression")
    public void testScheduleAppointmentForNewAccount() {
        bankOfAmericaSmallBusinessPage = new BankOfAmericaSmallBusinessPage();
        bankOfAmericaSmallBusinessPage.doScheduleAppointmentNewAccount();
        String expectedMessage = "How would you like to meet?";
        softAssert = new SoftAssert();
        softAssert.assertTrue(bankOfAmericaSmallBusinessPage.headerHowToMeet.isDisplayed(), "The message is not displayed.");
        softAssert.assertEquals(bankOfAmericaSmallBusinessPage.headerHowToMeet.getText(), expectedMessage, "The message is not displayed correctly.");
        softAssert.assertAll();
    }

    /**
     * Test#7
     * 1. Navigate to BOA Small Business Page.
     * 2. Verify that all links in 'Helpful tips' section are valid.
     */

    @Test(groups = "regression")
    public void testLinksExploreTopics() {
        bankOfAmericaSmallBusinessPage = new BankOfAmericaSmallBusinessPage();
        Assert.assertTrue(bankOfAmericaSmallBusinessPage.verifyLinksExploreTopics(), "One or more links in 'Helpful Tips' section are broken");
    }

    /**
     * Test#8
     * 1. Navigate to BOA Small Business Page.
     * 2. Verify that all links in 'Helpful tips' section display correct titles.
     */

    @Test(groups = "regression")
    public void testLinksTitlesExploreTopics() throws IOException {
        bankOfAmericaSmallBusinessPage = new BankOfAmericaSmallBusinessPage();
        Assert.assertTrue(bankOfAmericaSmallBusinessPage.verifyLinksTitlesExploreTopics(), "The titles of the links in 'Helpful tips' section are displayed incorrectly.");
    }

    /**
     * Test#9
     * 1. Navigate to BOA Small Business Page.
     * 2. Verify that all links in 'Helpful tips' section display correct titles.
     * 3. Click 'Our videos can help you run your business more efficiently' link.
     * 4. Click 'Play Video'.
     * 5. Verify the header of the video is displayed and the video playing.
     */
    @Test(groups = "regression")
    public void testVideo() throws Exception {
        bankOfAmericaSmallBusinessPage = new BankOfAmericaSmallBusinessPage();
        bankOfAmericaSmallBusinessPage.playVideoManageBusinessEffectively();
        Assert.assertTrue(bankOfAmericaSmallBusinessPage.headerVideo.isDisplayed(), "The the header of the video is not displayed and/or the video is not playing.");
    }

    /**
     * Test#10
     * 1. Navigate to BOA Small Business Page.
     * 2. Click on 'Online Banking Service Agreement' to navigate to 'Online Banking Service Agreement' Page.
     * 3. Verify the right page is open and the correct header is displayed.
     */

    @Test(groups = "regression")
    public void testAgreementPage() throws IOException {
        bankOfAmericaSmallBusinessPage = new BankOfAmericaSmallBusinessPage();
        bankOfAmericaSmallBusinessPage.navigateToAgreement();
        switchToNewTab(1);
        Assert.assertTrue(bankOfAmericaSmallBusinessPage.headerAgreementPage.isDisplayed(), "The header of Agreement Page is not displayed. The wrong page may be displayed.");
    }

    /**
     * Test#11
     * 1. Navigate to BOA Small Business Page.
     * 2. Click on 'Zelle' to navigate to 'Zelle' Page.
     * 3. Click on "Watch' to play video.
     * 3. Verify the expected element is located on a page and the video is playing.
     */

    @Test(groups = "regression")
    public void testZelleVideo() {
        bankOfAmericaSmallBusinessPage = new BankOfAmericaSmallBusinessPage();
        bankOfAmericaSmallBusinessPage.watchZelleVideo();
        Assert.assertTrue(bankOfAmericaSmallBusinessPage.viewTranscript.isDisplayed(), "The expected element is not displayed on the page. The video was not loaded correctly.");
    }

    /**
     * Test#11
     * 1. Navigate to BOA Small Business Page.
     * 2. Click in input field of Help Search to populate search prompts.
     * 3. Select 'routing number'.
     * 4. Verify that the link to routing numbers is displayed.
     */

    @Test(groups = "regression")
    public void testHelpSearch() {
        bankOfAmericaSmallBusinessPage = new BankOfAmericaSmallBusinessPage();
        bankOfAmericaSmallBusinessPage.searchHelp();
        waitUntilWebElementVisible(bankOfAmericaSmallBusinessPage.linkRoutingNumbers);
        Assert.assertTrue(bankOfAmericaSmallBusinessPage.linkRoutingNumbers.isDisplayed(), "The link to Routing Numbers is not displayed.");

    }

    /**
     * Test#12
     * 1. Navigate to BOA Small Business Page.
     * 2. Click on 'Putting Small Business First' section.
     * 3. Verify that the links on the page are valid.
     */

    @Test(groups = "regression")
    public void testSmallBusinessFirstLinks() {
        bankOfAmericaSmallBusinessPage = new BankOfAmericaSmallBusinessPage();
        Assert.assertTrue(bankOfAmericaSmallBusinessPage.verifyPuttingSmallBusinessFirstLinks(), "One or more links in 'Putting Small Business First' section are broken");
    }

    /**
     * Test#13
     * 1. Navigate to BOA Small Business Page.
     * 2. Click on 'Putting Small Business First' section.
     * 3. Click in each link and verify the title on every page.
     */

    @Test(groups = "regression")
    public void testLinksTitlesSmallBusinessFirst() throws IOException {
        bankOfAmericaSmallBusinessPage = new BankOfAmericaSmallBusinessPage();
        Assert.assertTrue(bankOfAmericaSmallBusinessPage.verifyLinksTitlesPuttingSmallBusinessFirst(), "One or more links in 'Putting Small Business First' section are broken");

    }

    /**
     * Test#14
     * 1. Navigate to BOA Small Business Page.
     * 2. Click on 'Open Account' button.
     * 3. Verify that chat option is available.
     */

    @Test(groups = "smoke")
    public void testChatOptionOpenAccount()  {
        bankOfAmericaSmallBusinessPage = new BankOfAmericaSmallBusinessPage();
        bankOfAmericaSmallBusinessPage.openAccount();
        waitUntilWebElementVisible(bankOfAmericaSmallBusinessPage.buttonChat);
        Assert.assertTrue(bankOfAmericaSmallBusinessPage.buttonChat.isDisplayed(), "The chat is not available.");

    }
}