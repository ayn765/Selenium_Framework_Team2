package profilePageTest;

import common.BaseAPI;
import homePageTrulia.HomePageTrulia;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import profilePage.ProfilePage;

public class ProfilePageTest extends BaseAPI {
    HomePageTrulia homePageTrulia;
    ProfilePage profilePage;
     @Test
    public void TestSaveProfile(){


        homePageTrulia=new HomePageTrulia();
         homePageTrulia.navigateTpProfilePage().savedProfile("jhkfjd","2676194567",3);

     }
}
