package financialServices;

import common.BaseAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static financialServices.FinancialLocators.*;
public class FinancialPage extends BaseAPI {
    public FinancialPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath=WebElementFinancial)
    WebElement financial;
    @FindBy(xpath=WebElementFinancialHeaderPic)
    WebElement pic;
    @FindBy(xpath=WebElementFindDealer)
    WebElement findDealer;
    @FindBy(xpath=WebElementInputZipCode)
    WebElement zipCode;
    @FindBy(xpath=WebElementSearch)
    WebElement search;
    @FindBy(xpath=WebElementAddressResult)
    public WebElement address;
    @FindBy(xpath=WebElementEstimatePayment)
    WebElement payment;
    @FindBy(xpath=WebElementSelectClass)
    WebElement classCar;
    @FindBy(xpath=WebElementSelectModel)
    WebElement model;
    @FindBy(xpath=WebElementSubmit)
    WebElement submit;
    @FindBy(xpath=WebElementCarPic)
    public WebElement carPic;
    @FindBy(xpath=WebElementOwnerLink)
    WebElement ownerLink;



    /**
     * Test case:1
     * Navigate to Financial Services
     * Validate that the picture displays
     */

    public void navigateToFinancial(){
        clickOnTheElement(financial);
    }
    public boolean isPicDisplays(){
        pic.isDisplayed();
        return true;
    }
    /**
     * Test case:2
     * Navigate to Financial Services
     * click on find Dealer
     * input zip code in search bar
     * click search
     * validate the result
     */
    public void searchDealer(){
        navigateToFinancial();
        clickOnTheElement(findDealer);
        sendKeysToElement(zipCode,"43220");
        clickOnTheElement(search);
    }
    /**
     * Test case:3
     * Navigate to Financial Services
     * click estimatePayment
     * select car class
     * select car model
     * click on search
     * validate the car picture displays
     */

    public void estimateCar(){
        navigateToFinancial();
        Select select=new Select(classCar);
        select.selectByVisibleText("CLS");
        Select select2=new Select(model);
        select2.deselectByVisibleText("A 220 Sedan");
        clickOnTheElement(submit);

    }
    /**
     * Test case:4
     * Navigate to Financial Services
     * click owner Link
     * Validate the Link
     */
    public void ownerPage(){
        navigateToFinancial();
        clickOnTheElement(ownerLink);
    }
}
