package framework.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {
    public static WebDriver Build(String browserName) {
        switch (browserName.toLowerCase()) {
            case ("chrome"):
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--incognito");
                return new ChromeDriver(chromeOptions);
            case ("firefox"):
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("-private");
                return new FirefoxDriver();
            default:
                throw new InvalidArgumentException(String.format("%s is not supported", browserName));
        }
    }
}
