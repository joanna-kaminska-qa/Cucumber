package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import models.User;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserPostStepsPojo {

    // Tworzymy listę, w której będziemy trzymać odpowiedzi z serwera dla każdego użytkownika
    private List<Response> responses = new ArrayList<>();

    @When("I create the following users:")
    public void iCreateTheFollowingUsers(List<User> usersList) {
        responses.clear(); // Czyścimy listę przed nowym testem

        for (User user : usersList) {
            Response response = given()
                    .spec(Hooks.requestSpec)
                    .body(user)
                    .when()
                    .post("/users");

            responses.add(response); // Zamiast sprawdzać tutaj, dodajemy do listy
            System.out.println("Sent user: " + user.getName());
        }
    }

    @Then("they should be successfully processed")
    public void theyShouldBeSuccessfullyProcessed() {
        // Teraz w jednym miejscu sprawdzamy wszystkie odpowiedzi
        for (Response resp : responses) {
            assertThat("Błąd przy tworzeniu użytkownika! Status nie jest 201",
                    resp.getStatusCode(), is(201)); // assertThat(komunikat, wartość_rzeczywista, warunek); komunikat: To jest tekst, który pojawi się w konsoli tylko wtedy, gdy test nie przejdzie.
        }
        System.out.println("All " + responses.size() + " users processed successfully!");
    }
}