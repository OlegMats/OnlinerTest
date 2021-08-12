package onliner.pages;

public class Pages {
    public static CatalogPage catalog;
    public static HeaderNavigationThroughPages headerNavigation;
    public static SingleProductPage productPage;
    public static BasketPage basketPage;
    public static ServicesPage servicesPage;

    public static void Init(){
        catalog = new CatalogPage();
        headerNavigation = new HeaderNavigationThroughPages();
        productPage = new SingleProductPage();
        basketPage = new BasketPage();
        servicesPage = new ServicesPage();
    }
}
