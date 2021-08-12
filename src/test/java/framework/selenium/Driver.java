package framework.selenium;

import framework.FW;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Driver {
    public static WebDriver driver;
    public static Wait wait;

    public static void Init() {
        FW.Log().Info(String.format("Browser is %s", FW.Config().driver.browser));
        driver = DriverFactory.Build(FW.Config().driver.browser);
        driver.manage().window().maximize();
        wait = new Wait(10);
    }

    public static WebDriver Current(){
        if(driver != null)
            return driver;
        throw new NullPointerException("driver is null");
    }

    public static void Goto(String url){
        Current().get(url);
    }

    public static void Quit(){
        Current().quit();
    }

    public static WebElement FindElement(By by){
        return Current().findElement(by);
    }

    public static List<WebElement> FindElements(By by){
        return Current().findElements(by);
    }

    public static void JsClick(WebElement element){
        JavascriptExecutor jse = (JavascriptExecutor) Current();
        jse.executeScript("arguments[0].click();", element);
    }

    public static String Title(){
        return Current().getTitle();
    }

    public static void TakeScreenshot(String methodName){
        DateTimeFormatter myDateTimeFormat = DateTimeFormatter.ofPattern("dd_MM_yy_hh_mm_ss");
        String dateTime = LocalDateTime.now().format(myDateTimeFormat);
        TakesScreenshot scr = ((TakesScreenshot)Current());
        File scrFile = scr.getScreenshotAs(OutputType.FILE);
        File destination = new File(System.getProperty("user.dir") + String.format("\\TestResults\\%s\\", methodName) + methodName + "_" + dateTime + ".png");
        try {
            FileUtils.copyFile(scrFile, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}