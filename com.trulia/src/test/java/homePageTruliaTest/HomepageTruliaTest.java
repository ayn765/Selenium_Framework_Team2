package homePageTruliaTest;

import common.BaseAPI;
import homePageTrulia.HomePageTrulia;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import profilePage.ProfilePage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class HomepageTruliaTest<enabled> extends BaseAPI {

    HomePageTrulia homePageTrulia;

    @Test(enabled = false)
    public void testHoverMethod() {
        homePageTrulia = new HomePageTrulia();
        homePageTrulia.mouseHover();

    }

    @Test(enabled = false)
    public void testSizeofList() {
        homePageTrulia = new HomePageTrulia();
        homePageTrulia.getSizeofdropdown();
        Assert.assertEquals(homePageTrulia.getSizeofdropdown(), 6);

    }

    @Test(enabled = false)
    public void testClickOnElementInDropDown() {
        homePageTrulia = new HomePageTrulia();
        homePageTrulia.clickOnElementOnDropDown("Home For Sales");

    }

    @Test(enabled = false)
    public void testEchelmetsToExpectedList() {
        homePageTrulia = new HomePageTrulia();
        homePageTrulia.comparingActualListToExpectedlist();
        String expectedList = "Perkiomenville\n" +
                "Homes for Sale\n" +
                "Open Houses\n" +
                "New Homes\n" +
                "Recently Sold\n" +
                "See Newest Listings\n" +
                "See Newest Listings\n";
        Assert.assertEquals(homePageTrulia.comparingActualListToExpectedlist(), expectedList);
    }

    @Test(enabled = false)
    public void testClickelmentByLoop() {
        homePageTrulia = new HomePageTrulia();
        homePageTrulia.clickOnEchElemntIntheList();

    }


    @Test(enabled = false)
    public void testGetTheTextFromSearchBar() {
        homePageTrulia = new HomePageTrulia();
        homePageTrulia.getKeysFromTheSearchBar();
        // Assert.assertTrue(compareStrings(homePageTrulia.getKeysFromTheSearchBar(),"Perkiomenville, PA"));
        Assert.assertEquals(homePageTrulia.getKeysFromTheSearchBar(), "Perkiomenville, PA");
    }

    @Test(enabled = false)
    public void testDeleteandsendkeys() {
        homePageTrulia = new HomePageTrulia();
        homePageTrulia.clearInputFieldAndSendKeysToElement(homePageTrulia.inputSearchBar, "Lansdale, PA");
        homePageTrulia.doSearch();
        Assert.assertEquals(homePageTrulia.doSearch(), "https://www.trulia.com//");

    }


    @Test(enabled = false)
    public void testListOfhover() throws IOException {
        homePageTrulia = new HomePageTrulia();
        homePageTrulia.getAllElementsOfList1();
        String sheetPath = System.getProperty("user.dir") + "Untitled spreadsheet (1).xlsx";
        Assert.assertTrue(compareAttributeListToExpectedStringArray(By.xpath("//*[@id='__next']/div/header/nav/ul/li[1]/ul/li"), "innerHTML", sheetPath, "Untitled spreadsheet"));
    }

    @Test(enabled = false)
    public void testList() throws IOException {
        homePageTrulia = new HomePageTrulia();
        WebElement ul_element = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/header/nav/ul/li[2]/a"));
        List<WebElement> li_all = ul_element.findElements(By.xpath("//*[@id=\"__next\"]/div/header/nav/ul/li[2]/ul/li[4]/a/div"));
        int total_links = li_all.size();
        System.out.println(total_links);
        for (int i = 0; i < total_links; i++) {
            li_all.get(i).getText();


            System.out.println("links name is: " + li_all.get(i).getText());
        }
    }


    @Test(enabled = false)
    public void testImage() throws IOException {
        homePageTrulia = new HomePageTrulia();

    }

    @Test(enabled = false)
    public void testTheNumberOfIfremInPage() throws IOException {
        homePageTrulia = new HomePageTrulia();
        homePageTrulia.mouseHover();
        homePageTrulia.getThenumOfifrem();
        Assert.assertEquals(homePageTrulia.getThenumOfifrem(), 0);
    }

    @Test
    public void testOpenAndSwitchnewTab() {
        homePageTrulia = new HomePageTrulia();
        homePageTrulia.SwitchToNewWin("New Home");
        Assert.assertTrue(isElementDisplayed(homePageTrulia.ImageNewTab));
    }

    @Test
    public void testSwitchBackToParentTab() {
        homePageTrulia = new HomePageTrulia();
        homePageTrulia.switchToParentTab("New Home");
        //  Assert.assertTrue(isElementDisplayed(homePageTrulia.text_In_Parent_page.getText()));

    }

    @Test
    public void TestNavigateToProfile() {
        homePageTrulia = new HomePageTrulia();
        ProfilePage profilePage = new ProfilePage();
        homePageTrulia.navigateTpProfilePage().savedProfile("huiyf", "5647895436", 3);

        String a = getTextFromElement(profilePage.expectedTextInvalidLogIn);
        Assert.assertEquals(a, "Please enter a valid phone number.");

    }


    @Test
    public void TestnumberOftheLinksInPOPULARtRULIA() {
        homePageTrulia = new HomePageTrulia();
        homePageTrulia.numLinkInPopularSearch();
        Assert.assertEquals(homePageTrulia.numLinkInPopularSearch(), "44");


    }

    @Test
    public void TestnumberOftheLinksInExploreTrulia() {
        homePageTrulia = new HomePageTrulia();
        homePageTrulia.numLinkInExploreTrulia();
        Assert.assertEquals(homePageTrulia.numLinkInExploreTrulia(), "44");


    }
}




