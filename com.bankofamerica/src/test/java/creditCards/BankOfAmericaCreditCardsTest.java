package creditCards;

import common.BaseAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BankOfAmericaCreditCardsTest extends BaseAPI {

    BankOfAmericaCreditCards bankOfAmericaCreditCards;

    @Test
    public void test_Featured_Credit_Cards(){
        bankOfAmericaCreditCards = new BankOfAmericaCreditCards();
        bankOfAmericaCreditCards.clickFeatured_Credit_Cards();
        String actualText = "Bank of America® Cash Back Rewards Credit Card";
        String expectedText = bankOfAmericaCreditCards.Expected_Feature.getText();

        Assert.assertEquals(actualText, expectedText, "TITLE DOES NOT MATCH");

    }

    @Test
    public void test_Cash_Rewards_Cards() {
        bankOfAmericaCreditCards = new BankOfAmericaCreditCards();
        bankOfAmericaCreditCards.clickCash_Rewards_Cards();
        String actualText = "Bank of America® Cash Rewards";
        String expectedText = bankOfAmericaCreditCards.Expected_Cash.getText();

        Assert.assertEquals(actualText, expectedText, "TITLE DOES NOT MATCH");


    }

    @Test
    public void test_Travel_And_Airline_Rewards_Cards() {
        bankOfAmericaCreditCards = new BankOfAmericaCreditCards();
        bankOfAmericaCreditCards.hoverTravel_And_Airline_Rewards_Cards();

        String actualText = "Bank of America® Travel Rewards";
        String expecetedText = bankOfAmericaCreditCards.Expected_Travel.getText();

        Assert.assertEquals(actualText, expecetedText, "TITLES DO NOT MATCH");

    }

    @Test
    public void test_Lower_Interest_Rate_Cards() {
        bankOfAmericaCreditCards = new BankOfAmericaCreditCards();
        bankOfAmericaCreditCards.clickLower_Interest_Rate_Cards();


    }
}
