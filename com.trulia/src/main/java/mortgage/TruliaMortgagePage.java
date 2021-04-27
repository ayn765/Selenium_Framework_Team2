package mortgage;

import common.BaseAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static mortgage.TruliaMortgagePageLocators.*;

public class TruliaMortgagePage extends BaseAPI {

    public TruliaMortgagePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = WEB_ELEMENT_INPUT_ZIPCODE)
    public WebElement inputZipCode;

    @FindBy(xpath = WEB_ELEMENT_BUTTON_GET_PRE_QUALIFIED)
    public WebElement buttonGetPreQualified;

    @FindBy(css = WEB_ELEMENTS_OPTIONS_GET_PRE_QUALIFIED)
    public List<WebElement> optionsGetPreQualified;

    @FindBy(xpath = WEB_ELEMENT_BUTTON_AFFORDABILITY_CALCULATOR)
    public WebElement buttonAffordabilityCalculator;

    @FindBy(css = WEB_ELEMENT_INPUT_ANNUAL_INCOME)
    public WebElement inputAnnualIncome;

    @FindBy(css = WEB_ELEMENT_INPUT_DOWN_PAYMENT)
    public WebElement inputDownPayment;

    @FindBy(css = WEB_ELEMENT_SELECT_CREDIT_SCORE)
    public WebElement selectCreditScore;

    @FindBy(css = WEB_ELEMENT_SLIDER_DEPT_TO_INCOME)
    public WebElement sliderDeptToIncome;

    @FindBy(css = WEB_ELEMENT_BUTTON_GET_PRE_QUALIFIED_CALCULATOR)
    public WebElement buttonPreQualifiedCalculator;

    @FindBy(css = WEB_ELEMENT_RESULT_AFFORD_HOUSE_VALUE)
    public WebElement resultAffordHouseValue;

    @FindBy(css = WEB_ELEMENT_RESULT_AFFORD_MONTHLY_PAYMENT)
    public WebElement resultAffordMonthlyPayment;

    @FindBy(xpath = WEB_ELEMENT_BUTTON_REFINANCE_CALCULATOR)
    public WebElement buttonRefinanceCalculator;

    @FindBy(css = WEB_ELEMENT_SLIDER_TOTAL_SAVINGS)
    public WebElement sliderTotalSavings;

    @FindBy(css = WEB_ELEMENT_RESULT_TOTAL_SAVINGS)
    public WebElement resultTotalSavings;

    @FindBy(xpath = WEB_ELEMENT_BUTTON_SEE_MORE)
    public WebElement buttonSeeMore;

    @FindBy(xpath = WEB_ELEMENT_BUTTON_LENDER_DIRECTORY)
    public WebElement buttonLenderDirectory;

    @FindBy(css = WEB_ELEMENT_INPUT_LOCATION)
    public WebElement inputLocation;

    @FindBy(css = WEB_ELEMENT_INPUT_NAME)
    public WebElement inputName;

    @FindBy(css = WEB_ELEMENT_BUTTON_SEARCH)
    public WebElement buttonSearch;

    @FindBy(xpath = WEB_ELEMENT_DROPDOWN_PROMPT)
    public WebElement dropdownPrompt;

    @FindBy(xpath = WEB_ELEMENTS_RESULTS_LENDER_DIRECTORY)
    public List<WebElement> resultsLenderDirectory;

    @FindBy(css = WEB_ELEMENT_LICENSE_AGREEMENT)
    public WebElement licenseAgreement;

    @FindBy(xpath = WEB_ELEMENTS_TEXT_HELP)
    public List<WebElement> helpText;

    @FindBy(xpath = WEB_ELEMENTS_BUTTONS_HELP)
    public List<WebElement> buttonsHelp;

    @FindBy(css = WEB_ELEMENT_MORTGAGE_QUESTIONS)
    public List<WebElement> mortgageQuestions;

    @FindBy(css = WEB_ELEMENT_LINKS_MORTGAGE_RESOURCES)
    public List<WebElement> linksMortgageResources;

    @FindBy(css = WEB_ELEMENTS_HOVER_HELP_BOX)
    public List<WebElement> hoverHelpBox;

    @FindBy(css = WEB_ELEMENTS_TEXT_HOVER_HELP_BOX)
    public List<WebElement> textHoverHelpBox;

    @FindBy(css = WEB_ELEMENT_TAB_REFINANCE)
    public WebElement tabRefinance;

    @FindBy(css = WEB_ELEMENT_PROPERTY_VALUE)
    public WebElement inputPropertyValue;

    @FindBy(css = WEB_ELEMENT_INPUT_CURRENT_BALANCE)
    public WebElement inputCurrentBalance;

    @FindBy(css = WEB_ELEMENT_CHECKBOX_MILITARY)
    public WebElement checkboxMilitary;

    @FindBy(xpath = WEB_ELEMENT_BUTTON_SEE_RATES)
    public WebElement buttonSeeRates;

    @FindBy(xpath = WEB_ELEMENT_BUTTON_NEXT)
    public WebElement buttonNext;

    @FindBy(css = WEB_ELEMENT_DROPDOWN_MORTGAGE)
    public List<WebElement> dropdownMortgage;

    public void getPreQualifiedRequest() {
        clearInputFieldAndSendKeysToElement(inputZipCode, "20165");
        clickElement(buttonGetPreQualified);
    }

    public boolean verifyOptionsGetPrequalifiedText() throws IOException {
        waitUntilWebElementListVisible(optionsGetPreQualified);
        System.out.println(optionsGetPreQualified.size());
        return compareListWebElementsToExcelDoc(optionsGetPreQualified, pathFromUserDir + "/src/test/resources/TruliaTestData.xlsx", "GetPreQualifiedOptions1");
    }

    public boolean verifyOptionsGetPreQualifiedLinksValid() {
        waitUntilWebElementListVisible(optionsGetPreQualified);
        return verifyLinks(optionsGetPreQualified, "href");
    }

    public void doAffordabilityCalculator() {
        implicitWait();
        clickElement(buttonAffordabilityCalculator);
        clearInputFieldAndSendKeysToElement(inputAnnualIncome, "150000");
        clearInputFieldAndSendKeysToElement(inputDownPayment, "30000");
        selectFromDropDownByIndex(selectCreditScore, 0);
        sliderBarAction(sliderDeptToIncome);
    }

    public void doSliderTotalSavings() throws InterruptedException {
        clickElement(buttonRefinanceCalculator);
        implicitWait();
        sliderBarAction(sliderTotalSavings);
        waitUntilWebElementVisible(resultTotalSavings);
        System.out.println(resultTotalSavings.getText());
    }

    public boolean searchLenderDirectory() {
        implicitWait();
        buttonSeeMore.click();
        buttonLenderDirectory.click();
        clearInputFieldAndSendKeysToElement(inputLocation, "Washin");
        dropdownPrompt.click();
        clearInputFieldAndSendKeysToElement(inputName, "Bank of America");
        clearInputFieldAndSendKeysToElement(inputName, "Bank of America");
        buttonSearch.click();
        String expectedResults = "Bank of America, N.A.";
        return compareListElementsToExpectedString(resultsLenderDirectory, expectedResults);
    }

    public boolean verifyHelpText() throws IOException {
        buttonRefinanceCalculator.click();
        implicitWait();
        return compareListWebElementsToExcelDoc(helpText, pathFromUserDir + "/src/test/resources/TruliaTestData.xlsx", "HelpText");
    }

    public boolean verifyMortgageQuestions() throws IOException {
        waitUntilWebElementListVisible(mortgageQuestions);
        return compareListWebElementsToExcelDoc(mortgageQuestions, pathFromUserDir + "/src/test/resources/TruliaTestData.xlsx", "MortgageQuestions");

    }

    public boolean verifyLinksMortgageResources() {
        buttonRefinanceCalculator.click();
        waitUntilWebElementListVisible(linksMortgageResources);
        return verifyLinks(linksMortgageResources, "href");
    }

    public boolean verifyLinksTitlesMortgageResources() throws IOException {
        buttonRefinanceCalculator.click();
        waitUntilWebElementListVisible(linksMortgageResources);
        return getUrlsAndTitlesFromListWebElementAndCompareToExcelDoc(linksMortgageResources, "href", pathFromUserDir + "/src/test/resources/TruliaTestData.xlsx", "LinksTitlesMortgageResources");
    }

    //SO PROUD OF THIS METHODS REGARDLESS THE SLEEP

    public boolean verifyHoverHelp() throws InterruptedException, IOException {
        buttonAffordabilityCalculator.click();
        implicitWait();
        ArrayList<String> allHelpOptions = new ArrayList<>();

        for (int i = 0; i < hoverHelpBox.size(); i++) {
            hoverOverElement(hoverHelpBox.get(i));
            Thread.sleep(2000);
            String helpBoxOption = driver.findElement(By.cssSelector("#tooltip-container-tooltip-" + (i + 1) + "> div")).getText();
//            System.out.println((i + 1) + " value is: " + helpBoxOption);
            allHelpOptions.add(helpBoxOption);
        }
        return compareListStringsToExcelDoc(allHelpOptions, pathFromUserDir + "/src/test/resources/TruliaTestData.xlsx", "HelpBoxOptions");
    }

    public void doRefinance(){
        clickElement(tabRefinance);
        clearInputFieldAndSendKeysToElement(inputPropertyValue, "500000");
        clearInputFieldAndSendKeysToElement(inputCurrentBalance, "300000");
        checkboxMilitary.click();
        clickElement(buttonSeeRates);
        waitUntilWebElementVisible(buttonNext);
    }

    public boolean verifyDropdownMortgage() throws Exception {
        return compareListWebElementsToExcelDoc(dropdownMortgage,pathFromUserDir + "/src/test/resources/TruliaTestData.xlsx", "MortgageDropdown");
    }


}