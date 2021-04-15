package homepageTest;

import common.BaseAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AirbnbCovid19Test extends BaseAPI {
    AirbnbCovid19 airbnbCovid19;
    @BeforeMethod
    public void getInit(){
        airbnbCovid19= PageFactory.initElements(driver,AirbnbCovid19.class);
    }

    @Test(enabled = false)
    public void testCheckTopics() throws InterruptedException {
        AirbnbCovid19 airbnbHomepage = new AirbnbCovid19();
      airbnbCovid19.checkTopics();
        String actualTitle = driver.getTitle();
        String expectedTitle = "About hosting - Resource Center";
        Assert.assertEquals(actualTitle, expectedTitle, "Title is incorrect.");
    }
  @Test(enabled = false)
    public void testCheckTitle(){
      AirbnbCovid19 airbnbHomepage = new AirbnbCovid19();
        airbnbCovid19.checkTitle();
      String actualTitle = driver.getTitle();
      String expectedTitle = "Your online listing - Resource Center";
      Assert.assertEquals(actualTitle, expectedTitle, "Title is incorrect.");
}
@Test
    public void testSignUp() throws InterruptedException {
    AirbnbCovid19 airbnbHomepage = new AirbnbCovid19();
        airbnbCovid19.signUp();
    String actualTitle = driver.getTitle();
    String expectedTitle = "Log In / Sign Up";
    Assert.assertEquals(actualTitle, expectedTitle, "Title is incorrect.");
}
@Test
public void testScrollToSettingUpSuccessfulListing() throws InterruptedException {
    AirbnbCovid19 airbnbHomepage = new AirbnbCovid19();
    airbnbHomepage.scrollToSettingUpSuccessfulListing();

}


//    AirbnbHomepage airbnbHomepage;

//    @Test
//    public void testTripSearch(){
//
//        AirbnbHomepage airbnbHomepage = new AirbnbHomepage();
//
//        airbnbHomepage.sendKeysToDestination("New York");
//        airbnbHomepage.createFlexibleSearch();
//        String actualTitle = driver.getTitle();
//        String expectedTitle = "Vacation Rentals, Homes, Hotels, Experiences & More - Airbnb";
//        Assert.assertEquals(actualTitle, expectedTitle, "Title is incorrect.");
//    }
}
