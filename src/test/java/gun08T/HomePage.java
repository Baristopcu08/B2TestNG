package gun08T;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    protected WebDriverWait wait;
    String URL="https://opencart.abstracta.us/index.php?route=account/login";

    @FindBy(xpath = "//span[contains(.,'My Account')]")
    public WebElement buttonMyAccount;

    @FindBy(xpath = "(//a[contains(.,'Login')])[1]")
    public WebElement buttonLogin;

    @FindBy(xpath = "//input[contains(@placeholder,'E-Mail Address')]")
    public WebElement inputUsername;

    @FindBy(xpath = "//input[contains(@placeholder,'Password')]")
    public WebElement inputPassword;

    @FindBy(xpath = "(//a[contains(.,'Logout')])[1]")
    public WebElement buttonLogout;


    public HomePage(WebDriver driver) {
       this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofMillis(10_000));
        PageFactory.initElements(driver,this);
    }

    public void click(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    public void sendkey(WebElement element,String value){
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(value);
    }

    public WebElement waitUntilVisible(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void gotoURL(String Url){
        driver.get(Url);
    }
    public void login(){

        click(buttonMyAccount);
        click(buttonLogin);
        sendkey(inputUsername,"baristopcu2008@gmail.com");
        sendkey(inputPassword,"46566600");
        inputPassword.submit();
    }
    public void logout(){
        click(buttonMyAccount);
        waitUntilVisible(buttonLogout).click();
        wait.until(ExpectedConditions.urlContains("logout"));

    }
}
