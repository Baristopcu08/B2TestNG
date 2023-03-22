package gun06.POM.Odev2;

import Utils.ThreatDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {


    @FindBy(xpath = "//input[@name='password']")
    public WebElement inputPassword;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement inputUsarname;

    @FindBy(xpath = "//p[normalize-space()='Invalid credentials']")
    public WebElement erorLoginText;

    String URL="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    WebDriver driver;
    WebDriverWait wait;

    public HomePage() {
        this.driver = ThreatDriver.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }


    public void login() {
        driver.get(URL);
        inputUsarname.sendKeys("Admin");
        inputPassword.sendKeys("admin123");
        inputPassword.submit();
        wait.until(ExpectedConditions.invisibilityOf(erorLoginText));
        wait.until(ExpectedConditions.urlContains("index"));




    }
}
