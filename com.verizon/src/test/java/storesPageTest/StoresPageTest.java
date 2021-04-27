package storesPageTest;

import common.BaseAPI;
import org.testng.annotations.Test;
import storesPage.StoresPage;

public class StoresPageTest extends BaseAPI {
    StoresPage storesPage;


    @Test(enabled = false)
    public void navigateToStoresPage(){
        storesPage=new StoresPage();
        storesPage.navigateToStorePage();
    }
    @Test
    public void testSingInButton(){
        storesPage=new StoresPage();
        storesPage.hoverOverSingInButton();
    }

}
