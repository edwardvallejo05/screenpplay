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

public class LoginUserlocked {

    String name;
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }


    @Given("^(.*) has an locked account")
    public void has_an_locked_account(String name) {this.name = name;}

    @When("he sends their blocked account")
    public void he_sends_their_blocked_account() {
        theActorCalled(name).attemptsTo(
                NavigateTo.theSauceDemoGoHomePage(),
                DoLogin.withCredentials( "locked_out_user", "secret_sauce")
        );
    }

    @Then("he should to be visible alert user has been locked")
    public void he_should_to_be_visible_alert_user_has_been_locked() {
        theActorInTheSpotlight().should(
                seeThat("The message Text", GetTextElements.textAlerts(), equalTo("Epic sadface: Sorry, this user has been locked out."))
        );
    }




}
