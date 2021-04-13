package ebayhomegardenpagetest;

import common.BaseAPI;
import ebayhomegarden.EbayHomeGardenPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class EbayHomeGardenPageTest extends BaseAPI {
  EbayHomeGardenPage ebayHomeGardenPage;

    @Test(enabled = false)
    public void testNavigateToHomeGarden(){
        ebayHomeGardenPage=new EbayHomeGardenPage();
        ebayHomeGardenPage.navigateToHomeGarden();
        boolean actualResult= ebayHomeGardenPage.checkIfPageDisplay();
        Assert.assertEquals(actualResult,true,"Page doesn't display");
    }

    @Test(enabled = false)
    public void tesSearchProductInHomePage(){
        ebayHomeGardenPage=new EbayHomeGardenPage();
        ebayHomeGardenPage.searchProduct();
    }
    @Test(enabled = false)
    public void testNavigateToWomenClothingInFashion(){
        ebayHomeGardenPage=new EbayHomeGardenPage();
       ebayHomeGardenPage.navigateToWomenClothing();
    }
  @Test(enabled = false)
    public void testGoBackToMainPage(){
      ebayHomeGardenPage=new EbayHomeGardenPage();
      ebayHomeGardenPage.validateDoMoveBackward();
      String actualUrl = super.getCurrentPageUrl();
      String expectedUrl = "https://www.ebay.com/";
      Assert.assertEquals(actualUrl, expectedUrl,"links Do Not Match");
  }
     @Test(enabled=false)
    public void testValidateAttribute(){
         ebayHomeGardenPage=new EbayHomeGardenPage();
         ebayHomeGardenPage.hoverHomeGardenHeader();
         String actualAttribute = ebayHomeGardenPage.homeGardenHeader.getAttribute("style");
         String expectedAttribute = "background: linear-gradient(to right, rgb(113, 227, 226) 70%, rgb(2, 162, 172) 70%, rgb(2, 162, 172) 90%, rgb(101, 158, 255) 90%); color: rgb(18, 18, 88);";
         Assert.assertEquals(actualAttribute, expectedAttribute, "AtT DOES NOT MATCH");
     }

    @Test(enabled=false)
    public void testValidateResultForLowestPriceItems(){
        ebayHomeGardenPage=new EbayHomeGardenPage();
        ebayHomeGardenPage.sortItems();
        String actualResult=getTextFromElement(ebayHomeGardenPage.howManyResult);
        String expectedResult="1-12 of 12 Results";
        Assert.assertEquals(actualResult,expectedResult,"Results Do not Match");
    }

    @Test(enabled=false)
    public void testDinnerWare(){
        ebayHomeGardenPage=new EbayHomeGardenPage();
        ebayHomeGardenPage.dinnerWareChoosePrice();
          boolean isTitleDisplayed=ebayHomeGardenPage.dinnerwareHeaderResult.isDisplayed();
          Assert.assertTrue(isTitleDisplayed);
    }
   @Test(enabled=false)
    public void testAddSmartTvToTheCart(){
       ebayHomeGardenPage=new EbayHomeGardenPage();
       ebayHomeGardenPage.addSonySmartTvToTheCart();
   }

   @Test(enabled=false)
    public void testValidateNumOfLinksInTheFurnitureDropDown(){
       ebayHomeGardenPage=new EbayHomeGardenPage();
        int actualNumOfLinks=ebayHomeGardenPage.numElementsInHomeGardenShopCategoryDrop();
        Assert.assertEquals(actualNumOfLinks,15);
   }
    @Test (enabled=false)
    public void testItemIsAvailable(){
       ebayHomeGardenPage=new EbayHomeGardenPage();
       ebayHomeGardenPage.searchItemInHousekeepingPage();
       boolean isAvailable=ebayHomeGardenPage.houseKeepingTool.isDisplayed();
       Assert.assertTrue(isAvailable);
   }
   @Test(enabled=false)
    public void testValidateKitchenAppliancesNumber() {
       ebayHomeGardenPage = new EbayHomeGardenPage();
       int actualResult=ebayHomeGardenPage.categoryKitchenAplliances();
       Assert.assertEquals(actualResult,12);
   }
    @Test(enabled=false)
    public void validateTopBrandPage(){
        ebayHomeGardenPage = new EbayHomeGardenPage();
        ebayHomeGardenPage.topProductBrand();
        String actual= getTextFromElement(ebayHomeGardenPage.topBrandProductPage);
        String result="Husqvarna Outdoor Power Equipment";
        Assert.assertEquals(actual,result);
    }
    @Test(enabled=false)
    public void testGoBackToGardenPage(){
        ebayHomeGardenPage = new EbayHomeGardenPage();
        ebayHomeGardenPage.navigateBack();
    }
    @Test(enabled=false)
    public void testValidateResultForPriceRange(){
        ebayHomeGardenPage = new EbayHomeGardenPage();
        ebayHomeGardenPage.selectHomeItemsPrice();
        String actualResult=getTextFromElement(ebayHomeGardenPage.priceRangeResult);
        Assert.assertEquals(actualResult,"22 results for Smart Home Automation");
    }

   @Test(enabled=false)
    public void testAdvancedSearch(){
       ebayHomeGardenPage = new EbayHomeGardenPage();
       ebayHomeGardenPage.advancedSearchHOMEGArden();
       String actual=getTextFromElement(ebayHomeGardenPage.advancedSearchResult);
       Assert.assertEquals(actual,"69,015 results for indoor plants indoor plants");
   }

@Test(enabled=false)
    public void testClearSearchAndGoBack(){
    ebayHomeGardenPage = new EbayHomeGardenPage();
    ebayHomeGardenPage.clearSearch();
}

}


