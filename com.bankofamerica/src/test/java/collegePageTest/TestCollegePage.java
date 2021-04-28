package collegePageTest;

import collegePage.CollegePage;
import common.BaseAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCollegePage extends BaseAPI {


    CollegePage collegePage;

    //Test Case # 1(**)
    @Test(enabled = false)
    public void testDeptDropDown() {
        collegePage = new CollegePage();
        collegePage.verifyDeptDropDown();

        Assert.assertTrue(isElementDisplayed(collegePage.imageFinancialAssistOption));

    }

    //Test Case # 2 (**)
    @Test(enabled = false)
    public void testPayingBackLoanTab() {
        collegePage = new CollegePage();
        collegePage.verifyPayingBackLoanTab();

        Assert.assertTrue(isElementDisplayed(collegePage.delayLoanVideo));


    }

    //Test Case # 3
    @Test(enabled = false)
    public void testBeforeCollegeTab() {
        collegePage = new CollegePage();
        collegePage.verifyBeforeCollegeTab();
    }

    //Test Case # 4 (**)
    @Test(enabled = false)
    public void testHomeOwnershipTab() {
        collegePage = new CollegePage();
        collegePage.checkHomeOwnershipTab();
        Assert.assertTrue(isElementDisplayed(collegePage.equityHeader));

    }

    //Test Case # 5
    @Test(enabled = false)
    public void testNavigatingToAutoTab() {
        collegePage = new CollegePage();
        collegePage.verifyAutoTab();
        Assert.assertTrue(isElementDisplayed(collegePage.selectAutoLoanFromAutoTab));

    }

    //Test Case #6 : Navigate to buy car Tab
    @Test(enabled = false)
    public void testNavigationToBuyCarTab() {
        collegePage = new CollegePage();
        collegePage.verifyNavigatingToBuyCarTab();
        String actualAttributeValue = collegePage.videoGettingCarAfterMilitary.getAttribute("id");
        String expectedAttributeValue = "#ItemTile_getting_a_car_after_the_military_________________________watch_video";
        System.out.println(actualAttributeValue);
        System.out.println(expectedAttributeValue);

        Assert.assertEquals(actualAttributeValue, expectedAttributeValue, "Texts do not match");
    }


    //Test Case #7
    @Test(enabled = false)
    public void testRetirementTab() {
        collegePage = new CollegePage();
        collegePage.verifyRetirementTab();
        Assert.assertTrue(isElementDisplayed(collegePage.HeaderRetirementPlan));
    }

    //Test # 8: Personal Banking(*)
    @Test(enabled = false)
    public void testPersonalBanking() {
        collegePage = new CollegePage();
        collegePage.verifyPersonalBankingTab();
        String actualText = collegePage.personalBankingHeader.getText();
        String expectedText = "Some bank accounts require a minimum or average ba";
        Assert.assertEquals(actualText, expectedText, "Texts do not match");
    }

    //Test # 9: Taxes and filing (**)
    @Test//(enabled = false)
    public void testTaxesAndFiling() {
        collegePage = new CollegePage();
        collegePage.verifyTaxesAndFiling();
        Assert.assertTrue(isElementDisplayed(collegePage.taxesHeader));
    }

    //Test # 10: Privacy AND Security(*)
    @Test(enabled = false)
    public void testPrivacyAndSecurityTab() {
        collegePage = new CollegePage();
        collegePage.verifyPrivacyAndSecurityTab();
        Assert.assertTrue(isElementSelected(collegePage.privacyAndSecurity));
    }

    //Test # 11(*)
    @Test(enabled = false)
    public void verifyMyPriority() {
        collegePage = new CollegePage();
        collegePage.verifyMyPriority();
        String actualAttributeValue = collegePage.priorityHeader.getAttribute("id");
        String expectedAttributeValue = "subhead_mypriorities";


        Assert.assertEquals(actualAttributeValue, expectedAttributeValue, "Texts do not match");


    }

    //test 12
    @Test(enabled = false)
    public void testSearchBarBillPay() {
        collegePage = new CollegePage();
        collegePage.doSearchBillPay();

        Assert.assertTrue(isElementDisplayed(collegePage.billPaymentSearchResult));
    }

    //Test Case 13
    @Test(enabled = false)
    public void testSearchBarOpenAnAccount() {
        collegePage.doSearchBillPay();
       collegePage.doSearchOpenAccount();
     Assert.assertTrue(isElementDisplayed(collegePage.openAnAccountResult));
    }
    //Test Case 14
    @Test(enabled = false)
    public void testSearchBarSelect() {
        collegePage.doSearchBillPay();
        collegePage.doSelectRoutingNumber();
        Assert.assertTrue(isElementDisplayed(collegePage.routingResult));
    }
    //Test Case 15
    @Test(enabled = false)
    public void testSwitchToIframe(){
        collegePage = new CollegePage();
        collegePage.numOfIframes();


    }




}


