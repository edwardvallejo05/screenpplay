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

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class LoginEmptyCredentials {

    String name;
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^(.*) has not credentials")
    public void has_not_credentials(String name) {this.name = name;}

    @When("he dit not send their valid credentials")
    public void he_dit_not_send_their_valid_credentials() {
        theActorCalled(name).attemptsTo(
                NavigateTo.theSauceDemoGoHomePage(),
                DoLogin.withCredentials( "", "")
        );

    }
    @Then("he should have not access to the store")
    public void he_should_have_not_access_to_the_store() {
        theActorInTheSpotlight().should(
                seeThat("The message Text", GetTextElements.textAlerts(), equalTo("Epic sadface: Username is required"))
        );
    }


}
