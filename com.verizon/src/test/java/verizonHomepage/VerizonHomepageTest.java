package verizonHomepage;

import common.BaseAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class VerizonHomepageTest extends BaseAPI {

    VerizonHomepage verizonHomepage;

    @Test(enabled = false)
    public void testSmartPhonePageButton() throws InterruptedException {
        verizonHomepage.checkSmartPhonePage();
        String expected = "Smartphones - Buy The Top Cell Phones | Verizon";
        String actual = driver.getTitle();
        Assert.assertEquals(actual, expected, "Test Failed");

    }

    @Test(enabled = true)
    public void test5GInternet() throws InterruptedException {
        verizonHomepage.check5GInternet();

        String expected = "Verizon 5G Home Internet | Verizon";
        String actual = driver.getTitle();
        Assert.assertEquals(actual, expected, "Test Failed");

    }

    @Test(enabled = true)
    public void testPhoneDeals() throws InterruptedException {
        verizonHomepage.checkPhones();

        String expected = "Deals On Samsung & Google Phones";
        String actual = driver.getTitle();
        Assert.assertEquals(actual, expected, "Test Failed");
    }

    @Test(enabled = true)
    public void testUnlimitedPlansPage() throws InterruptedException {
        verizonHomepage.checkUnlimitedPlans();

        String expected = "Verizon Unlimited Data Plans for Talk & Text, Now with 5G";
        String actual = driver.getTitle();
        Assert.assertEquals(actual, expected, "Test Failed");

    }

    @Test(enabled = true)
    public void testGamingPage() throws InterruptedException {
        verizonHomepage.checkGaming();

        String expected = "Deals On Samsung & Google Phones";
        String actual = driver.getTitle();
        Assert.assertEquals(actual, expected, "Test Failed");

    }

    @Test(enabled = false)
    public void testSearchBox() throws InterruptedException, IOException {
        verizonHomepage.searchBox();

        String expected = "Search Results for Apple iPhone 12 at Verizon";
        String actual = driver.getTitle();
        Assert.assertEquals(actual, expected, "Test Failed");

    }

    @Test(enabled = false)
    public void testSearchBox2() throws InterruptedException, IOException {
        verizonHomepage.searchBox2();

        String expected = "Search Results for Samsung Galaxy S20+ 5G at Verizon";
        String actual = driver.getTitle();
        Assert.assertEquals(actual, expected, "Test Failed");

    }

    @Test(enabled = false)
    public void testSearchBox3() throws InterruptedException, IOException {
        verizonHomepage.searchBox3();

        String expected = "Search Results for LG V60 ThinQ 5G UW at Verizon";
        String actual = driver.getTitle();
        Assert.assertEquals(actual, expected, "Test Failed");

    }

    @Test(enabled = false)
    public void testSearchBox4() throws InterruptedException, IOException {
        verizonHomepage.searchBox4();

        String expected = "Search Results for Black Friday at Verizon";
        String actual = driver.getTitle();
        Assert.assertEquals(actual, expected, "Test Failed");

    }

    @Test(enabled = false)
    public void testSearchBox5() throws InterruptedException, IOException {
        verizonHomepage.searchBox5();

        String expected = "Search Results for Upgrade at Verizon";
        String actual = driver.getTitle();
        Assert.assertEquals(actual, expected, "Test Failed");

    }

    @Test(enabled = false)
    public void testSearchBox6DB() throws Exception {
        verizonHomepage.dbConnectSearchBox6();

        String expected = "Search Results for Plans at Verizon";
        String actual = driver.getTitle();
        Assert.assertEquals(actual, expected, "Test Failed");

    }

    @Test(enabled = false)
    public void testSearchBox7DB() throws Exception {
        verizonHomepage.dbConnectSearchBox7();

        String expected = "Search Results for Apple Watch Series 6 at Verizon";
        String actual = driver.getTitle();
        Assert.assertEquals(actual, expected, "Test Failed");

    }

    @Test(enabled = false)
    public void testSearchBox8DB() throws Exception {
        verizonHomepage.dbConnectSearchBox8();
        String expected = "Search Results for Unlimted at Verizon";
        String actual = driver.getTitle();
        Assert.assertEquals(actual, expected, "Test Failed");

    }

    @Test(enabled = false)
    public void testSearchBox9DB() throws Exception {
        verizonHomepage.dbConnectSearchBox9();

        String expected = "Search Results for Samsung Galaxy Note20 5G at Verizon";
        String actual = driver.getTitle();
        Assert.assertEquals(actual, expected, "Test Failed");

    }

    @Test(enabled = false)
    public void testSearchBox10DB() throws Exception {
        verizonHomepage.dbConnectSearchBox10();

        String expected = "Search Results for Add a line at Verizon";
        String actual = driver.getTitle();
        Assert.assertEquals(actual, expected, "Test Failed");
    }
}
