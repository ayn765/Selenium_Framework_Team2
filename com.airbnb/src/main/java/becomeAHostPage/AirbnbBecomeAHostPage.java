package becomeAHostPage;

import common.BaseAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.List;
import static becomeAHostPage.AirbnbBecomeAHostPageLocators.*;


public class AirbnbBecomeAHostPage extends BaseAPI {

    public AirbnbBecomeAHostPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = WebElementBecomeHost)
    WebElement becomeHostButton;
    @FindBy(xpath = WebElementGetStartedButton)
    WebElement getStartedButton;
    @FindBy(xpath = WebElementCountryDropDown)
    WebElement countryDropDown;
    @FindBy(css = WebElementInputPhoneNumber)
    WebElement inputPhoneNumber;
    @FindBy(xpath = WebElementContinueClick)
    WebElement clickOnContinue;
    @FindBy(xpath = WebElementEntirePlaceDropDown)
    WebElement entirePlace;
    @FindBy(xpath = WebElementEntirePlaceChoice)
    WebElement entirePlaceChoice;
    @FindBy(xpath = WebElementPrivateRoomChoice)
    WebElement privateRoomChoice;
    @FindBy(xpath = WebElementSharedRoomChoice)
    WebElement sharedRoomChoice;
    @FindBy(xpath = WebElementGuestCapacity)
    WebElement guestCapacity;
    @FindBy(css = WebElementEmail)
    WebElement emailAddress;
    @FindBy(css = WebElementPhoneNumber)
    WebElement phoneNumberForNotification;
    @FindBy(css = WebElementEmailNotCheckBox)
    WebElement emailNotCheckBox;
    @FindBy(xpath = WebElementProtectWhileHosting)
    WebElement protectHost;
    @FindBy(css = WebElementHelpfulThumb)
    WebElement helpfulArticle;
    @FindBy(xpath = WebElementGetStartedWithFacebook)
    WebElement getStartedWithFacebook;
    @FindBy(xpath=WebElementSignUpWithMac)
    WebElement signUpWithMac;
    @FindBy(xpath = WebElementEarningPotentialInfo)
    WebElement earningPotential;
    @FindBy(xpath =WebElementAgreeButton)
    WebElement agreeButton;
    @FindBy(xpath = WebElementExploreHosting)
    WebElement exploreHosting;
    @FindBy(xpath = WebElementWhyHostOnAirbnb)
    WebElement whyHostOnAirbnb;
    @FindBy(xpath = WebElementHostSupport)
    WebElement hostSupport;
    @FindBy(xpath = WebElementHostSearchBar)
    WebElement hostSearchBar;
    @FindBy(xpath =WebElementSuccessListing)
    WebElement successListing;
    @FindBy(xpath=WebElementHowToEarnMoneyWithAirbnb)
    WebElement howToEarnMoneyWithAirbnb;
    @FindBy(xpath = WebElementGuidesForHost)
    WebElement guidesHost;
    @FindBy(xpath=WebElementPrivacyPolicy)
    WebElement privacyPolicy;
    @FindBy(xpath=WebElementLearnFromArealHost)
     WebElement LearnFromArealHost;
    @FindBy(xpath=WebElementDatePickedForWebinar)
    WebElement datePickedForWebinar;
    @FindBy(css=WebElementImage)
    WebElement image;



    /**
     * Test case:1
     * Navigate to become a host button
     * click on get started button
     * move to the tab and select the country code
     * enter phone number
     * click on SignUp Button to sign UP
     */

    public void clickOnbecomeHostButton() {
      clickOnTheElement(becomeHostButton);
    }

    public void clickOnGetStartedButton() {
      clickOnTheElement(getStartedButton);
    }

    public void selectCountry() {
       waitForVisibilityOfElement(countryDropDown);
        Select select = new Select(countryDropDown);
        select.selectByVisibleText("Algeria (+213)");
    }
    /*This method convert string to phone number with dashes
    1-Break the string to 3 groups using regular expression '(\\d{3})(\\d{3})(\\d+)'.
    2-First group contains 3 digits. Second contains 3 digits and last group contains all remaining digits.
    3-Create a formatted string using these groups in '($1) $2-$3' pattern.*/
    public void convertPhoneNumber(String phoneNumber){
        String input = "1234567890";
        String number= input.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
    }

    public void phoneInput() {
        convertPhoneNumber("45667899");
        inputPhoneNumber.sendKeys("45667899");
    }
    public void clickOnContinueToSignUp() {
        clickOnbecomeHostButton();
        clickOnGetStartedButton();
        selectCountry();
        phoneInput();
       clickOnTheElement(clickOnContinue);
    }
    /**
     * Test case:2
     * Navigate to become a host button
     * click on get started button
     * move to the tab and select the country
     * enter Invalid phone number
     */

    // method to check if the phone number is valid
    public boolean checkPhoneNumber(String phone){

            boolean valid =  phone.matches("\\d{3}-\\d{3}-\\d{4}");
            System.out.println(phone+" : "+valid);
            return true;
    }

    public void invalidInput(){
        clickOnbecomeHostButton();
        clickOnGetStartedButton();
        selectCountry();
        checkPhoneNumber("123");
        sendKeysToElement(inputPhoneNumber,"123");
        clickOnTheElement(clickOnContinue);
    }
    /**
     * Test case:3
     * Navigate to become a host button
     * click on Entire Place Drop Down
     * Select Entire place from DropDown
     */
    public void clickOnEntirePlace() {
        clickOnbecomeHostButton();
        clickOnTheElement(entirePlace);
        chooseRoomOption("Entire place");
    }
    public void clickOnEntirePlaceMark() {
        clickOnTheElement(entirePlaceChoice); }

    public void clickOnPrivateRoomMark() {
      clickOnTheElement(privateRoomChoice);
    }

    public void clickOnSharedRoomMark() {
      clickOnTheElement(sharedRoomChoice);
    }
    //I created a switch case to go through the Entire Place Drop Down
    public void chooseRoomOption(String option) {
        switch (option) {
            case "Entire place":
                clickOnEntirePlaceMark();
                break;
            case "Private Room":
                clickOnPrivateRoomMark();
                break;
            case "Shared Room":
                clickOnSharedRoomMark();
                break;
        }
    }


    /**
     * Test case:4
     * Navigate to become a host button
     * select Num Of guests DropDown
     */
    public void numberOfGuests(int numGuests) {
        List<WebElement> guests = driver.findElements(By.xpath("//div[@aria-labelledby='capacity-dropdown']"));
        int s = guests.size();
        for (WebElement element : guests) {
            System.out.println(element.getText());
        }
        }
    public void howManyGuests() {
        clickOnbecomeHostButton();
        numberOfGuests(4);
       clickOnTheElement(guestCapacity);
    }

    /**
     * Test case:5
     * Navigate to become a host button
     * select Num Of guests DropDown
     * validate number of guests
     */
    public int numberOfGuestsInTheDropDown() {
     clickOnbecomeHostButton();
     //created a List to go through the drop down
     List<WebElement> guests = driver.findElements(By.xpath("//div[@aria-labelledby='capacity-dropdown']"));
     int s = guests.size();
     for (WebElement element : guests) {
         System.out.println(element.getText());
     }
     //Declaring how many values(guests) is there in the number of hosts guests
     int numOfGuests=16;
     return numOfGuests;
 }
    /**
     * Test case:6
     * Navigate to become a host button
     * click on the link "How we support host"
     *Move to the new opening window
     * click on SignUp
     */
    public void hostHelpCustomerService() {
        clickOnbecomeHostButton();
        clickOnTheElement(hostSupport);
        //best thing I learn today:this method is used to switch to a new window

        String winHandleBefore = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        //now we can search our element in the new opening window

        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[text()='Sign up']")));
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Sign up']"))).click();
    }
    /**
     * Test case:7
     * Navigate to become a host button
     * click on the link "How we support host"
     *Move to the new opening window
     * click on guides tab
     *mouseHover Success Listening
     */
    public void guidesHost(){
        clickOnbecomeHostButton();
        clickOnTheElement(hostSupport);
        //we switch to a new window

        String winHandleBefore = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        clickOnTheElement(guidesHost);
        //I mouse Hover Guides Tab and click on it
        Actions action = new Actions(driver);
        action.moveToElement(successListing).click().build().perform();
    }

    /**
     * Test case:8
     * Navigate to become a host button
     * input email address
     * input phone number
     * check the box to receive Notification
     */
    public void inputEmail() {
        emailAddress.sendKeys("lamiabedjou@gmail.com");
    }
    public void phoneNumberTosend() {
        phoneNumberForNotification.sendKeys("614-558-5827");
    }
    public void checkTheBoxForNotification() {
        clickOnbecomeHostButton();
        inputEmail();
        phoneNumberTosend();
        emailNotCheckBox.isEnabled();
    }

    /**
     * Test case:9
     * Navigate to become a host button
     * click on Discovering the world of hosting
     * Switch to a new window
     * scroll down the page and Click on ThumbUp
     */

    public void clickOnProtectedHostLink() {
        protectHost.click();
    }
    public void protectedHostGiveThumbUp() {
        clickOnbecomeHostButton();
        clickOnProtectedHostLink();
        //switch to a new window
        String winHandleBefore = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        // give Thumb Up :helpful Article
        clickOnTheElement(helpfulArticle);
    }

    /**
     * Test case:10
     * Navigate to become a host button
     * click on get Started
     * click on SignUp with Facebook
     * switch to a new window
     * click on agree and continue
     */
    public void useFacebookToSignUp() {
        clickOnbecomeHostButton();
        clickOnGetStartedButton();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='social-auth-button-facebook']"))).click();
        getStartedWithFacebook.click();
        switchToNewTab(1);
        clickOnTheElement(agreeButton);

    }

    /**
     * Test case:11
     * Navigate to become a host button
     * click on get Started
     * click on SignUp with Mac
     */
    public void choseMacToSignUp() {
        clickOnbecomeHostButton();
        clickOnGetStartedButton();
        clickOnTheElement(signUpWithMac);}
    /**
     * Test case:12
     * Navigate to become a host button
     * click on earning potential
     * validate the page displays
     */

     public void validateInfoPopUpDisplay() {
        clickOnbecomeHostButton();
        boolean actualPageIsDisplayed = earningPotential.isDisplayed();
        Assert.assertEquals(actualPageIsDisplayed, true, "Expected page does not exist");
    }

    /**
     * Test case:13
     * Navigate to become a host button
     * click on explore hosting link
     *click on why hosting on airbnb video
     * validate that the video is there
     */

    public void exploreHostingWord() {
        clickOnbecomeHostButton();
        clickOnTheElement(exploreHosting);
        clickOnTheElement(whyHostOnAirbnb);
    }

    /**
     * Test case:14
     * Navigate to become a host button
     * click on explore hosting Support link
     * Switch to a new window
     * put input in the search bar
     */

    public void hostCustomerService() {
        clickOnbecomeHostButton();
       clickOnTheElement(hostSupport);
        //switch to the new window after clicking on Host Support Link

        String winHandleBefore = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        //Give some time for selenium to Find and click on element
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='_9jnsit']")));
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='_9jnsit']"))).click();
        //mouse hover Search Bar
        Actions action = new Actions(driver);
        action.moveToElement(hostSearchBar);
        //write what you want to search
        hostSearchBar.sendKeys("how to earn money with airbnb");

    }

    /**
     * Test case:15
     * Navigate to become a host button
     * click on How to earn money with airbnb
     * validate the page displays
     */

    public boolean earnMoneyAirbnb(){
        clickOnbecomeHostButton();
        howToEarnMoneyWithAirbnb.isDisplayed();
        return true;
    }
    /**
     * Test case:16
     * Navigate to become a host button
     * click on Privacy policy
     * validate the text
     */
  public void privacyPolicyairbnb(){
        clickOnbecomeHostButton();
      System.out.println(privacyPolicy.getText());
  }
    /**
     * Test case:17
     * Navigate to become a host button
     * click on Learn from a real host lik
     * move to a new opening window
     * select a date for webinar and click on register
     */
    public void chooseDateForWebinar(){
        clickOnbecomeHostButton();
        LearnFromArealHost.click();
        String winHandleBefore = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        datePickedForWebinar.click();
    }
    /**
     * Test case:18
     * Navigate to become a host button
     * get the URL
     * Validate The URL
     */
    public String validateNavigationToUrl() {
        clickOnbecomeHostButton();
        //get the URL of the currently opened web page in the browser.
        String url = driver.getCurrentUrl();
        return url;
    }
    /**
     * Test case:19
     * Navigate to become a host button
     * Select Image to Download
     * Download Image to destination
     */

public void downloadPicture() {
        clickOnbecomeHostButton();
    try {
        String airbnbImage = image.getAttribute("src"); //Getting the Image Path
        java.net.URL imageURL = new URL(airbnbImage);//convert Image path to Java URL using URL Class
        BufferedImage saveImage = ImageIO.read(imageURL); //Read the image object from URL
        String path=System.getProperty("user.dir")+"/C/Users/Lamia/IdeaProjects";
        ImageIO.write(saveImage, "jpg", new File(path));   //Download image to the path
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
    }













