package ebayElectronics;

import common.BaseAPI;
import electronics.EbayElectronics;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EbayElectronicsTest extends BaseAPI {

    EbayElectronics ebayElectronics;

    @Test
    public void testCellphoneTab(){
        ebayElectronics = new EbayElectronics();
        ebayElectronics.selectShopByCategoryCellphones();

        String actualText = "Cell Phones, Smart Watches & Accessories";
        String expectedText = driver.findElement(By.cssSelector("div.pagecontainer__top > h1 > span")).getText();

        Assert.assertEquals(actualText, expectedText, "TITLE DOES NOT MATCH");

    }

    @Test
    public void testHoverOverCameraTab() {
        ebayElectronics = new EbayElectronics();
        ebayElectronics.hoverAndClickCamerra();

        String actualText = "Cameras & Photo";
        String expectedText = driver.findElement(By.cssSelector("div.pagecontainer__top > h1 > span")).getText();

        Assert.assertEquals(actualText, expectedText, "NAMES DO NOT MATCH");
    }

    @Test(enabled = false)
    public void navigateBackToRefresh(){
        ebayElectronics = new EbayElectronics();
        ebayElectronics.navigateBackToRefresh();
    }

    @Test
    public void testNumOfCategories(){
        ebayElectronics = new EbayElectronics();
        ebayElectronics.numOfCategories();

        boolean actual = ebayElectronics.numOfCategories();
        int expected = 5;

        Assert.assertEquals(actual, expected, "LIST OF CATEGORIES DO NOT MATCH");
    }

}
