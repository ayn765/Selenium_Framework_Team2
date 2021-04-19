package truliaBuy;

import common.BaseAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static truliaBuy.TruliaBuyLocators.*;
public class TruliaBuyPage extends BaseAPI {
    public TruliaBuyPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = WebElementBuy)
    WebElement buy;
    @FindBy(xpath =WebElementRecentlySold)
    WebElement recentlySold;
    @FindBy(xpath =WebElementResultSold)
    public WebElement resultSold;
    @FindBy(xpath =WebElementOpenHouse)
    WebElement openHouse;
    @FindBy(xpath =WebElementHouse)
    WebElement house;
    @FindBy(xpath =WebElementHouseSaveHouse)
    WebElement saveHouse;
    @FindBy(xpath =WebElementTruliaIcon)
    WebElement truliaIcon;
    @FindBy(xpath =WebElementHelpCenter)
    WebElement helpCenter;
    @FindBy(xpath =WebElementPhoneApps)
    WebElement phoneApp;



    /**
     * Test case:1
     * Mouse Hover Buy
     * Validate number of links in the Buy Drop Down
     */

    public void navigateToBuy() {
        Actions action = new Actions(driver);
        action.moveToElement(buy).build().perform();
    }

    public int numLinksInBuy(){
        navigateToBuy();
        WebElement ul_element = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/header/nav/ul"));
        List<WebElement> li_All = ul_element.findElements(By.className("cta wcgn-account-dropdown"));
        int AccountNUMlinks = li_All.size();
        for (int i = 0; i < li_All.size(); i++) {
            System.out.println(li_All.get(i).getText());
        }
        return AccountNUMlinks;

    }

    /**
     * Test case:2
     * Mouse Hover Buy
     * click on recently sold link
     * Validate the result
     */

    public void numOfHouseSold(){
        navigateToBuy();
        clickOnTheElement(recentlySold);
    }
    /**
     * Test case:3
     * Mouse Hover Buy
     * click on open House
     * select house
     * save the house
     * click on trulia icon to go back to the main page
     */
 public void openHouse(){
     navigateToBuy();
     clickOnTheElement(openHouse);
     clickOnTheElement(house);
     windoHandle();
     clickOnTheElement(saveHouse);
     clickOnTheElement(truliaIcon);
 }
 public void helpCenter(){
clickOnTheElement(buy);
scrollTillBottomPageJScript();
clickOnTheElement(helpCenter);
clickOnTheElement(phoneApp);
 }
}