package fantasyPage.fantasyHockey;

import common.BaseAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;

import java.io.IOException;
import java.util.List;

import static fantasyPage.fantasyHockey.CBSSportsFantasyHockeyPageLocators.*;

public class CBSSportsFantasyHockeyPage extends BaseAPI {

    public CBSSportsFantasyHockeyPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = WEBELEMENT_SLIDER_BAR)
    public WebElement sliderBar;

    @FindBy(css = WEBELEMENT_BUTTON_BET_NOW)
    public WebElement buttonBetNow;

    @FindBy(xpath = WEBELEMENT_IFRAME)
    public WebElement iframe;

    @FindBy(css = WEBELEMENT_PAYOUT_VALUE)
    public WebElement payoutValue;

    @FindBy(css = WEBELEMENTS_TABS_PLAYER_NEWS)
    public List<WebElement> tabsPlayerNews;

    public boolean verifySliderBar() throws InterruptedException {
        boolean flag;
        waitUntilWebElementVisible(iframe);
        driver.switchTo().frame(iframe);
        String payoutValueBefore = payoutValue.getText();
        System.out.println("Payout value before: " + payoutValueBefore);
        sliderBarAction(sliderBar);
        String payoutValueAfter = payoutValue.getText();
        System.out.println("Payout value after: " + payoutValueAfter);
        flag = !payoutValueAfter.equals(payoutValueBefore);
        return flag;
    }

    public boolean verifyTabsPlayerNewsExpanded() {

        boolean flag = false;
        int falseCount = 0;
        for (WebElement x : tabsPlayerNews) {
            clickElement(x);
            if (x.getAttribute("aria-expanded").equals("true")) {
                flag = true;
            } else {
                flag = false;
                falseCount++;
            }
        }
        if (falseCount > 0) {
            flag = false;

        }
        return flag;
    }


    public boolean verifyTabsPlayerNews() throws IOException {
        return compareListWebElementsToExcelDoc(tabsPlayerNews, System.getProperty("user.dir") + "/src/test/resources/CBSSportsTestData.xlsx", "TabsPlayerNews");
    }
}