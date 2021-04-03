package homepage;

import common.BaseAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

import static homepage.AirbnbHomepageLocators.*;
import static homepage.AirbnbHomepageLocators.webElementSearchButton;

public class AirbnbHomepage extends BaseAPI {

    @FindBy(css = webElementLocation)
    WebElement location;

    @FindBy(css = webElementWhereAreYouGoingInput)
    WebElement whereAreYouGoingInput;

    @FindBy(css = webElementExpectedVacationLocation)
    WebElement expectedVacationLocation;

    @FindBy(xpath = webElementCheckInAddDates)
    WebElement checkInAddDates;

    @FindBy(css = webElementIAmFlexible)
    WebElement iAmFlexible;

    @FindBy(xpath = webElementCheckOutAddDates)
    WebElement checkOutAddDates;

    @FindBy(css = webElementDate12May2021)
    WebElement date12May2021;

    @FindBy(css = webElementDate19May2021)
    WebElement date19May2021;

    @FindBy(xpath = getWebElementExpectedVacationDate)
    WebElement expectedVacationDate;

    @FindBy(xpath = webElementAddGuests)
    WebElement addGuests;

    @FindBy(css = webElementIncreaseAdultGuest)
    WebElement increaseAdultGuest;

    @FindBy(xpath = webElementExpectedNumOfGuests)
    WebElement expectedNumOfGuests;

    @FindBy(css = webElementSearchButton)
    WebElement searchButton;

    @FindBy(css = webElementLanguageIcon)
    WebElement languageIcon;

    @FindBy(css = webElementListOfLanguages)
    List<WebElement> listOfLanguages;

    @FindBy(css = webElementExploreNearbyDest)
    WebElement exploreNearbyDest;

    public AirbnbHomepage() {
        PageFactory.initElements(driver, this);
    }

    public void sendKeysToDestination(String keysToSend) {
        whereAreYouGoingInput.sendKeys(keysToSend);
    }


    public void verifyFlexibleSearch() {
        checkInAddDates.click();
        iAmFlexible.click();
        addGuests.click();
        increaseAdultGuest.click();
        searchButton.click();
    }

    public void verifyPickDatesSearch() {
        location.click();
        exploreNearbyDest.click();
        checkInAddDates.click();
        date12May2021.click();
        checkOutAddDates.click();
        date19May2021.click();
        addGuests.click();
        increaseAdultGuest.click();
        searchButton.click();
        boolean isExpectedLocationDisplayed = expectedVacationLocation.isDisplayed();
        boolean isExpectedVacationDateDisplayed = expectedVacationDate.isDisplayed();
        boolean isExpectedNumOfGuestsDisplayed = expectedNumOfGuests.isDisplayed();
    }

    public void verifyNumOfLanguages() {
        languageIcon.click();
        int actualNumOfLanguages = listOfLanguages.size();
        int expectedNumOfLanguages = 91;
        Assert.assertEquals(actualNumOfLanguages, expectedNumOfLanguages, "The number of languages is incorrect.");
    }

    public void verifyLanguages() {
        languageIcon.click();
        String[] expectedListOfLanguages = {"English\nUnited States", "Azərbaycan dili\nAzərbaycan", "Bahasa Indonesia\nIndonesia",
                "Bosanski\nBosna i Hercegovina", "Català\nEspanya", "Čeština\nČeská republika", "Crnogorski\nCrna Gora", "Dansk\nDanmark",
                "Deutsch\nDeutschland", "Deutsch\nÖsterreich", "Deutsch\nSchweiz", "Eesti\nEesti", "English\nAustralia", "English\nCanada", "English\nGuyana",
                "English\nIndia", "English\nIreland", "English\nNew Zealand", "English\nSingapore", "English\nUnited Arab Emirates",
                "English\nUnited Kingdom", "Español\nArgentina", "Español\nBelice", "Español\nBolivia", "Español\nChile"};


        waitUntilWebElementsVisible(listOfLanguages);

        for (int i = 0; i < 25; i++) {
            String langValue = listOfLanguages.get(i).getText();
            if (langValue.equals(expectedListOfLanguages[i])) {
                System.out.println("Passed on: " + langValue);
            } else {
                System.out.println("Failed on: " + langValue);
            }

        }

    }

}
