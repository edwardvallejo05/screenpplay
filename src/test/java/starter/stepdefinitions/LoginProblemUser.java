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
import starter.shop.DeleteProductCart;
import starter.shop.GetTextElements;
import starter.shop.ProductsPageObjects;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class LoginProblemUser {

    String name;
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^(.*) has an active with Problems")
    public void edward_has_an_active_with_problems(String name) {this.name = name;}

    @When("he logs in and adds a product to the shopping cart")
    public void he_logs_in_and_adds_a_product_to_the_shopping_cart() {
        theActorCalled(name).attemptsTo(
                NavigateTo.theSauceDemoGoHomePage(),
                DoLogin.withCredentials( "problem_user", "secret_sauce"),
                new AddProductCart()
        );
    }
    @Then("he could not remove the product")
    public void he_could_not_remove_the_product() {
        theActorCalled(name).attemptsTo(
                Ensure.that(ProductsPageObjects.BADGE)
                        .isNotDisplayed()
        );
    }





}
