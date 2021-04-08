package homepage;

import common.BaseAPI;
import musicPage.MusicPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EbayHomepageTest extends BaseAPI {
    EbayHomepage ebayHomepage;
    MusicPage musicPage;

    @Test
    public void testNavigateToMusicPage(){
        ebayHomepage = new EbayHomepage();
        musicPage = ebayHomepage.navigateToMusicPage();
        Assert.assertTrue(musicPage.headerMusicPage.isDisplayed());

    }
}
