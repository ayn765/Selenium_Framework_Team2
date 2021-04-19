package homepage;

import common.BaseAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static homepage.ChaseHomepageLocators.*;

public class ChaseHomepage extends BaseAPI {
    public ChaseHomepage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = WebElementOpenAccount)
    WebElement openAccount;
    @FindBy(xpath = WebElementInputEmail)
    WebElement inputEmail;
    @FindBy(xpath = WebElementCoupon)
    WebElement coupon;
    @FindBy(xpath = WebElementMessage)
    WebElement message;
    @FindBy(xpath = WebElementClose)
    WebElement close;
    @FindBy(css = WebElementSlideButton)
    WebElement slideButton;
    @FindBy(xpath = WebElementSavingLink)
    WebElement savingLink;
    @FindBy(xpath = WebElementFirstRow)
    public WebElement firstRow;
    @FindBy(xpath =WebElementCustomerServiceDropDown)
    WebElement customerService;
    @FindBy(id = WebElementSideMenu)
    WebElement sideMenu;
    @FindBy(xpath=WebElementNewsStories)
    WebElement news;




    /**
     * Test case:1
     * click on Sign Up
     * send input to email
     * click on email coupon
     * get the text from the window
     * close the window
     * go back to the main page
     */

    public void openAccoutChase() {
        clickOnTheElement(openAccount);
        sendKeysToElement(inputEmail, "lamiads345@gmail.com");
        clickOnTheElement(coupon);
        String messageSignUp = message.getText();
        System.out.println(messageSignUp);
        clickOnTheElement(close);
        driver.navigate().back();
        driver.navigate().refresh();
    }

    /**
     * Test case:2
     * Click on slide button
     * After we see Saving we click on it
     * Get text from the first Row
     *Validate the text
     */
    public void checkFirstRow() {
        clickOnTheElement(slideButton);
        clickOnTheElement(savingLink);
    }

    /**
     * Test case:3
     * Click on CustomerService drop down
     * Validate the number of links
     */

    public int numLinksInCustomerServiceDrop(){
        clickOnTheElement(customerService);
        WebElement ul_element = driver.findElement(By.xpath("//*[@id=\"contact-2\"]/ul"));
        List<WebElement> li_All = ul_element.findElements(By.className("colored"));
        int AccountNUMlinks = li_All.size();
        for (int i = 0; i < li_All.size(); i++) {
            System.out.println(li_All.get(i).getText());
        }
        return AccountNUMlinks;
    }
    /**
     * Test case:4
     * Click on left side menu
     * click on News and Stories
     * get the number of images displayed in the page
     *Validate the number of Images
     */
    public int numOfImageInThePage(){
        int countImage=0;
        List<WebElement> listImages=driver.findElements(By.tagName("img"));
        for(WebElement image:listImages)
        {
            if(image.isDisplayed())
            {
                countImage++;
                System.out.println(image.getAttribute("alt"));
            }
        }
        System.out.println("Total Number of images in the page : "+countImage);
        return countImage;
    }
    public void sideMenu(){
        clickOnTheElement(sideMenu);
        clickOnTheElement(news);
    }
}