package gun06.POM.Odev2;

import org.testng.annotations.Test;

public class Test_DashBorad {



    @Test
    public void addUser() {
        new HomePage().login();
        new DashboradPage().userAdd();


    }
}
