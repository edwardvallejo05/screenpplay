package starter.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import starter.login.DoLogin;
import starter.navigation.NavigateTo;
import starter.shop.GetTextElements;
import starter.shop.Store;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class LoginStepDefinitions {

    String name;
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^(.*) has an active account")
    public void has_an_active_account(String name) {this.name = name;}

    @When("he sends their valid credentials")
    public void he_sends_their_valid_credentials() {
       theActorCalled(name).attemptsTo(
            NavigateTo.theSauceDemoGoHomePage(),
            DoLogin.withCredentials( "standard_user", "secret_sauce")
       );
    }

    @Then("he should have access to the store")
    public void he_should_have_access_to_the_store() {
        theActorInTheSpotlight().should(
                seeThat("Is Visible Title", GetTextElements.storeTitle(), equalTo("Products"))
        );
    }

}
