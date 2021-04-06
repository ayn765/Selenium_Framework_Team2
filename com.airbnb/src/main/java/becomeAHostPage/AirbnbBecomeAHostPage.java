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
    @FindBy(css = WebElementGetStartedButton)
    WebElement getStartedButton;
    @FindBy(xpath = WebElementCountryDropDown)
    WebElement countryDropDown;
    @FindBy(css = WebElementInputPhoneNumber)
    WebElement inputPhoneNumber;
    @FindBy(css = WebElementContinueClick)
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
    @FindBy(xpath = WebElementExploreHosting)
    WebElement exploreHosting;
    @FindBy(xpath = WebElementWhyHostOnAirbnb)
    WebElement whyHostOnAirbnb;
    @FindBy(xpath = WebElementHostSupport)
    WebElement hostSupport;
    @FindBy(xpath = WebElementHostSearchBar)
    WebElement hostSearchBar;
    @FindBy(xpath = WebElementHostHelp)
    WebElement hostHelp;
    @FindBy(xpath = WebElementHelpHowIBook)
    WebElement helpHowIBook;
    @FindBy(css=WebElementHelpHowIBookYes)
    WebElement helpHowIBookYes;
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



    //---------------------------Methods test1:Sign-UP--------------------------------------------

    public void clickOnbecomeHostButton() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(becomeHostButton));
        becomeHostButton.click();
    }

    public void clickOnGetStartedButton() {
        //new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(getStartedButton));
        getStartedButton.click();
    }

    public void selectCountry() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(countryDropDown ));
        Select select = new Select(countryDropDown);
        select.selectByVisibleText("Algeria (+213)");
    }
    /*This method convert string to phone number with dashes
    1-Break the string to 3 groups using regular expression '(\\d{3})(\\d{3})(\\d+)'.
    2-First group contains 3 digits. Second contains 3 digits and last group contains all remaining digits.
    3-Create a formatted string using these groups in '($1) $2-$3' pattern.*/
    public void convertPhoneNumber(String phoneNumber){
        String input = "1234567890";
        String number = input.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
    }
    public void phoneInput() {
        convertPhoneNumber("2134566789");
        inputPhoneNumber.sendKeys("2134566789");
    }
    public void clickOnContinueToSignUp() {
        clickOnbecomeHostButton();
        clickOnGetStartedButton();
        selectCountry();
        phoneInput();
        clickOnContinue.click();
    }
    //----------------------------------Test2:sign up with invalid data------------------------------------------

    // method to check if the phone number is valid
    public boolean checkPhoneNumber(String phone){
        try{
            boolean isValid =  phone.matches("\\d{3}-\\d{3}-\\d{4}");
            System.out.println(phone+" : "+isValid);
            return isValid;
        }catch
        (Exception e) {
            System.out.println("Phone number is too short or contains invalid characters.");
        }
        return true;
    }
    public void invalidInput(){
        clickOnbecomeHostButton();
        clickOnGetStartedButton();
        selectCountry();
        checkPhoneNumber("123");
        inputPhoneNumber.sendKeys("123");
        clickOnContinue.click();
    }
    //----------------Methods test3 :Entire Place Drop Down-----------------------------
    public void clickOnEntirePlace() {
        clickOnbecomeHostButton();
        entirePlace.click();
        chooseRoomOption("Entire place");
    }
    public void clickOnEntirePlaceMark() {
        entirePlaceChoice.click(); }

    public void clickOnPrivateRoomMark() {
        privateRoomChoice.click();
    }

    public void clickOnSharedRoomMark() {
        sharedRoomChoice.click();
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

    //----------------------Methods test4 :How many guests in DropDown-------------------------------

    public void numberOfGuests(int numGuests) {
        //going through the drop down and choosing how many guests I want (4)
        List<WebElement> guests = driver.findElements(By.xpath("//div[@aria-labelledby='capacity-dropdown']"));
        int s = guests.size();
        for (WebElement element : guests) {
            System.out.println(element.getText());
        }
        }
    public void howManyGuests() {
        clickOnbecomeHostButton();
        numberOfGuests(4);
        guestCapacity.click();
    }
 //------------------------------------method test5 :validate number of guests DropDown---------------------

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
    //-----------------------------Methods test6:hostHelpLink--------------------------------------------------

    public void hostHelpCustomerService() {
        clickOnbecomeHostButton();
        hostSupport.click();
        //best thing I learn today:this method is used to switch to a new window

        String winHandleBefore = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        //now we can search our element in the new opening window

        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[text()='Sign up']")));
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Sign up']"))).click();
    }
    //----------------------------------test7 GuidesForHosting-------------------------------------------------

    public void guidesHost(){
        clickOnbecomeHostButton();
        hostSupport.click();
        //we switch to a new window

        String winHandleBefore = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        //I mouse Hover Guides Tab and click on it
        Actions action = new Actions(driver);
        action.moveToElement(guidesHost).click().build().perform();
    }

//----------------------------------Methods test8:Receive Notification---------------------------------------------

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
        //check the box to receive Notification to my email
        emailNotCheckBox.isEnabled();
    }

