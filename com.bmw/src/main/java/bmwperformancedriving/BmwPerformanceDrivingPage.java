package bmwperformancedriving;

import common.BaseAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static bmwperformancedriving.BmwPerformanceDrivingLocators.*;
public class BmwPerformanceDrivingPage extends BaseAPI {
    public BmwPerformanceDrivingPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = WebElementPerformanceDrivingLink)
    WebElement performanceDrivingLink;
    @FindBy(css=WebElementPerformanceExperiencesTab)
    WebElement performanceExperiencesTab;
    @FindBy(xpath=WebElementBookExperiences)
    WebElement bookExperiences;
    @FindBy(xpath=WebElementSelectDate)
    WebElement selectDate;
    @FindBy(xpath=WebElementSelectDateTab)
    WebElement selectDateTab;
    @FindBy(xpath= WebElementFindEvent)
    WebElement findEvent;
    @FindBy(xpath= WebElementShareVideo)
    WebElement shareVideo;
    @FindBy(xpath=WebElementLearnMore)
    WebElement learnMore;
    @FindBy(xpath=WebElementMeetInstructor)
    WebElement meetInstructor;
    @FindBy(xpath=WebElementSelectInstructor)
    WebElement selectInstructor;



    /**
     * Test case:1
     * Navigate to Performance Driving
     * Validate the title that displays using Excel sheet
     */
public void navigateToPerformance(){
clickOnTheElement(performanceDrivingLink);
}
/**
 * Test case:2
 * Navigate to Performance Driving
 * click on experiences Tab
 * click on book
 * select a date in the calendar
 */
public void selectDateForDriving(){
    navigateToPerformance();
   scrollToElementJScript(performanceExperiencesTab);
   clickOnTheElement(performanceExperiencesTab);
   clickOnTheElement(bookExperiences);
   clickOnTheElement(selectDate);
   switchToNewTab(1);
   clickOnTheElement(selectDateTab);
}
/**
 * Test case:3
 * Navigate to Performance Driving
 * click on Find event
 * click on share video Icon
 */
public void shareVideo(){
    navigateToPerformance();
    scrollToElementJScript(findEvent);
    clickOnTheElement(findEvent);
    clickOnTheElement(shareVideo);
}
/**
 * Test case:4
 * Navigate to Performance Driving
 * click on LearnMore
 * click on MeetInstructor
 * select Instructor
 * get the info about the instructor
 */
public void selectInstructor(){
    navigateToPerformance();
    clickOnTheElement(learnMore);
    clickOnTheElement(meetInstructor);
    switchToNewTab(1);
    selectInstructor.getText();

}
}