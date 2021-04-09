package flightsPageTest;

import common.BaseAPI;
import flightsPage.ExpediaFlightsPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.awt.*;

public class ExpediaFlightsPageTest extends BaseAPI {

    ExpediaFlightsPage expediaFlightsPage;

    @Test
    public void test() throws AWTException {
        expediaFlightsPage = new ExpediaFlightsPage();
        pressEscapeKey();
        waitUntilWebElementVisible(driver.findElement(By.xpath("//*[@id=\"uitk-tabs-button-container\"]/li[2]/a/span")));
        driver.findElement(By.xpath("//*[@id=\"uitk-tabs-button-container\"]/li[2]/a/span")).click();
        expediaFlightsPage.verifyAirlineAgeRules();
    }
}
