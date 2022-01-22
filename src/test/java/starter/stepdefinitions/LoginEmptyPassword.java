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

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class LoginEmptyPassword {

    String name;
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^(.*) has not an active password")
    public void has_not_an_active_password(String name) {this.name = name;}

    @When("he dit not send their password")
    public void he_dit_not_send_their_password() {
        theActorCalled(name).attemptsTo(
                NavigateTo.theSauceDemoGoHomePage(),
                DoLogin.withCredentials( "standard_user", "")
        );
    }
    @Then("he should to be visible alert Password is requiered")
    public void he_should_to_be_visible_alert_password_is_requiered() {
        theActorInTheSpotlight().should(
                seeThat("The message Text", GetTextElements.textAlerts(), equalTo("Epic sadface: Password is required"))
        );
    }




}
