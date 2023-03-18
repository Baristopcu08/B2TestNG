package gun05.Odev;

import static gun05.Odev.BaseTest.randomText;
import static gun05.Odev.BaseTest.randomText;
import static gun05.Odev.Locators.*;
import Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.time.Duration;


/*1.  https://opensource-demo.orangehrmlive.com/
2.  Login olunuz
3.  Admin linkine tiklayin
4.  Add butonu ile kullanici eklenecek
5.  Ismi cecil olani employee olarak secin
6.  Diger bilgileri doldurun
7.  kaydedin ve user kaydi yapildigindan emin olun.
8.  Kaydedilen kullaniciyi bulun ve edit edin
9.  Kullanici adi sonuna 1 ekleyin ve kaydedin.
10. yeni kullaniciyi aratin ve silin
11. kullanicinin silindiginden emin olun.
//label[text()='Username']/ancestor::div[starts-with(@class,'oxd-grid-item')]//input*/


public class Test_Class extends BaseTest{

    private   String USERNAME = randomText();
    private final String NEWUSERNAME = randomText();
    private final String PASWORD = "345764Na.";
    private final String URL ="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    WebDriver driver;
    WebDriverWait wait;

    @BeforeSuite
    public void setup(){
        driver= Driver.getDriver();
        wait=new WebDriverWait(driver,Duration.ofMillis(10_000));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        super.driver=driver;
        super.wait=wait;
    }

    @Test
    public void gotoURL() {
        driver.get(URL);
    }

    @Test(dependsOnMethods = "gotoURL")
    public void login() {

        sendKeys(lusarName,"Admin");
        sendKeys(lpassword,"admin123");
        click(lsubmit);
    }

    @Test(dependsOnMethods = "login")
    public void register() {

        click(llAdminButton);
        click(lAddButtun);
        click(lUserRole);
        click(lAdmin);
        click(lstatus);
        click(lEnabled);
        sendKeys(lUSarname,USERNAME);
        sendKeys(lpassword2,PASWORD);
        sendKeys(lpaswordConfirm,PASWORD);
        String searchEmploye="cecil";
        new Actions(driver).sendKeys(driver.findElement(lTypeForHint), "ceci").pause(3).build().perform();
        click(By.xpath("//div[@role='listbox']//span[text()='Cecil  Bonaparte']"));
        click(lSaveButton);
        wait_URL_Contains("viewSystemUsers");
        wait.until(ExpectedConditions.visibilityOfElementLocated(loutput));
        click(loutput); //
        click(llogout);
    }



    @Test(dependsOnMethods = "register")
    public void changeUSERNME() {

        gotoURL();
        sendKeys(lusarName,USERNAME);
        sendKeys(lpassword,PASWORD);
        click(lsubmit);
        click(llAdminButton);
        SerchUsarname(USERNAME);
        changeUsarname(USERNAME,NEWUSERNAME);
        USERNAME=NEWUSERNAME;
        SerchUsarname(NEWUSERNAME);

    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}