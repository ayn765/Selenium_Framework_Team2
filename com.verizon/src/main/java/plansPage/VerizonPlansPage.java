package plansPage;

import common.BaseAPI;
import homepage.VerizonHomepage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static plansPage.VerizonPlansPageLocators.*;

public class VerizonPlansPage extends BaseAPI {

    public VerizonPlansPage() {
        PageFactory.initElements(driver, this);
//        new VerizonHomepage().navigateToVerizonPlansPage();
    }

    @FindBy(css = WEB_ELEMENT_BUTTON_ADD_LINE)
    public WebElement buttonAddLine;

    @FindBy(css = WEB_ELEMENT_BUTTON_SUBTRACT_LINE)
    public WebElement buttonSubtractLine;

    @FindBy(xpath = WEB_ELEMENTS_START_UNLIMITED_RATES)
    public List<WebElement> startUnlimitedRates;

    @FindBy(xpath = WEB_ELEMENTS_PLAY_MORE_UNLIMITED_RATES)
    public List<WebElement> playMoreUnlimitedRates;

    @FindBy(xpath = WEB_ELEMENTS_DO_MORE_UNLIMITED_RATES)
    public List<WebElement> doMoreUnlimitedRates;

    @FindBy(xpath = WEB_ELEMENTS_GET_MORE_UNLIMITED_RATES)
    public List<WebElement> getMoreUnlimitedRates;


    public void verifyRates() throws InterruptedException {
//        for(int i = 0; i < 2; i++){
           try{
               clickElement(buttonSubtractLine);
           }catch(Exception e){
               e.printStackTrace();
           }
            Thread.sleep(10000);



        int x = 4;

            do {
                String rate = driver.findElement(By.xpath("//div[@id='start-unlimited31-tab']//span[@class='line-price-" + (x) + "']")).getAttribute("innerHTML");
                System.out.println(rate);

                try{clickElement(buttonSubtractLine);
                    Thread.sleep(20000);
                }catch (StaleElementReferenceException e){
                    e.printStackTrace();
                }
                x--;
            } while (x < 0);

        }
//
    }
//    }
