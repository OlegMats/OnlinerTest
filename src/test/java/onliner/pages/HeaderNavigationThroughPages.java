package onliner.pages;

import framework.selenium.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HeaderNavigationThroughPages {
    public HeaderNavigationThroughPagesMap Map;

    public HeaderNavigationThroughPages() {
        Map = new HeaderNavigationThroughPagesMap();
    }

    public void GoToCatalog() {
        Map.CatalogLink().click();
    }

    public void GoToServices() {
        Map.ServicesLink().click();
    }

    public void GoToForum() {
        Map.ForumLink().click();
    }

    public String GetHeaderTitle() {
        return Map.HeaderTitle().getAttribute("content");
    }

    public void GoToLoginForm() {
        Map.LoginButton().click();
    }


    public class HeaderNavigationThroughPagesMap {

        public WebElement CatalogLink() {
            return Driver.FindElement(By.xpath("//a[@href='https://catalog.onliner.by/']"));
        }

        public WebElement ServicesLink() {
            return Driver.FindElement(By.xpath("//a[@href='https://s.onliner.by/tasks'][contains(@class,'b-main')]"));
        }

        public WebElement ForumLink() {
            return Driver.FindElement(By.xpath("//a[@href='https://forum.onliner.by/']"));
        }

        public WebElement HeaderTitle() {
            return Driver.FindElement(By.xpath("//meta[@property='og:title']"));
        }

        public WebElement LoginButton() {
            return Driver.FindElement(By.xpath("//div[contains(@class,'auth-bar__item')][contains(text(),'Вход')]"));
        }

    }

}


