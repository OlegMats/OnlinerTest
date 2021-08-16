package onliner.pages;

import framework.selenium.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ForumPage extends HeaderNavigationThroughPages {
    public ForumPageMap Map;

    public ForumPage() {
        Map = new ForumPageMap();
    }

    public void GoToNewFor24Hours() {
        Map.NewFor24Hours().click();
    }

    public void GoToLastForumTopicsPage() {
        int length = Map.ForumPageNavigation().size();
        Map.ForumPageNavigation().get(length - 2).click();
    }

    public class ForumPageMap {
        public WebElement NewFor24Hours() {
            return Driver.FindElement(By.xpath("//span[contains(text(),'Новое за 24 часа')]"));
        }

        public WebElement ForumHeaderWithNumberOfTopics() {
            return Driver.FindElement(By.xpath("//h1[@class='m-title']"));
        }

        public List<WebElement> ForumPageNavigation() {
            return Driver.FindElements(By.xpath("(//ul[@class='pages-fastnav'])[1]/descendant::a"));
        }

        public List<WebElement> ForumTopicsPublicationTime() {
            return Driver.FindElements(By.xpath("//div[@class='b-lt-author']/child::a[@class='link-getlast']"));
        }
    }
}
