package configScroll;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TestConfig {

    WebDriver driver;
    @Test
    public void test1(){

        ConfigClass.dimension = "700x600";

        driver = DriverConf.getDriver();
    }
}
