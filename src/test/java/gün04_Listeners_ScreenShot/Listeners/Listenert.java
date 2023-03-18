package gün04_Listeners_ScreenShot.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class Listenert implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Başladı");

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Başarılı"+", "+result.getName()+", "+result.getStatus());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Başarısız"+", "+result.getName()+", "+result.getStatus());

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("PAs Geçildi"+", "+result.getName()+", "+result.getStatus());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Başladı"+", "+context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }
}
