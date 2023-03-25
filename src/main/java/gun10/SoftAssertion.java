package gun10;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {

    SoftAssert softAssert = new SoftAssert();

    int i=0;

    @Test
    public void test1(){
        softAssert.assertEquals(1,1,"Message Test1");
    }

    @Test
    public void test2(){
        // assert sonucu alinir
        softAssert.assertEquals(1,2, "Message Test2");

        // assert sonucu ne olursa olsun calisma devam eder
        i++;
    }

    @Test
    public void test3(){
        softAssert.assertEquals(2,1, "Message Test3");
    }


    @Test(dependsOnMethods = "test3")
    public void test4(){
        softAssert.assertEquals(4,4, "Message Test4");
    }

    @Test
    public void test5(){
        // assert sonucu alinir
        softAssert.assertEquals(5,5, "Message Test5");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("int i : " + i);

        // Assertler isleme konur
        softAssert.assertAll();

    }
}
