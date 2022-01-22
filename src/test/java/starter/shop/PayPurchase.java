package starter.shop;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PayPurchase implements Task{

    private final String firstName;
    private final String lastName;
    private final String zipcode;

    public PayPurchase(String firstName, String lastName, String zipcode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.zipcode = zipcode;
    }

    public static Performable withData(String firstName, String lastName, String zipcode){
        return instrumented(PayPurchase.class, firstName, lastName, zipcode);
    }


    @Override
    public <T extends Actor> void performAs (T actor) {
        actor.attemptsTo(
                Click.on(ProductsPageObjects.SHOPPING_CART),
                Click.on(ProductsPageObjects.BUTTON_CHECKOUT),
                Enter.theValue(firstName).into(ProductsPageObjects.FIRSTNAME_FIELD),
                Enter.theValue(lastName).into(ProductsPageObjects.LASTNAME_FIELD),
                Enter.theValue(zipcode).into(ProductsPageObjects.ZIPCODE_FIELD),
                Click.on(ProductsPageObjects.CONTINUE_BUTTON),
                Click.on(ProductsPageObjects.FINISH_BUTTON)
        );
    }




}
