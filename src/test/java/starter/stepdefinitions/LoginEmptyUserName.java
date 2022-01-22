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

public class LoginEmptyUserName {

    String name;
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^(.*) has not valid credentials")
    public void has_not_valid_credentials(String name) {this.name = name;}

    @When("he dit not send their user name")
    public void he_dit_not_send_their_user_name() {
        theActorCalled(name).attemptsTo(
                NavigateTo.theSauceDemoGoHomePage(),
                DoLogin.withCredentials( "", "secret_sauce")
        );
    }
    @Then("he should to be visible alert Username is requiered")
    public void he_should_to_be_visible_alert_username_is_requiered() {
        theActorInTheSpotlight().should(
                seeThat("The message Text", GetTextElements.textAlerts(), equalTo("Epic sadface: Username is required"))
        );
    }


}
