package carsPageTest;

import carsPage.CarsPage;
import common.BaseAPI;
import io.cucumber.java.nl.Stel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class CarsPageTest extends BaseAPI {
    CarsPage carsPage;

    @Test(enabled = false)
    public void testCarsPage() {
        carsPage = new CarsPage();
        carsPage.navigateToCARSPage();
        Assert.assertEquals(getTextFromElement(carsPage.expectedImageCarsPage), "Switch up your routine\n" +
                "Enjoy a weekend away at a vacation rental near Philadelphia");

    }

    @Test(enabled = false)
    public void testRentalCarsPAGE() {
        carsPage = new CarsPage();
        carsPage.navigateToCARSPage();
        clickElement(carsPage.buttonRentalCars);
        Assert.assertEquals(getTextFromElement(carsPage.expectedImageCarsPage), "Switch up your routine\n" +
                "Enjoy a weekend away at a vacation rental near Philadelphia");


    }

    @Test(enabled = false)
    public void testAIRPORTTRANSPORTATIONPAGE() {
        carsPage = new CarsPage();
        carsPage.navigateToCARSPage();
        clickElement(carsPage.buttonAirportTransportation);
        Assert.assertEquals(getTextFromElement(carsPage.expectedImageCarsPage), "Switch up your routine\n" +
                "Enjoy a weekend away at a vacation rental near Philadelphia");
    }

    @Test(enabled = false)
    public void testSizeofDropDownRentalCompany() {
        carsPage = new CarsPage();

        carsPage.clickOndiscountbuton();

        Select company = new Select(carsPage.dropDownRentalCompany);
        List<WebElement> company_List = company.getOptions();
        Assert.assertEquals(company_List.size(), 21);


    }

    @Test(enabled = false)
    public void testOptionOfDropDownRentalCompany() {
        carsPage = new CarsPage();

        carsPage.clickOndiscountbuton();

        Select company = new Select(carsPage.dropDownRentalCompany);
        List<WebElement> company_List = company.getOptions();

        for (WebElement element : company_List) {
            String actualCompany_name = element.getText();
            System.out.println(actualCompany_name);
            String expectedCompany_name = "Rental car company\n" +
                    "Ace Rent A Car\n" +
                    "Advantage Rent-A-Car\n" +
                    "Alamo Rent A Car\n" +
                    "Avis\n" +
                    "Budget\n" +
                    "Dollar Rent A Car\n" +
                    "Economy Rent a Car\n" +
                    "Enterprise\n" +
                    "Europcar\n" +
                    "Fox Rent a Car\n" +
                    "Hertz\n" +
                    "Midway Car Rental\n" +
                    "National Car Rental\n" +
                    "Nu Car\n" +
                    "Payless\n" +
                    "Routes Car Rental\n" +
                    "Sixt\n" +
                    "Thrifty Car Rental\n" +
                    "U-Save\n" +
                    "Silvercar";
            Assert.assertEquals(actualCompany_name, expectedCompany_name);

        }


    }

    @Test(enabled = false)
    public void testSelectElmentFromDropDownRentalCompanybyValue() {
        carsPage = new CarsPage();

        carsPage.clickOndiscountbuton();

        Select company = new Select(carsPage.dropDownRentalCompany);
        company.selectByValue("NO_PREFERENCE");
        Assert.assertEquals(company.getFirstSelectedOption().getText(), "Rental car company");
    }



    @Test(enabled = false)
    public void test2SelectElmentFromDropDownRentalCompanybyIndex() {
        carsPage = new CarsPage();
        carsPage.clickOndiscountbuton();
        Select company = new Select(carsPage.dropDownRentalCompany);
        company.selectByIndex(3);
        String actualOption = company.getFirstSelectedOption().getText();
        Assert.assertEquals(company.getFirstSelectedOption().getText(), "Alamo Rent A Car");

    }

    @Test(enabled = false)//////////////
    public void test2SelectElmentFromDropDownRentalCompanybyvisbleText() {
        carsPage = new CarsPage();

        carsPage.clickOndiscountbuton();

        Select company = new Select(carsPage.dropDownRentalCompany);
        company.selectByVisibleText("Europcar");
        Assert.assertEquals(company.getFirstSelectedOption().getText(),"Europcar" );

    }

    @Test(enabled = false)
    public void testSizeOfInputPickUpDateBox() {
        carsPage = new CarsPage();
        carsPage.clickONDropDownTimeToPickUp();
        Select time= new Select(carsPage.dropDownTimeToPickUp);
        List<WebElement> time_List = time.getOptions();
        Assert.assertEquals(time_List.size(), 96);
    }

    @Test(enabled = false)
    public void testOptionOfInputPickUpDateBox() {
        carsPage = new CarsPage();
        carsPage.clickOndiscountbuton();
        Select time = new Select(carsPage.dropDownTimeToPickUp);
        List<WebElement> time_List = time.getOptions();

        for (WebElement element : time_List) {
            String actualCompany_name = element.getText();
            System.out.println(actualCompany_name);}}



    @Test(enabled = false)
    public void testSizeOfInputDropOffDateBox() {
        carsPage = new CarsPage();
        carsPage.clickONDropDownTimeToPickUp();
        Select time= new Select(carsPage.dropDownTimeToDropOff);
        List<WebElement> time_List = time.getOptions();
        int actualSizeList = time_List.size();
        int expectedSizeList = 96;
        Assert.assertEquals(actualSizeList, expectedSizeList);
    }

    @Test(enabled = false)
    public void testOptionOfInputDropOffDateBox() {
        carsPage = new CarsPage();
        carsPage.clickOndiscountbuton();
        Select time = new Select(carsPage.dropDownTimeToDropOff);
        List<WebElement> time_List = time.getOptions();

        for (WebElement element : time_List) {
            String actualCompany_name = element.getText();
            System.out.println(actualCompany_name);
        }
    }

    @Test(enabled = false)
    public void testsendkeydtoPickUpcare() {
        carsPage=new CarsPage();
        carsPage.sendKeysINPUT_PICK_UP_BOX("perkiomenville");
        Assert.assertEquals(carsPage.inputPickUpDateBox.getAttribute("value"),"");


    }

    @Test(enabled = false)
    public void testsendkeydtoDropOffBox() {
        carsPage=new CarsPage();
        carsPage.sendKeysINPUT_SAME_AS_PICK_UP_BOX("perkiomenville");
        Assert.assertEquals(carsPage.inputSameAsPickUpBOX.getAttribute("class"),"uitk-faux-input");


    }

    @Test(enabled = false)
    public void testsendkeydToAirportBox() {
        carsPage=new CarsPage();
        carsPage.navigateToAirportTransportationPage();
        carsPage.sendKeysINPUtAirPortBox("jfk");
        Assert.assertEquals(carsPage.inputAirPortBox.getAttribute("class"),"uitk-faux-input");


    }

    @Test(enabled = false)
    public void testsendkeydToHotelName() {
        carsPage=new CarsPage();
        carsPage.sendKeysINPUtHotelNameBox("New York");
        Assert.assertEquals(carsPage.inputAirPortBox.getAttribute("type"),"button");
    }


    @Test(enabled = false)
    public void testSizeOfInputArrivalDateBox() {
        carsPage = new CarsPage();
        carsPage.navigateToAirportTransportationPage();
        Select time= new Select(carsPage.dropDownArrivalTime);
        List<WebElement> time_List = time.getOptions();
        int actualSizeList = time_List.size();
        Assert.assertEquals(actualSizeList,96 );
    }

    @Test(enabled = false)
    public void testSizeOfInputDepartureDateBox() {
                  carsPage = new CarsPage();
                  carsPage.navigateToAirportTransportationPage();
        clickElement(carsPage.buttonRoundTrip);

        Select time= new Select(carsPage.dropDownArrivalTime);
        List<WebElement> time_List = time.getOptions();
        int actualSizeList = time_List.size();
        Assert.assertEquals(actualSizeList, 96);
    }

@Test(enabled = false)
    public void testCalenderPickUpDate(){
                      carsPage=new CarsPage();
        carsPage.navigateToCARSPage();
        carsPage.selectDateJS(driver,carsPage.inputPickUpBOX,"4-3-2021");;
    Assert.assertEquals(carsPage.inputPickUpBOX.getAttribute("value"),"4-3-2021");


}@Test(enabled = false)
    public void testCalenderDropOffDate(){
        carsPage=new CarsPage();
        carsPage.navigateToCARSPage();
        carsPage.selectDateJS(driver,carsPage.inputDropOffDateBox,"4-12-2021");
        String actualDAteSelected= carsPage.inputDropOffDateBox.getAttribute("value");
        System.out.println(actualDAteSelected);
        String expectedDateSelected="4-12-2021";
        Assert.assertEquals(actualDAteSelected,expectedDateSelected);


    }

    @Test(enabled = false)
    public void TestNameinDropDownOption() throws IOException {
        carsPage=new CarsPage();
        carsPage.clickOndiscountbuton();
       String sheetPath=System.getProperty("user.dir")+ "RentalCompanyName.xlsx";
       Assert.assertTrue(compareAttributeListToExpectedStringArray(By.cssSelector("#Rental-cars-transportation > details > div > div > div > div > select"),"innerHTML",sheetPath,"RentalCompanyName"));
    }

    @Test(enabled = false)
    public void testiframe() {
        carsPage=new CarsPage();
        carsPage.navigateToCARSPage();
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println(size);
    }
    @Test
    public void tes() {
        carsPage = new CarsPage();
        carsPage.navigateToCARSPage();
        carsPage.sendKeysINPUT_SAME_AS_PICK_UP_BOX("perkiomenville");
        String a=carsPage.inputSameAsPickUpBOX.getAttribute("class");
        driver.navigate().forward();

    }






}