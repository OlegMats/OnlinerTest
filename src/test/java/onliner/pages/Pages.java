package onliner.pages;

public class Pages {
    public static CatalogPage catalog;
    public static HeaderNavigationThroughPages headerNavigation;
    public static SingleProductPage productPage;
    public static BasketPage basketPage;
    public static ServicesPage servicesPage;
    public static ForumPage forumPage;
    public static LoginPage loginPage;
    public static RegistrationPage registrationPage;

    public static void Init(){
        catalog = new CatalogPage();
        headerNavigation = new HeaderNavigationThroughPages();
        productPage = new SingleProductPage();
        basketPage = new BasketPage();
        servicesPage = new ServicesPage();
        forumPage = new ForumPage();
        loginPage = new LoginPage();
        registrationPage = new RegistrationPage();
    }
}
