package musicPage;

import common.BaseAPI;
import concersPage.ConcertsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TextFileReader;

import java.io.IOException;

public class MusicPageTest extends BaseAPI {


    MusicPage musicPage;
    ConcertsPage concertTicketsAndExperiencesPage;

    @Test(enabled = false)
    public void testTitleMusicPage() {
        musicPage = new MusicPage();
        TextFileReader textFileReader = new TextFileReader();
        musicPage.buttonNavigateToMusicPage.click();
        String expectedTitle = textFileReader.readToString(System.getProperty("user.dir") + "/src/test/resources/MusicPageTitle.txt");
        Assert.assertEquals(driver.getTitle(), expectedTitle, "The Title is incorrect.");
    }

    @Test(enabled = false)
    public void testNumberDropDownOptionsMusicMedia() {
        musicPage = new MusicPage();
        musicPage.navigateToMusicPage();
        int expectedNumDropDowns = 233;
        Assert.assertEquals(musicPage.dropDownMusicMedia.size(), expectedNumDropDowns, "The number of drop downs is incorrect.");
    }
    @Test(enabled = false)
    public void testClassicalMusicSearchWithinPriceRange() {
        musicPage = new MusicPage();
        musicPage.makeSelectionFromMusicCDOption();
        Assert.assertTrue(musicPage.headerSearchResults.isDisplayed());
    }
    @Test(enabled = false)
    public void testNavigateToConcertTicketsAndExperiencesPage(){
        musicPage = new MusicPage();
        musicPage.navigateToMusicPage();
        concertTicketsAndExperiencesPage = musicPage.navigateToConcertTicketsPage();
        Assert.assertTrue(concertTicketsAndExperiencesPage.headerConcertTicketsPage.isDisplayed());
    }
//Testing a Menu Options on Concert Page from Music Page using method chaining
    @Test
    public void testMenuTicketsOptionsOnConcertPage() throws IOException {
        musicPage = new MusicPage();
        musicPage.navigateToMusicPage();
        Assert.assertTrue(musicPage.navigateToConcertTicketsPage().verifyMenuTicketsOptions());
    }
}
