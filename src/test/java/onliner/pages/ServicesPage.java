package onliner.pages;

import framework.selenium.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ServicesPage extends HeaderNavigationThroughPages{
    public ServicesPageMap Map;

    public ServicesPage() {
        Map = new ServicesPageMap();
    }

    public void CheckUnfulfilledTasks(){
        Driver.JsClick(Map.UnfulfilledTasks());
        Driver.wait.Sleep(1);
    }

    public class ServicesPageMap {
        public WebElement SortingDropdown() {
            return Driver.FindElement(By.xpath("//div[contains(@class,'dropdown-style')]/child::a"));
        }
        public WebElement UnfulfilledTasks(){
            return Driver.FindElement(By.xpath("//span[contains(text(), 'Невыполненные')]/parent::span/preceding-sibling::input"));
        }
        public List<WebElement> ResultServiceStatuses(){
            return Driver.FindElements(By.xpath("//div[@class='service-offers__list']/descendant::div[contains(@class,'service-offers__status')]"));
        }
        public WebElement ResultDetails(){
            return Driver.FindElement(By.xpath("//span[contains(text(),'Найден')]"));
        }
        public List<WebElement> ServiceOfferPreviewPicture(){
            return Driver.FindElements(By.xpath("//div[@class='service-offers__list']/descendant::span[@class='service-offers__preview']/child::span"));
        }
    }
}
