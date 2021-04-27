package expediaCruisesTest;

import common.BaseAPI;
import expediaCruisesPage.ExpediaCruisesPage;
import org.testng.annotations.Test;

public class ExpediaCruisesTestPage extends BaseAPI {

    ExpediaCruisesPage expediaCruisesPage = new ExpediaCruisesPage();

    //Test Case # 1
    @Test(enabled = false)
    public void testNavigateToCruisesPage() throws InterruptedException {

        expediaCruisesPage = new ExpediaCruisesPage();
        expediaCruisesPage.checkCruisesPage();
        // isElementDisplayed(expediaCruisesPage.travelersTab);
    }

    //Test Case # 2
    @Test(enabled = false)
    public void testNavigatingToTravelersTab() {
        expediaCruisesPage = new ExpediaCruisesPage();
        expediaCruisesPage.checkCruisesPage();
        expediaCruisesPage.verifyTwoTravelersTab();

    }

    //Test Case # 3
    @Test(enabled = false)
    public void testAddingChildrenUsingPlusButton() {
        expediaCruisesPage = new ExpediaCruisesPage();
        expediaCruisesPage.checkCruisesPage();
        expediaCruisesPage.verifyAddingChildrenButton();
    }

    //Test Case # 4
    @Test(enabled = false)
    public void testAddingChildAgeAndSelectingByIndex() {
        expediaCruisesPage = new ExpediaCruisesPage();
        expediaCruisesPage.checkCruisesPage();
        expediaCruisesPage.verifyAddingChildrenButton();
        expediaCruisesPage.verifySelectingChildAgeByIndex(2);

    }

    //Test Case # 5
    @Test(enabled = false)
    public void testAddingChildAgeAndSelectingByValue() {

        expediaCruisesPage = new ExpediaCruisesPage();
        String value = "1";
        expediaCruisesPage.checkCruisesPage();
        expediaCruisesPage.verifyAddingChildrenButton();
        expediaCruisesPage.verifySelectingChildAgeByValue(value);

    }

    //Test Case #6
    @Test(enabled = false)
    public void testAddingChildAgeAndSelectingByVisibleText() {

        expediaCruisesPage = new ExpediaCruisesPage();
        String visibleText = "4";
        expediaCruisesPage.checkCruisesPage();
        expediaCruisesPage.verifyAddingChildrenButton();
        expediaCruisesPage.verifySelectingChildAgeByVisibleText(visibleText);
    }

    //Test Case #7(*)
    @Test//(enabled = false)
    public void testSelectingDestinationByIndex(){
        expediaCruisesPage = new ExpediaCruisesPage();
        expediaCruisesPage.verifySelectingDestinationByIndex(1);
    }

    //Test Case #8 (*)
    @Test(enabled = false)
    public void testSelectingDestinationByValue() {
        expediaCruisesPage = new ExpediaCruisesPage();
        String value ="panama-canal";
        expediaCruisesPage.verifySelectingDestinationByValue(value);


    }
    //Test Case # 9 (*)
    @Test//(enabled = false)
    public void testSelectingDestinationByVisibleText() {

        expediaCruisesPage = new ExpediaCruisesPage();
        String visibleText="Central America";
        expediaCruisesPage.verifySelectingDestinationByVisibleText(visibleText);
    }







}