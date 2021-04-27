package dealsEbayTest;

import advancedPage.AdvancedPage;
import common.BaseAPI;
import dealsEbay.DealsEbay;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class DealsEbayTest extends BaseAPI {
    DealsEbay dealsEbay;
    AdvancedPage advancedPage;

    @Test(enabled = false)
    public void testNaigateToPageDeals() {
        dealsEbay = new DealsEbay();
        dealsEbay.navigateToDealsPage();
        Assert.assertEquals(getTextFromElement(dealsEbay.expectedText), "Deals");
    }

    @Test(enabled = false)
    public void testClickElementOnDropDown() {
        dealsEbay = new DealsEbay();
        dealsEbay.navigateToDealsPage();
        dealsEbay.clickOnListShopCategory("Collectibles & art");
    }

    @Test(enabled = false)
    public void testsizeElementOnDropDownSHOP_CATEGORY() {
        dealsEbay = new DealsEbay();
        dealsEbay.navigateToDealsPage();
        dealsEbay.getSizeOfShopCategory();
        Assert.assertEquals(dealsEbay.getSizeOfShopCategory(), "3");

    }

    @Test(enabled = false)
    public void testClickElementOnDropDownCategoryDeals() {
        dealsEbay = new DealsEbay();
        dealsEbay.navigateToDealsPage();
        dealsEbay.clickOnListCategoryDeals("All Deals");
    }

    @Test(enabled = false)
    public void testsizeElementOnDropDownCategoryDeals() throws IOException {
        dealsEbay = new DealsEbay();
        dealsEbay.navigateToDealsPage();
        dealsEbay.getlistofcategoryDeals();
        Assert.assertEquals(dealsEbay.getSizeOfShopCategory(), "2");
    }


    @Test(enabled = false)
    public void TestListCategoryDealsAgainstExelSheet () throws IOException {
            dealsEbay = new DealsEbay();
            dealsEbay.navigateToDealsPage();
            dealsEbay.compareListOfElementToExcelSheet();
            String sheetPath = System.getProperty("user.dir") + "categoryDealsList.xlsx";
            Assert.assertTrue(compareAttributeListToExpectedStringArray(By.cssSelector("#gh-cat>option"), "innerHTML", sheetPath, "categoryDealsList"));
    }

    @Test(enabled = false)
    public void TestSendKeysToSearchBar () throws IOException {
        dealsEbay = new DealsEbay();
        dealsEbay.navigateToDealsPage();
        dealsEbay.SendKeysToSearchBar("laptop");
        dealsEbay.getNumOfPhotos();


        Assert.assertEquals(getNumOfPhotos(), "28");
    }

    @Test(enabled = false)
    public void TestnumOfthelinks () throws IOException {
        dealsEbay = new DealsEbay();
        dealsEbay.navigateToDealsPage();
        dealsEbay.numLinkInAboutEbayButton();
        Assert.assertEquals(dealsEbay.numLinkInAboutEbayButton(), 10);
    }


    @Test(enabled = false)
    public void TestclickOnTheLinksList () throws IOException {
        dealsEbay = new DealsEbay();
        dealsEbay.navigateToDealsPage();
        dealsEbay.clickOnTheLink();

        Assert.assertEquals(getTextFromElement(dealsEbay.expectedTextSecurityPage), "Security Center");
    }
    @Test(enabled = false)
    public void testNumOfIframe() {
        dealsEbay = new DealsEbay();
        dealsEbay.getNumOfIframe();
       Assert.assertEquals(dealsEbay.getNumOfIframe(), 0);
    }

    @Test(enabled = false)
    public void testAddingToTheShoppingCart() {
        dealsEbay = new DealsEbay();
        dealsEbay.shoppingCart("kids", 1, 1);
    }

    @Test
    public void TestNavigateToAdvanced() {
        dealsEbay = new DealsEbay();
        advancedPage=new AdvancedPage();
        dealsEbay.navigationToAdvancePage().displayedCategory();



    }


}
