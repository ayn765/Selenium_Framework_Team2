package homepageTest;

import common.BaseAPI;
import homepage.AirbnbHomepage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AirbnbHomepageTest extends BaseAPI {

//    AirbnbHomepage airbnbHomepage;

    @Test
    public void testTripSearch(){

        AirbnbHomepage airbnbHomepage = new AirbnbHomepage();

        airbnbHomepage.sendKeysToDestination("New York");
        airbnbHomepage.createFlexibleSearch();
        String actualTitle = driver.getTitle();
        String expectedTitle = "Vacation Rentals, Homes, Hotels, Experiences & More - Airbnb";
        Assert.assertEquals(actualTitle, expectedTitle, "Title is incorrect.");
    }
    @Test
    public void testNumberOfLanguages(){
        AirbnbHomepage airbnbHomepage = new AirbnbHomepage();
        airbnbHomepage.verifyNumOfLanguages();
    }
    @Test
    public void testVerifyLanguages(){
        AirbnbHomepage airbnbHomepage = new AirbnbHomepage();
        airbnbHomepage.verifyLanguages();
    }
}
