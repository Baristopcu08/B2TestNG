package gun07.xml2;

import Utils.Browsers;
import Utils.ThreatDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class Test_2_xml {
    WebDriver driver;

    @BeforeTest
    @Parameters( {"browser" , "Usarname", "Password"})
    public void beforetest( String Chrome, @Optional String Usarname, @Optional String Password) {
        driver= ThreatDriver.getDriver(Browsers.valueOf(Chrome));

    }

    @BeforeClass
    public void beforeclass() {
    }

    @Test()
    public void test1(){
        System.out.println("Test1");
    }

    @Test()
    public void test2(){
        System.out.println("Test2");
    }

    @Test()
    public void test3(){
        System.out.println("Test3");
    }

    @Test()
    public void test4(){
        System.out.println("Test4");
    }

}
