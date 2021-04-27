package ebayTestFashionPage;


import common.BaseAPI;
import ebayFashionPage.EbayFashionPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EbayTestFashionPage extends BaseAPI {

    EbayFashionPage ebayFashionPage = new EbayFashionPage();

    @Test(enabled = false)
    public void testNavigationToFashionPage() { //passed
        ebayFashionPage = new EbayFashionPage();
        ebayFashionPage.selectFashionTab();

        Assert.assertTrue(isElementDisplayed(ebayFashionPage.textFashion));

    }
    //Test Case # 1(****)
    @Test(enabled = false)
    public void testBeautyButton() {


        ebayFashionPage = new EbayFashionPage();
        clickElement(ebayFashionPage.fashionTab);
        ebayFashionPage.verifyBeautyTab();

        Assert.assertTrue(isElementDisplayed(ebayFashionPage.beautyDropDownDisplayed));
    }

    //Test Case # 2
    @Test(enabled = false)
    public void testAllCategoriesDropDownButton() {
        ebayFashionPage = new EbayFashionPage();
        ebayFashionPage.verifyAllCategoriesDropDown();
        Assert.assertTrue(isElementSelected(ebayFashionPage.allCategoriesDropDown));

    }
    //Test Case # 3
    @Test(enabled = false)
    public void testSelectAntiquesOptionByValue() throws Exception {
        ebayFashionPage = new EbayFashionPage();
        String value = "20081";
        ebayFashionPage.selectOptionAntiqueUsingValue(value);

        Assert.assertTrue(isElementSelected(ebayFashionPage.optionAntiques));


    }
    //Test Case # 4
    @Test(enabled = false)
    public void testSelectingBabyOptionByVisibleText() throws Exception {
        ebayFashionPage = new EbayFashionPage();
        String visibleText = "Baby";
        ebayFashionPage.selectBabyByFromDropdownVisibleText(visibleText);


    }
    //Test Case # 5
    @Test(enabled = false)
    public void testSelectingArtOptionByIndex() {
        ebayFashionPage = new EbayFashionPage();
        ebayFashionPage.selectArtFromDropdownUsingIndex(1);


    }
    //Test Case # 6
    @Test(enabled = false)
    public void testSendingSearchBar() {
        ebayFashionPage = new EbayFashionPage();
        String searchKeys = "watches";
        ebayFashionPage.verifySearchBar(searchKeys);

        Assert.assertTrue(isElementDisplayed(ebayFashionPage.watchesText));

    }
    //Test Case # 7
    @Test(enabled = false)
    public void testShoppingCartButton() {
        ebayFashionPage = new EbayFashionPage();
        ebayFashionPage.verifyShoppingCartButton();
    }
    //Test Case # 8
    @Test(enabled = false)
    public void testSignInButton() {
        ebayFashionPage = new EbayFashionPage();
        ebayFashionPage.verifySignInButton();
        String expectedText = "Please verify yourself";


        Assert.assertTrue(isElementDisplayed(ebayFashionPage.signInTextExpected));
    }
    //Test Case # 9
    @Test(enabled = false)
    public void testContactAndHelpTab() {
        ebayFashionPage = new EbayFashionPage();
        ebayFashionPage.verifyHelpAndContactTab();

        String actualText = getTextFromElement(ebayFashionPage.customerService);
        String expectedText = "Customer Service";

        Assert.assertEquals(actualText,expectedText,"TEXTS DO NOT MUCH");

    }
    //Test Case # 10
    @Test(enabled = false)
    public void testRegister() {
        ebayFashionPage = new EbayFashionPage();
        ebayFashionPage.navigateToRegisterPage();



    }
    //Test Case # 11

    @Test(enabled = false)
    public void testCreatingAccountTab(){
        ebayFashionPage = new EbayFashionPage();


        ebayFashionPage.verifyCreatingAccountPage();

        Assert.assertTrue(isElementSelected(ebayFashionPage.registerButton));


    }
    //Test Case # 12
    @Test//(enabled = false)
    public void verifyMenClothingTab(){
        ebayFashionPage = new EbayFashionPage();
        ebayFashionPage.verifyMenClothingTab();

        Assert.assertTrue(isElementDisplayed(ebayFashionPage.headerMenCoatAndJackets));

    }
    //Test Case # 13
    @Test(enabled = false)
    public void testTopBrandsTab(){
        ebayFashionPage = new EbayFashionPage();
        ebayFashionPage.adidasPage();
        Assert.assertTrue(isElementDisplayed(ebayFashionPage.adidasPageTitle));

    }
    //Test Case # 14
     @Test(enabled = false)
     public void testSellTab(){
        ebayFashionPage = new EbayFashionPage();
        ebayFashionPage.verifySellTab();


        String expectedAttributeValue="textual-display fake-link category__selected pseudolink";
        String actualAttributeValue = (ebayFashionPage.athleticShoesHeader.getAttribute("class"));

        Assert.assertEquals(actualAttributeValue,expectedAttributeValue, "Attribute value do not match");
     }



}
