package gun03_DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataProvider_1 {


    @Test(dataProvider = "myData")
    public void test1(int num) {
        System.out.println(num);
    }


    @DataProvider
    public Object[][] myData(){

        return new Object[][]
          {
                {1},
                {2},
                {3}
          };
    }


    @Test(dataProvider = "getUsers")
    public void getUsers(String usarname, String password) {
        System.out.println(usarname+","+password);
    }

    @DataProvider
    public Object[][] getUsers(){

        return new Object[][]
                {
                        {"Admin", "admin124"},
                        {"Admin", "admin124"},
                        {"Admin", "admin124"},

                };
    }

}
