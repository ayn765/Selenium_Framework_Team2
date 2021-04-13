package sell;

import common.BaseAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static sell.SellPageLocators.*;


public class SellPage extends BaseAPI {

    public SellPage(){
        PageFactory.initElements(driver,this);
        waitForPageLoad(properties.getProperty("URL"));
    }
    @FindBy(xpath=WebElementListAnItem)
    WebElement listAnItem;
    @FindBy(xpath= WebElementSearchBar)
    WebElement searchBar;


    public void sellItem(){
 mouseHoverElement(listAnItem);
  sendKeysToElement(searchBar,"Samsung");
    }
}
