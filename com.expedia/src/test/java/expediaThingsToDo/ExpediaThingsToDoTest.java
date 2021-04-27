package expediaThingsToDo;

import common.BaseAPI;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExpediaThingsToDoTest extends BaseAPI {

    ExpediaThingsToDo expediaThingsToDo;

    @Test (enabled = false)
    public void testThingsToDoSearch() {
        expediaThingsToDo = new ExpediaThingsToDo();

        String searchKeys = "Atlanta";
        expediaThingsToDo.clickKeysToSearchBar();
        expediaThingsToDo.clickSearchButton();

        String actualText = "Atlanta";
        String expectedText = expediaThingsToDo.Things_To_Do_Search_Bar.getText();

        Assert.assertEquals(actualText, expectedText, "TEXT DOES NOT MATCH");

    }

    @Test
    public void testDateButtons() {
        expediaThingsToDo = new ExpediaThingsToDo();

        expediaThingsToDo.clickFromDateButtons();
        expediaThingsToDo.clickToDateButtons();

    }

    @Test
    public void testRecommendedButtons(){
        expediaThingsToDo = new ExpediaThingsToDo();
        expediaThingsToDo.clickRecommendedButton();

        String actualText = "Atlanta";
        String expectedText = getTextFromElement(expediaThingsToDo.Things_To_Do_Search_Bar);

        Assert.assertEquals(actualText, expectedText, "TITLE DOES NOT MATCH");


    }

    @Test
    public void testLowSortButton() {
        expediaThingsToDo = new ExpediaThingsToDo();
        expediaThingsToDo.clickLowPriceButton();

        String actualText = "Atlanta";
        String expectedText = driver.findElement(By.cssSelector("#placeholder > section.all-b-margin-six > h2")).getText();

        Assert.assertEquals(actualText, expectedText, "TITLES DO NOT MATCH");
    }

    @Test
    public void testHighSortButton() {
        expediaThingsToDo = new ExpediaThingsToDo();
        expediaThingsToDo.clickHighPriceButton();

        String actualText = "Atlanta";
        String expectedText = driver.findElement(By.cssSelector("#placeholder > section.all-b-margin-six > h2")).getText();

        Assert.assertEquals(actualText, expectedText, "TITLES DO NOT MATCH");
    }

    @Test
    public void testDestinations(){
        expediaThingsToDo = new ExpediaThingsToDo();
        expediaThingsToDo.listDestinations();

    }

}
