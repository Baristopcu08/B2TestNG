package gun06.POM;
import A_TemelSiniflar.Element;
import Utils.ThreatDriver;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import java.time.Duration;

import static A_TemelSiniflar.Element.*;
import static A_TemelSiniflar.Locators.*;

public class HomePage {

    WebDriver driver;

    @AfterSuite
    public void setup(){
        driver= ThreatDriver.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Element.Element_driver(driver);
    }


    @Test
    public void testName() {

        $(xpath(ALL_DIV,"nav pull-right")).findElementforSecond("//span[normalize-space()='My Account']").click();


    }
}
