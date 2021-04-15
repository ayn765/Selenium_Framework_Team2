package homepageTest;

import common.BaseAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BankOfAmericaHomepageTest extends BaseAPI{


        // Test class
        BankOfAmericaHomepage.HomePage homePage;
        @BeforeMethod
        public void getInit(){
            homePage= PageFactory.initElements(driver, BankOfAmericaHomepage.HomePage.class);
        }
        // @Ignore
        @Test(priority = 1)
        public void TestCheckLogo(){
            homePage.checkLogo();
        }
        // @Ignore
        @Test(priority = 2)
        public void testCheckContinueToBank(){
            homePage.checkContinueToBank();
            assertEqualByXpath(thatsFitsYourNeedsLocator,"that fitslect your device");
        }


        // @Ignore
        @Test(priority = 3)
        public void testCheckContactUs() throws InterruptedException {
            homePage.checkContactUs();
            assertEqualByXpath(selectYourDeviceLocator,"Select your device");
        }

    // @Ignore
        @Test(priority = 4)
        public void testCheckChecking(){
            homePage.checkChecking();
            assertEqualByXpath(stayFlexibleWithBankOfTextLocator,"Stay flexible with Bank of\n" +
                    "America Advantage Banking");


        }
        // @Ignore
        @Test(priority = 5)
        public void testCheckSavings() throws InterruptedException {
            homePage.checkSavings();
            assertEqualByXpath(TakeTextLocator,"Take charge of your account, at home or on the go");
        }
        // @Ignore()
        @Test(priority = 6)
        public void testCheckNavigatingTheContinuing() throws
                InterruptedException {
            homePage.checkNavigatingTheContinuing();
            assertEqualByXpath(betterMoneyHabitsLocator,"");
        }
        // @Ignore()
        @Test(priority = 7)
        public void testCheckSeeDetails() throws InterruptedException {
            homePage.checkSeeDetails();
            assertEqualByXpath(clientInformationTextLocator,"client information");
        }
        // @Ignore()
        @Test(priority = 8)
        public void testCheckAutoLoans() throws InterruptedException {
            homePage.checkAutoLoans();
            assertEqualByXpath(getALowRateOnPurchaseTextLocator,"Get a low rate on purchase, refinance and lease buyout loans")
        // @Ignore()
        @Test(priority = 9)
        public void testCheckSmallBusiness() throws InterruptedException {
            homePage.checkSmallBusiness();
                assertEqualByXpath(businessCheckingTextLocator,"BUSINESS CHECKING / BIG ADVANTAGES");
        }
        // @Ignore()
        @Test(priority = 10)
        public void testCheckWealthManagement() throws InterruptedException {
            homePage.checkWealthManagement();
                assertEqualByXpath(wealthManagementTextLocator,"Wealth Management");
            }


            // @Ignore()
        @Test(priority = 11)
        public void testCheckBusinessesAndIns() throws InterruptedException {
            homePage.checkBusinessesAndIns();
                assertEqualByXpath(globalBankingAndMarketsLocator,"Global Banking & Markets");
        }

//    @Ignore()
            @Test(priority = 12)
            public void testCheckAboutUs() throws InterruptedException {
                homePage.checkAboutUs();
            }

//    @Ignore()
            @Test(priority = 13)
            public void testCheckWhoWeAre() throws InterruptedException {
                homePage.checkAboutUs();
                assertEqualByXpath(drivingResponsibleGrowthTextLocator,"Driving responsible growth");
            }

//    @Ignore()
            @Test(priority = 14)
            public void testCheckSecurity() throws InterruptedException {
                homePage.checkSecurity();
                assertEqualByXpath(privacyAndSecurityTextLocator,"Privacy & Security");
            }

//    @Ignore()
            @Test(priority = 15)
            public void testMoveToLeft() throws InterruptedException {
                homePage.moveToLeft();
                assertEqualByXpath(newScamAlertTextLocator,"New scam alert");
            }

//    @Ignore()
            @Test(priority = 16)
            public void testCheckHelp() throws InterruptedException {
                homePage.checkHelp();
                assertEqualByXpath(selectYourStateLocator,"Select Your State");
            }

//    @Ignore()
            @Test(priority = 17)
            public void checkCashBack() throws InterruptedException {
                clickByXpath(cachBackLocator);
                sleepFor(5);
            }

//    @Ignore()
            @Test(priority = 18)
            public void TestCheckCashBack() throws InterruptedException {
                homePage.checkCashBack();
                assertEqualByXpath(bankOfAmericaLocator,"Bank of America");
            }

//    @Ignore()
            @Test(priority = 19)
            public void checkRadioButton() throws InterruptedException {
                homePage.checkRadioButton();
                assertEqualByXpath(saveONTextLocator,"Save Online ID");
            }

//    @Ignore()
            @Test(priority = 20)
            public void testCheckScheduleApp() throws InterruptedException {
                homePage.checkScheduleApp();
                sleepFor(5);
            }

//    @Ignore()
            @Test(priority = 21)
            public void checkScheduleApp() throws InterruptedException {
                homePage.checkScheduleApp();
                assertEqualByXpath(scheduleAppointmentTextLocator, "Schedule An Appointment")
            }
        }
}