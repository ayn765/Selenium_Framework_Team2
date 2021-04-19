package bmwperformancedriving;

import common.BaseAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class BmwPerformanceDrivingTest extends BaseAPI {
    BmwPerformanceDrivingPage bmwPerformanceDrivingPage;

    @Test(enabled = false)
    public void testValidatePerformancePageTitle() throws IOException {
        bmwPerformanceDrivingPage=new BmwPerformanceDrivingPage();
        bmwPerformanceDrivingPage.navigateToPerformance();
        String actualPageTitle=getCurrentPageTitle();
        String path=System.getProperty("user.dir")+"/src/test/resources/performanceTitle.xlsx";
        String[] titleINExcelSheet=dataReader.fileReaderStringXSSF(path,"performanceTitle");
        String expectedTitle=titleINExcelSheet[0];
        Assert.assertEquals(actualPageTitle,expectedTitle);
    }
    @Test(enabled = false)
    public void testChooseDateForDriving(){
        bmwPerformanceDrivingPage=new BmwPerformanceDrivingPage();
        bmwPerformanceDrivingPage.selectDateForDriving();
    }
    @Test(enabled = false)
    public void testShareVideo(){
        bmwPerformanceDrivingPage=new BmwPerformanceDrivingPage();
        bmwPerformanceDrivingPage.shareVideo();
    }
 @Test
    public void testInstructorInfo(){
     bmwPerformanceDrivingPage=new BmwPerformanceDrivingPage();
     bmwPerformanceDrivingPage.selectInstructor();
 }
 }

