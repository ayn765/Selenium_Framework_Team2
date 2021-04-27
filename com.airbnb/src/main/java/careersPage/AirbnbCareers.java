package careersPage;

import common.BaseAPI;
import org.apache.commons.math3.analysis.function.Exp;
import org.apache.poi.ss.usermodel.IgnoredErrorType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

import static careersPage.AirbnbCareersLocators.*;


public class AirbnbCareers extends BaseAPI {


    @FindBy(css = webElementUniversityTab)
    WebElement UniversityTab;

    @FindBy(css = webElementContract_FreelanceWorkTab)
    WebElement Contract_FreelanceWork;

    @FindBy(css = webELementSearchOpportunities)
    public WebElement SearchOpportunities;

    @FindBy(css = webElementAll_JobsTab)
    WebElement All_Jobs;

    @FindBy(css = webElementAllJobsTitle)
    public WebElement AllJobsTitle;

    @FindBy(xpath = webElementExploreRolesTab)
    WebElement ExploreRoles;

    @FindBy(xpath = webElementSelectLocation)
    WebElement SelectLocation;

    @FindBy(css = webElementLocationsDropDownList)
    public WebElement LocationsDropDownList;

    public AirbnbCareers() {
        PageFactory.initElements(driver, this);
    }

    WebDriverWait wait;


    public void verifyTabsOpen() {
        UniversityTab.click();
        String actualUniversityURL = "https://careers.airbnb.com/university/";
        String expectedUniversityURL = driver.getCurrentUrl();
        Assert.assertEquals(actualUniversityURL, expectedUniversityURL, "URL DOES NOT MATCH");

        Contract_FreelanceWork.click();
        String actualContract_FreelanceWork = "https://careers.airbnb.com/contractors/";
        String expectedContract_FreelanceWork = driver.getCurrentUrl();
        Assert.assertEquals(actualContract_FreelanceWork, expectedContract_FreelanceWork, "URL DOES NOT MATCH");

        All_Jobs.click();
        String actualAll_Jobs = "https://careers.airbnb.com/positions/";
        String expectedAll_Jobs = driver.getCurrentUrl();
        Assert.assertEquals(actualAll_Jobs, expectedAll_Jobs, "URL DOES NOT MATCH");

    }

    public void verifyExploreRoles() {
        ExploreRoles.click();
        String actualExploreRoles = "Select location";
        String expectedExploreRoles = SelectLocation.getText();
        Assert.assertEquals(actualExploreRoles, expectedExploreRoles, "TEXT DOES NOT MATCH");
    }

    public void verifyNameOfLocationsList() {
        ExploreRoles.click();
        LocationsDropDownList.click();
    }

    public void goToAllJobsTab() {
        All_Jobs.click();
    }

    public void clickOnSearchOpportunities(){
        UniversityTab.click();
        SearchOpportunities.click();
    }
}
