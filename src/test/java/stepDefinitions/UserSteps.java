package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.User;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.equalTo;


public class UserSteps {
    private List<User> users;
    private User targetUser;

    @Given("the user API is available")
    public void theUserApiIsAvailable() {
    }

    @When("I request details for user {string}")
    public void iRequestDetailsForUser(String name) {
        users = given().spec(Hooks.requestSpec)
                .when().get("/users")
                .then().extract().jsonPath().getList("", User.class);

        targetUser = users.stream()
                .filter(u -> u.getName().equals(name))
                .findFirst()
                .orElseThrow();
    }

    @Then("the user latitude should be less than {double}")
    public void theUserLatitudeShouldBeLessThan(Double limit) {
        double lat = Double.parseDouble(targetUser.getAddress().getGeo().getLat());
        assertThat(lat, lessThan(limit));
    }

    @And("the user city should be {string}")
    public void theUserCityShouldBe(String city){
        String responseCity = targetUser.getAddress().getCity();
        assertThat(responseCity, equalTo(city));
    }
}