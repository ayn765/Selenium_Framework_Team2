package homepage;

import common.BaseAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ESPNHomepageTest extends BaseAPI {
    ESPNHomepage espnHomepage;

    @Test(enabled = false)
    public void testSubscribe(){
        espnHomepage=new ESPNHomepage();
        espnHomepage.subscribeEspn();
    }
@Test(enabled = false)
    public void testValidateImageTitle(){
    espnHomepage=new ESPNHomepage();
    espnHomepage.checkTitle();
    String actual=getCurrentPageTitle();
    Assert.assertEquals(actual,"ESPN: Serving sports fans. Anytime. Anywhere.","titles do not match");
}
 @Test(enabled = false)
    public void testPrintScoreBoxTable(){
    espnHomepage=new ESPNHomepage();
    espnHomepage.printScoreTable();
}
@Test
    public void testAddFavorite(){
    espnHomepage=new ESPNHomepage();
    espnHomepage.favorite();
}
}
