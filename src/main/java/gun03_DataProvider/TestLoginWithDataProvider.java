package gun03_DataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import utils.Driver;

import java.time.Duration;

public class TestLoginWithDataProvider {

    WebDriver driver;
    WebDriverWait wait;

    String url = "https://opensource-demo.orangehrmlive.com/";
    By lUsername = By.cssSelector("input[name='username']");
    By lPassword = By.cssSelector("input[name='password']");
    By lSubmitButton = By.cssSelector("button[type='submit']");
    By lUserDropDown = By.cssSelector(".oxd-userdropdown");
    By lUserDropDownLogout = By.xpath("//a[text()='Logout']");
    By lFailNotification = By.xpath("//p[text()='Invalid credentials']");
    @Test
    public void testgotoUrl(){
        driver.get(url);
    }


    @Test(dataProvider = "getUsers", dependsOnMethods = "testgotoUrl")
    public void testLogin(String username, String password, boolean pass){

        sendKeys(lUsername, username);
        sendKeys(lPassword, password);
        click(lSubmitButton);
        if (pass){
            click(lUserDropDown);
            click(lUserDropDownLogout);
            waitForVisibility(lUsername);
        }else {
            waitForVisibility(lFailNotification);
        }

    }


    @DataProvider
    public Object[][] getUsers(){
        return new Object[][]
                {
                        {"Admin", "admin124", false},
                        {"Admin1", "admin12412", false},
                        {"Admin", "admin123", true},
                        {"Admin2", "admin124234", false}
                };
    }

    @BeforeSuite
    public void setup(){
            driver = Driver.getDriver();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterSuite
    public void tearDown(){
        Driver.quitDriver();
    }


    public void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();

    }

    public void sendKeys(By locator, String text){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }

    public void waitForVisibility(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


}
