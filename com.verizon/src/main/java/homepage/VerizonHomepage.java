package homepage;

import accessoriesPage.VerizonAccessoriesPage;
import common.BaseAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import plansPage.VerizonPlansPage;

import static homepage.VerizonHomepageLocators.*;

public class VerizonHomepage extends BaseAPI {

    public VerizonHomepage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = WEB_ELEMENT_LINK_NAVIGATE_TO_PLANS_PAGE)
    public WebElement linkNavigateToPlansPage;

    @FindBy(css = WEB_ELEMENT_LINK_NAVIGATE_TO_ACCESSORIES_PAGE)
    public WebElement linkNavigateToAccessoriesPage;

    public VerizonPlansPage navigateToVerizonPlansPage(){
        clickElement(linkNavigateToPlansPage);
        return new VerizonPlansPage();
    }
    public VerizonAccessoriesPage navigateToAccessoriesPage(){
        clickElement(linkNavigateToAccessoriesPage);
        return new VerizonAccessoriesPage();
    }
}
