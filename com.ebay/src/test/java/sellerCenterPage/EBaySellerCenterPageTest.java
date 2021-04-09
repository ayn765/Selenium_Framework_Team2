package sellerCenterPage;

import common.BaseAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class EBaySellerCenterPageTest extends BaseAPI {

    EBaySellerCenterPage eBaySellerCenterPage;

    //Reading Test Data from text file
    @Test(enabled = false)
    public void testNavigateToSellerCenterPage() {
        EBaySellerCenterPage eBaySellerCenterPage = new EBaySellerCenterPage();
        eBaySellerCenterPage.navigateToSellerCenterPage();
        String expectedTitle = eBaySellerCenterPage.getSellerCenterTitle();
        Assert.assertEquals(driver.getTitle(), expectedTitle, "The title of Seller Center is incorrect.");
    }

    @Test(enabled = false)
    public void testInputSearch() {
        EBaySellerCenterPage eBaySellerCenterPage = new EBaySellerCenterPage();
        eBaySellerCenterPage.navigateToSellerCenterPage();
        eBaySellerCenterPage.sendKeysToInputSearch();
        waitUntilWebElementInvisible(eBaySellerCenterPage.inputSearchFocus);
        Assert.assertTrue(eBaySellerCenterPage.inputSearchFocus.isDisplayed(), "Search input displays incorrectly.");
    }
    //Reading Test Data from Excel
    @Test
    public void testMenuSellerCenter() throws IOException {
        EBaySellerCenterPage eBaySellerCenterPage = new EBaySellerCenterPage();
        eBaySellerCenterPage.navigateToSellerCenterPage();
        Assert.assertTrue(eBaySellerCenterPage.verifyCallCenterMenuOption(), "One or more menu options are incorrect.");
    }
}
