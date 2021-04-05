package careersPageTest;

import careersPage.AirbnbCareers;
import common.BaseAPI;
import org.testng.annotations.Test;

public class AirbnbCareersPageTest extends BaseAPI {

    @Test
    public void testCareersPage() {

        AirbnbCareers careers = new AirbnbCareers();

        careers.verifyTabsOpen();


    }








}
