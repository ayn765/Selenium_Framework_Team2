package expediaThingsToDo;

import common.BaseAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static expediaThingsToDo.ExpediaThingsToDoLocators.*;

public class ExpediaThingsToDo extends BaseAPI {

    public ExpediaThingsToDo() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = WEB_ELEMENT_THINGS_TO_DO_SEARCH_BAR)
    public WebElement Things_To_Do_Search_Bar;

    @FindBy(css = WEB_ELEMENT_FROM_DATE_BUTTON)
    public WebElement From_Date_Button;

    @FindBy(css = WEB_ELEMENT_TO_DATE_BUTTON)
    public WebElement To_Date_Button;

    @FindBy(xpath = WEB_ELEMENT_SEARCH_BUTTON)
    public WebElement Search_Button;

    @FindBy(css = WEB_ELEMENT_TO_DATE_BUTTON)
    public WebElement To_Date;

    @FindBy(css = WEB_ELEMENT_TO_DO_MONTH)
    public WebElement To_Do_Month;

    @FindBy(css = WEB_ELEMENT_TO_DO_MONTH_POINTER)
    public WebElement To_Do_Month_Arrow;

    @FindBy(xpath = WEB_ELEMENT_SINGLE_FROM_DATES)
    public List <WebElement> SingleFromDatePicker;

    @FindBy(xpath = WEB_ELEMENT_SINGLE_TO_DATES)
    public List <WebElement> SingleToDatePicker;

    @FindBy(css = WEB_ELEMENT_RECOMMENDED_BUTTON)
    public WebElement RecommendedButton;

    @FindBy(css = WEB_ELEMENT_LOW_SORT_BUTTON)
    public WebElement LowSortButton;

    @FindBy(css = WEB_ELEMENT_HIGH_PRICE_BUTTON)
    public WebElement HighSortButton;

    @FindBy(css = WEB_ELEMENT_FIND_DESTINATION)
    public List <WebElement> FindDestination;




    public void clickKeysToSearchBar() {
        waitForPageLoad("https://www.expedia.com/Activities");
        Things_To_Do_Search_Bar.click();
    }

    public void clickSearchButton() {
        Search_Button.click();
    }

    public void clickFromDateButtons() {
        String year = "2021";
        String month = "May";
        String date = "10";

        From_Date_Button.click();

        while (true) {
            String monthyear = From_Date_Button.getText();
            String arr[] = monthyear.split(" ");
            String mon = arr[0];
            String yr = arr[1];

            if (mon.equalsIgnoreCase(month) && yr.equals(year))
                break;
            else
                To_Do_Month_Arrow.click();
        }

        //Date Selection From
        for(WebElement ele:SingleFromDatePicker){
            String dt = ele.getText();
            if(dt.equals(date)){
            }
            ele.click();
            break;
        }

    }

    public void clickToDateButtons() {
        String year1 = "2021";
        String month1 = "June";
        String date1 = "15";

        while (true) {
            String monthyear1 = To_Date_Button.getText();
            String arr[] = monthyear1.split(" ");
            String mon = arr[0];
            String yr = arr[1];

            if (mon.equalsIgnoreCase(month1) && yr.equals(year1))
                break;
            else
                To_Do_Month_Arrow.click();
        }

        //Date Selection From
        for(WebElement ele:SingleToDatePicker){
            String dt = ele.getText();
            if(dt.equals(date1)){
            }
            ele.click();
            break;
        }
    }
    public void clickRecommendedButton() {
        javaScriptExecutorClickOnElement(RecommendedButton);
    }

    public void clickLowPriceButton() {
        actionClassClickOnElement(LowSortButton);
    }

    public void clickHighPriceButton() {
        clickElement(HighSortButton);

    }

    public void listDestinations() {
        getListOfWebElements(By.cssSelector("#region-1570976 > div.uitk-carousel.no-touch.all-t-margin-three.all-b-margin-zero.all-l-margin-three"));
    }

}