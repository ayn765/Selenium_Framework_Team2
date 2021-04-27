package helpCenterPageTest;

import common.BaseAPI;
import helpCenterPage.AirbnbHelpCenterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AirbnbHelpCenterPageTest extends BaseAPI {
    AirbnbHelpCenterPage airbnbHelpCenterPage;


    @Test(enabled = false)
    public void testnavigaatetoHelpCenter(){//Xpath works(ButtonHelpCenter)
        airbnbHelpCenterPage=new AirbnbHelpCenterPage();
        airbnbHelpCenterPage.navigateToHelpCenter();
        String actualText=getTextFromElement(airbnbHelpCenterPage.expectedTextResult);//"Popular articles";
      String expectedText="Popular articles";
        //Assert.assertTrue(compareStrings(actualText,expectedText));
       Assert.assertEquals(actualText,expectedText);

    }
    @Test(enabled = false)
    public void testDosearch(){
        airbnbHelpCenterPage=new AirbnbHelpCenterPage();
        airbnbHelpCenterPage.doSearch("How does it work when Airbnb verifies your identity?");
        WebElement m2=waitForElementToBeClickable(airbnbHelpCenterPage.expectedTextSearch);

        String actualText=getTextFromElement(m2);//"Popular articles";
        String expectedText="Verify phone number";
        Assert.assertEquals(actualText,expectedText);
       // Assert.assertTrue(compareStrings(actualText,expectedText));

    }


    @Test(enabled = false)
    public void testPhoneNumebrBox(){
        airbnbHelpCenterPage=new AirbnbHelpCenterPage();
        airbnbHelpCenterPage.sendkeysToPhoneNumberBox("2679162412");
        WebElement m1=waitForElementToBeClickable(airbnbHelpCenterPage.expectedTextSearchPhoneNumeberBox);
        String actualText=getTextFromElement(m1);
        String expectedText="Confirm your number";
    }
    @Test(enabled = false)
    public void  testDropDownCountryindex()throws Exception{
        airbnbHelpCenterPage=new AirbnbHelpCenterPage();
        int index=3;
        airbnbHelpCenterPage.selectCountryDropDownIndex(index);

    }
    @Test(enabled = false)
    public void  testDropDownCountryText()throws Exception{
        airbnbHelpCenterPage=new AirbnbHelpCenterPage();
        String text="Algeria (+213)";
        airbnbHelpCenterPage.selectCountryDropDownText(text);

    }
    @Test(enabled = false)
    public void  testDropDownCountryValue()throws Exception{
        airbnbHelpCenterPage=new AirbnbHelpCenterPage();
        String value="1CA";
        airbnbHelpCenterPage.selectCountryDropDownValue(value);


    }
    @Test(enabled = false)
    public void testNumberOfCountryInDropDown(){//css works for (ButtonHelpCenter)
        airbnbHelpCenterPage=new AirbnbHelpCenterPage();
        airbnbHelpCenterPage.navigateToLogInPge();
       List<WebElement>elementList= getListOfWebElements(By.cssSelector(airbnbHelpCenterPage.getWEB_ELEMENTS_EXPECTED_OPTION_DROP_DOWN_COUNTRY()));
 int actualCount=elementList.size();
 int expectedCount=242;
 Assert.assertEquals(actualCount,expectedCount,"count do not match");

    }

    @Test(enabled = false)
    public void testElementDropDown(){//Xpath works for (ButtonHelpCenter)

        airbnbHelpCenterPage=new AirbnbHelpCenterPage();
        airbnbHelpCenterPage.navigateToLogInPge();
        selectElement(airbnbHelpCenterPage.dropDownCountry);

            Select country=new Select(airbnbHelpCenterPage.dropDownCountry);
            List<WebElement> country_List=country.getOptions();
            int total_country=country_List.size();
            System.out.println("the total of the country in drop_down list is : " +total_country);
            for(WebElement element:country_List){
                String country_name =element.getText();
                System.out.println("names in the country in drop_down list is :  "+ country_name);
            }
            int actualList=country_List.size();;


            int expectedList=total_country;
            //Assert.assertEquals(actualList,expectedList);
        Assert.assertEquals(actualList,expectedList);
        }
        @Test
    public void tsetIndexList(){
            airbnbHelpCenterPage=new AirbnbHelpCenterPage();
            airbnbHelpCenterPage.navigateToLogInPge();
            selectElement(airbnbHelpCenterPage.dropDownCountry);

            Select country=new Select(airbnbHelpCenterPage.dropDownCountry);

            airbnbHelpCenterPage.selectCountryDropDownIndex(3);
            country.selectByIndex(3);
            String actualOption =  country.getFirstSelectedOption().getText();
            System.out.println(actualOption);
            String expectedOption="Algeria (+213) ";
           Assert.assertEquals(actualOption,expectedOption);

        }

    @Test
    public void tsetvalueList(){
        airbnbHelpCenterPage=new AirbnbHelpCenterPage();
        airbnbHelpCenterPage.navigateToLogInPge();
        selectElement(airbnbHelpCenterPage.dropDownCountry);

        Select country=new Select(airbnbHelpCenterPage.dropDownCountry);

        airbnbHelpCenterPage.selectCountryDropDownValue("355AL");

        String actualOption =  country.getFirstSelectedOption().getText();
        System.out.println(actualOption);
        String expectedOption="Albania (+355) ";
        Assert.assertEquals(actualOption,expectedOption);

    }

    @Test
    public void tsetvisibletxtList(){
        airbnbHelpCenterPage=new AirbnbHelpCenterPage();
        airbnbHelpCenterPage.navigateToLogInPge();
        selectElement(airbnbHelpCenterPage.dropDownCountry);

        Select country=new Select(airbnbHelpCenterPage.dropDownCountry);

        airbnbHelpCenterPage.selectCountryDropDownText("Åland Islands (+358)");

        String actualOption =  country.getFirstSelectedOption().getText();
        System.out.println(actualOption);
        String expectedOption="Åland Islands (+358) ";
        Assert.assertEquals(actualOption,expectedOption);

    }








}





