package homepage;

import common.BaseAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChaseHomepageTest extends BaseAPI {
    ChaseHomepage chaseHomepage;




    @Test(enabled = false)
    public void testOpenAccount(){
        chaseHomepage=new ChaseHomepage();
        chaseHomepage.openAccoutChase();
    }
    @Test(enabled = false)
    public void testGetTextFirstRow(){
        chaseHomepage=new ChaseHomepage();
        chaseHomepage.checkFirstRow();
        String actualRowText=getTextFromElement(chaseHomepage.firstRow);
        Assert.assertEquals(actualRowText,"Monthly Service Fee for Chase Savings(Service Mark)\n" +
                "$5 or $0\n" +
                "Waive fees\n" +
                "Opens overlay\n" +
                "Opens Overlay\n" +
                "Monthly Service Fee for Chase Premier Savings(Service Mark)\n" +
                "$25 or $0\n" +
                "Waive fees");
    }
    @Test(enabled = false)
    public void testLinksCustomerService(){
        chaseHomepage=new ChaseHomepage();
        int actualNumberLinks=chaseHomepage.numLinksInCustomerServiceDrop();
        Assert.assertEquals(actualNumberLinks,"6");
    }
@Test
    public void testValidateNumOfImages(){
    chaseHomepage=new ChaseHomepage();
    chaseHomepage.sideMenu();
    int actualNumImages=chaseHomepage.numOfImageInThePage();
    Assert.assertEquals(actualNumImages,"9");
}
}
