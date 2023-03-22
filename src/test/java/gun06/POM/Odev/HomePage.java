package gun06.POM.Odev;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    static WebDriver driver;

    @FindBy(xpath = "//span[normalize-space()='My Account']")
    public WebElement MyAcauntButton;

    @FindBy(xpath = "(//a[contains(text(),'Login')])[1]")
    public WebElement loginButton;

    @FindBy(xpath = "//input[contains(@name,'email')]")
    public WebElement inputEmail;

    @FindBy(xpath = "//input[@placeholder='Password']")
    public WebElement inputPassWord;

    @FindBy(xpath = "(//a[contains(.,'Forgotten Password')])[1]")
    public WebElement forgotPasswordButton;



    String URL="http://opencart.abstracta.us/";

    public void login() {

        driver.get(URL);
        MyAcauntButton.click();
        loginButton.click();
        inputEmail.sendKeys("abc@gmail.com");
        inputPassWord.sendKeys("46566600");
        inputPassWord.submit();
        forgotPasswordButton.click();
        driver.quit();
    }
}
