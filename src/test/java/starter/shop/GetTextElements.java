package starter.shop;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;

public class GetTextElements {

    public static Question<String> storeTitle(){
        return actor -> TextContent.of(ProductsPageObjects.SHOP_TITLE).viewedBy(actor).asString();
    }

}
