package ThreadLokal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Test extends BaseTest {


    @org.testng.annotations.Test
    public void test1() throws InterruptedException {
        getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        new WebDriverWait(getDriver(), Duration.ofMillis(10000))
                .until(ExpectedConditions.urlContains("login"));
        Thread.sleep(5000);
    }

}
