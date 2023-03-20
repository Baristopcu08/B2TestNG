package gun05.odev4;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utils.Driver;

import static gun05.odev4.Locators.*;
import static gun05.odev4.Element.*;

public class TestOdev4 {
    String url = "https://opensource-demo.orangehrmlive.com/";
    String newUsername;
    String newPassword;

    @Test
    public void gotoURL() {
        Driver.getDriver().manage().window().maximize();
        open(url);
    }

    @Test(dependsOnMethods = {"gotoURL"})
    public void testLogin() {
        $(xpath(INPUT, "Username")).sendKeys(myUsername);
        $(xpath(INPUT, "Password")).sendKeys(myPassword);
        $(xpath(BUTTON, "Login")).click();

    }

    @Test(dependsOnMethods = {"testLogin"}, priority = 1)
    public void addUser() {
        $(xpath(MENU_LINK, "Admin")).shouldBe(Conditions.clickable).click();
        $(xpath(BUTTON, "Add")).shouldBe(Conditions.visible).click();
        $(xpath(DROPDOWN, "User Role")).shouldBe(Conditions.clickable).click();
        $(xpath(DROPDOWN_OPTION, "ESS")).click();
        $(xpath(DROPDOWN, "Status")).click();
        $(xpath(DROPDOWN_OPTION, "Enabled")).click();

        $(xpath(INPUT, "Employee Name")).sendKeys("Lisa");
        $(xpath(DROPDOWN_OPTION, "Lisa")).shouldBe(Conditions.visible).click();


        newUsername = "Ahmet" + RandomStringUtils.randomAlphabetic(3);
        newPassword = "Aa123." + RandomStringUtils.randomAlphabetic(5);

        $(xpath(INPUT, "Username")).sendKeys(newUsername);
        $(xpath(INPUT, "Password")).sendKeys(newPassword);
        $(xpath(INPUT, "Confirm Password")).sendKeys(newPassword);

        $(xpath(BUTTON, "Save")).shouldBe(Conditions.clickable).click();
        $(xpath(NOTIFICATION, "Successfull")).shouldBe(Conditions.visible);
    }

    @Test(dependsOnMethods = {"addUser"}, priority = 2)
    public void updateUser() {
        $(xpath(MENU_LINK, "Admin")).click();
        $(xpath(INPUT, "Username")).sendKeys(newUsername);
        $(xpath(BUTTON, "Search")).click();
        $(xpath(TABLE_EDIT_BUTTON, newUsername)).click();
        newUsername+="1";
        $(xpath(INPUT, "Username")).sendKeys("1");
        sleep(1000);
        $(xpath(BUTTON, "Save")).click();
        $(xpath(NOTIFICATION, "Successfull")).shouldBe(Conditions.visible);
    }

    @Test(dependsOnMethods = {"addUser"}, priority = 3)
    public void deleteUser() {
        $(xpath(MENU_LINK, "Admin")).click();
        $(xpath(INPUT, "Username")).sendKeys(newUsername);
        $(xpath(BUTTON, "Search")).click();
        $(xpath(TABLE_DELETE_BUTTON, newUsername)).click();
        $(xpath(BUTTON, "No, Cancel")).click();
        $(xpath(TABLE_DELETE_BUTTON, newUsername)).click();
        $(xpath(BUTTON, "Yes, Delete")).click();
        $(xpath(NOTIFICATION, "Successfull")).shouldBe(Conditions.visible);
    }


}
