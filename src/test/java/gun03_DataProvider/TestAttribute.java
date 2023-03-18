package gun03_DataProvider;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAttribute {

    //nvocationCount = 5 testi 5 defa tekrar eder;

    @Test(priority = -1,invocationCount = 5)
    public void test1() {
        int actualResult=sum(1,2,3,4,5,6,7,8,9,10);
        int expected=55;
        Assert.assertEquals(actualResult,expected);
    }




    public int sum(int... nums){
        int sum=0;
        for (int num : nums) {
            sum+=num;

        }
        return sum;
    }
}
