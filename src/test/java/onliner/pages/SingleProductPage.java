package onliner.pages;

import framework.selenium.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SingleProductPage extends HeaderNavigationThroughPages {
    public SingleProductPageMap Map;

    public SingleProductPage() {
        Map = new SingleProductPageMap();
    }

    public void AddIntoBasket(){
        Map.AddToBasketBasketButton().click();
    }
    public void GoToBasket() {
        Map.BasketButton().click();
        Driver.wait.Sleep(1);
    }

    public class SingleProductPageMap {
        public WebElement AddToBasketBasketButton() {
            return Driver.FindElement(By.xpath("//div[contains(@class, 'product-aside__item--highlighted')]/descendant::a[contains(text(),'В корзин')]"));
        }
        public WebElement BasketButton(){
            return Driver.FindElement(By.xpath("//a[@title='Корзина']"));
        }
    }
}
