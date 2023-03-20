package gun05.odev2;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static gun05.odev2.Elements.*;


public class TestOdev2 extends BaseOdev2 {
    String url = "https://opensource-demo.orangehrmlive.com/";
    String siteTitle = "OrangeHRM";
    String myUsername = "admin";
    String myPassword = "admin123";
    By erroMessages = By.cssSelector(".oxd-input-field-error-message");
    String newUsername;
    String newPassword;

    @Test
    public void gotoURL() {
        driver.get(url);
        wait.until(ExpectedConditions.titleIs(siteTitle));
    }

    @Test(dependsOnMethods = {"gotoURL"})
    public void testLogin(){
        INPUT.of("Username").sendkeys(myUsername);
        INPUT.of("Password").sendkeys(myPassword);
        BUTTON.of("Login").click();

    }

    @Test(dependsOnMethods = {"testLogin"}, priority = 1)
    public void addUser() {
        MENU_LINK.of("Admin").click();
        BUTTON.of("Add").click();
        DROPDOWN.of("User Role").click();
        DROPDOWN_OPTION.of("ESS").click();
        DROPDOWN.of("Status").click();
        DROPDOWN_OPTION.of("Enabled").click();

        INPUT.of( "Employee Name").sendkeys("cecil");
        DROPDOWN_OPTION.of("Cecil").click();

        newUsername = "Ahmet" + RandomStringUtils.randomAlphabetic(3);
        newPassword = "Aa123." + RandomStringUtils.randomAlphabetic(5);

        INPUT.of( "Username").sendkeys(newUsername);
        INPUT.of( "Password").sendkeys(newPassword);
        INPUT.of( "Confirm Password").sendkeys(newPassword);

        wait.until(ExpectedConditions.numberOfElementsToBe(erroMessages, 0));
        BUTTON.of("Save").click();
        notificationIsShownWithText("Successfull");
    }


    @Test(dependsOnMethods = {"addUser"}, priority = 2)
    public void updateUser() {
        MENU_LINK.of("Admin").click();
        INPUT.of("Username").sendkeys(newUsername);
        BUTTON.of("Search").click();
        TABLE_EDIT_BUTTON.of(newUsername).click();
        valueToBe(INPUT.of("Username").getXpath(), newUsername);
        newUsername+="1";
        INPUT.of("Username").sendkeys("1");
        sleep(1000);
        BUTTON.of("Save").click();
        notificationIsShownWithText("Successfull");
    }

    @Test(dependsOnMethods = {"addUser"}, priority = 3)
    public void deleteUser() {
        MENU_LINK.of("Admin").click();
        INPUT.of("Username").sendkeys(newUsername);
        BUTTON.of("Search").click();
        TABLE_DELETE_BUTTON.of(newUsername).click();
        BUTTON.of("No, Cancel").click();
        TABLE_DELETE_BUTTON.of(newUsername).click();
        BUTTON.of("Yes, Delete").click();
        notificationIsShownWithText("Successfull");
    }

}
