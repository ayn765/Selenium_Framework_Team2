package concertsPage;

import common.BaseAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DataReader;

import java.io.IOException;
import java.util.List;

import static concertsPage.EbayConcertsPageLocators.*;

public class EbayConcertsPage extends BaseAPI {

    public EbayConcertsPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = WEBELEMENT_HEADER_CONCERT_TICKETS_PAGE)
    public WebElement headerConcertTicketsPage;

    @FindBy(xpath = WEBELEMENTS_MENU_TICKETS_AND_EXPERIENCES_OPTIONS)
    public List<WebElement> menuTicketsAndExperiencesOptions;

    @FindBy(xpath = WEBELEMENT_CHECKBOX_VENUE_STATE_CA)
    public WebElement checkboxVenueStateCA;

    @FindBy(xpath = WEBELEMENT_TICKET)
    public WebElement ticket;

    @FindBy(css = WEBELEMENT_ADD_TO_CART)
    public WebElement addToCart;

    @FindBy(css = WEBELEMENT_ITEM_ADDED_TO_CART)
    public WebElement itemAddedToCart;

    public boolean verifyMenuTicketsOptions() throws IOException {
        boolean flag;
        DataReader dataReader = new DataReader();
        flag = dataReader.compareListWebElementsToExcelDoc(menuTicketsAndExperiencesOptions, System.getProperty("user.dir")+"/src/test/resources/TestData.xlsx", "MenuOptions");
        return flag;
    }

    public void addTicketToCart(){
        clickElement(checkboxVenueStateCA);
        clickElement(ticket);
        clickElement(addToCart);

    }
}
