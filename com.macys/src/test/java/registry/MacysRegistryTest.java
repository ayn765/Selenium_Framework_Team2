package registry;

import common.BaseAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class MacysRegistryTest extends BaseAPI {

    MacysRegistryPage macysRegistryPage;

    @Test(groups = "smoke")
    public void testRegistryMenuOptions() throws Exception {
        macysRegistryPage = new MacysRegistryPage();
        macysRegistryPage.verifyShopRegistryOptions();
//        Assert.assertTrue(macysRegistryPage.verifyShopRegistryOptions());
    }

    @Test(groups = "regression")
    public void testInputSearch(){
        macysRegistryPage = new MacysRegistryPage();
        macysRegistryPage.doInputSearch();
        Assert.assertTrue(macysRegistryPage.headerSearchResult.isDisplayed(), "The header for Search is not correct or the search failed.");
    }

    @Test(groups = "regression")
    public void testManageOptions() throws IOException {
        macysRegistryPage = new MacysRegistryPage();
        macysRegistryPage.verifyManageDropdown();
    }

}
