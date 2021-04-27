package homeLoansPage;

import common.BaseAPI;
import static homeLoansPage.HomeLoansPageLocators.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;


public class HomeLoansPage extends BaseAPI {
    @FindBy(xpath = WEB_ELEMENT_BUTTON_HOME_LOANS_PAGE)
    public WebElement buttonHomeLoansPage;

    @FindBy(xpath = WEB_ELEMENT_BUTTON_ATM_BRANCH)
    public WebElement buttonAtm_branch;

    @FindBy(xpath = WEB_ELEMENT_INPUT_SEARCH_BAR_ZIP_CODE)
    public WebElement InputSearchBar;

    @FindBy(xpath = WEB_ELEMENT_BUTTON_SEARCH)
    public WebElement buttonSearch;
    @FindBy(xpath = WEB_ELEMENT_EXPECTED_TEXT_ZIP_CODE)
    public WebElement expectedTextZipCode;

    @FindBy(xpath = WEB_ELEMENT_BUTTON_ESPANOL)
    public WebElement espanolButton;

    @FindBy(xpath = WEB_ELEMENT_GET_TEXT_ESP)
    public WebElement expectedTextEsp;

    public HomeLoansPage() {

        PageFactory.initElements(driver, this);
    }

    /**
     * Test case:1
     * go to Home page Chase.com
     * navigate to the Home Loans page.
     * get the url.
     */
    public String navigateToHomeLoansPage() {
        clickElement(buttonHomeLoansPage);
        String URL = driver.getCurrentUrl();

        // currentPage.getCurrntUrl();
        System.out.println("the url iss: " + URL);

        return URL;


    }

    /**
     * Test case:2
     * go to Home page Chase.com
     * navigate to the Home Loans page.
     * CLICK ON THE aATM&BRANCH BUTTON.
     * create a list of zip code itrate through the list
     * send each element to the SearchBar
     * if the click on the search button
     * return boolean.
     */
    public boolean ValidateZipCode() {
        boolean flag = false;
        clickElement(buttonAtm_branch);

        List<String> messages = Arrays.asList("18074", "18056", "18075", "19034", "19088");


        for (String mes : messages) {
            javaScriptExecutorClickOnElement(InputSearchBar.findElement(By.xpath("//*[@id='q']")));
            sendKeysToElement(InputSearchBar.findElement(By.xpath("//*[@id='q']")), mes);
            clickElement(buttonSearch);

            if (expectedTextZipCode.isDisplayed()) {
                return flag = true;
            } else {
                return flag = false;
            }
        }
        return flag;
    }

    /**
     * Test case:3
     * go to Home page Chase.com
     * navigate to the Home Loans page.
     * CLICK ON THE Espanol button.
     * <p>
     * the page change the language
     * return boolean.
     */
    public boolean validateLanguage() {
        boolean flag = false;
        navigateToHomeLoansPage();
        clickElement(espanolButton);
        if (expectedTextEsp.getText().equals("Get prequalified—Start online")) {
            flag = false;

        } else {
            flag = true;


        }
        return flag;
    }
}
