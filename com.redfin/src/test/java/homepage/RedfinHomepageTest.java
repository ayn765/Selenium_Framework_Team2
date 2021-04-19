package homepage;

import common.BaseAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RedfinHomepageTest extends BaseAPI {

    RedfinHomepage redfinHomepage;

    @Test(enabled = false)
    public void testValidateSearch(){
        redfinHomepage=new RedfinHomepage();
        redfinHomepage.houseSearch();
        String actual=redfinHomepage.searchResult.getText();
        Assert.assertEquals(actual,"Showing 41 of 90 Homes");
    }
    @Test(enabled = false)
    public void testNoticeHouseLink(){
        redfinHomepage=new RedfinHomepage();
        redfinHomepage.noticeLink();
    }
    @Test(enabled = false)
    public void testPlayVideo(){
        redfinHomepage=new RedfinHomepage();
        redfinHomepage.checkVideo();
    }
    @Test
    public void testLinkNews(){
        redfinHomepage=new RedfinHomepage();
        redfinHomepage.navigateToNews();
        String actualLink=getCurrentPageUrl();
        Assert.assertEquals(actualLink,"https://www.redfin.com/news/");
    }
}
