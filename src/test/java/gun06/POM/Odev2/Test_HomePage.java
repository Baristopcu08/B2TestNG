package gun06.POM.Odev2;

import org.testng.annotations.Test;

public class Test_HomePage {



    @Test
    public void login() {
      HomePage homePage1=new HomePage();
      homePage1.login();

    }
}
