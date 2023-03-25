package gun10.demoblaze;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

public class Test1 {
    WebDriver driver;
    @BeforeTest
    public void bTest(){
        //DriverConfig.headles = true;
        DriverConfig.startmaximized = true;
        driver = DriverDemo.getDriver();
    }
}
