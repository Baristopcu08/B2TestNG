package gun08T;

import Utils.ThreatDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class TestParalelBase {

static protected WebDriver driver;
static protected WebDriverWait wait;

    HomePage hp;

    //@Parameters("browser")
    @BeforeTest
    public void beforeTest(){
        driver= ThreatDriver.getDriver();
        hp=new HomePage(driver);
        driver.manage().window().maximize();
        wait=new WebDriverWait(driver, Duration.ofMillis(10_000));

    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }

    public void click(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

}
