package tests;

import framework.FW;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import onliner.pages.Pages;
import onliner.verifications.Verifications;
import org.testng.annotations.Test;

public class OnlinerTests extends BaseTest {

    @Test
    @Description("First Test - 'Mobile phones'")
    @Epic("Onliner")
    public void Case1() {

        //Step 1
        Pages.headerNavigation.GoToCatalog();
        Verifications.TabTitleIsEqual("Каталог Onliner");
        FW.Log().Info("step1 is finished");

        //Step 2
        Pages.catalog.GoToElectronics();
        Pages.catalog.GoToMobilePhonesAccessories();
        Pages.catalog.GoToMobilePhones();
        Verifications.TabTitleContains("Мобильный телефон");
        Verifications.PageTitleIsEqual(Pages.catalog, "Мобильные телефоны");
        FW.Log().Info("step2 is finished");

        //Step 3
        Pages.catalog.OpenProducerList();
        Pages.catalog.ChooseProducer("HONOR");
        Verifications.VerifySearchResultPhonesContain("HONOR");
        FW.Log().Info("step3 is finished");

        //Step 4
        Pages.catalog.OpenSortingDropdown();
        Pages.catalog.ChooseSortingCriteria("Дорогие");
        FW.Log().Info("step4 is finished");
    }

    @Test
    public void Case2() {

        //Step 1
        Pages.headerNavigation.GoToLoginForm();
        Pages.loginPage.GoToRegistrationForm();
        Verifications.RegistrationHeaderIsEqual("Регистрация");
        FW.Log().Info("step1 is finished");

        //Step 2
        Pages.registrationPage.FillInEmailField();
        Verifications.VerifyEmailWarningPopupAppeared("Некорректный e-mail");
        FW.Log().Info("step2 is finished");

        //Step 3
        Pages.registrationPage.FillInPassField();
        Verifications.VerifyPassWarningPopup("Минимум 8 символов");
        FW.Log().Info("step3 is finished");

        //Step 4
        Pages.registrationPage.FillInRepeatPassField();
        Verifications.VerifyRepeatPassWarningPopup("Пароли не совпадают");
        FW.Log().Info("step4 is finished");
    }

    @Test
    public void Case3() {

        //Step 1
        Pages.headerNavigation.GoToCatalog();
        Verifications.TabTitleIsEqual("Каталог Onliner");
        FW.Log().Info("step1 is finished");

        //Step 2
        Pages.catalog.GoToElectronics();
        Pages.catalog.GoToVideoGames();
        Pages.catalog.GoToConsoles();
        Verifications.PageTitleIsEqual(Pages.catalog, "Игровые приставки");
        FW.Log().Info("step2 is finished");

        //Step 3
        Pages.catalog.OpenFirstElementOfSearchResult();
        Verifications.EnsureBasketTitleIs("В корзину");
        Pages.productPage.AddIntoBasket();
        Verifications.EnsureBasketTitleIs("В корзине");
        FW.Log().Info("step3 is finished");

        //Step 4
        Pages.productPage.GoToBasket();
        Verifications.BasketIsNotEmpty();
        FW.Log().Info("step4 is finished");
    }

    @Test
    public void Case4() {

        //Step1
        Pages.headerNavigation.GoToServices();
        Verifications.TabTitleIsEqual("Заказы на услуги");
        FW.Log().Info("step1 is finished");

        //Step2
        Pages.servicesPage.CheckUnfulfilledTasks();
        Verifications.VerifyOrdersStatusIs("Не выполнен");
        FW.Log().Info("step2 is finished");

        //Step3
        Verifications.NumberOfOrdersMoreThanOne();
        FW.Log().Info("step3 is finished");

        //Step4
        Verifications.WetherAllOrdersContainPicture();
        FW.Log().Info("step4 is finished");
    }

    @Test
    public void Case5() {

        //Step1
        Pages.headerNavigation.GoToForum();
        Verifications.TabTitleIsEqual("Форум onliner.by - Главная страница");
        FW.Log().Info("step1 is finished");

        //Step2
        Pages.forumPage.GoToNewFor24Hours();
        Verifications.ForumHeaderIsEqual("Новое за 24 часа");
        FW.Log().Info("step2 is finished");

        //Step3
        Verifications.NumberOfForumTopicsMoreThanZero();
        FW.Log().Info("step3 is finished");

        //Step4
        Pages.forumPage.GoToLastForumTopicsPage();
        Verifications.EnsureForumTopicPublicationTimeLess24();
        FW.Log().Info("step4 is finished");
    }
}
