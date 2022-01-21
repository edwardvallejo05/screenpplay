package starter.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {
    public static Performable theSauceDemoGoHomePage() {
        return Task.where("{0} opens the SauceDemoGo home page",
                Open.browserOn().the(SauceDemoGoHomePage.class));
    }
}
