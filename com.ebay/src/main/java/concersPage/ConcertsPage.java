package concersPage;

import common.BaseAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DataReader;

import java.io.IOException;
import java.util.List;

import static concersPage.ConcertsPageLocators.*;

public class ConcertsPage extends BaseAPI {

    public ConcertsPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = WEBELEMENT_HEADER_CONCERT_TICKETS_PAGE)
    public WebElement headerConcertTicketsPage;

    @FindBy(xpath = WEBELEMENTS_MENU_TICKETS_AND_EXPERIENCES_OPTIONS)
    public List<WebElement> menuTicketsAndExperiencesOptions;

    public boolean verifyMenuTicketsOptions() throws IOException {
        boolean flag;
        DataReader dataReader = new DataReader();
        flag = dataReader.compareListWebElementsToExcelDoc(menuTicketsAndExperiencesOptions, System.getProperty("user.dir")+"/src/test/resources/TestData.xlsx", "MenuOptions");
        return flag;
    }
}
