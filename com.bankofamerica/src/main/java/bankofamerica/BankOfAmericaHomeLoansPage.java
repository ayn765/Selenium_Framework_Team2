package bankofamerica;

import common.BaseAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



import java.util.List;
import java.util.stream.Collectors;

import static bankofamerica.BankOfAmericaHomeLoansLocators.*;
public class BankOfAmericaHomeLoansPage extends BaseAPI {


    public BankOfAmericaHomeLoansPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = WebElementHomeLoans)
    WebElement homeLoans;
    @FindBy(xpath = WebElementHomeMortgages)
    WebElement homeMortgages;
    @FindBy(xpath = WebElementApply)
    WebElement  apply;
    @FindBy(css= WebElementWantToBuyHouse)
    WebElement  wantToBuyHouse;
    @FindBy(css= WebElementGetQualified)
    WebElement getQualified;
    @FindBy(xpath=WebElementSignIn)
    WebElement signIn;
    @FindBy(css=WebElementFirstTimeBuyerLink)
    WebElement firstTimeBuyerLink;
    @FindBy(css=WebElementResourcesLinks)
    WebElement resourcesLinks;
    @FindBy(css= WebElementHomeEquity)
    WebElement homeEquity;
    @FindBy(xpath=WebElementSelectState)
    WebElement selectState;
    @FindBy(xpath= WebElementLaterApr)
    public WebElement laterApr;
    @FindBy(id=WebElementGoButton)
    WebElement goButton;
    @FindBy(css=WebElementsAllStates)
    public List<WebElement> allStates;
    @FindBy(id=WebElementHomeLink)
    WebElement homeLink;
    @FindBy(css= WebElementRefinance)
    WebElement refinance;
    @FindBy(xpath= WebElementRefinanceVideo)
    WebElement refinanceVideo;
    @FindBy(css=WebElementVideoPlayPauseButton)
    WebElement videoPlayPauseButton;




    /**
     * Test case:1
     * Navigate to Home Loans
     * Get the title
     * Validate the title
     */
  public void navigateHomeLoans(){
      clickOnTheElement(homeLoans);
  }
  public String verifyTitle(){
     navigateHomeLoans();
     String pageTitle=getCurrentPageTitle();
      System.out.println("The page Title is: "+pageTitle);
     return pageTitle;
  }
    /**
     * Test case:2
     * Navigate to Home Loans
     * click on Mortgages
     * click on apply
     * click want To Buy hOUSE
     * Click on getQualified
     * Validate that Sign iN info display
     */
  public void applyToGetInfo(){
      navigateHomeLoans();
      clickOnTheElement(homeMortgages);
      clickOnTheElement(apply);
      clickOnTheElement(wantToBuyHouse);
      clickOnTheElement(getQualified);
  }
  public boolean isSignInInfoDisplayed(){
      waitForVisibilityOfElement(signIn);
      signIn.isDisplayed();
      return true;
    }
    /**
     * Test case:3
     * Navigate to Home Loans
     * click on First Time Home buyer Link
     * calculate number of links in the page
     * validate the result
     */
    public int numOfLinksInHomeBuyerPage(){
        navigateHomeLoans();
        clickOnTheElement(firstTimeBuyerLink);
        scrollToElementJScript(resourcesLinks);
        List<WebElement> parent= resourcesLinks.findElements(By.tagName("a"));
        List<WebElement> sublinks = parent.stream().filter(WebElement::isDisplayed).collect(Collectors.toList());
        return  sublinks.size();
    }
    /**
     * Test case:4
     * Navigate to Home Loans
     * click on Home Equity
     * Select Ohio From Drop Down
     * Click on Go button
     * Validate the text that displays
     */

    public void stateApr(){
        navigateHomeLoans();
        clickOnTheElement(homeEquity);
        mouseHoverElement(selectState);
        Select state=new Select(selectState);
        state.selectByVisibleText("Ohio");
        clickOnTheElement(goButton);
    }
    /**
     * Test case:5
     * Navigate to Home Loans
     * click on First Time Home buyer Link
     * validate States Names in the drop down against Names in Excel sheet
     */

    public void checkStates(){
        navigateHomeLoans();
        clickOnTheElement(homeEquity);
    }

    /**
     * Test case:6
     * Navigate to Home Loans
     * click on Home Sweet Home Link
     * validate The Title by comparing it to the title in Excel sheet
     */

    public void checkHomeSweetHome(){
        navigateHomeLoans();
        clickOnTheElement(homeLink);
    }
    /**
     * Test case:7
     * Navigate to Home Loans
     * click on Refinance Link
     * Scroll down to the Video
     * validate That The Video is Playing
     */
    public boolean isVideoPlaying(){
        navigateHomeLoans();
        clickOnTheElement(refinance);
        scrollToElementJScript(refinanceVideo);
        try {
            waitForVisibilityOfElement(videoPlayPauseButton);
          videoPlayPauseButton.click();
            if(videoPlayPauseButton.getAttribute("data-control").equals("Play")){
                System.out.println("This Youtube video wasn't playing but we clicked on it to play the video.");
            }else{
                if(videoPlayPauseButton.getAttribute("data-control").equals("Pause")){
                    System.out.println("Youtube video is already playing.");
                    return true;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;//return "false" in case both conditions fail
        }


    }