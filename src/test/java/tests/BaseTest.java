package tests;

import framework.FW;
import framework.selenium.Driver;
import onliner.pages.Pages;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public abstract class BaseTest {
    @BeforeSuite
    public void BeforeAll() throws IOException {
        FW.SetConfig();
        FW.CreateTestDirectory();
    }

    @BeforeMethod
    public void TestMethodName(Method method) throws IOException {
        FW.SetLogger(method.getName());
        Driver.Init();
        Pages.Init();
        Driver.Goto(FW.Config().test.url);
        FW.Log().Info(String.format("Test name is: %s", method.getName()));
    }

    @AfterMethod
    public void AfterMethod(ITestResult result, Method method){
        switch(result.getStatus()){
            case(ITestResult.SUCCESS):
                FW.Log().Info("Test has been successfully passed");
                break;
            case(ITestResult.FAILURE):
                Driver.TakeScreenshot(method.getName());
                FW.Log().Info("Test has been failed");
                break;
            case(ITestResult.SKIP):
                FW.Log().Info("Test has been skipped");
                break;
            default:
                FW.Log().Warning("Something went wrong. Try to debug this test.");
        }
        if (Driver.Current() != null) {
            Driver.Quit();
        }
        FW.Log().CloseStream();
    }
}
