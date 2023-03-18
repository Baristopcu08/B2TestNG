package gun03_DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataProvider {

    // Test methodunun dataprovider'i
    // ya @DataProvider'in name'i ile ya da @DataProvider'in method ismi ile cagrilir
    @Test(dataProvider = "myData")
    public void test1(int num){     //dataProvider'dan gelen degisken türü ve
                                    // sayisi methoda parametre olarak girilir
        System.out.println(num);

    }


    // Dataprovider --> test methodlari icin data kaynagidir, @DataProvider annotation'u ile belirtilir
    // 2 boyutlu Object return etmek zorundadir. return Object[][]
    @DataProvider(name = "myData")
    public Object[][] getData(){
        return new Object[][]
                {
                        {1},
                        {2},
                        {3}
                };
    }


    @Test(dataProvider = "getUsers")
    public void test2(String username, String password, boolean pass){

        if (pass)
            System.out.println(username + ", " + password + " --- PASS");
        else
            System.out.println(username + ", " + password + " --- FAIL");

    }

    @DataProvider
    public Object[][] getUsers(){
        return new Object[][]
                {
                        {"Admin", "admin124", false},
                        {"Admin1", "admin12412", false},
                        {"Admin2", "admin124234", false},
                        {"Admin", "admin123", true},
                };
    }

}
