package starter.shop;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class StoreQuestions implements Question<String> {

    public static Question<String> value(){
        return new StoreQuestions();
    }

    @Override
    public String answeredBy (Actor actor){
        return BrowseTheWeb.as(actor).find(ProductsPageObjects.SHOP_TITLE).getText();
    }
}
