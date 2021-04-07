package homepage;

import adventuresPage.AirbnbAdventuresPage;
import becomeAHostPage.AirbnbBecomeAHostPage;
import common.BaseAPI;
import onlineExperiencesPage.AirbnbOnlineExperiencesPage;
import static homepage.AirbnbHomepageLocators.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DataReader;
import utilities.TextFileReader;
import java.io.IOException;
import java.util.List;



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

    @FindBy(xpath = webElementExpectedVacationDate)
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

    @FindBy(css = webElementButtonMainMenu)
    public WebElement buttonMainMenu;

    @FindBy(xpath = webElementButtonLogin)
    public WebElement buttonLogin;

    @FindBy(css = webElementInputPhoneNumber)
    public WebElement inputPhoneNumber;

    @FindBy(css = webElementButtonLogInContinue)
    public WebElement buttonLoginContinue;

    @FindBy(css = webElementInvPhoneErrorMessage)
    public WebElement invPhoneErrorMessage;

    @FindBy(css = webElementsInspirationGetaways)
    public List<WebElement> inspirationGetaways;

    @FindBy(css = webElementLinksExploreNearbyDest)
    public List<WebElement> linksExploreNearbyDest;

    @FindBy(css = webElementLinksLiveAnywhere)
    public List<WebElement> linksLiveAnywhere;


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

    public AirbnbBecomeAHostPage navigateToBecomeAHostPage() {
        actionClassClickOnElement(becomeAHost);
        return new AirbnbBecomeAHostPage();
    }

    public AirbnbAdventuresPage navigateToAdventuresPage() {
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


    public boolean verifyLanguages() throws IOException {
        boolean flag = false;
        int flagCount = 0;
        languageIcon.click();
        DataReader dataReader = new DataReader();
        String[] expectedListOfLanguages = dataReader.fileReaderStringArrayXSSF(System.getProperty("user.dir") + "/src/test/resources/TestData.xlsx", "Languages");

//        String[] expectedListOfLanguages = {"English\nUnited States", "Azərbaycan dili\nAzərbaycan", "Bahasa Indonesia\nIndonesia",
//                "Bosanski\nBosna i Hercegovina", "Català\nEspanya", "Čeština\nČeská republika", "Crnogorski\nCrna Gora", "Dansk\nDanmark",
//                "Deutsch\nDeutschland", "Deutsch\nÖsterreich", "Deutsch\nSchweiz", "Eesti\nEesti", "English\nAustralia", "English\nCanada", "English\nGuyana",
//                "English\nIndia", "English\nIreland", "English\nNew Zealand", "English\nSingapore", "English\nUnited Arab Emirates",
//                "English\nUnited Kingdom", "Español\nArgentina", "Español\nBelice", "Español\nBolivia", "Español\nChile"};


        waitUntilWebElementListVisible(listOfLanguages);

        for (int i = 0; i < 4; i++) {

            String langValue = listOfLanguages.get(i).getText();

            if (langValue.equals(expectedListOfLanguages[i])) {
                System.out.println("Passed on: " + langValue);
                flag = true;
            } else {
                System.out.println("Failed on: " + langValue);
                flag = false;
                flagCount++;
            }

        }
        if (flagCount > 0) {
            flag = false;

        }
        return flag;
    }

    public void invalidPhoneNumLogin() {
        buttonMainMenu.click();
        buttonLogin.click();
        inputPhoneNumber.sendKeys("1234567890");
        buttonLoginContinue.click();
    }

    public String getInvalidPhoneErrorMessage() {
        String errorMessage = "";
        TextFileReader reader = new TextFileReader();
        errorMessage = reader.readToString(System.getProperty("user.dir") + "/src/test/resources/InvalidPhoneMessage.txt");
        return errorMessage;
    }

    public boolean verifyInspirationGetaways() throws IOException {

        DataReader dataReader = new DataReader();
        String[] expectedGetawayOptions = dataReader.fileReaderStringArrayXSSF(System.getProperty("user.dir") + "/src/test/resources/TestData.xlsx", "Inspiration Getaways");
        waitUntilWebElementListVisible(inspirationGetaways);
        boolean flag = false;
        int count = 0;
        for (int i = 0; i <= inspirationGetaways.size() - 1; i++) {
            String getawayOption = inspirationGetaways.get(i).getText();
            if (getawayOption.equals(expectedGetawayOptions[i])) {
                flag = true;
                System.out.println("Passed on: " + getawayOption);
            } else {
                System.out.println("Failed on: " + getawayOption);
                count++;
            }
        }
        if (count > 0) {
            flag = false;
        }
        return flag;

//        Iterator<WebElement> iterator = inspirationGetaways.iterator();

//
//        int i = 0;
//        while (iterator.hasNext()) {
//
//            String getawayOption = iterator.next().getText();
//            if (!getawayOption.equals(expectedGetawayOptions[i])) {
//                System.out.println("Failed on: " + getawayOption);
//                i++;
//            } else
//                System.out.println("Passed on: " + getawayOption);
//        }
    }

    public boolean verifyLinksExploreNearbyDest() {
        BaseAPI baseAPI = new BaseAPI();
        boolean flag = baseAPI.verifyLinks(linksExploreNearbyDest, "src");
        return flag;
    }

    public boolean verifyLinksLiveAnywhere(){
        BaseAPI baseAPI = new BaseAPI();
        boolean flag = baseAPI.verifyLinks(linksLiveAnywhere, "src");
        return flag;
    }
}






