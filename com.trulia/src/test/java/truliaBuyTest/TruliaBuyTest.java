package truliaBuyTest;

import common.BaseAPI;
import org.testng.Assert;
import org.testng.annotations.Test;
import truliaBuy.TruliaBuyPage;


public class TruliaBuyTest extends BaseAPI {
  TruliaBuyPage truliaBuyPage;

  @Test(enabled = false)
    public void testNumLinksInBuy(){
  truliaBuyPage=new TruliaBuyPage();
 int actual= truliaBuyPage.numLinksInBuy();
      Assert.assertEquals(actual,"5");
  }
  @Test(enabled = false)
    public void testValidateNumHousesSold(){
      truliaBuyPage=new TruliaBuyPage();
      truliaBuyPage.numOfHouseSold();
      String result=truliaBuyPage.resultSold.getText();
      Assert.assertEquals(result,"18,242 sold homes on Trulia");
  }
  @Test(enabled = false)
    public void testSearchOpenHouse(){
      truliaBuyPage=new TruliaBuyPage();
      truliaBuyPage.openHouse();
  }
  @Test
    public void testValidateLink(){
      truliaBuyPage=new TruliaBuyPage();
      truliaBuyPage.helpCenter();
      String actualLink=getCurrentPageUrl();
      Assert.assertEquals(actualLink,"https://support.trulia.com/hc/en-us/categories/360002036653-Android-iOS-Mobile-Apps");
  }
}
