package onliner.pages;

import framework.selenium.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeaderNavigationThroughPages {
    public HeaderNavigationThroughPagesMap Map;

    public HeaderNavigationThroughPages() {
        Map = new HeaderNavigationThroughPagesMap();
    }

    public void GoToCatalog() {
        Map.CatalogLink().click();
    }

    public void GoToServices(){
        Map.ServicesLink().click();
    }

    public String GetHeaderTitle() {
        return Map.HeaderTitle().getAttribute("content");
    }

    public class HeaderNavigationThroughPagesMap {

        public WebElement CatalogLink() {
            return Driver.FindElement(By.xpath("//a[@href='https://catalog.onliner.by/']"));
        }

        public WebElement ServicesLink(){
            return Driver.FindElement(By.xpath("//a[@href='https://s.onliner.by/tasks'][contains(@class,'b-main')]"));
        }

        public WebElement HeaderTitle() {
            return Driver.FindElement(By.xpath("//meta[@property='og:title']"));
        }
    }
}


