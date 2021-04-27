package onlineExperiencesPageTest;

import common.BaseAPI;
import onlineExperiencesPage.OnlineExperiencesPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class OnlineExperiencesPageTest extends BaseAPI {
    OnlineExperiencesPage onlineExperiencesPage;


    //Test Case # 1 (**)
    @Test ( enabled = false)
    public void testNavigateToHomepage(){

        onlineExperiencesPage = new OnlineExperiencesPage();
    onlineExperiencesPage.clickExperiencesPageButton();
    onlineExperiencesPage.verifyNavigationToAirbnbHomepage();
}
    //Test Case # 2*
   @Test (enabled = false)
    public void testLogInButton() {

       onlineExperiencesPage = new OnlineExperiencesPage();
       onlineExperiencesPage.clickExperiencesPageButton();
       onlineExperiencesPage.verifyLoginButton();
   }

    //Test Case #  (**)
   @Test  (enabled = false)
   public void testListOfLabelsDisplayed(){
       onlineExperiencesPage = new OnlineExperiencesPage();
       onlineExperiencesPage.clickExperiencesPageButton();
       List<WebElement> elementList = onlineExperiencesPage.expectedListOfLabelsDisplayed;
       Assert.assertTrue(isElementDisplayed(onlineExperiencesPage.dateTab));



   }
    //Test Case # 4 (**)
    @Test(enabled = false)
    public void testSwitchingToFiltersTab(){
        onlineExperiencesPage = new OnlineExperiencesPage();
        onlineExperiencesPage.verifySwitchingToFilterTab();

        Assert.assertTrue(isElementDisplayed(onlineExperiencesPage.showAllOnlineExperiencesRes));

    }

    //Test Case # 5 *
   @Test(enabled = false)
   public void testSelectingDate(){
     onlineExperiencesPage = new OnlineExperiencesPage();
     onlineExperiencesPage.verifySelectDateTab();


       Assert.assertTrue(isElementSelected(onlineExperiencesPage.dateAprilTwentySeven));

    }
    //Test Case # 6 (**)
    @Test(enabled = false)
    public void testGroupSizeButton() {
        onlineExperiencesPage = new OnlineExperiencesPage();
        onlineExperiencesPage.verifySelectGroupSize();

        Assert.assertTrue(isElementSelected(onlineExperiencesPage.numberOfGuestsSelected));
    }
    //Test Case # 7 *
    @Test(enabled = false)
    public void testSwitchWindowToSangriaPage(){
        onlineExperiencesPage = new OnlineExperiencesPage();
        onlineExperiencesPage.verifySwitchToSangriaPage();

        Assert.assertTrue(isElementDisplayed(onlineExperiencesPage.checkSangriaImage));

    }





}

