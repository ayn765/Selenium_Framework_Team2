package verizonDevicesTest;

import common.BaseAPI;
import org.testng.Assert;
import org.testng.annotations.Test;
import verizonDevices.VerizonDevicesPage;

public class VerizonDevicesTest extends BaseAPI {

    VerizonDevicesPage verizonDevicesPage;
    @Test(enabled = false)
    public void testValidateThePage(){
        verizonDevicesPage=new VerizonDevicesPage();
        boolean actualPage=verizonDevicesPage.isPageDisplayed();
        Assert.assertTrue(actualPage,"page is not displayed");
    }
    @Test(enabled = false)
    public void testFilters(){
        verizonDevicesPage=new VerizonDevicesPage();
        verizonDevicesPage.applyFilter();
        String actResult=getTextFromElement(verizonDevicesPage.result);
        Assert.assertEquals(actResult,"Showing 24 of 71 items");
    }
    @Test(enabled = false)
    public void testVideoPhone(){
        verizonDevicesPage=new VerizonDevicesPage();
        verizonDevicesPage.phoneVideo();
    }
    @Test
    public void testChat(){
        verizonDevicesPage=new VerizonDevicesPage();
        verizonDevicesPage.verizonChat();
    }
}
