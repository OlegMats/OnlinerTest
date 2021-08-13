package onliner.pages;

import framework.selenium.Driver;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class RegistrationPage extends HeaderNavigationThroughPages{
    public RegistrationPageMap Map;

    public RegistrationPage() {
        Map = new RegistrationPageMap();
    }

    public void FillInEmailField() {
        Map.EmailField().sendKeys(RandomStringUtils.randomAlphabetic(10));
    }

    public void FillInPassField() {
        Map.PassField().sendKeys(String.format("%d", new Random().nextInt(10000000)));
    }
    public void FillInRepeatPassField(){
        Map.RepeatPassField().sendKeys(RandomStringUtils.randomAlphabetic(Map.PassField().getAttribute("value").length()));
    }

    public class RegistrationPageMap {
        public WebElement RegistrationFormHeader() {
            return Driver.FindElement(By.xpath("//div[contains(@class, 'auth-form__titl')]"));
        }

        public WebElement EmailField() {
            return Driver.FindElement(By.xpath("//input[@type='email']"));
        }

        public WebElement EmailWarningPopup() {
            return Driver.FindElement(By.xpath("//input[@type='email']/parent::div/following::div"));
        }

        public WebElement PassField() {
            return Driver.FindElement(By.xpath("//input[@type='password']"));
        }

        public WebElement PassWarningPopup() {
            return Driver.FindElement(By.xpath("//div[@class='auth-form__securebox-line']/following-sibling::div"));
        }
        public WebElement RepeatPassField(){
            return Driver.FindElement(By.xpath("(//input[@type='password'])[2]"));
        }
        public WebElement RepeatPassWarningPopup() {
            return Driver.FindElement(By.xpath("(//input[@type='password'])[2]/parent::div/parent::div/following::div"));
        }
    }
}
