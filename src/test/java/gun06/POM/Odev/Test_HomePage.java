package gun06.POM.Odev;

import Utils.Browsers;
import Utils.ThreatDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import java.time.Duration;

public class Test_HomePage {

    public static WebDriver  driver;


    @Parameters("version")
    @BeforeTest
    public void setup(@Optional String browser) {
        driver = ThreatDriver.getDriver(Browsers.valueOf(browser.toUpperCase()));

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10_000));
        HomePage.driver=driver;
    }


    @Test
    public void login() {

        HomePage homePage= PageFactory.initElements(ThreatDriver.getDriver(),HomePage.class);
        homePage.login();

    }
}
