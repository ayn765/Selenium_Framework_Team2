package becomeAHostPageTest;

import becomeAHostPage.AirbnbBecomeAHostPage;
import common.BaseAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AirbnbBecomeAHostPageTest extends BaseAPI {
    AirbnbBecomeAHostPage airbnbBecomeAHostPage;

    @Test
    public void testSignUp() {
        AirbnbBecomeAHostPage airbnbBecomeAHostPage = new AirbnbBecomeAHostPage();
        airbnbBecomeAHostPage.clickOnContinueToSignUp();
    }
    @Test
    public void testForInvalidSignUp(){
        AirbnbBecomeAHostPage airbnbBecomeAHostPage = new AirbnbBecomeAHostPage();
        airbnbBecomeAHostPage.invalidInput();
    }
    @Test
    public void testRoomOptionDropDown(){
        AirbnbBecomeAHostPage airbnbBecomeAHostPage=new AirbnbBecomeAHostPage();
        airbnbBecomeAHostPage.clickOnEntirePlace();
    }
   @Test
    public void testNumberOfGuest() {
       AirbnbBecomeAHostPage airbnbBecomeAHostPage = new AirbnbBecomeAHostPage();
       airbnbBecomeAHostPage.howManyGuests();
   }
   @Test
   public void testNumberOfGuestDropDown(){
       AirbnbBecomeAHostPage airbnbBecomeAHostPage = new AirbnbBecomeAHostPage();
       int actualDropDownGuests=airbnbBecomeAHostPage.numberOfGuestsInTheDropDown();
       Assert.assertEquals(actualDropDownGuests,16);
   }
    @Test
    public void testHelpHowToBookOnAirbnb(){
        AirbnbBecomeAHostPage airbnbBecomeAHostPage = new AirbnbBecomeAHostPage();
        airbnbBecomeAHostPage.hostHelpCustomerService();
    }
    @Test
    public void testGuidesHost(){
        AirbnbBecomeAHostPage airbnbBecomeAHostPage = new AirbnbBecomeAHostPage();
        airbnbBecomeAHostPage.guidesHost();
    }

   @Test
    public void testReceiveNotification(){
       AirbnbBecomeAHostPage airbnbBecomeAHostPage = new AirbnbBecomeAHostPage();
       airbnbBecomeAHostPage.checkTheBoxForNotification();
   }
  @Test
    public void testProtectedHost(){
      AirbnbBecomeAHostPage airbnbBecomeAHostPage = new AirbnbBecomeAHostPage();
      airbnbBecomeAHostPage.protectedHostGiveThumbUp();
  }
  @Test
    public void testSignUpWithFacebook(){
      AirbnbBecomeAHostPage airbnbBecomeAHostPage = new AirbnbBecomeAHostPage();
      airbnbBecomeAHostPage.useFacebookToSignUp();
  }
  @Test
  public void testMac(){
      AirbnbBecomeAHostPage airbnbBecomeAHostPage = new AirbnbBecomeAHostPage();
      airbnbBecomeAHostPage.choseMacToSignUp();
  }
  @Test
    public void testPotentialLink(){
      AirbnbBecomeAHostPage airbnbBecomeAHostPage = new AirbnbBecomeAHostPage();
      airbnbBecomeAHostPage.validateInfoPopUpDisplay();
  }
  @Test
    public void testHostingWordVideo(){
      AirbnbBecomeAHostPage airbnbBecomeAHostPage = new AirbnbBecomeAHostPage();
      airbnbBecomeAHostPage.exploreHostingWord();
  }
  @Test
    public void testHostCustomerSupport() {
      AirbnbBecomeAHostPage airbnbBecomeAHostPage = new AirbnbBecomeAHostPage();
      airbnbBecomeAHostPage.hostCustomerService();
  }

   @Test
   public void testLearnToEarnMoneyWithAirbnb(){
       AirbnbBecomeAHostPage airbnbBecomeAHostPage = new AirbnbBecomeAHostPage();
       boolean actualPageDisplayed =airbnbBecomeAHostPage.earnMoneyAirbnb();
       Assert.assertEquals(actualPageDisplayed, true, "Expected page does not exist");
   }

    @Test
    public void testPrivacyPolicy(){
        AirbnbBecomeAHostPage airbnbBecomeAHostPage = new AirbnbBecomeAHostPage();
        airbnbBecomeAHostPage.privacyPolicyairbnb();
    }
    @Test
    public void TestRegisterForWebinar(){
        AirbnbBecomeAHostPage airbnbBecomeAHostPage = new AirbnbBecomeAHostPage();
        airbnbBecomeAHostPage.chooseDateForWebinar();
    }
    @Test
    public void testNavigationToIsMySpaceAGoodFit(){
        AirbnbBecomeAHostPage airbnbBecomeAHostPage = new AirbnbBecomeAHostPage();
        String actualUrl= airbnbBecomeAHostPage.validateNavigationToUrl();
        String expectedUrl="https://www.airbnb.com/host/homes";
        Assert.assertEquals(actualUrl,expectedUrl,"URL's do not match");

    }
    @Test
    public void TestSaveImageSelenium(){
        AirbnbBecomeAHostPage airbnbBecomeAHostPage = new AirbnbBecomeAHostPage();
        airbnbBecomeAHostPage.saveImageFileOnSite();
    }

  }


