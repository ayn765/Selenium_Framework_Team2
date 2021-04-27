package verizonHomepage;

import common.BaseAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DataReader;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static verizonHomepage.VerizonHomepageLocators.*;

public class VerizonHomepage extends BaseAPI {

    VerizonHomepage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = WEB_ELEMENT_SHOP_BUTTON)
    public WebElement shopButton;

    @FindBy(xpath = WEB_ELEMENT_SMART_PHONES_BUTTON)
    public WebElement smartPhonesButton;

    @FindBy(xpath = WEB_ELEMENT_UNLIMITED_PLANS)
    public WebElement unlimitedPlans;

    @FindBy(xpath = WEB_ELEMENT_HOME_INTERNET)
    public WebElement homeInternet;

    @FindBy(xpath = WEB_ELEMENT_PHONE_DEALS)
    public WebElement phoneDeals;

    @FindBy(xpath = WEB_ELEMENT_GAMING )
    public WebElement gaming;


    @FindBy(xpath = WEB_ELEMENT_SEARCH_BUTTON)
    public WebElement searchButton;

    @FindBy(xpath = WEB_ELEMENT_SEARCH_BOX)
    public WebElement searchBox;

    public void checkSmartPhonePage() throws InterruptedException {
        WebElement menuHover = shopButton;
        Actions action = new Actions(driver);
        action.moveToElement(menuHover).perform();
        Thread.sleep(3000);
        smartPhonesButton.click();
        Thread.sleep(3000);
    }


    public void checkUnlimitedPlans() throws InterruptedException {
        WebElement menuHover = shopButton;
        Actions action = new Actions(driver);
        action.moveToElement(menuHover).perform();
        Thread.sleep(3000);
        unlimitedPlans.click();
        Thread.sleep(3000);
    }


    public void check5GInternet() throws InterruptedException {
        WebElement menuHover = shopButton;
        Actions action = new Actions(driver);
        action.moveToElement(menuHover).perform();
        Thread.sleep(3000);
        homeInternet.click();
        Thread.sleep(3000);
    }


    public void checkPhones() throws InterruptedException {
        WebElement menuHover = shopButton;
        Actions action = new Actions(driver);
        action.moveToElement(menuHover).perform();
        Thread.sleep(3000);
        phoneDeals.click();
        Thread.sleep(3000);
    }


    public void checkGaming() throws InterruptedException {
        WebElement menuHover = shopButton;
        Actions action = new Actions(driver);
        action.moveToElement(menuHover).perform();
        Thread.sleep(3000);
        gaming.click();
        Thread.sleep(3000);
    }



    public void searchBox() throws IOException {
        DataReader obj = new DataReader();
        String[][] searchValue = obj.fileReaderIntegerArrayXSSF("../Verizon/DataTest/VerizonData.xlsx", "VerizonData");
        searchButton.click();
        String[] s = searchValue[1];
    }

    public void searchBox2() throws IOException {
        DataReader obj = new DataReader();
        String[] searchValue = obj.fileReaderStringXSSF("../Verizon/DataTest/VerizonData.xlsx", "VerizonData");
        searchButton.click();
        String s = searchValue[2];
    }


    public void searchBox3() throws IOException {
        DataReader obj = new DataReader();
        String[][] searchValue = obj.fileReaderIntegerArrayXSSF("../Verizon/DataTest/VerizonData.xlsx","VerizonData");
        searchButton.click();
        String[] s = searchValue[3];
    }


    public void searchBox4() throws IOException {
        DataReader obj = new DataReader();
        String[][] searchValue = obj.fileReaderIntegerArrayXSSF("../Verizon/DataTest/VerizonData.xlsx","VerizonData");
        searchButton.click();
        String[] s = searchValue[4];
    }

    public void searchBox5() throws IOException {
        DataReader obj = new DataReader();
        String[][] searchValue = obj.fileReaderIntegerArrayXSSF("../Verizon/DataTest/VerizonData.xlsx","VerizonData");
        searchButton.click();
        String[] s = searchValue[5];
    }


    public void dbConnectSearchBox6() throws Exception {
        DataReader connection = new DataReader();
        List<String> data = Arrays.asList(connection.fileReaderStringXSSF("src/DataTest/VerizonData.xlsx", "VerizonTestData"));
        searchButton.click();
        data.get(0);

    }

    public void dbConnectSearchBox7() throws Exception {
        DataReader connection = new DataReader();
        List<String> data = Arrays.asList(connection.fileReaderStringXSSF("src/DataTest/VerizonData.xlsx", "VerizonTestData"));
        searchButton.click();
        data.get(1);

    }


    public void dbConnectSearchBox8() throws Exception {
        DataReader connection = new DataReader();
        List<String> data = Arrays.asList(connection.fileReaderStringXSSF("src/DataTest/VerizonData.xlsx", "VerizonTestData"));
        searchButton.click();
        data.get(2);

    }

    public void dbConnectSearchBox9() throws Exception {
        DataReader connection = new DataReader();
        List<String> data = Arrays.asList(connection.fileReaderStringXSSF("src/DataTest/VerizonData.xlsx", "VerizonTestData"));
        searchButton.click();
        data.get(3);

    }


    public void dbConnectSearchBox10() throws Exception {
        DataReader connection = new DataReader();
        List<String> data = Arrays.asList(connection.fileReaderStringXSSF("src/DataTest/VerizonData.xlsx", "VerizonTestData"));
        searchButton.click();
        data.get(4);

    }
}
