package careersPageTest;

import careersPage.AirbnbCareers;
import common.BaseAPI;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AirbnbCareersPageTest extends BaseAPI {

    AirbnbCareers airbnbCareers;

    @Test (enabled = false)
    public void testCareersPage() {
        airbnbCareers = new AirbnbCareers();
        airbnbCareers.verifyTabsOpen();

    }

    @Test (enabled = false)
    public void testExploreRolesButton(){
        airbnbCareers = new AirbnbCareers();
        airbnbCareers.verifyExploreRoles();
    }


    @Test (enabled = false)
    public void testSelectLocationDropDownName(){
        airbnbCareers = new AirbnbCareers();
        airbnbCareers.verifyNameOfLocationsList();

        WebElement elementList = airbnbCareers.LocationsDropDownList;

        String actualList = elementList.getText();
        String expectedList = "All Locations";

        Assert.assertEquals(actualList, expectedList, "NAME OF CATEGORIES DOES NOT MATCH");
}

    @Test (enabled = false)
    public void testGoToAllJobsTab(){
        airbnbCareers = new AirbnbCareers();
        airbnbCareers.goToAllJobsTab();

        String actualAllJobsTab = driver.getTitle();
        String expectedAllJobsTab = "All jobs - Careers at Airbnb";

        Assert.assertEquals(actualAllJobsTab, expectedAllJobsTab, "TITLES DOES NOT MATCH");

    }

    @Test (enabled = false)
    public void testSearchOpportunitiesButton() {
        airbnbCareers = new AirbnbCareers();
        airbnbCareers.clickOnSearchOpportunities();

        String actualSearchOpportunities = airbnbCareers.SearchOpportunities.getText();
        String expectedSearchOpportunities = "Search opportunities ";

        Assert.assertEquals(actualSearchOpportunities, expectedSearchOpportunities, "REDIRECTION NAME DOES NOT MATCH");
    }




}
