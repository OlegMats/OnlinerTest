package tests;

import framework.FW;
import onliner.pages.Pages;
import onliner.verifications.Verifications;
import org.testng.annotations.Test;

public class OnlinerTests extends BaseTest {

    @Test
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
        Verifications.WebElementsContain(Pages.catalog.Map.ResultPhones(1), "HONOR");
        FW.Log().Info("step3 is finished");

        //Step 4
        Pages.catalog.OpenSortingDropdown();
        Pages.catalog.ChooseSortingCriteria("Дорогие");
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
        Verifications.WebElementTextIsEqual(Pages.productPage.Map.AddToBasketBasketButton(), "В корзину");
        Pages.productPage.AddIntoBasket();
        Verifications.WebElementTextIsEqual(Pages.productPage.Map.AddToBasketBasketButton(), "В корзине");
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
        Verifications.WebElementsContain(Pages.servicesPage.Map.ResultServiceStatuses(), "Не выполнен");

        //Step3
        Verifications.NumberOfOrdersMoreThanOne();

        //Step4
        Verifications.WetherAllOrdersContainPicture();
    }
}
