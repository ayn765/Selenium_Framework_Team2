package attInternetTest;

import attInternetpage.AttInternetPage;
import common.BaseAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AttInternetTest extends BaseAPI {
    AttInternetPage attInternetPage;

    @Test(enabled = false)
    public void testNavigateToAttInternet() {
        attInternetPage = new AttInternetPage();
        attInternetPage.navigateToInternet();
        String actualLink = attInternetPage.getCurrentPageUrl();
        String expectedLink = "https://www.att.com/internet/fiber/";
        Assert.assertEquals(actualLink, expectedLink);
    }

    @Test(enabled = false)
    public void testSendMessageToCustomerService() {
        attInternetPage = new AttInternetPage();
        attInternetPage.sendChat();
    }

    @Test(enabled = false)
    public void testValidatePageDeal() {
        attInternetPage = new AttInternetPage();
        attInternetPage.infoRewardDeal();
        String currentLink = attInternetPage.getCurrentPageTitle();
        Assert.assertEquals(currentLink, "AT&T Fiber Internet – A Faster Connection | AT&T Internet");
    }

    @Test(enabled = false)
    public void testPageScrollDown() {
        attInternetPage = new AttInternetPage();
        attInternetPage.scrollDownUntilElementIsVisible();
    }

    @Test(enabled = false)
    public void testShoppingAndGoBackToHome() {
        attInternetPage = new AttInternetPage();
        attInternetPage.shopInternetAndGoBackMainPage();
    }
    @Test(enabled = false)
    public void testBackgroundCheckColor(){
        attInternetPage = new AttInternetPage();
        attInternetPage.backgroundColor();
        String actualColor=attInternetPage.feedbackButton.getCssValue("background-color");
        Assert.assertEquals(actualColor,"rgba(255, 255, 255, 1)");
    }
    @Test(enabled = false)
    public void testNumberOfLinksInAccountDropDown(){
        attInternetPage = new AttInternetPage();
        attInternetPage.navigateToAccountDropDown();
        int actualNumLinksInAccount=attInternetPage.calculateItemsInsideOfDrop();
        Assert.assertEquals(actualNumLinksInAccount,"7");
    }

    @Test(enabled = false)
    public void testProductReviews(){
        attInternetPage = new AttInternetPage();
        attInternetPage.shoppingProduct();
    }
    @Test(enabled = false)
    public void validateWhyAttText(){
        attInternetPage = new AttInternetPage();
        attInternetPage.whyATTInfo();
        boolean isTextInternetThere=attInternetPage.isWhyATTInternetTextDisplayed();
        Assert.assertTrue(isTextInternetThere);
    }
    @Test(enabled = false)
    public void testFeedBack(){
        attInternetPage = new AttInternetPage();
        attInternetPage.giveFeedback();
    }
    @Test(enabled = false)
    public void testValidateAttFacebook(){
        attInternetPage = new AttInternetPage();
        attInternetPage.checkAttOnFacebook();
    }
    @Test(enabled = false)
    public void testPlanLinkAtt(){
        attInternetPage = new AttInternetPage();
        attInternetPage.planLink();
        String actualLink=attInternetPage.getCurrentPageUrl();
        Assert.assertEquals(actualLink,"https://www.att.com/buy/bundles/?product_suite=NBB");
    }
    @Test(enabled = false)
    public void testAttEmailNotifications(){
        attInternetPage = new AttInternetPage();
        attInternetPage.moveToTextHeader();
        String actualText=attInternetPage.textHeader.getText();
        Assert.assertEquals(actualText,"So many reasons to love AT&T Internet");
    }
    @Test(dataProviderClass=AttInternetPage.class,dataProvider ="getInvalidSignIn")
    public void invalidSignIn(String email,String password){
        attInternetPage = new AttInternetPage();
        attInternetPage.signIn(email,password);
        String actualText = getTextFromElement(attInternetPage.errorText);
        String expectedText = "Incorrect Email or Password";

        Assert.assertEquals(actualText, expectedText, "INVALID LOGIN TEXT DOES NOT MATCH");
    }
}
