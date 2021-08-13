package framework.selenium;

import framework.FW;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class Wait {
    private WebDriverWait wait;
    public FluentWait fluentWait;

    public Wait(long waitSeconds) {
        this.wait = new WebDriverWait(Driver.Current(), waitSeconds);
        this.fluentWait = new FluentWait<WebDriver>(Driver.Current())
                .withTimeout(Duration.ofSeconds(waitSeconds))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
    }

    public Wait(long waitSeconds, long pollingEvery) {
        this.wait = new WebDriverWait(Driver.Current(), waitSeconds);
        this.fluentWait = new FluentWait<WebDriver>(Driver.Current())
                .withTimeout(Duration.ofSeconds(waitSeconds))
                .pollingEvery(Duration.ofMillis(pollingEvery))
                .ignoring(NoSuchElementException.class);
    }

    public WebElement Until(Function<WebDriver, WebElement> condition) {
        return wait.until(condition);
    }

    public void UntilTrue(ExpectedCondition<Boolean> condition) {
        this.UntilTrue(condition, null);
    }

    public void UntilTrue(ExpectedCondition<Boolean> condition, String message) {
       if (!wait.until(condition))
           FW.Log().Error(message);
    }

    public void Sleep(int sec) {
        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
