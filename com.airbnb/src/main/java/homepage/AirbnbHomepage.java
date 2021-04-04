package homepage;

import adventuresPage.AirbnbAdventuresPage;
import becomeAHostPage.AirbnbBecomeAHostPage;
import common.BaseAPI;
import onlineExperiencesPage.AirbnbOnlineExperiencesPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

import static homepage.AirbnbHomepageLocators.*;

public class AirbnbHomepage extends BaseAPI {

    @FindBy(css = webElementOnlineExperiences)
    public WebElement onlineExperiences;

    @FindBy(css = webElementBecomeAHost)
    public WebElement becomeAHost;

    @FindBy(xpath = webElementAdventures)
    public WebElement adventures;

    @FindBy(css = webElementLocation)
    public WebElement location;

    @FindBy(css = webElementWhereAreYouGoingInput)
    public WebElement whereAreYouGoingInput;

    @FindBy(xpath = webElementExpectedVacationLocation)
    public WebElement expectedVacationLocation;

    @FindBy(xpath = webElementCheckInAddDates)
    public WebElement checkInAddDates;

    @FindBy(css = webElementIAmFlexible)
    public WebElement iAmFlexible;

    @FindBy(xpath = webElementCheckOutAddDates)
    public WebElement checkOutAddDates;

    @FindBy(css = webElementDate12May2021)
    public WebElement date12May2021;

    @FindBy(css = webElementDate19May2021)
    public WebElement date19May2021;

    @FindBy(xpath = getWebElementExpectedVacationDate)
    public WebElement expectedVacationDate;

    @FindBy(xpath = webElementAddGuests)
    public WebElement addGuests;

    @FindBy(xpath = webElementIncreaseAdultGuest)
    public WebElement increaseAdultGuest;

    @FindBy(css = webElementIncreaseChildGuest)
    public WebElement increaseChildGuest;

    @FindBy(xpath = webElementExpectedNumOfGuests)
    public WebElement expectedNumOfGuests;

    @FindBy(css = webElementSearchButton)
    public WebElement searchButton;

    @FindBy(css = webElementLanguageIcon)
    public WebElement languageIcon;

    @FindBy(css = webElementListOfLanguages)
    public List<WebElement> listOfLanguages;

    @FindBy(css = webElementExploreNearbyDest)
    public WebElement exploreNearbyDest;

    public AirbnbHomepage() {
        PageFactory.initElements(driver, this);
    }

    public void sendKeysToDestination(String keysToSend) {
        whereAreYouGoingInput.sendKeys(keysToSend);
    }

    public AirbnbOnlineExperiencesPage navigateToOnlineExperiencesPage() {
        onlineExperiences.click();
        return new AirbnbOnlineExperiencesPage();
    }

    public AirbnbBecomeAHostPage navigateToBecomeAHostPage(){
        actionClassClickOnElement(becomeAHost);
        return new AirbnbBecomeAHostPage();
    }

    public AirbnbAdventuresPage navigateToAdventuresPage(){
        waitUntilWebElementVisible(adventures);
        actionClassClickOnElement(adventures);
        return new AirbnbAdventuresPage();
    }

    public void doFlexibleSearch() {
        sendKeysToDestination("Los Angeles");
        checkInAddDates.click();
        iAmFlexible.click();
        addGuests.click();
        increaseAdultGuest.click();
        searchButton.click();
    }

//    public void verifyVacationDateDisplayed() {
//        boolean isVacationDateDisplayed = expectedVacationDate.isDisplayed();
//        Assert.assertTrue(isVacationDateDisplayed);
//    }
//
//    public void verifyNumOfGuestsDisplayed() {
//        boolean isNumOfGuestsDisplayed = expectedNumOfGuests.isDisplayed();
//        Assert.assertTrue(isNumOfGuestsDisplayed);
//    }

    public void pickDatesSearch() {
        sendKeysToDestination("Los Angeles");
        checkInAddDates.click();
        date12May2021.click();
        date19May2021.click();
        addGuests.click();
        waitUntilWebElementClickable(increaseAdultGuest);
        actionClassClickOnElement(increaseAdultGuest);
        increaseChildGuest.click();
        searchButton.click();
    }


    public void verifyLanguages() {
        languageIcon.click();
        String[] expectedListOfLanguages = {"English\nUnited States", "Azərbaycan dili\nAzərbaycan", "Bahasa Indonesia\nIndonesia",
                "Bosanski\nBosna i Hercegovina", "Català\nEspanya", "Čeština\nČeská republika", "Crnogorski\nCrna Gora", "Dansk\nDanmark",
                "Deutsch\nDeutschland", "Deutsch\nÖsterreich", "Deutsch\nSchweiz", "Eesti\nEesti", "English\nAustralia", "English\nCanada", "English\nGuyana",
                "English\nIndia", "English\nIreland", "English\nNew Zealand", "English\nSingapore", "English\nUnited Arab Emirates",
                "English\nUnited Kingdom", "Español\nArgentina", "Español\nBelice", "Español\nBolivia", "Español\nChile"};


        waitUntilWebElementListVisible(listOfLanguages);

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
