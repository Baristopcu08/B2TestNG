package ThreadLokal;

import Utils.Browsers;
import Utils.ThreatDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.time.Duration;
public class BaseTest {

WebDriver driver;
WebDriverWait wait;

    ExtentSparkReporter html;   // raporu html olarak kaydetmek icin
    ExtentReports extentReport; // rapor olusturmak icin
    ExtentTest test1;           // Test - 1
    ExtentTest test2;           // Test - 2
    ExtentTest test3;           // Test - 3
    // test :   bir veya daha fazla method'dan ya da
    //          bir veya daha fazla class'dan olusabilir


    @BeforeTest
    @Parameters("browser")
    public void setup(@Optional String browser){
        driver=ThreatDriver.getDriver(Browsers.valueOf(browser.toUpperCase()));
        driver.manage().window().maximize();
        wait=new WebDriverWait(driver, Duration.ofMillis(10_000));
        html = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/report.html");
        extentReport = new ExtentReports();
        extentReport.attachReporter(html);
        test1 = extentReport.createTest("Test Suite 1", "Deneme-1 Testi");
        test2 = extentReport.createTest("Test Suite 2", "Deneme-2 Testi");
        test3 = extentReport.createTest("Test Suite 3", "Deneme-3 Testi");
    }

    @AfterTest
    public void tearDown() {
        extentReport.setSystemInfo("QA Team", "GuiderSoft QA");
        extentReport.setSystemInfo("Isletim Systemi", System.getProperty("os.name"));
        extentReport.setSystemInfo("Isletim Systemi V", System.getProperty("os.version"));
        extentReport.flush();
        ThreatDriver.quitDriver();

    }
}
