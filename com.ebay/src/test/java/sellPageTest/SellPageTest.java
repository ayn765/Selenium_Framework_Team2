package sellPageTest;

import common.BaseAPI;
import ebayhomegarden.EbayHomeGardenPage;
import org.testng.annotations.Test;

public class SellPageTest extends BaseAPI {
    EbayHomeGardenPage ebayHomeGardenPage;
    @Test
    public void testSellItems(){
        ebayHomeGardenPage=new EbayHomeGardenPage();
        ebayHomeGardenPage.navigateToSellPage().sellItem();
    }
}
