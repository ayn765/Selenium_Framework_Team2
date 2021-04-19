package homepage;
import common.BaseAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static homepage.RedfinHomepageLocators.*;
public class RedfinHomepage extends BaseAPI {
    public RedfinHomepage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath=WebElementSearchBar)
    WebElement searchBar;
    @FindBy(xpath=WebElementFilter)
    WebElement filter;
    @FindBy(xpath=WebElementFilterByHouse)
    WebElement houseFilter;
    @FindBy(xpath=WebElementApplyFilter)
    WebElement applyFilter;
    @FindBy(xpath=WebElementSearchResult)
    public WebElement searchResult;
    @FindBy(xpath=WebElementNoticeLink)
    WebElement noticeLink;
    @FindBy(xpath=WebElementVideo)
    WebElement video;
    @FindBy(xpath=WebElementVideoDuration)
    WebElement videoDuration;
    @FindBy(xpath=WebElementNewsLink)
    WebElement newsLink;


/**
 * Test case:1
 * Search location in Search bar
 * click add filter
 * click House filter
 * click on apply Filter
 * validate the result
 */
public void houseSearch(){
    sendKeysToElement(searchBar,"dublin ohio");
    clickOnTheElement(filter);
    clickOnTheElement(houseFilter);
    clickOnTheElement(applyFilter);
}
/**
 * Test case:2
 *click on Notice link
 * scroll till the bottom of the page
 * go back to the home page
 */
public void noticeLink(){
    clickOnTheElement(noticeLink);
    scrollTillBottomPageJScript();
    driver.navigate().back();
    driver.navigate().refresh();
}
/**
 * Test case:3
 *check if video is present on the page
 * get the duration of the video
 */

public boolean isVideoPresent(){
    video.isDisplayed();
    return true;
}
public void checkVideo(){
  String timeVideo=videoDuration.getText();
    System.out.println(timeVideo);
    isVideoPresent();
}
/**
 * Test case:4
 *click on the news button
 *get the Url of the new window
 * validate the url
 */
public void navigateToNews(){
    clickOnTheElement(newsLink);
}
}
