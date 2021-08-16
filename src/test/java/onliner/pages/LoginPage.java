package onliner.pages;

import framework.selenium.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends HeaderNavigationThroughPages {
    public LoginPageMap Map;

    public LoginPage() {
        Map = new LoginPageMap();
    }

    public void GoToRegistrationForm() {
        Map.OnlinerRegistration().click();
    }

    public class LoginPageMap {
        public WebElement OnlinerRegistration() {
            return Driver.FindElement(By.xpath("//a[contains(text(),'Зарегистрироваться')]"));
        }
    }
}
