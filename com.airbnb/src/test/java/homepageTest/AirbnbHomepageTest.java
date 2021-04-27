package homepageTest;

import common.BaseAPI;
import homepage.Homepage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AirbnbHomepageTest extends BaseAPI {

//    AirbnbHomepage airbnbHomepage;

    @Test
    public void testTripSearch(){

        Homepage airbnbHomepage = new Homepage();

        airbnbHomepage.sendKeysToDestination("New York");
        airbnbHomepage.createFlexibleSearch();
        String actualTitle = driver.getTitle();
        String expectedTitle = "Vacation Rentals, Homes, Hotels, Experiences & More - Airbnb";
        Assert.assertEquals(actualTitle, expectedTitle, "Title is incorrect.");
    }
}
