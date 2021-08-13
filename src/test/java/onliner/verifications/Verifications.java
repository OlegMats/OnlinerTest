package onliner.verifications;

import framework.FW;
import framework.selenium.Driver;
import onliner.pages.HeaderNavigationThroughPages;
import onliner.pages.Pages;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Verifications {
    public static void TabTitleIsEqual(String title) {
        Assert.assertEquals(Driver.Title(), title, "Заголовок вкладки браузера не 'Каталог Onliner'");
    }

    public static void TabTitleContains(String title) {
        Assert.assertTrue(Driver.Title().contains(title), "Заголовок вкладки браузера не 'Мобильный телефон'");
    }

    public static void WebElementContains(WebElement element, String text) {
        Assert.assertTrue(element.getText().contains(text));
    }

    public static void WebElementsContain(List<WebElement> elements, String text) {
        for (WebElement element : elements)
            Assert.assertTrue(element.getText().contains(text), String.format("В одном из результатов поиска отсутствует - %s", text));
    }

    public static void WebElementTextIsEqual(WebElement element, String text) {
        Assert.assertEquals(element.getText(), text, String.format("Текстовая подпись элемента не %s", text));
    }

    public static void PageTitleIsEqual(HeaderNavigationThroughPages page, String pageTitle) {
        Assert.assertEquals(page.GetHeaderTitle(), pageTitle, String.format("Заголовок страницы(schema-header_title) не %s", pageTitle));
    }

    public static void BasketIsNotEmpty() {
        Assert.assertTrue(Pages.basketPage.Map.BasketContent().getText().contains("на сумму"), "Корзина пуста");
    }

    public static void NumberOfOrdersMoreThanOne() {
        Driver.wait.Sleep(2);
        Assert.assertFalse(Pages.servicesPage.Map.ResultDetails().getText().contains("Нет Заказов"), "Заказов не найдено");
    }

    public static void WetherAllOrdersContainPicture() {
        for (WebElement element : Pages.servicesPage.Map.ServiceOfferPreviewPicture()) {
            if (element.getAttribute("style").isEmpty()) {
                FW.Log().Info("Not All orders contain preview pictures");
                return;
            }
        }
        FW.Log().Info("All orders contain preview pictures");
    }

    public static void ForumHeaderIsEqual(String text) {
        String forumHeader = Pages.forumPage.Map.ForumHeaderWithNumberOfTopics().getText().split("\\n")[0];
        Assert.assertEquals(forumHeader, text, String.format("Заголовок форума не %s", text));
    }

    public static void NumberOfForumTopicsMoreThanZero() {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(Pages.forumPage.Map.ForumHeaderWithNumberOfTopics().getText().split("\\n")[1]);
        while (matcher.find())
            if (Integer.parseInt(matcher.group()) > 0)
                FW.Log().Info("Есть найденные темы на форуме за последнии 24 часа");
            else
                Assert.fail("Тем на форуме не было найдено");
    }

    public static void EnsureForumTopicPublicationTimeLess24() {
        Pattern pattern = Pattern.compile("\\d+");
        for (WebElement element : Pages.forumPage.Map.ForumTopicsPublicationTime()) {
            Matcher matcher = pattern.matcher(element.getText());
            while (matcher.find())
                Assert.assertFalse(Integer.parseInt(matcher.group()) > 24, "Найдена публикация старше 24 часов");
        }
    }

    public static void RegistrationHeaderIsEqual(String header) {
        Assert.assertEquals(Pages.registrationPage.Map.RegistrationFormHeader().getText(), header, "Заголовок не содержит слово 'Регистрация'");
    }

    public static void VerifyEmailWarningPopupAppeared(String message) {
        Driver.wait.Sleep(2);
        Assert.assertTrue(Pages.registrationPage.Map.EmailWarningPopup().getText().contains(message), "Отсутствует подсказка 'Некорректный e-mail'");
    }
    public static void VerifyPassWarningPopup(String message){
        Assert.assertTrue(Pages.registrationPage.Map.PassWarningPopup().getText().contains(message), "Отсутствует подсказка 'Минимум 8 символов'");
    }
    public static void VerifyRepeatPassWarningPopup(String message){
        Driver.wait.Sleep(1);
        Assert.assertTrue(Pages.registrationPage.Map.RepeatPassWarningPopup().getText().contains(message), "Отсутствует подсказка 'Пароли не совпадают'");
    }
}
