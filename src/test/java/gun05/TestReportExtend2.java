package gun05;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestReportExtend2 {

    /*       ONCE DEPENDENCY EKLİYORUZ
             <dependency>
                <groupId>com.aventstack</groupId>
                <artifactId>extentreports</artifactId>
                <version>5.0.9</version>
            </dependency>
    */
    ExtentSparkReporter html;
    ExtentReports extentReport;
    ExtentTest test1;


    @BeforeTest
    public void setup() {
        html = new ExtentSparkReporter("_test-output/ExtentReport.html");
        extentReport = new ExtentReports();
        extentReport.attachReporter(html);
        test1 = extentReport.createTest("Test adi", "Testin ne yaptığının açıklaması");
    }

    @AfterTest
    public void tearDownd() {
        //extentReport.setSystemInfo("Tester", "Baris");
        //extentReport.setSystemInfo("OS", System.getProperty("os.name"));
        //extentReport.setSystemInfo("Project Dir", System.getProperty("user.dir"));
        //extentReport.flush();
         //dosyası kapatır
    }

    @Test
    public void test3() {
        test1.info("Test3 başladi");
        Assert.assertEquals(1, 1);
        test1.pass("Passed");

    }

    @Test()
    public void test1() {
        test1.info("Test1 başladi");
        Assert.assertEquals(1, 1);
        test1.fail("Test1 failed");
    }

    @Test
    public void test2() {
        test1.info("test2 baladi");
        Assert.assertEquals(1, 1);
        test1.pass("Test3 passed");
    }
}
