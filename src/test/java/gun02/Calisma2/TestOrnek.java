package gun02.Calisma2;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class TestOrnek extends TestOrnekBase {
/*
BeforeSuite
            driver, wait set edin
        BeforeClass
            https://opensource-demo.orangehrmlive.com/  gidin

        Test 1
            login :
        Test 2
            Menüden admin'e tikla
            User Role -> Admin  secin
            Search edilecek
            Listelenen kullanicilarin tümünün User Rolü'nünü Admin oldugu assert edilecek


        AfterSuite
            TearDown
* */

By lName=By.xpath("//input[@placeholder='Username']");
By lPassword=By.xpath("//input[@placeholder='Password']");
By lLoginSubmit=By.xpath("//button[@type='submit']");

By lAdminLink=By.xpath("(//a[@class='oxd-main-menu-item'])[1]");
By lUserRole=By.xpath("(//div[contains(@class,\"oxd-select-text oxd-select\")])[1]");
By lAdminsection=By.xpath("//div[@role='option']//span[text()='Admin']");
By lSubmitButton=By.xpath("//button[@type='submit']");
By lRecordFounds=By.xpath("//div[@class='oxd-table-card']//div[3]/div");



    @BeforeMethod
    public void login() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lName));
        driver.findElement(lName).sendKeys("Admin");
        driver.findElement(lPassword).sendKeys("admin123");
        driver.findElement(lLoginSubmit).click();
    }

    @Test()
    public void roleControls() {
        click(lAdminLink);
        click(lUserRole);
        click(lAdminsection);
        click(lSubmitButton);
        driver.findElements(lRecordFounds).stream().forEach(i-> System.out.println(i.getText().equals("Admin")));
        System.out.println("--");

    }

}
