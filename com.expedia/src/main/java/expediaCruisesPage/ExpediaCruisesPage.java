package expediaCruisesPage;

import common.BaseAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static expediaCruisesPage.ExpediaCruisesLocators.*;

public class ExpediaCruisesPage extends BaseAPI {


    @FindBy(css = WEB_ELEMENT_CRUISES_PAGE)
    WebElement navigateToCruisesPage;

    @FindBy(xpath = WEB_ELEMENT_TRAVELERS_TAB)
    public WebElement travelersTab;

    @FindBy(xpath = WEB_ELEMENT_PLUS_CHILDREN_SIGN_BUTTON)
    WebElement childrenPlusSignButtton;

    @FindBy(xpath = WEB_ELEMENT_SELECT_CHILD_AGE_DROPDOWN)
    WebElement selectChildByAgeDropDown;

    @FindBy(xpath = WEB_ELEMENT_TRAVELERS_DONE_BUTTON)
    WebElement travelersDoneButton;

    @FindBy(xpath=WEB_ELEMENT_DESTINATION_SEARCH_BAR)
    public WebElement destinationSearchBar;

    public ExpediaCruisesPage() {
        PageFactory.initElements(driver, this);
    }

    public void checkCruisesPage() {
        driverWait = new WebDriverWait(driver, 10);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", "disable-popup-blocking");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(capabilities);
        driverWait.until(ExpectedConditions.elementToBeClickable(navigateToCruisesPage));
        //navigateToCruisesPage.click();

    }

    public void verifyTwoTravelersTab() {
        clickElement(navigateToCruisesPage);
        clickElement(travelersTab);
        clickElement(travelersDoneButton);
    }


    public void verifyAddingChildrenButton() {

        clickElement(navigateToCruisesPage);
        clickElement(travelersTab);
        childrenPlusSignButtton.click();
        clickElement(travelersDoneButton);
    }

    public void verifySelectingChildAgeByIndex(int index) {
        clickElement(navigateToCruisesPage);
        clickElement(travelersTab);
        childrenPlusSignButtton.click();
        selectOptionByIndex(selectChildByAgeDropDown, index);
        clickElement(travelersDoneButton);
    }

    public void verifySelectingChildAgeByValue(String value) {
        clickElement(navigateToCruisesPage);
        clickElement(travelersTab);
        childrenPlusSignButtton.click();
        selectOptionByValue(selectChildByAgeDropDown, value);
        clickElement(travelersDoneButton);
    }

    public void verifySelectingChildAgeByVisibleText(String visibleText) {
        clickElement(navigateToCruisesPage);
        clickElement(travelersTab);
        childrenPlusSignButtton.click();
        selectOptionByVisibleText(selectChildByAgeDropDown, visibleText);
        clickElement(travelersDoneButton);
    }

    public void verifySelectingDestinationByIndex(int index) {
        selectOptionByIndex(destinationSearchBar,index);


    }
    public void verifySelectingDestinationByValue(String value){
        selectOptionByValue(destinationSearchBar, value);

    }

    public void verifySelectingDestinationByVisibleText(String visibleText){

       selectOptionByVisibleText(destinationSearchBar, visibleText);

    }





}

//    public boolean killPopup() {
//        boolean flag = false;
//
//        try {
//            wait.until(ExpectedConditions.visibilityOf(popup));
//            if (popup.isDisplayed()) {
//                System.out.println("POP-UP DISPLAYED\n");
//                buttonPopupClose.click();
//                System.out.println("POP-UP CLOSED\n");
//                driver.switchTo().defaultContent();
//                flag = true;
//            } else {
//                System.out.println("Pop-up was not displayed\n");
//            }
//        } catch (Exception e) {
//            e.getMessage();
//        }
//        return flag;
//    }
//}