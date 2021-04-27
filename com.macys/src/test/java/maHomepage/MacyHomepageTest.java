package maHomepage;

import common.BaseAPI;
import macyHomepage.MacyHomepage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Locale;


public class MacyHomepageTest extends BaseAPI {


   //Test Case #1
    @Test
    public void testDoSearch(){
       MacyHomepage macyHomepage= new MacyHomepage();
       String expectedResult = "women shoes";
       macyHomepage.doSearch();


        String actualResult= macyHomepage.getTextFromElement(macyHomepage.expectedSearchResult);
        Assert. assertEquals(actualResult, expectedResult.toLowerCase(Locale.ROOT));
        }
        //Test case #2
        @Test
       public void testBootieSearchBox(){
        MacyHomepage macyHomepage= new MacyHomepage();
        macyHomepage.doSearch();
        macyHomepage.verifyBootieSearchBox();

            String actualAttributeValue = macyHomepage.expectedBootieSearchResult.getAttribute("Id");
            String expectedAttributeValue="#Booties";

        Assert.assertEquals( actualAttributeValue, expectedAttributeValue,"Attribute Value Do Not Match");

        }


    }

