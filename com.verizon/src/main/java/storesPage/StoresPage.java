package storesPage;

import common.BaseAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.util.List;

import static storesPage.StoresPageLocators.*;
import static common.BaseAPI.driver;

public class StoresPage extends BaseAPI {

    @FindBy(css=WEB_ELEMENT_BUTTON_STORES)
    public WebElement buttonStores;
    @FindBy(xpath=WEB_ELEMENT_BUTTON_SING_IN)
    public WebElement buttonSingIn;

    @FindBy(xpath=WEB_ELEMENT_BUTTON_SING_IN_LIST)
    public WebElement buttonSingInList;



    public StoresPage(){
        PageFactory.initElements(driver, this);
    }
    /**
     * Test case 1 - navigate to page Stores
     * 1. Navigate to www.verzion.com.
     * 2. click on Stores button.

     */
public void navigateToStorePage(){
    clickElement(buttonStores);
}
/**
 * Test case 2 -hover over Sing In button
 * 1. Navigate to www.verizon.com.
 * 2. click on Stores button.
 * 3.put the mouse on the the sing in button.
 * 4.get the list of the drop down Sing In button.
 * 5.compare the list against Excel sheet.

 */
public void hoverOverSingInButton(){
    navigateToStorePage();
    waitForVisibilityOfElement(buttonSingIn);
 hoverOverElement(buttonSingIn);
    List<WebElement> links= (List<WebElement>) buttonSingInList;
   int total_links=links.size();
    for(int i=0;i<total_links;i++){
       WebElement element= links.get(i);
        String text=element.getText();
      System.out.println("links name is: ");}}}





