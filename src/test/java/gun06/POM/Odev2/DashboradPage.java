package gun06.POM.Odev2;

import Utils.ThreatDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboradPage {
     WebDriver driver;
     WebDriverWait wait;

    @FindBy(xpath = "//span[text()='Admin']")
    public WebElement adminButton;

    @FindBy(xpath = "//button[normalize-space()='Add']")
    public WebElement addButton;

    @FindBy(xpath = "(//div[@class='oxd-select-text-input'])[1]")
    public WebElement userroleSelectButton;

    @FindBy(xpath = "//div[@role=\"listbox\"]//*[contains(text(),\"Admin\")]")
    public WebElement adminSection;

    @FindBy(xpath = "(//div[contains(@class,'oxd-select-text-input')])[2]")
    public WebElement statusSelectButton;

    @FindBy(xpath = "//div[@role=\"listbox\"]//*[contains(text(),\"Enabled\")]")
    public WebElement enabledSection;

    @FindBy(xpath = "//input[contains(@placeholder,'Type for hints...')]")
    public WebElement typeforhintsButton;

    @FindBy(xpath = "//div[@role=\"listbox\"]//*[contains(text(),\"Cecil\")]")
    public WebElement CecilSection;

    @FindBy(xpath = "//label[text()=\"Username\"]//ancestor::div[contains(@class,\"oxd-grid-item oxd-grid-item\")]//input")
    public WebElement inputUsername;

    @FindBy(xpath = "//label[text()=\"Password\"]//ancestor::div[contains(@class,\"oxd-grid-item oxd-grid-item\")]//input")
    public WebElement inputPassword;

    @FindBy(xpath = "//label[text()=\"Confirm Password\"]//ancestor::div[contains(@class,\"oxd-grid-item oxd-grid-item\")]//input")
    public WebElement inputConfirmPassword;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    public WebElement saveButton;


    public DashboradPage() {
        this.driver = ThreatDriver.getDriver();
        this.wait = new WebDriverWait(driver,Duration.ofMillis(10000));
        PageFactory.initElements(driver, this);
    }

    public void userAdd() {
        wait.until(ExpectedConditions.visibilityOf(adminButton));
        adminButton.click();
        addButton.click();
        userroleSelectButton.click();
        wait.until(ExpectedConditions.visibilityOf(adminButton));
        adminSection.click();
        statusSelectButton.click();
        wait.until(ExpectedConditions.visibilityOf(enabledSection)).click();
        typeforhintsButton.sendKeys("ce");
        wait.until(ExpectedConditions.visibilityOf(CecilSection)).click();
        inputUsername.sendKeys("Salih");
        inputPassword.sendKeys("345678Ba.");
        inputConfirmPassword.sendKeys("345678Ba.");
        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        saveButton.click();


        //wait.until(ExpectedConditions.visibilityOf(enablesSelect)).click();
    }
}
