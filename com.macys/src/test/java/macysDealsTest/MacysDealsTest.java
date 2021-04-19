package macysDealsTest;

import common.BaseAPI;
import macysdeals.MacysDealsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MacysDealsTest extends BaseAPI {
    MacysDealsPage macysDealPage;

    @Test(enabled = false)
    public void testValidateTextHeader() {
        macysDealPage = new MacysDealsPage();
        macysDealPage.textHeader();
        String actualText = getTextFromElement(macysDealPage.offerHeader);
        Assert.assertEquals(actualText, "We've gathered all our latest deals in one easy-to-shop spot.");
    }
    @Test(enabled = false)
   public void testNumLinkInCategoryShopping(){
        macysDealPage = new MacysDealsPage();
        macysDealPage.navigateDeals();
        int linksNum=macysDealPage.NumOfLinksINCategoryDropDown();
        Assert.assertEquals(linksNum,"15");
        }

    @Test(enabled = false)
    public void testFilterSearchKidsDeal(){
        macysDealPage = new MacysDealsPage();
        macysDealPage.shop();
    }
    @Test
    public void testLinkAlertPopup(){
        macysDealPage = new MacysDealsPage();
        macysDealPage.jewelery();
    }
}
