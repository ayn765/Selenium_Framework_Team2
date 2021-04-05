package careersPage;

import common.BaseAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static careersPage.AirbnbCareersLocators.*;


public class AirbnbCareers extends BaseAPI {


    @FindBy(css = webElementUniversityTab)
    WebElement UniversityTab;

    @FindBy(css = webElementContract_FreelanceWorkTab)
    WebElement Contract_FreelanceWork;

    @FindBy(css = webElementAll_JobsTab)
    WebElement All_Jobs;

    @FindBy(xpath = webElementExploreRolesTab)
    WebElement ExploreRoles;

    @FindBy(xpath = webElementSelectLocation)
    WebElement SelectLocation;

    public AirbnbCareers() {
        PageFactory.initElements(driver, this);
    }

    WebDriverWait wait;


    public void verifyTabsOpen() {
        UniversityTab.click();
        String actualUniversityURL = "https://careers.airbnb.com/university/";
        String expectedUniversityURL = driver.getCurrentUrl();
        Assert.assertEquals(actualUniversityURL, expectedUniversityURL);

        Contract_FreelanceWork.click();
        String actualContract_FreelanceWork = "https://careers.airbnb.com/contractors/";
        String expectedContract_FreelanceWork = driver.getCurrentUrl();
        Assert.assertEquals(actualContract_FreelanceWork, expectedContract_FreelanceWork);

        All_Jobs.click();
        String actualAll_Jobs = "https://careers.airbnb.com/positions/";
        String expectedAll_Jobs = driver.getCurrentUrl();
        Assert.assertEquals(actualAll_Jobs, expectedAll_Jobs);

    }

//    public boolean isSelectLocationsTextDisplay(){
//        ExploreRoles.click();
//
////        return wait.until(ExpectedConditions.visibilityOfElementLocated(SelectLocation))


}
