package mortgage;

import common.BaseAPI;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class TruliaMortgagePageTest extends BaseAPI {

    TruliaMortgagePage truliaMortgagePage;
    SoftAssert softAssert;

    /**
     * Test#1
     * 1. Navigate to Trulia Mortgages Page
     * 2. Enter zipcode in to the field.
     * 3. Click 'get pre-qualified'.
     * 4. Validate that the 3 options to get pre-qualified are displayed.
     */

    @Test(enabled = false)
    public void testGetPreQualifiedRequest() {
        truliaMortgagePage = new TruliaMortgagePage();
        truliaMortgagePage.getPreQualifiedRequest();
        waitUntilWebElementListVisible(truliaMortgagePage.optionsGetPreQualified);
        softAssert = new SoftAssert();
        for (WebElement option : truliaMortgagePage.optionsGetPreQualified) {
            softAssert.assertTrue(option.isDisplayed(), "The option is not displayed");
        }
        softAssert.assertAll();
    }
    /**
     * Test#2
     * 1.Navigate to Trulia Mortgages Page
     * 2. Enter zipcode in to the field.
     * 3. Click 'get pre-qualified'.
     * 4. Validate that the 3 options are displayed correctly.
     */

    @Test(enabled = false)
    public void testGetPreQualifiedRequestText() throws Exception {
        truliaMortgagePage = new TruliaMortgagePage();
        truliaMortgagePage.getPreQualifiedRequest();
        Assert.assertTrue(truliaMortgagePage.verifyOptionsGetPrequalifiedText(), "The test of the options is displayed incorrectly.");
    }

    /**
     * Test#3
     * 1.Navigate to Trulia Mortgages Page
     * 2. Enter zipcode in to the field.
     * 3. Click 'get pre-qualified'.
     * 4. Validate that the links of 3 options ave valid.
     */

    @Test(enabled = false)
    public void testGetPreQualifiedRequestLinksValid() throws Exception {
        truliaMortgagePage = new TruliaMortgagePage();
        truliaMortgagePage.getPreQualifiedRequest();
        Assert.assertTrue(truliaMortgagePage.verifyOptionsGetPreQualifiedLinksValid(), "One or more links are broken.");
    }

    /**
     * Test#4
     * 1.Navigate to Trulia Mortgages Page
     * 2. Click on 'Affordability Calculator'
     * 3. Enter annual income into input field.
     * 4. Enter down payment into input field.
     * 5. Select credit score from dropdown.
     * 6. Adjust dept-to-income slider.
     * 7. Validate that the affordable house value and monthly payments are displayed correctly according the user inputs.
     */

    @Test(enabled = false)
    public void testAffordabilityCalculator() {
        truliaMortgagePage = new TruliaMortgagePage();
        truliaMortgagePage.doAffordabilityCalculator();
        String expectedHouseValue = "$745,050";
        String expectedMonthlyPayment = "$3,875";
        softAssert = new SoftAssert();
        softAssert.assertEquals(truliaMortgagePage.resultAffordHouseValue.getText(), expectedHouseValue, "The house value is incorrect.");
        softAssert.assertEquals(truliaMortgagePage.resultAffordMonthlyPayment.getText(), expectedMonthlyPayment, "The monthly payment is incorrect.");
        softAssert.assertAll();
    }
    /**
     * Test#5
     * 1.Navigate to Trulia Mortgages Page
     * 2. Click 'Refinance Calculator'
     * 3. Slide the bar to calculate savings.
     * 4. Validate that the total savings are displayed correctly.
     */

    @Test(enabled = false)
    public void testRefinanceCalculator() throws Exception {
        truliaMortgagePage = new TruliaMortgagePage();
        truliaMortgagePage.doSliderTotalSavings();
        String expectedResultSavings = "$4,464";
        Assert.assertEquals(truliaMortgagePage.resultTotalSavings.getText(), expectedResultSavings, "The total savings are displayed incorrectly.");
    }

    /**
     * Test#6
     * 1.Navigate to Trulia Mortgages Page
     * 2. Click 'See More'.
     * 3. Click 'Lender Directory.
     * 4. Enter location partially, then select an option from dropdown prompt.
     * 5. Enter a name of a bank into the input field.
     * 6. Click 'Search'.
     * 7. Validate that all search result belong to the correct bank.
     */

    @Test(enabled = false)
    public void testSearchLenderDirectory() {
        truliaMortgagePage = new TruliaMortgagePage();
        Assert.assertTrue(truliaMortgagePage.searchLenderDirectory(), "The search results are displayed incorrectly.");

    }

    /**
     * Test#7
     * 1.Navigate to Trulia Mortgages Page
     * 2. Click 'Northstar MLS End User License Agreement.' to open PDF.
     * 3. Validate that pdf opens as expected and contains accurate information.
     */

    @Test(enabled = false)
    public void testLicenseAgreement(){
        truliaMortgagePage = new TruliaMortgagePage();
        String licenceAgreementLink = truliaMortgagePage.licenseAgreement.getAttribute("href");
        verifyContentInPDf(licenceAgreementLink, "End-User License Agreement for consumers accessing");
    }
    /**
     * Test#8
     * 1. Navigate to Trulia Mortgages Page
     * 2. Click 'Northstar MLS End User License Agreement.' to open PDF.
     * 3. Validate that pdf opens as expected and contains accurate information.
     */

    @Test(enabled = false)
    public void testHelpText() throws IOException {
        truliaMortgagePage = new TruliaMortgagePage();
        Assert.assertTrue(truliaMortgagePage.verifyHelpText(), "The help text is not displayed correctly.");
    }

    /**
     * Test#9
     * 1. Navigate to Trulia Mortgages Page
     * 2. Validate that 'Most-asked mortgage questions' are displayed correctly.
     */

    @Test(enabled = true)
    public void testMortgageQuestions() throws IOException {
        truliaMortgagePage = new TruliaMortgagePage();
        Assert.assertTrue(truliaMortgagePage.verifyMortgageQuestions());
    }

    /**
     * Test#10
     * 1. Navigate to Trulia Mortgages Page
     * 2. Navigate to Mortgage Calculator Page
     * 3. Validate that all links in Mortgage Resources Section are valid.
     */

    @Test(enabled = false)
    public void testLinksMortgageResources(){
        truliaMortgagePage = new TruliaMortgagePage();
        Assert.assertTrue(truliaMortgagePage.verifyLinksMortgageResources(),"One or more links are broken.");
    }

    /**
     * Test#11
     * 1. Navigate to Trulia Mortgages Page
     * 2. Navigate to Mortgage Calculator Page
     * 3. Validate that all links in Mortgage Resources Section are valid.
     */

    @Test(enabled = false)
    public void testLinksTitlesMortgageResources() throws IOException {
        truliaMortgagePage = new TruliaMortgagePage();
        Assert.assertTrue(truliaMortgagePage.verifyLinksTitlesMortgageResources(),"One or more titles are incorrect");
    }
    @Test(enabled = false)
    public void testHoverHelpText() throws InterruptedException {
        truliaMortgagePage = new TruliaMortgagePage();
        truliaMortgagePage.verifyHoverHelp();
    }


}
