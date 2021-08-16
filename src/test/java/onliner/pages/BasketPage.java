package onliner.pages;

import framework.selenium.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasketPage extends HeaderNavigationThroughPages {
    public BasketPageMap Map;

    public BasketPage() {
        Map = new BasketPageMap();
    }

    public class BasketPageMap {
        public WebElement BasketContent() {
            return Driver.FindElement(By.xpath("//div[contains(text(),'Корзина')]/following-sibling::div"));
        }
    }
}
