package onliner.verifications;

import framework.FW;
import framework.selenium.Driver;
import onliner.pages.HeaderNavigationThroughPages;
import onliner.pages.Pages;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Collections;
import java.util.List;

public class Verifications {
    public static void TabTitleIsEqual(String title) {
        Assert.assertEquals(Driver.Title(), title);
    }

    public static void TabTitleContains(String title) {
        Assert.assertTrue(Driver.Title().contains(title));
    }

    public static void WebElementContains(WebElement element, String text) {
        Assert.assertTrue(element.getText().contains(text));
    }

    public static void WebElementsContain(List<WebElement> elements, String text) {
        for (WebElement element : elements)
            Assert.assertTrue(element.getText().contains(text));
    }

    public static void WebElementTextIsEqual(WebElement element, String text) {
        Assert.assertEquals(element.getText(), text);
    }

    public static void PageTitleIsEqual(HeaderNavigationThroughPages page, String pageTitle) {
        Assert.assertEquals(page.GetHeaderTitle(), pageTitle);
    }

    public static void BasketIsNotEmpty() {
        Assert.assertTrue(Pages.basketPage.Map.BasketContent().getText().contains("на сумму"));
    }

    public static void NumberOfOrdersMoreThanOne() {
        Driver.wait.Sleep(2);
        Assert.assertFalse(Pages.servicesPage.Map.ResultDetails().getText().contains("Нет Заказов"));
    }
    public static void WetherAllOrdersContainPicture(){
        for(WebElement element : Pages.servicesPage.Map.ServiceOfferPreviewPicture()){
            if (element.getAttribute("style").isEmpty()){
                FW.Log().Info("Not All orders contain preview pictures");
                return;
            }
        }
        FW.Log().Info("All orders contain preview pictures");
    }
}
