package collegePage;
import common.BaseAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


import static collegePage.CollegePageLocators.*;
public class CollegePage extends BaseAPI {


    @FindBy (xpath=WEB_ELEMENT_BETTER_MONEY_HABITS)
    WebElement betterMoneyHabits;
    @FindBy(xpath = WEB_ELEMENT_COLLEGE_TAB)
    WebElement collegeTab;
    @FindBy(css=WEB_ELEMENT_DEBT_TAB)
    WebElement debtDropDown;
    @FindBy(xpath= WEB_ELEMENT_DEPTH_AND_FINANTIAL_ASSISTANCE)
    WebElement deptAndFinancialAssistanceOption;
    @FindBy(xpath = WEB_ELEMENT_FINANTIAL_ASSISTANCE_IMAGE)
    public WebElement imageFinancialAssistOption;
    @FindBy(xpath= WEB_ELEMENT_PAYING_BACK_STUDENT_LOANS)
    WebElement payingBackStudentLoans;
    @FindBy(xpath = WEB_ELEMENT_DELAYING_STUDENT_PAYMENT_IMAGE)
    public WebElement delayingStudentLoanImage;
    @FindBy(xpath= WEB_ELEMENT_VideoDelay_Loan)
    public WebElement delayLoanVideo;
    @FindBy(xpath = WEB_ELEMENT_BeforeCollege)
    WebElement beforeCollegeTab;
    @FindBy(xpath = WEB_ELEMENT_IMAGE_BEFORE_COLLEGE)
    public WebElement imageBeforeCollege;

    @FindBy(xpath = WEB_ELEMENT_HOME_OWNERSHIP_TAB)
    WebElement homeOwnershipTab;
    @FindBy(css = WEB_ELEMENT_HOME_EQUITY_OPTION)
    public WebElement selectHomeEquityOption;

    @FindBy(xpath = WEB_ELEMENT_EQUITY_HEADER)
    public WebElement equityHeader;

    @FindBy(xpath = WEB_ELEMENT_AUTO_TAB)
    WebElement autoTab;
    @FindBy(css = WEB_ELEMENT_AUTO_LOAN_TIPS)
    public WebElement selectAutoLoanFromAutoTab;
    @FindBy(css = WEB_ELEMENT_BUYING_A_CAR)
    WebElement clickBuyingCarTab;
    @FindBy(css= WEB_ELEMENT_VIDEO_GETTING_CAR_AFTER_MILITARY)
    public WebElement videoGettingCarAfterMilitary;

    @FindBy(css=WEB_ELEMENT_RETIREMENT_TAB)
    WebElement retirementTab;
    @FindBy (xpath= WEB_ELEMENT_RETIREMENT_PLAN)
    WebElement pickRetirementPlan;
    @FindBy(xpath= WEB_ELEMENT_GET_HEADER_RETIREMENT_PLAN)
    public WebElement HeaderRetirementPlan;
    //personal banking
    @FindBy(xpath=WEB_ELEMENT_PERSONAL_BANKING)
    public WebElement pwesonalBankingTab;
    @FindBy(xpath=WEB_ELEMENT_HOW_BANKING_WORKS)
    public WebElement howBankingWorksOption;
    @FindBy(xpath=WEB_ELEMENT_PERSONAL_BANKING_HEADER)
    public WebElement personalBankingHeader;
    //tAXES PREP
    @FindBy(xpath=WEB_ELEMENT_TAXES_AND_INCOME)
    public WebElement taxesAndIncome;
    @FindBy(xpath=WEB_ELEMENT_PRE_AND_FILLING)
    public WebElement prepAndFiling;
    @FindBy(xpath=WEB_ELEMENT_TAX_HEADER)
    public WebElement taxesHeader;
    //Privacy and security
    @FindBy(xpath=WEB_ELEMENT_PRIVACY_AND_SECURITY)
    public WebElement privacyAndSecurityTab;
    @FindBy(xpath=WEB_ELEMENT_LEARN_ABOUT_SECURITY)
    public WebElement learnAboutSecurity;
    @FindBy(css=WEB_ELEMENT_PRIVACY_AND_SECURITY_OPTION)
    public WebElement privacyAndSecurity;
    @FindBy(xpath=WEB_ELEMENT_VICTIMS_HEADER)
    public WebElement victimsHeader;
    //My priorities
    @FindBy(css=WEB_ELEMENT_MY_PRIORITIES)
    public WebElement myPrioritiesTab;
    @FindBy(xpath=WEB_ELEMENT_PRIORITY_HEADER)
    public WebElement priorityHeader;
    //do search
    @FindBy(css=WEB_ELEMENT_SEARCH_TAB)
    public WebElement searchTab;
    @FindBy(xpath=WEB_ELEMENT_SEARCH_BAR)
    public WebElement searchBar;
    @FindBy(xpath=WEB_ELEMENT_SEARCH_BUTTON)
     public WebElement searchButton;
    @FindBy (xpath=WEB_ELEMENT_BILL_PAYMENT_SEARCH_RESULT)
    public WebElement billPaymentSearchResult;
    //select routing number
    @FindBy(xpath=WEB_ELEMENT_SELECT_ROUTING_NUMBER)
    public WebElement selectRoutingNumber;
    @FindBy(xpath= WEB_ELEMENT_ROUTING_RESULT)
    public WebElement routingResult;
    //search open an account
    @FindBy (xpath = WEB_ELEMENT_OPEN_ACCOUNT_RESULT)
    public WebElement openAnAccountResult;




    public CollegePage(){
        PageFactory.initElements(driver,this);
    }

    public void verifyDeptDropDown(){
        debtDropDown.click();
        hoverOverElement(deptAndFinancialAssistanceOption);


    }
    public void verifyPayingBackLoanTab(){
                selectElement(payingBackStudentLoans);
    }
    public void verifyBeforeCollegeTab(){
                clickElement(beforeCollegeTab);

    }

    public void checkHomeOwnershipTab(){
                hoverOverElement(homeOwnershipTab);
                selectElement(selectHomeEquityOption);

    }

    public void verifyAutoTab(){
                hoverOverElement(autoTab);
                selectElement(selectAutoLoanFromAutoTab);

    }
    public void verifyNavigatingToBuyCarTab(){
        autoTab.click();
        selectElement(selectAutoLoanFromAutoTab);
        clickElement(clickBuyingCarTab);
    }



    public void verifyRetirementTab(){
                hoverOverElement(retirementTab);
                selectElement(pickRetirementPlan);
    }

    //personal banking tab
    public void verifyPersonalBankingTab(){
     hoverOverElement(pwesonalBankingTab);
     clickElement(howBankingWorksOption);
    }

    //Taxes and filing
    public void verifyTaxesAndFiling(){
    taxesAndIncome.click();
     clickElement(prepAndFiling);
    }
    //Privacy And Security Tab
    public void verifyPrivacyAndSecurityTab(){
    clickElement(privacyAndSecurityTab);
    selectElement(privacyAndSecurity);


    }
    //My Priority
    public void verifyMyPriority(){
        myPrioritiesTab.click();
    }

    public void doSearchBillPay(){
        searchTab.click();
        sendKeysToElement(searchBar,"bill pay");
        clickElement(searchButton);


    }
    public void doSearchOpenAccount(){
        searchTab.click();
        sendKeysToElement(searchBar,"open an account");
        clickElement(searchButton);

    }
    public void doSelectRoutingNumber(){
        searchTab.click();
        clickElement(searchBar);
        clickElement(selectRoutingNumber);
    }


}
