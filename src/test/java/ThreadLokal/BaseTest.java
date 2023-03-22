package ThreadLokal;

import Utils.ThreatDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
   protected static ThreadLocal<WebDriver>  driver=new ThreadLocal<>();

    @BeforeMethod
    public void setup(){
        //System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Desktop\\Drivers\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver.set(ThreatDriver.getDriver());
    }

    public WebDriver getDriver(){
        return driver.get();
    }

    @BeforeMethod
    public void tearDown() {
        getDriver().quit();
    }
}
