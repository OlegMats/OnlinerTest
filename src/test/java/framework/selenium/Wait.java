package framework.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class Wait {
    private WebDriverWait wait;
    public FluentWait fluentWait;

    public Wait(long waitSeconds){
        this.wait = new WebDriverWait(Driver.Current(), waitSeconds);
        this.fluentWait = new FluentWait<WebDriver>(Driver.Current())
                .withTimeout(Duration.ofSeconds(waitSeconds))
                .ignoring(NoSuchElementException.class);
    }

    public Wait(long waitSeconds, long pollingInterval) {
        this.wait = new WebDriverWait(Driver.Current(), waitSeconds, pollingInterval);
        this.fluentWait = new FluentWait<WebDriver>(Driver.Current())
                .withTimeout(Duration.ofSeconds(waitSeconds))
                .pollingEvery(Duration.ofMillis(pollingInterval))
                .ignoring(NoSuchElementException.class);
    }

    public WebElement Until(Function<WebDriver, WebElement> condition){
        return wait.until(condition);
    }
    public void Sleep(int sec){
        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
