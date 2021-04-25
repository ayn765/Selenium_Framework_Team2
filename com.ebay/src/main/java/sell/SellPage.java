package sell;

import common.BaseAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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
    @FindBy(xpath=WebElementSellCategories)
    WebElement sellCategories;
    @FindBy(xpath=WebElementLearnMoreSell)
    WebElement learnMore;
    @FindBy(xpath=WebElementLearnMoreSellPicture)
    WebElement picture;
    @FindBy(xpath=WebElementSeller)
    WebElement seller;
    @FindBy(xpath=WebElementSellStories)
    WebElement sellStories;
    @FindBy(xpath=WebElementSellerStoryText)
    WebElement sellerStoryText;


    public void sellItem(){
 mouseHoverElement(listAnItem);
  sendKeysToElement(searchBar,"Samsung");
    }

    public int numOfCategories(){
        scrollToElementJScript(sellCategories);
        clickOnTheElement(sellCategories);
        WebElement ul_element = driver.findElement(By.xpath("//*[@id=\"profile-unauth\"]/div[2]/ul"));
        List<WebElement> li_All = ul_element.findElements(By.className("cta wcgn-account-dropdown"));
        int accountCategories = li_All.size();
        for (int i = 0; i < li_All.size(); i++) {
            System.out.println(li_All.get(i).getText());
        }
        return accountCategories;
    }

    public void clickLearnMore(){
        learnMore.click();
    }

    public boolean isPicDisplayed(){
       picture.isDisplayed();
       return true;
    }

    public void sellerStory(){
        clickOnTheElement(learnMore);
        clickOnTheElement(sellStories);
        clickOnTheElement(seller);
        String theSellerStory= sellerStoryText.getText();
        System.out.println(theSellerStory);
    }
}

