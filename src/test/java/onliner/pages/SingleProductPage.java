package onliner.pages;

import framework.selenium.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SingleProductPage extends HeaderNavigationThroughPages {
    public SingleProductPageMap Map;

    public SingleProductPage() {
        Map = new SingleProductPageMap();
    }

    public void AddIntoBasket() {
        Map.AddToBasketBasketButton().click();
    }

    public void GoToBasket() {
        Driver.wait.Sleep(1);
        Map.BasketButton().click();
    }

    public class SingleProductPageMap {
        public WebElement AddToBasketBasketButton() {
            Driver.wait.Until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'product-aside__item--highlighted')]/descendant::a[contains(text(),'В корзин')]")));
            return Driver.FindElement(By.xpath("//div[contains(@class, 'product-aside__item--highlighted')]/descendant::a[contains(text(),'В корзин')]"));
        }

        public WebElement BasketButton() {
            return Driver.FindElement(By.xpath("//a[@title='Корзина']"));
        }
    }
}
