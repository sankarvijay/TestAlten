package hellocucumber;
import cucumber.api.CucumberOptions;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import userJava.User;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

class IsItActive {
    static String isItActive(String active) {
        return "inactive";
    }
}

@RunWith(Cucumber.class)
@CucumberOptions(glue = {"hellocucumber"})
public class MyStepdefs {
    private String active;
    private String canal;

    User user = new User();

    @Given("^a subscriber with a main address \"([^\"]*)\" in France$")
    public void a_subscriber_with_a_main_address_in_France(String arg1) throws Exception {
        user.setActive(arg1);
        active = IsItActive.isItActive(arg1);

    }

    @When("^the adviser connected to \"([^\"]*)\" changes the subscriber's address$")
    public void the_adviser_connected_to_changes_the_subscriber_s_address(String arg1) throws Exception {
        user.setCanal(arg1);
    }

    @Then("^the modified subscriber's address is recorded on all the subscriber's contracts$")
    public void the_modified_subscriber_s_address_is_recorded_on_all_the_subscriber_s_contracts() throws Exception {
        assertThat(user.getResult(), is(user.getActive()));
    }

    @Then("^an address modification movement is created$")
    public void an_address_modification_movement_is_created() throws Exception {
        assertThat(user.getResult(), is(user.getActive()));
    }
}
