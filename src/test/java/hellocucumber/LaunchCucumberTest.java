package hellocucumber;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import model.User;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/", monochrome = true)
public class LaunchCucumberTest {
    public static final String APPLICATION_JSON_UTF8_VALUE = "ISO-8859-1";
    private static final Logger log = LoggerFactory.getLogger(LaunchCucumberTest.class);
    private static WireMockServer wireMockServer;

    @BeforeClass
    public static void initWireMockServer() throws JsonProcessingException {
        log.info("Start Init Wire Mock Server ");

        wireMockServer = new WireMockServer();
        wireMockServer.start();

         ObjectMapper mapper = new ObjectMapper();
         List<User> users = new ArrayList<User>();
         User us1 = new User("FACE", "inactive");
         User us2 = new User("EC", "active");
         users.add(us1);
         users.add(us2);

        // get user with active status
        String usersString = mapper.writeValueAsString(users);
        wireMockServer.stubFor(get(urlEqualTo("/getAll")).willReturn(aResponse().withStatus(HttpStatus.OK.value())
                .withHeader("Content-Type", APPLICATION_JSON_UTF8_VALUE).withBody(usersString)));
    }

    @AfterClass
    public static void stopWireMockServer() {
        log.info("Start Stopping Wire Server ");
        wireMockServer.stop();
        log.info("End Stopping Wire Server ");
    }

}
