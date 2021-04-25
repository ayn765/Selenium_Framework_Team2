package homepage;

import common.BaseAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
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
    @FindBy(xpath = WebElementCustomerServiceDropDown)
    WebElement customerService;
    @FindBy(id = WebElementSideMenu)
    WebElement sideMenu;
    @FindBy(xpath = WebElementNewsStories)
    WebElement news;
    @FindBy(xpath = WebElementATM)
    public WebElement atmLink;
    @FindBy(xpath = WebElementFindAdvisor)
    public WebElement findAdvisor;
    @FindBy(xpath = WebElementSearchBox)
    public WebElement searchBox;
    @FindBy(xpath = WebElementSearch)
    public WebElement searchButton;
    @FindBy(xpath = WebElementAdvisor)
    public WebElement advisor;
    @FindBy(xpath = WebElementConnectWithAdvisor)
    public WebElement connectWithAdvisor;
    @FindBy(xpath = WebElementFirstNameInput)
    public WebElement firstName;
    @FindBy(xpath = WebElementLastNameInput)
    public WebElement lastName;
    @FindBy(xpath = WebElementEmail)
    public WebElement email;
    @FindBy(xpath = WebElementPhone)
    public WebElement phone;
    @FindBy(xpath = WebElementZipInput)
    public WebElement zipInput;
    @FindBy(xpath = WebElementAmountRangeDropDown)
    public WebElement rangeDropDown;
    @FindBy(xpath = WebElementRange)
    public WebElement range;
    @FindBy(xpath = WebElementNext)
    public WebElement nextButton;
    @FindBy(xpath = WebElementFinishedProcess)
    public WebElement finishedProcess;
    @FindBy(xpath = WebElementLinkedInIcon)
    public WebElement linkedInIcon;
    @FindBy(xpath = WebElementProceedButton)
    public WebElement proceedButton;
    @FindBy(xpath = WebElementEnglishTab)
    public WebElement englishTab;
    @FindBy(xpath = WebElementSpanishTab)
    public WebElement spanishTab;
    @FindBy(xpath = WebElementText)
    public WebElement text;


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
     * Validate the text
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

    public int numLinksInCustomerServiceDrop() {
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
     * Validate the number of Images
     */
    public int numOfImageInThePage() {
        int countImage = 0;
        List<WebElement> listImages = driver.findElements(By.tagName("img"));
        for (WebElement image : listImages) {
            if (image.isDisplayed()) {
                countImage++;
                System.out.println(image.getAttribute("alt"));
            }
        }
        System.out.println("Total Number of images in the page : " + countImage);
        return countImage;
    }

    public void sideMenu() {
        clickOnTheElement(sideMenu);
        clickOnTheElement(news);
    }

    /**
     * Test case:5
     * Click on ATM
     * click on find advisor
     * put advisor name in search box
     * Validate the name of advisor
     */

    public void findAdvisor() {
        clickOnTheElement(atmLink);
        clickOnTheElement(findAdvisor);
        sendKeysToElement(searchBox, "John P. Grosso");
        clickOnTheElement(searchButton);
    }

    /**
     * Test case:6
     * Click on ATM
     * click on find advisor
     * put advisor name in search box
     * Validate the name of advisor
     */

    public void inputFirstName(String fName) {
        sendKeysToElement(firstName, fName);
    }

    public void inputLastName(String lName) {
        sendKeysToElement(lastName, lName);
    }

    public void inputZip(int zip) {
        sendKeysToElement(zipInput, String.valueOf(zip));
    }

    public void inputEmail(String emailAddress) {
        sendKeysToElement(email, emailAddress);
    }

    public void inputPhoneNumber(int phNumber) {
        sendKeysToElement(phone, String.valueOf(phNumber));
    }

    public void connectWithAdvisor() {
        clickOnTheElement(atmLink);
        clickOnTheElement(connectWithAdvisor);
        inputFirstName("lamia");
        inputLastName("bedj");
        inputPhoneNumber(6145656);
        inputZip(1234);
        inputEmail("l@gmail.com");
        clickOnTheElement(rangeDropDown);
        clickOnTheElement(range);
        clickOnTheElement(nextButton);
    }

    /**
     * Test case:7
     * Click on Linkedin Icon
     * click on proceed Button
     * Validate the LinkedIn Url
     */

    public void navigateToLinkedIn() {
        clickOnTheElement(linkedInIcon);
        clickOnTheElement(proceedButton);
        windoHandle();
    }

    /**
     * Test case:8
     * Click on english tab on the top right of the page
     * click on espanol
     * Validate the language of the page
     */
    public void checkTheLanguage() {
        if (text.getText().contains("Choose what's right for you")) {
            System.out.println("The language is English");
        } else if (text.getText().contains("Elige lo que es correcto para ti")) {
            System.out.println("The Language is Spanish ");
        }
        clickOnTheElement(englishTab);
        clickOnTheElement(spanishTab);
    }

    /**
     * Test case:9
     * Navigate to chase home page
     * Get the number and all the names of links available on the page
     */
    public void nameAndNumberOfLinksInPage(){
        String url="";
        List<WebElement> allURLs = driver.findElements(By.tagName("a"));
        System.out.println("Total links on the Wb Page: " + allURLs.size());
        //We will iterate through the list and will check the elements in the list.
        Iterator<WebElement> iterator = allURLs.iterator();
        while (iterator.hasNext()) {
            url = iterator.next().getText();
            System.out.println(url);
        }
    }

}
