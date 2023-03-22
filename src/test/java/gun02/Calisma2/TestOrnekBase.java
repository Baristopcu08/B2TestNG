package gun02.Calisma2;

import Utils.ThreatDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class TestOrnekBase{

    WebDriver driver;
    WebDriverWait wait;

    @BeforeSuite
    public void setup() {
        driver= ThreatDriver.getDriver();
        wait=new WebDriverWait(driver, Duration.ofMillis(10_000));
    }

    @BeforeClass
    public void open(){
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    protected void click(By locator) {

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();

    }
}
