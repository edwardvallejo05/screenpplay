package starter.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import starter.login.DoLogin;
import starter.navigation.NavigateTo;
import starter.shop.AddProductCart;
import starter.shop.GetTextElements;
import starter.shop.PayPurchase;
import starter.shop.ProductsPageObjects;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class PayProductStandardUser {

    String name;
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^(.*) wants to buy a Product")
    public void wants_to_buy_a_product(String name) {this.name = name;}

    @When("add a product to the cart and pay for it")
    public void add_a_product_to_the_cart_and_pay_for_it() {
        theActorCalled(name).attemptsTo(
                NavigateTo.theSauceDemoGoHomePage(),
                DoLogin.withCredentials( "standard_user", "secret_sauce"),
                new AddProductCart(),
                PayPurchase.withData("Standard","User","123456")
        );
    }
    @Then("he should see the order confirmation")
    public void he_should_see_the_order_confirmation() {

        theActorCalled(name).attemptsTo(
                Ensure.that(ProductsPageObjects.YOUR_ORDER)
                        .isDisplayed()
        );

        theActorInTheSpotlight().should(
               seeThat("The message of Order is", GetTextElements.yourOrder(), equalTo("THANK YOU FOR YOUR ORDER"))
        );
    }

}
