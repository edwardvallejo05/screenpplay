package starter.shop;

import org.openqa.selenium.By;

public class ProductsPageObjects {
    public static By SHOP_TITLE = By.className("title");
    public static By BUTTON_ADD_BACKPACK = By.id("add-to-cart-sauce-labs-fleece-jacket");
    public static By BUTTON_REMOVE_BACKPACK = By.id("remove-sauce-labs-fleece-jacket");
    public static By BADGE = By.className("shopping_cart_badge");
    public static By SHOPPING_CART = By.className("shopping_cart_link");
    public static By FLEECE_JACKET = By.className("inventory_item_name");
    public static By BUTTON_CHECKOUT = By.id("checkout");
    public static By FIRSTNAME_FIELD = By.id("first-name");
    public static By LASTNAME_FIELD = By.id("last-name");
    public static By ZIPCODE_FIELD = By.id("postal-code");
    public static By CONTINUE_BUTTON = By.id("continue");

    public static By FINISH_BUTTON = By.id("finish");

    public static By YOUR_ORDER = By.className("complete-header");
}

