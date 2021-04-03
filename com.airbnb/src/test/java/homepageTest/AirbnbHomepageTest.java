package homepageTest;

import common.BaseAPI;
import homepage.AirbnbHomepage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AirbnbHomepageTest extends BaseAPI {

//    AirbnbHomepage airbnbHomepage;

    @Test (enabled = false)
    public void testTripSearch(){

        AirbnbHomepage airbnbHomepage = new AirbnbHomepage();

        airbnbHomepage.sendKeysToDestination("New York");
        airbnbHomepage.verifyFlexibleSearch();
        String actualTitle = driver.getTitle();
        String expectedTitle = "Vacation Rentals, Homes, Hotels, Experiences & More - Airbnb";
        Assert.assertEquals(actualTitle, expectedTitle, "Title is incorrect.");
    }
    @Test(enabled = false)
    public void testNumberOfLanguages(){
        AirbnbHomepage airbnbHomepage = new AirbnbHomepage();
        airbnbHomepage.verifyNumOfLanguages();
    }
    @Test(enabled = false)
    public void testVerifyLanguages(){
        AirbnbHomepage airbnbHomepage = new AirbnbHomepage();
        airbnbHomepage.verifyLanguages();
    }

}
