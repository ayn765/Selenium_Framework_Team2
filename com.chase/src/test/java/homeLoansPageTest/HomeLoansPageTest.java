package homeLoansPageTest;

import common.BaseAPI;
import homeLoansPage.HomeLoansPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeLoansPageTest extends BaseAPI {
    HomeLoansPage homeLoansPage;
@Test(enabled = false)
    public void testNvigationToHomeLoansPage(){
    homeLoansPage=new HomeLoansPage();
    homeLoansPage.navigateToHomeLoansPage();
    Assert.assertEquals(homeLoansPage.navigateToHomeLoansPage(),"https://www.chase.com/personal/mortgage");

}

    @Test(enabled = false)
    public void testList(){
        homeLoansPage=new HomeLoansPage();
        homeLoansPage.navigateToHomeLoansPage();
homeLoansPage.ValidateZipCode();}
    @Test
    public void testLangguageOnPage(){
        homeLoansPage=new HomeLoansPage();
        homeLoansPage.validateLanguage();}


}
