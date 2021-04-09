package homepage;

import common.BaseAPI;
import concertsPage.EbayConcertsPage;
import musicPage.EbayMusicPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import sellerCenterPage.EBaySellerCenterPage;

public class EbayHomepageTest extends BaseAPI {
    EbayHomepage ebayHomepage;
    EbayMusicPage musicPage;
    EbayConcertsPage concertTicketsPage;
    EBaySellerCenterPage eBaySellerCenterPage;

    @Test
    public void testNavigateToMusicPage() {
        ebayHomepage = new EbayHomepage();
        musicPage = ebayHomepage.navigateToMusicPage();
        Assert.assertTrue(musicPage.headerMusicPage.isDisplayed());

    }
    @Test
    public void testNavigateToConcertTicketsPage() {
        ebayHomepage = new EbayHomepage();
        concertTicketsPage = ebayHomepage.navigateToMusicPage().navigateToConcertsPage();
        Assert.assertTrue(concertTicketsPage.headerConcertTicketsPage.isDisplayed());

    }
    @Test
    public void testNavigateToSellerCenterPage() {
        ebayHomepage = new EbayHomepage();
        eBaySellerCenterPage = ebayHomepage.navigateToSellerCenterPage();
        Assert.assertTrue(eBaySellerCenterPage.headerSellerCenterPage.isDisplayed());
    }
}
