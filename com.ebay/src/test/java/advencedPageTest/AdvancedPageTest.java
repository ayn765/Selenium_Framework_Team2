package advencedPageTest;

import advancedPage.AdvancedPage;
import common.BaseAPI;
import dealsEbay.DealsEbay;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdvancedPageTest extends BaseAPI {
    DealsEbay dealsEbay;
    AdvancedPage advancedPage;

    @Test(enabled = false)
    public void testNavigateToAdvancedPage(){
        dealsEbay=new DealsEbay();
        advancedPage=new AdvancedPage();
       advancedPage.advancedPage();
       Assert.assertEquals(advancedPage.expectedResult.getAttribute("id"), "gh-title");

    }
}
