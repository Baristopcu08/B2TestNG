package gun03_DataProvider;

import Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class TestDataProvider_2 {

    By lName=By.xpath("//input[@placeholder='Username']");
    By lPassword=By.xpath("//input[@placeholder='Password']");
    By lLoginSubmit=By.xpath("//button[@type='submit']");

    By lUserLink=By.xpath("//span[@class='oxd-userdropdown-tab']");
    By lLogout=By.xpath("(//a[text()='Logout'])[1]");

    By lInvalid=By.xpath("(//p[text()='Invalid credentials'])[1]");


WebDriver driver;
WebDriverWait wait;

  @BeforeSuite
  public void setup(){
      driver= Driver.getDriver();
      wait=new WebDriverWait(driver, Duration.ofMillis(10_000));
  }

  @Test
  public void gotoURL(){
      driver.get("https://opensource-demo.orangehrmlive.com/");
  }


    @Test(dataProvider = "getUsers",dependsOnMethods = "gotoURL")
    public void login(String usarname,String password,boolean boolen) {


        waitvisiblityof(lName);
        sendKeys(lName,usarname);
        sendKeys(lPassword,password);
        click(lLoginSubmit);
        if (boolen){
            click(lUserLink);
            click(lLogout);
        }else {
            wait.until(ExpectedConditions.visibilityOfElementLocated(lInvalid));
        }
    }


    @AfterSuite
    public void quit(){
      driver.quit();
    }



    @DataProvider
    public Object[][] getUsers(){

        return new Object[][]
                {
                        {"Admin", "admin124",false},
                        {"Admin", "admin124",false},
                        {"Admin", "admin124",false},
                        {"Admin", "admin123",true},
                        {"Admin", "admin124",false},
                        {"Admin", "admin124",false},

                };
    }

    protected void click(By locator) {

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    private void sendKeys(By locator,String text) {
        new Actions(driver).sendKeys(driver.findElement(locator), Keys.CLEAR);
        driver.findElement(locator).sendKeys(text);
    }

    private void waitvisiblityof(By locator){
      wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}
