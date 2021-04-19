package financialTest;

import common.BaseAPI;
import financialServices.FinancialPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FinancialTest extends BaseAPI {
    FinancialPage financialPage;

    @Test(enabled = false)
    public void testValidatePic(){
        financialPage=new FinancialPage();
        boolean isPicThere=financialPage.isPicDisplays();
        Assert.assertTrue(isPicThere,"picture is not displayed");
    }
    @Test(enabled = false)
    public void testValidateSearch(){
        financialPage=new FinancialPage();
        financialPage.searchDealer();
        String actualResult=getTextFromElement(financialPage.address);
        Assert.assertEquals(actualResult,"6500 Perimeter Loop Road\n" +
                "Dublin, OH, 43017");
    }
    @Test(enabled = false)
    public void testValidateEstimate(){
        financialPage=new FinancialPage();
        financialPage.estimateCar();
        Boolean estimatePic=financialPage.carPic.isDisplayed();
        Assert.assertTrue(estimatePic,"pic is not displayed");
    }
    @Test
    public void testValidateOwnerLinkPage(){
        financialPage=new FinancialPage();
        financialPage.ownerPage();
        String currentLink=financialPage.getCurrentPageUrl();
        Assert.assertEquals(currentLink,"https://www.mbusa.com/en/shop/warranty-maintenance");
    }
}
