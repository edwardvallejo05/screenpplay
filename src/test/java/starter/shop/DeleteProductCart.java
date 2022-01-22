package starter.shop;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;


public class DeleteProductCart implements Task{

    @Override
    public <T extends Actor> void performAs (T actor) {
        actor.attemptsTo(
                Click.on(ProductsPageObjects.BUTTON_REMOVE_BACKPACK)
        );
    }




}
