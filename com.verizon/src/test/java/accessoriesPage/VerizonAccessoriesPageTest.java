package accessoriesPage;

import common.BaseAPI;
import homepage.VerizonHomepage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class VerizonAccessoriesPageTest extends BaseAPI {

    VerizonAccessoriesPage verizonAccessoriesPage;
    SoftAssert softAssert;

    @Test(groups = "smoke", enabled = false)
    public void testAllProductsLinks() {
        verizonAccessoriesPage = new VerizonAccessoriesPage();
        verizonAccessoriesPage.verifyProductLinks();
    }
    @Test(groups = "smoke", enabled = false)
    public void testNumOfLinks(){
        verizonAccessoriesPage = new VerizonAccessoriesPage();
        int expectedNumOfLinks = 7;
        Assert.assertEquals(verizonAccessoriesPage.linksAllProducts.size(), expectedNumOfLinks, "The number of links is not correct.");
    }

    @Test(groups = "smoke", enabled = false)
    public void testLinksTitles() throws IOException {
        verizonAccessoriesPage = new VerizonAccessoriesPage();
        Assert.assertTrue(verizonAccessoriesPage.verifyProductLinksTitles(), "The titles are incorrect.");
    }
    @Test(groups = "smoke", enabled = false)
    public void testItemsWorkFromHome(){
        verizonAccessoriesPage = new VerizonAccessoriesPage();
        softAssert = new SoftAssert();
        verizonAccessoriesPage.viewItemsWorkFromHome();
        waitUntilWebElementListVisible(verizonAccessoriesPage.linksItemsWorkFromHome);
        for(WebElement singleItem : verizonAccessoriesPage.linksItemsWorkFromHome){
            softAssert.assertTrue(singleItem.isDisplayed(), "The item is not displayed.");
        }
        softAssert.assertAll();
    }

    @Test(groups = "smoke", enabled = true)
    public void testVerifyHelpText(){
        verizonAccessoriesPage = new VerizonAccessoriesPage();
        verizonAccessoriesPage.verifyTextGetHelp();
        String expectedText = "Shop online or through the My Verizon app and get your orders fast.";
        Assert.assertEquals(verizonAccessoriesPage.headerHelpPopup.getText(), expectedText, "The text is incorrect.");
    }
}
