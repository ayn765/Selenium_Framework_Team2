package expediaStaysTest;

import common.BaseAPI;
import expediaStays.ExpediaStaysPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExpediaStaysTest extends BaseAPI {
 ExpediaStaysPage expediaStaysPage;
 @Test(enabled = false)
 public void testDestinationSearch(){
  expediaStaysPage=new ExpediaStaysPage();
  expediaStaysPage.searchStayDestination();
  String actual=getTextFromElement(expediaStaysPage.firstResult);
  Assert.assertEquals(actual,"Courtyard Mexico City Airport","titles do not match");
 }
@Test(enabled = false)
 public void testStaysDeals(){
 expediaStaysPage=new ExpediaStaysPage();
 expediaStaysPage.searchDeals();

}
@Test
 public void testvalidateLinkSearch(){
 expediaStaysPage=new ExpediaStaysPage();
 expediaStaysPage.searchInMap();
 String currentLink=expediaStaysPage.getCurrentPageUrl();
 Assert.assertEquals(currentLink,"www.expedia.com/Mexico-City-Hotels-Econo-Express-Hotel");
}
 @Test
 public void testSearchByPics(){
  expediaStaysPage=new ExpediaStaysPage();
  expediaStaysPage.bookRoom();
 }
}
