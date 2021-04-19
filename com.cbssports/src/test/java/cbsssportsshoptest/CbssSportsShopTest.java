package cbsssportsshoptest;

import cbsssportsshop.CbssSportShopPage;
import common.BaseAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CbssSportsShopTest extends BaseAPI {
    CbssSportShopPage cbssSportShopPage;

 @Test(enabled = false)
    public void testShop(){
         cbssSportShopPage=new CbssSportShopPage();
         cbssSportShopPage.shopSoccer();

}
@Test(enabled = false)
    public void testPlayers(){
    cbssSportShopPage=new CbssSportShopPage();
    cbssSportShopPage.shopPlayersItems();
}
@Test(enabled = false)
    public void testValidateSearch(){
    cbssSportShopPage=new CbssSportShopPage();
    cbssSportShopPage.searchItems();
    String actualResult=getTextFromElement(cbssSportShopPage.searchResult);
    Assert.assertEquals(actualResult,"1 - 3 of 3");
}
@Test
    public void testReturnPolicy(){
    cbssSportShopPage=new CbssSportShopPage();
    cbssSportShopPage.returnItems();
}
}
