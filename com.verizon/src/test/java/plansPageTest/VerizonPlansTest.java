package plansPageTest;

import common.BaseAPI;
import homepage.VerizonHomepage;
import org.testng.Assert;
import org.testng.annotations.Test;
import plansPage.VerizonPlansPage;

public class VerizonPlansTest extends BaseAPI {

    VerizonPlansPage verizonPlansPage;
    VerizonHomepage verizonHomepage;

    @Test (enabled = false, groups = "smoke")
    public void testNavigateToPlansPage(){
        verizonHomepage = new VerizonHomepage();
        verizonHomepage.navigateToVerizonPlansPage();
        String expectedTitle = "Unlimited Data, Talk & Text Prepaid and Family Wireless Plans";
        Assert.assertEquals(driver.getTitle(), expectedTitle, "The title is incorrect or the page is wrong.");
    }

    @Test (enabled = false, groups = "smoke")
    public void testRates() throws InterruptedException {
        verizonPlansPage = new VerizonPlansPage();
//        verizonHomepage = new VerizonHomepage();
//        verizonHomepage.navigateToVerizonPlansPage();
        verizonPlansPage.verifyRates();

    }
}
