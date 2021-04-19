package bankofamericahomeloanstest;

import bankofamerica.BankOfAmericaHomeLoansPage;
import common.BaseAPI;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DataReader;

import java.io.IOException;


public class BankOfAmericaHomeLoansTest extends BaseAPI {
    BankOfAmericaHomeLoansPage bankOfAmericaHomeLoansPage;

    DataReader dataReader= new DataReader();

    @Test(enabled = false)
    public void testValidateTitle(){
        bankOfAmericaHomeLoansPage=new BankOfAmericaHomeLoansPage();
       String actualTitle= bankOfAmericaHomeLoansPage.verifyTitle();
       Assert.assertEquals(actualTitle,"Bank of America - Banking, Credit Cards, Loans and Merrill Investing");
    }
    @Test(enabled = false)
    public void testValidateSignIn(){
        bankOfAmericaHomeLoansPage=new BankOfAmericaHomeLoansPage();
        bankOfAmericaHomeLoansPage.applyToGetInfo();
       boolean result=bankOfAmericaHomeLoansPage.isSignInInfoDisplayed();
       Assert.assertTrue(result);
    }
    @Test(enabled = false)
    public void testValidateNumLinks(){
        bankOfAmericaHomeLoansPage=new BankOfAmericaHomeLoansPage();
        bankOfAmericaHomeLoansPage.numOfLinksInHomeBuyerPage();
       int actualNumLink=bankOfAmericaHomeLoansPage.numOfLinksInHomeBuyerPage();
        Assert.assertEquals(actualNumLink,"7");
    }
    @Test(enabled = false)
    public void testValidateAPRForOhio(){
        bankOfAmericaHomeLoansPage=new BankOfAmericaHomeLoansPage();
        bankOfAmericaHomeLoansPage.stateApr();
        String actualAPR=getTextFromElement(bankOfAmericaHomeLoansPage.laterApr);
        Assert.assertEquals(actualAPR,"Later:\n" +
                "4.350%\n" +
                "Variable APR\n" +
                "† after the introductory period");
    }

    @Test(enabled = false)
    public void testValidateStatesExcelSheet() throws IOException {
        bankOfAmericaHomeLoansPage=new BankOfAmericaHomeLoansPage();
        bankOfAmericaHomeLoansPage.checkStates();
        String excelPath=System.getProperty("user.dir")+"/src/test/resources/bankTest/AllStates.xlsx";
        Assert.assertTrue(compareListWebElementsToExcelDoc(bankOfAmericaHomeLoansPage.allStates,excelPath,"AllStatesTest"));
    }
   @Test(enabled = false)
    public void testNavigateBackText() throws IOException {
       bankOfAmericaHomeLoansPage=new BankOfAmericaHomeLoansPage();
       bankOfAmericaHomeLoansPage.checkHomeSweetHome();
       String actualPageTitle=getCurrentPageTitle();
       System.out.println("the page Title is: "+actualPageTitle);
       String path=System.getProperty("user.dir")+"/src/test/resources/bankTest/homeLink.xlsx";
       String[] titleArray=dataReader.fileReaderStringXSSF(path,"homeLink");
       String expectedTitle=titleArray[0];
       Assert.assertEquals(actualPageTitle,expectedTitle);
   }

   @Test(enabled = false)
    public void testVideo(){
       bankOfAmericaHomeLoansPage=new BankOfAmericaHomeLoansPage();
       bankOfAmericaHomeLoansPage.isVideoPlaying();
   }
   @Test(enabled = false)
    public void testViewMapForNewConstructionHome(){
       bankOfAmericaHomeLoansPage=new BankOfAmericaHomeLoansPage();
       bankOfAmericaHomeLoansPage.findNewConstructionHome();
   }
  @Test(enabled = false)
    public void testValidateSearchBYPrice(){
      bankOfAmericaHomeLoansPage=new BankOfAmericaHomeLoansPage();
      bankOfAmericaHomeLoansPage.searchHomeByPrice();
      String actualResult=getTextFromElement(bankOfAmericaHomeLoansPage.HomeResultSearch);
      Assert.assertEquals(actualResult,"24 new home communities found");

}
    @Test(enabled =false)
    public void testAppointment(){
        bankOfAmericaHomeLoansPage=new BankOfAmericaHomeLoansPage();
        bankOfAmericaHomeLoansPage.scheduleAppointment();
    }
}
