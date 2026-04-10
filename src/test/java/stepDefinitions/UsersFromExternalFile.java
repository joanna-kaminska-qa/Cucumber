package stepDefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import models.User;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class UsersFromExternalFile {

    private List<Response> responses = new ArrayList<>();

    @When("I load users from {string} and create them")
    public void iLoadUsersFromFileAndCreateThem(String fileName) throws Exception {
        // 1. Inicjalizujemy ObjectMapper (narzędzie od Jacksona)
        ObjectMapper mapper = new ObjectMapper();

        // 2. Budujemy ścieżkę do pliku (szukamy go w folderze resources/data/)
        File jsonFile = Paths.get("src/test/resources/data/" + fileName).toFile();

        // 3. Jackson czyta plik i automatycznie tworzy tablicę obiektów User
        User[] usersArray = mapper.readValue(jsonFile, User[].class);

        // 4. Zamieniamy tablicę na listę, żeby pasowała do naszej poprzedniej metody
        List<User> usersList = Arrays.asList(usersArray);

        responses.clear();
        for (User user : usersList) {
            Response response = given()
                    .spec(Hooks.requestSpec)
                    .body(user)
                    .when()
                    .post("/users");

            responses.add(response);
            System.out.println("Sent user from file: " + user.getName());
        }
    }
}
