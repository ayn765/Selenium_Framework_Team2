package verizonDevices;

import common.BaseAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static verizonDevices.VerizonDevicesLocators.*;
public class VerizonDevicesPage extends BaseAPI {
    public VerizonDevicesPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = WebElementDevices)
    WebElement devices;
    @FindBy(css= WebElementFilterBy)
    WebElement filterBy;
    @FindBy(css =WebElementFilterByBrand)
    WebElement filterByBrand;
    @FindBy(xpath =WebElementFilterByBrandApple)
    WebElement apple;
    @FindBy(xpath =WebElementApplyFilter)
    WebElement applyFilter;
    @FindBy(xpath =WebElementResult)
    public WebElement result;
    @FindBy(css =WebElementPhone)
    WebElement phone;
    @FindBy(xpath=WebElementPhoneVideo)
    WebElement phoneVideo;
    @FindBy(xpath=WebElementCloseVideo)
    WebElement closeVideo;
    @FindBy(xpath=WebElementChat)
    WebElement chat;
    @FindBy(className=WebElementChatInput)
    WebElement chatInput;
    @FindBy(xpath=WebElementChatClose)
    WebElement chatClose;





    /**
     * Test case:1
     * Navigate to Devices Page
     * Validate that the page displays
     */
    public void navigateToDevices(){
        clickOnTheElement(devices);
    }
    public boolean isPageDisplayed() {
        navigateToDevices();
        devices.isDisplayed();
        return true;
    }
    /**
     * Test case:2
     * Navigate to Devices Page
     * click on add filters
     * click on filterByBrand
     * select Apple
     * validate the result
     */
    public void applyFilter(){
        navigateToDevices();
        clickOnTheElement(filterBy);
        clickOnTheElement(filterByBrand);
        clickOnTheElement(apple);
        clickOnTheElement(applyFilter);
    }
    /**
     * Test case:3
     * Navigate to Devices Page
     * click on a phone
     * click on watch video
     * switch to the video
     * close the video
     */
public void phoneVideo(){
    navigateToDevices();
    clickOnTheElement(phone);
    clickOnTheElement(phoneVideo);
    switchToNewTab(1);
    clickOnTheElement(closeVideo);
}
/**
 * Test case:4
 * Navigate to Devices Page
 * click on Chat Icon
 * put input in the chat input box
 * send chat
 * close chat
 */
public void verizonChat(){
    navigateToDevices();
    clickOnTheElement(chat);
    sendKeysToElement(chatInput,"I have a question about Trading my phone");
    clickOnTheElement(chatClose);
}
}