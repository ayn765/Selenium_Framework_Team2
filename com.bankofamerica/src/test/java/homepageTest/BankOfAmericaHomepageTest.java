package homepageTest;

import common.BaseAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class BankOfAmericaHomepageTest extends BaseAPI {
    BankOfAmericaHomepage bankOfAmericaHomepage;
    private String dataProvider;

    @Test(enabled = false)
    public void testnumOfiframe() {
        bankOfAmericaHomepage = new BankOfAmericaHomepage();
        bankOfAmericaHomepage.getNumOfIframe();
        Assert.assertEquals( bankOfAmericaHomepage.getNumOfIframe(), 3);
    }
    @Test
    public void testSwitchfromAnIframeToanother() {
        bankOfAmericaHomepage = new BankOfAmericaHomepage();
       bankOfAmericaHomepage.switchtoTheNextIframe();
    }


    @Test(enabled = false)
    public void testINVALDLOGiN() {
        bankOfAmericaHomepage = new BankOfAmericaHomepage();
        bankOfAmericaHomepage.invalidLogIn("neilavtgsf","1234abc");
        Assert.assertEquals(getTextFromElement(bankOfAmericaHomepage.TextAfterLogIn), "Your Passcode is missing. Please try again.");
    }

    @Test(dataProviderClass = BankOfAmericaHomepage.class, dataProvider = "getInvalidLoginTestData")
    public void testLogIn() {
        bankOfAmericaHomepage = new BankOfAmericaHomepage();
        bankOfAmericaHomepage.invalidLogIn("neilavtgsf","1234abc");
        Assert.assertEquals(getTextFromElement(bankOfAmericaHomepage.TextAfterLogIn), "Your Passcode is missing. Please try again.");}







    @Test(enabled = false)
    public void Testlocation() {
        bankOfAmericaHomepage = new BankOfAmericaHomepage();
        bankOfAmericaHomepage.searchLocation("18074");
        String actualText = getTextFromElement(bankOfAmericaHomepage.expectedResultLocation);
        String expectedText = "1833 E Ridge Pike, Royersford, PA 19468";
        Assert.assertEquals(actualText, expectedText);

    }


    @Test(enabled = false)
    public void testPlayingVideo() {
        bankOfAmericaHomepage = new BankOfAmericaHomepage();
        bankOfAmericaHomepage.navigateToVideo();
        String a = getTextFromElement(bankOfAmericaHomepage.expectedTextVideo);
        String expectedText = "See how Erica® makes everyday banking easier";

        Assert.assertEquals(a, expectedText);
        //bankOfAmericaHomepage.videoTimer.getCurrentUrL();
// String a= bankOfAmericaHomepage.buttonAskErica.getText();
        // System.out.println(a);
        // bankOfAmericaHomepage.videoTimer.getAttribute(" ended");
    }

    @Test(enabled = false)
    public void testCreditCardMenu() {
        bankOfAmericaHomepage = new BankOfAmericaHomepage();
        bankOfAmericaHomepage.navigateToCridtCardPage();
        String a = getTextFromElement(bankOfAmericaHomepage.expectedTextCriditCard);
        System.out.println(a);
        String expectedText = "25,000 online bonus points after you make at least $1,000 in purchases in the first 90 days of account opening – which can be redeemed for a $250 statement credit toward travel purchases.";

        Assert.assertEquals(a, expectedText);

    }

    @Test(enabled = false)
    public void testImageInHomepage() {//static image
        bankOfAmericaHomepage = new BankOfAmericaHomepage();
        if (bankOfAmericaHomepage.imageHomepage.isDisplayed()) {
            System.out.println("image is displayed");
            String actualText = bankOfAmericaHomepage.imageHomepage.getAttribute("alt");
            System.out.println("actualText is: " + actualText);
            String expectedText = "Bank of America Logo";
            System.out.println("expectedText is: " + expectedText);
            Assert.assertEquals(actualText, expectedText);
        } else {
            System.out.println("image is not displayed");
        }
    }

    @Test(enabled = false)
    public void testImageAskErica() {//problem with imageAskErica
        bankOfAmericaHomepage = new BankOfAmericaHomepage();
        if (bankOfAmericaHomepage.imageAskErica.isEnabled()) {
            System.out.println("image is Enbaled");
            bankOfAmericaHomepage.clickOnImageAskErica();
        } else {
            System.out.println("image is not Enbaled ");
        }
    }

    @Test(enabled = false)
    public void tesLinkImage() {
        bankOfAmericaHomepage = new BankOfAmericaHomepage();
        selectElement(bankOfAmericaHomepage.linkImageCashReward);


        //System.out.println(text);

    }

    @Test(enabled = false)
    public void testHomeLoan() {
        bankOfAmericaHomepage = new BankOfAmericaHomepage();
        bankOfAmericaHomepage.navigateToHomeLoans();
        bankOfAmericaHomepage.navigateToMortgagePage();
        bankOfAmericaHomepage.sendKeysPurchasePriceBox("199000");
        bankOfAmericaHomepage.sendKeysDownPaymentBox("20000");
        bankOfAmericaHomepage.sendKeysZipCodeBox("18074");
        String actualText = getTextFromElement(bankOfAmericaHomepage.expectedTextHomeLoan);
        System.out.println(actualText);
        String expectedText = "Enter a down payment that is at least 5% of the purchase price.";
        System.out.println(expectedText);
        Assert.assertEquals(actualText, expectedText);


    }

    @Test(enabled = false)
    public void testWebLinksNum() throws IOException {
        bankOfAmericaHomepage = new BankOfAmericaHomepage();
        clickElement(bankOfAmericaHomepage.buttonCriditCard);


        // Capture link from current page
        List<WebElement> links = driver.findElements(By.tagName("link"));
        int actuallinksNum = links.size();
        System.out.println(actuallinksNum);
        int expectedLinks = 142;
        System.out.println(expectedLinks);
        Assert.assertEquals(actuallinksNum, expectedLinks);


    }

    @Test(enabled = false)
    public void testHelpBox() throws IOException {
        bankOfAmericaHomepage = new BankOfAmericaHomepage();
        bankOfAmericaHomepage.extandSearch("bill pay");

        Assert.assertEquals( getTextFromElement(bankOfAmericaHomepage.expectedTextHelpPage), "BILL PAY");


    }

    @Test(enabled = false)
    public void testCheckingPage() {
        bankOfAmericaHomepage = new BankOfAmericaHomepage();
        bankOfAmericaHomepage.navigateToCheCkingPage();
        if (bankOfAmericaHomepage.expectedImageChecking.isDisplayed()) {
            System.out.println("image is displayed");
            String actualText = bankOfAmericaHomepage.expectedImageChecking.getAttribute("alt");
            System.out.println("actualText is: " + actualText);
            // String expectedText = "";
            // System.out.println("expectedText is: " + expectedText);
            //  Assert.assertEquals(actualText, expectedText);
        } else {
            System.out.println("image is not displayed");
        }


    }

    @Test(enabled = false)
    public void testSavingsPage() {
        bankOfAmericaHomepage = new BankOfAmericaHomepage();
        bankOfAmericaHomepage.navigateToSavingsPage();
        String actualText = getTextFromElement(bankOfAmericaHomepage.expectedTextSavings);
        System.out.println(actualText);
        String expectedText = "Save for a child's future\n" +
                "\n" +
                "Interest-earning savings accounts for children to help prepare for the future\n" +
                "Compare accounts";
        System.out.println((expectedText));
        Assert.assertEquals(actualText, expectedText);
    }

    @Test(enabled = false)
    public void testAutoLoanPage() {
        bankOfAmericaHomepage = new BankOfAmericaHomepage();
        bankOfAmericaHomepage.navigateToAutoPage();
        String actualText = getTextFromElement(bankOfAmericaHomepage.expectedHeaderAutoLoan);
        System.out.println(actualText);
        String expectedText = "Lock in a fixed rate as low as";
        System.out.println((expectedText));
        Assert.assertEquals(actualText, expectedText);
    }



}
