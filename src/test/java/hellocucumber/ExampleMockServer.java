package hellocucumber;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

import org.junit.runner.RunWith;
import org.springframework.http.HttpStatus;
import userJava.User;

import java.util.ArrayList;
import java.util.List;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/", monochrome = true)
public class ExampleMockServer {
    public static final String APPLICATION_JSON_UTF8_VALUE = "ISO-8859-1";
    private static final Logger log = LoggerFactory.getLogger(ExampleMockServer.class);

    private static WireMockServer wireMockServer;
    @BeforeClass
    public static void initWireMockServer() throws JsonProcessingException {
        log.info("Start Init Wire Mock Server ");
        wireMockServer = new WireMockServer();
        wireMockServer.start();
        ObjectMapper mapper = new ObjectMapper();

        User us1 = new User();
        us1.setActive("active");

        User us2 = new User();
        us2.setActive("inactive");

        // get user with active status
        String usersString = mapper.writeValueAsString(us1);
        wireMockServer.stubFor(get(urlEqualTo("/getUsers/user1")).willReturn(aResponse().withStatus(HttpStatus.OK.value())
                .withHeader("Content-Type", APPLICATION_JSON_UTF8_VALUE).withBody(usersString)));

        log.info("End Init Wire Mock Server ");

    }

    @AfterClass
    public static void stopWireMockServer() {
        log.info("Start Stopping Wire Server ");
        wireMockServer.stop();
        log.info("End Stopping Wire Server ");
    }
}