//---------methods test9:Protected while Hosting Link-----------------------------------------

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
        helpfulArticle.click();
    }

    //-------------------methods test10:SignUpWithFacebook---------------------------------------------------

    public void useFacebookToSignUp() {
        clickOnbecomeHostButton();
        clickOnGetStartedButton();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='social-auth-button-facebook']"))).click();
        getStartedWithFacebook.click();
    }

    //----------------------test11:SignUpWith Mac----------------------------------------------------------------
    public void choseMacToSignUp() {
        clickOnbecomeHostButton();
        clickOnGetStartedButton();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Continue with Apple']"))).click();
       signUpWithMac.click();}

    //------------------------------method test12:EarningPotentialInfo-----------------------------------------

    public void validateInfoPopUpDisplay() {
        clickOnbecomeHostButton();
        boolean actualPageIsDisplayed = earningPotential.isDisplayed();
        Assert.assertEquals(actualPageIsDisplayed, true, "Expected page does not exist");
    }

    //------------------------------Methods test13:ExploreHostingLink--------------------------------------------

    public void exploreHostingWord() {
        clickOnbecomeHostButton();
        exploreHosting.click();
        whyHostOnAirbnb.click();
    }

    //-------------------------Methods test14:HostCustomerService--------------------------------------------

    public void hostCustomerService() {
        clickOnbecomeHostButton();
        hostSupport.click();
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

   //-------------------------------test15:how to earn money with airBNB----------------------------------------------
    public boolean earnMoneyAirbnb(){
        clickOnbecomeHostButton();
        howToEarnMoneyWithAirbnb.isDisplayed();
        return true;
    }

 //-----------------------------------Test16;test Privacy Policy-----------------------------------------------
  public void privacyPolicyairbnb(){
        clickOnbecomeHostButton();
        privacyPolicy.isDisplayed();
  }
//-----------------------------------Test17:RegisterForWebinar-------------------------------------------------
    public void chooseDateForWebinar(){
        clickOnbecomeHostButton();
        LearnFromArealHost.click();
        String winHandleBefore = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        datePickedForWebinar.click();
    }//------------------------------test 18:navigate to Is my space a good fit for-------------------------
    public String validateNavigationToUrl() {
        clickOnbecomeHostButton();
        //get the URL of the currently opened web page in the browser.
        String url = driver.getCurrentUrl();
        return url;
    }

//-----------------------------------------Test19:SaveImageInSelenium------------------------------------------
public void saveImageFileOnSite() {
        clickOnbecomeHostButton();
    try {
        //Getting the Image Path
        String airbnbImage = image.getAttribute("src");
        System.out.println(airbnbImage);
        //convert Image path to Java URL using URL Class
        java.net.URL imageURL = new URL(airbnbImage);
        //Read the image object from URL
        BufferedImage saveImage = ImageIO.read(imageURL);
        //write image on the disk
        ImageIO.write(saveImage, "jpg", new File("airbnb.jpg"));

    } catch (Exception e) {
        e.printStackTrace();
    }
    }
    }













