package truliaFinfHomeTest;

import common.BaseAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import truliaFindHome.TruliaFindHome;

import java.util.List;

public class TruliaFindHomeTest extends BaseAPI {

   TruliaFindHome truliaFindHome = new TruliaFindHome();

   //Test Case # 1 (P)
    @Test(enabled = false)
    public void testSearchBar(){
        TruliaFindHome truliaFindHome = new TruliaFindHome();
       truliaFindHome.verifySearchBar();

       //     String actualAttributeValue = truliaFindHome.newHanoverHeaderText.getAttribute("class");
//        String expectedAttributeValue ="Text__TextBase-sc-1cait9d-0-div Text__TextContainerBase-sc-1cait9d-1 ilVROc";
//        Assert.assertEquals(actualAttributeValue, expectedAttributeValue, "COLOR DOES NOT MATCH");


        String actualText=truliaFindHome.newHanoverHeaderText.getText();
        String expectedText="See the Homes";
        Assert.assertEquals(actualText,expectedText,"Texts do not match");

    }
    //Test Case #2 (P)
@Test (enabled = false)
    public void testHouseTab(){
        TruliaFindHome truliaFindHome = new TruliaFindHome();
        truliaFindHome.verifyHouseTab();
    String actualText=truliaFindHome.newHanoverHeaderText.getText();
    String expectedText="See the Homes";
    Assert.assertEquals(actualText,expectedText,"Texts do not match");




        //truliaFindHome.selectCondoCheckBox();
//     String actualAttributeValue = truliaFindHome.headerCondo.getAttribute("id");
//     String expectedAttributeValue = "Condo";
//    System.out.println(actualAttributeValue);
//    System.out.println(expectedAttributeValue);
//
//    Assert.assertEquals(actualAttributeValue,expectedAttributeValue,"Texts do not match");

    }

    //Test Case #3 (P)
    @Test(enabled = false)
    public void testSavedHomesTab(){
        TruliaFindHome truliaFindHome = new TruliaFindHome();
        truliaFindHome.verifySavedHomeTab();
        truliaFindHome.enterEmailAddress();

        String actualAttributeValue = truliaFindHome.submitButton.getAttribute("Type");
        String expectedAttributeValue = "submit";
        System.out.println(actualAttributeValue);
       System.out.println(expectedAttributeValue);

        Assert.assertEquals(actualAttributeValue,expectedAttributeValue,"Texts do not match");

    }
    //Test Case # 4 P
    @Test(enabled = false)
    public void testNumberOfElementsInAnyPriceTab(){
        TruliaFindHome truliaFindHome = new TruliaFindHome();
        List<WebElement> elementList =truliaFindHome.expectedNumberOfElementsAnyPriceTabDropDown;
        int actualCount = elementList.size();
        int expectedCount= 1;
        Assert.assertEquals(actualCount, expectedCount, "COUNT OF CATEGORIES DOES NOT MATCH");
    }
  //Test Case # 5 P
    @Test(enabled = false)
    public void testSelectByIndex() throws Exception{
        truliaFindHome = new TruliaFindHome();
        truliaFindHome.selectFromAnyPriceDropdownUsingIndex(2);

    }
    //Test Case # 6 P
   @Test(enabled = false)
   public void testSelectByValue(){
       truliaFindHome = new TruliaFindHome();
        String value ="$30k";
        truliaFindHome.selectFromAnyPriceDropdownUsingValue(value);

    }
    //Test Case # 7 (P)
    @Test(enabled = false)
    public void testSelectByVisibleText(){
        truliaFindHome = new TruliaFindHome();
        String visibleText="$100k";
        truliaFindHome.selectFromAnyPriceDropdownUsingVisibleText(visibleText);
    }
    //Test Case # 8 (P)
    @Test(enabled = false)
    public void testAllBedsTab(){
        truliaFindHome = new TruliaFindHome();
        truliaFindHome.checkAllBedsTab();

        Assert.assertTrue(isElementDisplayed(truliaFindHome.selectStudioPlusOption));
    }

    //Test Case # 9 (P)
    @Test(enabled = false)
    public void testSavedSearchesTab(){
        truliaFindHome = new TruliaFindHome();
        truliaFindHome.verifySavedSearchesTab();

        Assert.assertTrue(isElementDisplayed(truliaFindHome.headerSavedSearches));
    }
    //Test Case # 10 (P)
    @Test(enabled = false)
    public void testMoreTab(){
        truliaFindHome = new TruliaFindHome();
        truliaFindHome.checkMoreTab();
Assert.assertTrue(isElementDisplayed(truliaFindHome.savedSearchHeader));

    }
    //Test Case # 11
    @Test(enabled = false)
    public void testAgentListingsTab(){
        truliaFindHome = new TruliaFindHome();
        truliaFindHome.verifyAgentListingsTab();
        Assert.assertTrue(isElementDisplayed(truliaFindHome.sortResult));

    }
    //Test Case # 12(P)
    @Test(enabled = false)
    public void testMortgageTab(){
        truliaFindHome = new TruliaFindHome();
        truliaFindHome.verifyMortgageTab();
        Assert.assertTrue(isElementDisplayed(truliaFindHome.prequalifiedButton));
//
    }
    //TEst Case # 13
    @Test (enabled = false)
    public void testEnterZipCodeToQualifyForMortgage(){
        truliaFindHome = new TruliaFindHome();
        truliaFindHome.verifyMortgageTab();
        truliaFindHome.verifyEnteringZipCodeInMortgageTab();
        String actualAttributeValue = truliaFindHome.prequalifiedButton.getAttribute("Text");
        String expectedAttributeValue = "Get Pre-Qualified";
        System.out.println(actualAttributeValue);
        System.out.println(expectedAttributeValue);

        Assert.assertEquals(actualAttributeValue,expectedAttributeValue,"Texts do not match");
    }


    //Test Case # 14 (***)
    @Test(enabled = false)
    public void testRentTab(){
        truliaFindHome = new TruliaFindHome();
        truliaFindHome.verifyRentTab();
        String actualAttributeValue = truliaFindHome.sortResult.getAttribute("class");
        String expectedAttributeValue = "Select__NativeSelect-sc-1l7enz0-1 hltsmt";
        System.out.println(actualAttributeValue);
        System.out.println(expectedAttributeValue);

        Assert.assertEquals(actualAttributeValue,expectedAttributeValue,"Texts do not match");
    }
    //Test Case # 15 (*)
    @Test//(enabled = false)
    public void TestListOfMortgageOptions () throws Exception {
        truliaFindHome = new TruliaFindHome();
        Assert.assertTrue(truliaFindHome.compareListOfElementToExcelSheet());


    }


}







