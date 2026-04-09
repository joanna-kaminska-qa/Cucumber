package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import models.User;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class UserDetailsSteps {
    private Response response; // To jest nasza nowa "pamięć" na odpowiedź API
    private List<User> users;
    private User targetUser;

    @Given("the API is available")
    public void theUserApiIsAvailable() {
        // Na razie puste, bo Hooks zajmują się konfiguracją
    }

    @When("I ask for details of user {string}")
    public void iAskForDetailsForUser(String name) {
        // Zapamiętujemy całą odpowiedź w zmiennej 'response'
        response = io.restassured.RestAssured.given()
                .spec(Hooks.requestSpec)
                .when()
                .get("/users");

        // Wyciągamy listę użytkowników z zapamiętanej odpowiedzi
        users = response.then().extract().jsonPath().getList("", User.class);

        targetUser = users.stream()
                .filter(u -> u.getName().equals(name))
                .findFirst()
                .orElseThrow();
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int code) {
        assertThat(
                response.getStatusCode(),
                is(code));
    }

    @Then("the user should live in {string}")
    public void theUserCityShouldBe(String expectedCity) {
        String actualCity = targetUser.getAddress().getCity();
        assertThat(actualCity, equalTo(expectedCity));
    }

    @Then("the user email should be {string}")
    public void theUserEmailShouldBe(String expectedEmail) {
        assertThat(targetUser.getEmail(), is(expectedEmail));
    }
}