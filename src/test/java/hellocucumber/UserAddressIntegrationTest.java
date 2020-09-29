package hellocucumber;


import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class UserAddressIntegrationTest {

    @Steps
    private MyStepdefs usersSteps;

    @Test
    public void usersShouldStartWithActiveStatus() {
        try {
            usersSteps.a_subscriber_with_a_main_address_in_France("active");
            usersSteps.the_adviser_connected_to_changes_the_subscriber_s_address("EC");
            usersSteps.the_modified_subscriber_s_address_is_recorded_on_all_the_subscriber_s_contracts();
            usersSteps.an_address_modification_movement_is_created();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void usersShouldStartWithInactiveStatus() {
        try {
            usersSteps.a_subscriber_with_a_main_address_in_France("inactive");
            usersSteps.the_adviser_connected_to_changes_the_subscriber_s_address("FACE");
            usersSteps.the_modified_subscriber_s_address_is_recorded_on_all_the_subscriber_s_contracts();
            usersSteps.an_address_modification_movement_is_created();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}