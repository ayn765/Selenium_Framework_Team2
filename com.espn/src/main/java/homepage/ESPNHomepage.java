package homepage;

import common.BaseAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static homepage.ESPNHomepageLocators.*;
public class ESPNHomepage extends BaseAPI {
    public ESPNHomepage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = WebElementSubscribe)
    WebElement subscribe;
    @FindBy(xpath =WebElementInputEmail)
    WebElement email;
    @FindBy(xpath=WebElementInputPassword)
    WebElement password;
    @FindBy(xpath =WebElementInputSubmit)
    WebElement submit;
    @FindBy(xpath =WebElementHomeImage)
    WebElement homePageImage;
    @FindBy(xpath =WebElementScoreBoard)
    WebElement scoreBoard;
    @FindBy(xpath =WebElementScoreBox)
    WebElement scoreBox;
    @FindBy(css=WebElementFavoriteDropdown)
    WebElement favoriteDropDown;
    @FindBy(xpath= WebElementFavoriteButton)
    WebElement favoriteButton;
    @FindBy(xpath=WebElementFollowSoccer)
    WebElement followSoccer;



    /**
     * Test case:1
     * Navigate to Espn Home Page
     * click on subscribe
     * enter email
     * enter password
     * login
     */
    public void subscribeEspn() {
      clickOnTheElement(subscribe);
      switchToNewTab(1);
      sendKeysToElement(email,"lamia@gmail.com");
      sendKeysToElement(password,"ajsska");
      clickOnTheElement(submit);
    }
    /**
     * Test case:2
     * Navigate to Espn Home Page
     * click on image Link
     * validate the new window Title
     */
  public void checkTitle(){
        clickOnTheElement(homePageImage);
  }
    /**
     * Test case:3
     * Navigate to Espn Home Page
     * click on MLB score Board Link
     * click on Score Box
     * Get the values of The table
     */
    public void printScoreTable(){
        scrollToElementJScript(scoreBoard);
        clickOnTheElement(scoreBoard);
        clickOnTheElement(scoreBox);
        // Get all the rows in the table
        List<WebElement> allRows = driver.findElements(By.xpath("//*[@id=\"gamepackage-linescore\"]/article/div/div/div[1]/table"));
        for (WebElement row : allRows) {
            List<WebElement> cells = row.findElements(By.className("linescore__item test "));
            for (WebElement cell : cells) {
                System.out.println(cell.getText());
    }

}}
    /**
     * Test case:4
     * Navigate to Espn Home Page
     * click on Favorite Drop Down
     * click on add Favorite
     * click on follow soccer
     */
    public void favorite() {
        clickOnTheElement(favoriteDropDown);
        clickOnTheElement(favoriteButton);
        switchToNewTab(1);
        scrollToElementJScript(followSoccer);
        clickOnTheElement(followSoccer);
    }
}