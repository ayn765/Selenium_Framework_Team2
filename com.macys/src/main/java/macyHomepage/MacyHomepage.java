package macyHomepage;

import common.BaseAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static macyHomepage.MacHomeLocators.*;

public class MacyHomepage extends BaseAPI {


    @FindBy (xpath = WEB_ELEMENT_INPUT_SEARCH_BAR)
    WebElement inputSearchBar;

    @FindBy(xpath = WEB_ELEMENT_BUTTON_SEARCH_SEARCH_BAR)
    WebElement buttonSearchBar;
    @FindBy (xpath = WEB_ELEMENT_SHOE_TYPE_BUTTON)
    WebElement shoeType;
    @FindBy(xpath= WEB_ELEMENT_BOOTIE_CHECK_BOX )
    WebElement bootieCheckBox;
    @FindBy( css = WEB_ELEMENT_EXPECTED_SEARCH_RESULT )
    public WebElement expectedSearchResult;
    @FindBy(css = WEB_ELEMENT_EXPECTED_BOOTIE_SEARCH_RESULT)
    public WebElement expectedBootieSearchResult;

    public MacyHomepage(){
        PageFactory.initElements(driver, this);
    }

    public void doSearch(){
        inputSearchBar.sendKeys("Women Shoes");
        buttonSearchBar.click();
        expectedSearchResult.isDisplayed();


    }
    public void verifyBootieSearchBox(){
        inputSearchBar.sendKeys("Women shoes");
        buttonSearchBar.click();
        shoeType.click();
        bootieCheckBox.click();

    }




}
