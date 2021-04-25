package sellPageTest;

import common.BaseAPI;
import ebayhomegarden.EbayHomeGardenPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SellPageTest extends BaseAPI {
    EbayHomeGardenPage ebayHomeGardenPage;

    @Test(enabled = false)
    public void testSellItems() {
        ebayHomeGardenPage = new EbayHomeGardenPage();
        ebayHomeGardenPage.navigateToSellPage().sellItem();
    }

    @Test(enabled = false)
    public void testValidateCategories() {
        ebayHomeGardenPage = new EbayHomeGardenPage();
        int actualNumber = ebayHomeGardenPage.navigateToSellPage().numOfCategories();
        Assert.assertEquals(actualNumber, "39");
    }
    @Test(enabled = false)
    public void testValidatePicIsThere(){
        ebayHomeGardenPage = new EbayHomeGardenPage();
        ebayHomeGardenPage.navigateToSellPage().clickLearnMore();
        boolean isPicThere=ebayHomeGardenPage.navigateToSellPage().isPicDisplayed();
        Assert.assertTrue(isPicThere,"picture is not visible");
    }
    @Test
    public void testTheSellerStory(){
        ebayHomeGardenPage = new EbayHomeGardenPage();
        ebayHomeGardenPage.navigateToSellPage().sellerStory();
    }
}