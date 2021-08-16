package onliner.pages;

import framework.selenium.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.*;

public class CatalogPage extends HeaderNavigationThroughPages {
    public CatalogPageMap Map;

    public CatalogPage() {
        Map = new CatalogPageMap();
    }

    public void GoToElectronics() {
        Map.Electronics().click();
    }

    public void GoToMobilePhonesAccessories() {
        Map.MobilePhonesAccessories().click();
    }

    public void GoToVideoGames() {
        Driver.wait.Until(ExpectedConditions.visibilityOf(Map.VideoGames()));
        Map.VideoGames().click();
    }

    public void GoToMobilePhones() {
        Map.MobilePhones().click();
    }

    public void GoToConsoles() {
        Driver.wait.Until(ExpectedConditions.visibilityOf(Map.Consoles()));
        Map.Consoles().click();
    }

    public void OpenProducerList() {
        Driver.JsClick(Map.ProducerList());
    }

    public void ChooseProducer(String producer) {
        Map.Producer(producer).click();
    }

    public void OpenPagesDropdown() {
        Map.PagesDropdown().click();
    }

    public void ChosePageNumber(int number) {
        Map.PageNumberFromPagesDropdown(number).click();
    }

    public void OpenSortingDropdown() {
        Map.SortingDropdown().click();
    }

    public void ChooseSortingCriteria(String criteria) {
        Map.SortingCriteria(criteria).click();
    }

    public void OpenFirstElementOfSearchResult() {
        Map.FirstElementOfSearchResult().click();
    }

    public class CatalogPageMap {

        public WebElement Electronics() {
            return Driver.FindElement(By.xpath("//span[contains(text(),'Электроника')]"));
        }

        public WebElement MobilePhonesAccessories() {
            return Driver.FindElement(By.xpath("//div[contains(text(),'Мобильные телефоны')]"));
        }

        public WebElement MobilePhones() {
            return Driver.FindElement(By.xpath("//a[@href='https://catalog.onliner.by/mobile']"));
        }

        public WebElement ProducerList() {
            return Driver.FindElement(By.xpath("//span[contains(text(),'Производитель')]/parent::div/following-sibling::div/descendant::div[contains(text(),'Все')]"));
        }

        public WebElement Producer(String producer) {
            return Driver.FindElement(By.xpath(String.format("//span[contains(text(),'%s')]/preceding-sibling::span", producer)));
        }

        public List<WebElement> ResultPhones(int numberOfPages) {
            List<WebElement> result = new ArrayList();
            Driver.wait.Sleep(1);
            result.addAll(Driver.FindElements(By.xpath("//div[@class='schema-products'][@id='schema-products']/child::div[@class='schema-product__group']/descendant::div[@class='schema-product__title']")));
            for (int pageNumber = 2; pageNumber <= numberOfPages; pageNumber++) {
                OpenPagesDropdown();
                ChosePageNumber(pageNumber);
                Driver.wait.Sleep(1);
                result.addAll(Driver.FindElements(By.xpath("//div[@class='schema-products'][@id='schema-products']/child::div[@class='schema-product__group']/descendant::div[@class='schema-product__title']")));
            }
            return result;
        }

        public WebElement PagesDropdown() {
            return Driver.FindElement(By.xpath("//div[@id='schema-pagination']/descendant::div[@class='schema-pagination__dropdown']"));
        }

        public WebElement PageNumberFromPagesDropdown(int number) {
            return Driver.FindElement(By.xpath(String.format("//a[@class='schema-pagination__pages-link'][contains(text(),'%d')]", number)));
        }

        public WebElement ResultDetails() {
            return Driver.FindElement(By.xpath("//span[@class='schema-filter-button__sub schema-filter-button__sub_main']"));
        }

        public WebElement SortingDropdown() {
            return Driver.FindElement(By.xpath("//div[@class='schema-order']/child::a"));
        }

        public WebElement SortingCriteria(String criteria) {
            return Driver.FindElement(By.xpath(String.format("//span[contains(text(),'%s')]", criteria)));
        }

        public WebElement FirstElementOfSearchResult() {
            Driver.wait.Until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='schema-products'][@id='schema-products']/child::div[@class='schema-product__group']/descendant::div[@class='schema-product__title']/descendant::a")));
            return Driver.FindElement(By.xpath("//div[@class='schema-products'][@id='schema-products']/child::div[@class='schema-product__group']/descendant::div[@class='schema-product__title']/descendant::a"));
        }

        public WebElement VideoGames() {
            return Driver.FindElement(By.xpath("//div[contains(text(),'Видеоигры')]"));
        }

        public WebElement Consoles() {
            return Driver.FindElement(By.xpath("//a[@href='https://catalog.onliner.by/console']"));
        }
    }
}


