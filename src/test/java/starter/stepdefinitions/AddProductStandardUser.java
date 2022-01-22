package starter.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import starter.login.DoLogin;
import starter.navigation.NavigateTo;
import starter.shop.AddProductCart;
import starter.shop.GetTextElements;
import starter.shop.ProductsPageObjects;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class AddProductStandardUser {

    String name;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^(.*) has an active session")
    public void has_an_active_session(String name) {
        this.name = name;
    }

    @When("Add a Product to Cart")
    public void add_a_product_to_cart() {
        theActorCalled(name).attemptsTo(
                NavigateTo.theSauceDemoGoHomePage(),
                DoLogin.withCredentials("standard_user", "secret_sauce"),
                new AddProductCart(),
                Click.on(ProductsPageObjects.SHOPPING_CART)
        );
    }

    @Then("he should see the product in the shopping Cart")
    public void he_should_see_the_product_in_the_shopping_cart() {


        theActorInTheSpotlight().should(
                seeThat("Product Name on Shopping Cart", GetTextElements.fleeceJacket(), equalTo("Sauce Labs Fleece Jacket"))
        );

        theActorCalled(name).attemptsTo(
                Ensure.that(ProductsPageObjects.FLEECE_JACKET)
                        .isDisplayed(),
                Ensure.that(ProductsPageObjects.BUTTON_CHECKOUT)
                        .isDisplayed()
        );
    }


}
