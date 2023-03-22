package gun08T;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class TestParalel extends TestParalelBase {


    @Test
    public void test1() {
        hp.gotoURL(hp.URL);

    }
    @Test(dependsOnMethods = "test1")
    public void test2() {
        hp.login();

    }
     @Test(dependsOnMethods = "test2")
    public void test3() {
        hp.logout();

    }
}
