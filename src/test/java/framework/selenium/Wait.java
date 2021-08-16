package framework.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class Wait {
    private WebDriverWait wait;

    public Wait(long waitSeconds) {
        this.wait = new WebDriverWait(Driver.Current(), waitSeconds);
    }

    public Wait(long waitSeconds, long pollingEvery) {
        this.wait = new WebDriverWait(Driver.Current(), waitSeconds, pollingEvery);
    }

    public WebElement Until(Function<WebDriver, WebElement> condition) {
        return wait.until(condition);
    }

    public void Until(ExpectedCondition<Boolean> booleanExpectedCondition) {
        wait.until(booleanExpectedCondition);
    }

    public void Sleep(int sec) {
        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
