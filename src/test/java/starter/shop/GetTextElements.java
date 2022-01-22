package starter.shop;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;
import starter.login.LoginPageObjects;

public class GetTextElements {

    public static Question<String> storeTitle(){
        return actor -> TextContent.of(ProductsPageObjects.SHOP_TITLE).viewedBy(actor).asString();
    }

    public static Question<String> textAlerts(){
        return actor -> TextContent.of(LoginPageObjects.MESSAGE_ALERT).viewedBy(actor).asString();
    }

    public static Question<String> countBadge(){
        return actor -> TextContent.of(ProductsPageObjects.BADGE).viewedBy(actor).asString();
    }

    public static Question<String> fleeceJacket(){
        return actor -> TextContent.of(ProductsPageObjects.FLEECE_JACKET).viewedBy(actor).asString();
    }

    public static Question<String> yourOrder(){
        return actor -> TextContent.of(ProductsPageObjects.YOUR_ORDER).viewedBy(actor).asString();
    }

}
