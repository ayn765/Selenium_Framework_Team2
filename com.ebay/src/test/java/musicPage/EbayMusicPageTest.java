package musicPage;

import common.BaseAPI;
import concertsPage.EbayConcertsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TextFileReader;

import java.awt.*;
import java.io.IOException;

public class EbayMusicPageTest extends BaseAPI {


    EbayMusicPage ebayMusicPage;
    EbayConcertsPage ebayConcertsPage;

    @Test(enabled = false)
    public void testTitleMusicPage() {
        ebayMusicPage = new EbayMusicPage();
        TextFileReader textFileReader = new TextFileReader();
        ebayMusicPage.buttonNavigateToMusicPage.click();
        String expectedTitle = textFileReader.readToString(System.getProperty("user.dir") + "/src/test/resources/MusicPageTitle.txt");
        Assert.assertEquals(driver.getTitle(), expectedTitle, "The Title is incorrect.");
    }

    @Test(enabled = false)
    public void testNumberDropDownOptionsMusicMedia() {
        ebayMusicPage = new EbayMusicPage();
        ebayMusicPage.navigateToMusicPage();
        int expectedNumDropDowns = 233;
        Assert.assertEquals(ebayMusicPage.dropDownMusicMedia.size(), expectedNumDropDowns, "The number of drop downs is incorrect.");
    }

    @Test(enabled = false)
    public void testClassicalMusicSearchWithinPriceRange() {
        ebayMusicPage = new EbayMusicPage();
        ebayMusicPage.makeSelectionFromMusicCDOption();
        Assert.assertTrue(ebayMusicPage.headerSearchResults.isDisplayed());
    }
    //Return an object of another page
    @Test(enabled = false)
    public void testNavigateToConcertTicketsAndExperiencesPage() {
        ebayMusicPage = new EbayMusicPage();
        ebayMusicPage.navigateToMusicPage();
        ebayConcertsPage = ebayMusicPage.navigateToConcertsPage();
        Assert.assertTrue(ebayConcertsPage.headerConcertTicketsPage.isDisplayed());
    }

    //Test a Menu Options on Concert Page from Music Page using method chaining
    //Reading Test Date from Excel
    @Test(enabled = false)
    public void testMenuTicketsOptionsOnConcertPage() throws IOException {
        ebayMusicPage = new EbayMusicPage();
        ebayMusicPage.navigateToMusicPage();
        Assert.assertTrue(ebayMusicPage.navigateToConcertsPage().verifyMenuTicketsOptions());
    }

    //Test adding ticket to cart on Concert Page from Music Page
    @Test(enabled = false)
    public void testAddingConcertTicketToCart() {
        ebayMusicPage = new EbayMusicPage();
        ebayMusicPage.navigateToMusicPage();
        ebayConcertsPage = ebayMusicPage.navigateToConcertsPage();
        ebayConcertsPage.addTicketToCart();
        Assert.assertTrue(ebayConcertsPage.addToCart.isDisplayed());
    }
    //Test search in Music Category using Select dropdown
    //Press Enter Key with Robot Class
    @Test(enabled = false)
    public void testSearchInMusicCategory() throws AWTException {
        ebayMusicPage = new EbayMusicPage();
        ebayMusicPage.searchInMusicCategory();
        Assert.assertTrue(ebayMusicPage.searchResultMadonna.isDisplayed());
    }
    //Hover over
    @Test
    public void testIconNotificationMessage(){
        ebayMusicPage = new EbayMusicPage();
        ebayMusicPage.hoverOverIconNotifications();
        Assert.assertTrue(ebayMusicPage.messageIconNotifications.isDisplayed());
    }
}
