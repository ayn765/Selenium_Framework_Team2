package fantasyPage.fantasyCollege;

import common.BaseAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.TextFileReader;

import static fantasyPage.fantasyCollege.CBSSportsFantasyCollegePageLocators.*;


public class CBSSportsFantasyCollegePage extends BaseAPI {

    public CBSSportsFantasyCollegePage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = WEBELEMENT_HEADER)
    public WebElement header;

    public boolean verifyHeader(){
        boolean flag;
        String actualHeader = header.getText();
        System.out.println("Actual header: "+ actualHeader);
        TextFileReader textFileReader = new TextFileReader();
        String expectedHeader = textFileReader.readToString(System.getProperty("user.dir")+ "/src/test/resources/CollegePageHeader.txt");
        System.out.println("Expected header: " + expectedHeader);
        flag = actualHeader.equals(expectedHeader);
    return flag;
    }

}
