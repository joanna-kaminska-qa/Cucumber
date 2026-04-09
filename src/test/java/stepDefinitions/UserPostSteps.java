package stepDefinitions;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class UserPostSteps {
    private Response response;

    @When("I send a POST request to {string} with body:")
    public void iSendAPostRequestWithBody(String endpoint, String jsonBody) {
        response = RestAssured.given()
                .spec(Hooks.requestSpec)
                .body(jsonBody)
                .when()
                .post(endpoint);
    }

    @Then("the creation status code should be {int}")
    public void theCreationStatusCodeShouldBe(int expectedCode) {
        assertThat(response.getStatusCode(), is(expectedCode));
    }

}