package becomeAHostPageTest;

import becomeAHostPage.AirbnbBecomeAHostPage;
import common.BaseAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AirbnbBecomeAHostPageTest extends BaseAPI {
    AirbnbBecomeAHostPage airbnbBecomeAHostPage;

    @Test(enabled = false)
    public void testSignUp() {
        airbnbBecomeAHostPage = new AirbnbBecomeAHostPage();
        airbnbBecomeAHostPage.clickOnContinueToSignUp();
    }
    @Test(enabled = false)
    public void testForInvalidSignUp(){
        airbnbBecomeAHostPage = new AirbnbBecomeAHostPage();
        airbnbBecomeAHostPage.invalidInput();
    }
    @Test(enabled = false)
    public void testRoomOptionDropDown(){
       airbnbBecomeAHostPage=new AirbnbBecomeAHostPage();
        airbnbBecomeAHostPage.clickOnEntirePlace();
    }
   @Test(enabled = false)
    public void testNumberOfGuest() {
       airbnbBecomeAHostPage = new AirbnbBecomeAHostPage();
       airbnbBecomeAHostPage.howManyGuests();
   }
   @Test(enabled = false)
   public void testNumberOfGuestDropDown(){
       airbnbBecomeAHostPage = new AirbnbBecomeAHostPage();
       int actualDropDownGuests=airbnbBecomeAHostPage.numberOfGuestsInTheDropDown();
       Assert.assertEquals(actualDropDownGuests,16);
   }
    @Test(enabled = false)
    public void testHelpHowToBookOnAirbnb(){
        AirbnbBecomeAHostPage airbnbBecomeAHostPage = new AirbnbBecomeAHostPage();
        airbnbBecomeAHostPage.hostHelpCustomerService();
    }
    @Test(enabled = false)
    public void testGuidesHost(){
        airbnbBecomeAHostPage = new AirbnbBecomeAHostPage();
        airbnbBecomeAHostPage.guidesHost();
    }

   @Test(enabled = false)
    public void testReceiveNotification(){
    airbnbBecomeAHostPage = new AirbnbBecomeAHostPage();
       airbnbBecomeAHostPage.checkTheBoxForNotification();
   }
  @Test(enabled = false)
    public void testProtectedHost(){
      airbnbBecomeAHostPage = new AirbnbBecomeAHostPage();
      airbnbBecomeAHostPage.protectedHostGiveThumbUp();
  }
  @Test(enabled =false)
    public void testSignUpWithFacebook(){
       airbnbBecomeAHostPage = new AirbnbBecomeAHostPage();
      airbnbBecomeAHostPage.useFacebookToSignUp();
  }
  @Test(enabled = false)
  public void testMac(){
     airbnbBecomeAHostPage = new AirbnbBecomeAHostPage();
      airbnbBecomeAHostPage.choseMacToSignUp();
  }
  @Test(enabled = false)
    public void testPotentialLink(){
     airbnbBecomeAHostPage = new AirbnbBecomeAHostPage();
      airbnbBecomeAHostPage.validateInfoPopUpDisplay();
  }
  @Test(enabled = false)
    public void testHostingWordVideo(){
        airbnbBecomeAHostPage = new AirbnbBecomeAHostPage();
      airbnbBecomeAHostPage.exploreHostingWord();
  }
  @Test(enabled = false)
    public void testHostCustomerSupport() {
      AirbnbBecomeAHostPage airbnbBecomeAHostPage = new AirbnbBecomeAHostPage();
      airbnbBecomeAHostPage.hostCustomerService();
  }

   @Test(enabled = false)
   public void testLearnToEarnMoneyWithAirbnb(){
        airbnbBecomeAHostPage = new AirbnbBecomeAHostPage();
       boolean actualPageDisplayed =airbnbBecomeAHostPage.earnMoneyAirbnb();
       Assert.assertEquals(actualPageDisplayed, true, "Expected page does not exist");
   }

    @Test(enabled = false)
    public void testPrivacyPolicy(){
        airbnbBecomeAHostPage = new AirbnbBecomeAHostPage();
        airbnbBecomeAHostPage.privacyPolicyairbnb();
    }
    @Test(enabled = false)
    public void TestRegisterForWebinar(){
        airbnbBecomeAHostPage = new AirbnbBecomeAHostPage();
        airbnbBecomeAHostPage.chooseDateForWebinar();
    }
    @Test(enabled = false)
    public void testNavigationToIsMySpaceAGoodFit(){
        airbnbBecomeAHostPage = new AirbnbBecomeAHostPage();
        String actualUrl= airbnbBecomeAHostPage.validateNavigationToUrl();
        String expectedUrl="https://www.airbnb.com/host/homes";
        Assert.assertEquals(actualUrl,expectedUrl,"URL's do not match");

    }
    @Test(enabled = true)
    public void TestDownloadPictureSelenium(){
        airbnbBecomeAHostPage = new AirbnbBecomeAHostPage();
        airbnbBecomeAHostPage.downloadPicture();
    }

  }


